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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.o.a;
import com.baidu.tieba.personCenter.b.b;
/* loaded from: classes5.dex */
public class PersonCenterFragment extends BaseFragment {
    private b gkq;
    private String gkr;
    private String gks;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean gkp = false;
    private long fLU = 0;
    private CustomMessageListener gkt = new CustomMessageListener(2016560) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016560) {
                PersonCenterFragment.this.lT(false);
            }
        }
    };
    private CustomMessageListener dCT = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonCenterFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonCenterFragment.this.gkr = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener gku = new CustomMessageListener(2921378) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonCenterFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    PersonCenterFragment.this.gks = (String) data;
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.gkp = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
        lT(true);
        MessageManager.getInstance().registerListener(this.gkt);
        MessageManager.getInstance().registerListener(this.dCT);
        MessageManager.getInstance().registerListener(this.gku);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmH() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_feedback_tip", 0L);
        if (TbadkCoreApplication.isLogin() && System.currentTimeMillis() - j > 4 * ao.ayO) {
            x.a(new w<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.w
                public Boolean doInBackground() {
                    com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP);
                    xVar.x("user_id", TbadkCoreApplication.getCurrentAccount());
                    String BH = xVar.BH();
                    com.baidu.tieba.personCenter.data.b bVar = new com.baidu.tieba.personCenter.data.b();
                    bVar.sZ(BH);
                    return bVar.getErrorCode() == 0 && bVar.ND() > 0;
                }
            }, new h<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                public void onReturnDataInUI(Boolean bool) {
                    if (bool.booleanValue()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016561, true));
                    }
                }
            });
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_feedback_tip", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lT(boolean z) {
        if (!z) {
            bmH();
        } else if (getPageContext() != null && getPageContext().getPageActivity() != null && getPageContext().getPageActivity().getMainLooper() != null && getPageContext().getPageActivity().getMainLooper().getQueue() != null) {
            getPageContext().getPageActivity().getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.6
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    PersonCenterFragment.this.bmH();
                    return false;
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        F(bundle);
        View inflate = layoutInflater.inflate(e.h.fragment_my_tab_layout, (ViewGroup) null);
        this.gkq = new b(inflate, getPageContext(), getUniqueId());
        this.gkq.initView();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.gkp) {
            return null;
        }
        return "a011";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.gkq.lU(isPrimary());
        if (isPrimary()) {
            if (!StringUtils.isNull(this.gkr)) {
                this.gkq.sX(this.gkr);
                this.gkr = null;
            }
            if (!StringUtils.isNull(this.gks)) {
                this.gkq.sY(this.gks);
                this.gks = null;
            } else {
                this.gkq.refreshView();
            }
            this.gkq.bmK();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", false);
        } else {
            this.gkq.bmL();
        }
        if (isAdded()) {
            a.btQ().btW();
        }
        a.btQ().mM(isPrimary());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isSelf && this.isBigV) {
            this.fLU = System.currentTimeMillis();
        } else {
            this.fLU = -1L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fLU > 0) {
            TiebaStatic.log(new am("c12263").ax("obj_duration", String.valueOf((System.currentTimeMillis() - this.fLU) / 1000)).x("obj_type", 2));
            this.fLU = 0L;
        }
    }

    private void F(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.userId = intent.getLongExtra("user_id", com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gkq != null) {
            this.gkq.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.gkt);
        MessageManager.getInstance().unRegisterListener(this.dCT);
        MessageManager.getInstance().unRegisterListener(this.gku);
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
        if (this.gkq != null) {
            this.gkq.onChangeSkinType(i);
        }
    }
}
