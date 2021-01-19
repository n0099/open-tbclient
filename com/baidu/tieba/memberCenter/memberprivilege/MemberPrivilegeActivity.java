package com.baidu.tieba.memberCenter.memberprivilege;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.a;
import java.util.Map;
/* loaded from: classes8.dex */
public class MemberPrivilegeActivity extends BaseActivity<MemberPrivilegeActivity> {
    private d ljh;
    private String SCENE_ID = "4001001000";
    private HttpMessageListener lji = new HttpMessageListener(1001531) { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            MemberPrivilegeActivity.this.hideLoadingView(MemberPrivilegeActivity.this.ljh.getRootView());
            if ((httpResponsedMessage instanceof ResponseMemberPrivilegeMessage) && httpResponsedMessage.getCmd() == 1001531) {
                int error = httpResponsedMessage.getError();
                ResponseMemberPrivilegeMessage responseMemberPrivilegeMessage = (ResponseMemberPrivilegeMessage) httpResponsedMessage;
                if (error != 0) {
                    MemberPrivilegeActivity.this.showToast(StringUtils.isNull(responseMemberPrivilegeMessage.getErrorString()) ? MemberPrivilegeActivity.this.getResources().getString(R.string.neterror) : responseMemberPrivilegeMessage.getErrorString());
                } else if (responseMemberPrivilegeMessage.mData != null) {
                    MemberPrivilegeActivity.this.ljh.ddL().a(responseMemberPrivilegeMessage.mData);
                } else {
                    MemberPrivilegeActivity.this.showToast(R.string.neterror);
                }
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ((Integer) customResponsedMessage.getData()) != null) {
                MemberPrivilegeActivity.this.ddK();
            }
        }
    };
    private final CustomMessageListener jNe = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                MemberPrivilegeActivity.this.ddK();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ddJ();
        registerListener(this.mMemListener);
        registerListener(this.jNe);
        registerListener(this.lji);
        initUI();
        ddK();
    }

    private void initUI() {
        this.ljh = new d((MemberPrivilegeActivity) getPageContext().getOrignalPage());
    }

    private void ddJ() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001531, TbConfig.SERVER_ADDRESS + TbConfig.MEMBER_PRIVILEGE);
        tbHttpMessageTask.setResponsedClass(ResponseMemberPrivilegeMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void ddK() {
        showLoadingView(this.ljh.getRootView(), true);
        HttpMessage httpMessage = new HttpMessage(1001531);
        httpMessage.addParam("st_type", "shop");
        sendMessage(httpMessage);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ljh.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != 0 && 1 != this.ljh.ddL().getItemViewType(i)) {
            String str = ((a.C0793a) this.ljh.ddL().getItem(i)).mLink;
            String str2 = ((a.C0793a) this.ljh.ddL().getItem(i)).mTitle;
            if (!at.isEmpty(str)) {
                if (Np(str)) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleChooseActivityConfig(getPageContext().getPageActivity())));
                } else {
                    com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), str2, str, true, true, true);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (R.id.left_button == view.getId()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_33", "click", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(getPageContext().getPageActivity(), 0, "pay", 3, 1, this.SCENE_ID)));
        } else if (R.id.right_button == view.getId()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, 1, this.SCENE_ID, PageDialogHelper.PayForm.NOT_SET)));
        }
    }

    private boolean Np(String str) {
        Map<String, String> paramPair;
        return (TextUtils.isEmpty(str) || (paramPair = be.getParamPair(be.getParamStr(str))) == null || !"1".equals(paramPair.get("type"))) ? false : true;
    }
}
