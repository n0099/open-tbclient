package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity aKF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LogoActivity logoActivity) {
        this.aKF = logoActivity;
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
        relativeLayout = this.aKF.mRootView;
        if (relativeLayout != null) {
            relativeLayout2 = this.aKF.mRootView;
            relativeLayout2.setVisibility(8);
        }
        i = this.aKF.aKt;
        if (i >= 0) {
            LogoActivity logoActivity = this.aKF;
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this.aKF.getPageContext().getPageActivity());
            i2 = this.aKF.aKt;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNormalCfg(i2)));
        } else {
            this.aKF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aKF.getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        this.aKF.finish();
    }
}
