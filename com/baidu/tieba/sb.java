package com.baidu.tieba;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class sb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ArrayList<String> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65536, null, arrayList, z) == null) {
            a7 a7Var = new a7(BdStatisticsManager.getInstance().getTrackLogWriteDir(), null, DiskFileOperate.Action.DELETE_FILES, arrayList);
            a7Var.setSdCard(z);
            a7Var.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            t6.g().a(a7Var);
        }
    }

    public static File[] b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getTrackLogWriteDir(), null, DiskFileOperate.Action.INFO);
            diskFileOperate.setSdCard(z);
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            t6.g().d(diskFileOperate);
            File fileInfo = diskFileOperate.getFileInfo();
            if (fileInfo == null) {
                return null;
            }
            return fileInfo.listFiles();
        }
        return (File[]) invokeZ.objValue;
    }
}
