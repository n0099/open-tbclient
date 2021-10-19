package com.baidu.ufosdk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class bi extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f59913a;

    public bi(FeedbackInputActivity feedbackInputActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackInputActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59913a = feedbackInputActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0083  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceive(Context context, Intent intent) {
        Handler handler;
        String str;
        String str2;
        FeedbackInputActivity feedbackInputActivity;
        String str3;
        Handler handler2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            if (intent.getAction().equals("com.baidu.ufosdk.getchat")) {
                ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList("msgList");
                handler2 = this.f59913a.aK;
                handler2.obtainMessage(2, parcelableArrayList).sendToTarget();
            }
            if (intent.getAction().equals("com.baidu.ufosdk.getmsgid")) {
                this.f59913a.f59841e = intent.getStringExtra("msgid");
                str = this.f59913a.ar;
                if (str != null) {
                    str3 = this.f59913a.ar;
                    if (str3.length() > 0) {
                        str2 = this.f59913a.ar;
                        feedbackInputActivity = this.f59913a;
                        if (feedbackInputActivity.f59843g == null) {
                            feedbackInputActivity.f59843g = new com.baidu.ufosdk.a.a(this.f59913a.getApplicationContext(), this.f59913a.f59841e, str2);
                        }
                        this.f59913a.f59843g.b();
                        if (!this.f59913a.f59843g.isAlive()) {
                            this.f59913a.f59843g.start();
                        }
                    }
                }
                str2 = UfoSDK.appid;
                feedbackInputActivity = this.f59913a;
                if (feedbackInputActivity.f59843g == null) {
                }
                this.f59913a.f59843g.b();
                if (!this.f59913a.f59843g.isAlive()) {
                }
            }
            if (intent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss")) {
                this.f59913a.k.setVisibility(8);
            }
            if (intent.getAction().equals("com.baidu.ufosdk.reload")) {
                handler = this.f59913a.aK;
                handler.obtainMessage(4, null).sendToTarget();
            }
        }
    }
}
