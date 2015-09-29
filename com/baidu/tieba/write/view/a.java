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
import com.baidu.tieba.write.album.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends PopupWindow {
    private ListView aSK;
    private AlbumActivity dms;
    private ViewGroup dmt;
    private i dmu;
    private int dmv;
    private InterfaceC0082a dmw;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0082a {
        void a(int i, com.baidu.tieba.write.album.a aVar);
    }

    public void a(InterfaceC0082a interfaceC0082a) {
        this.dmw = interfaceC0082a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.dms = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(e(new ArrayList(), "-1"));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View e(List<com.baidu.tieba.write.album.a> list, String str) {
        BdListView bdListView = new BdListView(this.dms.getPageContext().getPageActivity());
        this.aSK = bdListView;
        bdListView.setCacheColorHint(this.dms.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.dmu = new i(this.dms);
        this.dmu.c(list, str);
        bdListView.setAdapter((ListAdapter) this.dmu);
        bdListView.setOnItemClickListener(new b(this));
        FrameLayout frameLayout = new FrameLayout(this.dms.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.dms.getPageContext().getPageActivity());
        this.dmt = frameLayout2;
        frameLayout2.setBackgroundColor(this.dms.getResources().getColor(i.c.album_list_window_bg));
        frameLayout2.setOnClickListener(new c(this));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void c(List<com.baidu.tieba.write.album.a> list, String str) {
        int i;
        if (list != null) {
            this.dmv = f(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.dms.getResources().getDimensionPixelSize(i.d.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aSK.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.aSK.setLayoutParams(layoutParams);
            this.dmu.c(list, str);
            this.dmu.notifyDataSetChanged();
        }
    }

    private int f(List<com.baidu.tieba.write.album.a> list, String str) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.write.album.a aVar = list.get(i);
            if (aVar != null && str.equals(aVar.getAlbumId())) {
                return i;
            }
        }
        return -1;
    }

    public void P(View view) {
        this.aSK.setSelection(this.dmv);
        showAsDropDown(view);
        aCi();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Xy();
    }

    public void Xy() {
        Qn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCh() {
        super.dismiss();
    }

    private void aCi() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.aSK.startAnimation(translateAnimation);
        this.dmt.startAnimation(alphaAnimation);
    }

    private void Qn() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new d(this));
        this.aSK.startAnimation(translateAnimation);
        this.dmt.startAnimation(alphaAnimation);
    }
}
