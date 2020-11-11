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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends PopupWindow {
    private View bFD;
    private ViewGroup bFE;
    private int bFG;
    private BaseFragmentActivity fTv;
    private ListView mListView;
    private final View.OnClickListener mOnClickListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private int nJY;
    private ValueAnimator nJZ;
    private ValueAnimator nKa;
    private b nKb;
    private InterfaceC0884a nKc;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0884a {
        void a(int i, com.baidu.tbadk.album.a aVar);
    }

    public void a(InterfaceC0884a interfaceC0884a) {
        this.nKc = interfaceC0884a;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext().getPageActivity());
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.album.a item = a.this.nKb.getItem(i);
                if (a.this.nKc != null) {
                    a.this.nKc.a(i, item);
                }
                a.this.Um();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Um();
            }
        };
        this.fTv = baseFragmentActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(d(new ArrayList(), com.baidu.tbadk.album.a.ALBUM_ID_ALL));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @SuppressLint({"ResourceAsColor"})
    private View d(List<com.baidu.tbadk.album.a> list, String str) {
        BdListView bdListView = new BdListView(this.fTv.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.fTv.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.nKb = new b(this.fTv);
        this.nKb.c(list, str);
        bdListView.setAdapter((ListAdapter) this.nKb);
        FrameLayout frameLayout = new FrameLayout(this.fTv.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.fTv.getPageContext().getPageActivity());
        this.bFE = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        frameLayout.setOnClickListener(this.mOnClickListener);
        ap.setBackgroundColor(this.bFD, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.mListView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.bFE, R.color.black_alpha70);
        return frameLayout;
    }

    public void c(List<com.baidu.tbadk.album.a> list, String str) {
        if (list != null) {
            this.bFG = e(list, str);
            this.nJY = -2;
            if (list.size() > 5) {
                this.nJY = this.fTv.getResources().getDimensionPixelSize(R.dimen.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.nJY);
            } else {
                layoutParams.height = this.nJY;
            }
            this.mListView.setLayoutParams(layoutParams);
            if (this.nJY < 0) {
                this.nJY = l.getDimens(this.fTv, R.dimen.tbds168) * list.size();
            }
            this.nKb.c(list, str);
            this.nKb.notifyDataSetChanged();
        }
    }

    private int e(List<com.baidu.tbadk.album.a> list, String str) {
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
        this.mListView.setSelection(this.bFG);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.showPopupWindowAsDropDown(this, view)) {
                Uo();
                return;
            }
            return;
        }
        int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int height = view.getHeight() + iArr[1];
        ((FrameLayout.LayoutParams) this.mListView.getLayoutParams()).topMargin = height - statusBarHeight;
        ((FrameLayout.LayoutParams) this.bFE.getLayoutParams()).topMargin = height - statusBarHeight;
        if (g.showPopupWindowAtLocation(this, view, 0, 0, 0)) {
            Uo();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Um();
    }

    public void Um() {
        Up();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Un() {
        super.dismiss();
    }

    private void Uo() {
        if (this.nJZ == null) {
            this.nJZ = ValueAnimator.ofInt(0, this.nJY);
            this.nJZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.view.a.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = a.this.mListView.getLayoutParams();
                    layoutParams.height = intValue;
                    a.this.mListView.setLayoutParams(layoutParams);
                }
            });
            this.nJZ.setDuration(350L);
        }
        this.nJZ.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.bFE.startAnimation(alphaAnimation);
    }

    private void Up() {
        if (this.nKa == null) {
            this.nKa = ValueAnimator.ofInt(this.mListView.getHeight(), 0);
            this.nKa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.view.a.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = a.this.mListView.getLayoutParams();
                    layoutParams.height = intValue;
                    a.this.mListView.setLayoutParams(layoutParams);
                }
            });
            this.nKa.setDuration(350L);
        }
        this.nKa.start();
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
                a.this.Un();
            }
        });
        this.bFE.startAnimation(alphaAnimation);
    }

    public void clearAnimation() {
        if (this.mListView != null) {
            this.mListView.clearAnimation();
        }
        if (this.bFE != null) {
            this.bFE.clearAnimation();
        }
    }
}
