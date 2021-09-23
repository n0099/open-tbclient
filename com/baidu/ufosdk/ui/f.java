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
    public LinearLayout.LayoutParams f60056a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f60057b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f60058c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f60059d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f60060e;

    /* renamed from: f  reason: collision with root package name */
    public Context f60061f;

    /* renamed from: g  reason: collision with root package name */
    public ey f60062g;

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
        this.f60061f = context;
        this.f60062g = eyVar;
        this.f60059d = new ArrayList();
        this.f60060e = new ArrayList();
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, arrayList) == null) {
            int i2 = 0;
            while (i2 < arrayList.size()) {
                int i3 = i2 + 1;
                (i3 % 2 == 1 ? this.f60059d : this.f60060e).add(arrayList.get(i2));
                i2 = i3;
            }
        }
    }

    public final LinearLayout a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f60061f);
            this.f60057b = linearLayout;
            linearLayout.setOrientation(1);
            this.f60057b.setBackgroundColor(-1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            this.f60056a = layoutParams;
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f60061f, 15.0f), com.baidu.ufosdk.f.i.a(this.f60061f, 2.0f), com.baidu.ufosdk.f.i.a(this.f60061f, 15.0f), com.baidu.ufosdk.f.i.a(this.f60061f, 14.0f));
            for (int i2 = 0; i2 < this.f60059d.size(); i2++) {
                e eVar = new e(this.f60061f);
                eVar.a();
                eVar.a((String) this.f60059d.get(i2));
                eVar.a(com.baidu.ufosdk.b.U);
                this.f60057b.addView(eVar, this.f60056a);
                eVar.setOnClickListener(new g(this, eVar));
            }
            return this.f60057b;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final LinearLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f60061f);
            this.f60058c = linearLayout;
            linearLayout.setOrientation(1);
            this.f60058c.setBackgroundColor(-1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            this.f60056a = layoutParams;
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f60061f, 5.0f), com.baidu.ufosdk.f.i.a(this.f60061f, 2.0f), com.baidu.ufosdk.f.i.a(this.f60061f, 15.0f), com.baidu.ufosdk.f.i.a(this.f60061f, 14.0f));
            for (int i2 = 0; i2 < this.f60060e.size(); i2++) {
                e eVar = new e(this.f60061f);
                eVar.a();
                eVar.a((String) this.f60060e.get(i2));
                eVar.a(com.baidu.ufosdk.b.U);
                this.f60058c.addView(eVar, this.f60056a);
                eVar.setOnClickListener(new h(this, eVar));
            }
            return this.f60058c;
        }
        return (LinearLayout) invokeV.objValue;
    }
}
