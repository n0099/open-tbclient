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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f {
    private TbPageContext Fp;
    private ViewGroup UR;
    private CustomMessageListener aTR = new ag(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private BaseActivity aWr;
    private com.baidu.tbadk.coreExtra.d.a dSm;
    private com.baidu.tieba.personPolymeric.d.af eDN;
    public com.baidu.tieba.g.c eDO;
    private boolean mIsLiked;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public af(BaseActivity baseActivity, ViewGroup viewGroup, UserData userData) {
        this.aWr = baseActivity;
        this.Fp = baseActivity.getPageContext();
        this.UR = viewGroup;
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.dSm = new com.baidu.tbadk.coreExtra.d.a(this);
        ahj();
        Mj();
        if (this.UR != null && this.eDN != null) {
            this.eDO = new com.baidu.tieba.g.c(this.Fp.getPageActivity(), this.eDN, null);
        }
    }

    private void ahj() {
        this.mOnClickListener = new ah(this);
        this.eDN = new com.baidu.tieba.personPolymeric.d.af(this.Fp.getPageActivity(), this.mIsLiked, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds110));
        this.eDN.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.eDN.setAlpha(0.9f);
        this.eDN.setOrientation(0);
        this.UR.addView(this.eDN);
    }

    public void onChangeSkinType(int i) {
        this.eDN.onChangeSkinType(i);
    }

    private void Mj() {
        this.Fp.registerListener(this.aTR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFV() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new ar("c11593"));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.Fp.getPageActivity(), Long.parseLong(this.mUserData.getUserId()), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getIsFriend())));
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
        this.eDN.setData(this.mIsLiked);
    }

    public void onDestroy() {
        if (this.eDO != null) {
            this.eDO.VK();
        }
    }
}
