package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ov8;
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
/* loaded from: classes5.dex */
public class nv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public vv8 b;
    public ov8 c;
    public ov8.c d;

    public nv8(Context context) {
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

    public static void a(List<vv8> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65537, null, list, i, str, str2) == null) || list == null) {
            return;
        }
        list.add(new vv8(str, i, str2));
    }

    public static List<vv8> c(Context context) {
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
            return cv8.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            vv8 vv8Var = this.b;
            return (vv8Var == null || "normal".equalsIgnoreCase(vv8Var.c)) ? "" : this.b.c;
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        ov8 ov8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (ov8Var = this.c) == null) {
            return;
        }
        ov8Var.e();
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ov8 ov8Var = this.c;
            if (ov8Var != null) {
                return ov8Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            ov8 ov8Var = this.c;
            if ((ov8Var == null || !ov8Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                ov8 ov8Var2 = new ov8(this.a, str, d(), str2);
                this.c = ov8Var2;
                ov8.c cVar = this.d;
                if (cVar != null) {
                    ov8Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }

    public void h(vv8 vv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vv8Var) == null) {
            this.b = vv8Var;
        }
    }

    public void i(ov8.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            ov8 ov8Var = this.c;
            if (ov8Var != null) {
                ov8Var.h(cVar);
            }
        }
    }
}
