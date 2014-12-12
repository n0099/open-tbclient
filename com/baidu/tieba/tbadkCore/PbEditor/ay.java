package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
/* loaded from: classes.dex */
public class ay {
    public static void a(ViewGroup viewGroup, Context context, ba baVar) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new az(baVar, viewGroup));
        viewGroup.startAnimation(translateAnimation);
    }
}
