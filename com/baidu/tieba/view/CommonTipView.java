package com.baidu.tieba.view;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private int Ae;
    private Runnable ctk;
    private TranslateAnimation ctn;
    private Animation fNS;
    private a fNT;

    /* loaded from: classes.dex */
    public interface a {
        void bmB();
    }

    public CommonTipView(Context context) {
        super(context);
        this.Ae = 4000;
        this.fNS = AnimationUtils.loadAnimation(TbadkCoreApplication.m10getInst(), u.a.fade_out);
        this.ctn = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m10getInst().getResources().getDimension(u.e.ds56), 0.0f);
        this.ctk = new d(this);
        init();
    }

    private void init() {
        setTextSize(0, TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds24));
        setGravity(17);
        this.fNS.setAnimationListener(new e(this));
        this.ctn.setDuration(400L);
        this.ctn.setAnimationListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.ctk);
        if (this != null && getParent() != null) {
            startAnimation(this.fNS);
        }
    }

    public void b(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.ctn);
        }
    }

    public void a(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds56));
            layoutParams.setMargins(0, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT), 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.ctn);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.Ae = i;
        }
    }

    public void onChangeSkinType(int i) {
        av.d(this, u.d.common_color_10260, i);
        av.b(this, u.d.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.ctk);
    }
}
