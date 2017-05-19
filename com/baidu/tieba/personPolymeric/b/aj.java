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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.f {
    private ViewGroup ZO;
    private TbPageContext aat;
    private CustomMessageListener bax = new ak(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private BaseFragmentActivity dEr;
    private com.baidu.tbadk.coreExtra.c.a dPz;
    private com.baidu.tieba.personPolymeric.d.ak eCW;
    public com.baidu.tieba.f.c eCX;
    private boolean mIsLiked;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public aj(BaseFragmentActivity baseFragmentActivity, ViewGroup viewGroup, UserData userData) {
        this.dEr = baseFragmentActivity;
        this.aat = baseFragmentActivity.getPageContext();
        this.ZO = viewGroup;
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.dPz = new com.baidu.tbadk.coreExtra.c.a(this);
        aeY();
        initListener();
        if (this.ZO != null && this.eCW != null) {
            this.eCX = new com.baidu.tieba.f.c(this.aat.getPageActivity(), this.eCW, null);
        }
    }

    private void aeY() {
        this.mOnClickListener = new al(this);
        this.eCW = new com.baidu.tieba.personPolymeric.d.ak(this.aat.getPageActivity(), this.mIsLiked, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds110));
        this.eCW.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.eCW.setOrientation(0);
        this.ZO.addView(this.eCW);
    }

    public void onChangeSkinType(int i) {
        this.eCW.onChangeSkinType(i);
    }

    private void initListener() {
        this.aat.registerListener(this.bax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDn() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new as("c11593"));
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
        this.eCW.setData(this.mIsLiked);
    }

    public void onDestroy() {
        if (this.eCX != null) {
            this.eCX.GA();
        }
    }
}
