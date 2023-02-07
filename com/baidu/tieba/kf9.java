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
public class kf9 {
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

    public static nf9 b(pf9 pf9Var, ff9 ff9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pf9Var, ff9Var)) == null) {
            if (pf9Var == null || ff9Var == null || pf9Var.e == null) {
                return null;
            }
            long[] a = a(pf9Var.b, pf9Var.a);
            MultiMediaData multiMediaData = pf9Var.e;
            nf9 nf9Var = new nf9();
            nf9Var.e = new ArrayList();
            nf9Var.a = multiMediaData.path;
            nf9Var.c = pf9Var.c;
            nf9Var.d = pf9Var.d;
            nf9Var.b = multiMediaData.rotation;
            for (int i = 0; i < pf9Var.b; i++) {
                long j = multiMediaData.start + a[i];
                hf9 hf9Var = new hf9();
                hf9Var.a = af9.b(multiMediaData.path, j, multiMediaData.type);
                hf9Var.b = multiMediaData.path;
                hf9Var.f = i;
                hf9Var.g = multiMediaData.type;
                hf9Var.h = pf9Var.c;
                hf9Var.i = pf9Var.d;
                hf9Var.j = ff9Var;
                hf9Var.d = j;
                hf9Var.c = multiMediaData.rotation;
                nf9Var.e.add(hf9Var);
            }
            return nf9Var;
        }
        return (nf9) invokeLL.objValue;
    }

    public static List<nf9> c(of9 of9Var, ff9 ff9Var) {
        InterceptResult invokeLL;
        List<hf9> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, of9Var, ff9Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (of9Var == null || ff9Var == null || of9Var.b <= 0 || hw9.e(of9Var.e) || hw9.e(of9Var.f)) {
                return null;
            }
            long[] a = a(of9Var.b, of9Var.a);
            ArrayList arrayList = new ArrayList();
            nf9 nf9Var = null;
            for (int i = 0; i < of9Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(of9Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) hw9.c(of9Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        nf9Var = new nf9();
                        nf9Var.e = new ArrayList();
                        nf9Var.a = multiMediaData2.path;
                        nf9Var.c = of9Var.c;
                        nf9Var.d = of9Var.d;
                        nf9Var.b = multiMediaData2.rotation;
                        arrayList.add(nf9Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) hw9.c(of9Var.e, findInputIndexInSegments), j) * 1000;
                    hf9 hf9Var = new hf9();
                    hf9Var.a = af9.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    hf9Var.b = multiMediaData2.path;
                    hf9Var.f = i;
                    hf9Var.g = multiMediaData2.type;
                    hf9Var.h = of9Var.c;
                    hf9Var.i = of9Var.d;
                    hf9Var.d = multiMediaDataSeekTime;
                    hf9Var.j = ff9Var;
                    hf9Var.c = multiMediaData2.rotation;
                    if (nf9Var != null && (list = nf9Var.e) != null) {
                        list.add(hf9Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
