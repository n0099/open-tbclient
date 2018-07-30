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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.b.b;
import com.baidu.tieba.personCenter.data.a;
/* loaded from: classes2.dex */
public class PersonCenterFragment extends BaseFragment {
    private b fUj;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean fUi = false;
    private long fvi = 0;
    private CustomMessageListener fUk = new CustomMessageListener(2016560) { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016560) {
                PersonCenterFragment.this.kV(false);
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.fUi = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
        kV(true);
        MessageManager.getInstance().registerListener(this.fUk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhF() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_feedback_tip", 0L);
        if (TbadkCoreApplication.isLogin() && System.currentTimeMillis() - j > 4 * ap.aqR) {
            v.a(new u<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP);
                    yVar.o("user_id", TbadkCoreApplication.getCurrentAccount());
                    String yq = yVar.yq();
                    a aVar = new a();
                    aVar.rM(yq);
                    return aVar.getErrorCode() == 0 && aVar.Kc() > 0;
                }
            }, new g<Boolean>() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
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
    public void kV(boolean z) {
        if (!z) {
            bhF();
        } else if (getPageContext() != null && getPageContext().getPageActivity() != null && getPageContext().getPageActivity().getMainLooper() != null && getPageContext().getPageActivity().getMainLooper().getQueue() != null) {
            getPageContext().getPageActivity().getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.personCenter.PersonCenterFragment.4
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    PersonCenterFragment.this.bhF();
                    return false;
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        B(bundle);
        View inflate = layoutInflater.inflate(d.h.fragment_my_tab_layout, (ViewGroup) null);
        this.fUj = new b(inflate, getPageContext(), getUniqueId());
        this.fUj.initView();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.fUi) {
            return null;
        }
        return "a011";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.fUj.kW(isPrimary());
        if (isPrimary()) {
            this.fUj.refreshView();
            this.fUj.bhI();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", false);
        } else {
            this.fUj.bhJ();
        }
        if (isAdded()) {
            com.baidu.tieba.o.a.box().boD();
        }
        com.baidu.tieba.o.a.box().lK(isPrimary());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isSelf && this.isBigV) {
            this.fvi = System.currentTimeMillis();
        } else {
            this.fvi = -1L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fvi > 0) {
            TiebaStatic.log(new an("c12263").af("obj_duration", String.valueOf((System.currentTimeMillis() - this.fvi) / 1000)).r("obj_type", 2));
            this.fvi = 0L;
        }
    }

    private void B(Bundle bundle) {
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
        if (this.fUj != null) {
            this.fUj.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.fUk);
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
        if (this.fUj != null) {
            this.fUj.onChangeSkinType(i);
        }
    }
}
