package com.baidu.tieba.yuyinala.liveroom.h;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public abstract class a extends Dialog {
    public String hAg;
    public InterfaceC0920a olu;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0920a {
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
        FP();
    }

    private void FP() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        ceR();
    }

    public void ceR() {
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

    public void a(InterfaceC0920a interfaceC0920a) {
        this.olu = interfaceC0920a;
    }

    public void LB(int i) {
    }
}
