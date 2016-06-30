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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String fDp = TbadkCoreApplication.m9getInst().getResources().getString(u.j.original_img);
    private Runnable akg;
    private ViewGroup dci;
    private AlbumActivity fCP;
    private String[] fDA;
    private FrameLayout[] fDB;
    private View[] fDC;
    private int fDD;
    private String fDq;
    private String fDr;
    private Button fDs;
    private View fDt;
    private HorizontalCustomScrollView fDu;
    private LinearLayout fDv;
    private RelativeLayout fDw;
    private ImageView fDx;
    private TextView fDy;
    private Fragment[] fDz;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.fDq = "tag_image";
        this.fDr = "tag_b_image";
        this.mHandler = new Handler();
        this.fCP = albumActivity;
        d(albumActivity);
    }

    private void d(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(u.h.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.dci = (ViewGroup) albumActivity.findViewById(u.g.parent);
        this.fDs = (Button) albumActivity.findViewById(u.g.btn_done);
        this.fDs.setOnClickListener(albumActivity);
        this.fDu = (HorizontalCustomScrollView) albumActivity.findViewById(u.g.bottom_scroll);
        this.fDv = (LinearLayout) albumActivity.findViewById(u.g.bottom_container);
        this.fDw = (RelativeLayout) albumActivity.findViewById(u.g.lay_bottom);
        this.fDx = (ImageView) albumActivity.findViewById(u.g.add_more);
        this.fDt = albumActivity.findViewById(u.g.bottom_shadow);
        this.fDy = (TextView) albumActivity.findViewById(u.g.original_select_btn);
        this.fDy.setOnClickListener(albumActivity);
        this.fDD = (int) this.fCP.getResources().getDimension(u.e.ds90);
    }

    public void se(int i) {
        this.fDB = new FrameLayout[i];
        this.fDC = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.fDB[i2] = (FrameLayout) LayoutInflater.from(this.fCP.getPageContext().getPageActivity()).inflate(u.h.album_bottom_item_view, (ViewGroup) null);
            this.fDC[i2 * 4] = this.fDB[i2].findViewById(u.g.line_top);
            this.fDC[(i2 * 4) + 1] = this.fDB[i2].findViewById(u.g.line_left);
            this.fDC[(i2 * 4) + 2] = this.fDB[i2].findViewById(u.g.line_right);
            this.fDC[(i2 * 4) + 3] = this.fDB[i2].findViewById(u.g.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(u.g.item_iv);
    }

    public void bkh() {
        this.fDz = new Fragment[2];
        this.fDA = new String[2];
        this.fDz[0] = new ag();
        this.fDA[0] = this.fDq;
        this.fDz[1] = new e();
        this.fDA[1] = this.fDr;
    }

    public Fragment sf(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fDz[i];
    }

    public String sg(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fDA[i];
    }

    public void onChangeSkinType(int i) {
        this.fCP.getLayoutMode().ad(i == 1);
        this.fCP.getLayoutMode().w(this.dci);
        for (int i2 = 0; i2 < this.fDz.length; i2++) {
            if (this.fDz[i2] != null && (this.fDz[i2] instanceof ag)) {
                ((ag) this.fDz[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button bki() {
        return this.fDs;
    }

    public View bkj() {
        Fragment sf = sf(0);
        if (sf == null || !(sf instanceof ag)) {
            return null;
        }
        return ((ag) sf).aNm();
    }

    public View bkk() {
        Fragment sf = sf(1);
        if (sf == null || !(sf instanceof e)) {
            return null;
        }
        return ((e) sf).aNm();
    }

    public void p(boolean z, String str) {
        this.fDs.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.fDs.setText(str);
    }

    public void h(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.fDB.length;
            for (int i = 0; i < length; i++) {
                if (this.fDB[i] != null && (a = a(this.fDB[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.fDD, this.fDD));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fDD, this.fDD);
                    layoutParams.rightMargin = (int) this.fCP.getResources().getDimension(u.e.ds10);
                    this.fDB[i].setLayoutParams(layoutParams);
                    this.fDv.addView(this.fDB[i], this.fDv.getChildCount() - 1);
                    a((HorizontalScrollView) this.fDu);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.fDD, this.fDD));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.fCP.afd().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.fCP.afd().a(imageFileInfo, new v(this, imageFileInfo), false);
                        return;
                    }
                }
            }
        }
    }

    public void i(ImageFileInfo imageFileInfo) {
        FrameLayout frameLayout;
        TbImageView a;
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.fDD, this.fDD));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.fDv.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.fDv.getChildAt(i) != null && (this.fDv.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.fDv.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.fDv.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void lf(boolean z) {
        if (this.fDx != null) {
            if (z) {
                this.fDx.setVisibility(0);
            } else {
                this.fDx.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.fDu != null) {
            if (this.akg == null) {
                this.akg = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.akg);
            this.mHandler.postDelayed(this.akg, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.akg != null) {
            this.mHandler.removeCallbacks(this.akg);
        }
        if (this.fCP.afd() != null) {
            this.fCP.afd().CW();
        }
    }

    public void sh(int i) {
        if (i == 1) {
            av.d(this.fDw, u.d.common_color_10100, 0);
            av.k(this.fDs, u.f.post_button_bg_bigimage);
            av.d(this.fDx, u.f.btn_add_pic_bigimage, 0);
            av.e(this.fDt, u.d.common_color_10101, 0);
            for (View view : this.fDC) {
                av.e(view, u.d.common_color_10101, 0);
            }
            return;
        }
        av.k(this.fDw, u.d.common_color_10099);
        av.k(this.fDs, u.f.post_button_bg);
        av.k(this.fDx, u.f.btn_add_pic);
        av.l(this.fDt, u.d.cp_cont_e);
        for (View view2 : this.fDC) {
            av.l(view2, u.d.cp_cont_e);
        }
    }

    public void z(boolean z, boolean z2) {
        if (z) {
            this.fDy.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.fDy.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.fDy.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(fDp);
            if (j > 0) {
                sb.append("(");
                sb.append(ba.L(j));
                sb.append(")");
            }
            this.fDy.setText(sb.toString());
            return;
        }
        this.fDy.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fDy.setText(fDp);
    }

    public View bkl() {
        return this.fDy;
    }
}
