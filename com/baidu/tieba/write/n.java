package com.baidu.tieba.write;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ e gdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(e eVar) {
        this.gdS = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbPageContext tbPageContext;
        GridLayout gridLayout;
        GridLayout gridLayout2;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        TbPageContext tbPageContext2;
        tbPageContext = this.gdS.aat;
        Animation loadAnimation = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), w.a.home_write_bgin);
        loadAnimation.setFillAfter(true);
        gridLayout = this.gdS.gdK;
        gridLayout.setVisibility(0);
        gridLayout2 = this.gdS.gdK;
        gridLayout2.startAnimation(loadAnimation);
        tbImageView = this.gdS.gdJ;
        tbImageView.setVisibility(0);
        tbImageView2 = this.gdS.gdJ;
        tbPageContext2 = this.gdS.aat;
        tbImageView2.startAnimation(AnimationUtils.loadAnimation(tbPageContext2.getPageActivity(), w.a.write_thread_anim));
    }
}
