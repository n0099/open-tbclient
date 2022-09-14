package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.zu8;
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
public class yu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public gv8 b;
    public zu8 c;
    public zu8.c d;

    public yu8(Context context) {
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

    public static void a(List<gv8> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65537, null, list, i, str, str2) == null) || list == null) {
            return;
        }
        list.add(new gv8(str, i, str2));
    }

    public static List<gv8> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f080570, context.getString(R.string.obfuscated_res_0x7f0f063a), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f080574, context.getString(R.string.obfuscated_res_0x7f0f0637), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f080577, context.getString(R.string.obfuscated_res_0x7f0f063b), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f080573, context.getString(R.string.obfuscated_res_0x7f0f0635), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056e, context.getString(R.string.obfuscated_res_0x7f0f0632), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057b, context.getString(R.string.obfuscated_res_0x7f0f063f), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056d, context.getString(R.string.obfuscated_res_0x7f0f0631), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f080575, context.getString(R.string.obfuscated_res_0x7f0f0638), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056f, context.getString(R.string.obfuscated_res_0x7f0f0636), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056a, context.getString(R.string.obfuscated_res_0x7f0f062e), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f080571, context.getString(R.string.obfuscated_res_0x7f0f0633), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f080579, context.getString(R.string.obfuscated_res_0x7f0f063d), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057a, context.getString(R.string.obfuscated_res_0x7f0f063e), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056c, context.getString(R.string.obfuscated_res_0x7f0f0630), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f080576, context.getString(R.string.obfuscated_res_0x7f0f0639), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f080572, context.getString(R.string.obfuscated_res_0x7f0f0634), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f080578, context.getString(R.string.obfuscated_res_0x7f0f063c), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056b, context.getString(R.string.obfuscated_res_0x7f0f062f), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return nu8.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            gv8 gv8Var = this.b;
            return (gv8Var == null || "normal".equalsIgnoreCase(gv8Var.c)) ? "" : this.b.c;
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        zu8 zu8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (zu8Var = this.c) == null) {
            return;
        }
        zu8Var.e();
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            zu8 zu8Var = this.c;
            if (zu8Var != null) {
                return zu8Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            zu8 zu8Var = this.c;
            if ((zu8Var == null || !zu8Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                zu8 zu8Var2 = new zu8(this.a, str, d(), str2);
                this.c = zu8Var2;
                zu8.c cVar = this.d;
                if (cVar != null) {
                    zu8Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }

    public void h(gv8 gv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gv8Var) == null) {
            this.b = gv8Var;
        }
    }

    public void i(zu8.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            zu8 zu8Var = this.c;
            if (zu8Var != null) {
                zu8Var.h(cVar);
            }
        }
    }
}
