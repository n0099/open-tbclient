package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity aLA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LogoActivity logoActivity) {
        this.aLA = logoActivity;
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
        relativeLayout = this.aLA.mRootView;
        if (relativeLayout != null) {
            relativeLayout2 = this.aLA.mRootView;
            relativeLayout2.setVisibility(8);
        }
        i = this.aLA.aLo;
        if (i >= 0) {
            LogoActivity logoActivity = this.aLA;
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this.aLA.getPageContext().getPageActivity());
            i2 = this.aLA.aLo;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNormalCfg(i2)));
        } else {
            this.aLA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aLA.getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        this.aLA.finish();
    }
}
