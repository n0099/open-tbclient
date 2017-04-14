package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f {
    private CustomMessageListener aZX = new ag(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private TbPageContext aaX;
    private ViewGroup aas;
    private BaseActivity bcy;
    private com.baidu.tbadk.coreExtra.c.a dSy;
    private com.baidu.tieba.personPolymeric.d.af eFl;
    public com.baidu.tieba.f.c eFm;
    private boolean mIsLiked;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public af(BaseActivity baseActivity, ViewGroup viewGroup, UserData userData) {
        this.bcy = baseActivity;
        this.aaX = baseActivity.getPageContext();
        this.aas = viewGroup;
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.dSy = new com.baidu.tbadk.coreExtra.c.a(this);
        ago();
        initListener();
        if (this.aas != null && this.eFl != null) {
            this.eFm = new com.baidu.tieba.f.c(this.aaX.getPageActivity(), this.eFl, null);
        }
    }

    private void ago() {
        this.mOnClickListener = new ah(this);
        this.eFl = new com.baidu.tieba.personPolymeric.d.af(this.aaX.getPageActivity(), this.mIsLiked, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds110));
        this.eFl.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.eFl.setAlpha(0.9f);
        this.eFl.setOrientation(0);
        this.aas.addView(this.eFl);
    }

    public void onChangeSkinType(int i) {
        this.eFl.onChangeSkinType(i);
    }

    private void initListener() {
        this.aaX.registerListener(this.aZX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFf() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new as("c11593"));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.aaX.getPageActivity(), Long.parseLong(this.mUserData.getUserId()), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getIsFriend())));
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
        this.eFl.setData(this.mIsLiked);
    }

    public void onDestroy() {
        if (this.eFm != null) {
            this.eFm.Xg();
        }
    }
}
