package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.e<y> {
    private com.baidu.adp.framework.listener.a aWh = new z(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, 309023);
    private int dED;
    private int dEY;
    private a dFl;
    private DressItemData mBgItem;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, DressItemData dressItemData);
    }

    public y(int i, int i2) {
        this.dED = i;
        this.dEY = i2;
        CQ();
        registerListener(this.aWh);
    }

    private void CQ() {
        com.baidu.tieba.tbadkCore.a.a.a(309023, BackgroundGetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309023, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, TbConfig.PERSONAL_BACKGROUND_GET, BackgroundGetHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        BackgroundGetRequestMessage backgroundGetRequestMessage = new BackgroundGetRequestMessage();
        backgroundGetRequestMessage.setPropId(this.dED);
        sendMessage(backgroundGetRequestMessage);
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.dFl = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aWh);
    }
}
