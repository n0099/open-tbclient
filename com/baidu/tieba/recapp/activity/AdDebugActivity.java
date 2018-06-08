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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdDebugActivity extends BaseActivity<AdDebugActivity> implements View.OnClickListener {
    private TextView eyS;
    private List<AppData> gjk;
    private LinearLayout gjn;
    private TextView mTitle;

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.ad_debug_copy) {
            a.aN(this.eyS.getText().toString());
            showToast("已复制到系统剪贴板");
            return;
        }
        int indexOfChild = this.gjn.indexOfChild(view);
        if (indexOfChild >= 0 && indexOfChild < this.gjk.size()) {
            this.mTitle.setText("AD" + indexOfChild);
            a(this.gjk.get(indexOfChild));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.ad_debug_layout);
        this.mTitle = (TextView) findViewById(d.g.ad_debug_label_data);
        this.eyS = (TextView) findViewById(d.g.ad_debug_content);
        this.gjn = (LinearLayout) findViewById(d.g.ad_debug_item_container);
        ((TextView) findViewById(d.g.ad_debug_copy)).setOnClickListener(this);
        this.eyS.setMovementMethod(new ScrollingMovementMethod());
        this.eyS.setText("没刷到广告~ 换个姿势试试！");
        this.gjk = r.boj().boh();
        bom();
    }

    private void bom() {
        if (this.gjk.size() == 0) {
            TextView bon = bon();
            bon.setOnClickListener(null);
            bon.setText("No AD");
            this.gjn.addView(bon, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 != this.gjk.size()) {
                TextView bon2 = bon();
                bon2.setText("AD" + i2);
                AppData appData = this.gjk.get(i2);
                if (appData.mDiscardReason > 0) {
                    al.i(bon2, d.f.btn_all_red);
                } else {
                    al.i(bon2, d.f.btn_all_green);
                }
                if (i2 == 0) {
                    a(appData);
                    this.mTitle.setText("AD0");
                }
                this.gjn.addView(bon2, new LinearLayout.LayoutParams(-1, -1, 1.0f));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private TextView bon() {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        al.h(textView, d.C0141d.cp_other_f);
        textView.setOnClickListener(this);
        return textView;
    }

    private void a(AppData appData) {
        String str;
        if (appData == null) {
            this.eyS.setText("数据格式错误");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (appData.fillInJsonObject(jSONObject)) {
            try {
                String str2 = new String();
                if (appData.mDiscardReason > 0) {
                    String str3 = com.baidu.tieba.recapp.report.d.goS.get(Integer.valueOf(appData.mDiscardReason));
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
                this.eyS.setText(str + jSONObject.toString(4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
