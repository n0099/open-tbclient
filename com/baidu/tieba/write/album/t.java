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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String eHs = TbadkCoreApplication.m411getInst().getResources().getString(t.j.original_img);
    private Runnable anM;
    private ViewGroup cvW;
    private AlbumActivity eGS;
    private ImageView eHA;
    private TextView eHB;
    private Fragment[] eHC;
    private String[] eHD;
    private FrameLayout[] eHE;
    private View[] eHF;
    private int eHG;
    private String eHt;
    private String eHu;
    private Button eHv;
    private View eHw;
    private HorizontalCustomScrollView eHx;
    private LinearLayout eHy;
    private RelativeLayout eHz;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.eHt = "tag_image";
        this.eHu = "tag_b_image";
        this.mHandler = new Handler();
        this.eGS = albumActivity;
        d(albumActivity);
    }

    private void d(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(t.h.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.cvW = (ViewGroup) albumActivity.findViewById(t.g.parent);
        this.eHv = (Button) albumActivity.findViewById(t.g.btn_done);
        this.eHv.setOnClickListener(albumActivity);
        this.eHx = (HorizontalCustomScrollView) albumActivity.findViewById(t.g.bottom_scroll);
        this.eHy = (LinearLayout) albumActivity.findViewById(t.g.bottom_container);
        this.eHz = (RelativeLayout) albumActivity.findViewById(t.g.lay_bottom);
        this.eHA = (ImageView) albumActivity.findViewById(t.g.add_more);
        this.eHw = albumActivity.findViewById(t.g.bottom_shadow);
        this.eHB = (TextView) albumActivity.findViewById(t.g.original_select_btn);
        this.eHB.setOnClickListener(albumActivity);
        this.eHG = (int) this.eGS.getResources().getDimension(t.e.ds90);
    }

    public void qs(int i) {
        this.eHE = new FrameLayout[i];
        this.eHF = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.eHE[i2] = (FrameLayout) LayoutInflater.from(this.eGS.getPageContext().getPageActivity()).inflate(t.h.album_bottom_item_view, (ViewGroup) null);
            this.eHF[i2 * 4] = this.eHE[i2].findViewById(t.g.line_top);
            this.eHF[(i2 * 4) + 1] = this.eHE[i2].findViewById(t.g.line_left);
            this.eHF[(i2 * 4) + 2] = this.eHE[i2].findViewById(t.g.line_right);
            this.eHF[(i2 * 4) + 3] = this.eHE[i2].findViewById(t.g.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(t.g.item_iv);
    }

    public void aZp() {
        this.eHC = new Fragment[2];
        this.eHD = new String[2];
        this.eHC[0] = new ag();
        this.eHD[0] = this.eHt;
        this.eHC[1] = new e();
        this.eHD[1] = this.eHu;
    }

    public Fragment qt(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.eHC[i];
    }

    public String qu(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.eHD[i];
    }

    public void onChangeSkinType(int i) {
        this.eGS.getLayoutMode().ab(i == 1);
        this.eGS.getLayoutMode().x(this.cvW);
        for (int i2 = 0; i2 < this.eHC.length; i2++) {
            if (this.eHC[i2] != null && (this.eHC[i2] instanceof ag)) {
                ((ag) this.eHC[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button aZq() {
        return this.eHv;
    }

    public View aZr() {
        Fragment qt = qt(0);
        if (qt == null || !(qt instanceof ag)) {
            return null;
        }
        return ((ag) qt).aDR();
    }

    public View aZs() {
        Fragment qt = qt(1);
        if (qt == null || !(qt instanceof e)) {
            return null;
        }
        return ((e) qt).aDR();
    }

    public void o(boolean z, String str) {
        this.eHv.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.eHv.setText(str);
    }

    public void g(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.eHE.length;
            for (int i = 0; i < length; i++) {
                if (this.eHE[i] != null && (a = a(this.eHE[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.eHG, this.eHG));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eHG, this.eHG);
                    layoutParams.rightMargin = (int) this.eGS.getResources().getDimension(t.e.ds10);
                    this.eHE[i].setLayoutParams(layoutParams);
                    this.eHy.addView(this.eHE[i], this.eHy.getChildCount() - 1);
                    a((HorizontalScrollView) this.eHx);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.eHG, this.eHG));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.eGS.YO().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.eGS.YO().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.eHG, this.eHG));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.eHy.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.eHy.getChildAt(i) != null && (this.eHy.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.eHy.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.eHy.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void jp(boolean z) {
        if (this.eHA != null) {
            if (z) {
                this.eHA.setVisibility(0);
            } else {
                this.eHA.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.eHx != null) {
            if (this.anM == null) {
                this.anM = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.anM);
            this.mHandler.postDelayed(this.anM, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.anM != null) {
            this.mHandler.removeCallbacks(this.anM);
        }
        if (this.eGS.YO() != null) {
            this.eGS.YO().EU();
        }
    }

    public void qv(int i) {
        if (i == 1) {
            at.c(this.eHz, t.d.album_list_bottom_bigimage_bg, 0);
            at.k(this.eHv, t.f.post_button_bg_bigimage);
            at.c(this.eHA, t.f.btn_add_pic_bigimage, 0);
            at.d(this.eHw, t.d.album_list_bottom_bigimage_line, 0);
            for (View view : this.eHF) {
                at.d(view, t.d.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        at.k(this.eHz, t.d.album_list_bottom_bg);
        at.k(this.eHv, t.f.post_button_bg);
        at.k(this.eHA, t.f.btn_add_pic);
        at.l(this.eHw, t.d.album_list_bottom_line);
        for (View view2 : this.eHF) {
            at.l(view2, t.d.album_list_bottom_line);
        }
    }

    public void z(boolean z, boolean z2) {
        if (z) {
            this.eHB.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.eHB.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.eHB.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(eHs);
            if (j > 0) {
                sb.append("(");
                sb.append(ay.H(j));
                sb.append(")");
            }
            this.eHB.setText(sb.toString());
            return;
        }
        this.eHB.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.eHB.setText(eHs);
    }

    public View aZt() {
        return this.eHB;
    }
}
