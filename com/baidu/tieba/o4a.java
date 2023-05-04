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
public class o4a {
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

    public static r4a b(t4a t4aVar, j4a j4aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t4aVar, j4aVar)) == null) {
            if (t4aVar == null || j4aVar == null || t4aVar.e == null) {
                return null;
            }
            long[] a = a(t4aVar.b, t4aVar.a);
            MultiMediaData multiMediaData = t4aVar.e;
            r4a r4aVar = new r4a();
            r4aVar.e = new ArrayList();
            r4aVar.a = multiMediaData.path;
            r4aVar.c = t4aVar.c;
            r4aVar.d = t4aVar.d;
            r4aVar.b = multiMediaData.rotation;
            for (int i = 0; i < t4aVar.b; i++) {
                long j = multiMediaData.start + a[i];
                l4a l4aVar = new l4a();
                l4aVar.a = e4a.b(multiMediaData.path, j, multiMediaData.type);
                l4aVar.b = multiMediaData.path;
                l4aVar.f = i;
                l4aVar.g = multiMediaData.type;
                l4aVar.h = t4aVar.c;
                l4aVar.i = t4aVar.d;
                l4aVar.j = j4aVar;
                l4aVar.d = j;
                l4aVar.c = multiMediaData.rotation;
                r4aVar.e.add(l4aVar);
            }
            return r4aVar;
        }
        return (r4a) invokeLL.objValue;
    }

    public static List<r4a> c(s4a s4aVar, j4a j4aVar) {
        InterceptResult invokeLL;
        List<l4a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, s4aVar, j4aVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (s4aVar == null || j4aVar == null || s4aVar.b <= 0 || mla.e(s4aVar.e) || mla.e(s4aVar.f)) {
                return null;
            }
            long[] a = a(s4aVar.b, s4aVar.a);
            ArrayList arrayList = new ArrayList();
            r4a r4aVar = null;
            for (int i = 0; i < s4aVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(s4aVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) mla.c(s4aVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        r4aVar = new r4a();
                        r4aVar.e = new ArrayList();
                        r4aVar.a = multiMediaData2.path;
                        r4aVar.c = s4aVar.c;
                        r4aVar.d = s4aVar.d;
                        r4aVar.b = multiMediaData2.rotation;
                        arrayList.add(r4aVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) mla.c(s4aVar.e, findInputIndexInSegments), j) * 1000;
                    l4a l4aVar = new l4a();
                    l4aVar.a = e4a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    l4aVar.b = multiMediaData2.path;
                    l4aVar.f = i;
                    l4aVar.g = multiMediaData2.type;
                    l4aVar.h = s4aVar.c;
                    l4aVar.i = s4aVar.d;
                    l4aVar.d = multiMediaDataSeekTime;
                    l4aVar.j = j4aVar;
                    l4aVar.c = multiMediaData2.rotation;
                    if (r4aVar != null && (list = r4aVar.e) != null) {
                        list.add(l4aVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
