package com.baidu.ufosdk.screencapedt;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ufosdk.f.m;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes7.dex */
final class i extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f5405a;

    public i(ScreenCapEditActivity screenCapEditActivity) {
        this.f5405a = new WeakReference(screenCapEditActivity);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        HashMap hashMap;
        ImageView imageView;
        TextView textView;
        RelativeLayout relativeLayout;
        ImageView imageView2;
        TextView textView2;
        RelativeLayout relativeLayout2;
        super.handleMessage(message);
        ScreenCapEditActivity screenCapEditActivity = (ScreenCapEditActivity) this.f5405a.get();
        if (screenCapEditActivity != null && message.what == 0) {
            com.baidu.ufosdk.f.c.c("msg.what==0");
            hashMap = screenCapEditActivity.t;
            if (hashMap.size() == 0) {
                imageView2 = screenCapEditActivity.O;
                imageView2.setBackgroundDrawable(new BitmapDrawable(m.a(screenCapEditActivity, "delete_all_disable.png")));
                textView2 = screenCapEditActivity.V;
                textView2.setTextColor(-10066330);
                relativeLayout2 = screenCapEditActivity.P;
                relativeLayout2.setClickable(false);
                return;
            }
            imageView = screenCapEditActivity.O;
            imageView.setBackgroundDrawable(new BitmapDrawable(m.a(screenCapEditActivity, "delete_all.png")));
            textView = screenCapEditActivity.V;
            textView.setTextColor(-1);
            relativeLayout = screenCapEditActivity.P;
            relativeLayout.setClickable(true);
        }
    }
}
