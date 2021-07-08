package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f23463a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f23464b;

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
        this.f23464b = aVar;
        this.f23463a = eVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:21:0x0089 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b A[LOOP:0: B:20:0x007f->B:22:0x008b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
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
        e eVar = this.f23463a;
        boolean z = !eVar.f23589a;
        eVar.f23589a = z;
        eVar.a(z);
        if (this.f23463a.f23589a) {
            arrayList5 = this.f23464b.f23430d;
            arrayList5.add(this.f23463a.b());
            if (this.f23463a.b().contains("抄袭")) {
                this.f23464b.f23432f = 1;
            }
            if (this.f23463a.b().equals("播放问题")) {
                aVar = this.f23464b;
                i2 = 2;
                aVar.f23432f = i2;
            }
            for (i3 = 0; i3 < arrayList2.size(); i3++) {
                StringBuilder sb = new StringBuilder("选中的原因：");
                arrayList4 = this.f23464b.f23430d;
                sb.append((String) arrayList4.get(i3));
                com.baidu.ufosdk.f.c.a(sb.toString());
            }
            dVar = this.f23464b.f23431e;
            if (dVar == null) {
                dVar2 = this.f23464b.f23431e;
                arrayList3 = this.f23464b.f23430d;
                i4 = this.f23464b.f23432f;
                dVar2.a(arrayList3, i4);
                return;
            }
            return;
        }
        arrayList = this.f23464b.f23430d;
        arrayList.remove(this.f23463a.b());
        if (this.f23463a.b().contains("抄袭")) {
            this.f23464b.f23432f = 3;
        }
        if (this.f23463a.b().equals("播放问题")) {
            aVar = this.f23464b;
            i2 = 4;
            aVar.f23432f = i2;
        }
        while (i3 < arrayList2.size()) {
        }
        dVar = this.f23464b.f23431e;
        if (dVar == null) {
        }
    }
}
