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
public class tq9 {
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

    public static wq9 b(yq9 yq9Var, oq9 oq9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, yq9Var, oq9Var)) == null) {
            if (yq9Var == null || oq9Var == null || yq9Var.e == null) {
                return null;
            }
            long[] a = a(yq9Var.b, yq9Var.a);
            MultiMediaData multiMediaData = yq9Var.e;
            wq9 wq9Var = new wq9();
            wq9Var.e = new ArrayList();
            wq9Var.a = multiMediaData.path;
            wq9Var.c = yq9Var.c;
            wq9Var.d = yq9Var.d;
            wq9Var.b = multiMediaData.rotation;
            for (int i = 0; i < yq9Var.b; i++) {
                long j = multiMediaData.start + a[i];
                qq9 qq9Var = new qq9();
                qq9Var.a = jq9.b(multiMediaData.path, j, multiMediaData.type);
                qq9Var.b = multiMediaData.path;
                qq9Var.f = i;
                qq9Var.g = multiMediaData.type;
                qq9Var.h = yq9Var.c;
                qq9Var.i = yq9Var.d;
                qq9Var.j = oq9Var;
                qq9Var.d = j;
                qq9Var.c = multiMediaData.rotation;
                wq9Var.e.add(qq9Var);
            }
            return wq9Var;
        }
        return (wq9) invokeLL.objValue;
    }

    public static List<wq9> c(xq9 xq9Var, oq9 oq9Var) {
        InterceptResult invokeLL;
        List<qq9> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, xq9Var, oq9Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (xq9Var == null || oq9Var == null || xq9Var.b <= 0 || r7a.e(xq9Var.e) || r7a.e(xq9Var.f)) {
                return null;
            }
            long[] a = a(xq9Var.b, xq9Var.a);
            ArrayList arrayList = new ArrayList();
            wq9 wq9Var = null;
            for (int i = 0; i < xq9Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(xq9Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) r7a.c(xq9Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        wq9Var = new wq9();
                        wq9Var.e = new ArrayList();
                        wq9Var.a = multiMediaData2.path;
                        wq9Var.c = xq9Var.c;
                        wq9Var.d = xq9Var.d;
                        wq9Var.b = multiMediaData2.rotation;
                        arrayList.add(wq9Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) r7a.c(xq9Var.e, findInputIndexInSegments), j) * 1000;
                    qq9 qq9Var = new qq9();
                    qq9Var.a = jq9.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    qq9Var.b = multiMediaData2.path;
                    qq9Var.f = i;
                    qq9Var.g = multiMediaData2.type;
                    qq9Var.h = xq9Var.c;
                    qq9Var.i = xq9Var.d;
                    qq9Var.d = multiMediaDataSeekTime;
                    qq9Var.j = oq9Var;
                    qq9Var.c = multiMediaData2.rotation;
                    if (wq9Var != null && (list = wq9Var.e) != null) {
                        list.add(qq9Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
