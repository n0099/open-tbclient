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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends PopupWindow {
    private ViewGroup cZa;
    private int cZc;
    private AlbumActivity hrZ;
    private b hsa;
    private InterfaceC0257a hsb;
    private View mFooterView;
    private ListView mListView;
    private final View.OnClickListener mOnClickListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0257a {
        void a(int i, com.baidu.tbadk.album.a aVar);
    }

    public void a(InterfaceC0257a interfaceC0257a) {
        this.hsb = interfaceC0257a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.album.a item = a.this.hsa.getItem(i);
                if (a.this.hsb != null) {
                    a.this.hsb.a(i, item);
                }
                a.this.arf();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.arf();
            }
        };
        this.hrZ = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(e(new ArrayList(), com.baidu.tbadk.album.a.aap));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @SuppressLint({"ResourceAsColor"})
    private View e(List<com.baidu.tbadk.album.a> list, String str) {
        BdListView bdListView = new BdListView(this.hrZ.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.hrZ.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.hsa = new b(this.hrZ);
        this.hsa.f(list, str);
        bdListView.setAdapter((ListAdapter) this.hsa);
        FrameLayout frameLayout = new FrameLayout(this.hrZ.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.hrZ.getPageContext().getPageActivity());
        this.cZa = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        this.cZa.setOnClickListener(this.mOnClickListener);
        al.j(this.mFooterView, d.C0141d.cp_bg_line_d);
        al.j(this.mListView, d.C0141d.cp_bg_line_d);
        al.j(this.cZa, d.C0141d.black_alpha70);
        return frameLayout;
    }

    public void f(List<com.baidu.tbadk.album.a> list, String str) {
        int i;
        if (list != null) {
            this.cZc = g(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.hrZ.getResources().getDimensionPixelSize(d.e.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.mListView.setLayoutParams(layoutParams);
            this.hsa.f(list, str);
            this.hsa.notifyDataSetChanged();
        }
    }

    private int g(List<com.baidu.tbadk.album.a> list, String str) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.album.a aVar = list.get(i);
            if (aVar != null && str.equals(aVar.getAlbumId())) {
                return i;
            }
        }
        return -1;
    }

    public void ap(View view) {
        this.mListView.setSelection(this.cZc);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.showPopupWindowAsDropDown(this, view)) {
                arh();
                return;
            }
            return;
        }
        if (g.showPopupWindowAtLocation(this, view, 0, 0, ((this.hrZ.atU() == null || this.hrZ.atU().getVisibility() != 0) ? 0 : this.hrZ.atU().getHeight()) + view.getHeight())) {
            arh();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        arf();
    }

    public void arf() {
        ari();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arg() {
        super.dismiss();
    }

    private void arh() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.mListView.startAnimation(translateAnimation);
        this.cZa.startAnimation(alphaAnimation);
    }

    private void ari() {
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
                a.this.arg();
            }
        });
        this.mListView.startAnimation(translateAnimation);
        this.cZa.startAnimation(alphaAnimation);
    }

    public void clearAnimation() {
        if (this.mListView != null) {
            this.mListView.clearAnimation();
        }
        if (this.cZa != null) {
            this.cZa.clearAnimation();
        }
    }
}
