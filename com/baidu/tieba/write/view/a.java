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
    private ViewGroup cqG;
    private int cqI;
    private AlbumActivity gTL;
    private d gTM;
    private InterfaceC0144a gTN;
    private ListView mListView;

    /* renamed from: com.baidu.tieba.write.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0144a {
        void a(int i, com.baidu.tbadk.b.a aVar);
    }

    public void a(InterfaceC0144a interfaceC0144a) {
        this.gTN = interfaceC0144a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.gTL = albumActivity;
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
        BdListView bdListView = new BdListView(this.gTL.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.gTL.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.gTM = new d(this.gTL);
        this.gTM.d(list, str);
        bdListView.setAdapter((ListAdapter) this.gTM);
        bdListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.b.a item = a.this.gTM.getItem(i);
                if (item instanceof com.baidu.tbadk.b.a) {
                    com.baidu.tbadk.b.a aVar = item;
                    if (a.this.gTN != null) {
                        a.this.gTN.a(i, aVar);
                    }
                }
                a.this.ahe();
            }
        });
        FrameLayout frameLayout = new FrameLayout(this.gTL.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.gTL.getPageContext().getPageActivity());
        this.cqG = frameLayout2;
        frameLayout2.setBackgroundColor(this.gTL.getResources().getColor(d.C0080d.common_color_10175));
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ahe();
            }
        });
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void d(List<com.baidu.tbadk.b.a> list, String str) {
        int i;
        if (list != null) {
            this.cqI = e(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.gTL.getResources().getDimensionPixelSize(d.e.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.mListView.setLayoutParams(layoutParams);
            this.gTM.d(list, str);
            this.gTM.notifyDataSetChanged();
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

    public void as(View view) {
        this.mListView.setSelection(this.cqI);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.showPopupWindowAsDropDown(this, view)) {
                ahg();
            }
        } else if (g.showPopupWindowAtLocation(this, view, 0, 0, view.getHeight())) {
            ahg();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        ahe();
    }

    public void ahe() {
        ahh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahf() {
        super.dismiss();
    }

    private void ahg() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.mListView.startAnimation(translateAnimation);
        this.cqG.startAnimation(alphaAnimation);
    }

    private void ahh() {
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
                a.this.ahf();
            }
        });
        this.mListView.startAnimation(translateAnimation);
        this.cqG.startAnimation(alphaAnimation);
    }
}
