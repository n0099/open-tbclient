package com.baidu.tieba.write.view;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends PopupWindow {
    private AlbumActivity gEZ;
    private ViewGroup gFa;
    private d gFb;
    private int gFc;
    private InterfaceC0130a gFd;
    private ListView mListView;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0130a {
        void a(int i, com.baidu.tbadk.c.a aVar);
    }

    public void a(InterfaceC0130a interfaceC0130a) {
        this.gFd = interfaceC0130a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.gEZ = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(h(new ArrayList(), "-1"));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @SuppressLint({"ResourceAsColor"})
    private View h(List<com.baidu.tbadk.c.a> list, String str) {
        BdListView bdListView = new BdListView(this.gEZ.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.gEZ.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.gFb = new d(this.gEZ);
        this.gFb.c(list, str);
        bdListView.setAdapter((ListAdapter) this.gFb);
        bdListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.c.a item = a.this.gFb.getItem(i);
                if (item instanceof com.baidu.tbadk.c.a) {
                    com.baidu.tbadk.c.a aVar = item;
                    if (a.this.gFd != null) {
                        a.this.gFd.a(i, aVar);
                    }
                }
                a.this.aAM();
            }
        });
        FrameLayout frameLayout = new FrameLayout(this.gEZ.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.gEZ.getPageContext().getPageActivity());
        this.gFa = frameLayout2;
        frameLayout2.setBackgroundColor(this.gEZ.getResources().getColor(d.e.common_color_10175));
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.aAM();
            }
        });
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void c(List<com.baidu.tbadk.c.a> list, String str) {
        int i;
        if (list != null) {
            this.gFc = i(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.gEZ.getResources().getDimensionPixelSize(d.f.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.mListView.setLayoutParams(layoutParams);
            this.gFb.c(list, str);
            this.gFb.notifyDataSetChanged();
        }
    }

    private int i(List<com.baidu.tbadk.c.a> list, String str) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.c.a aVar = list.get(i);
            if (aVar != null && str.equals(aVar.getAlbumId())) {
                return i;
            }
        }
        return -1;
    }

    public void aS(View view) {
        this.mListView.setSelection(this.gFc);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.showPopupWindowAsDropDown(this, view)) {
                byZ();
            }
        } else if (g.showPopupWindowAtLocation(this, view, 0, 0, view.getHeight())) {
            byZ();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        aAM();
    }

    public void aAM() {
        anx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byY() {
        super.dismiss();
    }

    private void byZ() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.mListView.startAnimation(translateAnimation);
        this.gFa.startAnimation(alphaAnimation);
    }

    private void anx() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.view.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.byY();
            }
        });
        this.mListView.startAnimation(translateAnimation);
        this.gFa.startAnimation(alphaAnimation);
    }
}
