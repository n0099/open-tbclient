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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.g {
    private TbPageContext Gf;
    private ViewGroup VB;
    private BaseActivity aSs;
    private CustomMessageListener bIg = new ag(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.coreExtra.d.a dJo;
    private com.baidu.tieba.personPolymeric.d.ad etT;
    public com.baidu.tieba.e.c etU;
    private boolean mIsLiked;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public af(BaseActivity baseActivity, ViewGroup viewGroup, UserData userData) {
        this.aSs = baseActivity;
        this.Gf = baseActivity.getPageContext();
        this.VB = viewGroup;
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.dJo = new com.baidu.tbadk.coreExtra.d.a(this);
        aga();
        Tc();
        if (this.VB != null && this.etT != null) {
            this.etU = new com.baidu.tieba.e.c(this.Gf.getPageActivity(), this.etT, null);
        }
    }

    private void aga() {
        this.mOnClickListener = new ah(this);
        this.etT = new com.baidu.tieba.personPolymeric.d.ad(this.Gf.getPageActivity(), this.mIsLiked, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds110));
        this.etT.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.etT.setAlpha(0.9f);
        this.etT.setOrientation(0);
        this.VB.addView(this.etT);
    }

    public void onChangeSkinType(int i) {
        this.etT.onChangeSkinType(i);
    }

    private void Tc() {
        this.Gf.registerListener(this.bIg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEi() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new at("c11593"));
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
        this.etT.setData(this.mIsLiked);
    }

    public void onDestroy() {
        if (this.etU != null) {
            this.etU.Up();
        }
    }
}
