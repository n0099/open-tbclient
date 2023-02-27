package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public class xc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ga5 ga5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65536, null, ga5Var) != null) || ga5Var == null) {
            return;
        }
        VersionData u = ga5Var.u();
        TbadkCoreApplication.getInst().setVersionData(u);
        TbadkCoreApplication.getInst().refreshNewVersion(true);
        if (u.forceUpdate()) {
            if (ga5Var.k() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
                TbSingleton.getInstance();
                TbSingleton.setExceptInsertAdDiaShow(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), u, ga5Var.j())));
                return;
            }
            return;
        }
        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
        Long valueOf2 = Long.valueOf(new Date().getTime());
        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && u.getStrategy() == 0 && ga5Var.k() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
            TbSingleton.getInstance().setSyncModel(ga5Var);
            if (TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
                TbSingleton.getInstance();
                TbSingleton.setExceptInsertAdDiaShow(true);
                xx5.d();
            }
            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
        }
    }

    public static void b(VersionData versionData, ClientUpdateInfo clientUpdateInfo, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65537, null, new Object[]{versionData, clientUpdateInfo, str, Boolean.valueOf(z)}) != null) || versionData == null) {
            return;
        }
        TbadkCoreApplication.getInst().setVersionData(versionData);
        TbadkCoreApplication.getInst().refreshNewVersion(true);
        if (TbadkCoreApplication.getInst().getResumeNum() > 0) {
            if (versionData.forceUpdate()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, str)));
                return;
            }
            Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            if ((valueOf2.longValue() - valueOf.longValue() > 86400000 || z) && versionData.getStrategy() == 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, str)));
                TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
            }
        }
    }
}
