package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
import d.a.n0.e3.d0.a;
/* loaded from: classes5.dex */
public class ScreenLockLoadMoreModel extends BdBaseModel<ScreenLockActivity> {
    public ScreenLockLoadMoreModel(ScreenLockActivity screenLockActivity) {
        super(screenLockActivity.getPageContext());
        registerTask();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public final void registerTask() {
        a.h(309420, ScreenLockLoadMoreSocketResponseMessage.class, false, false);
        a.c(309420, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, TbConfig.CMD_SCREEN_LOCK_MESSAGE_MORE, ScreenLockLoadMoreHttpResponseMessage.class, false, false, false, false);
    }

    public void w() {
        sendMessage(new ScreenLockLoadMoreMessage());
    }
}
