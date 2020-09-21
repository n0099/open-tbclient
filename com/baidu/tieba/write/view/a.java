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
    private View btr;
    private ViewGroup bts;
    private int btu;
    private BaseFragmentActivity fsZ;
    private ListView mListView;
    private final View.OnClickListener mOnClickListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private int ncg;
    private ValueAnimator nch;
    private ValueAnimator nci;
    private b ncj;
    private InterfaceC0836a nck;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0836a {
        void a(int i, com.baidu.tbadk.album.a aVar);
    }

    public void a(InterfaceC0836a interfaceC0836a) {
        this.nck = interfaceC0836a;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext().getPageActivity());
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.album.a item = a.this.ncj.getItem(i);
                if (a.this.nck != null) {
                    a.this.nck.a(i, item);
                }
                a.this.PE();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.PE();
            }
        };
        this.fsZ = baseFragmentActivity;
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
        BdListView bdListView = new BdListView(this.fsZ.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.fsZ.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.ncj = new b(this.fsZ);
        this.ncj.b(list, str);
        bdListView.setAdapter((ListAdapter) this.ncj);
        FrameLayout frameLayout = new FrameLayout(this.fsZ.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.fsZ.getPageContext().getPageActivity());
        this.bts = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        frameLayout.setOnClickListener(this.mOnClickListener);
        ap.setBackgroundColor(this.btr, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.mListView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.bts, R.color.black_alpha70);
        return frameLayout;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        if (list != null) {
            this.btu = d(list, str);
            this.ncg = -2;
            if (list.size() > 5) {
                this.ncg = this.fsZ.getResources().getDimensionPixelSize(R.dimen.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.ncg);
            } else {
                layoutParams.height = this.ncg;
            }
            this.mListView.setLayoutParams(layoutParams);
            if (this.ncg < 0) {
                this.ncg = l.getDimens(this.fsZ, R.dimen.tbds168) * list.size();
            }
            this.ncj.b(list, str);
            this.ncj.notifyDataSetChanged();
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
        this.mListView.setSelection(this.btu);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.showPopupWindowAsDropDown(this, view)) {
                PG();
                return;
            }
            return;
        }
        int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int height = view.getHeight() + iArr[1];
        ((FrameLayout.LayoutParams) this.mListView.getLayoutParams()).topMargin = height - statusBarHeight;
        ((FrameLayout.LayoutParams) this.bts.getLayoutParams()).topMargin = height - statusBarHeight;
        if (g.showPopupWindowAtLocation(this, view, 0, 0, 0)) {
            PG();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        PE();
    }

    public void PE() {
        PH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() {
        super.dismiss();
    }

    private void PG() {
        if (this.nch == null) {
            this.nch = ValueAnimator.ofInt(0, this.ncg);
            this.nch.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.view.a.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = a.this.mListView.getLayoutParams();
                    layoutParams.height = intValue;
                    a.this.mListView.setLayoutParams(layoutParams);
                }
            });
            this.nch.setDuration(350L);
        }
        this.nch.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.bts.startAnimation(alphaAnimation);
    }

    private void PH() {
        if (this.nci == null) {
            this.nci = ValueAnimator.ofInt(this.mListView.getHeight(), 0);
            this.nci.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.view.a.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = a.this.mListView.getLayoutParams();
                    layoutParams.height = intValue;
                    a.this.mListView.setLayoutParams(layoutParams);
                }
            });
            this.nci.setDuration(350L);
        }
        this.nci.start();
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
                a.this.PF();
            }
        });
        this.bts.startAnimation(alphaAnimation);
    }

    public void clearAnimation() {
        if (this.mListView != null) {
            this.mListView.clearAnimation();
        }
        if (this.bts != null) {
            this.bts.clearAnimation();
        }
    }
}
