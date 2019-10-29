package com.baidu.tieba.personCenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.o.a;
import com.baidu.tieba.personCenter.b.b;
/* loaded from: classes4.dex */
public class PersonCenterFragment extends BaseFragment {
    private b ilg;
    private String ilh;
    private String ili;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean ilf = false;
    private long hLF = 0;
    private boolean eVV = false;
    private CustomMessageListener ilj = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016560) {
                PersonCenterFragment.this.pn(false);
            }
        }
    };
    private CustomMessageListener fwQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonCenterFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonCenterFragment.this.ilh = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener ilk = new CustomMessageListener(2921378) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonCenterFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    PersonCenterFragment.this.ili = (String) data;
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.ilf = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
        pn(true);
        MessageManager.getInstance().registerListener(this.ilj);
        MessageManager.getInstance().registerListener(this.fwQ);
        MessageManager.getInstance().registerListener(this.ilk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZi() {
        long j = com.baidu.tbadk.core.sharedPref.b.alR().getLong(SharedPrefConfig.KEY_FEEDBACK_TIP, 0L);
        if (TbadkCoreApplication.isLogin() && System.currentTimeMillis() - j > 4 * aq.MS_TO_HOUR) {
            z.a(new y<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.y
                public Boolean doInBackground() {
                    x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP);
                    xVar.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    String postNetData = xVar.postNetData();
                    com.baidu.tieba.personCenter.data.b bVar = new com.baidu.tieba.personCenter.data.b();
                    bVar.Bw(postNetData);
                    return bVar.getErrorCode() == 0 && bVar.awu() > 0;
                }
            }, new j<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.j
                public void onReturnDataInUI(Boolean bool) {
                    if (bool.booleanValue()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW, true));
                    }
                }
            });
            com.baidu.tbadk.core.sharedPref.b.alR().putLong(SharedPrefConfig.KEY_FEEDBACK_TIP, System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn(boolean z) {
        if (!z) {
            bZi();
        } else if (getPageContext() != null && getPageContext().getPageActivity() != null && getPageContext().getPageActivity().getMainLooper() != null && getPageContext().getPageActivity().getMainLooper().getQueue() != null) {
            getPageContext().getPageActivity().getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.6
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    PersonCenterFragment.this.bZi();
                    return false;
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ac(bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_my_tab_layout, (ViewGroup) null);
        this.ilg = new b(inflate, getPageContext(), getUniqueId());
        this.ilg.initView();
        this.eVV = false;
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.ilg.refreshView();
            this.eVV = true;
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.ilf) {
            return null;
        }
        return PageStayDurationConstants.PageName.PERSON;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.ilg.po(isPrimary());
        if (isPrimary()) {
            if (!this.eVV) {
                this.eVV = true;
                this.ilg.refreshView();
            }
            if (!StringUtils.isNull(this.ilh)) {
                this.ilg.Bu(this.ilh);
                this.ilh = null;
            }
            if (!StringUtils.isNull(this.ili)) {
                this.ilg.Bv(this.ili);
                this.ili = null;
            } else {
                this.ilg.refreshView();
            }
            this.ilg.bZl();
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, false);
        } else {
            this.ilg.bZm();
        }
        if (isAdded()) {
            a.chd().chj();
        }
        a.chd().qk(isPrimary());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isSelf && this.isBigV) {
            this.hLF = System.currentTimeMillis();
        } else {
            this.hLF = -1L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hLF > 0) {
            TiebaStatic.log(new an("c12263").bS("obj_duration", String.valueOf((System.currentTimeMillis() - this.hLF) / 1000)).O("obj_type", 2));
            this.hLF = 0L;
        }
    }

    private void ac(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.userId = intent.getLongExtra("user_id", com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ilg != null) {
            this.ilg.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.ilj);
        MessageManager.getInstance().unRegisterListener(this.fwQ);
        MessageManager.getInstance().unRegisterListener(this.ilk);
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
        if (this.ilg != null) {
            this.ilg.onChangeSkinType(i);
        }
    }
}
