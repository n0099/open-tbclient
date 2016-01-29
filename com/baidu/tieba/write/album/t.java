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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String env = TbadkCoreApplication.m411getInst().getResources().getString(t.j.original_img);
    private Runnable anv;
    private ViewGroup clt;
    private AlbumActivity emU;
    private HorizontalCustomScrollView enA;
    private LinearLayout enB;
    private RelativeLayout enC;
    private ImageView enD;
    private TextView enE;
    private Fragment[] enF;
    private String[] enG;
    private FrameLayout[] enH;
    private View[] enI;
    private int enJ;
    private String enw;
    private String enx;
    private Button eny;
    private View enz;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.enw = "tag_image";
        this.enx = "tag_b_image";
        this.mHandler = new Handler();
        this.emU = albumActivity;
        d(albumActivity);
    }

    private void d(AlbumActivity albumActivity) {
        albumActivity.setContentView(t.h.album_activity);
        this.clt = (ViewGroup) albumActivity.findViewById(t.g.parent);
        this.eny = (Button) albumActivity.findViewById(t.g.btn_done);
        this.eny.setOnClickListener(albumActivity);
        this.enA = (HorizontalCustomScrollView) albumActivity.findViewById(t.g.bottom_scroll);
        this.enB = (LinearLayout) albumActivity.findViewById(t.g.bottom_container);
        this.enC = (RelativeLayout) albumActivity.findViewById(t.g.lay_bottom);
        this.enD = (ImageView) albumActivity.findViewById(t.g.add_more);
        this.enz = albumActivity.findViewById(t.g.bottom_shadow);
        this.enE = (TextView) albumActivity.findViewById(t.g.original_select_btn);
        this.enE.setOnClickListener(albumActivity);
        this.enJ = (int) this.emU.getResources().getDimension(t.e.ds90);
    }

    public void pz(int i) {
        this.enH = new FrameLayout[i];
        this.enI = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.enH[i2] = (FrameLayout) LayoutInflater.from(this.emU.getPageContext().getPageActivity()).inflate(t.h.album_bottom_item_view, (ViewGroup) null);
            this.enI[i2 * 4] = this.enH[i2].findViewById(t.g.line_top);
            this.enI[(i2 * 4) + 1] = this.enH[i2].findViewById(t.g.line_left);
            this.enI[(i2 * 4) + 2] = this.enH[i2].findViewById(t.g.line_right);
            this.enI[(i2 * 4) + 3] = this.enH[i2].findViewById(t.g.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(t.g.item_iv);
    }

    public void aSP() {
        this.enF = new Fragment[2];
        this.enG = new String[2];
        this.enF[0] = new ag();
        this.enG[0] = this.enw;
        this.enF[1] = new e();
        this.enG[1] = this.enx;
    }

    public Fragment pA(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.enF[i];
    }

    public String pB(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.enG[i];
    }

    public void onChangeSkinType(int i) {
        this.emU.getLayoutMode().ac(i == 1);
        this.emU.getLayoutMode().x(this.clt);
        for (int i2 = 0; i2 < this.enF.length; i2++) {
            if (this.enF[i2] != null && (this.enF[i2] instanceof ag)) {
                ((ag) this.enF[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button aSQ() {
        return this.eny;
    }

    public View aSR() {
        Fragment pA = pA(0);
        if (pA == null || !(pA instanceof ag)) {
            return null;
        }
        return ((ag) pA).awm();
    }

    public View aSS() {
        Fragment pA = pA(1);
        if (pA == null || !(pA instanceof e)) {
            return null;
        }
        return ((e) pA).awm();
    }

    public void p(boolean z, String str) {
        this.eny.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.eny.setText(str);
    }

    public void e(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.enH.length;
            for (int i = 0; i < length; i++) {
                if (this.enH[i] != null && (a = a(this.enH[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.enJ, this.enJ));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.enJ, this.enJ);
                    layoutParams.rightMargin = (int) this.emU.getResources().getDimension(t.e.ds10);
                    this.enH[i].setLayoutParams(layoutParams);
                    this.enB.addView(this.enH[i], this.enB.getChildCount() - 1);
                    a((HorizontalScrollView) this.enA);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.G(this.enJ, this.enJ));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.emU.aSw().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.emU.aSw().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.G(this.enJ, this.enJ));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.enB.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.enB.getChildAt(i) != null && (this.enB.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.enB.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.enB.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void iz(boolean z) {
        if (this.enD != null) {
            if (z) {
                this.enD.setVisibility(0);
            } else {
                this.enD.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.enA != null) {
            if (this.anv == null) {
                this.anv = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.anv);
            this.mHandler.postDelayed(this.anv, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.anv != null) {
            this.mHandler.removeCallbacks(this.anv);
        }
        if (this.emU.aSw() != null) {
            this.emU.aSw().Ej();
        }
    }

    public void pC(int i) {
        if (i == 1) {
            ar.c(this.enC, t.d.album_list_bottom_bigimage_bg, 0);
            ar.k(this.eny, t.f.post_button_bg_bigimage);
            ar.c(this.enD, t.f.btn_add_pic_bigimage, 0);
            ar.d(this.enz, t.d.album_list_bottom_bigimage_line, 0);
            for (View view : this.enI) {
                ar.d(view, t.d.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        ar.k(this.enC, t.d.album_list_bottom_bg);
        ar.k(this.eny, t.f.post_button_bg);
        ar.k(this.enD, t.f.btn_add_pic);
        ar.l(this.enz, t.d.album_list_bottom_line);
        for (View view2 : this.enI) {
            ar.l(view2, t.d.album_list_bottom_line);
        }
    }

    public void x(boolean z, boolean z2) {
        if (z) {
            this.enE.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.enE.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.enE.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(env);
            if (j > 0) {
                sb.append("(");
                sb.append(aw.F(j));
                sb.append(")");
            }
            this.enE.setText(sb.toString());
            return;
        }
        this.enE.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.enE.setText(env);
    }

    public View aST() {
        return this.enE;
    }
}
