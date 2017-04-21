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
    private static final String fPZ = TbadkCoreApplication.m9getInst().getResources().getString(w.l.original_img);
    private ViewGroup cHu;
    private AlbumActivity fPr;
    private String fQa;
    private String fQb;
    private Button fQc;
    private View fQd;
    private HorizontalCustomScrollView fQe;
    private LinearLayout fQf;
    private RelativeLayout fQg;
    private ImageView fQh;
    private TextView fQi;
    private Fragment[] fQj;
    private String[] fQk;
    private FrameLayout[] fQl;
    private View[] fQm;
    private int fQn;
    private Handler mHandler;
    private Runnable scrollRunnable;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.fQa = "tag_image";
        this.fQb = "tag_b_image";
        this.mHandler = new Handler();
        this.fPr = albumActivity;
        e(albumActivity);
    }

    private void e(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(w.j.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.cHu = (ViewGroup) albumActivity.findViewById(w.h.parent);
        this.fQc = (Button) albumActivity.findViewById(w.h.btn_done);
        this.fQc.setOnClickListener(albumActivity);
        this.fQe = (HorizontalCustomScrollView) albumActivity.findViewById(w.h.bottom_scroll);
        this.fQf = (LinearLayout) albumActivity.findViewById(w.h.bottom_container);
        this.fQg = (RelativeLayout) albumActivity.findViewById(w.h.lay_bottom);
        this.fQh = (ImageView) albumActivity.findViewById(w.h.add_more);
        this.fQd = albumActivity.findViewById(w.h.bottom_shadow);
        this.fQi = (TextView) albumActivity.findViewById(w.h.original_select_btn);
        this.fQi.setOnClickListener(albumActivity);
        this.fQn = (int) this.fPr.getResources().getDimension(w.f.ds90);
    }

    public void sW(int i) {
        this.fQl = new FrameLayout[i];
        this.fQm = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.fQl[i2] = (FrameLayout) LayoutInflater.from(this.fPr.getPageContext().getPageActivity()).inflate(w.j.album_bottom_item_view, (ViewGroup) null);
            this.fQm[i2 * 4] = this.fQl[i2].findViewById(w.h.line_top);
            this.fQm[(i2 * 4) + 1] = this.fQl[i2].findViewById(w.h.line_left);
            this.fQm[(i2 * 4) + 2] = this.fQl[i2].findViewById(w.h.line_right);
            this.fQm[(i2 * 4) + 3] = this.fQl[i2].findViewById(w.h.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(w.h.item_iv);
    }

    public void boL() {
        this.fQj = new Fragment[2];
        this.fQk = new String[2];
        this.fQj[0] = new ag();
        this.fQk[0] = this.fQa;
        this.fQj[1] = new e();
        this.fQk[1] = this.fQb;
    }

    public Fragment sX(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fQj[i];
    }

    public String sY(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fQk[i];
    }

    public void onChangeSkinType(int i) {
        this.fPr.getLayoutMode().aj(i == 1);
        this.fPr.getLayoutMode().t(this.cHu);
        for (int i2 = 0; i2 < this.fQj.length; i2++) {
            if (this.fQj[i2] != null && (this.fQj[i2] instanceof ag)) {
                ((ag) this.fQj[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button boM() {
        return this.fQc;
    }

    public View boN() {
        Fragment sX = sX(0);
        if (sX == null || !(sX instanceof ag)) {
            return null;
        }
        return ((ag) sX).bdN();
    }

    public View boO() {
        Fragment sX = sX(1);
        if (sX == null || !(sX instanceof e)) {
            return null;
        }
        return ((e) sX).bdN();
    }

    public void n(boolean z, String str) {
        this.fQc.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.fQc.setText(str);
    }

    public void g(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.fQl.length;
            for (int i = 0; i < length; i++) {
                if (this.fQl[i] != null && (a = a(this.fQl[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.fQn, this.fQn));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fQn, this.fQn);
                    layoutParams.rightMargin = (int) this.fPr.getResources().getDimension(w.f.ds10);
                    this.fQl[i].setLayoutParams(layoutParams);
                    this.fQf.addView(this.fQl[i], this.fQf.getChildCount() - 1);
                    a((HorizontalScrollView) this.fQe);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M(this.fQn, this.fQn));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.fPr.aip().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.e(a);
                        return;
                    } else {
                        this.fPr.aip().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M(this.fQn, this.fQn));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.fQf.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.fQf.getChildAt(i) != null && (this.fQf.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.fQf.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.fQf.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void lV(boolean z) {
        if (this.fQh != null) {
            if (z) {
                this.fQh.setVisibility(0);
            } else {
                this.fQh.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.fQe != null) {
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
        if (this.fPr.aip() != null) {
            this.fPr.aip().EP();
        }
    }

    public void sZ(int i) {
        if (i == 1) {
            aq.d(this.fQg, w.e.common_color_10100, 0);
            aq.j(this.fQc, w.g.post_button_bg_bigimage);
            aq.d(this.fQh, w.g.btn_add_pic_bigimage, 0);
            aq.e(this.fQd, w.e.common_color_10101, 0);
            for (View view : this.fQm) {
                aq.e(view, w.e.common_color_10101, 0);
            }
            return;
        }
        aq.j(this.fQg, w.e.common_color_10099);
        aq.j(this.fQc, w.g.post_button_bg);
        aq.j(this.fQh, w.g.btn_add_pic);
        aq.k(this.fQd, w.e.cp_cont_e);
        for (View view2 : this.fQm) {
            aq.k(view2, w.e.cp_cont_e);
        }
    }

    public void E(boolean z, boolean z2) {
        if (z) {
            this.fQi.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.fQi.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.fQi.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(fPZ);
            if (j > 0) {
                sb.append("(");
                sb.append(au.E(j));
                sb.append(")");
            }
            this.fQi.setText(sb.toString());
            return;
        }
        this.fQi.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fQi.setText(fPZ);
    }

    public View boP() {
        return this.fQi;
    }
}
