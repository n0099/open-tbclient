package com.baidu.tieba.interestlabel.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.message.RequestGetLabelMessage;
import com.baidu.tieba.interestlabel.message.RequestSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketSubLabelMessage;
import java.util.List;
/* loaded from: classes17.dex */
public class LabelSettingModel extends BdBaseModel {
    private com.baidu.adp.framework.listener.a jvH;
    private com.baidu.adp.framework.listener.a jvI;
    private a jvx;
    private b mLabelDataSet;
    private TbPageContext<?> mPageContext;

    public LabelSettingModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.jvH = new com.baidu.adp.framework.listener.a(1003333, CmdConfigSocket.CMD_GET_INTEREST_LABEL_LIST) { // from class: com.baidu.tieba.interestlabel.model.LabelSettingModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ResponseHttpGetLabelMessage) || (responsedMessage instanceof ResponseSocketGetLabelMessage)) && LabelSettingModel.this.unique_id == responsedMessage.getOrginalMessage().getTag() && LabelSettingModel.this.jvx != null) {
                        LabelSettingModel.this.jvx.a(LabelRequestEnum.GET_LABEL, responsedMessage.getError() == 0 ? LabelSettingModel.this.mLabelDataSet : null, responsedMessage.getError());
                    }
                }
            }
        };
        this.jvI = new com.baidu.adp.framework.listener.a(1003334, CmdConfigSocket.CMD_SUB_INTEREST_LABEL_LIST) { // from class: com.baidu.tieba.interestlabel.model.LabelSettingModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ResponseHttpSubLabelMessage) || (responsedMessage instanceof ResponseSocketSubLabelMessage)) && LabelSettingModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        if (responsedMessage.getError() != 0 && !StringUtils.isNull(responsedMessage.getErrorString())) {
                            LabelSettingModel.this.mPageContext.showToast(responsedMessage.getErrorString());
                        }
                        if (LabelSettingModel.this.jvx != null) {
                            LabelSettingModel.this.jvx.a(LabelRequestEnum.SUB_LABEL, null, responsedMessage.getError());
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mLabelDataSet = new b();
        registerListener(this.jvH);
        registerListener(this.jvI);
    }

    public void a(a aVar) {
        this.jvx = aVar;
    }

    public void cAu() {
        if (!j.isNetworkAvailableForImmediately()) {
            if (this.jvx != null) {
                this.jvx.a(LabelRequestEnum.GET_LABEL, null, -1);
                return;
            }
            return;
        }
        RequestGetLabelMessage requestGetLabelMessage = new RequestGetLabelMessage();
        requestGetLabelMessage.setFrom(1);
        requestGetLabelMessage.setLabelDataSet(this.mLabelDataSet);
        requestGetLabelMessage.setTag(this.unique_id);
        sendMessage(requestGetLabelMessage);
    }

    public void dM(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        RequestSubLabelMessage requestSubLabelMessage = new RequestSubLabelMessage();
        requestSubLabelMessage.setLabelList(list);
        requestSubLabelMessage.setTag(this.unique_id);
        sendMessage(requestSubLabelMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }
}
