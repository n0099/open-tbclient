package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.te9;
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
public class se9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public af9 b;
    public te9 c;
    public te9.c d;

    public se9(Context context) {
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

    public void h(af9 af9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, af9Var) == null) {
            this.b = af9Var;
        }
    }

    public void i(te9.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            te9 te9Var = this.c;
            if (te9Var != null) {
                te9Var.h(cVar);
            }
        }
    }

    public static void a(List<af9> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new af9(str, i, str2));
    }

    public static List<af9> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f080592, context.getString(R.string.obfuscated_res_0x7f0f0685), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f080596, context.getString(R.string.obfuscated_res_0x7f0f0682), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f080599, context.getString(R.string.obfuscated_res_0x7f0f0686), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f080595, context.getString(R.string.obfuscated_res_0x7f0f0680), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f080590, context.getString(R.string.obfuscated_res_0x7f0f067d), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059d, context.getString(R.string.obfuscated_res_0x7f0f068a), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058f, context.getString(R.string.obfuscated_res_0x7f0f067c), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f080597, context.getString(R.string.obfuscated_res_0x7f0f0683), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f080591, context.getString(R.string.obfuscated_res_0x7f0f0681), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058c, context.getString(R.string.obfuscated_res_0x7f0f0679), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f080593, context.getString(R.string.obfuscated_res_0x7f0f067e), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059b, context.getString(R.string.obfuscated_res_0x7f0f0688), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059c, context.getString(R.string.obfuscated_res_0x7f0f0689), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058e, context.getString(R.string.obfuscated_res_0x7f0f067b), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f080598, context.getString(R.string.obfuscated_res_0x7f0f0684), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f080594, context.getString(R.string.obfuscated_res_0x7f0f067f), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059a, context.getString(R.string.obfuscated_res_0x7f0f0687), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058d, context.getString(R.string.obfuscated_res_0x7f0f067a), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return he9.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            af9 af9Var = this.b;
            if (af9Var != null && !"normal".equalsIgnoreCase(af9Var.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        te9 te9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (te9Var = this.c) != null) {
            te9Var.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            te9 te9Var = this.c;
            if (te9Var != null) {
                return te9Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            te9 te9Var = this.c;
            if ((te9Var == null || !te9Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                te9 te9Var2 = new te9(this.a, str, d(), str2);
                this.c = te9Var2;
                te9.c cVar = this.d;
                if (cVar != null) {
                    te9Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
