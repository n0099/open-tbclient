package com.baidu.tieba.write.view;

import android.graphics.drawable.ColorDrawable;
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
    private ListView bNV;
    private AlbumActivity fPF;
    private ViewGroup fPG;
    private m fPH;
    private int fPI;
    private InterfaceC0085a fPJ;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0085a {
        void a(int i, com.baidu.tieba.write.album.e eVar);
    }

    public void a(InterfaceC0085a interfaceC0085a) {
        this.fPJ = interfaceC0085a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.fPF = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(f(new ArrayList(), "-1"));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View f(List<com.baidu.tieba.write.album.e> list, String str) {
        BdListView bdListView = new BdListView(this.fPF.getPageContext().getPageActivity());
        this.bNV = bdListView;
        bdListView.setCacheColorHint(this.fPF.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.fPH = new m(this.fPF);
        this.fPH.b(list, str);
        bdListView.setAdapter((ListAdapter) this.fPH);
        bdListView.setOnItemClickListener(new b(this));
        FrameLayout frameLayout = new FrameLayout(this.fPF.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.fPF.getPageContext().getPageActivity());
        this.fPG = frameLayout2;
        frameLayout2.setBackgroundColor(this.fPF.getResources().getColor(w.e.common_color_10175));
        frameLayout2.setOnClickListener(new c(this));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void b(List<com.baidu.tieba.write.album.e> list, String str) {
        int i;
        if (list != null) {
            this.fPI = g(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.fPF.getResources().getDimensionPixelSize(w.f.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bNV.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.bNV.setLayoutParams(layoutParams);
            this.fPH.b(list, str);
            this.fPH.notifyDataSetChanged();
        }
    }

    private int g(List<com.baidu.tieba.write.album.e> list, String str) {
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

    public void aC(View view) {
        this.bNV.setSelection(this.fPI);
        if (com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(this, view)) {
            bno();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        arN();
    }

    public void arN() {
        aev();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnn() {
        super.dismiss();
    }

    private void bno() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.bNV.startAnimation(translateAnimation);
        this.fPG.startAnimation(alphaAnimation);
    }

    private void aev() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new d(this));
        this.bNV.startAnimation(translateAnimation);
        this.fPG.startAnimation(alphaAnimation);
    }
}
