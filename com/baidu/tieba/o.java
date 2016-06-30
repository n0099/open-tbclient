package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity aHs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LogoActivity logoActivity) {
        this.aHs = logoActivity;
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
        relativeLayout = this.aHs.mRootView;
        if (relativeLayout != null) {
            relativeLayout2 = this.aHs.mRootView;
            relativeLayout2.setVisibility(8);
        }
        i = this.aHs.aHg;
        if (i >= 0) {
            LogoActivity logoActivity = this.aHs;
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this.aHs.getPageContext().getPageActivity());
            i2 = this.aHs.aHg;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNormalCfg(i2)));
        } else {
            this.aHs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aHs.getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        this.aHs.finish();
    }
}
