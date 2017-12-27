package com.baidu.tieba.personCenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.b.b;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private b gfp;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean gfo = false;
    private long fFO = 0;
    private CustomMessageListener gfq = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP) { // from class: com.baidu.tieba.personCenter.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016560) {
                a.this.bht();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.gfo = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
        bht();
        MessageManager.getInstance().registerListener(this.gfq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bht() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_feedback_tip", 0L);
        if (TbadkCoreApplication.isLogin() && System.currentTimeMillis() - j > 4 * am.aVE) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.personCenter.a.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    x xVar = new x(strArr[0]);
                    xVar.n("user_id", TbadkCoreApplication.getCurrentAccount());
                    String BP = xVar.BP();
                    com.baidu.tieba.personCenter.data.a aVar = new com.baidu.tieba.personCenter.data.a();
                    aVar.qC(BP);
                    if (aVar.getErrorCode() == 0 && aVar.Nl() > 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW, true));
                        return null;
                    }
                    return null;
                }
            }.execute(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_feedback_tip", System.currentTimeMillis());
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        z(bundle);
        View inflate = layoutInflater.inflate(d.h.fragment_my_tab_layout, (ViewGroup) null);
        this.gfp = new b(inflate, getPageContext(), getUniqueId());
        this.gfp.initView();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.gfo) {
            return null;
        }
        return "a011";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.gfp.refreshView();
            this.gfp.bhw();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", false);
        } else {
            this.gfp.bhx();
        }
        if (isAdded()) {
            com.baidu.tieba.m.a.buv().buB();
        }
        com.baidu.tieba.m.a.buv().mQ(isPrimary());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isSelf && this.isBigV) {
            this.fFO = System.currentTimeMillis();
        } else {
            this.fFO = -1L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fFO > 0) {
            TiebaStatic.log(new ak("c12263").ab("obj_duration", String.valueOf((System.currentTimeMillis() - this.fFO) / 1000)).s("obj_type", 2));
            this.fFO = 0L;
        }
    }

    private void z(Bundle bundle) {
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
        if (this.gfp != null) {
            this.gfp.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.gfq);
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
        if (this.gfp != null) {
            this.gfp.onChangeSkinType(i);
        }
    }
}
