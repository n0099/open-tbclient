package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements Animation.AnimationListener {
    final /* synthetic */ bz bEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bz bzVar) {
        this.bEB = bzVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        PbEditor pbEditor;
        View view2;
        View view3;
        PbActivity pbActivity;
        PbEditor pbEditor2;
        bz bzVar = this.bEB;
        view = this.bEB.bEh;
        bzVar.bEn = view.getVisibility() == 0;
        pbEditor = this.bEB.bEe;
        if (pbEditor != null) {
            pbEditor2 = this.bEB.bEe;
            pbEditor2.setVisibility(8);
        }
        view2 = this.bEB.bEh;
        view2.setVisibility(8);
        view3 = this.bEB.bEg;
        view3.setVisibility(8);
        pbActivity = this.bEB.bCF;
        pbActivity.showToast(com.baidu.tieba.z.pb_double_click_tips, 0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
