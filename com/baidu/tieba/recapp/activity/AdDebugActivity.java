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
    private LinearLayout dsy;
    private TextView eVu;
    private List<AppData> gDi;
    private TextView mTitle;

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.ad_debug_copy) {
            a.bg(this.eVu.getText().toString());
            showToast("已复制到系统剪贴板");
            return;
        }
        int indexOfChild = this.dsy.indexOfChild(view);
        if (indexOfChild >= 0 && indexOfChild < this.gDi.size()) {
            this.mTitle.setText("AD" + indexOfChild);
            a(this.gDi.get(indexOfChild));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.ad_debug_layout);
        this.mTitle = (TextView) findViewById(e.g.ad_debug_label_data);
        this.eVu = (TextView) findViewById(e.g.ad_debug_content);
        this.dsy = (LinearLayout) findViewById(e.g.ad_debug_item_container);
        ((TextView) findViewById(e.g.ad_debug_copy)).setOnClickListener(this);
        this.eVu.setMovementMethod(new ScrollingMovementMethod());
        this.eVu.setText("没刷到广告~ 换个姿势试试！");
        this.gDi = r.btk().bti();
        btn();
    }

    private void btn() {
        if (this.gDi.size() == 0) {
            TextView bto = bto();
            bto.setOnClickListener(null);
            bto.setText("No AD");
            this.dsy.addView(bto, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 != this.gDi.size()) {
                TextView bto2 = bto();
                bto2.setText("AD" + i2);
                AppData appData = this.gDi.get(i2);
                if (appData.mDiscardReason > 0) {
                    al.i(bto2, e.f.btn_all_red);
                } else {
                    al.i(bto2, e.f.btn_all_green);
                }
                if (i2 == 0) {
                    a(appData);
                    this.mTitle.setText("AD0");
                }
                this.dsy.addView(bto2, new LinearLayout.LayoutParams(-1, -1, 1.0f));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private TextView bto() {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        al.h(textView, e.d.cp_other_f);
        textView.setOnClickListener(this);
        return textView;
    }

    private void a(AppData appData) {
        String str;
        if (appData == null) {
            this.eVu.setText("数据格式错误");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (appData.fillInJsonObject(jSONObject)) {
            try {
                String str2 = new String();
                if (appData.mDiscardReason > 0) {
                    String str3 = com.baidu.tieba.recapp.report.e.gIT.get(Integer.valueOf(appData.mDiscardReason));
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
                this.eVu.setText(str + jSONObject.toString(4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
