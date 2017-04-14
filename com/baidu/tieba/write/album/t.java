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
    private static final String fND = TbadkCoreApplication.m9getInst().getResources().getString(w.l.original_img);
    private ViewGroup cFd;
    private AlbumActivity fMV;
    private String fNE;
    private String fNF;
    private Button fNG;
    private View fNH;
    private HorizontalCustomScrollView fNI;
    private LinearLayout fNJ;
    private RelativeLayout fNK;
    private ImageView fNL;
    private TextView fNM;
    private Fragment[] fNN;
    private String[] fNO;
    private FrameLayout[] fNP;
    private View[] fNQ;
    private int fNR;
    private Handler mHandler;
    private Runnable scrollRunnable;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.fNE = "tag_image";
        this.fNF = "tag_b_image";
        this.mHandler = new Handler();
        this.fMV = albumActivity;
        e(albumActivity);
    }

    private void e(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(w.j.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.cFd = (ViewGroup) albumActivity.findViewById(w.h.parent);
        this.fNG = (Button) albumActivity.findViewById(w.h.btn_done);
        this.fNG.setOnClickListener(albumActivity);
        this.fNI = (HorizontalCustomScrollView) albumActivity.findViewById(w.h.bottom_scroll);
        this.fNJ = (LinearLayout) albumActivity.findViewById(w.h.bottom_container);
        this.fNK = (RelativeLayout) albumActivity.findViewById(w.h.lay_bottom);
        this.fNL = (ImageView) albumActivity.findViewById(w.h.add_more);
        this.fNH = albumActivity.findViewById(w.h.bottom_shadow);
        this.fNM = (TextView) albumActivity.findViewById(w.h.original_select_btn);
        this.fNM.setOnClickListener(albumActivity);
        this.fNR = (int) this.fMV.getResources().getDimension(w.f.ds90);
    }

    public void sQ(int i) {
        this.fNP = new FrameLayout[i];
        this.fNQ = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.fNP[i2] = (FrameLayout) LayoutInflater.from(this.fMV.getPageContext().getPageActivity()).inflate(w.j.album_bottom_item_view, (ViewGroup) null);
            this.fNQ[i2 * 4] = this.fNP[i2].findViewById(w.h.line_top);
            this.fNQ[(i2 * 4) + 1] = this.fNP[i2].findViewById(w.h.line_left);
            this.fNQ[(i2 * 4) + 2] = this.fNP[i2].findViewById(w.h.line_right);
            this.fNQ[(i2 * 4) + 3] = this.fNP[i2].findViewById(w.h.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(w.h.item_iv);
    }

    public void bnK() {
        this.fNN = new Fragment[2];
        this.fNO = new String[2];
        this.fNN[0] = new ag();
        this.fNO[0] = this.fNE;
        this.fNN[1] = new e();
        this.fNO[1] = this.fNF;
    }

    public Fragment sR(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fNN[i];
    }

    public String sS(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fNO[i];
    }

    public void onChangeSkinType(int i) {
        this.fMV.getLayoutMode().aj(i == 1);
        this.fMV.getLayoutMode().t(this.cFd);
        for (int i2 = 0; i2 < this.fNN.length; i2++) {
            if (this.fNN[i2] != null && (this.fNN[i2] instanceof ag)) {
                ((ag) this.fNN[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button bnL() {
        return this.fNG;
    }

    public View bnM() {
        Fragment sR = sR(0);
        if (sR == null || !(sR instanceof ag)) {
            return null;
        }
        return ((ag) sR).bcM();
    }

    public View bnN() {
        Fragment sR = sR(1);
        if (sR == null || !(sR instanceof e)) {
            return null;
        }
        return ((e) sR).bcM();
    }

    public void n(boolean z, String str) {
        this.fNG.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.fNG.setText(str);
    }

    public void g(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.fNP.length;
            for (int i = 0; i < length; i++) {
                if (this.fNP[i] != null && (a = a(this.fNP[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.fNR, this.fNR));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fNR, this.fNR);
                    layoutParams.rightMargin = (int) this.fMV.getResources().getDimension(w.f.ds10);
                    this.fNP[i].setLayoutParams(layoutParams);
                    this.fNJ.addView(this.fNP[i], this.fNJ.getChildCount() - 1);
                    a((HorizontalScrollView) this.fNI);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M(this.fNR, this.fNR));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.fMV.aho().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.e(a);
                        return;
                    } else {
                        this.fMV.aho().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M(this.fNR, this.fNR));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.fNJ.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.fNJ.getChildAt(i) != null && (this.fNJ.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.fNJ.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.fNJ.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void lL(boolean z) {
        if (this.fNL != null) {
            if (z) {
                this.fNL.setVisibility(0);
            } else {
                this.fNL.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.fNI != null) {
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
        if (this.fMV.aho() != null) {
            this.fMV.aho().EP();
        }
    }

    public void sT(int i) {
        if (i == 1) {
            aq.d(this.fNK, w.e.common_color_10100, 0);
            aq.j(this.fNG, w.g.post_button_bg_bigimage);
            aq.d(this.fNL, w.g.btn_add_pic_bigimage, 0);
            aq.e(this.fNH, w.e.common_color_10101, 0);
            for (View view : this.fNQ) {
                aq.e(view, w.e.common_color_10101, 0);
            }
            return;
        }
        aq.j(this.fNK, w.e.common_color_10099);
        aq.j(this.fNG, w.g.post_button_bg);
        aq.j(this.fNL, w.g.btn_add_pic);
        aq.k(this.fNH, w.e.cp_cont_e);
        for (View view2 : this.fNQ) {
            aq.k(view2, w.e.cp_cont_e);
        }
    }

    public void E(boolean z, boolean z2) {
        if (z) {
            this.fNM.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.fNM.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.fNM.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(fND);
            if (j > 0) {
                sb.append("(");
                sb.append(au.E(j));
                sb.append(")");
            }
            this.fNM.setText(sb.toString());
            return;
        }
        this.fNM.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fNM.setText(fND);
    }

    public View bnO() {
        return this.fNM;
    }
}
