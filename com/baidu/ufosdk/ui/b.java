package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public final class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ e a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f51643b;

    public b(a aVar, e eVar) {
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
        this.f51643b = aVar;
        this.a = eVar;
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
        e eVar = this.a;
        boolean z = !eVar.a;
        eVar.a = z;
        eVar.a(z);
        if (this.a.a) {
            arrayList5 = this.f51643b.f51636d;
            arrayList5.add(this.a.b());
            if (this.a.b().contains("抄袭")) {
                this.f51643b.f51638f = 1;
            }
            if (this.a.b().equals("播放问题")) {
                aVar = this.f51643b;
                i2 = 2;
                aVar.f51638f = i2;
            }
            for (i3 = 0; i3 < arrayList2.size(); i3++) {
                StringBuilder sb = new StringBuilder("选中的原因：");
                arrayList4 = this.f51643b.f51636d;
                sb.append((String) arrayList4.get(i3));
                com.baidu.ufosdk.f.c.a(sb.toString());
            }
            dVar = this.f51643b.f51637e;
            if (dVar == null) {
                dVar2 = this.f51643b.f51637e;
                arrayList3 = this.f51643b.f51636d;
                i4 = this.f51643b.f51638f;
                dVar2.a(arrayList3, i4);
                return;
            }
            return;
        }
        arrayList = this.f51643b.f51636d;
        arrayList.remove(this.a.b());
        if (this.a.b().contains("抄袭")) {
            this.f51643b.f51638f = 3;
        }
        if (this.a.b().equals("播放问题")) {
            aVar = this.f51643b;
            i2 = 4;
            aVar.f51638f = i2;
        }
        while (i3 < arrayList2.size()) {
        }
        dVar = this.f51643b.f51637e;
        if (dVar == null) {
        }
    }
}
