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
import com.baidu.tieba.n;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends PopupWindow {
    private ListView aYr;
    private AlbumActivity dNG;
    private ViewGroup dNH;
    private l dNI;
    private int dNJ;
    private InterfaceC0091a dNK;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0091a {
        void a(int i, com.baidu.tieba.write.album.d dVar);
    }

    public void a(InterfaceC0091a interfaceC0091a) {
        this.dNK = interfaceC0091a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.dNG = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(f(new ArrayList(), "-1"));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View f(List<com.baidu.tieba.write.album.d> list, String str) {
        BdListView bdListView = new BdListView(this.dNG.getPageContext().getPageActivity());
        this.aYr = bdListView;
        bdListView.setCacheColorHint(this.dNG.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.dNI = new l(this.dNG);
        this.dNI.d(list, str);
        bdListView.setAdapter((ListAdapter) this.dNI);
        bdListView.setOnItemClickListener(new b(this));
        FrameLayout frameLayout = new FrameLayout(this.dNG.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.dNG.getPageContext().getPageActivity());
        this.dNH = frameLayout2;
        frameLayout2.setBackgroundColor(this.dNG.getResources().getColor(n.c.album_list_window_bg));
        frameLayout2.setOnClickListener(new c(this));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void d(List<com.baidu.tieba.write.album.d> list, String str) {
        int i;
        if (list != null) {
            this.dNJ = g(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.dNG.getResources().getDimensionPixelSize(n.d.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aYr.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.aYr.setLayoutParams(layoutParams);
            this.dNI.d(list, str);
            this.dNI.notifyDataSetChanged();
        }
    }

    private int g(List<com.baidu.tieba.write.album.d> list, String str) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.write.album.d dVar = list.get(i);
            if (dVar != null && str.equals(dVar.getAlbumId())) {
                return i;
            }
        }
        return -1;
    }

    public void V(View view) {
        this.aYr.setSelection(this.dNJ);
        showAsDropDown(view);
        aIB();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        aaV();
    }

    public void aaV() {
        SV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIA() {
        super.dismiss();
    }

    private void aIB() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.aYr.startAnimation(translateAnimation);
        this.dNH.startAnimation(alphaAnimation);
    }

    private void SV() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new d(this));
        this.aYr.startAnimation(translateAnimation);
        this.dNH.startAnimation(alphaAnimation);
    }
}
