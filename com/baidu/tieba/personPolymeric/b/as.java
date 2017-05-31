package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.base.f {
    private ViewGroup ZN;
    private TbPageContext aas;
    private CustomMessageListener bbM = new at(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private BaseFragmentActivity bwL;
    private com.baidu.tieba.view.r bxW;
    private com.baidu.tbadk.coreExtra.c.a dUV;
    private com.baidu.tieba.personPolymeric.d.ai eLI;
    public com.baidu.tieba.f.c eLJ;
    private boolean mIsLiked;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public as(BaseFragmentActivity baseFragmentActivity, ViewGroup viewGroup, UserData userData) {
        this.bwL = baseFragmentActivity;
        this.aas = baseFragmentActivity.getPageContext();
        this.ZN = viewGroup;
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.dUV = new com.baidu.tbadk.coreExtra.c.a(this);
        agl();
        initListener();
        if (this.ZN != null && this.eLI != null) {
            this.eLJ = new com.baidu.tieba.f.c(this.aas.getPageActivity(), this.eLI, null);
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.r rVar) {
        this.bxW = rVar;
    }

    private void agl() {
        this.mOnClickListener = new au(this);
        this.eLI = new com.baidu.tieba.personPolymeric.d.ai(this.aas.getPageActivity(), this.mUserData, this.mIsLiked, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.aas.getPageActivity(), w.f.ds110));
        this.eLI.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.eLI.setOrientation(0);
        this.ZN.addView(this.eLI);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (this.eLI != null) {
            this.eLI.j(z, z2, z3);
        }
    }

    public void onChangeSkinType(int i) {
        this.eLI.onChangeSkinType(i);
    }

    private void initListener() {
        this.aas.registerListener(this.bbM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEk() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11593"));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.aas.getPageActivity(), Long.parseLong(this.mUserData.getUserId()), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getIsFriend())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUseSingleGod(UserData userData) {
        return (userData == null || userData.getGodUserData() == null || userData.getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.eLI.a(this.mUserData, this.mIsLiked);
    }

    public void onDestroy() {
        if (this.eLJ != null) {
            this.eLJ.Gu();
        }
    }
}
