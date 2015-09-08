package com.baidu.tieba.write.album;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private Runnable akM;
    private ViewGroup bKc;
    private AlbumActivity cYB;
    private String cZh;
    private String cZi;
    private Button cZj;
    private View cZk;
    private HorizontalCustomScrollView cZl;
    private LinearLayout cZm;
    private RelativeLayout cZn;
    private ImageView cZo;
    private Fragment[] cZp;
    private String[] cZq;
    private FrameLayout[] cZr;
    private View[] cZs;
    private int cZt;
    private Handler mHandler;

    public r(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.cZh = "tag_image";
        this.cZi = "tag_b_image";
        this.mHandler = new Handler();
        this.cYB = albumActivity;
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(i.g.album_activity);
        this.bKc = (ViewGroup) albumActivity.findViewById(i.f.parent);
        this.cZj = (Button) albumActivity.findViewById(i.f.btn_done);
        this.cZj.setOnClickListener(albumActivity);
        this.cZl = (HorizontalCustomScrollView) albumActivity.findViewById(i.f.bottom_scroll);
        this.cZm = (LinearLayout) albumActivity.findViewById(i.f.bottom_container);
        this.cZn = (RelativeLayout) albumActivity.findViewById(i.f.lay_bottom);
        this.cZo = (ImageView) albumActivity.findViewById(i.f.add_more);
        this.cZk = albumActivity.findViewById(i.f.bottom_shadow);
        this.cZt = (int) this.cYB.getResources().getDimension(i.d.ds90);
    }

    public void kV(int i) {
        this.cZr = new FrameLayout[i];
        this.cZs = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.cZr[i2] = (FrameLayout) LayoutInflater.from(this.cYB.getPageContext().getPageActivity()).inflate(i.g.album_bottom_item_view, (ViewGroup) null);
            this.cZs[i2 * 4] = this.cZr[i2].findViewById(i.f.line_top);
            this.cZs[(i2 * 4) + 1] = this.cZr[i2].findViewById(i.f.line_left);
            this.cZs[(i2 * 4) + 2] = this.cZr[i2].findViewById(i.f.line_right);
            this.cZs[(i2 * 4) + 3] = this.cZr[i2].findViewById(i.f.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(i.f.item_iv);
    }

    public void ayl() {
        this.cZp = new Fragment[2];
        this.cZq = new String[2];
        this.cZp[0] = new ad();
        this.cZq[0] = this.cZh;
        this.cZp[1] = new c();
        this.cZq[1] = this.cZi;
    }

    public Fragment kW(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cZp[i];
    }

    public String kX(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cZq[i];
    }

    public void onChangeSkinType(int i) {
        this.cYB.getLayoutMode().ad(i == 1);
        this.cYB.getLayoutMode().k(this.bKc);
    }

    public Button aym() {
        return this.cZj;
    }

    public View ayn() {
        Fragment kW = kW(0);
        if (kW == null || !(kW instanceof ad)) {
            return null;
        }
        return ((ad) kW).aic();
    }

    public View ayo() {
        Fragment kW = kW(1);
        if (kW == null || !(kW instanceof c)) {
            return null;
        }
        return ((c) kW).aic();
    }

    public void n(boolean z, String str) {
        this.cZj.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.cZj.setText(str);
    }

    public void f(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.cZr.length;
            for (int i = 0; i < length; i++) {
                if (this.cZr[i] != null && (a = a(this.cZr[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.cZt, this.cZt));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cZt, this.cZt);
                    layoutParams.rightMargin = (int) this.cYB.getResources().getDimension(i.d.ds10);
                    this.cZr[i].setLayoutParams(layoutParams);
                    this.cZm.addView(this.cZr[i], this.cZm.getChildCount() - 1);
                    a((HorizontalScrollView) this.cZl);
                    a.setOnClickListener(new s(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.cZt, this.cZt));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.cYB.axU().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.cYB.axU().a(imageFileInfo, new t(this, imageFileInfo), false);
                        return;
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo) {
        FrameLayout frameLayout;
        TbImageView a;
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.cZt, this.cZt));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.cZm.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.cZm.getChildAt(i) != null && (this.cZm.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.cZm.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.cZm.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void gE(boolean z) {
        if (this.cZo != null) {
            if (z) {
                this.cZo.setVisibility(0);
            } else {
                this.cZo.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.cZl != null) {
            if (this.akM == null) {
                this.akM = new u(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.akM);
            this.mHandler.postDelayed(this.akM, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.akM != null) {
            this.mHandler.removeCallbacks(this.akM);
        }
        if (this.cYB.axU() != null) {
            this.cYB.axU().Cz();
        }
    }

    public void kY(int i) {
        if (i == 1) {
            com.baidu.tbadk.core.util.al.c(this.cZn, i.c.album_list_bottom_bigimage_bg, 0);
            com.baidu.tbadk.core.util.al.h((View) this.cZj, i.e.post_button_bg_bigimage);
            com.baidu.tbadk.core.util.al.c(this.cZo, i.e.btn_add_pic_bigimage, 0);
            com.baidu.tbadk.core.util.al.d(this.cZk, i.c.album_list_bottom_bigimage_line, 0);
            for (View view : this.cZs) {
                com.baidu.tbadk.core.util.al.d(view, i.c.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        com.baidu.tbadk.core.util.al.h(this.cZn, i.c.album_list_bottom_bg);
        com.baidu.tbadk.core.util.al.h((View) this.cZj, i.e.post_button_bg);
        com.baidu.tbadk.core.util.al.h(this.cZo, i.e.btn_add_pic);
        com.baidu.tbadk.core.util.al.i(this.cZk, i.c.album_list_bottom_line);
        for (View view2 : this.cZs) {
            com.baidu.tbadk.core.util.al.i(view2, i.c.album_list_bottom_line);
        }
    }
}
