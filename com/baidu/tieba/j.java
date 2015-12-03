package com.baidu.tieba;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class j {

    /* loaded from: classes.dex */
    public interface a {
        void GJ();
    }

    public static void a(TbPageContext<?> tbPageContext, a aVar, RelativeLayout relativeLayout) {
        if (com.baidu.tbadk.core.sharedPref.b.tZ().getInt("logo_animation_overtime_count", 0) >= 2) {
            if (aVar != null) {
                aVar.GJ();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TextView textView = new TextView(tbPageContext.getPageActivity());
        textView.setText(n.i.copyright);
        textView.setTextSize(0, tbPageContext.getResources().getDimensionPixelSize(n.d.fontsize28));
        textView.setTextColor(tbPageContext.getResources().getColor(n.c.cp_cont_d));
        textView.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = tbPageContext.getResources().getDimensionPixelSize(n.d.ds32);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        relativeLayout.addView(textView, layoutParams);
        ImageView imageView = new ImageView(tbPageContext.getPageActivity());
        as.i(imageView, n.e.circle_shape);
        int dimensionPixelSize = tbPageContext.getResources().getDimensionPixelSize(n.d.ds140);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams2.topMargin = tbPageContext.getResources().getDimensionPixelSize(n.d.ds374);
        layoutParams2.addRule(14);
        relativeLayout.addView(imageView, layoutParams2);
        GifView gifView = new GifView(tbPageContext.getPageActivity());
        gifView.setAutoPlay(false);
        gifView.setIsKeepLastFrame(true);
        gifView.setGifRaw(n.h.qidong);
        gifView.setVisibility(4);
        gifView.setPlayCallback(new k(imageView, gifView, currentTimeMillis, aVar));
        int dimensionPixelSize2 = tbPageContext.getResources().getDimensionPixelSize(n.d.ds640);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2);
        layoutParams3.topMargin = tbPageContext.getResources().getDimensionPixelSize(n.d.ds100);
        layoutParams3.addRule(14);
        relativeLayout.addView(gifView, layoutParams3);
        ScaleAnimation scaleAnimation = new ScaleAnimation(50.0f, 1.0f, 50.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        scaleAnimation.setAnimationListener(new l(gifView, textView));
        imageView.startAnimation(scaleAnimation);
    }
}
