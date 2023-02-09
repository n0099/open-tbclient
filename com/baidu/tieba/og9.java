package com.baidu.tieba;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class og9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long[] a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (i < 0) {
                i = 0;
            }
            float[] fArr = new float[i];
            if (i > 1) {
                float f = 1.0f / i;
                int i2 = 0;
                while (i2 < i) {
                    int i3 = i2 + 1;
                    if (i3 == i) {
                        int i4 = i2 - 1;
                        fArr[i2] = fArr[i4] + ((1.0f - fArr[i4]) / 2.0f);
                    } else {
                        fArr[i2] = i3 * f;
                    }
                    i2 = i3;
                }
            } else if (i == 1) {
                fArr[0] = 0.5f;
            }
            long[] jArr = new long[i];
            for (int i5 = 0; i5 < i; i5++) {
                jArr[i5] = fArr[i5] * ((float) j) * 1000.0f;
            }
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static rg9 b(tg9 tg9Var, jg9 jg9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tg9Var, jg9Var)) == null) {
            if (tg9Var == null || jg9Var == null || tg9Var.e == null) {
                return null;
            }
            long[] a = a(tg9Var.b, tg9Var.a);
            MultiMediaData multiMediaData = tg9Var.e;
            rg9 rg9Var = new rg9();
            rg9Var.e = new ArrayList();
            rg9Var.a = multiMediaData.path;
            rg9Var.c = tg9Var.c;
            rg9Var.d = tg9Var.d;
            rg9Var.b = multiMediaData.rotation;
            for (int i = 0; i < tg9Var.b; i++) {
                long j = multiMediaData.start + a[i];
                lg9 lg9Var = new lg9();
                lg9Var.a = eg9.b(multiMediaData.path, j, multiMediaData.type);
                lg9Var.b = multiMediaData.path;
                lg9Var.f = i;
                lg9Var.g = multiMediaData.type;
                lg9Var.h = tg9Var.c;
                lg9Var.i = tg9Var.d;
                lg9Var.j = jg9Var;
                lg9Var.d = j;
                lg9Var.c = multiMediaData.rotation;
                rg9Var.e.add(lg9Var);
            }
            return rg9Var;
        }
        return (rg9) invokeLL.objValue;
    }

    public static List<rg9> c(sg9 sg9Var, jg9 jg9Var) {
        InterceptResult invokeLL;
        List<lg9> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, sg9Var, jg9Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (sg9Var == null || jg9Var == null || sg9Var.b <= 0 || lx9.e(sg9Var.e) || lx9.e(sg9Var.f)) {
                return null;
            }
            long[] a = a(sg9Var.b, sg9Var.a);
            ArrayList arrayList = new ArrayList();
            rg9 rg9Var = null;
            for (int i = 0; i < sg9Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(sg9Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) lx9.c(sg9Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        rg9Var = new rg9();
                        rg9Var.e = new ArrayList();
                        rg9Var.a = multiMediaData2.path;
                        rg9Var.c = sg9Var.c;
                        rg9Var.d = sg9Var.d;
                        rg9Var.b = multiMediaData2.rotation;
                        arrayList.add(rg9Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) lx9.c(sg9Var.e, findInputIndexInSegments), j) * 1000;
                    lg9 lg9Var = new lg9();
                    lg9Var.a = eg9.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    lg9Var.b = multiMediaData2.path;
                    lg9Var.f = i;
                    lg9Var.g = multiMediaData2.type;
                    lg9Var.h = sg9Var.c;
                    lg9Var.i = sg9Var.d;
                    lg9Var.d = multiMediaDataSeekTime;
                    lg9Var.j = jg9Var;
                    lg9Var.c = multiMediaData2.rotation;
                    if (rg9Var != null && (list = rg9Var.e) != null) {
                        list.add(lg9Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
