package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.a69;
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
public class z59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public h69 b;
    public a69 c;
    public a69.c d;

    public z59(Context context) {
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

    public void h(h69 h69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h69Var) == null) {
            this.b = h69Var;
        }
    }

    public void i(a69.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            a69 a69Var = this.c;
            if (a69Var != null) {
                a69Var.h(cVar);
            }
        }
    }

    public static void a(List<h69> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new h69(str, i, str2));
    }

    public static List<h69> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f08058b, context.getString(R.string.obfuscated_res_0x7f0f0656), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058f, context.getString(R.string.obfuscated_res_0x7f0f0653), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f080592, context.getString(R.string.obfuscated_res_0x7f0f0657), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058e, context.getString(R.string.obfuscated_res_0x7f0f0651), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f080589, context.getString(R.string.obfuscated_res_0x7f0f064e), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f080596, context.getString(R.string.obfuscated_res_0x7f0f065b), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f080588, context.getString(R.string.obfuscated_res_0x7f0f064d), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f080590, context.getString(R.string.obfuscated_res_0x7f0f0654), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058a, context.getString(R.string.obfuscated_res_0x7f0f0652), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f080585, context.getString(R.string.obfuscated_res_0x7f0f064a), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058c, context.getString(R.string.obfuscated_res_0x7f0f064f), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f080594, context.getString(R.string.obfuscated_res_0x7f0f0659), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f080595, context.getString(R.string.obfuscated_res_0x7f0f065a), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f080587, context.getString(R.string.obfuscated_res_0x7f0f064c), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f080591, context.getString(R.string.obfuscated_res_0x7f0f0655), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058d, context.getString(R.string.obfuscated_res_0x7f0f0650), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f080593, context.getString(R.string.obfuscated_res_0x7f0f0658), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f080586, context.getString(R.string.obfuscated_res_0x7f0f064b), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return o59.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            h69 h69Var = this.b;
            if (h69Var != null && !"normal".equalsIgnoreCase(h69Var.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        a69 a69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (a69Var = this.c) != null) {
            a69Var.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a69 a69Var = this.c;
            if (a69Var != null) {
                return a69Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            a69 a69Var = this.c;
            if ((a69Var == null || !a69Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                a69 a69Var2 = new a69(this.a, str, d(), str2);
                this.c = a69Var2;
                a69.c cVar = this.d;
                if (cVar != null) {
                    a69Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
