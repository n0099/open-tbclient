package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
/* loaded from: classes.dex */
public class ac {
    public static void a(ViewGroup viewGroup, Context context, ae aeVar) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new ad(aeVar, viewGroup));
        viewGroup.startAnimation(translateAnimation);
    }
}
