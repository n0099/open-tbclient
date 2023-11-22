package com.baidu.tieba;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class y7b {
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

    public static b8b b(d8b d8bVar, t7b t7bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, d8bVar, t7bVar)) == null) {
            if (d8bVar == null || t7bVar == null || d8bVar.e == null) {
                return null;
            }
            long[] a = a(d8bVar.b, d8bVar.a);
            MultiMediaData multiMediaData = d8bVar.e;
            b8b b8bVar = new b8b();
            b8bVar.e = new ArrayList();
            b8bVar.a = multiMediaData.path;
            b8bVar.c = d8bVar.c;
            b8bVar.d = d8bVar.d;
            b8bVar.b = multiMediaData.rotation;
            for (int i = 0; i < d8bVar.b; i++) {
                long j = multiMediaData.start + a[i];
                v7b v7bVar = new v7b();
                v7bVar.a = o7b.b(multiMediaData.path, j, multiMediaData.type);
                v7bVar.b = multiMediaData.path;
                v7bVar.f = i;
                v7bVar.g = multiMediaData.type;
                v7bVar.h = d8bVar.c;
                v7bVar.i = d8bVar.d;
                v7bVar.j = t7bVar;
                v7bVar.d = j;
                v7bVar.c = multiMediaData.rotation;
                b8bVar.e.add(v7bVar);
            }
            return b8bVar;
        }
        return (b8b) invokeLL.objValue;
    }

    public static List<b8b> c(c8b c8bVar, t7b t7bVar) {
        InterceptResult invokeLL;
        List<v7b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, c8bVar, t7bVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (c8bVar == null || t7bVar == null || c8bVar.b <= 0 || csb.e(c8bVar.e) || csb.e(c8bVar.f)) {
                return null;
            }
            long[] a = a(c8bVar.b, c8bVar.a);
            ArrayList arrayList = new ArrayList();
            b8b b8bVar = null;
            for (int i = 0; i < c8bVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(c8bVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) csb.c(c8bVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        b8bVar = new b8b();
                        b8bVar.e = new ArrayList();
                        b8bVar.a = multiMediaData2.path;
                        b8bVar.c = c8bVar.c;
                        b8bVar.d = c8bVar.d;
                        b8bVar.b = multiMediaData2.rotation;
                        arrayList.add(b8bVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) csb.c(c8bVar.e, findInputIndexInSegments), j) * 1000;
                    v7b v7bVar = new v7b();
                    v7bVar.a = o7b.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    v7bVar.b = multiMediaData2.path;
                    v7bVar.f = i;
                    v7bVar.g = multiMediaData2.type;
                    v7bVar.h = c8bVar.c;
                    v7bVar.i = c8bVar.d;
                    v7bVar.d = multiMediaDataSeekTime;
                    v7bVar.j = t7bVar;
                    v7bVar.c = multiMediaData2.rotation;
                    if (b8bVar != null && (list = b8bVar.e) != null) {
                        list.add(v7bVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
