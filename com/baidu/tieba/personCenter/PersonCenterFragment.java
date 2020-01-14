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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.o.a;
import com.baidu.tieba.personCenter.b.b;
/* loaded from: classes7.dex */
public class PersonCenterFragment extends BaseFragment {
    private b jfP;
    private String jfQ;
    private String jfR;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean jfO = false;
    private long iFF = 0;
    private boolean fMU = false;
    private CustomMessageListener jfS = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016560) {
                PersonCenterFragment.this.rc(false);
            }
        }
    };
    private CustomMessageListener gnE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonCenterFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonCenterFragment.this.jfQ = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener jfT = new CustomMessageListener(2921378) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonCenterFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    PersonCenterFragment.this.jfR = (String) data;
                }
            }
        }
    };
    private MessageQueue.IdleHandler jfU = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.6
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            PersonCenterFragment.this.ctH();
            return false;
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.jfO = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
        rc(true);
        MessageManager.getInstance().registerListener(this.jfS);
        MessageManager.getInstance().registerListener(this.gnE);
        MessageManager.getInstance().registerListener(this.jfT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctH() {
        long j = com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.KEY_FEEDBACK_TIP, 0L);
        if (TbadkCoreApplication.isLogin() && System.currentTimeMillis() - j > 4 * aq.MS_TO_HOUR) {
            ac.a(new ab<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP);
                    xVar.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    String postNetData = xVar.postNetData();
                    com.baidu.tieba.personCenter.data.b bVar = new com.baidu.tieba.personCenter.data.b();
                    bVar.Gr(postNetData);
                    return bVar.getErrorCode() == 0 && bVar.aOv() > 0;
                }
            }, new l<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Boolean bool) {
                    if (bool.booleanValue()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW, true));
                    }
                }
            });
            com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.KEY_FEEDBACK_TIP, System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(boolean z) {
        if (!z) {
            ctH();
        } else if (getPageContext() != null && getPageContext().getPageActivity() != null) {
            Looper.myQueue().removeIdleHandler(this.jfU);
            Looper.myQueue().addIdleHandler(this.jfU);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        aw(bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_my_tab_layout, (ViewGroup) null);
        this.jfP = new b(inflate, getPageContext(), getUniqueId());
        this.jfP.initView();
        this.fMU = false;
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.jfP.refreshView();
            this.fMU = true;
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.jfO) {
            return null;
        }
        return PageStayDurationConstants.PageName.PERSON;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.jfP.rd(isPrimary());
        if (isPrimary()) {
            if (!this.fMU) {
                this.fMU = true;
                this.jfP.refreshView();
            }
            if (!StringUtils.isNull(this.jfQ)) {
                this.jfP.Gp(this.jfQ);
                this.jfQ = null;
            }
            if (!StringUtils.isNull(this.jfR)) {
                this.jfP.Gq(this.jfR);
                this.jfR = null;
            } else {
                this.jfP.refreshView();
            }
            this.jfP.ctK();
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, false);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921423));
            }
        } else {
            this.jfP.ctL();
        }
        if (isAdded()) {
            a.cCm().cCs();
        }
        a.cCm().sf(isPrimary());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isSelf && this.isBigV) {
            this.iFF = System.currentTimeMillis();
        } else {
            this.iFF = -1L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iFF > 0) {
            TiebaStatic.log(new an("c12263").cp("obj_duration", String.valueOf((System.currentTimeMillis() - this.iFF) / 1000)).Z("obj_type", 2));
            this.iFF = 0L;
        }
    }

    private void aw(Bundle bundle) {
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
        if (this.jfP != null) {
            this.jfP.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.jfS);
        MessageManager.getInstance().unRegisterListener(this.gnE);
        MessageManager.getInstance().unRegisterListener(this.jfT);
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
        if (this.jfP != null) {
            this.jfP.onChangeSkinType(i);
        }
    }
}
