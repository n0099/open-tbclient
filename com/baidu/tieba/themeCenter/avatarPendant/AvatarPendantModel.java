package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.List;
/* loaded from: classes9.dex */
public class AvatarPendantModel extends BdBaseModel<AvatarPendantActivity> {
    private com.baidu.adp.framework.listener.a jbH;
    private List<com.baidu.tieba.themeCenter.avatarPendant.a> mAvatarPendantList;
    private e mRecommand;
    private a nFR;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, String str, e eVar, List<com.baidu.tieba.themeCenter.avatarPendant.a> list);
    }

    public AvatarPendantModel(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.jbH = new com.baidu.adp.framework.listener.a(1003178, CmdConfigSocket.CMD_AVATAR_APENDANT) { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof AvatarPendantListSocketResponseMessage) || (responsedMessage instanceof AvatarPendantListHttpResponseMessage)) {
                        if (responsedMessage instanceof AvatarPendantListSocketResponseMessage) {
                            AvatarPendantListSocketResponseMessage avatarPendantListSocketResponseMessage = (AvatarPendantListSocketResponseMessage) responsedMessage;
                            AvatarPendantModel.this.mAvatarPendantList = avatarPendantListSocketResponseMessage.getAvatarPendantListList();
                            AvatarPendantModel.this.mRecommand = avatarPendantListSocketResponseMessage.getRecommand();
                        } else if (responsedMessage instanceof AvatarPendantListHttpResponseMessage) {
                            AvatarPendantListHttpResponseMessage avatarPendantListHttpResponseMessage = (AvatarPendantListHttpResponseMessage) responsedMessage;
                            AvatarPendantModel.this.mAvatarPendantList = avatarPendantListHttpResponseMessage.getAvatarPendantListList();
                            AvatarPendantModel.this.mRecommand = avatarPendantListHttpResponseMessage.getRecommand();
                        }
                        if (AvatarPendantModel.this.nFR != null) {
                            AvatarPendantModel.this.nFR.a(responsedMessage.getError(), responsedMessage.getErrorString(), AvatarPendantModel.this.mRecommand, AvatarPendantModel.this.mAvatarPendantList);
                        }
                    }
                }
            }
        };
        registerTask();
        registerListener(this.jbH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new AvatarPendantListRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.nFR = aVar;
    }

    public List<com.baidu.tieba.themeCenter.avatarPendant.a> dQZ() {
        return this.mAvatarPendantList;
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_AVATAR_APENDANT, AvatarPendantListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_AVATAR_APENDANT, 1003178, TbConfig.AVATAR_PENDANT, AvatarPendantListHttpResponseMessage.class, true, true, true, true);
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.jbH);
    }
}
