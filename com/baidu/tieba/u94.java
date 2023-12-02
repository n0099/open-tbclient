package com.baidu.tieba;

import android.content.res.Resources;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public volatile float height;
    @V8JavascriptField
    public volatile float left;
    @V8JavascriptField
    public volatile float top;
    @V8JavascriptField
    public volatile float width;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
        }
    }

    public u94() {
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (rp2.c() != null) {
            resources = rp2.c().getResources();
        } else {
            resources = null;
        }
        this.left = a(resources, R.dimen.obfuscated_res_0x7f0708af);
        this.top = a(resources, R.dimen.obfuscated_res_0x7f0708b0);
        this.width = a(resources, R.dimen.obfuscated_res_0x7f0708b1);
        this.height = a(resources, R.dimen.obfuscated_res_0x7f0708ae);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "{left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + "}";
        }
        return (String) invokeV.objValue;
    }

    public final float a(Resources resources, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, resources, i)) == null) {
            if (resources != null && i != 0) {
                return a94.b(resources.getDimension(i));
            }
            return 0.0f;
        }
        return invokeLI.floatValue;
    }
}
