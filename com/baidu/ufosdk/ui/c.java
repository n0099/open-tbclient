package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f57775a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f57776b;

    public c(a aVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57776b = aVar;
        this.f57775a = eVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:21:0x0087 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089 A[LOOP:0: B:20:0x007d->B:22:0x0089, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        ArrayList arrayList;
        a aVar;
        int i2;
        int i3;
        ArrayList arrayList2;
        d dVar;
        d dVar2;
        ArrayList arrayList3;
        int i4;
        ArrayList arrayList4;
        ArrayList arrayList5;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, view) != null) {
            return;
        }
        e eVar = this.f57775a;
        boolean z = !eVar.f57869a;
        eVar.f57869a = z;
        eVar.a(z);
        if (this.f57775a.f57869a) {
            arrayList5 = this.f57776b.f57710d;
            arrayList5.add(this.f57775a.b());
            if (this.f57775a.b().contains("抄袭")) {
                this.f57776b.f57712f = 1;
            }
            if (this.f57775a.b().equals("播放问题")) {
                aVar = this.f57776b;
                i2 = 2;
                aVar.f57712f = i2;
            }
            for (i3 = 0; i3 < arrayList2.size(); i3++) {
                StringBuilder sb = new StringBuilder("选中的原因：");
                arrayList4 = this.f57776b.f57710d;
                sb.append((String) arrayList4.get(i3));
                com.baidu.ufosdk.f.c.a(sb.toString());
            }
            dVar = this.f57776b.f57711e;
            if (dVar == null) {
                dVar2 = this.f57776b.f57711e;
                arrayList3 = this.f57776b.f57710d;
                i4 = this.f57776b.f57712f;
                dVar2.a(arrayList3, i4);
                return;
            }
            return;
        }
        arrayList = this.f57776b.f57710d;
        arrayList.remove(this.f57775a.b());
        if (this.f57775a.b().contains("抄袭")) {
            this.f57776b.f57712f = 3;
        }
        if (this.f57775a.b().equals("播放问题")) {
            aVar = this.f57776b;
            i2 = 4;
            aVar.f57712f = i2;
        }
        while (i3 < arrayList2.size()) {
        }
        dVar = this.f57776b.f57711e;
        if (dVar == null) {
        }
    }
}
