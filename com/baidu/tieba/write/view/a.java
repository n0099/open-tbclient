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
/* loaded from: classes8.dex */
public class a extends PopupWindow {
    private View bMM;
    private ViewGroup bMN;
    private int bMP;
    private BaseFragmentActivity giB;
    private ListView mListView;
    private final View.OnClickListener mOnClickListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private int ohU;
    private ValueAnimator ohV;
    private ValueAnimator ohW;
    private b ohX;
    private InterfaceC0904a ohY;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0904a {
        void a(int i, com.baidu.tbadk.album.a aVar);
    }

    public void a(InterfaceC0904a interfaceC0904a) {
        this.ohY = interfaceC0904a;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext().getPageActivity());
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.album.a item = a.this.ohX.getItem(i);
                if (a.this.ohY != null) {
                    a.this.ohY.a(i, item);
                }
                a.this.UU();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.UU();
            }
        };
        this.giB = baseFragmentActivity;
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
        BdListView bdListView = new BdListView(this.giB.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.giB.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.ohX = new b(this.giB);
        this.ohX.setData(list, str);
        bdListView.setAdapter((ListAdapter) this.ohX);
        FrameLayout frameLayout = new FrameLayout(this.giB.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.giB.getPageContext().getPageActivity());
        this.bMN = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        frameLayout.setOnClickListener(this.mOnClickListener);
        ap.setBackgroundColor(this.bMM, R.color.CAM_X0201);
        ap.setBackgroundColor(this.mListView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.bMN, R.color.black_alpha70);
        return frameLayout;
    }

    public void setData(List<com.baidu.tbadk.album.a> list, String str) {
        if (list != null) {
            this.bMP = d(list, str);
            this.ohU = -2;
            if (list.size() > 5) {
                this.ohU = this.giB.getResources().getDimensionPixelSize(R.dimen.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.ohU);
            } else {
                layoutParams.height = this.ohU;
            }
            this.mListView.setLayoutParams(layoutParams);
            if (this.ohU < 0) {
                this.ohU = l.getDimens(this.giB, R.dimen.tbds168) * list.size();
            }
            this.ohX.setData(list, str);
            this.ohX.notifyDataSetChanged();
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
        this.mListView.setSelection(this.bMP);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.showPopupWindowAsDropDown(this, view)) {
                UW();
                return;
            }
            return;
        }
        int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int height = view.getHeight() + iArr[1];
        ((FrameLayout.LayoutParams) this.mListView.getLayoutParams()).topMargin = height - statusBarHeight;
        ((FrameLayout.LayoutParams) this.bMN.getLayoutParams()).topMargin = height - statusBarHeight;
        if (g.showPopupWindowAtLocation(this, view, 0, 0, 0)) {
            UW();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        UU();
    }

    public void UU() {
        UX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UV() {
        super.dismiss();
    }

    private void UW() {
        if (this.ohV == null) {
            this.ohV = ValueAnimator.ofInt(0, this.ohU);
            this.ohV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.view.a.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = a.this.mListView.getLayoutParams();
                    layoutParams.height = intValue;
                    a.this.mListView.setLayoutParams(layoutParams);
                }
            });
            this.ohV.setDuration(350L);
        }
        this.ohV.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.bMN.startAnimation(alphaAnimation);
    }

    private void UX() {
        if (this.ohW == null) {
            this.ohW = ValueAnimator.ofInt(this.mListView.getHeight(), 0);
            this.ohW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.view.a.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = a.this.mListView.getLayoutParams();
                    layoutParams.height = intValue;
                    a.this.mListView.setLayoutParams(layoutParams);
                }
            });
            this.ohW.setDuration(350L);
        }
        this.ohW.start();
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
                a.this.UV();
            }
        });
        this.bMN.startAnimation(alphaAnimation);
    }

    public void clearAnimation() {
        if (this.mListView != null) {
            this.mListView.clearAnimation();
        }
        if (this.bMN != null) {
            this.bMN.clearAnimation();
        }
    }
}
