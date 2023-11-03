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
public class x7b {
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

    public static a8b b(c8b c8bVar, s7b s7bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, c8bVar, s7bVar)) == null) {
            if (c8bVar == null || s7bVar == null || c8bVar.e == null) {
                return null;
            }
            long[] a = a(c8bVar.b, c8bVar.a);
            MultiMediaData multiMediaData = c8bVar.e;
            a8b a8bVar = new a8b();
            a8bVar.e = new ArrayList();
            a8bVar.a = multiMediaData.path;
            a8bVar.c = c8bVar.c;
            a8bVar.d = c8bVar.d;
            a8bVar.b = multiMediaData.rotation;
            for (int i = 0; i < c8bVar.b; i++) {
                long j = multiMediaData.start + a[i];
                u7b u7bVar = new u7b();
                u7bVar.a = n7b.b(multiMediaData.path, j, multiMediaData.type);
                u7bVar.b = multiMediaData.path;
                u7bVar.f = i;
                u7bVar.g = multiMediaData.type;
                u7bVar.h = c8bVar.c;
                u7bVar.i = c8bVar.d;
                u7bVar.j = s7bVar;
                u7bVar.d = j;
                u7bVar.c = multiMediaData.rotation;
                a8bVar.e.add(u7bVar);
            }
            return a8bVar;
        }
        return (a8b) invokeLL.objValue;
    }

    public static List<a8b> c(b8b b8bVar, s7b s7bVar) {
        InterceptResult invokeLL;
        List<u7b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, b8bVar, s7bVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (b8bVar == null || s7bVar == null || b8bVar.b <= 0 || bsb.e(b8bVar.e) || bsb.e(b8bVar.f)) {
                return null;
            }
            long[] a = a(b8bVar.b, b8bVar.a);
            ArrayList arrayList = new ArrayList();
            a8b a8bVar = null;
            for (int i = 0; i < b8bVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(b8bVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) bsb.c(b8bVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        a8bVar = new a8b();
                        a8bVar.e = new ArrayList();
                        a8bVar.a = multiMediaData2.path;
                        a8bVar.c = b8bVar.c;
                        a8bVar.d = b8bVar.d;
                        a8bVar.b = multiMediaData2.rotation;
                        arrayList.add(a8bVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) bsb.c(b8bVar.e, findInputIndexInSegments), j) * 1000;
                    u7b u7bVar = new u7b();
                    u7bVar.a = n7b.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    u7bVar.b = multiMediaData2.path;
                    u7bVar.f = i;
                    u7bVar.g = multiMediaData2.type;
                    u7bVar.h = b8bVar.c;
                    u7bVar.i = b8bVar.d;
                    u7bVar.d = multiMediaDataSeekTime;
                    u7bVar.j = s7bVar;
                    u7bVar.c = multiMediaData2.rotation;
                    if (a8bVar != null && (list = a8bVar.e) != null) {
                        list.add(u7bVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
