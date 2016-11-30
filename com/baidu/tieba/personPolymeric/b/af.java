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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.g {
    private TbPageContext Gf;
    private ViewGroup Wh;
    private BaseActivity aTb;
    private CustomMessageListener bqQ = new ag(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.coreExtra.d.a bzm;
    private com.baidu.tieba.personPolymeric.d.ad eQu;
    public com.baidu.tieba.e.c eQv;
    private boolean mIsLiked;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public af(BaseActivity baseActivity, ViewGroup viewGroup, UserData userData) {
        this.aTb = baseActivity;
        this.Gf = baseActivity.getPageContext();
        this.Wh = viewGroup;
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.bzm = new com.baidu.tbadk.coreExtra.d.a(this);
        alA();
        VV();
        if (this.Wh != null && this.eQu != null) {
            this.eQv = new com.baidu.tieba.e.c(this.Gf.getPageActivity(), this.eQu, null);
        }
    }

    private void alA() {
        this.mOnClickListener = new ah(this);
        this.eQu = new com.baidu.tieba.personPolymeric.d.ad(this.Gf.getPageActivity(), this.mIsLiked, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds110));
        this.eQu.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.eQu.setAlpha(0.9f);
        this.eQu.setOrientation(0);
        this.Wh.addView(this.eQu);
    }

    public void onChangeSkinType(int i) {
        this.eQu.onChangeSkinType(i);
    }

    private void VV() {
        this.Gf.registerListener(this.bqQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKh() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new av("c11593"));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.Gf.getPageActivity(), Long.parseLong(this.mUserData.getUserId()), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getIsFriend())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUseSingleGod(UserData userData) {
        return (userData == null || userData.getGodUserData() == null || userData.getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.eQu.setData(this.mIsLiked);
    }

    public void onDestroy() {
        if (this.eQv != null) {
            this.eQv.aac();
        }
    }
}
