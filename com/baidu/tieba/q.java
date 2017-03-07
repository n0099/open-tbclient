package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity aPQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LogoActivity logoActivity) {
        this.aPQ = logoActivity;
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
        relativeLayout = this.aPQ.mRootView;
        if (relativeLayout != null) {
            relativeLayout2 = this.aPQ.mRootView;
            relativeLayout2.setVisibility(8);
        }
        i = this.aPQ.aPI;
        if (i >= 0) {
            LogoActivity logoActivity = this.aPQ;
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this.aPQ.getPageContext().getPageActivity());
            i2 = this.aPQ.aPI;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNormalCfg(i2)));
        } else {
            this.aPQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aPQ.getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        this.aPQ.finish();
    }
}
