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
public class ucb {
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

    public static xcb b(zcb zcbVar, pcb pcbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, zcbVar, pcbVar)) == null) {
            if (zcbVar == null || pcbVar == null || zcbVar.e == null) {
                return null;
            }
            long[] a = a(zcbVar.b, zcbVar.a);
            MultiMediaData multiMediaData = zcbVar.e;
            xcb xcbVar = new xcb();
            xcbVar.e = new ArrayList();
            xcbVar.a = multiMediaData.path;
            xcbVar.c = zcbVar.c;
            xcbVar.d = zcbVar.d;
            xcbVar.b = multiMediaData.rotation;
            for (int i = 0; i < zcbVar.b; i++) {
                long j = multiMediaData.start + a[i];
                rcb rcbVar = new rcb();
                rcbVar.a = kcb.b(multiMediaData.path, j, multiMediaData.type);
                rcbVar.b = multiMediaData.path;
                rcbVar.f = i;
                rcbVar.g = multiMediaData.type;
                rcbVar.h = zcbVar.c;
                rcbVar.i = zcbVar.d;
                rcbVar.j = pcbVar;
                rcbVar.d = j;
                rcbVar.c = multiMediaData.rotation;
                xcbVar.e.add(rcbVar);
            }
            return xcbVar;
        }
        return (xcb) invokeLL.objValue;
    }

    public static List<xcb> c(ycb ycbVar, pcb pcbVar) {
        InterceptResult invokeLL;
        List<rcb> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ycbVar, pcbVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (ycbVar == null || pcbVar == null || ycbVar.b <= 0 || ywb.e(ycbVar.e) || ywb.e(ycbVar.f)) {
                return null;
            }
            long[] a = a(ycbVar.b, ycbVar.a);
            ArrayList arrayList = new ArrayList();
            xcb xcbVar = null;
            for (int i = 0; i < ycbVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(ycbVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) ywb.c(ycbVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        xcbVar = new xcb();
                        xcbVar.e = new ArrayList();
                        xcbVar.a = multiMediaData2.path;
                        xcbVar.c = ycbVar.c;
                        xcbVar.d = ycbVar.d;
                        xcbVar.b = multiMediaData2.rotation;
                        arrayList.add(xcbVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) ywb.c(ycbVar.e, findInputIndexInSegments), j) * 1000;
                    rcb rcbVar = new rcb();
                    rcbVar.a = kcb.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    rcbVar.b = multiMediaData2.path;
                    rcbVar.f = i;
                    rcbVar.g = multiMediaData2.type;
                    rcbVar.h = ycbVar.c;
                    rcbVar.i = ycbVar.d;
                    rcbVar.d = multiMediaDataSeekTime;
                    rcbVar.j = pcbVar;
                    rcbVar.c = multiMediaData2.rotation;
                    if (xcbVar != null && (list = xcbVar.e) != null) {
                        list.add(rcbVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
