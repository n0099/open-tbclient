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
public class s0a {
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

    public static v0a b(x0a x0aVar, n0a n0aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, x0aVar, n0aVar)) == null) {
            if (x0aVar == null || n0aVar == null || x0aVar.e == null) {
                return null;
            }
            long[] a = a(x0aVar.b, x0aVar.a);
            MultiMediaData multiMediaData = x0aVar.e;
            v0a v0aVar = new v0a();
            v0aVar.e = new ArrayList();
            v0aVar.a = multiMediaData.path;
            v0aVar.c = x0aVar.c;
            v0aVar.d = x0aVar.d;
            v0aVar.b = multiMediaData.rotation;
            for (int i = 0; i < x0aVar.b; i++) {
                long j = multiMediaData.start + a[i];
                p0a p0aVar = new p0a();
                p0aVar.a = i0a.b(multiMediaData.path, j, multiMediaData.type);
                p0aVar.b = multiMediaData.path;
                p0aVar.f = i;
                p0aVar.g = multiMediaData.type;
                p0aVar.h = x0aVar.c;
                p0aVar.i = x0aVar.d;
                p0aVar.j = n0aVar;
                p0aVar.d = j;
                p0aVar.c = multiMediaData.rotation;
                v0aVar.e.add(p0aVar);
            }
            return v0aVar;
        }
        return (v0a) invokeLL.objValue;
    }

    public static List<v0a> c(w0a w0aVar, n0a n0aVar) {
        InterceptResult invokeLL;
        List<p0a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, w0aVar, n0aVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (w0aVar == null || n0aVar == null || w0aVar.b <= 0 || qha.e(w0aVar.e) || qha.e(w0aVar.f)) {
                return null;
            }
            long[] a = a(w0aVar.b, w0aVar.a);
            ArrayList arrayList = new ArrayList();
            v0a v0aVar = null;
            for (int i = 0; i < w0aVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(w0aVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) qha.c(w0aVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        v0aVar = new v0a();
                        v0aVar.e = new ArrayList();
                        v0aVar.a = multiMediaData2.path;
                        v0aVar.c = w0aVar.c;
                        v0aVar.d = w0aVar.d;
                        v0aVar.b = multiMediaData2.rotation;
                        arrayList.add(v0aVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) qha.c(w0aVar.e, findInputIndexInSegments), j) * 1000;
                    p0a p0aVar = new p0a();
                    p0aVar.a = i0a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    p0aVar.b = multiMediaData2.path;
                    p0aVar.f = i;
                    p0aVar.g = multiMediaData2.type;
                    p0aVar.h = w0aVar.c;
                    p0aVar.i = w0aVar.d;
                    p0aVar.d = multiMediaDataSeekTime;
                    p0aVar.j = n0aVar;
                    p0aVar.c = multiMediaData2.rotation;
                    if (v0aVar != null && (list = v0aVar.e) != null) {
                        list.add(p0aVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
