package com.baidu.tieba.tblauncher;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    private final /* synthetic */ LinearLayout fyS;
    private final /* synthetic */ TbImageView fyT;
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MainTabActivity mainTabActivity, LinearLayout linearLayout, TbImageView tbImageView) {
        this.this$0 = mainTabActivity;
        this.fyS = linearLayout;
        this.fyT = tbImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.this$0.getBaseContext(), w.a.home_write_bgin);
        loadAnimation.setFillAfter(true);
        this.fyS.setVisibility(0);
        this.fyS.startAnimation(loadAnimation);
        this.fyT.setVisibility(0);
        this.fyT.startAnimation(AnimationUtils.loadAnimation(this.this$0.getBaseContext(), w.a.write_thread_anim));
    }
}
