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
import com.baidu.tieba.o;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends PopupWindow {
    private AlbumActivity cAN;
    private ViewGroup cAO;
    private l cAP;
    private int cAQ;
    private e cAR;
    private ListView mListView;

    public void a(e eVar) {
        this.cAR = eVar;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.cAN = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(d(new ArrayList(), "-1"));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View d(List<com.baidu.tieba.write.album.a> list, String str) {
        BdListView bdListView = new BdListView(this.cAN.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.cAN.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.cAP = new l(this.cAN);
        this.cAP.b(list, str);
        bdListView.setAdapter((ListAdapter) this.cAP);
        bdListView.setOnItemClickListener(new b(this));
        FrameLayout frameLayout = new FrameLayout(this.cAN.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.cAN.getPageContext().getPageActivity());
        this.cAO = frameLayout2;
        frameLayout2.setBackgroundColor(this.cAN.getResources().getColor(n.album_list_window_bg));
        frameLayout2.setOnClickListener(new c(this));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void b(List<com.baidu.tieba.write.album.a> list, String str) {
        int i;
        if (list != null) {
            this.cAQ = e(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.cAN.getResources().getDimensionPixelSize(o.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.mListView.setLayoutParams(layoutParams);
            this.cAP.b(list, str);
            this.cAP.notifyDataSetChanged();
        }
    }

    private int e(List<com.baidu.tieba.write.album.a> list, String str) {
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

    public void I(View view) {
        this.mListView.setSelection(this.cAQ);
        showAsDropDown(view);
        asP();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Vg();
    }

    public void Vg() {
        Ow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ce() {
        super.dismiss();
    }

    private void asP() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.mListView.startAnimation(translateAnimation);
        this.cAO.startAnimation(alphaAnimation);
    }

    private void Ow() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new d(this));
        this.mListView.startAnimation(translateAnimation);
        this.cAO.startAnimation(alphaAnimation);
    }
}
