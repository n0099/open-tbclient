package com.baidu.tieba.recapp.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdDebugActivity extends BaseActivity<AdDebugActivity> implements View.OnClickListener {
    private TextView emv;
    private List<AppData> fWP;
    private LinearLayout fWS;
    private TextView mTitle;

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == d.g.ad_debug_copy) {
            a.aB(this.emv.getText().toString());
            showToast("已复制到系统剪贴板");
            return;
        }
        int indexOfChild = this.fWS.indexOfChild(view2);
        if (indexOfChild >= 0 && indexOfChild < this.fWP.size()) {
            this.mTitle.setText("AD" + indexOfChild);
            a(this.fWP.get(indexOfChild));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.ad_debug_layout);
        this.mTitle = (TextView) findViewById(d.g.ad_debug_label_data);
        this.emv = (TextView) findViewById(d.g.ad_debug_content);
        this.fWS = (LinearLayout) findViewById(d.g.ad_debug_item_container);
        ((TextView) findViewById(d.g.ad_debug_copy)).setOnClickListener(this);
        this.emv.setMovementMethod(new ScrollingMovementMethod());
        this.emv.setText("没刷到广告~ 换个姿势试试！");
        this.fWP = r.bjl().bjj();
        bjo();
    }

    private void bjo() {
        if (this.fWP.size() == 0) {
            TextView bjp = bjp();
            bjp.setOnClickListener(null);
            bjp.setText("No AD");
            this.fWS.addView(bjp, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 != this.fWP.size()) {
                TextView bjp2 = bjp();
                bjp2.setText("AD" + i2);
                AppData appData = this.fWP.get(i2);
                if (appData.mDiscardReason > 0) {
                    ak.i(bjp2, d.f.btn_all_red);
                } else {
                    ak.i(bjp2, d.f.btn_all_green);
                }
                if (i2 == 0) {
                    a(appData);
                    this.mTitle.setText("AD0");
                }
                this.fWS.addView(bjp2, new LinearLayout.LayoutParams(-1, -1, 1.0f));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private TextView bjp() {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        ak.h(textView, d.C0126d.cp_other_f);
        textView.setOnClickListener(this);
        return textView;
    }

    private void a(AppData appData) {
        String str;
        if (appData == null) {
            this.emv.setText("数据格式错误");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (appData.fillInJsonObject(jSONObject)) {
            try {
                String str2 = new String();
                if (appData.mDiscardReason > 0) {
                    String str3 = com.baidu.tieba.recapp.report.d.gcw.get(Integer.valueOf(appData.mDiscardReason));
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
                this.emv.setText(str + jSONObject.toString(4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
