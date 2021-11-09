package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class bk implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f56833a;

    public bk(FeedbackInputActivity feedbackInputActivity) {
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
        this.f56833a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SharedPreferences.Editor edit = this.f56833a.getSharedPreferences("UfoSharePreference", 0).edit();
            str = this.f56833a.aA;
            if (str != null) {
                str3 = this.f56833a.aA;
                if (str3.trim().length() > 0) {
                    str4 = this.f56833a.aA;
                    str2 = com.baidu.ufosdk.f.k.a(str4);
                    edit.putString("cryptContactData", str2);
                    edit.commit();
                    FeedbackInputActivity.j(this.f56833a);
                }
            }
            str2 = "";
            edit.putString("cryptContactData", str2);
            edit.commit();
            FeedbackInputActivity.j(this.f56833a);
        }
    }
}
