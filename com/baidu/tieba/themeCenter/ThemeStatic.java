package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AllThemeListActivityConfig;
import com.baidu.tbadk.core.atomData.DownloadedThemeListActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.atomData.SkinDetailActivityConfig;
import com.baidu.tbadk.core.atomData.TopThemeListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.themeCenter.background.BackgroundGroupActivity;
import com.baidu.tieba.themeCenter.background.BackgroundListActivity;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity;
import com.baidu.tieba.themeCenter.theme.all.AllThemeListActivity;
import com.baidu.tieba.themeCenter.theme.detail.SkinDetailActivity;
import com.baidu.tieba.themeCenter.theme.download.DownloadedThemeListActivity;
import com.baidu.tieba.themeCenter.theme.top.TopThemeListActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ThemeStatic {
    static {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_NEED_ADD_ITEM));
        TbadkApplication.getInst().RegisterIntent(DressupCenterActivityConfig.class, DressupCenterActivity.class);
        TbadkApplication.getInst().RegisterIntent(TopThemeListActivityConfig.class, TopThemeListActivity.class);
        TbadkApplication.getInst().RegisterIntent(AllThemeListActivityConfig.class, AllThemeListActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonalBackdropGroupActivityConfig.class, BackgroundGroupActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonalBackdropListActivityConfig.class, BackgroundListActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonalBackgroundPreviewActivityConfig.class, BackgroundPreviewActivity.class);
        TbadkApplication.getInst().RegisterIntent(SkinDetailActivityConfig.class, SkinDetailActivity.class);
        TbadkApplication.getInst().RegisterIntent(DownloadedThemeListActivityConfig.class, DownloadedThemeListActivity.class);
        MessageManager.getInstance().registerListener(new o(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_THEME_CENTER_RES_TOOL, new p());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(new CustomMessageTask(CmdConfigCustom.CMD_INSERT_SKINT_DATA_TO_DB, new q()));
        MessageManager.getInstance().registerTask(new CustomMessageTask(CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB, new r()));
        MessageManager.getInstance().registerTask(new CustomMessageTask(CmdConfigCustom.CMD_DELETE_SKINT_DATA_FROM_DB, new s()));
        MessageManager.getInstance().registerTask(new CustomMessageTask(CmdConfigCustom.CMD_DELETE_SKIN_TEMP_FILE, new t()));
    }

    public static List<b> by(List<b> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            if (bVar != null) {
                if (com.baidu.tbadk.core.util.n.cG(String.valueOf(bVar.getId()) + ".apk")) {
                    arrayList.add(bVar);
                } else {
                    l.azi().ls(bVar.getId());
                }
            }
        }
        return arrayList;
    }
}
