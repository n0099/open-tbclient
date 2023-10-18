package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class yb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<tb> a(qb qbVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, qbVar, z)) == null) {
            ArrayList<tb> arrayList = new ArrayList<>();
            File[] b = rb.b(qbVar.E(), z);
            if (b != null) {
                for (File file : b) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith(qbVar.h()) && name.contains("Uploading")) {
                            long length = file.length();
                            if (z && file.getPath().contains("/notUpload")) {
                                name = "notUpload/" + file.getName();
                            }
                            arrayList.add(new tb(name, length, file.lastModified()));
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<tb> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (qbVar.h() != "stat") {
                Iterator<tb> it = arrayList.iterator();
                while (it.hasNext()) {
                    tb next = it.next();
                    if (next != null) {
                        long j = next.c;
                        if (j != 0 && j + 604800000 < currentTimeMillis) {
                            arrayList3.add(next.b);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList3.size() > 0) {
                rb.a(arrayList3, qbVar.E());
            }
            return arrayList;
        }
        return (ArrayList) invokeLZ.objValue;
    }

    public static BdUploadingLogInfo b(qb qbVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, qbVar, z)) == null) {
            ArrayList<tb> a = a(qbVar, z);
            BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getWriteDir(), qbVar.E(), qbVar.A());
            if (a != null && a.size() > 0) {
                if (a.size() > 1) {
                    Collections.sort(a, new ub());
                }
                ArrayList arrayList = new ArrayList();
                int size = a.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    tb tbVar = a.get(i);
                    j += tbVar.a;
                    arrayList.add(tbVar);
                    if (j >= ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
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
        return (BdUploadingLogInfo) invokeLZ.objValue;
    }
}
