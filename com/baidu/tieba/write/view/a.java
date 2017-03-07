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
import com.baidu.adp.lib.g.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.w;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends PopupWindow {
    private ListView bOj;
    private AlbumActivity fNA;
    private ViewGroup fNB;
    private l fNC;
    private int fND;
    private InterfaceC0079a fNE;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0079a {
        void a(int i, com.baidu.tieba.write.album.d dVar);
    }

    public void a(InterfaceC0079a interfaceC0079a) {
        this.fNE = interfaceC0079a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.fNA = albumActivity;
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
        BdListView bdListView = new BdListView(this.fNA.getPageContext().getPageActivity());
        this.bOj = bdListView;
        bdListView.setCacheColorHint(this.fNA.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.fNC = new l(this.fNA);
        this.fNC.b(list, str);
        bdListView.setAdapter((ListAdapter) this.fNC);
        bdListView.setOnItemClickListener(new b(this));
        FrameLayout frameLayout = new FrameLayout(this.fNA.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.fNA.getPageContext().getPageActivity());
        this.fNB = frameLayout2;
        frameLayout2.setBackgroundColor(this.fNA.getResources().getColor(w.e.common_color_10175));
        frameLayout2.setOnClickListener(new c(this));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void b(List<com.baidu.tieba.write.album.d> list, String str) {
        int i;
        if (list != null) {
            this.fND = g(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.fNA.getResources().getDimensionPixelSize(w.f.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bOj.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.bOj.setLayoutParams(layoutParams);
            this.fNC.b(list, str);
            this.fNC.notifyDataSetChanged();
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

    public void aJ(View view) {
        this.bOj.setSelection(this.fND);
        if (j.showPopupWindowAsDropDown(this, view)) {
            bnC();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        atY();
    }

    public void atY() {
        afR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnB() {
        super.dismiss();
    }

    private void bnC() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.bOj.startAnimation(translateAnimation);
        this.fNB.startAnimation(alphaAnimation);
    }

    private void afR() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new d(this));
        this.bOj.startAnimation(translateAnimation);
        this.fNB.startAnimation(alphaAnimation);
    }
}
