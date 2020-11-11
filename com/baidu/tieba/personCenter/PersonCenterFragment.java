package com.baidu.tieba.personCenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PersonCenterFragment extends BaseFragment {
    private com.baidu.tieba.personCenter.b.b lUW;
    private String lUX;
    private String lUY;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean lUV = false;
    private long ltw = 0;
    private boolean idS = false;
    private CustomMessageListener checkFeedBackListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016560) {
                PersonCenterFragment.this.vJ(false);
            }
        }
    };
    private CustomMessageListener iJc = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonCenterFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonCenterFragment.this.lUX = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener lUZ = new CustomMessageListener(2921378) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonCenterFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    PersonCenterFragment.this.lUY = (String) data;
                }
            }
        }
    };
    private MessageQueue.IdleHandler lVa = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.6
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            PersonCenterFragment.this.dts();
            return false;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a.dtt().setCreateTime(System.currentTimeMillis() - a.dtt().bdL());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.dtt().cX(System.currentTimeMillis());
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.lUV = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
        getPageStayDurationItem().objParam1 = "1";
        vJ(true);
        MessageManager.getInstance().registerListener(this.checkFeedBackListener);
        MessageManager.getInstance().registerListener(this.iJc);
        MessageManager.getInstance().registerListener(this.lUZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dts() {
        long j = com.baidu.tbadk.core.sharedPref.b.bqh().getLong(SharedPrefConfig.KEY_FEEDBACK_TIP, 0L);
        if (TbadkCoreApplication.isLogin() && System.currentTimeMillis() - j > 4 * at.MS_TO_HOUR) {
            ae.a(new ad<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ad
                public Boolean doInBackground() {
                    aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP);
                    aaVar.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    String postNetData = aaVar.postNetData();
                    com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b();
                    bVar.Qs(postNetData);
                    return bVar.getErrorCode() == 0 && bVar.bBT() > 0;
                }
            }, new m<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                public void onReturnDataInUI(Boolean bool) {
                    if (bool.booleanValue()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW, true));
                    }
                }
            });
            com.baidu.tbadk.core.sharedPref.b.bqh().putLong(SharedPrefConfig.KEY_FEEDBACK_TIP, System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vJ(boolean z) {
        if (!z) {
            dts();
        } else if (getPageContext() != null && getPageContext().getPageActivity() != null) {
            Looper.myQueue().removeIdleHandler(this.lVa);
            Looper.myQueue().addIdleHandler(this.lVa);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        aE(bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_my_tab_layout, (ViewGroup) null);
        this.lUW = new com.baidu.tieba.personCenter.b.b(inflate, getPageContext(), getUniqueId());
        this.lUW.initView();
        this.idS = false;
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.lUW.refreshView();
            this.idS = true;
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.lUV) {
            return null;
        }
        return PageStayDurationConstants.PageName.PERSON;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.lUW.vK(isPrimary());
        if (isPrimary()) {
            if (!this.idS) {
                this.idS = true;
                this.lUW.refreshView();
            }
            if (!StringUtils.isNull(this.lUX)) {
                this.lUW.Qq(this.lUX);
                this.lUX = null;
            }
            if (!StringUtils.isNull(this.lUY)) {
                this.lUW.Qr(this.lUY);
                this.lUY = null;
            } else {
                this.lUW.refreshView();
            }
            this.lUW.dtA();
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, false);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921423));
            }
        } else {
            this.lUW.dtB();
        }
        if (isAdded()) {
            com.baidu.tieba.p.a.dBY().dCe();
        }
        com.baidu.tieba.p.a.dBY().wM(isPrimary());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isSelf && this.isBigV) {
            this.ltw = System.currentTimeMillis();
        } else {
            this.ltw = -1L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ltw > 0) {
            TiebaStatic.log(new aq("c12263").dR("obj_duration", String.valueOf((System.currentTimeMillis() - this.ltw) / 1000)).al("obj_type", 2));
            this.ltw = 0L;
        }
    }

    private void aE(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.userId = intent.getLongExtra("user_id", com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lUW != null) {
            this.lUW.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.checkFeedBackListener);
        MessageManager.getInstance().unRegisterListener(this.iJc);
        MessageManager.getInstance().unRegisterListener(this.lUZ);
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putLong("user_id", this.userId);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.isSelf);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.isBigV);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lUW != null) {
            this.lUW.onChangeSkinType(i);
        }
    }
}
