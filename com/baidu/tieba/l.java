package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity aLM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LogoActivity logoActivity) {
        this.aLM = logoActivity;
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
        relativeLayout = this.aLM.mRootView;
        if (relativeLayout != null) {
            relativeLayout2 = this.aLM.mRootView;
            relativeLayout2.setVisibility(8);
        }
        i = this.aLM.aLE;
        if (i >= 0) {
            LogoActivity logoActivity = this.aLM;
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this.aLM.getPageContext().getPageActivity());
            i2 = this.aLM.aLE;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNormalCfg(i2)));
        } else {
            this.aLM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aLM.getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        this.aLM.finish();
    }
}
