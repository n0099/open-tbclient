package com.baidu.tieba.recapp.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.report.e;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdDebugActivity extends BaseActivity<AdDebugActivity> implements View.OnClickListener {
    private LinearLayout deC;
    private TextView eGw;
    private List<AppData> gop;
    private TextView mTitle;

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == f.g.ad_debug_copy) {
            a.aQ(this.eGw.getText().toString());
            showToast("已复制到系统剪贴板");
            return;
        }
        int indexOfChild = this.deC.indexOfChild(view);
        if (indexOfChild >= 0 && indexOfChild < this.gop.size()) {
            this.mTitle.setText("AD" + indexOfChild);
            a(this.gop.get(indexOfChild));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.ad_debug_layout);
        this.mTitle = (TextView) findViewById(f.g.ad_debug_label_data);
        this.eGw = (TextView) findViewById(f.g.ad_debug_content);
        this.deC = (LinearLayout) findViewById(f.g.ad_debug_item_container);
        ((TextView) findViewById(f.g.ad_debug_copy)).setOnClickListener(this);
        this.eGw.setMovementMethod(new ScrollingMovementMethod());
        this.eGw.setText("没刷到广告~ 换个姿势试试！");
        this.gop = r.bno().bnm();
        bnr();
    }

    private void bnr() {
        if (this.gop.size() == 0) {
            TextView bns = bns();
            bns.setOnClickListener(null);
            bns.setText("No AD");
            this.deC.addView(bns, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 != this.gop.size()) {
                TextView bns2 = bns();
                bns2.setText("AD" + i2);
                AppData appData = this.gop.get(i2);
                if (appData.mDiscardReason > 0) {
                    am.i(bns2, f.C0146f.btn_all_red);
                } else {
                    am.i(bns2, f.C0146f.btn_all_green);
                }
                if (i2 == 0) {
                    a(appData);
                    this.mTitle.setText("AD0");
                }
                this.deC.addView(bns2, new LinearLayout.LayoutParams(-1, -1, 1.0f));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private TextView bns() {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        am.h(textView, f.d.cp_other_f);
        textView.setOnClickListener(this);
        return textView;
    }

    private void a(AppData appData) {
        String str;
        if (appData == null) {
            this.eGw.setText("数据格式错误");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (appData.fillInJsonObject(jSONObject)) {
            try {
                String str2 = new String();
                if (appData.mDiscardReason > 0) {
                    String str3 = e.gua.get(Integer.valueOf(appData.mDiscardReason));
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "未知原因";
                    }
                    str = str2 + "\n抛弃原因 ： (" + appData.mDiscardReason + ")" + str3 + "\n\n";
                } else {
                    str = str2;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("goods");
                String optString = optJSONObject.optString("lego_card");
                if (!TextUtils.isEmpty(optString)) {
                    optJSONObject.put("lego_card", new JSONObject(optString));
                    jSONObject.put("goods", optJSONObject);
                }
                this.eGw.setText(str + jSONObject.toString(4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
