package com.baidu.tieba.write.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends PopupWindow {
    private ViewGroup bkA;
    private int bkC;
    private View bkz;
    private BaseFragmentActivity feq;
    private ListView mListView;
    private final View.OnClickListener mOnClickListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private int mzE;
    private ValueAnimator mzF;
    private ValueAnimator mzG;
    private b mzH;
    private InterfaceC0786a mzI;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0786a {
        void a(int i, com.baidu.tbadk.album.a aVar);
    }

    public void a(InterfaceC0786a interfaceC0786a) {
        this.mzI = interfaceC0786a;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext().getPageActivity());
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.album.a item = a.this.mzH.getItem(i);
                if (a.this.mzI != null) {
                    a.this.mzI.a(i, item);
                }
                a.this.Jj();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Jj();
            }
        };
        this.feq = baseFragmentActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(c(new ArrayList(), com.baidu.tbadk.album.a.ALBUM_ID_ALL));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @SuppressLint({"ResourceAsColor"})
    private View c(List<com.baidu.tbadk.album.a> list, String str) {
        BdListView bdListView = new BdListView(this.feq.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.feq.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.mzH = new b(this.feq);
        this.mzH.b(list, str);
        bdListView.setAdapter((ListAdapter) this.mzH);
        FrameLayout frameLayout = new FrameLayout(this.feq.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.feq.getPageContext().getPageActivity());
        this.bkA = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        frameLayout.setOnClickListener(this.mOnClickListener);
        ao.setBackgroundColor(this.bkz, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.mListView, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.bkA, R.color.black_alpha70);
        return frameLayout;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        if (list != null) {
            this.bkC = d(list, str);
            this.mzE = -2;
            if (list.size() > 5) {
                this.mzE = this.feq.getResources().getDimensionPixelSize(R.dimen.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.mzE);
            } else {
                layoutParams.height = this.mzE;
            }
            this.mListView.setLayoutParams(layoutParams);
            if (this.mzE < 0) {
                this.mzE = l.getDimens(this.feq, R.dimen.tbds168) * list.size();
            }
            this.mzH.b(list, str);
            this.mzH.notifyDataSetChanged();
        }
    }

    private int d(List<com.baidu.tbadk.album.a> list, String str) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.album.a aVar = list.get(i);
            if (aVar != null && str.equals(aVar.getAlbumId())) {
                return i;
            }
        }
        return -1;
    }

    public void O(View view) {
        this.mListView.setSelection(this.bkC);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.showPopupWindowAsDropDown(this, view)) {
                Jl();
                return;
            }
            return;
        }
        int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int height = view.getHeight() + iArr[1];
        ((FrameLayout.LayoutParams) this.mListView.getLayoutParams()).topMargin = height - statusBarHeight;
        ((FrameLayout.LayoutParams) this.bkA.getLayoutParams()).topMargin = height - statusBarHeight;
        if (g.showPopupWindowAtLocation(this, view, 0, 0, 0)) {
            Jl();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Jj();
    }

    public void Jj() {
        Jm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jk() {
        super.dismiss();
    }

    private void Jl() {
        if (this.mzF == null) {
            this.mzF = ValueAnimator.ofInt(0, this.mzE);
            this.mzF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.view.a.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = a.this.mListView.getLayoutParams();
                    layoutParams.height = intValue;
                    a.this.mListView.setLayoutParams(layoutParams);
                }
            });
            this.mzF.setDuration(350L);
        }
        this.mzF.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.bkA.startAnimation(alphaAnimation);
    }

    private void Jm() {
        if (this.mzG == null) {
            this.mzG = ValueAnimator.ofInt(this.mListView.getHeight(), 0);
            this.mzG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.view.a.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = a.this.mListView.getLayoutParams();
                    layoutParams.height = intValue;
                    a.this.mListView.setLayoutParams(layoutParams);
                }
            });
            this.mzG.setDuration(350L);
        }
        this.mzG.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.view.a.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.Jk();
            }
        });
        this.bkA.startAnimation(alphaAnimation);
    }

    public void clearAnimation() {
        if (this.mListView != null) {
            this.mListView.clearAnimation();
        }
        if (this.bkA != null) {
            this.bkA.clearAnimation();
        }
    }
}
