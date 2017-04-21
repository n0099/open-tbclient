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
    private TbPageContext aaY;
    private ViewGroup aat;
    private CustomMessageListener baa = new ag(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private BaseActivity bdG;
    private com.baidu.tbadk.coreExtra.c.a dUO;
    private com.baidu.tieba.personPolymeric.d.af eHB;
    public com.baidu.tieba.f.c eHC;
    private boolean mIsLiked;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public af(BaseActivity baseActivity, ViewGroup viewGroup, UserData userData) {
        this.bdG = baseActivity;
        this.aaY = baseActivity.getPageContext();
        this.aat = viewGroup;
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.dUO = new com.baidu.tbadk.coreExtra.c.a(this);
        ahp();
        initListener();
        if (this.aat != null && this.eHB != null) {
            this.eHC = new com.baidu.tieba.f.c(this.aaY.getPageActivity(), this.eHB, null);
        }
    }

    private void ahp() {
        this.mOnClickListener = new ah(this);
        this.eHB = new com.baidu.tieba.personPolymeric.d.af(this.aaY.getPageActivity(), this.mIsLiked, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds110));
        this.eHB.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.eHB.setAlpha(0.9f);
        this.eHB.setOrientation(0);
        this.aat.addView(this.eHB);
    }

    public void onChangeSkinType(int i) {
        this.eHB.onChangeSkinType(i);
    }

    private void initListener() {
        this.aaY.registerListener(this.baa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGg() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new as("c11593"));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.aaY.getPageActivity(), Long.parseLong(this.mUserData.getUserId()), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getIsFriend())));
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
        this.eHB.setData(this.mIsLiked);
    }

    public void onDestroy() {
        if (this.eHC != null) {
            this.eHC.Yh();
        }
    }
}
