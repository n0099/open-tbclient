package com.baidu.tieba.ueg;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class UEGCancelModel extends BdBaseModel {
    private a mbg;
    private final com.baidu.adp.framework.listener.a mbh = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_UEG_CANCEL, 309615) { // from class: com.baidu.tieba.ueg.UEGCancelModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UEGCancelResponsedMessage uEGCancelResponsedMessage;
            if (responsedMessage != null) {
                if (((responsedMessage instanceof UEGCancelSocketResponseMessage) || (responsedMessage instanceof UEGCancelResponsedMessage)) && UEGCancelModel.this.mbg != null) {
                    if (responsedMessage instanceof UEGCancelSocketResponseMessage) {
                        UEGCancelSocketResponseMessage uEGCancelSocketResponseMessage = (UEGCancelSocketResponseMessage) responsedMessage;
                        if (uEGCancelSocketResponseMessage != null && uEGCancelSocketResponseMessage.getError() == 0) {
                            UEGCancelModel.this.mbg.d(uEGCancelSocketResponseMessage.getData());
                        }
                    } else if ((responsedMessage instanceof UEGCancelResponsedMessage) && (uEGCancelResponsedMessage = (UEGCancelResponsedMessage) responsedMessage) != null && uEGCancelResponsedMessage.getError() == 0) {
                        UEGCancelModel.this.mbg.d(uEGCancelResponsedMessage.getData());
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void d(BlockPopInfoData blockPopInfoData);
    }

    public UEGCancelModel() {
        com.baidu.tieba.tbadkCore.a.a.a(309615, UEGCancelSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309615, CmdConfigHttp.CMD_UEG_CANCEL, "c/f/forum/queryBlockAndAppealInfo", UEGCancelResponsedMessage.class, false, false, true, false);
        registerListener(this.mbh);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void cancelRequest() {
        if (j.isNetWorkAvailable() && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            UEGCancelRequestMessage uEGCancelRequestMessage = new UEGCancelRequestMessage();
            uEGCancelRequestMessage.setUser_id(TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(uEGCancelRequestMessage);
        }
    }

    public void a(a aVar) {
        this.mbg = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mbh);
    }
}
