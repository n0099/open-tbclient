package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.y0a;
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
/* loaded from: classes8.dex */
public class x0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public f1a b;
    public y0a c;
    public y0a.c d;

    public x0a(Context context) {
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

    public void h(f1a f1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, f1aVar) == null) {
            this.b = f1aVar;
        }
    }

    public void i(y0a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            y0a y0aVar = this.c;
            if (y0aVar != null) {
                y0aVar.h(cVar);
            }
        }
    }

    public static void a(List<f1a> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new f1a(str, i, str2));
    }

    public static List<f1a> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f08067d, context.getString(R.string.obfuscated_res_0x7f0f06fb), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f080681, context.getString(R.string.obfuscated_res_0x7f0f06f8), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f080684, context.getString(R.string.obfuscated_res_0x7f0f06fc), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f080680, context.getString(R.string.obfuscated_res_0x7f0f06f6), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f08067b, context.getString(R.string.obfuscated_res_0x7f0f06f3), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f080688, context.getString(R.string.obfuscated_res_0x7f0f0700), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f08067a, context.getString(R.string.obfuscated_res_0x7f0f06f2), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f080682, context.getString(R.string.obfuscated_res_0x7f0f06f9), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f08067c, context.getString(R.string.obfuscated_res_0x7f0f06f7), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f080677, context.getString(R.string.obfuscated_res_0x7f0f06ef), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f08067e, context.getString(R.string.obfuscated_res_0x7f0f06f4), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f080686, context.getString(R.string.obfuscated_res_0x7f0f06fe), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f080687, context.getString(R.string.obfuscated_res_0x7f0f06ff), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f080679, context.getString(R.string.obfuscated_res_0x7f0f06f1), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f080683, context.getString(R.string.obfuscated_res_0x7f0f06fa), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f08067f, context.getString(R.string.obfuscated_res_0x7f0f06f5), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f080685, context.getString(R.string.obfuscated_res_0x7f0f06fd), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f080678, context.getString(R.string.obfuscated_res_0x7f0f06f0), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return m0a.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            f1a f1aVar = this.b;
            if (f1aVar != null && !"normal".equalsIgnoreCase(f1aVar.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        y0a y0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (y0aVar = this.c) != null) {
            y0aVar.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            y0a y0aVar = this.c;
            if (y0aVar != null) {
                return y0aVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            y0a y0aVar = this.c;
            if ((y0aVar == null || !y0aVar.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                y0a y0aVar2 = new y0a(this.a, str, d(), str2);
                this.c = y0aVar2;
                y0a.c cVar = this.d;
                if (cVar != null) {
                    y0aVar2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
