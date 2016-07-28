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
import com.baidu.adp.lib.h.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.u;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends PopupWindow {
    private ListView bFG;
    private ViewGroup fHW;
    private int fHY;
    private AlbumActivity fSq;
    private l fSr;
    private InterfaceC0083a fSs;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0083a {
        void a(int i, com.baidu.tieba.write.album.d dVar);
    }

    public void a(InterfaceC0083a interfaceC0083a) {
        this.fSs = interfaceC0083a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.fSq = albumActivity;
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
        BdListView bdListView = new BdListView(this.fSq.getPageContext().getPageActivity());
        this.bFG = bdListView;
        bdListView.setCacheColorHint(this.fSq.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.fSr = new l(this.fSq);
        this.fSr.b(list, str);
        bdListView.setAdapter((ListAdapter) this.fSr);
        bdListView.setOnItemClickListener(new b(this));
        FrameLayout frameLayout = new FrameLayout(this.fSq.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.fSq.getPageContext().getPageActivity());
        this.fHW = frameLayout2;
        frameLayout2.setBackgroundColor(this.fSq.getResources().getColor(u.d.common_color_10175));
        frameLayout2.setOnClickListener(new c(this));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void b(List<com.baidu.tieba.write.album.d> list, String str) {
        int i;
        if (list != null) {
            this.fHY = g(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.fSq.getResources().getDimensionPixelSize(u.e.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bFG.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.bFG.setLayoutParams(layoutParams);
            this.fSr.b(list, str);
            this.fSr.notifyDataSetChanged();
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
        this.bFG.setSelection(this.fHY);
        if (j.showPopupWindowAsDropDown(this, view)) {
            bli();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        arO();
    }

    public void arO() {
        aed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blh() {
        super.dismiss();
    }

    private void bli() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.bFG.startAnimation(translateAnimation);
        this.fHW.startAnimation(alphaAnimation);
    }

    private void aed() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new d(this));
        this.bFG.startAnimation(translateAnimation);
        this.fHW.startAnimation(alphaAnimation);
    }
}
