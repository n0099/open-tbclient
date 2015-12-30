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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String dSQ = TbadkCoreApplication.m411getInst().getResources().getString(n.j.original_img);
    private Runnable amC;
    private ViewGroup cgR;
    private String dSR;
    private String dSS;
    private Button dST;
    private View dSU;
    private HorizontalCustomScrollView dSV;
    private LinearLayout dSW;
    private RelativeLayout dSX;
    private ImageView dSY;
    private TextView dSZ;
    private AlbumActivity dSj;
    private Fragment[] dTa;
    private String[] dTb;
    private FrameLayout[] dTc;
    private View[] dTd;
    private int dTe;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.dSR = "tag_image";
        this.dSS = "tag_b_image";
        this.mHandler = new Handler();
        this.dSj = albumActivity;
        d(albumActivity);
    }

    private void d(AlbumActivity albumActivity) {
        albumActivity.setContentView(n.h.album_activity);
        this.cgR = (ViewGroup) albumActivity.findViewById(n.g.parent);
        this.dST = (Button) albumActivity.findViewById(n.g.btn_done);
        this.dST.setOnClickListener(albumActivity);
        this.dSV = (HorizontalCustomScrollView) albumActivity.findViewById(n.g.bottom_scroll);
        this.dSW = (LinearLayout) albumActivity.findViewById(n.g.bottom_container);
        this.dSX = (RelativeLayout) albumActivity.findViewById(n.g.lay_bottom);
        this.dSY = (ImageView) albumActivity.findViewById(n.g.add_more);
        this.dSU = albumActivity.findViewById(n.g.bottom_shadow);
        this.dSZ = (TextView) albumActivity.findViewById(n.g.original_select_btn);
        this.dSZ.setOnClickListener(albumActivity);
        this.dTe = (int) this.dSj.getResources().getDimension(n.e.ds90);
    }

    public void oe(int i) {
        this.dTc = new FrameLayout[i];
        this.dTd = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.dTc[i2] = (FrameLayout) LayoutInflater.from(this.dSj.getPageContext().getPageActivity()).inflate(n.h.album_bottom_item_view, (ViewGroup) null);
            this.dTd[i2 * 4] = this.dTc[i2].findViewById(n.g.line_top);
            this.dTd[(i2 * 4) + 1] = this.dTc[i2].findViewById(n.g.line_left);
            this.dTd[(i2 * 4) + 2] = this.dTc[i2].findViewById(n.g.line_right);
            this.dTd[(i2 * 4) + 3] = this.dTc[i2].findViewById(n.g.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(n.g.item_iv);
    }

    public void aKe() {
        this.dTa = new Fragment[2];
        this.dTb = new String[2];
        this.dTa[0] = new ag();
        this.dTb[0] = this.dSR;
        this.dTa[1] = new e();
        this.dTb[1] = this.dSS;
    }

    public Fragment of(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dTa[i];
    }

    public String og(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dTb[i];
    }

    public void onChangeSkinType(int i) {
        this.dSj.getLayoutMode().ac(i == 1);
        this.dSj.getLayoutMode().k(this.cgR);
        for (int i2 = 0; i2 < this.dTa.length; i2++) {
            if (this.dTa[i2] != null && (this.dTa[i2] instanceof ag)) {
                ((ag) this.dTa[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button aKf() {
        return this.dST;
    }

    public View aKg() {
        Fragment of = of(0);
        if (of == null || !(of instanceof ag)) {
            return null;
        }
        return ((ag) of).aqV();
    }

    public View aKh() {
        Fragment of = of(1);
        if (of == null || !(of instanceof e)) {
            return null;
        }
        return ((e) of).aqV();
    }

    public void o(boolean z, String str) {
        this.dST.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.dST.setText(str);
    }

    public void e(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.dTc.length;
            for (int i = 0; i < length; i++) {
                if (this.dTc[i] != null && (a = a(this.dTc[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.dTe, this.dTe));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dTe, this.dTe);
                    layoutParams.rightMargin = (int) this.dSj.getResources().getDimension(n.e.ds10);
                    this.dTc[i].setLayoutParams(layoutParams);
                    this.dSW.addView(this.dTc[i], this.dSW.getChildCount() - 1);
                    a((HorizontalScrollView) this.dSV);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.dTe, this.dTe));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.dSj.aJI().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.dSj.aJI().a(imageFileInfo, new v(this, imageFileInfo), false);
                        return;
                    }
                }
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo) {
        FrameLayout frameLayout;
        TbImageView a;
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.dTe, this.dTe));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.dSW.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.dSW.getChildAt(i) != null && (this.dSW.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.dSW.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.dSW.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void hN(boolean z) {
        if (this.dSY != null) {
            if (z) {
                this.dSY.setVisibility(0);
            } else {
                this.dSY.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.dSV != null) {
            if (this.amC == null) {
                this.amC = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.amC);
            this.mHandler.postDelayed(this.amC, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.amC != null) {
            this.mHandler.removeCallbacks(this.amC);
        }
        if (this.dSj.aJI() != null) {
            this.dSj.aJI().CS();
        }
    }

    public void oh(int i) {
        if (i == 1) {
            as.c(this.dSX, n.d.album_list_bottom_bigimage_bg, 0);
            as.i((View) this.dST, n.f.post_button_bg_bigimage);
            as.c(this.dSY, n.f.btn_add_pic_bigimage, 0);
            as.d(this.dSU, n.d.album_list_bottom_bigimage_line, 0);
            for (View view : this.dTd) {
                as.d(view, n.d.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        as.i(this.dSX, n.d.album_list_bottom_bg);
        as.i((View) this.dST, n.f.post_button_bg);
        as.i(this.dSY, n.f.btn_add_pic);
        as.j(this.dSU, n.d.album_list_bottom_line);
        for (View view2 : this.dTd) {
            as.j(view2, n.d.album_list_bottom_line);
        }
    }

    public void u(boolean z, boolean z2) {
        if (z) {
            this.dSZ.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.dSZ.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.dSZ.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(dSQ);
            if (j > 0) {
                sb.append("(");
                sb.append(ax.D(j));
                sb.append(")");
            }
            this.dSZ.setText(sb.toString());
            return;
        }
        this.dSZ.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.dSZ.setText(dSQ);
    }

    public View aKi() {
        return this.dSZ;
    }
}
