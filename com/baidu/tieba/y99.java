package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.z99;
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
/* loaded from: classes7.dex */
public class y99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ga9 b;
    public z99 c;
    public z99.c d;

    public y99(Context context) {
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

    public void h(ga9 ga9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ga9Var) == null) {
            this.b = ga9Var;
        }
    }

    public void i(z99.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            z99 z99Var = this.c;
            if (z99Var != null) {
                z99Var.h(cVar);
            }
        }
    }

    public static void a(List<ga9> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new ga9(str, i, str2));
    }

    public static List<ga9> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f080587, context.getString(R.string.obfuscated_res_0x7f0f0678), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058b, context.getString(R.string.obfuscated_res_0x7f0f0675), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058e, context.getString(R.string.obfuscated_res_0x7f0f0679), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058a, context.getString(R.string.obfuscated_res_0x7f0f0673), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f080585, context.getString(R.string.obfuscated_res_0x7f0f0670), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f080592, context.getString(R.string.obfuscated_res_0x7f0f067d), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f080584, context.getString(R.string.obfuscated_res_0x7f0f066f), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058c, context.getString(R.string.obfuscated_res_0x7f0f0676), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f080586, context.getString(R.string.obfuscated_res_0x7f0f0674), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f080581, context.getString(R.string.obfuscated_res_0x7f0f066c), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f080588, context.getString(R.string.obfuscated_res_0x7f0f0671), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f080590, context.getString(R.string.obfuscated_res_0x7f0f067b), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f080591, context.getString(R.string.obfuscated_res_0x7f0f067c), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f080583, context.getString(R.string.obfuscated_res_0x7f0f066e), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058d, context.getString(R.string.obfuscated_res_0x7f0f0677), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f080589, context.getString(R.string.obfuscated_res_0x7f0f0672), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058f, context.getString(R.string.obfuscated_res_0x7f0f067a), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f080582, context.getString(R.string.obfuscated_res_0x7f0f066d), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return n99.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ga9 ga9Var = this.b;
            if (ga9Var != null && !"normal".equalsIgnoreCase(ga9Var.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        z99 z99Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (z99Var = this.c) != null) {
            z99Var.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            z99 z99Var = this.c;
            if (z99Var != null) {
                return z99Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            z99 z99Var = this.c;
            if ((z99Var == null || !z99Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                z99 z99Var2 = new z99(this.a, str, d(), str2);
                this.c = z99Var2;
                z99.c cVar = this.d;
                if (cVar != null) {
                    z99Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
