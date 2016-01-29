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
import com.baidu.tieba.t;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends PopupWindow {
    private ListView beF;
    private ViewGroup ejn;
    private int ejp;
    private AlbumActivity eqa;
    private l eqb;
    private InterfaceC0092a eqc;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0092a {
        void a(int i, com.baidu.tieba.write.album.d dVar);
    }

    public void a(InterfaceC0092a interfaceC0092a) {
        this.eqc = interfaceC0092a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.eqa = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(e(new ArrayList(), "-1"));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View e(List<com.baidu.tieba.write.album.d> list, String str) {
        BdListView bdListView = new BdListView(this.eqa.getPageContext().getPageActivity());
        this.beF = bdListView;
        bdListView.setCacheColorHint(this.eqa.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.eqb = new l(this.eqa);
        this.eqb.d(list, str);
        bdListView.setAdapter((ListAdapter) this.eqb);
        bdListView.setOnItemClickListener(new b(this));
        FrameLayout frameLayout = new FrameLayout(this.eqa.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.eqa.getPageContext().getPageActivity());
        this.ejn = frameLayout2;
        frameLayout2.setBackgroundColor(this.eqa.getResources().getColor(t.d.album_list_window_bg));
        frameLayout2.setOnClickListener(new c(this));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void d(List<com.baidu.tieba.write.album.d> list, String str) {
        int i;
        if (list != null) {
            this.ejp = f(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.eqa.getResources().getDimensionPixelSize(t.e.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.beF.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.beF.setLayoutParams(layoutParams);
            this.eqb.d(list, str);
            this.eqb.notifyDataSetChanged();
        }
    }

    private int f(List<com.baidu.tieba.write.album.d> list, String str) {
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

    public void ao(View view) {
        this.beF.setSelection(this.ejp);
        showAsDropDown(view);
        aQK();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        afm();
    }

    public void afm() {
        Vw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQJ() {
        super.dismiss();
    }

    private void aQK() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.beF.startAnimation(translateAnimation);
        this.ejn.startAnimation(alphaAnimation);
    }

    private void Vw() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new d(this));
        this.beF.startAnimation(translateAnimation);
        this.ejn.startAnimation(alphaAnimation);
    }
}
