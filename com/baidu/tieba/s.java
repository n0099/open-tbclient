package com.baidu.tieba;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class s {

    /* loaded from: classes.dex */
    public interface a {
        void onCompleted();
    }

    public static void a(TbPageContext<?> tbPageContext, a aVar, RelativeLayout relativeLayout) {
        if (com.baidu.tbadk.core.sharedPref.b.uo().getInt("logo_animation_overtime_count", 0) >= 2 || relativeLayout == null) {
            if (aVar != null) {
                aVar.onCompleted();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TextView textView = new TextView(tbPageContext.getPageActivity());
        textView.setText(w.l.copyright);
        textView.setTextSize(0, tbPageContext.getResources().getDimensionPixelSize(w.f.fontsize28));
        textView.setTextColor(tbPageContext.getResources().getColor(w.e.cp_cont_d));
        textView.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = tbPageContext.getResources().getDimensionPixelSize(w.f.ds32);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        relativeLayout.addView(textView, layoutParams);
        ImageView imageView = new ImageView(tbPageContext.getPageActivity());
        aq.j(imageView, w.g.circle_shape);
        int dimensionPixelSize = tbPageContext.getResources().getDimensionPixelSize(w.f.ds140);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams2.topMargin = tbPageContext.getResources().getDimensionPixelSize(w.f.ds374);
        layoutParams2.addRule(14);
        relativeLayout.addView(imageView, layoutParams2);
        GifView gifView = new GifView(tbPageContext.getPageActivity());
        gifView.setAutoPlay(false);
        gifView.setIsKeepLastFrame(true);
        gifView.setGifRaw(w.k.qidong);
        gifView.setVisibility(4);
        gifView.setPlayCallback(new t(imageView, gifView, currentTimeMillis, aVar));
        int dimensionPixelSize2 = tbPageContext.getResources().getDimensionPixelSize(w.f.ds640);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2);
        layoutParams3.topMargin = tbPageContext.getResources().getDimensionPixelSize(w.f.ds100);
        layoutParams3.addRule(14);
        relativeLayout.addView(gifView, layoutParams3);
        ScaleAnimation scaleAnimation = new ScaleAnimation(50.0f, 1.0f, 50.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        scaleAnimation.setAnimationListener(new u(gifView, textView));
        imageView.startAnimation(scaleAnimation);
    }
}
