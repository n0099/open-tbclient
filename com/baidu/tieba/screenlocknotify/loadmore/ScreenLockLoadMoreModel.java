package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
/* loaded from: classes6.dex */
public class ScreenLockLoadMoreModel extends BdBaseModel<ScreenLockActivity> {
    public ScreenLockLoadMoreModel(ScreenLockActivity screenLockActivity) {
        super(screenLockActivity.getPageContext());
        rT();
    }

    private void rT() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE, ScreenLockLoadMoreSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE, 1003194, TbConfig.CMD_SCREEN_LOCK_MESSAGE_MORE, ScreenLockLoadMoreHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return true;
    }

    public void cCC() {
        sendMessage(new ScreenLockLoadMoreMessage());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
