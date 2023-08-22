package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ypa;
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
public class xpa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public fqa b;
    public ypa c;
    public ypa.c d;

    public xpa(Context context) {
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

    public void h(fqa fqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fqaVar) == null) {
            this.b = fqaVar;
        }
    }

    public void i(ypa.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            ypa ypaVar = this.c;
            if (ypaVar != null) {
                ypaVar.h(cVar);
            }
        }
    }

    public static void a(List<fqa> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new fqa(str, i, str2));
    }

    public static List<fqa> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a9, context.getString(R.string.obfuscated_res_0x7f0f0747), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ad, context.getString(R.string.obfuscated_res_0x7f0f0744), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b0, context.getString(R.string.obfuscated_res_0x7f0f0748), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ac, context.getString(R.string.obfuscated_res_0x7f0f0742), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a7, context.getString(R.string.obfuscated_res_0x7f0f073f), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b4, context.getString(R.string.obfuscated_res_0x7f0f074c), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a6, context.getString(R.string.obfuscated_res_0x7f0f073e), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ae, context.getString(R.string.obfuscated_res_0x7f0f0745), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a8, context.getString(R.string.obfuscated_res_0x7f0f0743), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a3, context.getString(R.string.obfuscated_res_0x7f0f073b), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806aa, context.getString(R.string.obfuscated_res_0x7f0f0740), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b2, context.getString(R.string.obfuscated_res_0x7f0f074a), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b3, context.getString(R.string.obfuscated_res_0x7f0f074b), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a5, context.getString(R.string.obfuscated_res_0x7f0f073d), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806af, context.getString(R.string.obfuscated_res_0x7f0f0746), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ab, context.getString(R.string.obfuscated_res_0x7f0f0741), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806b1, context.getString(R.string.obfuscated_res_0x7f0f0749), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a4, context.getString(R.string.obfuscated_res_0x7f0f073c), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return mpa.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fqa fqaVar = this.b;
            if (fqaVar != null && !"normal".equalsIgnoreCase(fqaVar.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        ypa ypaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ypaVar = this.c) != null) {
            ypaVar.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ypa ypaVar = this.c;
            if (ypaVar != null) {
                return ypaVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            ypa ypaVar = this.c;
            if ((ypaVar == null || !ypaVar.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                ypa ypaVar2 = new ypa(this.a, str, d(), str2);
                this.c = ypaVar2;
                ypa.c cVar = this.d;
                if (cVar != null) {
                    ypaVar2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
