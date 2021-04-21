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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.j0.r1.g.a;
import d.b.j0.r1.g.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class MemberPrivilegeActivity extends BaseActivity<MemberPrivilegeActivity> {
    public d mMemberPrivilegeView;
    public String SCENE_ID = "4001001000";
    public HttpMessageListener mRequestMemberPrivilegelistener = new a(CmdConfigHttp.MEMBER_PRIVILEGE_CMD);
    public final CustomMessageListener mMemListener = new b(2001194);
    public final CustomMessageListener mBuyTdouListener = new c(2001227);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            MemberPrivilegeActivity memberPrivilegeActivity = MemberPrivilegeActivity.this;
            memberPrivilegeActivity.hideLoadingView(memberPrivilegeActivity.mMemberPrivilegeView.f());
            if ((httpResponsedMessage instanceof ResponseMemberPrivilegeMessage) && httpResponsedMessage.getCmd() == 1001531) {
                int error = httpResponsedMessage.getError();
                ResponseMemberPrivilegeMessage responseMemberPrivilegeMessage = (ResponseMemberPrivilegeMessage) httpResponsedMessage;
                if (error != 0) {
                    MemberPrivilegeActivity.this.showToast(StringUtils.isNull(responseMemberPrivilegeMessage.getErrorString()) ? MemberPrivilegeActivity.this.getResources().getString(R.string.neterror) : responseMemberPrivilegeMessage.getErrorString());
                    return;
                }
                d.b.j0.r1.g.a aVar = responseMemberPrivilegeMessage.mData;
                if (aVar != null) {
                    MemberPrivilegeActivity.this.mMemberPrivilegeView.e().h(aVar);
                } else {
                    MemberPrivilegeActivity.this.showToast(R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || ((Integer) customResponsedMessage.getData()) == null) {
                return;
            }
            MemberPrivilegeActivity.this.requestMemberPrivilegeData();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            MemberPrivilegeActivity.this.requestMemberPrivilegeData();
        }
    }

    private void initUI() {
        this.mMemberPrivilegeView = new d(getPageContext().getOrignalPage());
    }

    private boolean isBubbleLink(String str) {
        Map<String, String> paramPair;
        return (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null || !"1".equals(paramPair.get("type"))) ? false : true;
    }

    private void registerGetMemberPrivilegeTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MEMBER_PRIVILEGE_CMD, TbConfig.SERVER_ADDRESS + TbConfig.MEMBER_PRIVILEGE);
        tbHttpMessageTask.setResponsedClass(ResponseMemberPrivilegeMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mMemberPrivilegeView.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (R.id.left_button == view.getId()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_33", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(getPageContext().getPageActivity(), 0, "pay", 3, 1, this.SCENE_ID)));
        } else if (R.id.right_button == view.getId()) {
            sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L, 1, this.SCENE_ID, PageDialogHelper.PayForm.NOT_SET)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerGetMemberPrivilegeTask();
        registerListener(this.mMemListener);
        registerListener(this.mBuyTdouListener);
        registerListener(this.mRequestMemberPrivilegelistener);
        initUI();
        requestMemberPrivilegeData();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0 || 1 == this.mMemberPrivilegeView.e().getItemViewType(i)) {
            return;
        }
        String str = ((a.C1571a) this.mMemberPrivilegeView.e().getItem(i)).f61560d;
        String str2 = ((a.C1571a) this.mMemberPrivilegeView.e().getItem(i)).f61558b;
        if (k.isEmpty(str)) {
            return;
        }
        if (isBubbleLink(str)) {
            sendMessage(new CustomMessage(2002001, new BubbleChooseActivityConfig(getPageContext().getPageActivity())));
        } else {
            d.b.i0.l.a.o(getPageContext().getPageActivity(), str2, str, true, true, true);
        }
    }

    public void requestMemberPrivilegeData() {
        showLoadingView(this.mMemberPrivilegeView.f(), true);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MEMBER_PRIVILEGE_CMD);
        httpMessage.addParam("st_type", "shop");
        sendMessage(httpMessage);
    }
}
