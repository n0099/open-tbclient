package com.baidu.tieba.recapp.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdDebugActivity extends BaseActivity<AdDebugActivity> implements View.OnClickListener {
    private LinearLayout dku;
    private TextView eNM;
    private List<AppData> gvH;
    private TextView mTitle;

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.ad_debug_copy) {
            a.bh(this.eNM.getText().toString());
            showToast("已复制到系统剪贴板");
            return;
        }
        int indexOfChild = this.dku.indexOfChild(view);
        if (indexOfChild >= 0 && indexOfChild < this.gvH.size()) {
            this.mTitle.setText("AD" + indexOfChild);
            a(this.gvH.get(indexOfChild));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.ad_debug_layout);
        this.mTitle = (TextView) findViewById(e.g.ad_debug_label_data);
        this.eNM = (TextView) findViewById(e.g.ad_debug_content);
        this.dku = (LinearLayout) findViewById(e.g.ad_debug_item_container);
        ((TextView) findViewById(e.g.ad_debug_copy)).setOnClickListener(this);
        this.eNM.setMovementMethod(new ScrollingMovementMethod());
        this.eNM.setText("没刷到广告~ 换个姿势试试！");
        this.gvH = r.bpV().bpT();
        bpY();
    }

    private void bpY() {
        if (this.gvH.size() == 0) {
            TextView bpZ = bpZ();
            bpZ.setOnClickListener(null);
            bpZ.setText("No AD");
            this.dku.addView(bpZ, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 != this.gvH.size()) {
                TextView bpZ2 = bpZ();
                bpZ2.setText("AD" + i2);
                AppData appData = this.gvH.get(i2);
                if (appData.mDiscardReason > 0) {
                    al.i(bpZ2, e.f.btn_all_red);
                } else {
                    al.i(bpZ2, e.f.btn_all_green);
                }
                if (i2 == 0) {
                    a(appData);
                    this.mTitle.setText("AD0");
                }
                this.dku.addView(bpZ2, new LinearLayout.LayoutParams(-1, -1, 1.0f));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private TextView bpZ() {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        al.h(textView, e.d.cp_other_f);
        textView.setOnClickListener(this);
        return textView;
    }

    private void a(AppData appData) {
        String str;
        if (appData == null) {
            this.eNM.setText("数据格式错误");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (appData.fillInJsonObject(jSONObject)) {
            try {
                String str2 = new String();
                if (appData.mDiscardReason > 0) {
                    String str3 = com.baidu.tieba.recapp.report.e.gBu.get(Integer.valueOf(appData.mDiscardReason));
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
                this.eNM.setText(str + jSONObject.toString(4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
