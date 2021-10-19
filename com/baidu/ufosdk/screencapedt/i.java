package com.baidu.ufosdk.screencapedt;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.f.m;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class i extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f59804a;

    public i(ScreenCapEditActivity screenCapEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {screenCapEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59804a = new WeakReference(screenCapEditActivity);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            ScreenCapEditActivity screenCapEditActivity = (ScreenCapEditActivity) this.f59804a.get();
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
}
