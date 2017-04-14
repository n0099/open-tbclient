package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity aQg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LogoActivity logoActivity) {
        this.aQg = logoActivity;
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
        relativeLayout = this.aQg.mRootView;
        if (relativeLayout != null) {
            relativeLayout2 = this.aQg.mRootView;
            relativeLayout2.setVisibility(8);
        }
        i = this.aQg.aPY;
        if (i >= 0) {
            LogoActivity logoActivity = this.aQg;
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this.aQg.getPageContext().getPageActivity());
            i2 = this.aQg.aPY;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNormalCfg(i2)));
        } else {
            this.aQg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aQg.getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        this.aQg.finish();
    }
}
