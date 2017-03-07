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
    private TbPageContext aaI;
    private ViewGroup aac;
    private CustomMessageListener bad = new ag(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private BaseActivity bcF;
    private com.baidu.tbadk.coreExtra.c.a dVf;
    private com.baidu.tieba.personPolymeric.d.af eHp;
    public com.baidu.tieba.f.c eHq;
    private boolean mIsLiked;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public af(BaseActivity baseActivity, ViewGroup viewGroup, UserData userData) {
        this.bcF = baseActivity;
        this.aaI = baseActivity.getPageContext();
        this.aac = viewGroup;
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.dVf = new com.baidu.tbadk.coreExtra.c.a(this);
        agu();
        MV();
        if (this.aac != null && this.eHp != null) {
            this.eHq = new com.baidu.tieba.f.c(this.aaI.getPageActivity(), this.eHp, null);
        }
    }

    private void agu() {
        this.mOnClickListener = new ah(this);
        this.eHp = new com.baidu.tieba.personPolymeric.d.af(this.aaI.getPageActivity(), this.mIsLiked, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds110));
        this.eHp.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.eHp.setAlpha(0.9f);
        this.eHp.setOrientation(0);
        this.aac.addView(this.eHp);
    }

    public void onChangeSkinType(int i) {
        this.eHp.onChangeSkinType(i);
    }

    private void MV() {
        this.aaI.registerListener(this.bad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFs() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new as("c11593"));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.aaI.getPageActivity(), Long.parseLong(this.mUserData.getUserId()), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getIsFriend())));
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
        this.eHp.setData(this.mIsLiked);
    }

    public void onDestroy() {
        if (this.eHq != null) {
            this.eHq.WI();
        }
    }
}
