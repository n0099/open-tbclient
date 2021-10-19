package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f59755a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f59756b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f59757c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f59758d;

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
        this.f59758d = aVar;
        this.f59755a = str;
        this.f59756b = str2;
        this.f59757c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                Bitmap a2 = a.a(this.f59755a);
                if (a2 == null) {
                    this.f59757c.obtainMessage(0, null).sendToTarget();
                    return;
                }
                hashMap = a.f59753b;
                hashMap.put(this.f59756b, new SoftReference(a2));
                f.a().a(a2, this.f59756b);
                this.f59757c.obtainMessage(0, a2).sendToTarget();
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (OutOfMemoryError e3) {
                c.d(e3.toString());
                System.gc();
            }
        }
    }
}
