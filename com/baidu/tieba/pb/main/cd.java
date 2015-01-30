package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements Animation.AnimationListener {
    final /* synthetic */ bz bEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bz bzVar) {
        this.bEC = bzVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        PbEditor pbEditor;
        PbEditor pbEditor2;
        View view;
        View view2;
        z = this.bEC.bEo;
        if (!z) {
            pbEditor = this.bEC.bEf;
            if (pbEditor != null) {
                pbEditor2 = this.bEC.bEf;
                pbEditor2.setVisibility(0);
                return;
            }
            return;
        }
        view = this.bEC.bEi;
        view.setVisibility(0);
        view2 = this.bEC.bEh;
        view2.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
