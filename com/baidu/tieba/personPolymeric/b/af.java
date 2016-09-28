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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.g {
    private TbPageContext Gd;
    private ViewGroup VJ;
    private BaseActivity aRd;
    private CustomMessageListener bnV = new ag(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.coreExtra.d.a bwr;
    private com.baidu.tieba.personPolymeric.d.ad eJV;
    private boolean eJW;
    public com.baidu.tieba.e.c eJX;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public af(BaseActivity baseActivity, ViewGroup viewGroup, UserData userData) {
        this.aRd = baseActivity;
        this.Gd = baseActivity.getPageContext();
        this.VJ = viewGroup;
        this.mUserData = userData;
        this.eJW = userData.getHave_attention() == 1;
        this.bwr = new com.baidu.tbadk.coreExtra.d.a(this);
        ajF();
        UT();
        if (this.VJ != null && this.eJV != null) {
            this.eJX = new com.baidu.tieba.e.c(this.Gd.getPageActivity(), this.eJV, null);
        }
    }

    private void ajF() {
        this.mOnClickListener = new ah(this);
        this.eJV = new com.baidu.tieba.personPolymeric.d.ad(this.Gd.getPageActivity(), this.eJW, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds110));
        this.eJV.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.eJV.setAlpha(0.9f);
        this.eJV.setOrientation(0);
        this.VJ.addView(this.eJV);
    }

    public void onChangeSkinType(int i) {
        this.eJV.onChangeSkinType(i);
    }

    private void UT() {
        this.Gd.registerListener(this.bnV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIm() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new ax("c11593"));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.Gd.getPageActivity(), Long.parseLong(this.mUserData.getUserId()), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getIsFriend())));
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
        this.eJW = userData.getHave_attention() == 1;
        this.eJV.setData(this.eJW);
    }

    public void onDestroy() {
        if (this.eJX != null) {
            this.eJX.Za();
        }
    }
}
