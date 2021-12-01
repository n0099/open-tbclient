package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f51543b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f51544c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f51545d;

    public b(a aVar, String str, String str2, n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, str, str2, nVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51545d = aVar;
        this.a = str;
        this.f51543b = str2;
        this.f51544c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                Bitmap a = a.a(this.a);
                if (a == null) {
                    this.f51544c.obtainMessage(0, null).sendToTarget();
                    return;
                }
                hashMap = a.f51541b;
                hashMap.put(this.f51543b, new SoftReference(a));
                f.a().a(a, this.f51543b);
                this.f51544c.obtainMessage(0, a).sendToTarget();
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (OutOfMemoryError e3) {
                c.d(e3.toString());
                System.gc();
            }
        }
    }
}
