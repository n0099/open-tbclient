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
public class tcb {
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

    public static wcb b(ycb ycbVar, ocb ocbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ycbVar, ocbVar)) == null) {
            if (ycbVar == null || ocbVar == null || ycbVar.e == null) {
                return null;
            }
            long[] a = a(ycbVar.b, ycbVar.a);
            MultiMediaData multiMediaData = ycbVar.e;
            wcb wcbVar = new wcb();
            wcbVar.e = new ArrayList();
            wcbVar.a = multiMediaData.path;
            wcbVar.c = ycbVar.c;
            wcbVar.d = ycbVar.d;
            wcbVar.b = multiMediaData.rotation;
            for (int i = 0; i < ycbVar.b; i++) {
                long j = multiMediaData.start + a[i];
                qcb qcbVar = new qcb();
                qcbVar.a = jcb.b(multiMediaData.path, j, multiMediaData.type);
                qcbVar.b = multiMediaData.path;
                qcbVar.f = i;
                qcbVar.g = multiMediaData.type;
                qcbVar.h = ycbVar.c;
                qcbVar.i = ycbVar.d;
                qcbVar.j = ocbVar;
                qcbVar.d = j;
                qcbVar.c = multiMediaData.rotation;
                wcbVar.e.add(qcbVar);
            }
            return wcbVar;
        }
        return (wcb) invokeLL.objValue;
    }

    public static List<wcb> c(xcb xcbVar, ocb ocbVar) {
        InterceptResult invokeLL;
        List<qcb> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, xcbVar, ocbVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (xcbVar == null || ocbVar == null || xcbVar.b <= 0 || xwb.e(xcbVar.e) || xwb.e(xcbVar.f)) {
                return null;
            }
            long[] a = a(xcbVar.b, xcbVar.a);
            ArrayList arrayList = new ArrayList();
            wcb wcbVar = null;
            for (int i = 0; i < xcbVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(xcbVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) xwb.c(xcbVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        wcbVar = new wcb();
                        wcbVar.e = new ArrayList();
                        wcbVar.a = multiMediaData2.path;
                        wcbVar.c = xcbVar.c;
                        wcbVar.d = xcbVar.d;
                        wcbVar.b = multiMediaData2.rotation;
                        arrayList.add(wcbVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) xwb.c(xcbVar.e, findInputIndexInSegments), j) * 1000;
                    qcb qcbVar = new qcb();
                    qcbVar.a = jcb.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    qcbVar.b = multiMediaData2.path;
                    qcbVar.f = i;
                    qcbVar.g = multiMediaData2.type;
                    qcbVar.h = xcbVar.c;
                    qcbVar.i = xcbVar.d;
                    qcbVar.d = multiMediaDataSeekTime;
                    qcbVar.j = ocbVar;
                    qcbVar.c = multiMediaData2.rotation;
                    if (wcbVar != null && (list = wcbVar.e) != null) {
                        list.add(qcbVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
