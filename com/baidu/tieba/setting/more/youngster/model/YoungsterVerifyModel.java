package com.baidu.tieba.setting.more.youngster.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.YoungsterVerifyActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.youngster.message.YoungsterVerifyHttpResponsedMessage;
/* loaded from: classes25.dex */
public class YoungsterVerifyModel extends BdBaseModel {
    private HttpMessageListener mHttpMessageListener;
    a mKn;
    TbPageContext<?> pageContext;

    /* loaded from: classes25.dex */
    public interface a {
        void b(ErrorData errorData);

        void onSuccess();
    }

    public YoungsterVerifyModel(TbPageContext<?> tbPageContext, a aVar) {
        super(tbPageContext);
        this.mHttpMessageListener = new HttpMessageListener(CmdConfigHttp.CMD_GET_YOUNGSTER_VERIFY_AUTHID) { // from class: com.baidu.tieba.setting.more.youngster.model.YoungsterVerifyModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String str;
                YoungsterVerifyHttpResponsedMessage youngsterVerifyHttpResponsedMessage;
                if (httpResponsedMessage != null) {
                    YoungsterVerifyModel.this.mErrorCode = httpResponsedMessage.getError();
                    YoungsterVerifyModel.this.mErrorString = httpResponsedMessage.getErrorString();
                    if (!StringUtils.isNull(YoungsterVerifyModel.this.mErrorString)) {
                        str = YoungsterVerifyModel.this.mErrorString;
                    } else {
                        str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                    }
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(YoungsterVerifyModel.this.mErrorCode);
                    errorData.setError_msg(str);
                    if (!(httpResponsedMessage instanceof YoungsterVerifyHttpResponsedMessage)) {
                        youngsterVerifyHttpResponsedMessage = null;
                    } else {
                        youngsterVerifyHttpResponsedMessage = (YoungsterVerifyHttpResponsedMessage) httpResponsedMessage;
                    }
                    if (youngsterVerifyHttpResponsedMessage != null && youngsterVerifyHttpResponsedMessage.getData() != null && youngsterVerifyHttpResponsedMessage.getData().isSuccess) {
                        YoungsterVerifyModel.this.mKn.onSuccess();
                    } else {
                        YoungsterVerifyModel.this.mKn.b(errorData);
                    }
                }
            }
        };
        this.pageContext = tbPageContext;
        this.mHttpMessageListener.setSelfListener(true);
        registerListener(this.mHttpMessageListener);
        this.mKn = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void RB(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_YOUNGSTER_VERIFY_AUTHID);
        httpMessage.addParam(YoungsterVerifyActivityConfig.PARAMA_AUTH_ID, str);
        httpMessage.addParam("scene", YoungsterVerifyActivityConfig.PARAMA_TIEBA_AUTH);
        this.pageContext.sendMessage(httpMessage);
    }
}
