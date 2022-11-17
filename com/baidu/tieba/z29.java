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
public class z29 {
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

    public static c39 b(e39 e39Var, u29 u29Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, e39Var, u29Var)) == null) {
            if (e39Var == null || u29Var == null || e39Var.e == null) {
                return null;
            }
            long[] a = a(e39Var.b, e39Var.a);
            MultiMediaData multiMediaData = e39Var.e;
            c39 c39Var = new c39();
            c39Var.e = new ArrayList();
            c39Var.a = multiMediaData.path;
            c39Var.c = e39Var.c;
            c39Var.d = e39Var.d;
            c39Var.b = multiMediaData.rotation;
            for (int i = 0; i < e39Var.b; i++) {
                long j = multiMediaData.start + a[i];
                w29 w29Var = new w29();
                w29Var.a = p29.b(multiMediaData.path, j, multiMediaData.type);
                w29Var.b = multiMediaData.path;
                w29Var.f = i;
                w29Var.g = multiMediaData.type;
                w29Var.h = e39Var.c;
                w29Var.i = e39Var.d;
                w29Var.j = u29Var;
                w29Var.d = j;
                w29Var.c = multiMediaData.rotation;
                c39Var.e.add(w29Var);
            }
            return c39Var;
        }
        return (c39) invokeLL.objValue;
    }

    public static List<c39> c(d39 d39Var, u29 u29Var) {
        InterceptResult invokeLL;
        List<w29> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, d39Var, u29Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (d39Var == null || u29Var == null || d39Var.b <= 0 || ij9.e(d39Var.e) || ij9.e(d39Var.f)) {
                return null;
            }
            long[] a = a(d39Var.b, d39Var.a);
            ArrayList arrayList = new ArrayList();
            c39 c39Var = null;
            for (int i = 0; i < d39Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(d39Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) ij9.c(d39Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        c39Var = new c39();
                        c39Var.e = new ArrayList();
                        c39Var.a = multiMediaData2.path;
                        c39Var.c = d39Var.c;
                        c39Var.d = d39Var.d;
                        c39Var.b = multiMediaData2.rotation;
                        arrayList.add(c39Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) ij9.c(d39Var.e, findInputIndexInSegments), j) * 1000;
                    w29 w29Var = new w29();
                    w29Var.a = p29.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    w29Var.b = multiMediaData2.path;
                    w29Var.f = i;
                    w29Var.g = multiMediaData2.type;
                    w29Var.h = d39Var.c;
                    w29Var.i = d39Var.d;
                    w29Var.d = multiMediaDataSeekTime;
                    w29Var.j = u29Var;
                    w29Var.c = multiMediaData2.rotation;
                    if (c39Var != null && (list = c39Var.e) != null) {
                        list.add(w29Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
