package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.yv8;
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
public class xv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public fw8 b;
    public yv8 c;
    public yv8.c d;

    public xv8(Context context) {
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

    public void h(fw8 fw8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fw8Var) == null) {
            this.b = fw8Var;
        }
    }

    public void i(yv8.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            yv8 yv8Var = this.c;
            if (yv8Var != null) {
                yv8Var.h(cVar);
            }
        }
    }

    public static void a(List list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new fw8(str, i, str2));
    }

    public static List c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f080571, context.getString(R.string.obfuscated_res_0x7f0f0643), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f080575, context.getString(R.string.obfuscated_res_0x7f0f0640), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f080578, context.getString(R.string.obfuscated_res_0x7f0f0644), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f080574, context.getString(R.string.obfuscated_res_0x7f0f063e), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056f, context.getString(R.string.obfuscated_res_0x7f0f063b), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057c, context.getString(R.string.obfuscated_res_0x7f0f0648), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056e, context.getString(R.string.obfuscated_res_0x7f0f063a), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f080576, context.getString(R.string.obfuscated_res_0x7f0f0641), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f080570, context.getString(R.string.obfuscated_res_0x7f0f063f), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056b, context.getString(R.string.obfuscated_res_0x7f0f0637), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f080572, context.getString(R.string.obfuscated_res_0x7f0f063c), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057a, context.getString(R.string.obfuscated_res_0x7f0f0646), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057b, context.getString(R.string.obfuscated_res_0x7f0f0647), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056d, context.getString(R.string.obfuscated_res_0x7f0f0639), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f080577, context.getString(R.string.obfuscated_res_0x7f0f0642), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f080573, context.getString(R.string.obfuscated_res_0x7f0f063d), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f080579, context.getString(R.string.obfuscated_res_0x7f0f0645), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056c, context.getString(R.string.obfuscated_res_0x7f0f0638), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return mv8.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fw8 fw8Var = this.b;
            if (fw8Var != null && !"normal".equalsIgnoreCase(fw8Var.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        yv8 yv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (yv8Var = this.c) != null) {
            yv8Var.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            yv8 yv8Var = this.c;
            if (yv8Var != null) {
                return yv8Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            yv8 yv8Var = this.c;
            if ((yv8Var == null || !yv8Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                yv8 yv8Var2 = new yv8(this.a, str, d(), str2);
                this.c = yv8Var2;
                yv8.c cVar = this.d;
                if (cVar != null) {
                    yv8Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
