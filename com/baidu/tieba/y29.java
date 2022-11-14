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
public class y29 {
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

    public static b39 b(d39 d39Var, t29 t29Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, d39Var, t29Var)) == null) {
            if (d39Var == null || t29Var == null || d39Var.e == null) {
                return null;
            }
            long[] a = a(d39Var.b, d39Var.a);
            MultiMediaData multiMediaData = d39Var.e;
            b39 b39Var = new b39();
            b39Var.e = new ArrayList();
            b39Var.a = multiMediaData.path;
            b39Var.c = d39Var.c;
            b39Var.d = d39Var.d;
            b39Var.b = multiMediaData.rotation;
            for (int i = 0; i < d39Var.b; i++) {
                long j = multiMediaData.start + a[i];
                v29 v29Var = new v29();
                v29Var.a = o29.b(multiMediaData.path, j, multiMediaData.type);
                v29Var.b = multiMediaData.path;
                v29Var.f = i;
                v29Var.g = multiMediaData.type;
                v29Var.h = d39Var.c;
                v29Var.i = d39Var.d;
                v29Var.j = t29Var;
                v29Var.d = j;
                v29Var.c = multiMediaData.rotation;
                b39Var.e.add(v29Var);
            }
            return b39Var;
        }
        return (b39) invokeLL.objValue;
    }

    public static List<b39> c(c39 c39Var, t29 t29Var) {
        InterceptResult invokeLL;
        List<v29> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, c39Var, t29Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (c39Var == null || t29Var == null || c39Var.b <= 0 || hj9.e(c39Var.e) || hj9.e(c39Var.f)) {
                return null;
            }
            long[] a = a(c39Var.b, c39Var.a);
            ArrayList arrayList = new ArrayList();
            b39 b39Var = null;
            for (int i = 0; i < c39Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(c39Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) hj9.c(c39Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        b39Var = new b39();
                        b39Var.e = new ArrayList();
                        b39Var.a = multiMediaData2.path;
                        b39Var.c = c39Var.c;
                        b39Var.d = c39Var.d;
                        b39Var.b = multiMediaData2.rotation;
                        arrayList.add(b39Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) hj9.c(c39Var.e, findInputIndexInSegments), j) * 1000;
                    v29 v29Var = new v29();
                    v29Var.a = o29.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    v29Var.b = multiMediaData2.path;
                    v29Var.f = i;
                    v29Var.g = multiMediaData2.type;
                    v29Var.h = c39Var.c;
                    v29Var.i = c39Var.d;
                    v29Var.d = multiMediaDataSeekTime;
                    v29Var.j = t29Var;
                    v29Var.c = multiMediaData2.rotation;
                    if (b39Var != null && (list = b39Var.e) != null) {
                        list.add(v29Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
