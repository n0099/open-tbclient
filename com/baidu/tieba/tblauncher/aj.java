package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import protobuf.GetOnlineInfo.Game;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements CustomMessageTask.CustomRunnable<Game> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Game> customMessage) {
        if (customMessage == null) {
            return null;
        }
        if (customMessage.getData() != null) {
            MainTabActivityStatic.cVc = customMessage.getData();
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_SHOW_GAME_ICON);
    }
}
