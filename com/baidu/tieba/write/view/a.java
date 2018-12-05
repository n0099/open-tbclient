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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends PopupWindow {
    private View dbn;
    private ViewGroup dvv;
    private int dvx;
    private AlbumActivity hVV;
    private b hVW;
    private InterfaceC0342a hVX;
    private ListView mListView;
    private final View.OnClickListener mOnClickListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0342a {
        void a(int i, com.baidu.tbadk.album.a aVar);
    }

    public void a(InterfaceC0342a interfaceC0342a) {
        this.hVX = interfaceC0342a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.album.a item = a.this.hVW.getItem(i);
                if (a.this.hVX != null) {
                    a.this.hVX.a(i, item);
                }
                a.this.axu();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.axu();
            }
        };
        this.hVV = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(f(new ArrayList(), com.baidu.tbadk.album.a.alN));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @SuppressLint({"ResourceAsColor"})
    private View f(List<com.baidu.tbadk.album.a> list, String str) {
        BdListView bdListView = new BdListView(this.hVV.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.hVV.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.hVW = new b(this.hVV);
        this.hVW.setData(list, str);
        bdListView.setAdapter((ListAdapter) this.hVW);
        FrameLayout frameLayout = new FrameLayout(this.hVV.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.hVV.getPageContext().getPageActivity());
        this.dvv = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        this.dvv.setOnClickListener(this.mOnClickListener);
        al.j(this.dbn, e.d.cp_bg_line_d);
        al.j(this.mListView, e.d.cp_bg_line_d);
        al.j(this.dvv, e.d.black_alpha70);
        return frameLayout;
    }

    public void setData(List<com.baidu.tbadk.album.a> list, String str) {
        int i;
        if (list != null) {
            this.dvx = g(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.hVV.getResources().getDimensionPixelSize(e.C0210e.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.mListView.setLayoutParams(layoutParams);
            this.hVW.setData(list, str);
            this.hVW.notifyDataSetChanged();
        }
    }

    private int g(List<com.baidu.tbadk.album.a> list, String str) {
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

    public void aK(View view) {
        this.mListView.setSelection(this.dvx);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.showPopupWindowAsDropDown(this, view)) {
                axw();
                return;
            }
            return;
        }
        if (g.showPopupWindowAtLocation(this, view, 0, 0, ((this.hVV.aBn() == null || this.hVV.aBn().getVisibility() != 0) ? 0 : this.hVV.aBn().getHeight()) + view.getHeight())) {
            axw();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        axu();
    }

    public void axu() {
        axx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axv() {
        super.dismiss();
    }

    private void axw() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.mListView.startAnimation(translateAnimation);
        this.dvv.startAnimation(alphaAnimation);
    }

    private void axx() {
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
                a.this.axv();
            }
        });
        this.mListView.startAnimation(translateAnimation);
        this.dvv.startAnimation(alphaAnimation);
    }

    public void clearAnimation() {
        if (this.mListView != null) {
            this.mListView.clearAnimation();
        }
        if (this.dvv != null) {
            this.dvv.clearAnimation();
        }
    }
}
