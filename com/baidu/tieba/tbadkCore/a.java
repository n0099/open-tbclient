package com.baidu.tieba.tbadkCore;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.TbPageContextSupport;
/* loaded from: classes.dex */
public class a {
    public static final void a(TbPageContextSupport tbPageContextSupport, Animatable animatable) {
        if (tbPageContextSupport != null) {
            tbPageContextSupport.getPageContext().startAnimatable(animatable);
        }
    }

    public static final void a(TbPageContextSupport tbPageContextSupport, View view, Animation animation, Animation.AnimationListener animationListener) {
        if (tbPageContextSupport != null) {
            tbPageContextSupport.getPageContext().startAnimation(view, animation, animationListener);
        }
    }
}
