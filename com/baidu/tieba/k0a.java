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
public class k0a {
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

    public static n0a b(p0a p0aVar, f0a f0aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, p0aVar, f0aVar)) == null) {
            if (p0aVar == null || f0aVar == null || p0aVar.e == null) {
                return null;
            }
            long[] a = a(p0aVar.b, p0aVar.a);
            MultiMediaData multiMediaData = p0aVar.e;
            n0a n0aVar = new n0a();
            n0aVar.e = new ArrayList();
            n0aVar.a = multiMediaData.path;
            n0aVar.c = p0aVar.c;
            n0aVar.d = p0aVar.d;
            n0aVar.b = multiMediaData.rotation;
            for (int i = 0; i < p0aVar.b; i++) {
                long j = multiMediaData.start + a[i];
                h0a h0aVar = new h0a();
                h0aVar.a = a0a.b(multiMediaData.path, j, multiMediaData.type);
                h0aVar.b = multiMediaData.path;
                h0aVar.f = i;
                h0aVar.g = multiMediaData.type;
                h0aVar.h = p0aVar.c;
                h0aVar.i = p0aVar.d;
                h0aVar.j = f0aVar;
                h0aVar.d = j;
                h0aVar.c = multiMediaData.rotation;
                n0aVar.e.add(h0aVar);
            }
            return n0aVar;
        }
        return (n0a) invokeLL.objValue;
    }

    public static List<n0a> c(o0a o0aVar, f0a f0aVar) {
        InterceptResult invokeLL;
        List<h0a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, o0aVar, f0aVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (o0aVar == null || f0aVar == null || o0aVar.b <= 0 || iha.e(o0aVar.e) || iha.e(o0aVar.f)) {
                return null;
            }
            long[] a = a(o0aVar.b, o0aVar.a);
            ArrayList arrayList = new ArrayList();
            n0a n0aVar = null;
            for (int i = 0; i < o0aVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(o0aVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) iha.c(o0aVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        n0aVar = new n0a();
                        n0aVar.e = new ArrayList();
                        n0aVar.a = multiMediaData2.path;
                        n0aVar.c = o0aVar.c;
                        n0aVar.d = o0aVar.d;
                        n0aVar.b = multiMediaData2.rotation;
                        arrayList.add(n0aVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) iha.c(o0aVar.e, findInputIndexInSegments), j) * 1000;
                    h0a h0aVar = new h0a();
                    h0aVar.a = a0a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    h0aVar.b = multiMediaData2.path;
                    h0aVar.f = i;
                    h0aVar.g = multiMediaData2.type;
                    h0aVar.h = o0aVar.c;
                    h0aVar.i = o0aVar.d;
                    h0aVar.d = multiMediaDataSeekTime;
                    h0aVar.j = f0aVar;
                    h0aVar.c = multiMediaData2.rotation;
                    if (n0aVar != null && (list = n0aVar.e) != null) {
                        list.add(h0aVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
