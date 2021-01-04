package com.baidu.tieba.yuyinala.liveroom.h;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public abstract class a extends Dialog {
    public String hEM;
    public InterfaceC0899a oqc;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0899a {
        void onConfirm();
    }

    public abstract void initView();

    public abstract void p(String str, String str2, String str3);

    public a(@NonNull Context context) {
        super(context, a.i.sdk_Transparent);
        init();
    }

    public void init() {
        initView();
        JK();
    }

    private void JK() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        ciI();
    }

    public void ciI() {
        show();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = displayMetrics.widthPixels;
                attributes.height = displayMetrics.heightPixels;
                window.setAttributes(attributes);
            }
        }
    }

    public void a(InterfaceC0899a interfaceC0899a) {
        this.oqc = interfaceC0899a;
    }

    public void Ni(int i) {
    }
}
