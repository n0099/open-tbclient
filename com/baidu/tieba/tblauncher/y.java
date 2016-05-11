package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
class y implements CustomMessageTask.CustomRunnable<Game> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Game> customMessage) {
        if (customMessage == null) {
            return null;
        }
        if (customMessage.getData() != null) {
            com.baidu.tbadk.mainTab.d.a(customMessage.getData());
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_SHOW_GAME_ICON);
    }
}
