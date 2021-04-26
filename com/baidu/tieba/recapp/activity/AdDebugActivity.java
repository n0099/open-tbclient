package com.baidu.tieba.recapp.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.a.c.e.p.a;
import d.a.j0.s2.h0.g;
import d.a.j0.s2.w;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdDebugActivity extends BaseActivity<AdDebugActivity> implements View.OnClickListener {
    public static final String KEY_GOODS = "goods";
    public static final String KEY_LEGO = "lego_card";
    public List<AppData> mAdDatas;
    public TextView mContent;
    public LinearLayout mItemContainer;
    public TextView mTitle;

    private TextView initItemView() {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0312);
        textView.setOnClickListener(this);
        return textView;
    }

    private void initLayout() {
        if (this.mAdDatas.size() == 0) {
            TextView initItemView = initItemView();
            initItemView.setOnClickListener(null);
            initItemView.setText("No AD");
            this.mItemContainer.addView(initItemView, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            return;
        }
        for (int i2 = 0; i2 != this.mAdDatas.size(); i2++) {
            TextView initItemView2 = initItemView();
            initItemView2.setText("AD" + i2);
            AppData appData = this.mAdDatas.get(i2);
            if (appData.mDiscardReason > 0) {
                SkinManager.setBackgroundResource(initItemView2, R.drawable.btn_all_red);
            } else {
                SkinManager.setBackgroundResource(initItemView2, R.drawable.btn_all_green);
            }
            if (i2 == 0) {
                updateContent(appData);
                this.mTitle.setText("AD0");
            }
            this.mItemContainer.addView(initItemView2, new LinearLayout.LayoutParams(-1, -1, 1.0f));
        }
    }

    private void updateContent(AppData appData) {
        if (appData == null) {
            this.mContent.setText("数据格式错误");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (appData.fillInJsonObject(jSONObject)) {
            try {
                String str = new String();
                if (appData.mDiscardReason > 0) {
                    String str2 = g.f60312a.get(Integer.valueOf(appData.mDiscardReason));
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "未知原因";
                    }
                    str = str + "\n抛弃原因 ： (" + appData.mDiscardReason + SmallTailInfo.EMOTION_SUFFIX + str2 + "\n\n";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(KEY_GOODS);
                String optString = optJSONObject.optString(KEY_LEGO);
                if (!TextUtils.isEmpty(optString)) {
                    optJSONObject.put(KEY_LEGO, new JSONObject(optString));
                    jSONObject.put(KEY_GOODS, optJSONObject);
                }
                this.mContent.setText(str + jSONObject.toString(4));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.ad_debug_copy) {
            a.a(this.mContent.getText().toString());
            showToast("已复制到系统剪贴板");
            return;
        }
        int indexOfChild = this.mItemContainer.indexOfChild(view);
        if (indexOfChild < 0 || indexOfChild >= this.mAdDatas.size()) {
            return;
        }
        TextView textView = this.mTitle;
        textView.setText("AD" + indexOfChild);
        updateContent(this.mAdDatas.get(indexOfChild));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ad_debug_layout);
        this.mTitle = (TextView) findViewById(R.id.ad_debug_label_data);
        this.mContent = (TextView) findViewById(R.id.ad_debug_content);
        this.mItemContainer = (LinearLayout) findViewById(R.id.ad_debug_item_container);
        ((TextView) findViewById(R.id.ad_debug_copy)).setOnClickListener(this);
        this.mContent.setMovementMethod(new ScrollingMovementMethod());
        this.mContent.setText("没刷到广告~ 换个姿势试试！");
        this.mAdDatas = w.p().j();
        initLayout();
    }
}
