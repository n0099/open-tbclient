package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.themeCenter.IThemeCenterResTool;
/* loaded from: classes.dex */
class r implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<IThemeCenterResTool> run(CustomMessage<String> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_THEME_CENTER_RES_TOOL, new p());
    }
}
