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
public class at extends com.baidu.adp.base.f {
    private ViewGroup ZO;
    private TbPageContext aat;
    private CustomMessageListener bdP = new au(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private BaseFragmentActivity bzr;
    private com.baidu.tieba.view.r eRa;
    private com.baidu.tieba.personPolymeric.d.ai eVQ;
    public com.baidu.tieba.f.c eVR;
    private com.baidu.tbadk.coreExtra.c.a edt;
    private boolean mIsLiked;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public at(BaseFragmentActivity baseFragmentActivity, ViewGroup viewGroup, UserData userData) {
        this.bzr = baseFragmentActivity;
        this.aat = baseFragmentActivity.getPageContext();
        this.ZO = viewGroup;
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.edt = new com.baidu.tbadk.coreExtra.c.a(this);
        ajV();
        initListener();
        if (this.ZO != null && this.eVQ != null) {
            this.eVR = new com.baidu.tieba.f.c(this.aat.getPageActivity(), this.eVQ, null);
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.r rVar) {
        this.eRa = rVar;
    }

    private void ajV() {
        this.mOnClickListener = new av(this);
        this.eVQ = new com.baidu.tieba.personPolymeric.d.ai(this.aat.getPageActivity(), this.mUserData, this.mIsLiked, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds110));
        this.eVQ.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.eVQ.setOrientation(0);
        this.ZO.addView(this.eVQ);
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (this.eVQ != null) {
            this.eVQ.i(z, z2, z3);
        }
    }

    public void onChangeSkinType(int i) {
        this.eVQ.onChangeSkinType(i);
    }

    private void initListener() {
        this.aat.registerListener(this.bdP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIc() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11593"));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.aat.getPageActivity(), Long.parseLong(this.mUserData.getUserId()), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getIsFriend())));
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
        this.eVQ.a(this.mUserData, this.mIsLiked);
    }

    public void onDestroy() {
        if (this.eVR != null) {
            this.eVR.GR();
        }
    }
}
