package com.baidu.tieba.memberCenter.memberExchange;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.MemberExchangeActivityConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class MemberExchangeActivity extends BaseActivity<MemberExchangeActivity> implements View.OnClickListener {
    private String descStr;
    private String dueDate;
    private a lnv;
    public HttpMessageListener lnw = new HttpMessageListener(1003320) { // from class: com.baidu.tieba.memberCenter.memberExchange.MemberExchangeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetTCodeResMessage) {
                GetTCodeResMessage getTCodeResMessage = (GetTCodeResMessage) httpResponsedMessage;
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (StringUtils.isNull(errorString) || "null".equals(errorString)) {
                        errorString = MemberExchangeActivity.this.getResources().getString(R.string.neterror);
                    }
                    MemberExchangeActivity.this.showToast(errorString);
                } else if (getTCodeResMessage.getTCodeInfo() != null) {
                    if (getTCodeResMessage.getTCodeInfo().errorCode.equals("0")) {
                        MemberExchangeActivity.this.showToast(R.string.exchange_success);
                    } else {
                        MemberExchangeActivity.this.showToast(R.string.exchange_error);
                    }
                } else {
                    MemberExchangeActivity.this.showToast(R.string.neterror);
                }
            }
        }
    };
    private String memberImage;
    private String memberLevelIcon;
    private String memberName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.memberImage = bundle.getString(MemberExchangeActivityConfig.MEMBER_IMAGE);
            this.memberName = bundle.getString(MemberExchangeActivityConfig.MEMBER_NAME);
            this.memberLevelIcon = bundle.getString(MemberExchangeActivityConfig.MEMBER_LEVEL_IMAGE);
            this.dueDate = bundle.getString(MemberExchangeActivityConfig.DUE_DATE);
            this.descStr = bundle.getString(MemberExchangeActivityConfig.DESC_STR);
        } else if (getIntent() != null) {
            this.memberImage = getIntent().getStringExtra(MemberExchangeActivityConfig.MEMBER_IMAGE);
            this.memberName = getIntent().getStringExtra(MemberExchangeActivityConfig.MEMBER_NAME);
            this.memberLevelIcon = getIntent().getStringExtra(MemberExchangeActivityConfig.MEMBER_LEVEL_IMAGE);
            this.dueDate = getIntent().getStringExtra(MemberExchangeActivityConfig.DUE_DATE);
            this.descStr = getIntent().getStringExtra(MemberExchangeActivityConfig.DESC_STR);
        }
        abY();
        initListener();
        this.lnv = new a(this);
        this.lnv.l(this.memberImage, this.memberName, this.memberLevelIcon, this.dueDate, this.descStr);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.go_to_exchange) {
                dfh();
            } else {
                l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lnv.getEditText());
            }
        }
    }

    private void abY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003320, TbConfig.SERVER_ADDRESS + TbConfig.GET_T_CODE_INFO);
        tbHttpMessageTask.setResponsedClass(GetTCodeResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void initListener() {
        registerListener(this.lnw);
    }

    private void dfh() {
        HttpMessage httpMessage = new HttpMessage(1003320);
        httpMessage.addParam(GetTCodeResMessage.ACTIVATION_CODE, this.lnv.getEditText().getText().toString());
        sendMessage(httpMessage);
    }
}
