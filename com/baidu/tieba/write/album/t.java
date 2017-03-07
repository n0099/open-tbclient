package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Build;
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
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private static final String fLU = TbadkCoreApplication.m9getInst().getResources().getString(w.l.original_img);
    private ViewGroup cGE;
    private String fLV;
    private String fLW;
    private Button fLX;
    private View fLY;
    private HorizontalCustomScrollView fLZ;
    private AlbumActivity fLm;
    private LinearLayout fMa;
    private RelativeLayout fMb;
    private ImageView fMc;
    private TextView fMd;
    private Fragment[] fMe;
    private String[] fMf;
    private FrameLayout[] fMg;
    private View[] fMh;
    private int fMi;
    private Handler mHandler;
    private Runnable scrollRunnable;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.fLV = "tag_image";
        this.fLW = "tag_b_image";
        this.mHandler = new Handler();
        this.fLm = albumActivity;
        e(albumActivity);
    }

    private void e(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(w.j.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.cGE = (ViewGroup) albumActivity.findViewById(w.h.parent);
        this.fLX = (Button) albumActivity.findViewById(w.h.btn_done);
        this.fLX.setOnClickListener(albumActivity);
        this.fLZ = (HorizontalCustomScrollView) albumActivity.findViewById(w.h.bottom_scroll);
        this.fMa = (LinearLayout) albumActivity.findViewById(w.h.bottom_container);
        this.fMb = (RelativeLayout) albumActivity.findViewById(w.h.lay_bottom);
        this.fMc = (ImageView) albumActivity.findViewById(w.h.add_more);
        this.fLY = albumActivity.findViewById(w.h.bottom_shadow);
        this.fMd = (TextView) albumActivity.findViewById(w.h.original_select_btn);
        this.fMd.setOnClickListener(albumActivity);
        this.fMi = (int) this.fLm.getResources().getDimension(w.f.ds90);
    }

    public void sS(int i) {
        this.fMg = new FrameLayout[i];
        this.fMh = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.fMg[i2] = (FrameLayout) LayoutInflater.from(this.fLm.getPageContext().getPageActivity()).inflate(w.j.album_bottom_item_view, (ViewGroup) null);
            this.fMh[i2 * 4] = this.fMg[i2].findViewById(w.h.line_top);
            this.fMh[(i2 * 4) + 1] = this.fMg[i2].findViewById(w.h.line_left);
            this.fMh[(i2 * 4) + 2] = this.fMg[i2].findViewById(w.h.line_right);
            this.fMh[(i2 * 4) + 3] = this.fMg[i2].findViewById(w.h.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(w.h.item_iv);
    }

    public void bna() {
        this.fMe = new Fragment[2];
        this.fMf = new String[2];
        this.fMe[0] = new ag();
        this.fMf[0] = this.fLV;
        this.fMe[1] = new e();
        this.fMf[1] = this.fLW;
    }

    public Fragment sT(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fMe[i];
    }

    public String sU(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fMf[i];
    }

    public void onChangeSkinType(int i) {
        this.fLm.getLayoutMode().ah(i == 1);
        this.fLm.getLayoutMode().t(this.cGE);
        for (int i2 = 0; i2 < this.fMe.length; i2++) {
            if (this.fMe[i2] != null && (this.fMe[i2] instanceof ag)) {
                ((ag) this.fMe[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button bnb() {
        return this.fLX;
    }

    public View bnc() {
        Fragment sT = sT(0);
        if (sT == null || !(sT instanceof ag)) {
            return null;
        }
        return ((ag) sT).bcd();
    }

    public View bnd() {
        Fragment sT = sT(1);
        if (sT == null || !(sT instanceof e)) {
            return null;
        }
        return ((e) sT).bcd();
    }

    public void o(boolean z, String str) {
        this.fLX.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.fLX.setText(str);
    }

    public void g(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.fMg.length;
            for (int i = 0; i < length; i++) {
                if (this.fMg[i] != null && (a = a(this.fMg[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.fMi, this.fMi));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fMi, this.fMi);
                    layoutParams.rightMargin = (int) this.fLm.getResources().getDimension(w.f.ds10);
                    this.fMg[i].setLayoutParams(layoutParams);
                    this.fMa.addView(this.fMg[i], this.fMa.getChildCount() - 1);
                    a((HorizontalScrollView) this.fLZ);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M(this.fMi, this.fMi));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.fLm.ahu().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.e(a);
                        return;
                    } else {
                        this.fLm.ahu().a(imageFileInfo, new v(this, imageFileInfo), false);
                        return;
                    }
                }
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo) {
        FrameLayout frameLayout;
        TbImageView a;
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M(this.fMi, this.fMi));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.fMa.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.fMa.getChildAt(i) != null && (this.fMa.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.fMa.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.fMa.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void lI(boolean z) {
        if (this.fMc != null) {
            if (z) {
                this.fMc.setVisibility(0);
            } else {
                this.fMc.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.fLZ != null) {
            if (this.scrollRunnable == null) {
                this.scrollRunnable = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.scrollRunnable);
            this.mHandler.postDelayed(this.scrollRunnable, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.scrollRunnable != null) {
            this.mHandler.removeCallbacks(this.scrollRunnable);
        }
        if (this.fLm.ahu() != null) {
            this.fLm.ahu().Er();
        }
    }

    public void sV(int i) {
        if (i == 1) {
            aq.d(this.fMb, w.e.common_color_10100, 0);
            aq.j(this.fLX, w.g.post_button_bg_bigimage);
            aq.d(this.fMc, w.g.btn_add_pic_bigimage, 0);
            aq.e(this.fLY, w.e.common_color_10101, 0);
            for (View view : this.fMh) {
                aq.e(view, w.e.common_color_10101, 0);
            }
            return;
        }
        aq.j(this.fMb, w.e.common_color_10099);
        aq.j(this.fLX, w.g.post_button_bg);
        aq.j(this.fMc, w.g.btn_add_pic);
        aq.k(this.fLY, w.e.cp_cont_e);
        for (View view2 : this.fMh) {
            aq.k(view2, w.e.cp_cont_e);
        }
    }

    public void E(boolean z, boolean z2) {
        if (z) {
            this.fMd.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.fMd.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.fMd.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(fLU);
            if (j > 0) {
                sb.append("(");
                sb.append(au.E(j));
                sb.append(")");
            }
            this.fMd.setText(sb.toString());
            return;
        }
        this.fMd.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fMd.setText(fLU);
    }

    public View bne() {
        return this.fMd;
    }
}
