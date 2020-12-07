package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes4.dex */
public class b extends Dialog implements View.OnClickListener {
    private Activity beD;
    private TextView mTipView;
    private View mView;

    public b(Activity activity) {
        super(activity, a.i.DialogConnectionWheatStyle_3);
        this.beD = activity;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.yuyin_sdk_custom_loading_toast);
        Zo();
        initView();
        initListener();
    }

    private void Zo() {
        Window window;
        if (this.beD != null && (window = this.beD.getWindow()) != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (((WindowManager) getContext().getSystemService("window")) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (UtilHelper.getRealScreenOrientation(this.beD) == 2) {
                    attributes.width = ScreenHelper.getRealScreenHeight(this.beD);
                    attributes.height = -1;
                } else {
                    attributes.width = -1;
                    attributes.height = -1;
                }
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        this.mTipView = (TextView) findViewById(a.f.custom_loading_text);
        this.mView = findViewById(a.f.view);
    }

    private void initListener() {
        this.mView.setOnClickListener(this);
    }

    public void setTipString(String str) {
        if (this.mTipView != null && !TextUtils.isEmpty(str)) {
            this.mTipView.setText(str);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
    }
}
