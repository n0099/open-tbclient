package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.e<y> {
    private com.baidu.adp.framework.listener.a aQK = new z(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, 309023);
    private int deT;
    private int dfm;
    private a dfz;
    private DressItemData mBgItem;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, DressItemData dressItemData);
    }

    public y(int i, int i2) {
        this.deT = i;
        this.dfm = i2;
        BZ();
        registerListener(this.aQK);
    }

    private void BZ() {
        com.baidu.tieba.tbadkCore.a.a.a(309023, BackgroundGetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309023, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, TbConfig.PERSONAL_BACKGROUND_GET, BackgroundGetHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        BackgroundGetRequestMessage backgroundGetRequestMessage = new BackgroundGetRequestMessage();
        backgroundGetRequestMessage.setPropId(this.deT);
        sendMessage(backgroundGetRequestMessage);
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.dfz = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aQK);
    }
}
