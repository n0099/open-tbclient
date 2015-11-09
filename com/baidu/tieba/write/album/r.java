package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String dml = TbadkCoreApplication.m411getInst().getResources().getString(i.h.original_img);
    private Runnable ajL;
    private ViewGroup bNN;
    private AlbumActivity dlE;
    private String dmm;
    private String dmn;
    private Button dmo;
    private View dmp;
    private HorizontalCustomScrollView dmq;
    private LinearLayout dmr;
    private RelativeLayout dms;
    private ImageView dmt;
    private TextView dmu;
    private Fragment[] dmv;
    private String[] dmw;
    private FrameLayout[] dmx;
    private View[] dmy;
    private int dmz;
    private Handler mHandler;

    public r(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.dmm = "tag_image";
        this.dmn = "tag_b_image";
        this.mHandler = new Handler();
        this.dlE = albumActivity;
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(i.g.album_activity);
        this.bNN = (ViewGroup) albumActivity.findViewById(i.f.parent);
        this.dmo = (Button) albumActivity.findViewById(i.f.btn_done);
        this.dmo.setOnClickListener(albumActivity);
        this.dmq = (HorizontalCustomScrollView) albumActivity.findViewById(i.f.bottom_scroll);
        this.dmr = (LinearLayout) albumActivity.findViewById(i.f.bottom_container);
        this.dms = (RelativeLayout) albumActivity.findViewById(i.f.lay_bottom);
        this.dmt = (ImageView) albumActivity.findViewById(i.f.add_more);
        this.dmp = albumActivity.findViewById(i.f.bottom_shadow);
        this.dmu = (TextView) albumActivity.findViewById(i.f.original_select_btn);
        this.dmu.setOnClickListener(albumActivity);
        this.dmz = (int) this.dlE.getResources().getDimension(i.d.ds90);
    }

    public void ma(int i) {
        this.dmx = new FrameLayout[i];
        this.dmy = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.dmx[i2] = (FrameLayout) LayoutInflater.from(this.dlE.getPageContext().getPageActivity()).inflate(i.g.album_bottom_item_view, (ViewGroup) null);
            this.dmy[i2 * 4] = this.dmx[i2].findViewById(i.f.line_top);
            this.dmy[(i2 * 4) + 1] = this.dmx[i2].findViewById(i.f.line_left);
            this.dmy[(i2 * 4) + 2] = this.dmx[i2].findViewById(i.f.line_right);
            this.dmy[(i2 * 4) + 3] = this.dmx[i2].findViewById(i.f.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(i.f.item_iv);
    }

    public void aCm() {
        this.dmv = new Fragment[2];
        this.dmw = new String[2];
        this.dmv[0] = new ae();
        this.dmw[0] = this.dmm;
        this.dmv[1] = new c();
        this.dmw[1] = this.dmn;
    }

    public Fragment mb(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dmv[i];
    }

    public String mc(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dmw[i];
    }

    public void onChangeSkinType(int i) {
        this.dlE.getLayoutMode().ad(i == 1);
        this.dlE.getLayoutMode().k(this.bNN);
    }

    public Button aCn() {
        return this.dmo;
    }

    public View aCo() {
        Fragment mb = mb(0);
        if (mb == null || !(mb instanceof ae)) {
            return null;
        }
        return ((ae) mb).akF();
    }

    public View aCp() {
        Fragment mb = mb(1);
        if (mb == null || !(mb instanceof c)) {
            return null;
        }
        return ((c) mb).akF();
    }

    public void n(boolean z, String str) {
        this.dmo.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.dmo.setText(str);
    }

    public void g(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.dmx.length;
            for (int i = 0; i < length; i++) {
                if (this.dmx[i] != null && (a = a(this.dmx[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.dmz, this.dmz));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dmz, this.dmz);
                    layoutParams.rightMargin = (int) this.dlE.getResources().getDimension(i.d.ds10);
                    this.dmx[i].setLayoutParams(layoutParams);
                    this.dmr.addView(this.dmx[i], this.dmr.getChildCount() - 1);
                    a((HorizontalScrollView) this.dmq);
                    a.setOnClickListener(new s(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.dmz, this.dmz));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.dlE.aBR().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.dlE.aBR().a(imageFileInfo, new t(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.dmz, this.dmz));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.dmr.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.dmr.getChildAt(i) != null && (this.dmr.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.dmr.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.dmr.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void gW(boolean z) {
        if (this.dmt != null) {
            if (z) {
                this.dmt.setVisibility(0);
            } else {
                this.dmt.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.dmq != null) {
            if (this.ajL == null) {
                this.ajL = new u(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.ajL);
            this.mHandler.postDelayed(this.ajL, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.ajL != null) {
            this.mHandler.removeCallbacks(this.ajL);
        }
        if (this.dlE.aBR() != null) {
            this.dlE.aBR().Cc();
        }
    }

    public void md(int i) {
        if (i == 1) {
            com.baidu.tbadk.core.util.an.c(this.dms, i.c.album_list_bottom_bigimage_bg, 0);
            com.baidu.tbadk.core.util.an.i((View) this.dmo, i.e.post_button_bg_bigimage);
            com.baidu.tbadk.core.util.an.c(this.dmt, i.e.btn_add_pic_bigimage, 0);
            com.baidu.tbadk.core.util.an.d(this.dmp, i.c.album_list_bottom_bigimage_line, 0);
            for (View view : this.dmy) {
                com.baidu.tbadk.core.util.an.d(view, i.c.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        com.baidu.tbadk.core.util.an.i(this.dms, i.c.album_list_bottom_bg);
        com.baidu.tbadk.core.util.an.i((View) this.dmo, i.e.post_button_bg);
        com.baidu.tbadk.core.util.an.i(this.dmt, i.e.btn_add_pic);
        com.baidu.tbadk.core.util.an.j(this.dmp, i.c.album_list_bottom_line);
        for (View view2 : this.dmy) {
            com.baidu.tbadk.core.util.an.j(view2, i.c.album_list_bottom_line);
        }
    }

    public void q(boolean z, boolean z2) {
        if (z) {
            this.dmu.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.dmu.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.dmu.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(dml);
            if (j > 0) {
                sb.append("(");
                sb.append(as.w(j));
                sb.append(")");
            }
            this.dmu.setText(sb.toString());
            return;
        }
        this.dmu.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.dmu.setText(dml);
    }

    public View aCq() {
        return this.dmu;
    }
}
