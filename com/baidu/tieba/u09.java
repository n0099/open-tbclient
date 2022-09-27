package com.baidu.tieba;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class u09 {
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

    public static x09 b(z09 z09Var, p09 p09Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, z09Var, p09Var)) == null) {
            if (z09Var == null || p09Var == null || z09Var.e == null) {
                return null;
            }
            long[] a = a(z09Var.b, z09Var.a);
            MultiMediaData multiMediaData = z09Var.e;
            x09 x09Var = new x09();
            x09Var.e = new ArrayList();
            x09Var.a = multiMediaData.path;
            x09Var.c = z09Var.c;
            x09Var.d = z09Var.d;
            x09Var.b = multiMediaData.rotation;
            for (int i = 0; i < z09Var.b; i++) {
                long j = multiMediaData.start + a[i];
                r09 r09Var = new r09();
                r09Var.a = k09.b(multiMediaData.path, j, multiMediaData.type);
                r09Var.b = multiMediaData.path;
                r09Var.f = i;
                r09Var.g = multiMediaData.type;
                r09Var.h = z09Var.c;
                r09Var.i = z09Var.d;
                r09Var.j = p09Var;
                r09Var.d = j;
                r09Var.c = multiMediaData.rotation;
                x09Var.e.add(r09Var);
            }
            return x09Var;
        }
        return (x09) invokeLL.objValue;
    }

    public static List<x09> c(y09 y09Var, p09 p09Var) {
        InterceptResult invokeLL;
        List<r09> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, y09Var, p09Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (y09Var == null || p09Var == null || y09Var.b <= 0 || vg9.e(y09Var.e) || vg9.e(y09Var.f)) {
                return null;
            }
            long[] a = a(y09Var.b, y09Var.a);
            ArrayList arrayList = new ArrayList();
            x09 x09Var = null;
            for (int i = 0; i < y09Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(y09Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) vg9.c(y09Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        x09Var = new x09();
                        x09Var.e = new ArrayList();
                        x09Var.a = multiMediaData2.path;
                        x09Var.c = y09Var.c;
                        x09Var.d = y09Var.d;
                        x09Var.b = multiMediaData2.rotation;
                        arrayList.add(x09Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) vg9.c(y09Var.e, findInputIndexInSegments), j) * 1000;
                    r09 r09Var = new r09();
                    r09Var.a = k09.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    r09Var.b = multiMediaData2.path;
                    r09Var.f = i;
                    r09Var.g = multiMediaData2.type;
                    r09Var.h = y09Var.c;
                    r09Var.i = y09Var.d;
                    r09Var.d = multiMediaDataSeekTime;
                    r09Var.j = p09Var;
                    r09Var.c = multiMediaData2.rotation;
                    if (x09Var != null && (list = x09Var.e) != null) {
                        list.add(r09Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
