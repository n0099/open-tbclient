package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* loaded from: classes8.dex */
public class DressupCenterModel extends BdBaseModel<DressupCenterModel> {
    private com.baidu.adp.framework.listener.a jdE = new com.baidu.adp.framework.listener.a(1003030, CmdConfigSocket.CMD_DRESSUP_CENTER) { // from class: com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof DressupCenterHttpResponseMessage) || (responsedMessage instanceof DressupCenterSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        if (DressupCenterModel.this.nLw != null) {
                            DressupCenterModel.this.nLw.a(responsedMessage.getError(), responsedMessage.getErrorString(), DressupCenterModel.this.mThemeCarouselList, DressupCenterModel.this.mRecommand, DressupCenterModel.this.mThemeList);
                            return;
                        }
                        return;
                    }
                    if (responsedMessage instanceof DressupCenterHttpResponseMessage) {
                        DressupCenterHttpResponseMessage dressupCenterHttpResponseMessage = (DressupCenterHttpResponseMessage) responsedMessage;
                        DressupCenterModel.this.mThemeList = dressupCenterHttpResponseMessage.getThemeList();
                        DressupCenterModel.this.mRecommand = dressupCenterHttpResponseMessage.getRecommand();
                        DressupCenterModel.this.mThemeCarouselList = dressupCenterHttpResponseMessage.getThemeCarouselList();
                    } else if (responsedMessage instanceof DressupCenterSocketResponseMessage) {
                        DressupCenterSocketResponseMessage dressupCenterSocketResponseMessage = (DressupCenterSocketResponseMessage) responsedMessage;
                        DressupCenterModel.this.mThemeList = dressupCenterSocketResponseMessage.getThemeList();
                        DressupCenterModel.this.mRecommand = dressupCenterSocketResponseMessage.getRecommand();
                        DressupCenterModel.this.mThemeCarouselList = dressupCenterSocketResponseMessage.getThemeCarouselList();
                    }
                    if (DressupCenterModel.this.nLw != null) {
                        DressupCenterModel.this.nLw.a(responsedMessage.getError(), responsedMessage.getErrorString(), DressupCenterModel.this.mThemeCarouselList, DressupCenterModel.this.mRecommand, DressupCenterModel.this.mThemeList);
                    }
                }
            }
        }
    };
    private e mRecommand;
    private List<com.baidu.tieba.themeCenter.dressCenter.a> mThemeCarouselList;
    private List<d> mThemeList;
    private boolean nJf;
    private a nLw;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, String str, List<com.baidu.tieba.themeCenter.dressCenter.a> list, e eVar, List<d> list2);
    }

    public DressupCenterModel(DressupCenterActivity dressupCenterActivity) {
        this.nJf = dressupCenterActivity.getIntent().getBooleanExtra("member_buy_show", false);
        registerTask();
        registerListener(this.jdE);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_DRESSUP_CENTER, DressupCenterSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_DRESSUP_CENTER, 1003030, TbConfig.DRESSUP_CENTER_PAGE, DressupCenterHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new DressupCenterRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.nLw = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.jdE);
    }

    public boolean dLf() {
        return this.nJf;
    }
}
