package com.bytedance.sdk.component.image.c.a.b;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.LruCache;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.IMemoryCache;
/* loaded from: classes9.dex */
public class b implements IMemoryCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f65190a;

    /* renamed from: b  reason: collision with root package name */
    public int f65191b;

    /* renamed from: c  reason: collision with root package name */
    public int f65192c;

    /* renamed from: d  reason: collision with root package name */
    public LruCache<String, Bitmap> f65193d;

    public b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65192c = i2;
        this.f65190a = i3;
        this.f65193d = new LruCache<String, Bitmap>(this, i2) { // from class: com.bytedance.sdk.component.image.c.a.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f65194a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(i2);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f65194a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.LruCache
            /* renamed from: a */
            public int sizeOf(String str, Bitmap bitmap) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, bitmap)) == null) ? b.a(bitmap) : invokeLL.intValue;
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.image.c.a.a
    @Nullable
    public boolean a(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bitmap)) == null) {
            if (str == null || bitmap == null) {
                return false;
            }
            this.f65193d.put(str, bitmap);
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.image.c.a.a
    @Nullable
    public Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f65193d.get(str) : (Bitmap) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.image.c.a.a
    public void a(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)}) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.f65193d.trimToSize((int) (this.f65192c * d2));
            } else {
                this.f65193d.evictAll();
            }
        }
    }

    public static int a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bitmap)) == null) {
            if (bitmap == null) {
                return 0;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 19) {
                return bitmap.getAllocationByteCount();
            }
            if (i2 >= 12) {
                return bitmap.getByteCount();
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        return invokeL.intValue;
    }
}
