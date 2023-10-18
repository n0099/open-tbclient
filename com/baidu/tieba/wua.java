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
public class wua {
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

    public static zua b(bva bvaVar, rua ruaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bvaVar, ruaVar)) == null) {
            if (bvaVar == null || ruaVar == null || bvaVar.e == null) {
                return null;
            }
            long[] a = a(bvaVar.b, bvaVar.a);
            MultiMediaData multiMediaData = bvaVar.e;
            zua zuaVar = new zua();
            zuaVar.e = new ArrayList();
            zuaVar.a = multiMediaData.path;
            zuaVar.c = bvaVar.c;
            zuaVar.d = bvaVar.d;
            zuaVar.b = multiMediaData.rotation;
            for (int i = 0; i < bvaVar.b; i++) {
                long j = multiMediaData.start + a[i];
                tua tuaVar = new tua();
                tuaVar.a = mua.b(multiMediaData.path, j, multiMediaData.type);
                tuaVar.b = multiMediaData.path;
                tuaVar.f = i;
                tuaVar.g = multiMediaData.type;
                tuaVar.h = bvaVar.c;
                tuaVar.i = bvaVar.d;
                tuaVar.j = ruaVar;
                tuaVar.d = j;
                tuaVar.c = multiMediaData.rotation;
                zuaVar.e.add(tuaVar);
            }
            return zuaVar;
        }
        return (zua) invokeLL.objValue;
    }

    public static List<zua> c(ava avaVar, rua ruaVar) {
        InterceptResult invokeLL;
        List<tua> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, avaVar, ruaVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (avaVar == null || ruaVar == null || avaVar.b <= 0 || afb.e(avaVar.e) || afb.e(avaVar.f)) {
                return null;
            }
            long[] a = a(avaVar.b, avaVar.a);
            ArrayList arrayList = new ArrayList();
            zua zuaVar = null;
            for (int i = 0; i < avaVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(avaVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) afb.c(avaVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        zuaVar = new zua();
                        zuaVar.e = new ArrayList();
                        zuaVar.a = multiMediaData2.path;
                        zuaVar.c = avaVar.c;
                        zuaVar.d = avaVar.d;
                        zuaVar.b = multiMediaData2.rotation;
                        arrayList.add(zuaVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) afb.c(avaVar.e, findInputIndexInSegments), j) * 1000;
                    tua tuaVar = new tua();
                    tuaVar.a = mua.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    tuaVar.b = multiMediaData2.path;
                    tuaVar.f = i;
                    tuaVar.g = multiMediaData2.type;
                    tuaVar.h = avaVar.c;
                    tuaVar.i = avaVar.d;
                    tuaVar.d = multiMediaDataSeekTime;
                    tuaVar.j = ruaVar;
                    tuaVar.c = multiMediaData2.rotation;
                    if (zuaVar != null && (list = zuaVar.e) != null) {
                        list.add(tuaVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
