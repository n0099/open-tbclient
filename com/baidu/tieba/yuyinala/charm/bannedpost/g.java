package com.baidu.tieba.yuyinala.charm.bannedpost;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes10.dex */
public class g extends Dialog implements DialogInterface.OnDismissListener, View.OnClickListener {
    private View bZD;
    private TextView bZE;
    private TextView bZF;
    private Context mContext;
    private TextView mTitle;
    private a osD;

    /* loaded from: classes10.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public g(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.yuyin_layout_dialog_connnection_wheat_remind);
        YE();
        initView();
        initListener();
    }

    private void YE() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(a.c.sdk_black_alpha30)));
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (((WindowManager) getContext().getSystemService("window")) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = ScreenHelper.getRealScreenHeight(this.mContext);
                    attributes.height = -1;
                } else {
                    attributes.width = -1;
                    attributes.height = ScreenHelper.getRealScreenHeight(this.mContext) - UtilHelper.getStatusBarHeight();
                }
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        this.bZD = findViewById(a.f.view);
        this.mTitle = (TextView) findViewById(a.f.tv_title);
        this.bZE = (TextView) findViewById(a.f.tv_cancel);
        this.bZF = (TextView) findViewById(a.f.tv_confirm);
    }

    private void initListener() {
        this.bZD.setOnClickListener(this);
        this.bZE.setOnClickListener(this);
        this.bZF.setOnClickListener(this);
        setOnDismissListener(this);
    }

    public void setText(String str) {
        if (this.mTitle != null && !TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void VW(String str) {
        if (this.bZE != null && !TextUtils.isEmpty(str)) {
            this.bZE.setText(str);
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
        if (view == this.bZD || view == this.bZE) {
            dismiss();
            if (this.osD != null) {
                this.osD.onCancel();
            }
        } else if (view == this.bZF) {
            dismiss();
            if (this.osD != null) {
                this.osD.onConfirm();
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
    }

    public void a(a aVar) {
        this.osD = aVar;
    }
}
