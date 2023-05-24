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
public class r6a {
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

    public static u6a b(w6a w6aVar, m6a m6aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, w6aVar, m6aVar)) == null) {
            if (w6aVar == null || m6aVar == null || w6aVar.e == null) {
                return null;
            }
            long[] a = a(w6aVar.b, w6aVar.a);
            MultiMediaData multiMediaData = w6aVar.e;
            u6a u6aVar = new u6a();
            u6aVar.e = new ArrayList();
            u6aVar.a = multiMediaData.path;
            u6aVar.c = w6aVar.c;
            u6aVar.d = w6aVar.d;
            u6aVar.b = multiMediaData.rotation;
            for (int i = 0; i < w6aVar.b; i++) {
                long j = multiMediaData.start + a[i];
                o6a o6aVar = new o6a();
                o6aVar.a = h6a.b(multiMediaData.path, j, multiMediaData.type);
                o6aVar.b = multiMediaData.path;
                o6aVar.f = i;
                o6aVar.g = multiMediaData.type;
                o6aVar.h = w6aVar.c;
                o6aVar.i = w6aVar.d;
                o6aVar.j = m6aVar;
                o6aVar.d = j;
                o6aVar.c = multiMediaData.rotation;
                u6aVar.e.add(o6aVar);
            }
            return u6aVar;
        }
        return (u6a) invokeLL.objValue;
    }

    public static List<u6a> c(v6a v6aVar, m6a m6aVar) {
        InterceptResult invokeLL;
        List<o6a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, v6aVar, m6aVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (v6aVar == null || m6aVar == null || v6aVar.b <= 0 || lna.e(v6aVar.e) || lna.e(v6aVar.f)) {
                return null;
            }
            long[] a = a(v6aVar.b, v6aVar.a);
            ArrayList arrayList = new ArrayList();
            u6a u6aVar = null;
            for (int i = 0; i < v6aVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(v6aVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) lna.c(v6aVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        u6aVar = new u6a();
                        u6aVar.e = new ArrayList();
                        u6aVar.a = multiMediaData2.path;
                        u6aVar.c = v6aVar.c;
                        u6aVar.d = v6aVar.d;
                        u6aVar.b = multiMediaData2.rotation;
                        arrayList.add(u6aVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) lna.c(v6aVar.e, findInputIndexInSegments), j) * 1000;
                    o6a o6aVar = new o6a();
                    o6aVar.a = h6a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    o6aVar.b = multiMediaData2.path;
                    o6aVar.f = i;
                    o6aVar.g = multiMediaData2.type;
                    o6aVar.h = v6aVar.c;
                    o6aVar.i = v6aVar.d;
                    o6aVar.d = multiMediaDataSeekTime;
                    o6aVar.j = m6aVar;
                    o6aVar.c = multiMediaData2.rotation;
                    if (u6aVar != null && (list = u6aVar.e) != null) {
                        list.add(o6aVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
