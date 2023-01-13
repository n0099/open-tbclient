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
public class lb9 {
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

    public static ob9 b(qb9 qb9Var, gb9 gb9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, qb9Var, gb9Var)) == null) {
            if (qb9Var == null || gb9Var == null || qb9Var.e == null) {
                return null;
            }
            long[] a = a(qb9Var.b, qb9Var.a);
            MultiMediaData multiMediaData = qb9Var.e;
            ob9 ob9Var = new ob9();
            ob9Var.e = new ArrayList();
            ob9Var.a = multiMediaData.path;
            ob9Var.c = qb9Var.c;
            ob9Var.d = qb9Var.d;
            ob9Var.b = multiMediaData.rotation;
            for (int i = 0; i < qb9Var.b; i++) {
                long j = multiMediaData.start + a[i];
                ib9 ib9Var = new ib9();
                ib9Var.a = bb9.b(multiMediaData.path, j, multiMediaData.type);
                ib9Var.b = multiMediaData.path;
                ib9Var.f = i;
                ib9Var.g = multiMediaData.type;
                ib9Var.h = qb9Var.c;
                ib9Var.i = qb9Var.d;
                ib9Var.j = gb9Var;
                ib9Var.d = j;
                ib9Var.c = multiMediaData.rotation;
                ob9Var.e.add(ib9Var);
            }
            return ob9Var;
        }
        return (ob9) invokeLL.objValue;
    }

    public static List<ob9> c(pb9 pb9Var, gb9 gb9Var) {
        InterceptResult invokeLL;
        List<ib9> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pb9Var, gb9Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (pb9Var == null || gb9Var == null || pb9Var.b <= 0 || as9.e(pb9Var.e) || as9.e(pb9Var.f)) {
                return null;
            }
            long[] a = a(pb9Var.b, pb9Var.a);
            ArrayList arrayList = new ArrayList();
            ob9 ob9Var = null;
            for (int i = 0; i < pb9Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(pb9Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) as9.c(pb9Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        ob9Var = new ob9();
                        ob9Var.e = new ArrayList();
                        ob9Var.a = multiMediaData2.path;
                        ob9Var.c = pb9Var.c;
                        ob9Var.d = pb9Var.d;
                        ob9Var.b = multiMediaData2.rotation;
                        arrayList.add(ob9Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) as9.c(pb9Var.e, findInputIndexInSegments), j) * 1000;
                    ib9 ib9Var = new ib9();
                    ib9Var.a = bb9.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    ib9Var.b = multiMediaData2.path;
                    ib9Var.f = i;
                    ib9Var.g = multiMediaData2.type;
                    ib9Var.h = pb9Var.c;
                    ib9Var.i = pb9Var.d;
                    ib9Var.d = multiMediaDataSeekTime;
                    ib9Var.j = gb9Var;
                    ib9Var.c = multiMediaData2.rotation;
                    if (ob9Var != null && (list = ob9Var.e) != null) {
                        list.add(ib9Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
