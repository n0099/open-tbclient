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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.a;
import java.util.Map;
/* loaded from: classes9.dex */
public class MemberPrivilegeActivity extends BaseActivity<MemberPrivilegeActivity> {
    private d lrB;
    private String SCENE_ID = "4001001000";
    private HttpMessageListener lrC = new HttpMessageListener(1001531) { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            MemberPrivilegeActivity.this.hideLoadingView(MemberPrivilegeActivity.this.lrB.getRootView());
            if ((httpResponsedMessage instanceof ResponseMemberPrivilegeMessage) && httpResponsedMessage.getCmd() == 1001531) {
                int error = httpResponsedMessage.getError();
                ResponseMemberPrivilegeMessage responseMemberPrivilegeMessage = (ResponseMemberPrivilegeMessage) httpResponsedMessage;
                if (error != 0) {
                    MemberPrivilegeActivity.this.showToast(StringUtils.isNull(responseMemberPrivilegeMessage.getErrorString()) ? MemberPrivilegeActivity.this.getResources().getString(R.string.neterror) : responseMemberPrivilegeMessage.getErrorString());
                } else if (responseMemberPrivilegeMessage.mData != null) {
                    MemberPrivilegeActivity.this.lrB.dfS().a(responseMemberPrivilegeMessage.mData);
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
                MemberPrivilegeActivity.this.dfR();
            }
        }
    };
    private final CustomMessageListener jUU = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                MemberPrivilegeActivity.this.dfR();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dfQ();
        registerListener(this.mMemListener);
        registerListener(this.jUU);
        registerListener(this.lrC);
        initUI();
        dfR();
    }

    private void initUI() {
        this.lrB = new d((MemberPrivilegeActivity) getPageContext().getOrignalPage());
    }

    private void dfQ() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001531, TbConfig.SERVER_ADDRESS + TbConfig.MEMBER_PRIVILEGE);
        tbHttpMessageTask.setResponsedClass(ResponseMemberPrivilegeMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void dfR() {
        showLoadingView(this.lrB.getRootView(), true);
        HttpMessage httpMessage = new HttpMessage(1001531);
        httpMessage.addParam("st_type", "shop");
        sendMessage(httpMessage);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lrB.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != 0 && 1 != this.lrB.dfS().getItemViewType(i)) {
            String str = ((a.C0796a) this.lrB.dfS().getItem(i)).mLink;
            String str2 = ((a.C0796a) this.lrB.dfS().getItem(i)).mTitle;
            if (!au.isEmpty(str)) {
                if (Oe(str)) {
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

    private boolean Oe(String str) {
        Map<String, String> paramPair;
        return (TextUtils.isEmpty(str) || (paramPair = bf.getParamPair(bf.getParamStr(str))) == null || !"1".equals(paramPair.get("type"))) ? false : true;
    }
}
