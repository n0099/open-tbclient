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
    public String hEE;
    public InterfaceC0926a ovN;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0926a {
        void onConfirm();
    }

    public abstract void initView();

    public abstract void o(String str, String str2, String str3);

    public a(@NonNull Context context) {
        super(context, a.i.sdk_Transparent);
        init();
    }

    public void init() {
        initView();
        Hf();
    }

    private void Hf() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        cfR();
    }

    public void cfR() {
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

    public void a(InterfaceC0926a interfaceC0926a) {
        this.ovN = interfaceC0926a;
    }

    public void LX(int i) {
    }
}
