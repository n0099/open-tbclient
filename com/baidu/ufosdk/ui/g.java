package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class g implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f60107a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f60108b;

    public g(f fVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60108b = fVar;
        this.f60107a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ey eyVar;
        ey eyVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            String b2 = this.f60107a.b();
            for (int i2 = 0; i2 < this.f60108b.f60092b.getChildCount(); i2++) {
                View childAt = this.f60108b.f60092b.getChildAt(i2);
                if (childAt instanceof e) {
                    e eVar = (e) childAt;
                    if (eVar.b().equals(b2)) {
                        eVar.a(true);
                    } else {
                        eVar.a(false);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f60108b.f60093c.getChildCount(); i3++) {
                View childAt2 = this.f60108b.f60093c.getChildAt(i3);
                if (childAt2 instanceof e) {
                    ((e) childAt2).a(false);
                }
            }
            eyVar = this.f60108b.f60097g;
            if (eyVar != null) {
                eyVar2 = this.f60108b.f60097g;
                eyVar2.a(b2);
            }
        }
    }
}
