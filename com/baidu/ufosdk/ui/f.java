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
/* loaded from: classes8.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout.LayoutParams f59745a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f59746b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f59747c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f59748d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f59749e;

    /* renamed from: f  reason: collision with root package name */
    public Context f59750f;

    /* renamed from: g  reason: collision with root package name */
    public ey f59751g;

    public f(ArrayList arrayList, Context context, ey eyVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, context, eyVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59750f = context;
        this.f59751g = eyVar;
        this.f59748d = new ArrayList();
        this.f59749e = new ArrayList();
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, arrayList) == null) {
            int i2 = 0;
            while (i2 < arrayList.size()) {
                int i3 = i2 + 1;
                (i3 % 2 == 1 ? this.f59748d : this.f59749e).add(arrayList.get(i2));
                i2 = i3;
            }
        }
    }

    public final LinearLayout a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f59750f);
            this.f59746b = linearLayout;
            linearLayout.setOrientation(1);
            this.f59746b.setBackgroundColor(-1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            this.f59745a = layoutParams;
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f59750f, 15.0f), com.baidu.ufosdk.f.i.a(this.f59750f, 2.0f), com.baidu.ufosdk.f.i.a(this.f59750f, 15.0f), com.baidu.ufosdk.f.i.a(this.f59750f, 14.0f));
            for (int i2 = 0; i2 < this.f59748d.size(); i2++) {
                e eVar = new e(this.f59750f);
                eVar.a();
                eVar.a((String) this.f59748d.get(i2));
                eVar.a(com.baidu.ufosdk.b.U);
                this.f59746b.addView(eVar, this.f59745a);
                eVar.setOnClickListener(new g(this, eVar));
            }
            return this.f59746b;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final LinearLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f59750f);
            this.f59747c = linearLayout;
            linearLayout.setOrientation(1);
            this.f59747c.setBackgroundColor(-1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            this.f59745a = layoutParams;
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f59750f, 5.0f), com.baidu.ufosdk.f.i.a(this.f59750f, 2.0f), com.baidu.ufosdk.f.i.a(this.f59750f, 15.0f), com.baidu.ufosdk.f.i.a(this.f59750f, 14.0f));
            for (int i2 = 0; i2 < this.f59749e.size(); i2++) {
                e eVar = new e(this.f59750f);
                eVar.a();
                eVar.a((String) this.f59749e.get(i2));
                eVar.a(com.baidu.ufosdk.b.U);
                this.f59747c.addView(eVar, this.f59745a);
                eVar.setOnClickListener(new h(this, eVar));
            }
            return this.f59747c;
        }
        return (LinearLayout) invokeV.objValue;
    }
}
