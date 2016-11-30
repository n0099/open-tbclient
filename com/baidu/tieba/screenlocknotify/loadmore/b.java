package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.adp.base.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
/* loaded from: classes.dex */
public class b extends e<ScreenLockActivity> {
    public b(ScreenLockActivity screenLockActivity) {
        super(screenLockActivity.getPageContext());
        Ei();
    }

    private void Ei() {
        com.baidu.tieba.tbadkCore.a.a.a(309420, ScreenLockLoadMoreSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309420, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, TbConfig.CMD_SCREEN_LOCK_MESSAGE_MORE, ScreenLockLoadMoreHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        return true;
    }

    public void bfg() {
        sendMessage(new ScreenLockLoadMoreMessage());
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
