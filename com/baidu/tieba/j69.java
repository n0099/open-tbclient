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
public class j69 {
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

    public static m69 b(o69 o69Var, e69 e69Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, o69Var, e69Var)) == null) {
            if (o69Var == null || e69Var == null || o69Var.e == null) {
                return null;
            }
            long[] a = a(o69Var.b, o69Var.a);
            MultiMediaData multiMediaData = o69Var.e;
            m69 m69Var = new m69();
            m69Var.e = new ArrayList();
            m69Var.a = multiMediaData.path;
            m69Var.c = o69Var.c;
            m69Var.d = o69Var.d;
            m69Var.b = multiMediaData.rotation;
            for (int i = 0; i < o69Var.b; i++) {
                long j = multiMediaData.start + a[i];
                g69 g69Var = new g69();
                g69Var.a = z59.b(multiMediaData.path, j, multiMediaData.type);
                g69Var.b = multiMediaData.path;
                g69Var.f = i;
                g69Var.g = multiMediaData.type;
                g69Var.h = o69Var.c;
                g69Var.i = o69Var.d;
                g69Var.j = e69Var;
                g69Var.d = j;
                g69Var.c = multiMediaData.rotation;
                m69Var.e.add(g69Var);
            }
            return m69Var;
        }
        return (m69) invokeLL.objValue;
    }

    public static List<m69> c(n69 n69Var, e69 e69Var) {
        InterceptResult invokeLL;
        List<g69> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, n69Var, e69Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (n69Var == null || e69Var == null || n69Var.b <= 0 || sm9.e(n69Var.e) || sm9.e(n69Var.f)) {
                return null;
            }
            long[] a = a(n69Var.b, n69Var.a);
            ArrayList arrayList = new ArrayList();
            m69 m69Var = null;
            for (int i = 0; i < n69Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(n69Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) sm9.c(n69Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        m69Var = new m69();
                        m69Var.e = new ArrayList();
                        m69Var.a = multiMediaData2.path;
                        m69Var.c = n69Var.c;
                        m69Var.d = n69Var.d;
                        m69Var.b = multiMediaData2.rotation;
                        arrayList.add(m69Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) sm9.c(n69Var.e, findInputIndexInSegments), j) * 1000;
                    g69 g69Var = new g69();
                    g69Var.a = z59.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    g69Var.b = multiMediaData2.path;
                    g69Var.f = i;
                    g69Var.g = multiMediaData2.type;
                    g69Var.h = n69Var.c;
                    g69Var.i = n69Var.d;
                    g69Var.d = multiMediaDataSeekTime;
                    g69Var.j = e69Var;
                    g69Var.c = multiMediaData2.rotation;
                    if (m69Var != null && (list = m69Var.e) != null) {
                        list.add(g69Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
