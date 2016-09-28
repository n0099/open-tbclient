package com.baidu.tieba;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class n {

    /* loaded from: classes.dex */
    public interface a {
        void onCompleted();
    }

    public static void a(TbPageContext<?> tbPageContext, a aVar, RelativeLayout relativeLayout) {
        if (com.baidu.tbadk.core.sharedPref.b.uh().getInt("logo_animation_overtime_count", 0) >= 2 || relativeLayout == null) {
            if (aVar != null) {
                aVar.onCompleted();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TextView textView = new TextView(tbPageContext.getPageActivity());
        textView.setText(r.j.copyright);
        textView.setTextSize(0, tbPageContext.getResources().getDimensionPixelSize(r.e.fontsize28));
        textView.setTextColor(tbPageContext.getResources().getColor(r.d.cp_cont_d));
        textView.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = tbPageContext.getResources().getDimensionPixelSize(r.e.ds32);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        relativeLayout.addView(textView, layoutParams);
        ImageView imageView = new ImageView(tbPageContext.getPageActivity());
        av.k(imageView, r.f.circle_shape);
        int dimensionPixelSize = tbPageContext.getResources().getDimensionPixelSize(r.e.ds140);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams2.topMargin = tbPageContext.getResources().getDimensionPixelSize(r.e.ds374);
        layoutParams2.addRule(14);
        relativeLayout.addView(imageView, layoutParams2);
        GifView gifView = new GifView(tbPageContext.getPageActivity());
        gifView.setAutoPlay(false);
        gifView.setIsKeepLastFrame(true);
        gifView.setGifRaw(r.i.qidong);
        gifView.setVisibility(4);
        gifView.setPlayCallback(new o(imageView, gifView, currentTimeMillis, aVar));
        int dimensionPixelSize2 = tbPageContext.getResources().getDimensionPixelSize(r.e.ds640);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2);
        layoutParams3.topMargin = tbPageContext.getResources().getDimensionPixelSize(r.e.ds100);
        layoutParams3.addRule(14);
        relativeLayout.addView(gifView, layoutParams3);
        ScaleAnimation scaleAnimation = new ScaleAnimation(50.0f, 1.0f, 50.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        scaleAnimation.setAnimationListener(new p(gifView, textView));
        imageView.startAnimation(scaleAnimation);
    }
}
