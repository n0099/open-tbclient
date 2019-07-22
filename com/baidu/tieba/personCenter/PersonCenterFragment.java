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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.o.a;
import com.baidu.tieba.personCenter.b.b;
/* loaded from: classes4.dex */
public class PersonCenterFragment extends BaseFragment {
    private b ijv;
    private String ijw;
    private String ijx;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean iju = false;
    private long hKm = 0;
    private boolean eLy = false;
    private CustomMessageListener ijy = new CustomMessageListener(2016560) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016560) {
                PersonCenterFragment.this.pA(false);
            }
        }
    };
    private CustomMessageListener fvq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonCenterFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonCenterFragment.this.ijw = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener ijz = new CustomMessageListener(2921378) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonCenterFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    PersonCenterFragment.this.ijx = (String) data;
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.iju = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
        pA(true);
        MessageManager.getInstance().registerListener(this.ijy);
        MessageManager.getInstance().registerListener(this.fvq);
        MessageManager.getInstance().registerListener(this.ijz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cba() {
        long j = com.baidu.tbadk.core.sharedPref.b.ahO().getLong("key_feedback_tip", 0L);
        if (TbadkCoreApplication.isLogin() && System.currentTimeMillis() - j > 4 * aq.bTB) {
            aa.a(new z<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP);
                    xVar.o("user_id", TbadkCoreApplication.getCurrentAccount());
                    String aig = xVar.aig();
                    com.baidu.tieba.personCenter.data.b bVar = new com.baidu.tieba.personCenter.data.b();
                    bVar.CD(aig);
                    return bVar.getErrorCode() == 0 && bVar.auO() > 0;
                }
            }, new k<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                public void onReturnDataInUI(Boolean bool) {
                    if (bool.booleanValue()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016561, true));
                    }
                }
            });
            com.baidu.tbadk.core.sharedPref.b.ahO().putLong("key_feedback_tip", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z) {
        if (!z) {
            cba();
        } else if (getPageContext() != null && getPageContext().getPageActivity() != null && getPageContext().getPageActivity().getMainLooper() != null && getPageContext().getPageActivity().getMainLooper().getQueue() != null) {
            getPageContext().getPageActivity().getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.6
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    PersonCenterFragment.this.cba();
                    return false;
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ad(bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_my_tab_layout, (ViewGroup) null);
        this.ijv = new b(inflate, getPageContext(), getUniqueId());
        this.ijv.initView();
        this.eLy = false;
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.ijv.refreshView();
            this.eLy = true;
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.iju) {
            return null;
        }
        return "a011";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.ijv.pB(isPrimary());
        if (isPrimary()) {
            if (!this.eLy) {
                this.eLy = true;
                this.ijv.refreshView();
            }
            if (!StringUtils.isNull(this.ijw)) {
                this.ijv.CB(this.ijw);
                this.ijw = null;
            }
            if (!StringUtils.isNull(this.ijx)) {
                this.ijv.CC(this.ijx);
                this.ijx = null;
            } else {
                this.ijv.refreshView();
            }
            this.ijv.cbd();
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("key_feedback_tip_tab_show", false);
        } else {
            this.ijv.cbe();
        }
        if (isAdded()) {
            a.ciR().ciX();
        }
        a.ciR().qx(isPrimary());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isSelf && this.isBigV) {
            this.hKm = System.currentTimeMillis();
        } else {
            this.hKm = -1L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hKm > 0) {
            TiebaStatic.log(new an("c12263").bT("obj_duration", String.valueOf((System.currentTimeMillis() - this.hKm) / 1000)).P("obj_type", 2));
            this.hKm = 0L;
        }
    }

    private void ad(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.userId = intent.getLongExtra("user_id", com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ijv != null) {
            this.ijv.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.ijy);
        MessageManager.getInstance().unRegisterListener(this.fvq);
        MessageManager.getInstance().unRegisterListener(this.ijz);
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
        if (this.ijv != null) {
            this.ijv.onChangeSkinType(i);
        }
    }
}
