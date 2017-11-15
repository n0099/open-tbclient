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
    private ViewGroup cqZ;
    private int crb;
    private AlbumActivity gUV;
    private d gUW;
    private InterfaceC0147a gUX;
    private ListView mListView;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0147a {
        void a(int i, com.baidu.tbadk.b.a aVar);
    }

    public void a(InterfaceC0147a interfaceC0147a) {
        this.gUX = interfaceC0147a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.gUV = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(c(new ArrayList(), "-1"));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @SuppressLint({"ResourceAsColor"})
    private View c(List<com.baidu.tbadk.b.a> list, String str) {
        BdListView bdListView = new BdListView(this.gUV.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.gUV.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.gUW = new d(this.gUV);
        this.gUW.d(list, str);
        bdListView.setAdapter((ListAdapter) this.gUW);
        bdListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.b.a item = a.this.gUW.getItem(i);
                if (item instanceof com.baidu.tbadk.b.a) {
                    com.baidu.tbadk.b.a aVar = item;
                    if (a.this.gUX != null) {
                        a.this.gUX.a(i, aVar);
                    }
                }
                a.this.ahs();
            }
        });
        FrameLayout frameLayout = new FrameLayout(this.gUV.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.gUV.getPageContext().getPageActivity());
        this.cqZ = frameLayout2;
        frameLayout2.setBackgroundColor(this.gUV.getResources().getColor(d.C0080d.common_color_10175));
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ahs();
            }
        });
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void d(List<com.baidu.tbadk.b.a> list, String str) {
        int i;
        if (list != null) {
            this.crb = e(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.gUV.getResources().getDimensionPixelSize(d.e.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.mListView.setLayoutParams(layoutParams);
            this.gUW.d(list, str);
            this.gUW.notifyDataSetChanged();
        }
    }

    private int e(List<com.baidu.tbadk.b.a> list, String str) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.b.a aVar = list.get(i);
            if (aVar != null && str.equals(aVar.getAlbumId())) {
                return i;
            }
        }
        return -1;
    }

    public void at(View view) {
        this.mListView.setSelection(this.crb);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.showPopupWindowAsDropDown(this, view)) {
                ahu();
            }
        } else if (g.showPopupWindowAtLocation(this, view, 0, 0, view.getHeight())) {
            ahu();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        ahs();
    }

    public void ahs() {
        ahv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aht() {
        super.dismiss();
    }

    private void ahu() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.mListView.startAnimation(translateAnimation);
        this.cqZ.startAnimation(alphaAnimation);
    }

    private void ahv() {
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
                a.this.aht();
            }
        });
        this.mListView.startAnimation(translateAnimation);
        this.cqZ.startAnimation(alphaAnimation);
    }

    public void clearAnimation() {
        if (this.mListView != null) {
            this.mListView.clearAnimation();
        }
        if (this.cqZ != null) {
            this.cqZ.clearAnimation();
        }
    }
}
