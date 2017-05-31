package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity aQD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LogoActivity logoActivity) {
        this.aQD = logoActivity;
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
        relativeLayout = this.aQD.mRootView;
        if (relativeLayout != null) {
            relativeLayout2 = this.aQD.mRootView;
            relativeLayout2.setVisibility(8);
        }
        i = this.aQD.aQu;
        if (i >= 0) {
            LogoActivity logoActivity = this.aQD;
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this.aQD.getPageContext().getPageActivity());
            i2 = this.aQD.aQu;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNormalCfg(i2)));
        } else {
            this.aQD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aQD.getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        this.aQD.finish();
    }
}
