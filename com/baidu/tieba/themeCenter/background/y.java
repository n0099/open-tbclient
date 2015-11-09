package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.e<y> {
    private com.baidu.adp.framework.listener.a aRd = new z(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, 309023);
    private int dgZ;
    private a dhF;
    private int dhs;
    private DressItemData mBgItem;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, DressItemData dressItemData);
    }

    public y(int i, int i2) {
        this.dgZ = i;
        this.dhs = i2;
        BP();
        registerListener(this.aRd);
    }

    private void BP() {
        com.baidu.tieba.tbadkCore.a.a.a(309023, BackgroundGetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309023, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, TbConfig.PERSONAL_BACKGROUND_GET, BackgroundGetHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        BackgroundGetRequestMessage backgroundGetRequestMessage = new BackgroundGetRequestMessage();
        backgroundGetRequestMessage.setPropId(this.dgZ);
        sendMessage(backgroundGetRequestMessage);
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.dhF = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aRd);
    }
}
