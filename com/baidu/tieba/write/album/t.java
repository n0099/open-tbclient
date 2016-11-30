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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String gkv = TbadkCoreApplication.m9getInst().getResources().getString(r.j.original_img);
    private Runnable aoE;
    private ViewGroup cSX;
    private AlbumActivity gjT;
    private HorizontalCustomScrollView gkA;
    private LinearLayout gkB;
    private RelativeLayout gkC;
    private ImageView gkD;
    private TextView gkE;
    private Fragment[] gkF;
    private String[] gkG;
    private FrameLayout[] gkH;
    private View[] gkI;
    private int gkJ;
    private String gkw;
    private String gkx;
    private Button gky;
    private View gkz;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gkw = "tag_image";
        this.gkx = "tag_b_image";
        this.mHandler = new Handler();
        this.gjT = albumActivity;
        e(albumActivity);
    }

    private void e(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(r.h.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.cSX = (ViewGroup) albumActivity.findViewById(r.g.parent);
        this.gky = (Button) albumActivity.findViewById(r.g.btn_done);
        this.gky.setOnClickListener(albumActivity);
        this.gkA = (HorizontalCustomScrollView) albumActivity.findViewById(r.g.bottom_scroll);
        this.gkB = (LinearLayout) albumActivity.findViewById(r.g.bottom_container);
        this.gkC = (RelativeLayout) albumActivity.findViewById(r.g.lay_bottom);
        this.gkD = (ImageView) albumActivity.findViewById(r.g.add_more);
        this.gkz = albumActivity.findViewById(r.g.bottom_shadow);
        this.gkE = (TextView) albumActivity.findViewById(r.g.original_select_btn);
        this.gkE.setOnClickListener(albumActivity);
        this.gkJ = (int) this.gjT.getResources().getDimension(r.e.ds90);
    }

    public void tJ(int i) {
        this.gkH = new FrameLayout[i];
        this.gkI = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.gkH[i2] = (FrameLayout) LayoutInflater.from(this.gjT.getPageContext().getPageActivity()).inflate(r.h.album_bottom_item_view, (ViewGroup) null);
            this.gkI[i2 * 4] = this.gkH[i2].findViewById(r.g.line_top);
            this.gkI[(i2 * 4) + 1] = this.gkH[i2].findViewById(r.g.line_left);
            this.gkI[(i2 * 4) + 2] = this.gkH[i2].findViewById(r.g.line_right);
            this.gkI[(i2 * 4) + 3] = this.gkH[i2].findViewById(r.g.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(r.g.item_iv);
    }

    public void buU() {
        this.gkF = new Fragment[2];
        this.gkG = new String[2];
        this.gkF[0] = new ag();
        this.gkG[0] = this.gkw;
        this.gkF[1] = new e();
        this.gkG[1] = this.gkx;
    }

    public Fragment tK(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gkF[i];
    }

    public String tL(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gkG[i];
    }

    public void onChangeSkinType(int i) {
        this.gjT.getLayoutMode().ai(i == 1);
        this.gjT.getLayoutMode().x(this.cSX);
        for (int i2 = 0; i2 < this.gkF.length; i2++) {
            if (this.gkF[i2] != null && (this.gkF[i2] instanceof ag)) {
                ((ag) this.gkF[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button buV() {
        return this.gky;
    }

    public View buW() {
        Fragment tK = tK(0);
        if (tK == null || !(tK instanceof ag)) {
            return null;
        }
        return ((ag) tK).bgN();
    }

    public View buX() {
        Fragment tK = tK(1);
        if (tK == null || !(tK instanceof e)) {
            return null;
        }
        return ((e) tK).bgN();
    }

    public void o(boolean z, String str) {
        this.gky.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.gky.setText(str);
    }

    public void h(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.gkH.length;
            for (int i = 0; i < length; i++) {
                if (this.gkH[i] != null && (a = a(this.gkH[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.gkJ, this.gkJ));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.gkJ, this.gkJ);
                    layoutParams.rightMargin = (int) this.gjT.getResources().getDimension(r.e.ds10);
                    this.gkH[i].setLayoutParams(layoutParams);
                    this.gkB.addView(this.gkH[i], this.gkB.getChildCount() - 1);
                    a((HorizontalScrollView) this.gkA);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(this.gkJ, this.gkJ));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.gjT.amA().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.e(a);
                        return;
                    } else {
                        this.gjT.amA().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(this.gkJ, this.gkJ));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.gkB.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.gkB.getChildAt(i) != null && (this.gkB.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.gkB.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.gkB.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void ml(boolean z) {
        if (this.gkD != null) {
            if (z) {
                this.gkD.setVisibility(0);
            } else {
                this.gkD.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.gkA != null) {
            if (this.aoE == null) {
                this.aoE = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.aoE);
            this.mHandler.postDelayed(this.aoE, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.aoE != null) {
            this.mHandler.removeCallbacks(this.aoE);
        }
        if (this.gjT.amA() != null) {
            this.gjT.amA().Ev();
        }
    }

    public void tM(int i) {
        if (i == 1) {
            at.d(this.gkC, r.d.common_color_10100, 0);
            at.k(this.gky, r.f.post_button_bg_bigimage);
            at.d(this.gkD, r.f.btn_add_pic_bigimage, 0);
            at.e(this.gkz, r.d.common_color_10101, 0);
            for (View view : this.gkI) {
                at.e(view, r.d.common_color_10101, 0);
            }
            return;
        }
        at.k(this.gkC, r.d.common_color_10099);
        at.k(this.gky, r.f.post_button_bg);
        at.k(this.gkD, r.f.btn_add_pic);
        at.l(this.gkz, r.d.cp_cont_e);
        for (View view2 : this.gkI) {
            at.l(view2, r.d.cp_cont_e);
        }
    }

    public void G(boolean z, boolean z2) {
        if (z) {
            this.gkE.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.gkE.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.gkE.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(gkv);
            if (j > 0) {
                sb.append("(");
                sb.append(ax.H(j));
                sb.append(")");
            }
            this.gkE.setText(sb.toString());
            return;
        }
        this.gkE.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gkE.setText(gkv);
    }

    public View buY() {
        return this.gkE;
    }
}
