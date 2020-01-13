package com.baidu.tieba.write.view;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends PopupWindow {
    private View azg;
    private ViewGroup azh;
    private int azj;
    private AlbumActivity kQf;
    private b kQg;
    private InterfaceC0630a kQh;
    private ListView mListView;
    private final View.OnClickListener mOnClickListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0630a {
        void a(int i, com.baidu.tbadk.album.a aVar);
    }

    public void a(InterfaceC0630a interfaceC0630a) {
        this.kQh = interfaceC0630a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.album.a item = a.this.kQg.getItem(i);
                if (a.this.kQh != null) {
                    a.this.kQh.a(i, item);
                }
                a.this.yA();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.yA();
            }
        };
        this.kQf = albumActivity;
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
        BdListView bdListView = new BdListView(this.kQf.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.kQf.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.kQg = new b(this.kQf);
        this.kQg.b(list, str);
        bdListView.setAdapter((ListAdapter) this.kQg);
        FrameLayout frameLayout = new FrameLayout(this.kQf.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.kQf.getPageContext().getPageActivity());
        this.azh = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        this.azh.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.azg, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.mListView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.azh, R.color.black_alpha70);
        return frameLayout;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        int i;
        if (list != null) {
            this.azj = d(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.kQf.getResources().getDimensionPixelSize(R.dimen.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.mListView.setLayoutParams(layoutParams);
            this.kQg.b(list, str);
            this.kQg.notifyDataSetChanged();
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

    public void R(View view) {
        this.mListView.setSelection(this.azj);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.showPopupWindowAsDropDown(this, view)) {
                yC();
                return;
            }
            return;
        }
        if (g.showPopupWindowAtLocation(this, view, 0, 0, ((this.kQf.xT() == null || this.kQf.xT().getVisibility() != 0) ? 0 : this.kQf.xT().getHeight()) + view.getHeight())) {
            yC();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        yA();
    }

    public void yA() {
        yD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yB() {
        super.dismiss();
    }

    private void yC() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.mListView.startAnimation(translateAnimation);
        this.azh.startAnimation(alphaAnimation);
    }

    private void yD() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.view.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.yB();
            }
        });
        this.mListView.startAnimation(translateAnimation);
        this.azh.startAnimation(alphaAnimation);
    }

    public void clearAnimation() {
        if (this.mListView != null) {
            this.mListView.clearAnimation();
        }
        if (this.azh != null) {
            this.azh.clearAnimation();
        }
    }
}
