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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PersonCenterFragment extends BaseFragment {
    private com.baidu.tieba.personCenter.b.b moG;
    private String moH;
    private String moI;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean moF = false;
    private long lMP = 0;
    private boolean iBX = false;
    private CustomMessageListener checkFeedBackListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016560) {
                PersonCenterFragment.this.wr(false);
            }
        }
    };
    private CustomMessageListener jgW = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonCenterFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonCenterFragment.this.moH = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener moJ = new CustomMessageListener(2921378) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonCenterFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    PersonCenterFragment.this.moI = (String) data;
                }
            }
        }
    };
    private MessageQueue.IdleHandler moK = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.6
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            PersonCenterFragment.this.dya();
            return false;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a.dyb().setCreateTime(System.currentTimeMillis() - a.dyb().biG());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        a.dyb().dw(System.currentTimeMillis());
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.moF = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
        getPageStayDurationItem().objParam1 = "1";
        wr(true);
        MessageManager.getInstance().registerListener(this.checkFeedBackListener);
        MessageManager.getInstance().registerListener(this.jgW);
        MessageManager.getInstance().registerListener(this.moJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dya() {
        long j = com.baidu.tbadk.core.sharedPref.b.bvq().getLong(SharedPrefConfig.KEY_FEEDBACK_TIP, 0L);
        if (TbadkCoreApplication.isLogin() && System.currentTimeMillis() - j > 4 * at.MS_TO_HOUR) {
            ac.a(new ab<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    z zVar = new z(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP);
                    zVar.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    String postNetData = zVar.postNetData();
                    com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b();
                    bVar.QC(postNetData);
                    return bVar.getErrorCode() == 0 && bVar.bHf() > 0;
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
            com.baidu.tbadk.core.sharedPref.b.bvq().putLong(SharedPrefConfig.KEY_FEEDBACK_TIP, System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wr(boolean z) {
        if (!z) {
            dya();
        } else if (getPageContext() != null && getPageContext().getPageActivity() != null) {
            Looper.myQueue().removeIdleHandler(this.moK);
            Looper.myQueue().addIdleHandler(this.moK);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        aF(bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_my_tab_layout, (ViewGroup) null);
        this.moG = new com.baidu.tieba.personCenter.b.b(inflate, getPageContext(), getUniqueId());
        this.moG.initView();
        this.iBX = false;
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.moG.refreshView();
            this.iBX = true;
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.moF) {
            return null;
        }
        return PageStayDurationConstants.PageName.PERSON;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.moG.ws(isPrimary());
        if (isPrimary()) {
            if (!this.iBX) {
                this.iBX = true;
                this.moG.refreshView();
            }
            if (!StringUtils.isNull(this.moH)) {
                this.moG.QA(this.moH);
                this.moH = null;
            }
            if (!StringUtils.isNull(this.moI)) {
                this.moG.QB(this.moI);
                this.moI = null;
            } else {
                this.moG.refreshView();
            }
            this.moG.dyi();
            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, false);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921423));
            }
        } else {
            this.moG.dyj();
        }
        if (isAdded()) {
            com.baidu.tieba.p.a.dGD().dGJ();
        }
        com.baidu.tieba.p.a.dGD().xu(isPrimary());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isSelf && this.isBigV) {
            this.lMP = System.currentTimeMillis();
        } else {
            this.lMP = -1L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.lMP > 0) {
            TiebaStatic.log(new aq("c12263").dX("obj_duration", String.valueOf((System.currentTimeMillis() - this.lMP) / 1000)).an("obj_type", 2));
            this.lMP = 0L;
        }
    }

    private void aF(Bundle bundle) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.moG != null) {
            this.moG.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.checkFeedBackListener);
        MessageManager.getInstance().unRegisterListener(this.jgW);
        MessageManager.getInstance().unRegisterListener(this.moJ);
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
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
        if (this.moG != null) {
            this.moG.onChangeSkinType(i);
        }
    }
}
