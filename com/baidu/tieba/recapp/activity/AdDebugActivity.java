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
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.report.e;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AdDebugActivity extends BaseActivity<AdDebugActivity> implements View.OnClickListener {
    private TextView hMb;
    private List<AppData> jFi;
    private LinearLayout jFl;
    private TextView mTitle;

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.ad_debug_copy) {
            a.copyToClipboard(this.hMb.getText().toString());
            showToast("已复制到系统剪贴板");
            return;
        }
        int indexOfChild = this.jFl.indexOfChild(view);
        if (indexOfChild >= 0 && indexOfChild < this.jFi.size()) {
            this.mTitle.setText("AD" + indexOfChild);
            a(this.jFi.get(indexOfChild));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ad_debug_layout);
        this.mTitle = (TextView) findViewById(R.id.ad_debug_label_data);
        this.hMb = (TextView) findViewById(R.id.ad_debug_content);
        this.jFl = (LinearLayout) findViewById(R.id.ad_debug_item_container);
        ((TextView) findViewById(R.id.ad_debug_copy)).setOnClickListener(this);
        this.hMb.setMovementMethod(new ScrollingMovementMethod());
        this.hMb.setText("没刷到广告~ 换个姿势试试！");
        this.jFi = r.cAX().cAV();
        aFa();
    }

    private void aFa() {
        if (this.jFi.size() == 0) {
            TextView cBa = cBa();
            cBa.setOnClickListener(null);
            cBa.setText("No AD");
            this.jFl.addView(cBa, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 != this.jFi.size()) {
                TextView cBa2 = cBa();
                cBa2.setText("AD" + i2);
                AppData appData = this.jFi.get(i2);
                if (appData.mDiscardReason > 0) {
                    am.setBackgroundResource(cBa2, R.drawable.btn_all_red);
                } else {
                    am.setBackgroundResource(cBa2, R.drawable.btn_all_green);
                }
                if (i2 == 0) {
                    a(appData);
                    this.mTitle.setText("AD0");
                }
                this.jFl.addView(cBa2, new LinearLayout.LayoutParams(-1, -1, 1.0f));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private TextView cBa() {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        am.setViewTextColor(textView, (int) R.color.cp_other_f);
        textView.setOnClickListener(this);
        return textView;
    }

    private void a(AppData appData) {
        String str;
        if (appData == null) {
            this.hMb.setText("数据格式错误");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (appData.fillInJsonObject(jSONObject)) {
            try {
                String str2 = new String();
                if (appData.mDiscardReason > 0) {
                    String str3 = e.jKU.get(Integer.valueOf(appData.mDiscardReason));
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
                this.hMb.setText(str + jSONObject.toString(4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
