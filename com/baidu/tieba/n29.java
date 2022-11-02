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
public class n29 {
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

    public static q29 b(s29 s29Var, i29 i29Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, s29Var, i29Var)) == null) {
            if (s29Var == null || i29Var == null || s29Var.e == null) {
                return null;
            }
            long[] a = a(s29Var.b, s29Var.a);
            MultiMediaData multiMediaData = s29Var.e;
            q29 q29Var = new q29();
            q29Var.e = new ArrayList();
            q29Var.a = multiMediaData.path;
            q29Var.c = s29Var.c;
            q29Var.d = s29Var.d;
            q29Var.b = multiMediaData.rotation;
            for (int i = 0; i < s29Var.b; i++) {
                long j = multiMediaData.start + a[i];
                k29 k29Var = new k29();
                k29Var.a = d29.b(multiMediaData.path, j, multiMediaData.type);
                k29Var.b = multiMediaData.path;
                k29Var.f = i;
                k29Var.g = multiMediaData.type;
                k29Var.h = s29Var.c;
                k29Var.i = s29Var.d;
                k29Var.j = i29Var;
                k29Var.d = j;
                k29Var.c = multiMediaData.rotation;
                q29Var.e.add(k29Var);
            }
            return q29Var;
        }
        return (q29) invokeLL.objValue;
    }

    public static List<q29> c(r29 r29Var, i29 i29Var) {
        InterceptResult invokeLL;
        List<k29> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, r29Var, i29Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (r29Var == null || i29Var == null || r29Var.b <= 0 || wi9.e(r29Var.e) || wi9.e(r29Var.f)) {
                return null;
            }
            long[] a = a(r29Var.b, r29Var.a);
            ArrayList arrayList = new ArrayList();
            q29 q29Var = null;
            for (int i = 0; i < r29Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(r29Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) wi9.c(r29Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        q29Var = new q29();
                        q29Var.e = new ArrayList();
                        q29Var.a = multiMediaData2.path;
                        q29Var.c = r29Var.c;
                        q29Var.d = r29Var.d;
                        q29Var.b = multiMediaData2.rotation;
                        arrayList.add(q29Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) wi9.c(r29Var.e, findInputIndexInSegments), j) * 1000;
                    k29 k29Var = new k29();
                    k29Var.a = d29.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    k29Var.b = multiMediaData2.path;
                    k29Var.f = i;
                    k29Var.g = multiMediaData2.type;
                    k29Var.h = r29Var.c;
                    k29Var.i = r29Var.d;
                    k29Var.d = multiMediaDataSeekTime;
                    k29Var.j = i29Var;
                    k29Var.c = multiMediaData2.rotation;
                    if (q29Var != null && (list = q29Var.e) != null) {
                        list.add(k29Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
