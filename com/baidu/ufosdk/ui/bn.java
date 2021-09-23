package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class bn implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f59884a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ bm f59885b;

    public bn(bm bmVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bmVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59885b = bmVar;
        this.f59884a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SharedPreferences.Editor edit = this.f59885b.f59883b.getSharedPreferences("UfoSharePreference", 0).edit();
            edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f59884a));
            edit.commit();
            this.f59885b.f59883b.aA = this.f59884a;
            FeedbackInputActivity.j(this.f59885b.f59883b);
        }
    }
}
