package com.baidu.ufosdk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
/* loaded from: classes10.dex */
public final class dh extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f56924a;

    public dh(FeedbackListActivity feedbackListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56924a = feedbackListActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Handler handler;
        View view;
        View view2;
        ExecutorService executorService;
        ExecutorService executorService2;
        View view3;
        Handler handler2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            if (intent.getAction().equals("com.baidu.ufosdk.gethistorylist")) {
                view3 = this.f56924a.w;
                view3.setVisibility(8);
                handler2 = this.f56924a.A;
                handler2.obtainMessage(0, (ArrayList) intent.getSerializableExtra("msgList")).sendToTarget();
                FeedbackListActivity.k(this.f56924a);
            }
            if (intent.getAction().equals("com.baidu.ufosdk.getnewhistoryflag")) {
                executorService2 = this.f56924a.y;
                executorService2.execute(new di(this));
            }
            if (intent.getAction().equals("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag")) {
                executorService = this.f56924a.y;
                executorService.execute(new dj(this));
            }
            if (intent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss")) {
                view = this.f56924a.v;
                view.setVisibility(8);
                view2 = this.f56924a.w;
                view2.setVisibility(8);
            }
            if (intent.getAction().equals("com.baidu.ufosdk.reload")) {
                handler = this.f56924a.A;
                handler.obtainMessage(1, null).sendToTarget();
            }
        }
    }
}
