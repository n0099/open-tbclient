package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements Animation.AnimationListener {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bz bzVar) {
        this.bCR = bzVar;
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
        bz bzVar = this.bCR;
        view = this.bCR.bCx;
        bzVar.bCD = view.getVisibility() == 0;
        pbEditor = this.bCR.bCu;
        if (pbEditor != null) {
            pbEditor2 = this.bCR.bCu;
            pbEditor2.setVisibility(8);
        }
        view2 = this.bCR.bCx;
        view2.setVisibility(8);
        view3 = this.bCR.bCw;
        view3.setVisibility(8);
        pbActivity = this.bCR.bAW;
        pbActivity.showToast(com.baidu.tieba.z.pb_double_click_tips, 0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
