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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdDebugActivity extends BaseActivity<AdDebugActivity> implements View.OnClickListener {
    private LinearLayout dbM;
    private TextView eCH;
    private List<AppData> gnc;
    private TextView mTitle;

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.ad_debug_copy) {
            a.aP(this.eCH.getText().toString());
            showToast("已复制到系统剪贴板");
            return;
        }
        int indexOfChild = this.dbM.indexOfChild(view);
        if (indexOfChild >= 0 && indexOfChild < this.gnc.size()) {
            this.mTitle.setText("AD" + indexOfChild);
            a(this.gnc.get(indexOfChild));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.ad_debug_layout);
        this.mTitle = (TextView) findViewById(d.g.ad_debug_label_data);
        this.eCH = (TextView) findViewById(d.g.ad_debug_content);
        this.dbM = (LinearLayout) findViewById(d.g.ad_debug_item_container);
        ((TextView) findViewById(d.g.ad_debug_copy)).setOnClickListener(this);
        this.eCH.setMovementMethod(new ScrollingMovementMethod());
        this.eCH.setText("没刷到广告~ 换个姿势试试！");
        this.gnc = r.boJ().boH();
        boM();
    }

    private void boM() {
        if (this.gnc.size() == 0) {
            TextView boN = boN();
            boN.setOnClickListener(null);
            boN.setText("No AD");
            this.dbM.addView(boN, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 != this.gnc.size()) {
                TextView boN2 = boN();
                boN2.setText("AD" + i2);
                AppData appData = this.gnc.get(i2);
                if (appData.mDiscardReason > 0) {
                    am.i(boN2, d.f.btn_all_red);
                } else {
                    am.i(boN2, d.f.btn_all_green);
                }
                if (i2 == 0) {
                    a(appData);
                    this.mTitle.setText("AD0");
                }
                this.dbM.addView(boN2, new LinearLayout.LayoutParams(-1, -1, 1.0f));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private TextView boN() {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        am.h(textView, d.C0142d.cp_other_f);
        textView.setOnClickListener(this);
        return textView;
    }

    private void a(AppData appData) {
        String str;
        if (appData == null) {
            this.eCH.setText("数据格式错误");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (appData.fillInJsonObject(jSONObject)) {
            try {
                String str2 = new String();
                if (appData.mDiscardReason > 0) {
                    String str3 = com.baidu.tieba.recapp.report.d.gsK.get(Integer.valueOf(appData.mDiscardReason));
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
                this.eCH.setText(str + jSONObject.toString(4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
