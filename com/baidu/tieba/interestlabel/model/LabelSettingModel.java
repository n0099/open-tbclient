package com.baidu.tieba.interestlabel.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.e;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.message.RequestGetLabelMessage;
import com.baidu.tieba.interestlabel.message.RequestSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketSubLabelMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelSettingModel extends BdBaseModel {
    private a fnb;
    private com.baidu.adp.framework.listener.a fnl;
    private com.baidu.adp.framework.listener.a fnm;
    private b mLabelDataSet;
    private TbPageContext<?> mPageContext;

    public LabelSettingModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fnl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST, 309467) { // from class: com.baidu.tieba.interestlabel.model.LabelSettingModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ResponseHttpGetLabelMessage) || (responsedMessage instanceof ResponseSocketGetLabelMessage)) && LabelSettingModel.this.unique_id == responsedMessage.getOrginalMessage().getTag() && LabelSettingModel.this.fnb != null) {
                        LabelSettingModel.this.fnb.a(LabelRequestEnum.GET_LABEL, responsedMessage.getError() == 0 ? LabelSettingModel.this.mLabelDataSet : null, responsedMessage.getError());
                    }
                }
            }
        };
        this.fnm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SUB_INTEREST_LABEL_LIST, 309468) { // from class: com.baidu.tieba.interestlabel.model.LabelSettingModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ResponseHttpSubLabelMessage) || (responsedMessage instanceof ResponseSocketSubLabelMessage)) && LabelSettingModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        if (responsedMessage.getError() != 0 && !StringUtils.isNull(responsedMessage.getErrorString())) {
                            LabelSettingModel.this.mPageContext.showToast(responsedMessage.getErrorString());
                        }
                        if (LabelSettingModel.this.fnb != null) {
                            LabelSettingModel.this.fnb.a(LabelRequestEnum.SUB_LABEL, null, responsedMessage.getError());
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mLabelDataSet = new b();
        registerListener(this.fnl);
        registerListener(this.fnm);
    }

    public void a(a aVar) {
        this.fnb = aVar;
    }

    public void aYr() {
        if (!j.kK()) {
            if (this.fnb != null) {
                this.fnb.a(LabelRequestEnum.GET_LABEL, null, -1);
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

    public void cR(List<Integer> list) {
        if (!j.kK()) {
            this.mPageContext.showToast(e.j.neterror);
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
