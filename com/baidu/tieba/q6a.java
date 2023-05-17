package com.baidu.tieba;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class q6a {
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

    public static t6a b(v6a v6aVar, l6a l6aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, v6aVar, l6aVar)) == null) {
            if (v6aVar == null || l6aVar == null || v6aVar.e == null) {
                return null;
            }
            long[] a = a(v6aVar.b, v6aVar.a);
            MultiMediaData multiMediaData = v6aVar.e;
            t6a t6aVar = new t6a();
            t6aVar.e = new ArrayList();
            t6aVar.a = multiMediaData.path;
            t6aVar.c = v6aVar.c;
            t6aVar.d = v6aVar.d;
            t6aVar.b = multiMediaData.rotation;
            for (int i = 0; i < v6aVar.b; i++) {
                long j = multiMediaData.start + a[i];
                n6a n6aVar = new n6a();
                n6aVar.a = g6a.b(multiMediaData.path, j, multiMediaData.type);
                n6aVar.b = multiMediaData.path;
                n6aVar.f = i;
                n6aVar.g = multiMediaData.type;
                n6aVar.h = v6aVar.c;
                n6aVar.i = v6aVar.d;
                n6aVar.j = l6aVar;
                n6aVar.d = j;
                n6aVar.c = multiMediaData.rotation;
                t6aVar.e.add(n6aVar);
            }
            return t6aVar;
        }
        return (t6a) invokeLL.objValue;
    }

    public static List<t6a> c(u6a u6aVar, l6a l6aVar) {
        InterceptResult invokeLL;
        List<n6a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, u6aVar, l6aVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (u6aVar == null || l6aVar == null || u6aVar.b <= 0 || kna.e(u6aVar.e) || kna.e(u6aVar.f)) {
                return null;
            }
            long[] a = a(u6aVar.b, u6aVar.a);
            ArrayList arrayList = new ArrayList();
            t6a t6aVar = null;
            for (int i = 0; i < u6aVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(u6aVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) kna.c(u6aVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        t6aVar = new t6a();
                        t6aVar.e = new ArrayList();
                        t6aVar.a = multiMediaData2.path;
                        t6aVar.c = u6aVar.c;
                        t6aVar.d = u6aVar.d;
                        t6aVar.b = multiMediaData2.rotation;
                        arrayList.add(t6aVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) kna.c(u6aVar.e, findInputIndexInSegments), j) * 1000;
                    n6a n6aVar = new n6a();
                    n6aVar.a = g6a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    n6aVar.b = multiMediaData2.path;
                    n6aVar.f = i;
                    n6aVar.g = multiMediaData2.type;
                    n6aVar.h = u6aVar.c;
                    n6aVar.i = u6aVar.d;
                    n6aVar.d = multiMediaDataSeekTime;
                    n6aVar.j = l6aVar;
                    n6aVar.c = multiMediaData2.rotation;
                    if (t6aVar != null && (list = t6aVar.e) != null) {
                        list.add(n6aVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
