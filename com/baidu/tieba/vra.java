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
public class vra {
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

    public static yra b(asa asaVar, qra qraVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, asaVar, qraVar)) == null) {
            if (asaVar == null || qraVar == null || asaVar.e == null) {
                return null;
            }
            long[] a = a(asaVar.b, asaVar.a);
            MultiMediaData multiMediaData = asaVar.e;
            yra yraVar = new yra();
            yraVar.e = new ArrayList();
            yraVar.a = multiMediaData.path;
            yraVar.c = asaVar.c;
            yraVar.d = asaVar.d;
            yraVar.b = multiMediaData.rotation;
            for (int i = 0; i < asaVar.b; i++) {
                long j = multiMediaData.start + a[i];
                sra sraVar = new sra();
                sraVar.a = lra.b(multiMediaData.path, j, multiMediaData.type);
                sraVar.b = multiMediaData.path;
                sraVar.f = i;
                sraVar.g = multiMediaData.type;
                sraVar.h = asaVar.c;
                sraVar.i = asaVar.d;
                sraVar.j = qraVar;
                sraVar.d = j;
                sraVar.c = multiMediaData.rotation;
                yraVar.e.add(sraVar);
            }
            return yraVar;
        }
        return (yra) invokeLL.objValue;
    }

    public static List<yra> c(zra zraVar, qra qraVar) {
        InterceptResult invokeLL;
        List<sra> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, zraVar, qraVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (zraVar == null || qraVar == null || zraVar.b <= 0 || o9b.e(zraVar.e) || o9b.e(zraVar.f)) {
                return null;
            }
            long[] a = a(zraVar.b, zraVar.a);
            ArrayList arrayList = new ArrayList();
            yra yraVar = null;
            for (int i = 0; i < zraVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(zraVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) o9b.c(zraVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        yraVar = new yra();
                        yraVar.e = new ArrayList();
                        yraVar.a = multiMediaData2.path;
                        yraVar.c = zraVar.c;
                        yraVar.d = zraVar.d;
                        yraVar.b = multiMediaData2.rotation;
                        arrayList.add(yraVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) o9b.c(zraVar.e, findInputIndexInSegments), j) * 1000;
                    sra sraVar = new sra();
                    sraVar.a = lra.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    sraVar.b = multiMediaData2.path;
                    sraVar.f = i;
                    sraVar.g = multiMediaData2.type;
                    sraVar.h = zraVar.c;
                    sraVar.i = zraVar.d;
                    sraVar.d = multiMediaDataSeekTime;
                    sraVar.j = qraVar;
                    sraVar.c = multiMediaData2.rotation;
                    if (yraVar != null && (list = yraVar.e) != null) {
                        list.add(sraVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
