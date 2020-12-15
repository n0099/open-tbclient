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
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.report.f;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class AdDebugActivity extends BaseActivity<AdDebugActivity> implements View.OnClickListener {
    private LinearLayout ilC;
    private TextView kHJ;
    private List<AppData> mHF;
    private TextView mTitle;

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.ad_debug_copy) {
            a.copyToClipboard(this.kHJ.getText().toString());
            showToast("已复制到系统剪贴板");
            return;
        }
        int indexOfChild = this.ilC.indexOfChild(view);
        if (indexOfChild >= 0 && indexOfChild < this.mHF.size()) {
            this.mTitle.setText("AD" + indexOfChild);
            a(this.mHF.get(indexOfChild));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ad_debug_layout);
        this.mTitle = (TextView) findViewById(R.id.ad_debug_label_data);
        this.kHJ = (TextView) findViewById(R.id.ad_debug_content);
        this.ilC = (LinearLayout) findViewById(R.id.ad_debug_item_container);
        ((TextView) findViewById(R.id.ad_debug_copy)).setOnClickListener(this);
        this.kHJ.setMovementMethod(new ScrollingMovementMethod());
        this.kHJ.setText("没刷到广告~ 换个姿势试试！");
        this.mHF = r.dFg().dFe();
        buM();
    }

    private void buM() {
        if (this.mHF.size() == 0) {
            TextView dFj = dFj();
            dFj.setOnClickListener(null);
            dFj.setText("No AD");
            this.ilC.addView(dFj, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 != this.mHF.size()) {
                TextView dFj2 = dFj();
                dFj2.setText("AD" + i2);
                AppData appData = this.mHF.get(i2);
                if (appData.mDiscardReason > 0) {
                    ap.setBackgroundResource(dFj2, R.drawable.btn_all_red);
                } else {
                    ap.setBackgroundResource(dFj2, R.drawable.btn_all_green);
                }
                if (i2 == 0) {
                    a(appData);
                    this.mTitle.setText("AD0");
                }
                this.ilC.addView(dFj2, new LinearLayout.LayoutParams(-1, -1, 1.0f));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private TextView dFj() {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        ap.setViewTextColor(textView, R.color.CAM_X0312);
        textView.setOnClickListener(this);
        return textView;
    }

    private void a(AppData appData) {
        String str;
        if (appData == null) {
            this.kHJ.setText("数据格式错误");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (appData.fillInJsonObject(jSONObject)) {
            try {
                String str2 = new String();
                if (appData.mDiscardReason > 0) {
                    String str3 = f.mNB.get(Integer.valueOf(appData.mDiscardReason));
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
                this.kHJ.setText(str + jSONObject.toString(4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
