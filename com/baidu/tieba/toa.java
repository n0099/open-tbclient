package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.uoa;
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
public class toa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public bpa b;
    public uoa c;
    public uoa.c d;

    public toa(Context context) {
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

    public void h(bpa bpaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bpaVar) == null) {
            this.b = bpaVar;
        }
    }

    public void i(uoa.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            uoa uoaVar = this.c;
            if (uoaVar != null) {
                uoaVar.h(cVar);
            }
        }
    }

    public static void a(List<bpa> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new bpa(str, i, str2));
    }

    public static List<bpa> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b5, context.getString(R.string.obfuscated_res_0x7f0f0750), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b9, context.getString(R.string.obfuscated_res_0x7f0f074d), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806bc, context.getString(R.string.obfuscated_res_0x7f0f0751), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b8, context.getString(R.string.obfuscated_res_0x7f0f074b), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b3, context.getString(R.string.obfuscated_res_0x7f0f0748), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806c0, context.getString(R.string.obfuscated_res_0x7f0f0755), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b2, context.getString(R.string.obfuscated_res_0x7f0f0747), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ba, context.getString(R.string.obfuscated_res_0x7f0f074e), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b4, context.getString(R.string.obfuscated_res_0x7f0f074c), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806af, context.getString(R.string.obfuscated_res_0x7f0f0744), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b6, context.getString(R.string.obfuscated_res_0x7f0f0749), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806be, context.getString(R.string.obfuscated_res_0x7f0f0753), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806bf, context.getString(R.string.obfuscated_res_0x7f0f0754), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b1, context.getString(R.string.obfuscated_res_0x7f0f0746), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806bb, context.getString(R.string.obfuscated_res_0x7f0f074f), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b7, context.getString(R.string.obfuscated_res_0x7f0f074a), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806bd, context.getString(R.string.obfuscated_res_0x7f0f0752), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b0, context.getString(R.string.obfuscated_res_0x7f0f0745), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return ioa.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bpa bpaVar = this.b;
            if (bpaVar != null && !"normal".equalsIgnoreCase(bpaVar.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        uoa uoaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (uoaVar = this.c) != null) {
            uoaVar.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            uoa uoaVar = this.c;
            if (uoaVar != null) {
                return uoaVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            uoa uoaVar = this.c;
            if ((uoaVar == null || !uoaVar.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                uoa uoaVar2 = new uoa(this.a, str, d(), str2);
                this.c = uoaVar2;
                uoa.c cVar = this.d;
                if (cVar != null) {
                    uoaVar2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
