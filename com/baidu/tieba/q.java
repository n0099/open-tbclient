package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity aQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LogoActivity logoActivity) {
        this.aQi = logoActivity;
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
        relativeLayout = this.aQi.mRootView;
        if (relativeLayout != null) {
            relativeLayout2 = this.aQi.mRootView;
            relativeLayout2.setVisibility(8);
        }
        i = this.aQi.aQa;
        if (i >= 0) {
            LogoActivity logoActivity = this.aQi;
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this.aQi.getPageContext().getPageActivity());
            i2 = this.aQi.aQa;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNormalCfg(i2)));
        } else {
            this.aQi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aQi.getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        this.aQi.finish();
    }
}
