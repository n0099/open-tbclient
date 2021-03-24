package com.baidu.wallet.core.utils;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
/* loaded from: classes5.dex */
public class AnimUtils {
    public static void startSharkAnim(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(-10.0f, 10.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(40L);
        translateAnimation.setRepeatCount(2);
        translateAnimation.setRepeatMode(2);
        view.startAnimation(translateAnimation);
    }
}
