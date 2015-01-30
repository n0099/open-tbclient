package com.baidu.tieba.view;

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
import com.baidu.tieba.album.AlbumActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends PopupWindow {
    private AlbumActivity ceA;
    private ViewGroup ceB;
    private com.baidu.tieba.album.j ceC;
    private int ceD;
    private e ceE;
    private ListView mListView;

    public void a(e eVar) {
        this.ceE = eVar;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.ceA = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(e(new ArrayList(), "-1"));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View e(List<com.baidu.tieba.album.a> list, String str) {
        BdListView bdListView = new BdListView(this.ceA.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.ceA.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.ceC = new com.baidu.tieba.album.j(this.ceA);
        this.ceC.a(list, str);
        bdListView.setAdapter((ListAdapter) this.ceC);
        bdListView.setOnItemClickListener(new b(this));
        FrameLayout frameLayout = new FrameLayout(this.ceA.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.ceA.getPageContext().getPageActivity());
        this.ceB = frameLayout2;
        frameLayout2.setBackgroundColor(this.ceA.getResources().getColor(t.album_list_window_bg));
        frameLayout2.setOnClickListener(new c(this));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void a(List<com.baidu.tieba.album.a> list, String str) {
        int i;
        if (list != null) {
            this.ceD = f(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.ceA.getResources().getDimensionPixelSize(u.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.mListView.setLayoutParams(layoutParams);
            this.ceC.a(list, str);
            this.ceC.notifyDataSetChanged();
        }
    }

    private int f(List<com.baidu.tieba.album.a> list, String str) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.album.a aVar = list.get(i);
            if (aVar != null && str.equals(aVar.getAlbumId())) {
                return i;
            }
        }
        return -1;
    }

    public void J(View view) {
        this.mListView.setSelection(this.ceD);
        showAsDropDown(view);
        aka();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        TK();
    }

    public void TK() {
        akb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yd() {
        super.dismiss();
    }

    private void aka() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.mListView.startAnimation(translateAnimation);
        this.ceB.startAnimation(alphaAnimation);
    }

    private void akb() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new d(this));
        this.mListView.startAnimation(translateAnimation);
        this.ceB.startAnimation(alphaAnimation);
    }
}
