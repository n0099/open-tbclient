package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity aGQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LogoActivity logoActivity) {
        this.aGQ = logoActivity;
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
        relativeLayout = this.aGQ.mRootView;
        if (relativeLayout != null) {
            relativeLayout2 = this.aGQ.mRootView;
            relativeLayout2.setVisibility(8);
        }
        i = this.aGQ.aGE;
        if (i >= 0) {
            LogoActivity logoActivity = this.aGQ;
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this.aGQ.getPageContext().getPageActivity());
            i2 = this.aGQ.aGE;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNormalCfg(i2)));
        } else {
            this.aGQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.aGQ.getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        this.aGQ.finish();
    }
}
