package com.bytedance.sdk.component.d.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f28687a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28688b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.d.b.d f28689c;

    public d(byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28688b = false;
        this.f28687a = bArr;
        this.f28688b = z;
    }

    @Override // com.bytedance.sdk.component.d.d.h
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "decode" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.d.d.h
    public void a(com.bytedance.sdk.component.d.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            com.bytedance.sdk.component.d.c.b a2 = com.bytedance.sdk.component.d.c.b.a();
            com.bytedance.sdk.component.d.c.b.a a3 = a2.a(aVar);
            try {
                String a4 = a(this.f28687a);
                if (!TextUtils.isEmpty(a4) && a4.startsWith("image")) {
                    Bitmap a5 = a3.a(this.f28687a);
                    if (a5 != null) {
                        aVar.a(new l(a5, this.f28689c));
                        a2.b().a(aVar.e(), a5);
                        return;
                    }
                    a(1002, "decode failed bitmap null", null, aVar);
                    return;
                }
                a(1001, "not image format", null, aVar);
            } catch (Throwable th) {
                a(1002, "decode failed:" + th.getMessage(), th, aVar);
            }
        }
    }

    public d(byte[] bArr, com.bytedance.sdk.component.d.b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28688b = false;
        this.f28687a = bArr;
        this.f28689c = dVar;
    }

    private void a(int i2, String str, Throwable th, com.bytedance.sdk.component.d.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), str, th, aVar}) == null) {
            if (this.f28688b) {
                aVar.a(new j());
            } else {
                aVar.a(new g(i2, str, th));
            }
        }
    }

    private String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bArr)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            return options.outMimeType;
        }
        return (String) invokeL.objValue;
    }
}
