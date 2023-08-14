package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pla;
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
public class ola {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public wla b;
    public pla c;
    public pla.c d;

    public ola(Context context) {
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

    public void h(wla wlaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wlaVar) == null) {
            this.b = wlaVar;
        }
    }

    public void i(pla.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            pla plaVar = this.c;
            if (plaVar != null) {
                plaVar.h(cVar);
            }
        }
    }

    public static void a(List<wla> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new wla(str, i, str2));
    }

    public static List<wla> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a4, context.getString(R.string.obfuscated_res_0x7f0f073f), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a8, context.getString(R.string.obfuscated_res_0x7f0f073c), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ab, context.getString(R.string.obfuscated_res_0x7f0f0740), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a7, context.getString(R.string.obfuscated_res_0x7f0f073a), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a2, context.getString(R.string.obfuscated_res_0x7f0f0737), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806af, context.getString(R.string.obfuscated_res_0x7f0f0744), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a1, context.getString(R.string.obfuscated_res_0x7f0f0736), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a9, context.getString(R.string.obfuscated_res_0x7f0f073d), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a3, context.getString(R.string.obfuscated_res_0x7f0f073b), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f08069e, context.getString(R.string.obfuscated_res_0x7f0f0733), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a5, context.getString(R.string.obfuscated_res_0x7f0f0738), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ad, context.getString(R.string.obfuscated_res_0x7f0f0742), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ae, context.getString(R.string.obfuscated_res_0x7f0f0743), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a0, context.getString(R.string.obfuscated_res_0x7f0f0735), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806aa, context.getString(R.string.obfuscated_res_0x7f0f073e), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a6, context.getString(R.string.obfuscated_res_0x7f0f0739), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ac, context.getString(R.string.obfuscated_res_0x7f0f0741), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f08069f, context.getString(R.string.obfuscated_res_0x7f0f0734), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return dla.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wla wlaVar = this.b;
            if (wlaVar != null && !"normal".equalsIgnoreCase(wlaVar.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        pla plaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (plaVar = this.c) != null) {
            plaVar.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            pla plaVar = this.c;
            if (plaVar != null) {
                return plaVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            pla plaVar = this.c;
            if ((plaVar == null || !plaVar.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                pla plaVar2 = new pla(this.a, str, d(), str2);
                this.c = plaVar2;
                pla.c cVar = this.d;
                if (cVar != null) {
                    plaVar2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
