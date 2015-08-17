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
import com.baidu.tieba.i;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends PopupWindow {
    private ListView aTA;
    private AlbumActivity cSD;
    private ViewGroup cSE;
    private j cSF;
    private int cSG;
    private InterfaceC0076a cSH;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0076a {
        void a(int i, com.baidu.tieba.write.album.b bVar);
    }

    public void a(InterfaceC0076a interfaceC0076a) {
        this.cSH = interfaceC0076a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.cSD = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(e(new ArrayList(), "-1"));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View e(List<com.baidu.tieba.write.album.b> list, String str) {
        BdListView bdListView = new BdListView(this.cSD.getPageContext().getPageActivity());
        this.aTA = bdListView;
        bdListView.setCacheColorHint(this.cSD.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.cSF = new j(this.cSD);
        this.cSF.c(list, str);
        bdListView.setAdapter((ListAdapter) this.cSF);
        bdListView.setOnItemClickListener(new b(this));
        FrameLayout frameLayout = new FrameLayout(this.cSD.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.cSD.getPageContext().getPageActivity());
        this.cSE = frameLayout2;
        frameLayout2.setBackgroundColor(this.cSD.getResources().getColor(i.c.album_list_window_bg));
        frameLayout2.setOnClickListener(new c(this));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void c(List<com.baidu.tieba.write.album.b> list, String str) {
        int i;
        if (list != null) {
            this.cSG = f(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.cSD.getResources().getDimensionPixelSize(i.d.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aTA.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.aTA.setLayoutParams(layoutParams);
            this.cSF.c(list, str);
            this.cSF.notifyDataSetChanged();
        }
    }

    private int f(List<com.baidu.tieba.write.album.b> list, String str) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.write.album.b bVar = list.get(i);
            if (bVar != null && str.equals(bVar.getAlbumId())) {
                return i;
            }
        }
        return -1;
    }

    public void N(View view) {
        this.aTA.setSelection(this.cSG);
        showAsDropDown(view);
        auG();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        WN();
    }

    public void WN() {
        Qg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auF() {
        super.dismiss();
    }

    private void auG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.aTA.startAnimation(translateAnimation);
        this.cSE.startAnimation(alphaAnimation);
    }

    private void Qg() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new d(this));
        this.aTA.startAnimation(translateAnimation);
        this.cSE.startAnimation(alphaAnimation);
    }
}
