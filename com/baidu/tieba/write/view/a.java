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
    private View bJa;
    private ViewGroup bJb;
    private int bJd;
    private BaseFragmentActivity gbo;
    private ListView mListView;
    private final View.OnClickListener mOnClickListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private int nZH;
    private ValueAnimator nZI;
    private ValueAnimator nZJ;
    private b nZK;
    private InterfaceC0903a nZL;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0903a {
        void a(int i, com.baidu.tbadk.album.a aVar);
    }

    public void a(InterfaceC0903a interfaceC0903a) {
        this.nZL = interfaceC0903a;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext().getPageActivity());
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.album.a item = a.this.nZK.getItem(i);
                if (a.this.nZL != null) {
                    a.this.nZL.a(i, item);
                }
                a.this.Wd();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Wd();
            }
        };
        this.gbo = baseFragmentActivity;
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
        BdListView bdListView = new BdListView(this.gbo.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.gbo.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.nZK = new b(this.gbo);
        this.nZK.c(list, str);
        bdListView.setAdapter((ListAdapter) this.nZK);
        FrameLayout frameLayout = new FrameLayout(this.gbo.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.gbo.getPageContext().getPageActivity());
        this.bJb = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        frameLayout.setOnClickListener(this.mOnClickListener);
        ap.setBackgroundColor(this.bJa, R.color.CAM_X0201);
        ap.setBackgroundColor(this.mListView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.bJb, R.color.black_alpha70);
        return frameLayout;
    }

    public void c(List<com.baidu.tbadk.album.a> list, String str) {
        if (list != null) {
            this.bJd = e(list, str);
            this.nZH = -2;
            if (list.size() > 5) {
                this.nZH = this.gbo.getResources().getDimensionPixelSize(R.dimen.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.nZH);
            } else {
                layoutParams.height = this.nZH;
            }
            this.mListView.setLayoutParams(layoutParams);
            if (this.nZH < 0) {
                this.nZH = l.getDimens(this.gbo, R.dimen.tbds168) * list.size();
            }
            this.nZK.c(list, str);
            this.nZK.notifyDataSetChanged();
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
        this.mListView.setSelection(this.bJd);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.showPopupWindowAsDropDown(this, view)) {
                Wf();
                return;
            }
            return;
        }
        int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int height = view.getHeight() + iArr[1];
        ((FrameLayout.LayoutParams) this.mListView.getLayoutParams()).topMargin = height - statusBarHeight;
        ((FrameLayout.LayoutParams) this.bJb.getLayoutParams()).topMargin = height - statusBarHeight;
        if (g.showPopupWindowAtLocation(this, view, 0, 0, 0)) {
            Wf();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Wd();
    }

    public void Wd() {
        Wg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We() {
        super.dismiss();
    }

    private void Wf() {
        if (this.nZI == null) {
            this.nZI = ValueAnimator.ofInt(0, this.nZH);
            this.nZI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.view.a.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = a.this.mListView.getLayoutParams();
                    layoutParams.height = intValue;
                    a.this.mListView.setLayoutParams(layoutParams);
                }
            });
            this.nZI.setDuration(350L);
        }
        this.nZI.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.bJb.startAnimation(alphaAnimation);
    }

    private void Wg() {
        if (this.nZJ == null) {
            this.nZJ = ValueAnimator.ofInt(this.mListView.getHeight(), 0);
            this.nZJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.view.a.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = a.this.mListView.getLayoutParams();
                    layoutParams.height = intValue;
                    a.this.mListView.setLayoutParams(layoutParams);
                }
            });
            this.nZJ.setDuration(350L);
        }
        this.nZJ.start();
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
                a.this.We();
            }
        });
        this.bJb.startAnimation(alphaAnimation);
    }

    public void clearAnimation() {
        if (this.mListView != null) {
            this.mListView.clearAnimation();
        }
        if (this.bJb != null) {
            this.bJb.clearAnimation();
        }
    }
}
