package com.baidu.tieba.memberCenter.memberExchange;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.MemberExchangeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class MemberExchangeActivity extends BaseActivity<MemberExchangeActivity> implements View.OnClickListener {
    public String descStr;
    public String dueDate;
    public HttpMessageListener getTCodeInfoListener = new a(CmdConfigHttp.CMD_GET_TCODE_INFO_CMD);
    public d.b.j0.r1.d.a mView;
    public String memberImage;
    public String memberLevelIcon;
    public String memberName;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetTCodeResMessage) {
                GetTCodeResMessage getTCodeResMessage = (GetTCodeResMessage) httpResponsedMessage;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (getTCodeResMessage.getTCodeInfo() != null) {
                        if (getTCodeResMessage.getTCodeInfo().f61455a.equals("0")) {
                            MemberExchangeActivity.this.showToast(R.string.exchange_success);
                            return;
                        } else {
                            MemberExchangeActivity.this.showToast(R.string.exchange_error);
                            return;
                        }
                    }
                    MemberExchangeActivity.this.showToast(R.string.neterror);
                    return;
                }
                String errorString = httpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString) || StringUtil.NULL_STRING.equals(errorString)) {
                    errorString = MemberExchangeActivity.this.getResources().getString(R.string.neterror);
                }
                MemberExchangeActivity.this.showToast(errorString);
            }
        }
    }

    private void initListener() {
        registerListener(this.getTCodeInfoListener);
    }

    private void initTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_TCODE_INFO_CMD, TbConfig.SERVER_ADDRESS + TbConfig.GET_T_CODE_INFO);
        tbHttpMessageTask.setResponsedClass(GetTCodeResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void requestTCodeInfo() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_TCODE_INFO_CMD);
        httpMessage.addParam(GetTCodeResMessage.ACTIVATION_CODE, this.mView.b().getText().toString());
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (view.getId() == R.id.go_to_exchange) {
            requestTCodeInfo();
        } else {
            l.w(getPageContext().getPageActivity(), this.mView.b());
        }
    }

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
        initTask();
        initListener();
        d.b.j0.r1.d.a aVar = new d.b.j0.r1.d.a(this);
        this.mView = aVar;
        aVar.a(this.memberImage, this.memberName, this.memberLevelIcon, this.dueDate, this.descStr);
    }
}
