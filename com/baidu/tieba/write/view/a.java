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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends PopupWindow {
    private View cgT;
    private ViewGroup czK;
    private int czM;
    private AlbumActivity hfQ;
    private d hfR;
    private InterfaceC0145a hfS;
    private ListView mListView;
    private final View.OnClickListener mOnClickListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0145a {
        void a(int i, com.baidu.tbadk.album.a aVar);
    }

    public void a(InterfaceC0145a interfaceC0145a) {
        this.hfS = interfaceC0145a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.album.a item = a.this.hfR.getItem(i);
                if (a.this.hfS != null) {
                    a.this.hfS.a(i, item);
                }
                a.this.ajf();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ajf();
            }
        };
        this.hfQ = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(c(new ArrayList(), com.baidu.tbadk.album.a.Ri));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @SuppressLint({"ResourceAsColor"})
    private View c(List<com.baidu.tbadk.album.a> list, String str) {
        BdListView bdListView = new BdListView(this.hfQ.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.hfQ.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.hfR = new d(this.hfQ);
        this.hfR.d(list, str);
        bdListView.setAdapter((ListAdapter) this.hfR);
        FrameLayout frameLayout = new FrameLayout(this.hfQ.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.hfQ.getPageContext().getPageActivity());
        this.czK = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        this.czK.setOnClickListener(this.mOnClickListener);
        aj.k(this.cgT, d.C0082d.cp_bg_line_d);
        aj.k(this.mListView, d.C0082d.cp_bg_line_d);
        aj.k(this.czK, d.C0082d.black_alpha70);
        return frameLayout;
    }

    public void d(List<com.baidu.tbadk.album.a> list, String str) {
        int i;
        if (list != null) {
            this.czM = e(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.hfQ.getResources().getDimensionPixelSize(d.e.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.mListView.setLayoutParams(layoutParams);
            this.hfR.d(list, str);
            this.hfR.notifyDataSetChanged();
        }
    }

    private int e(List<com.baidu.tbadk.album.a> list, String str) {
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

    public void au(View view) {
        this.mListView.setSelection(this.czM);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.showPopupWindowAsDropDown(this, view)) {
                ajh();
                return;
            }
            return;
        }
        if (g.showPopupWindowAtLocation(this, view, 0, 0, ((this.hfQ.alB() == null || this.hfQ.alB().getVisibility() != 0) ? 0 : this.hfQ.alB().getHeight()) + view.getHeight())) {
            ajh();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        ajf();
    }

    public void ajf() {
        aji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajg() {
        super.dismiss();
    }

    private void ajh() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.mListView.startAnimation(translateAnimation);
        this.czK.startAnimation(alphaAnimation);
    }

    private void aji() {
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
                a.this.ajg();
            }
        });
        this.mListView.startAnimation(translateAnimation);
        this.czK.startAnimation(alphaAnimation);
    }

    public void clearAnimation() {
        if (this.mListView != null) {
            this.mListView.clearAnimation();
        }
        if (this.czK != null) {
            this.czK.clearAnimation();
        }
    }
}
