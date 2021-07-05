package com.bytedance.sdk.component.adnet.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.b.d;
import com.bytedance.sdk.component.adnet.core.o;
/* loaded from: classes6.dex */
public class a implements d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LruCache<String, Pair<Bitmap, byte[]>> f27735a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27735a = new LruCache<String, Pair<Bitmap, byte[]>>(this, Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16) { // from class: com.bytedance.sdk.component.adnet.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f27736a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f27736a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.LruCache
            /* renamed from: a */
            public int sizeOf(String str, Pair<Bitmap, byte[]> pair) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, pair)) == null) {
                    Bitmap bitmap = (Bitmap) pair.first;
                    Object obj = pair.second;
                    int length = obj != null ? ((byte[]) obj).length : 0;
                    return bitmap != null ? length + (bitmap.getRowBytes() * bitmap.getHeight()) : length;
                }
                return invokeLL.intValue;
            }
        };
    }

    @Override // com.bytedance.sdk.component.adnet.b.d.b
    public String a(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), scaleType})) == null) {
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.b.d.b
    public byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                Pair<Bitmap, byte[]> pair = this.f27735a.get(str);
                byte[] bArr = pair != null ? (byte[]) pair.second : new byte[0];
                return bArr == null ? new byte[0] : bArr;
            } catch (Throwable th) {
                o.a(th, "DefaultImageCache get bitmap error", new Object[0]);
                return new byte[0];
            }
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.b.d.b
    public Bitmap b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                Pair<Bitmap, byte[]> pair = this.f27735a.get(str);
                if (pair != null) {
                    return (Bitmap) pair.first;
                }
                return null;
            } catch (Throwable th) {
                o.a(th, "DefaultImageCache get bitmap error", new Object[0]);
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.b.d.b
    public void a(String str, Bitmap bitmap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bitmap, bArr) == null) || TextUtils.isEmpty(str) || bitmap == null) {
            return;
        }
        try {
            this.f27735a.put(str, new Pair<>(bitmap, bArr));
        } catch (Throwable th) {
            o.a(th, "DefaultImageCache put bitmap error", new Object[0]);
        }
    }
}
