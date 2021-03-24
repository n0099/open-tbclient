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
/* loaded from: classes5.dex */
public class YoungsterVerifyModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f21062e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f21063f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessageListener f21064g;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            if (httpResponsedMessage == null) {
                return;
            }
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
            YoungsterVerifyHttpResponsedMessage youngsterVerifyHttpResponsedMessage = httpResponsedMessage instanceof YoungsterVerifyHttpResponsedMessage ? (YoungsterVerifyHttpResponsedMessage) httpResponsedMessage : null;
            if (youngsterVerifyHttpResponsedMessage != null && youngsterVerifyHttpResponsedMessage.getData() != null && youngsterVerifyHttpResponsedMessage.getData().f61403a) {
                YoungsterVerifyModel.this.f21062e.onSuccess();
            } else {
                YoungsterVerifyModel.this.f21062e.onError(errorData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onError(ErrorData errorData);

        void onSuccess();
    }

    public YoungsterVerifyModel(TbPageContext<?> tbPageContext, b bVar) {
        super(tbPageContext);
        a aVar = new a(CmdConfigHttp.CMD_GET_YOUNGSTER_VERIFY_AUTHID);
        this.f21064g = aVar;
        this.f21063f = tbPageContext;
        aVar.setSelfListener(true);
        registerListener(this.f21064g);
        this.f21062e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void x(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_YOUNGSTER_VERIFY_AUTHID);
        httpMessage.addParam(YoungsterVerifyActivityConfig.PARAMA_AUTH_ID, str);
        httpMessage.addParam("scene", YoungsterVerifyActivityConfig.PARAMA_TIEBA_AUTH);
        this.f21063f.sendMessage(httpMessage);
    }
}
