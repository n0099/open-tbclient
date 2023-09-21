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
public class uza {
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

    public static xza b(zza zzaVar, pza pzaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, zzaVar, pzaVar)) == null) {
            if (zzaVar == null || pzaVar == null || zzaVar.e == null) {
                return null;
            }
            long[] a = a(zzaVar.b, zzaVar.a);
            MultiMediaData multiMediaData = zzaVar.e;
            xza xzaVar = new xza();
            xzaVar.e = new ArrayList();
            xzaVar.a = multiMediaData.path;
            xzaVar.c = zzaVar.c;
            xzaVar.d = zzaVar.d;
            xzaVar.b = multiMediaData.rotation;
            for (int i = 0; i < zzaVar.b; i++) {
                long j = multiMediaData.start + a[i];
                rza rzaVar = new rza();
                rzaVar.a = kza.b(multiMediaData.path, j, multiMediaData.type);
                rzaVar.b = multiMediaData.path;
                rzaVar.f = i;
                rzaVar.g = multiMediaData.type;
                rzaVar.h = zzaVar.c;
                rzaVar.i = zzaVar.d;
                rzaVar.j = pzaVar;
                rzaVar.d = j;
                rzaVar.c = multiMediaData.rotation;
                xzaVar.e.add(rzaVar);
            }
            return xzaVar;
        }
        return (xza) invokeLL.objValue;
    }

    public static List<xza> c(yza yzaVar, pza pzaVar) {
        InterceptResult invokeLL;
        List<rza> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, yzaVar, pzaVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (yzaVar == null || pzaVar == null || yzaVar.b <= 0 || fkb.e(yzaVar.e) || fkb.e(yzaVar.f)) {
                return null;
            }
            long[] a = a(yzaVar.b, yzaVar.a);
            ArrayList arrayList = new ArrayList();
            xza xzaVar = null;
            for (int i = 0; i < yzaVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(yzaVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) fkb.c(yzaVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        xzaVar = new xza();
                        xzaVar.e = new ArrayList();
                        xzaVar.a = multiMediaData2.path;
                        xzaVar.c = yzaVar.c;
                        xzaVar.d = yzaVar.d;
                        xzaVar.b = multiMediaData2.rotation;
                        arrayList.add(xzaVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) fkb.c(yzaVar.e, findInputIndexInSegments), j) * 1000;
                    rza rzaVar = new rza();
                    rzaVar.a = kza.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    rzaVar.b = multiMediaData2.path;
                    rzaVar.f = i;
                    rzaVar.g = multiMediaData2.type;
                    rzaVar.h = yzaVar.c;
                    rzaVar.i = yzaVar.d;
                    rzaVar.d = multiMediaDataSeekTime;
                    rzaVar.j = pzaVar;
                    rzaVar.c = multiMediaData2.rotation;
                    if (xzaVar != null && (list = xzaVar.e) != null) {
                        list.add(rzaVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
