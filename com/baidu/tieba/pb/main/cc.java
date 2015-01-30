package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements Animation.AnimationListener {
    final /* synthetic */ bz bEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bz bzVar) {
        this.bEC = bzVar;
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
        bz bzVar = this.bEC;
        view = this.bEC.bEi;
        bzVar.bEo = view.getVisibility() == 0;
        pbEditor = this.bEC.bEf;
        if (pbEditor != null) {
            pbEditor2 = this.bEC.bEf;
            pbEditor2.setVisibility(8);
        }
        view2 = this.bEC.bEi;
        view2.setVisibility(8);
        view3 = this.bEC.bEh;
        view3.setVisibility(8);
        pbActivity = this.bEC.bCG;
        pbActivity.showToast(com.baidu.tieba.z.pb_double_click_tips, 0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
