package com.baidu.tieba.tblauncher;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    private final /* synthetic */ GridLayout fGP;
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(MainTabActivity mainTabActivity, GridLayout gridLayout) {
        this.this$0 = mainTabActivity;
        this.fGP = gridLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        Animation loadAnimation = AnimationUtils.loadAnimation(this.this$0.getBaseContext(), w.a.home_write_bgin);
        loadAnimation.setFillAfter(true);
        this.fGP.setVisibility(0);
        this.fGP.startAnimation(loadAnimation);
        tbImageView = this.this$0.fGB;
        tbImageView.setVisibility(0);
        tbImageView2 = this.this$0.fGB;
        tbImageView2.startAnimation(AnimationUtils.loadAnimation(this.this$0.getBaseContext(), w.a.write_thread_anim));
    }
}
