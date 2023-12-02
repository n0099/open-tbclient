package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r6b;
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
public class q6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public y6b b;
    public r6b c;
    public r6b.c d;

    public q6b(Context context) {
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

    public void h(y6b y6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, y6bVar) == null) {
            this.b = y6bVar;
        }
    }

    public void i(r6b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            r6b r6bVar = this.c;
            if (r6bVar != null) {
                r6bVar.h(cVar);
            }
        }
    }

    public static void a(List<y6b> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new y6b(str, i, str2));
    }

    public static List<y6b> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c1, context.getString(R.string.obfuscated_res_0x7f0f075a), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c5, context.getString(R.string.obfuscated_res_0x7f0f0757), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c8, context.getString(R.string.obfuscated_res_0x7f0f075b), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c4, context.getString(R.string.obfuscated_res_0x7f0f0755), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806bf, context.getString(R.string.obfuscated_res_0x7f0f0752), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806cc, context.getString(R.string.obfuscated_res_0x7f0f075f), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806be, context.getString(R.string.obfuscated_res_0x7f0f0751), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c6, context.getString(R.string.obfuscated_res_0x7f0f0758), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c0, context.getString(R.string.obfuscated_res_0x7f0f0756), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806bb, context.getString(R.string.obfuscated_res_0x7f0f074e), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c2, context.getString(R.string.obfuscated_res_0x7f0f0753), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ca, context.getString(R.string.obfuscated_res_0x7f0f075d), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806cb, context.getString(R.string.obfuscated_res_0x7f0f075e), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806bd, context.getString(R.string.obfuscated_res_0x7f0f0750), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c7, context.getString(R.string.obfuscated_res_0x7f0f0759), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c3, context.getString(R.string.obfuscated_res_0x7f0f0754), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c9, context.getString(R.string.obfuscated_res_0x7f0f075c), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806bc, context.getString(R.string.obfuscated_res_0x7f0f074f), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return f6b.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            y6b y6bVar = this.b;
            if (y6bVar != null && !"normal".equalsIgnoreCase(y6bVar.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        r6b r6bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (r6bVar = this.c) != null) {
            r6bVar.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            r6b r6bVar = this.c;
            if (r6bVar != null) {
                return r6bVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            r6b r6bVar = this.c;
            if ((r6bVar == null || !r6bVar.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                r6b r6bVar2 = new r6b(this.a, str, d(), str2);
                this.c = r6bVar2;
                r6b.c cVar = this.d;
                if (cVar != null) {
                    r6bVar2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
