package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity aHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LogoActivity logoActivity) {
        this.aHJ = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        int i;
        int i2;
        RelativeLayout relativeLayout2;
        relativeLayout = this.aHJ.mRootView;
        if (relativeLayout != null) {
            relativeLayout2 = this.aHJ.mRootView;
            relativeLayout2.setVisibility(8);
        }
        i = this.aHJ.aHx;
        if (i >= 0) {
            LogoActivity logoActivity = this.aHJ;
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this.aHJ.getPageContext().getPageActivity());
            i2 = this.aHJ.aHx;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNormalCfg(i2)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(this.aHJ.getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
        }
        this.aHJ.finish();
    }
}
