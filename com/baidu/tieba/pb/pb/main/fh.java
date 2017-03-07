package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fh implements Animation.AnimationListener {
    final /* synthetic */ fa etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(fa faVar) {
        this.etn = faVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        com.baidu.tbadk.editortools.j jVar;
        View view2;
        com.baidu.tbadk.editortools.j jVar2;
        fa faVar = this.etn;
        view = this.etn.esf;
        faVar.esk = view.getVisibility() == 0;
        jVar = this.etn.Ll;
        if (jVar != null) {
            jVar2 = this.etn.Ll;
            jVar2.hide();
        }
        view2 = this.etn.esf;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
