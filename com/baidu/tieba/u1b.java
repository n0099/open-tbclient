package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.v1b;
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
public class u1b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public c2b b;
    public v1b c;
    public v1b.c d;

    public u1b(Context context) {
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

    public void h(c2b c2bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c2bVar) == null) {
            this.b = c2bVar;
        }
    }

    public void i(v1b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            v1b v1bVar = this.c;
            if (v1bVar != null) {
                v1bVar.h(cVar);
            }
        }
    }

    public static void a(List<c2b> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new c2b(str, i, str2));
    }

    public static List<c2b> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f0806be, context.getString(R.string.obfuscated_res_0x7f0f0752), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c2, context.getString(R.string.obfuscated_res_0x7f0f074f), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c5, context.getString(R.string.obfuscated_res_0x7f0f0753), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c1, context.getString(R.string.obfuscated_res_0x7f0f074d), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806bc, context.getString(R.string.obfuscated_res_0x7f0f074a), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c9, context.getString(R.string.obfuscated_res_0x7f0f0757), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806bb, context.getString(R.string.obfuscated_res_0x7f0f0749), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c3, context.getString(R.string.obfuscated_res_0x7f0f0750), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806bd, context.getString(R.string.obfuscated_res_0x7f0f074e), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b8, context.getString(R.string.obfuscated_res_0x7f0f0746), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806bf, context.getString(R.string.obfuscated_res_0x7f0f074b), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c7, context.getString(R.string.obfuscated_res_0x7f0f0755), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c8, context.getString(R.string.obfuscated_res_0x7f0f0756), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ba, context.getString(R.string.obfuscated_res_0x7f0f0748), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c4, context.getString(R.string.obfuscated_res_0x7f0f0751), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c0, context.getString(R.string.obfuscated_res_0x7f0f074c), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c6, context.getString(R.string.obfuscated_res_0x7f0f0754), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b9, context.getString(R.string.obfuscated_res_0x7f0f0747), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return j1b.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c2b c2bVar = this.b;
            if (c2bVar != null && !"normal".equalsIgnoreCase(c2bVar.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        v1b v1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (v1bVar = this.c) != null) {
            v1bVar.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            v1b v1bVar = this.c;
            if (v1bVar != null) {
                return v1bVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            v1b v1bVar = this.c;
            if ((v1bVar == null || !v1bVar.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                v1b v1bVar2 = new v1b(this.a, str, d(), str2);
                this.c = v1bVar2;
                v1b.c cVar = this.d;
                if (cVar != null) {
                    v1bVar2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
