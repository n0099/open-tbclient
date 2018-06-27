package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
/* loaded from: classes3.dex */
public class ScreenLockLoadMoreModel extends BdBaseModel<ScreenLockActivity> {
    public ScreenLockLoadMoreModel(ScreenLockActivity screenLockActivity) {
        super(screenLockActivity.getPageContext());
        registerTask();
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309420, ScreenLockLoadMoreSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309420, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, TbConfig.CMD_SCREEN_LOCK_MESSAGE_MORE, ScreenLockLoadMoreHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return true;
    }

    public void bqn() {
        sendMessage(new ScreenLockLoadMoreMessage());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
