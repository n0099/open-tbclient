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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private static final String fHA = TbadkCoreApplication.m9getInst().getResources().getString(r.l.original_img);
    private ViewGroup cFj;
    private AlbumActivity fGS;
    private String fHB;
    private String fHC;
    private Button fHD;
    private View fHE;
    private HorizontalCustomScrollView fHF;
    private LinearLayout fHG;
    private RelativeLayout fHH;
    private ImageView fHI;
    private TextView fHJ;
    private Fragment[] fHK;
    private String[] fHL;
    private FrameLayout[] fHM;
    private View[] fHN;
    private int fHO;
    private Handler mHandler;
    private Runnable scrollRunnable;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.fHB = "tag_image";
        this.fHC = "tag_b_image";
        this.mHandler = new Handler();
        this.fGS = albumActivity;
        e(albumActivity);
    }

    private void e(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(r.j.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.cFj = (ViewGroup) albumActivity.findViewById(r.h.parent);
        this.fHD = (Button) albumActivity.findViewById(r.h.btn_done);
        this.fHD.setOnClickListener(albumActivity);
        this.fHF = (HorizontalCustomScrollView) albumActivity.findViewById(r.h.bottom_scroll);
        this.fHG = (LinearLayout) albumActivity.findViewById(r.h.bottom_container);
        this.fHH = (RelativeLayout) albumActivity.findViewById(r.h.lay_bottom);
        this.fHI = (ImageView) albumActivity.findViewById(r.h.add_more);
        this.fHE = albumActivity.findViewById(r.h.bottom_shadow);
        this.fHJ = (TextView) albumActivity.findViewById(r.h.original_select_btn);
        this.fHJ.setOnClickListener(albumActivity);
        this.fHO = (int) this.fGS.getResources().getDimension(r.f.ds90);
    }

    public void sT(int i) {
        this.fHM = new FrameLayout[i];
        this.fHN = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.fHM[i2] = (FrameLayout) LayoutInflater.from(this.fGS.getPageContext().getPageActivity()).inflate(r.j.album_bottom_item_view, (ViewGroup) null);
            this.fHN[i2 * 4] = this.fHM[i2].findViewById(r.h.line_top);
            this.fHN[(i2 * 4) + 1] = this.fHM[i2].findViewById(r.h.line_left);
            this.fHN[(i2 * 4) + 2] = this.fHM[i2].findViewById(r.h.line_right);
            this.fHN[(i2 * 4) + 3] = this.fHM[i2].findViewById(r.h.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(r.h.item_iv);
    }

    public void bnn() {
        this.fHK = new Fragment[2];
        this.fHL = new String[2];
        this.fHK[0] = new ag();
        this.fHL[0] = this.fHB;
        this.fHK[1] = new e();
        this.fHL[1] = this.fHC;
    }

    public Fragment sU(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fHK[i];
    }

    public String sV(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fHL[i];
    }

    public void onChangeSkinType(int i) {
        this.fGS.getLayoutMode().ai(i == 1);
        this.fGS.getLayoutMode().v(this.cFj);
        for (int i2 = 0; i2 < this.fHK.length; i2++) {
            if (this.fHK[i2] != null && (this.fHK[i2] instanceof ag)) {
                ((ag) this.fHK[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button bno() {
        return this.fHD;
    }

    public View bnp() {
        Fragment sU = sU(0);
        if (sU == null || !(sU instanceof ag)) {
            return null;
        }
        return ((ag) sU).bcs();
    }

    public View bnq() {
        Fragment sU = sU(1);
        if (sU == null || !(sU instanceof e)) {
            return null;
        }
        return ((e) sU).bcs();
    }

    public void o(boolean z, String str) {
        this.fHD.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.fHD.setText(str);
    }

    public void g(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.fHM.length;
            for (int i = 0; i < length; i++) {
                if (this.fHM[i] != null && (a = a(this.fHM[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.fHO, this.fHO));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fHO, this.fHO);
                    layoutParams.rightMargin = (int) this.fGS.getResources().getDimension(r.f.ds10);
                    this.fHM[i].setLayoutParams(layoutParams);
                    this.fHG.addView(this.fHM[i], this.fHG.getChildCount() - 1);
                    a((HorizontalScrollView) this.fHF);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.G(this.fHO, this.fHO));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.fGS.aii().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.e(a);
                        return;
                    } else {
                        this.fGS.aii().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.G(this.fHO, this.fHO));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.fHG.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.fHG.getChildAt(i) != null && (this.fHG.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.fHG.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.fHG.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void lJ(boolean z) {
        if (this.fHI != null) {
            if (z) {
                this.fHI.setVisibility(0);
            } else {
                this.fHI.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.fHF != null) {
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
        if (this.fGS.aii() != null) {
            this.fGS.aii().DY();
        }
    }

    public void sW(int i) {
        if (i == 1) {
            com.baidu.tbadk.core.util.ap.d(this.fHH, r.e.common_color_10100, 0);
            com.baidu.tbadk.core.util.ap.j((View) this.fHD, r.g.post_button_bg_bigimage);
            com.baidu.tbadk.core.util.ap.d(this.fHI, r.g.btn_add_pic_bigimage, 0);
            com.baidu.tbadk.core.util.ap.e(this.fHE, r.e.common_color_10101, 0);
            for (View view : this.fHN) {
                com.baidu.tbadk.core.util.ap.e(view, r.e.common_color_10101, 0);
            }
            return;
        }
        com.baidu.tbadk.core.util.ap.j(this.fHH, r.e.common_color_10099);
        com.baidu.tbadk.core.util.ap.j((View) this.fHD, r.g.post_button_bg);
        com.baidu.tbadk.core.util.ap.j(this.fHI, r.g.btn_add_pic);
        com.baidu.tbadk.core.util.ap.k(this.fHE, r.e.cp_cont_e);
        for (View view2 : this.fHN) {
            com.baidu.tbadk.core.util.ap.k(view2, r.e.cp_cont_e);
        }
    }

    public void F(boolean z, boolean z2) {
        if (z) {
            this.fHJ.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.fHJ.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.fHJ.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(fHA);
            if (j > 0) {
                sb.append("(");
                sb.append(at.E(j));
                sb.append(")");
            }
            this.fHJ.setText(sb.toString());
            return;
        }
        this.fHJ.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fHJ.setText(fHA);
    }

    public View bnr() {
        return this.fHJ;
    }
}
