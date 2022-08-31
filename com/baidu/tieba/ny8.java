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
public class ny8 {
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

    public static qy8 b(sy8 sy8Var, iy8 iy8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, sy8Var, iy8Var)) == null) {
            if (sy8Var == null || iy8Var == null || sy8Var.e == null) {
                return null;
            }
            long[] a = a(sy8Var.b, sy8Var.a);
            MultiMediaData multiMediaData = sy8Var.e;
            qy8 qy8Var = new qy8();
            qy8Var.e = new ArrayList();
            qy8Var.a = multiMediaData.path;
            qy8Var.c = sy8Var.c;
            qy8Var.d = sy8Var.d;
            qy8Var.b = multiMediaData.rotation;
            for (int i = 0; i < sy8Var.b; i++) {
                long j = multiMediaData.start + a[i];
                ky8 ky8Var = new ky8();
                ky8Var.a = dy8.b(multiMediaData.path, j, multiMediaData.type);
                ky8Var.b = multiMediaData.path;
                ky8Var.f = i;
                ky8Var.g = multiMediaData.type;
                ky8Var.h = sy8Var.c;
                ky8Var.i = sy8Var.d;
                ky8Var.j = iy8Var;
                ky8Var.d = j;
                ky8Var.c = multiMediaData.rotation;
                qy8Var.e.add(ky8Var);
            }
            return qy8Var;
        }
        return (qy8) invokeLL.objValue;
    }

    public static List<qy8> c(ry8 ry8Var, iy8 iy8Var) {
        InterceptResult invokeLL;
        List<ky8> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ry8Var, iy8Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (ry8Var == null || iy8Var == null || ry8Var.b <= 0 || dc9.e(ry8Var.e) || dc9.e(ry8Var.f)) {
                return null;
            }
            long[] a = a(ry8Var.b, ry8Var.a);
            ArrayList arrayList = new ArrayList();
            qy8 qy8Var = null;
            for (int i = 0; i < ry8Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(ry8Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) dc9.c(ry8Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        qy8Var = new qy8();
                        qy8Var.e = new ArrayList();
                        qy8Var.a = multiMediaData2.path;
                        qy8Var.c = ry8Var.c;
                        qy8Var.d = ry8Var.d;
                        qy8Var.b = multiMediaData2.rotation;
                        arrayList.add(qy8Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) dc9.c(ry8Var.e, findInputIndexInSegments), j) * 1000;
                    ky8 ky8Var = new ky8();
                    ky8Var.a = dy8.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    ky8Var.b = multiMediaData2.path;
                    ky8Var.f = i;
                    ky8Var.g = multiMediaData2.type;
                    ky8Var.h = ry8Var.c;
                    ky8Var.i = ry8Var.d;
                    ky8Var.d = multiMediaDataSeekTime;
                    ky8Var.j = iy8Var;
                    ky8Var.c = multiMediaData2.rotation;
                    if (qy8Var != null && (list = qy8Var.e) != null) {
                        list.add(ky8Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
