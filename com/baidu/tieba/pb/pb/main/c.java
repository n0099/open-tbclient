package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Animation.AnimationListener {
    final /* synthetic */ GetLotteryChanceActivity dfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GetLotteryChanceActivity getLotteryChanceActivity) {
        this.dfT = getLotteryChanceActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        LinearLayout linearLayout;
        String str;
        long j;
        linearLayout = this.dfT.dfG;
        linearLayout.setVisibility(0);
        com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10841");
        str = this.dfT.forumId;
        com.baidu.tbadk.core.util.aw ac = awVar.ac("fid", str);
        j = this.dfT.threadId;
        TiebaStatic.log(ac.ac("tid", String.valueOf(j)));
    }
}
