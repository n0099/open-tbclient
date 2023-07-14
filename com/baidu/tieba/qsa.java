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
public class qsa {
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

    public static tsa b(vsa vsaVar, lsa lsaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, vsaVar, lsaVar)) == null) {
            if (vsaVar == null || lsaVar == null || vsaVar.e == null) {
                return null;
            }
            long[] a = a(vsaVar.b, vsaVar.a);
            MultiMediaData multiMediaData = vsaVar.e;
            tsa tsaVar = new tsa();
            tsaVar.e = new ArrayList();
            tsaVar.a = multiMediaData.path;
            tsaVar.c = vsaVar.c;
            tsaVar.d = vsaVar.d;
            tsaVar.b = multiMediaData.rotation;
            for (int i = 0; i < vsaVar.b; i++) {
                long j = multiMediaData.start + a[i];
                nsa nsaVar = new nsa();
                nsaVar.a = gsa.b(multiMediaData.path, j, multiMediaData.type);
                nsaVar.b = multiMediaData.path;
                nsaVar.f = i;
                nsaVar.g = multiMediaData.type;
                nsaVar.h = vsaVar.c;
                nsaVar.i = vsaVar.d;
                nsaVar.j = lsaVar;
                nsaVar.d = j;
                nsaVar.c = multiMediaData.rotation;
                tsaVar.e.add(nsaVar);
            }
            return tsaVar;
        }
        return (tsa) invokeLL.objValue;
    }

    public static List<tsa> c(usa usaVar, lsa lsaVar) {
        InterceptResult invokeLL;
        List<nsa> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, usaVar, lsaVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (usaVar == null || lsaVar == null || usaVar.b <= 0 || kab.e(usaVar.e) || kab.e(usaVar.f)) {
                return null;
            }
            long[] a = a(usaVar.b, usaVar.a);
            ArrayList arrayList = new ArrayList();
            tsa tsaVar = null;
            for (int i = 0; i < usaVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(usaVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) kab.c(usaVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        tsaVar = new tsa();
                        tsaVar.e = new ArrayList();
                        tsaVar.a = multiMediaData2.path;
                        tsaVar.c = usaVar.c;
                        tsaVar.d = usaVar.d;
                        tsaVar.b = multiMediaData2.rotation;
                        arrayList.add(tsaVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) kab.c(usaVar.e, findInputIndexInSegments), j) * 1000;
                    nsa nsaVar = new nsa();
                    nsaVar.a = gsa.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    nsaVar.b = multiMediaData2.path;
                    nsaVar.f = i;
                    nsaVar.g = multiMediaData2.type;
                    nsaVar.h = usaVar.c;
                    nsaVar.i = usaVar.d;
                    nsaVar.d = multiMediaDataSeekTime;
                    nsaVar.j = lsaVar;
                    nsaVar.c = multiMediaData2.rotation;
                    if (tsaVar != null && (list = tsaVar.e) != null) {
                        list.add(nsaVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
