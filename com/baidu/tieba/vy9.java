package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.wy9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class vy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public dz9 b;
    public wy9 c;
    public wy9.c d;

    public vy9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public void h(dz9 dz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dz9Var) == null) {
            this.b = dz9Var;
        }
    }

    public void i(wy9.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            wy9 wy9Var = this.c;
            if (wy9Var != null) {
                wy9Var.h(cVar);
            }
        }
    }

    public static void a(List<dz9> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new dz9(str, i, str2));
    }

    public static List<dz9> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f08059a, context.getString(R.string.obfuscated_res_0x7f0f068d), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059e, context.getString(R.string.obfuscated_res_0x7f0f068a), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a1, context.getString(R.string.obfuscated_res_0x7f0f068e), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059d, context.getString(R.string.obfuscated_res_0x7f0f0688), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f080598, context.getString(R.string.obfuscated_res_0x7f0f0685), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a5, context.getString(R.string.obfuscated_res_0x7f0f0692), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f080597, context.getString(R.string.obfuscated_res_0x7f0f0684), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059f, context.getString(R.string.obfuscated_res_0x7f0f068b), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f080599, context.getString(R.string.obfuscated_res_0x7f0f0689), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f080594, context.getString(R.string.obfuscated_res_0x7f0f0681), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059b, context.getString(R.string.obfuscated_res_0x7f0f0686), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a3, context.getString(R.string.obfuscated_res_0x7f0f0690), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a4, context.getString(R.string.obfuscated_res_0x7f0f0691), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f080596, context.getString(R.string.obfuscated_res_0x7f0f0683), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a0, context.getString(R.string.obfuscated_res_0x7f0f068c), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059c, context.getString(R.string.obfuscated_res_0x7f0f0687), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a2, context.getString(R.string.obfuscated_res_0x7f0f068f), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f080595, context.getString(R.string.obfuscated_res_0x7f0f0682), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return ky9.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            dz9 dz9Var = this.b;
            if (dz9Var != null && !"normal".equalsIgnoreCase(dz9Var.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        wy9 wy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (wy9Var = this.c) != null) {
            wy9Var.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            wy9 wy9Var = this.c;
            if (wy9Var != null) {
                return wy9Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            wy9 wy9Var = this.c;
            if ((wy9Var == null || !wy9Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                wy9 wy9Var2 = new wy9(this.a, str, d(), str2);
                this.c = wy9Var2;
                wy9.c cVar = this.d;
                if (cVar != null) {
                    wy9Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
