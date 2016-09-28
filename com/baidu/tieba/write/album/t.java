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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String gcQ = TbadkCoreApplication.m9getInst().getResources().getString(r.j.original_img);
    private Runnable anK;
    private ViewGroup dsk;
    private String gcR;
    private String gcS;
    private Button gcT;
    private View gcU;
    private HorizontalCustomScrollView gcV;
    private LinearLayout gcW;
    private RelativeLayout gcX;
    private ImageView gcY;
    private TextView gcZ;
    private AlbumActivity gco;
    private Fragment[] gda;
    private String[] gdb;
    private FrameLayout[] gdc;
    private View[] gdd;
    private int gde;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gcR = "tag_image";
        this.gcS = "tag_b_image";
        this.mHandler = new Handler();
        this.gco = albumActivity;
        e(albumActivity);
    }

    private void e(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(r.h.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.dsk = (ViewGroup) albumActivity.findViewById(r.g.parent);
        this.gcT = (Button) albumActivity.findViewById(r.g.btn_done);
        this.gcT.setOnClickListener(albumActivity);
        this.gcV = (HorizontalCustomScrollView) albumActivity.findViewById(r.g.bottom_scroll);
        this.gcW = (LinearLayout) albumActivity.findViewById(r.g.bottom_container);
        this.gcX = (RelativeLayout) albumActivity.findViewById(r.g.lay_bottom);
        this.gcY = (ImageView) albumActivity.findViewById(r.g.add_more);
        this.gcU = albumActivity.findViewById(r.g.bottom_shadow);
        this.gcZ = (TextView) albumActivity.findViewById(r.g.original_select_btn);
        this.gcZ.setOnClickListener(albumActivity);
        this.gde = (int) this.gco.getResources().getDimension(r.e.ds90);
    }

    public void tn(int i) {
        this.gdc = new FrameLayout[i];
        this.gdd = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.gdc[i2] = (FrameLayout) LayoutInflater.from(this.gco.getPageContext().getPageActivity()).inflate(r.h.album_bottom_item_view, (ViewGroup) null);
            this.gdd[i2 * 4] = this.gdc[i2].findViewById(r.g.line_top);
            this.gdd[(i2 * 4) + 1] = this.gdc[i2].findViewById(r.g.line_left);
            this.gdd[(i2 * 4) + 2] = this.gdc[i2].findViewById(r.g.line_right);
            this.gdd[(i2 * 4) + 3] = this.gdc[i2].findViewById(r.g.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(r.g.item_iv);
    }

    public void bsz() {
        this.gda = new Fragment[2];
        this.gdb = new String[2];
        this.gda[0] = new ag();
        this.gdb[0] = this.gcR;
        this.gda[1] = new e();
        this.gdb[1] = this.gcS;
    }

    public Fragment to(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gda[i];
    }

    public String tp(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gdb[i];
    }

    public void onChangeSkinType(int i) {
        this.gco.getLayoutMode().ah(i == 1);
        this.gco.getLayoutMode().x(this.dsk);
        for (int i2 = 0; i2 < this.gda.length; i2++) {
            if (this.gda[i2] != null && (this.gda[i2] instanceof ag)) {
                ((ag) this.gda[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button bsA() {
        return this.gcT;
    }

    public View bsB() {
        Fragment fragment = to(0);
        if (fragment == null || !(fragment instanceof ag)) {
            return null;
        }
        return ((ag) fragment).ber();
    }

    public View bsC() {
        Fragment fragment = to(1);
        if (fragment == null || !(fragment instanceof e)) {
            return null;
        }
        return ((e) fragment).ber();
    }

    public void n(boolean z, String str) {
        this.gcT.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.gcT.setText(str);
    }

    public void h(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.gdc.length;
            for (int i = 0; i < length; i++) {
                if (this.gdc[i] != null && (a = a(this.gdc[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.gde, this.gde));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.gde, this.gde);
                    layoutParams.rightMargin = (int) this.gco.getResources().getDimension(r.e.ds10);
                    this.gdc[i].setLayoutParams(layoutParams);
                    this.gcW.addView(this.gdc[i], this.gcW.getChildCount() - 1);
                    a((HorizontalScrollView) this.gcV);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(this.gde, this.gde));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.gco.akF().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.e(a);
                        return;
                    } else {
                        this.gco.akF().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(this.gde, this.gde));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.gcW.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.gcW.getChildAt(i) != null && (this.gcW.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.gcW.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.gcW.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void lM(boolean z) {
        if (this.gcY != null) {
            if (z) {
                this.gcY.setVisibility(0);
            } else {
                this.gcY.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.gcV != null) {
            if (this.anK == null) {
                this.anK = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.anK);
            this.mHandler.postDelayed(this.anK, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.anK != null) {
            this.mHandler.removeCallbacks(this.anK);
        }
        if (this.gco.akF() != null) {
            this.gco.akF().Eq();
        }
    }

    public void tq(int i) {
        if (i == 1) {
            av.d(this.gcX, r.d.common_color_10100, 0);
            av.k(this.gcT, r.f.post_button_bg_bigimage);
            av.d(this.gcY, r.f.btn_add_pic_bigimage, 0);
            av.e(this.gcU, r.d.common_color_10101, 0);
            for (View view : this.gdd) {
                av.e(view, r.d.common_color_10101, 0);
            }
            return;
        }
        av.k(this.gcX, r.d.common_color_10099);
        av.k(this.gcT, r.f.post_button_bg);
        av.k(this.gcY, r.f.btn_add_pic);
        av.l(this.gcU, r.d.cp_cont_e);
        for (View view2 : this.gdd) {
            av.l(view2, r.d.cp_cont_e);
        }
    }

    public void E(boolean z, boolean z2) {
        if (z) {
            this.gcZ.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.gcZ.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.gcZ.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(gcQ);
            if (j > 0) {
                sb.append("(");
                sb.append(az.I(j));
                sb.append(")");
            }
            this.gcZ.setText(sb.toString());
            return;
        }
        this.gcZ.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gcZ.setText(gcQ);
    }

    public View bsD() {
        return this.gcZ;
    }
}
