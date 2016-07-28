package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity aIj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LogoActivity logoActivity) {
        this.aIj = logoActivity;
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
        relativeLayout = this.aIj.mRootView;
        if (relativeLayout != null) {
            relativeLayout2 = this.aIj.mRootView;
            relativeLayout2.setVisibility(8);
        }
        i = this.aIj.aHX;
        if (i >= 0) {
            LogoActivity logoActivity = this.aIj;
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this.aIj.getPageContext().getPageActivity());
            i2 = this.aIj.aHX;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNormalCfg(i2)));
        } else {
            this.aIj.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aIj.getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        this.aIj.finish();
    }
}
