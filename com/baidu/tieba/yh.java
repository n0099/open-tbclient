package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import com.baidu.searchbox.retrieve.core.task.UploadTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class yh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<qh> a(nh nhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, nhVar)) == null) {
            ArrayList arrayList = new ArrayList();
            File[] b = ph.b(nhVar.C());
            if (b != null) {
                for (File file : b) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith(nhVar.h()) && name.contains("Uploading")) {
                            arrayList.add(new qh(name, file.length(), file.lastModified()));
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<qh> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                qh qhVar = (qh) it.next();
                if (qhVar != null) {
                    long j = qhVar.c;
                    if (j != 0 && j + 604800000 < currentTimeMillis) {
                        arrayList3.add(qhVar.b);
                    } else {
                        arrayList2.add(qhVar);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                ph.a(arrayList3, nhVar.C());
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static BdUploadingLogInfo b(nh nhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nhVar)) == null) {
            ArrayList<qh> a = a(nhVar);
            BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getTrackLogWriteDir(), nhVar.C(), nhVar.A());
            if (a != null && a.size() > 0) {
                if (a.size() > 1) {
                    Collections.sort(a, new rh());
                }
                ArrayList arrayList = new ArrayList();
                int size = a.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    qh qhVar = a.get(i);
                    j += qhVar.a;
                    arrayList.add(qhVar);
                    if (j >= UploadTask.SIZE_LIMIT_DEFAULT) {
                        bdUploadingLogInfo.add(arrayList);
                        arrayList = new ArrayList();
                        j = 0;
                    }
                }
                if (arrayList.size() > 0) {
                    bdUploadingLogInfo.add(arrayList);
                }
            }
            return bdUploadingLogInfo;
        }
        return (BdUploadingLogInfo) invokeL.objValue;
    }
}
