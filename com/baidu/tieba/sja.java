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
public class sja {
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

    public static vja b(xja xjaVar, nja njaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, xjaVar, njaVar)) == null) {
            if (xjaVar == null || njaVar == null || xjaVar.e == null) {
                return null;
            }
            long[] a = a(xjaVar.b, xjaVar.a);
            MultiMediaData multiMediaData = xjaVar.e;
            vja vjaVar = new vja();
            vjaVar.e = new ArrayList();
            vjaVar.a = multiMediaData.path;
            vjaVar.c = xjaVar.c;
            vjaVar.d = xjaVar.d;
            vjaVar.b = multiMediaData.rotation;
            for (int i = 0; i < xjaVar.b; i++) {
                long j = multiMediaData.start + a[i];
                pja pjaVar = new pja();
                pjaVar.a = ija.b(multiMediaData.path, j, multiMediaData.type);
                pjaVar.b = multiMediaData.path;
                pjaVar.f = i;
                pjaVar.g = multiMediaData.type;
                pjaVar.h = xjaVar.c;
                pjaVar.i = xjaVar.d;
                pjaVar.j = njaVar;
                pjaVar.d = j;
                pjaVar.c = multiMediaData.rotation;
                vjaVar.e.add(pjaVar);
            }
            return vjaVar;
        }
        return (vja) invokeLL.objValue;
    }

    public static List<vja> c(wja wjaVar, nja njaVar) {
        InterceptResult invokeLL;
        List<pja> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, wjaVar, njaVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (wjaVar == null || njaVar == null || wjaVar.b <= 0 || m1b.e(wjaVar.e) || m1b.e(wjaVar.f)) {
                return null;
            }
            long[] a = a(wjaVar.b, wjaVar.a);
            ArrayList arrayList = new ArrayList();
            vja vjaVar = null;
            for (int i = 0; i < wjaVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(wjaVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) m1b.c(wjaVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        vjaVar = new vja();
                        vjaVar.e = new ArrayList();
                        vjaVar.a = multiMediaData2.path;
                        vjaVar.c = wjaVar.c;
                        vjaVar.d = wjaVar.d;
                        vjaVar.b = multiMediaData2.rotation;
                        arrayList.add(vjaVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) m1b.c(wjaVar.e, findInputIndexInSegments), j) * 1000;
                    pja pjaVar = new pja();
                    pjaVar.a = ija.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    pjaVar.b = multiMediaData2.path;
                    pjaVar.f = i;
                    pjaVar.g = multiMediaData2.type;
                    pjaVar.h = wjaVar.c;
                    pjaVar.i = wjaVar.d;
                    pjaVar.d = multiMediaDataSeekTime;
                    pjaVar.j = njaVar;
                    pjaVar.c = multiMediaData2.rotation;
                    if (vjaVar != null && (list = vjaVar.e) != null) {
                        list.add(pjaVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
