package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tieba.tbadkCore.l.a> run(CustomMessage<String> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_THEME_CENTER_RES_TOOL, new n());
    }
}
