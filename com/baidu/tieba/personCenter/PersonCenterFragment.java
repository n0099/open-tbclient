package com.baidu.tieba.personCenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
    private b giT;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean giS = false;
    private long fKu = 0;
    private CustomMessageListener giU = new CustomMessageListener(2016560) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016560) {
                PersonCenterFragment.this.lI(false);
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.giS = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
        lI(true);
        MessageManager.getInstance().registerListener(this.giU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnm() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_feedback_tip", 0L);
        if (TbadkCoreApplication.isLogin() && System.currentTimeMillis() - j > 4 * ao.ayb) {
            x.a(new w<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.w
                public Boolean doInBackground() {
                    com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP);
                    xVar.x("user_id", TbadkCoreApplication.getCurrentAccount());
                    String BA = xVar.BA();
                    com.baidu.tieba.personCenter.data.b bVar = new com.baidu.tieba.personCenter.data.b();
                    bVar.sW(BA);
                    return bVar.getErrorCode() == 0 && bVar.Nu() > 0;
                }
            }, new h<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.3
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
    public void lI(boolean z) {
        if (!z) {
            bnm();
        } else if (getPageContext() != null && getPageContext().getPageActivity() != null && getPageContext().getPageActivity().getMainLooper() != null && getPageContext().getPageActivity().getMainLooper().getQueue() != null) {
            getPageContext().getPageActivity().getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.4
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    PersonCenterFragment.this.bnm();
                    return false;
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C(bundle);
        View inflate = layoutInflater.inflate(e.h.fragment_my_tab_layout, (ViewGroup) null);
        this.giT = new b(inflate, getPageContext(), getUniqueId());
        this.giT.initView();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.giS) {
            return null;
        }
        return "a011";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.giT.lJ(isPrimary());
        if (isPrimary()) {
            this.giT.refreshView();
            this.giT.bnp();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", false);
        } else {
            this.giT.bnq();
        }
        if (isAdded()) {
            a.buu().buA();
        }
        a.buu().mB(isPrimary());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isSelf && this.isBigV) {
            this.fKu = System.currentTimeMillis();
        } else {
            this.fKu = -1L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fKu > 0) {
            TiebaStatic.log(new am("c12263").ax("obj_duration", String.valueOf((System.currentTimeMillis() - this.fKu) / 1000)).x("obj_type", 2));
            this.fKu = 0L;
        }
    }

    private void C(Bundle bundle) {
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
        if (this.giT != null) {
            this.giT.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.giU);
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
        if (this.giT != null) {
            this.giT.onChangeSkinType(i);
        }
    }
}
