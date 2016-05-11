package com.baidu.tieba.tbadkCore;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
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

    public static final void a(TbPageContextSupport tbPageContextSupport, View view, int i, Animation.AnimationListener animationListener) {
        if (view != null) {
            try {
                a(tbPageContextSupport, view, AnimationUtils.loadAnimation(TbadkCoreApplication.m11getInst().getContext(), i), animationListener);
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
