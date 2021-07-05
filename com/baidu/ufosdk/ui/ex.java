package com.baidu.ufosdk.ui;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public final class ex implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ev f23533a;

    public ex(ev evVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {evVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23533a = evVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        int i3;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i2 = this.f23533a.f23530i;
            JSONArray jSONArray = null;
            String trim = i2 != -1 ? this.f23533a.f23523b.getText().toString().trim() : null;
            i3 = this.f23533a.f23529h;
            if (i3 != -1) {
                arrayList = this.f23533a.m;
                jSONArray = new JSONArray((Collection) arrayList);
            }
            ev.a(this.f23533a, trim, jSONArray);
        }
    }
}
