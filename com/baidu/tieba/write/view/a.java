package com.baidu.tieba.write.view;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.w;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends PopupWindow {
    private ListView cbP;
    private AlbumActivity giB;
    private ViewGroup giC;
    private m giD;
    private int giE;
    private InterfaceC0090a giF;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0090a {
        void a(int i, com.baidu.tieba.write.album.e eVar);
    }

    public void a(InterfaceC0090a interfaceC0090a) {
        this.giF = interfaceC0090a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.giB = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(g(new ArrayList(), "-1"));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View g(List<com.baidu.tieba.write.album.e> list, String str) {
        BdListView bdListView = new BdListView(this.giB.getPageContext().getPageActivity());
        this.cbP = bdListView;
        bdListView.setCacheColorHint(this.giB.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.giD = new m(this.giB);
        this.giD.c(list, str);
        bdListView.setAdapter((ListAdapter) this.giD);
        bdListView.setOnItemClickListener(new b(this));
        FrameLayout frameLayout = new FrameLayout(this.giB.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.giB.getPageContext().getPageActivity());
        this.giC = frameLayout2;
        frameLayout2.setBackgroundColor(this.giB.getResources().getColor(w.e.common_color_10175));
        frameLayout2.setOnClickListener(new c(this));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void c(List<com.baidu.tieba.write.album.e> list, String str) {
        int i;
        if (list != null) {
            this.giE = h(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.giB.getResources().getDimensionPixelSize(w.f.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cbP.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.cbP.setLayoutParams(layoutParams);
            this.giD.c(list, str);
            this.giD.notifyDataSetChanged();
        }
    }

    private int h(List<com.baidu.tieba.write.album.e> list, String str) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.write.album.e eVar = list.get(i);
            if (eVar != null && str.equals(eVar.getAlbumId())) {
                return i;
            }
        }
        return -1;
    }

    public void aE(View view) {
        this.cbP.setSelection(this.giE);
        if (Build.VERSION.SDK_INT < 24) {
            if (com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(this, view)) {
                btl();
            }
        } else if (com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this, view, 0, 0, view.getHeight())) {
            btl();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        aww();
    }

    public void aww() {
        ajr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btk() {
        super.dismiss();
    }

    private void btl() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.cbP.startAnimation(translateAnimation);
        this.giC.startAnimation(alphaAnimation);
    }

    private void ajr() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new d(this));
        this.cbP.startAnimation(translateAnimation);
        this.giC.startAnimation(alphaAnimation);
    }
}
