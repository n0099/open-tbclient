package com.baidu.tieba;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ura {
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

    public static xra b(zra zraVar, pra praVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, zraVar, praVar)) == null) {
            if (zraVar == null || praVar == null || zraVar.e == null) {
                return null;
            }
            long[] a = a(zraVar.b, zraVar.a);
            MultiMediaData multiMediaData = zraVar.e;
            xra xraVar = new xra();
            xraVar.e = new ArrayList();
            xraVar.a = multiMediaData.path;
            xraVar.c = zraVar.c;
            xraVar.d = zraVar.d;
            xraVar.b = multiMediaData.rotation;
            for (int i = 0; i < zraVar.b; i++) {
                long j = multiMediaData.start + a[i];
                rra rraVar = new rra();
                rraVar.a = kra.b(multiMediaData.path, j, multiMediaData.type);
                rraVar.b = multiMediaData.path;
                rraVar.f = i;
                rraVar.g = multiMediaData.type;
                rraVar.h = zraVar.c;
                rraVar.i = zraVar.d;
                rraVar.j = praVar;
                rraVar.d = j;
                rraVar.c = multiMediaData.rotation;
                xraVar.e.add(rraVar);
            }
            return xraVar;
        }
        return (xra) invokeLL.objValue;
    }

    public static List<xra> c(yra yraVar, pra praVar) {
        InterceptResult invokeLL;
        List<rra> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, yraVar, praVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (yraVar == null || praVar == null || yraVar.b <= 0 || n9b.e(yraVar.e) || n9b.e(yraVar.f)) {
                return null;
            }
            long[] a = a(yraVar.b, yraVar.a);
            ArrayList arrayList = new ArrayList();
            xra xraVar = null;
            for (int i = 0; i < yraVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(yraVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) n9b.c(yraVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        xraVar = new xra();
                        xraVar.e = new ArrayList();
                        xraVar.a = multiMediaData2.path;
                        xraVar.c = yraVar.c;
                        xraVar.d = yraVar.d;
                        xraVar.b = multiMediaData2.rotation;
                        arrayList.add(xraVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) n9b.c(yraVar.e, findInputIndexInSegments), j) * 1000;
                    rra rraVar = new rra();
                    rraVar.a = kra.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    rraVar.b = multiMediaData2.path;
                    rraVar.f = i;
                    rraVar.g = multiMediaData2.type;
                    rraVar.h = yraVar.c;
                    rraVar.i = yraVar.d;
                    rraVar.d = multiMediaDataSeekTime;
                    rraVar.j = praVar;
                    rraVar.c = multiMediaData2.rotation;
                    if (xraVar != null && (list = xraVar.e) != null) {
                        list.add(rraVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
