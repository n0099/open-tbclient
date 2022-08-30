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
public class py8 {
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

    public static sy8 b(uy8 uy8Var, ky8 ky8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, uy8Var, ky8Var)) == null) {
            if (uy8Var == null || ky8Var == null || uy8Var.e == null) {
                return null;
            }
            long[] a = a(uy8Var.b, uy8Var.a);
            MultiMediaData multiMediaData = uy8Var.e;
            sy8 sy8Var = new sy8();
            sy8Var.e = new ArrayList();
            sy8Var.a = multiMediaData.path;
            sy8Var.c = uy8Var.c;
            sy8Var.d = uy8Var.d;
            sy8Var.b = multiMediaData.rotation;
            for (int i = 0; i < uy8Var.b; i++) {
                long j = multiMediaData.start + a[i];
                my8 my8Var = new my8();
                my8Var.a = fy8.b(multiMediaData.path, j, multiMediaData.type);
                my8Var.b = multiMediaData.path;
                my8Var.f = i;
                my8Var.g = multiMediaData.type;
                my8Var.h = uy8Var.c;
                my8Var.i = uy8Var.d;
                my8Var.j = ky8Var;
                my8Var.d = j;
                my8Var.c = multiMediaData.rotation;
                sy8Var.e.add(my8Var);
            }
            return sy8Var;
        }
        return (sy8) invokeLL.objValue;
    }

    public static List<sy8> c(ty8 ty8Var, ky8 ky8Var) {
        InterceptResult invokeLL;
        List<my8> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ty8Var, ky8Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (ty8Var == null || ky8Var == null || ty8Var.b <= 0 || fc9.e(ty8Var.e) || fc9.e(ty8Var.f)) {
                return null;
            }
            long[] a = a(ty8Var.b, ty8Var.a);
            ArrayList arrayList = new ArrayList();
            sy8 sy8Var = null;
            for (int i = 0; i < ty8Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(ty8Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) fc9.c(ty8Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        sy8Var = new sy8();
                        sy8Var.e = new ArrayList();
                        sy8Var.a = multiMediaData2.path;
                        sy8Var.c = ty8Var.c;
                        sy8Var.d = ty8Var.d;
                        sy8Var.b = multiMediaData2.rotation;
                        arrayList.add(sy8Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) fc9.c(ty8Var.e, findInputIndexInSegments), j) * 1000;
                    my8 my8Var = new my8();
                    my8Var.a = fy8.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    my8Var.b = multiMediaData2.path;
                    my8Var.f = i;
                    my8Var.g = multiMediaData2.type;
                    my8Var.h = ty8Var.c;
                    my8Var.i = ty8Var.d;
                    my8Var.d = multiMediaDataSeekTime;
                    my8Var.j = ky8Var;
                    my8Var.c = multiMediaData2.rotation;
                    if (sy8Var != null && (list = sy8Var.e) != null) {
                        list.add(my8Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
