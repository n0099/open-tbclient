package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.yf2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public final class uf2 implements yf2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CopyOnWriteArrayList<rf2> a;
    public String b;
    public Map<String, String> c;
    public int d;
    public boolean e;
    public String f;

    public uf2(CopyOnWriteArrayList<rf2> copyOnWriteArrayList, String str, Map<String, String> map, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {copyOnWriteArrayList, str, map, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = copyOnWriteArrayList;
        this.b = str;
        this.c = map;
        this.d = i;
        this.e = z;
    }

    @Override // com.baidu.tieba.yf2.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f = str;
        }
    }

    @Override // com.baidu.tieba.yf2.a
    public WebResourceResponse b(String str, Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, z)) == null) {
            if (this.d >= this.a.size()) {
                return null;
            }
            return this.a.get(this.d).a(new uf2(this.a, this.b, this.c, this.d + 1, z));
        }
        return (WebResourceResponse) invokeLLZ.objValue;
    }

    @Override // com.baidu.tieba.yf2.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yf2.a
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yf2.a
    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.f)) {
                this.f = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.b));
            }
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yf2.a
    public Map<String, String> getRequestHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (Map) invokeV.objValue;
    }
}
