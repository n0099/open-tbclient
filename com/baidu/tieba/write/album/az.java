package com.baidu.tieba.write.album;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class az implements Animation.AnimationListener {
    final /* synthetic */ TransparentHeadGridView ggE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(TransparentHeadGridView transparentHeadGridView) {
        this.ggE = transparentHeadGridView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.ggE.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
