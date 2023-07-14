package com.baidu.tieba;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rsa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LruCache<String, Bitmap> a;

    /* loaded from: classes7.dex */
    public class a extends LruCache<String, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rsa rsaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rsaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.LruCache
        /* renamed from: a */
        public void entryRemoved(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, bitmap, bitmap2}) == null) && bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.LruCache
        /* renamed from: b */
        public int sizeOf(String str, Bitmap bitmap) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bitmap)) == null) {
                return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
            }
            return invokeLL.intValue;
        }
    }

    public rsa(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i > 0) {
            this.a = new a(this, i);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.a.get(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public void b(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bitmap) == null) && !TextUtils.isEmpty(str) && bitmap != null && !bitmap.isRecycled()) {
            this.a.put(str, bitmap);
        }
    }
}
