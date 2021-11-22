package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f57707a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f57708b;

    /* renamed from: c  reason: collision with root package name */
    public Context f57709c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f57710d;

    /* renamed from: e  reason: collision with root package name */
    public d f57711e;

    /* renamed from: f  reason: collision with root package name */
    public int f57712f;

    public a(ArrayList arrayList, Context context, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, context, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57712f = 0;
        this.f57709c = context;
        this.f57711e = dVar;
        this.f57707a = new ArrayList();
        this.f57708b = new ArrayList();
        this.f57710d = new ArrayList();
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, arrayList) == null) {
            int i2 = 0;
            while (i2 < arrayList.size()) {
                int i3 = i2 + 1;
                (i3 % 2 == 1 ? this.f57707a : this.f57708b).add(arrayList.get(i2));
                i2 = i3;
            }
        }
    }

    public final LinearLayout a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f57709c);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(-1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f57709c, 15.0f), com.baidu.ufosdk.f.i.a(this.f57709c, 2.0f), com.baidu.ufosdk.f.i.a(this.f57709c, 15.0f), com.baidu.ufosdk.f.i.a(this.f57709c, 14.0f));
            for (int i2 = 0; i2 < this.f57707a.size(); i2++) {
                e eVar = new e(this.f57709c);
                eVar.a();
                eVar.a((String) this.f57707a.get(i2));
                eVar.a(com.baidu.ufosdk.b.U);
                linearLayout.addView(eVar, layoutParams);
                eVar.setOnClickListener(new b(this, eVar));
            }
            return linearLayout;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final LinearLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f57709c);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(-1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f57709c, 5.0f), com.baidu.ufosdk.f.i.a(this.f57709c, 2.0f), com.baidu.ufosdk.f.i.a(this.f57709c, 15.0f), com.baidu.ufosdk.f.i.a(this.f57709c, 14.0f));
            for (int i2 = 0; i2 < this.f57708b.size(); i2++) {
                e eVar = new e(this.f57709c);
                eVar.a();
                eVar.a((String) this.f57708b.get(i2));
                eVar.a(com.baidu.ufosdk.b.U);
                linearLayout.addView(eVar, layoutParams);
                eVar.setOnClickListener(new c(this, eVar));
            }
            return linearLayout;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final ArrayList c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57710d : (ArrayList) invokeV.objValue;
    }
}
