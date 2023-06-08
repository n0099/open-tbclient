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
public class lda {
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

    public static oda b(qda qdaVar, gda gdaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, qdaVar, gdaVar)) == null) {
            if (qdaVar == null || gdaVar == null || qdaVar.e == null) {
                return null;
            }
            long[] a = a(qdaVar.b, qdaVar.a);
            MultiMediaData multiMediaData = qdaVar.e;
            oda odaVar = new oda();
            odaVar.e = new ArrayList();
            odaVar.a = multiMediaData.path;
            odaVar.c = qdaVar.c;
            odaVar.d = qdaVar.d;
            odaVar.b = multiMediaData.rotation;
            for (int i = 0; i < qdaVar.b; i++) {
                long j = multiMediaData.start + a[i];
                ida idaVar = new ida();
                idaVar.a = bda.b(multiMediaData.path, j, multiMediaData.type);
                idaVar.b = multiMediaData.path;
                idaVar.f = i;
                idaVar.g = multiMediaData.type;
                idaVar.h = qdaVar.c;
                idaVar.i = qdaVar.d;
                idaVar.j = gdaVar;
                idaVar.d = j;
                idaVar.c = multiMediaData.rotation;
                odaVar.e.add(idaVar);
            }
            return odaVar;
        }
        return (oda) invokeLL.objValue;
    }

    public static List<oda> c(pda pdaVar, gda gdaVar) {
        InterceptResult invokeLL;
        List<ida> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pdaVar, gdaVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (pdaVar == null || gdaVar == null || pdaVar.b <= 0 || dva.e(pdaVar.e) || dva.e(pdaVar.f)) {
                return null;
            }
            long[] a = a(pdaVar.b, pdaVar.a);
            ArrayList arrayList = new ArrayList();
            oda odaVar = null;
            for (int i = 0; i < pdaVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(pdaVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) dva.c(pdaVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        odaVar = new oda();
                        odaVar.e = new ArrayList();
                        odaVar.a = multiMediaData2.path;
                        odaVar.c = pdaVar.c;
                        odaVar.d = pdaVar.d;
                        odaVar.b = multiMediaData2.rotation;
                        arrayList.add(odaVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) dva.c(pdaVar.e, findInputIndexInSegments), j) * 1000;
                    ida idaVar = new ida();
                    idaVar.a = bda.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    idaVar.b = multiMediaData2.path;
                    idaVar.f = i;
                    idaVar.g = multiMediaData2.type;
                    idaVar.h = pdaVar.c;
                    idaVar.i = pdaVar.d;
                    idaVar.d = multiMediaDataSeekTime;
                    idaVar.j = gdaVar;
                    idaVar.c = multiMediaData2.rotation;
                    if (odaVar != null && (list = odaVar.e) != null) {
                        list.add(idaVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
