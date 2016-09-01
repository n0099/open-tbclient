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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.g {
    private TbPageContext Gd;
    private ViewGroup Vz;
    private BaseActivity aPR;
    private CustomMessageListener bnI = new ag(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.coreExtra.d.a bwf;
    private com.baidu.tieba.personPolymeric.d.ad eHR;
    private boolean eHS;
    public com.baidu.tieba.f.c eHT;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public af(BaseActivity baseActivity, ViewGroup viewGroup, UserData userData) {
        this.aPR = baseActivity;
        this.Gd = baseActivity.getPageContext();
        this.Vz = viewGroup;
        this.mUserData = userData;
        this.eHS = userData.getHave_attention() == 1;
        this.bwf = new com.baidu.tbadk.coreExtra.d.a(this);
        ajr();
        UA();
        if (this.Vz != null && this.eHR != null) {
            this.eHT = new com.baidu.tieba.f.c(this.Gd.getPageActivity(), this.eHR, null);
        }
    }

    private void ajr() {
        this.mOnClickListener = new ah(this);
        this.eHR = new com.baidu.tieba.personPolymeric.d.ad(this.Gd.getPageActivity(), this.eHS, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds110));
        this.eHR.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.eHR.setAlpha(0.9f);
        this.eHR.setOrientation(0);
        this.Vz.addView(this.eHR);
    }

    public void onChangeSkinType(int i) {
        this.eHR.onChangeSkinType(i);
    }

    private void UA() {
        this.Gd.registerListener(this.bnI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHL() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new ay("c11593"));
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
        this.eHS = userData.getHave_attention() == 1;
        this.eHR.setData(this.eHS);
    }
}
