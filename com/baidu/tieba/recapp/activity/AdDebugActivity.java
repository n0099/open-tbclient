package com.baidu.tieba.recapp.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AdDebugActivity extends BaseActivity<AdDebugActivity> implements View.OnClickListener {
    private LinearLayout iAX;
    private TextView kSG;
    private List<AppData> mTV;
    private TextView mTitle;

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.ad_debug_copy) {
            a.copyToClipboard(this.kSG.getText().toString());
            showToast("已复制到系统剪贴板");
            return;
        }
        int indexOfChild = this.iAX.indexOfChild(view);
        if (indexOfChild >= 0 && indexOfChild < this.mTV.size()) {
            this.mTitle.setText("AD" + indexOfChild);
            b(this.mTV.get(indexOfChild));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ad_debug_layout);
        this.mTitle = (TextView) findViewById(R.id.ad_debug_label_data);
        this.kSG = (TextView) findViewById(R.id.ad_debug_content);
        this.iAX = (LinearLayout) findViewById(R.id.ad_debug_item_container);
        ((TextView) findViewById(R.id.ad_debug_copy)).setOnClickListener(this);
        this.kSG.setMovementMethod(new ScrollingMovementMethod());
        this.kSG.setText("没刷到广告~ 换个姿势试试！");
        this.mTV = s.dDB().dDz();
        btL();
    }

    private void btL() {
        if (this.mTV.size() == 0) {
            TextView dDF = dDF();
            dDF.setOnClickListener(null);
            dDF.setText("No AD");
            this.iAX.addView(dDF, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 != this.mTV.size()) {
                TextView dDF2 = dDF();
                dDF2.setText("AD" + i2);
                AppData appData = this.mTV.get(i2);
                if (appData.mDiscardReason > 0) {
                    ap.setBackgroundResource(dDF2, R.drawable.btn_all_red);
                } else {
                    ap.setBackgroundResource(dDF2, R.drawable.btn_all_green);
                }
                if (i2 == 0) {
                    b(appData);
                    this.mTitle.setText("AD0");
                }
                this.iAX.addView(dDF2, new LinearLayout.LayoutParams(-1, -1, 1.0f));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private TextView dDF() {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        ap.setViewTextColor(textView, R.color.CAM_X0312);
        textView.setOnClickListener(this);
        return textView;
    }

    private void b(AppData appData) {
        String str;
        if (appData == null) {
            this.kSG.setText("数据格式错误");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (appData.fillInJsonObject(jSONObject)) {
            try {
                String str2 = new String();
                if (appData.mDiscardReason > 0) {
                    String str3 = g.nab.get(Integer.valueOf(appData.mDiscardReason));
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
                this.kSG.setText(str + jSONObject.toString(4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
