package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.model.message.AddPollPostHttpResponseMessage;
import com.baidu.tieba.model.message.AddPollPostRequestNetMessage;
import com.baidu.tieba.model.message.AddPollPostSocketResponseMessage;
/* loaded from: classes.dex */
public class AddPollPostModel extends BdBaseModel {
    private long eoP;
    private a kXi;
    private com.baidu.adp.framework.listener.a kXj;

    /* loaded from: classes.dex */
    public interface a {
        void aE(int i, String str);
    }

    public AddPollPostModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kXj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_POLL_POST, 309006) { // from class: com.baidu.tieba.model.AddPollPostModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str;
                int i;
                if (responsedMessage != null && (responsedMessage.getOrginalMessage().getExtra() instanceof AddPollPostRequestNetMessage) && AddPollPostModel.this.eoP == ((AddPollPostRequestNetMessage) responsedMessage.getOrginalMessage().getExtra()).getThreadId()) {
                    if ((responsedMessage instanceof AddPollPostHttpResponseMessage) || (responsedMessage instanceof AddPollPostSocketResponseMessage)) {
                        AddPollPostHttpResponseMessage addPollPostHttpResponseMessage = responsedMessage instanceof AddPollPostHttpResponseMessage ? (AddPollPostHttpResponseMessage) responsedMessage : null;
                        AddPollPostSocketResponseMessage addPollPostSocketResponseMessage = responsedMessage instanceof AddPollPostSocketResponseMessage ? (AddPollPostSocketResponseMessage) responsedMessage : null;
                        if (responsedMessage.getError() != 0) {
                            i = responsedMessage.getError();
                            str = responsedMessage.getErrorString();
                        } else if (addPollPostHttpResponseMessage != null && addPollPostHttpResponseMessage.getIdl() != null && addPollPostHttpResponseMessage.getIdl().data != null && addPollPostHttpResponseMessage.getIdl().data.error_code.intValue() != 0) {
                            int intValue = addPollPostHttpResponseMessage.getIdl().data.error_code.intValue();
                            str = addPollPostHttpResponseMessage.getIdl().data.error_msg;
                            i = intValue;
                        } else if (addPollPostSocketResponseMessage == null || addPollPostSocketResponseMessage.getIdl() == null || addPollPostSocketResponseMessage.getIdl().data == null || addPollPostSocketResponseMessage.getIdl().data.error_code.intValue() == 0) {
                            str = "";
                            i = 0;
                        } else {
                            i = addPollPostSocketResponseMessage.getIdl().data.error_code.intValue();
                            str = addPollPostSocketResponseMessage.getIdl().data.error_msg;
                        }
                        if (AddPollPostModel.this.kXi != null) {
                            AddPollPostModel.this.kXi.aE(i, str);
                        }
                    }
                }
            }
        };
        cHT();
    }

    private void cHT() {
        com.baidu.tieba.tbadkCore.a.a.a(309006, AddPollPostSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309006, CmdConfigHttp.CMD_ADD_POLL_POST, TbConfig.VOTE_ADD, AddPollPostHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void registerListener() {
        registerListener(this.kXj);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.kXj);
    }

    public void a(a aVar) {
        this.kXi = aVar;
    }

    public void setTid(long j) {
        this.eoP = j;
    }

    public void j(String str, String str2, long j) {
        AddPollPostRequestNetMessage addPollPostRequestNetMessage = new AddPollPostRequestNetMessage();
        addPollPostRequestNetMessage.setThreadId(com.baidu.adp.lib.f.b.toLong(str, 0L));
        addPollPostRequestNetMessage.setOptions(str2);
        addPollPostRequestNetMessage.setForumId(j);
        sendMessage(addPollPostRequestNetMessage);
    }
}
