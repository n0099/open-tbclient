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
public class kk9 {
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

    public static nk9 b(pk9 pk9Var, fk9 fk9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pk9Var, fk9Var)) == null) {
            if (pk9Var == null || fk9Var == null || pk9Var.e == null) {
                return null;
            }
            long[] a = a(pk9Var.b, pk9Var.a);
            MultiMediaData multiMediaData = pk9Var.e;
            nk9 nk9Var = new nk9();
            nk9Var.e = new ArrayList();
            nk9Var.a = multiMediaData.path;
            nk9Var.c = pk9Var.c;
            nk9Var.d = pk9Var.d;
            nk9Var.b = multiMediaData.rotation;
            for (int i = 0; i < pk9Var.b; i++) {
                long j = multiMediaData.start + a[i];
                hk9 hk9Var = new hk9();
                hk9Var.a = ak9.b(multiMediaData.path, j, multiMediaData.type);
                hk9Var.b = multiMediaData.path;
                hk9Var.f = i;
                hk9Var.g = multiMediaData.type;
                hk9Var.h = pk9Var.c;
                hk9Var.i = pk9Var.d;
                hk9Var.j = fk9Var;
                hk9Var.d = j;
                hk9Var.c = multiMediaData.rotation;
                nk9Var.e.add(hk9Var);
            }
            return nk9Var;
        }
        return (nk9) invokeLL.objValue;
    }

    public static List<nk9> c(ok9 ok9Var, fk9 fk9Var) {
        InterceptResult invokeLL;
        List<hk9> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ok9Var, fk9Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (ok9Var == null || fk9Var == null || ok9Var.b <= 0 || i1a.e(ok9Var.e) || i1a.e(ok9Var.f)) {
                return null;
            }
            long[] a = a(ok9Var.b, ok9Var.a);
            ArrayList arrayList = new ArrayList();
            nk9 nk9Var = null;
            for (int i = 0; i < ok9Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(ok9Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) i1a.c(ok9Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        nk9Var = new nk9();
                        nk9Var.e = new ArrayList();
                        nk9Var.a = multiMediaData2.path;
                        nk9Var.c = ok9Var.c;
                        nk9Var.d = ok9Var.d;
                        nk9Var.b = multiMediaData2.rotation;
                        arrayList.add(nk9Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) i1a.c(ok9Var.e, findInputIndexInSegments), j) * 1000;
                    hk9 hk9Var = new hk9();
                    hk9Var.a = ak9.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    hk9Var.b = multiMediaData2.path;
                    hk9Var.f = i;
                    hk9Var.g = multiMediaData2.type;
                    hk9Var.h = ok9Var.c;
                    hk9Var.i = ok9Var.d;
                    hk9Var.d = multiMediaDataSeekTime;
                    hk9Var.j = fk9Var;
                    hk9Var.c = multiMediaData2.rotation;
                    if (nk9Var != null && (list = nk9Var.e) != null) {
                        list.add(hk9Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
