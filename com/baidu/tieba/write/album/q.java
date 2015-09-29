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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String dkd = TbadkCoreApplication.m411getInst().getResources().getString(i.h.original_img);
    private Runnable ajF;
    private ViewGroup bNh;
    private AlbumActivity djw;
    private String dke;
    private String dkf;
    private Button dkg;
    private View dkh;
    private HorizontalCustomScrollView dki;
    private LinearLayout dkj;
    private RelativeLayout dkk;
    private ImageView dkl;
    private TextView dkm;
    private Fragment[] dkn;
    private String[] dko;
    private FrameLayout[] dkp;
    private View[] dkq;
    private int dkr;
    private Handler mHandler;

    public q(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.dke = "tag_image";
        this.dkf = "tag_b_image";
        this.mHandler = new Handler();
        this.djw = albumActivity;
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(i.g.album_activity);
        this.bNh = (ViewGroup) albumActivity.findViewById(i.f.parent);
        this.dkg = (Button) albumActivity.findViewById(i.f.btn_done);
        this.dkg.setOnClickListener(albumActivity);
        this.dki = (HorizontalCustomScrollView) albumActivity.findViewById(i.f.bottom_scroll);
        this.dkj = (LinearLayout) albumActivity.findViewById(i.f.bottom_container);
        this.dkk = (RelativeLayout) albumActivity.findViewById(i.f.lay_bottom);
        this.dkl = (ImageView) albumActivity.findViewById(i.f.add_more);
        this.dkh = albumActivity.findViewById(i.f.bottom_shadow);
        this.dkm = (TextView) albumActivity.findViewById(i.f.original_select_btn);
        this.dkm.setOnClickListener(albumActivity);
        this.dkr = (int) this.djw.getResources().getDimension(i.d.ds90);
    }

    public void lK(int i) {
        this.dkp = new FrameLayout[i];
        this.dkq = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.dkp[i2] = (FrameLayout) LayoutInflater.from(this.djw.getPageContext().getPageActivity()).inflate(i.g.album_bottom_item_view, (ViewGroup) null);
            this.dkq[i2 * 4] = this.dkp[i2].findViewById(i.f.line_top);
            this.dkq[(i2 * 4) + 1] = this.dkp[i2].findViewById(i.f.line_left);
            this.dkq[(i2 * 4) + 2] = this.dkp[i2].findViewById(i.f.line_right);
            this.dkq[(i2 * 4) + 3] = this.dkp[i2].findViewById(i.f.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(i.f.item_iv);
    }

    public void aBq() {
        this.dkn = new Fragment[2];
        this.dko = new String[2];
        this.dkn[0] = new ac();
        this.dko[0] = this.dke;
        this.dkn[1] = new b();
        this.dko[1] = this.dkf;
    }

    public Fragment lL(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dkn[i];
    }

    public String lM(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dko[i];
    }

    public void onChangeSkinType(int i) {
        this.djw.getLayoutMode().ad(i == 1);
        this.djw.getLayoutMode().k(this.bNh);
    }

    public Button aBr() {
        return this.dkg;
    }

    public View aBs() {
        Fragment lL = lL(0);
        if (lL == null || !(lL instanceof ac)) {
            return null;
        }
        return ((ac) lL).akd();
    }

    public View aBt() {
        Fragment lL = lL(1);
        if (lL == null || !(lL instanceof b)) {
            return null;
        }
        return ((b) lL).akd();
    }

    public void n(boolean z, String str) {
        this.dkg.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.dkg.setText(str);
    }

    public void f(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.dkp.length;
            for (int i = 0; i < length; i++) {
                if (this.dkp[i] != null && (a = a(this.dkp[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.dkr, this.dkr));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dkr, this.dkr);
                    layoutParams.rightMargin = (int) this.djw.getResources().getDimension(i.d.ds10);
                    this.dkp[i].setLayoutParams(layoutParams);
                    this.dkj.addView(this.dkp[i], this.dkj.getChildCount() - 1);
                    a((HorizontalScrollView) this.dki);
                    a.setOnClickListener(new r(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.dkr, this.dkr));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.djw.aAV().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.djw.aAV().a(imageFileInfo, new s(this, imageFileInfo), false);
                        return;
                    }
                }
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo) {
        FrameLayout frameLayout;
        TbImageView a;
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.dkr, this.dkr));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.dkj.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.dkj.getChildAt(i) != null && (this.dkj.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.dkj.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.dkj.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void gT(boolean z) {
        if (this.dkl != null) {
            if (z) {
                this.dkl.setVisibility(0);
            } else {
                this.dkl.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.dki != null) {
            if (this.ajF == null) {
                this.ajF = new t(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.ajF);
            this.mHandler.postDelayed(this.ajF, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.ajF != null) {
            this.mHandler.removeCallbacks(this.ajF);
        }
        if (this.djw.aAV() != null) {
            this.djw.aAV().Cm();
        }
    }

    public void lN(int i) {
        if (i == 1) {
            am.c(this.dkk, i.c.album_list_bottom_bigimage_bg, 0);
            am.i((View) this.dkg, i.e.post_button_bg_bigimage);
            am.c(this.dkl, i.e.btn_add_pic_bigimage, 0);
            am.d(this.dkh, i.c.album_list_bottom_bigimage_line, 0);
            for (View view : this.dkq) {
                am.d(view, i.c.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        am.i(this.dkk, i.c.album_list_bottom_bg);
        am.i((View) this.dkg, i.e.post_button_bg);
        am.i(this.dkl, i.e.btn_add_pic);
        am.j(this.dkh, i.c.album_list_bottom_line);
        for (View view2 : this.dkq) {
            am.j(view2, i.c.album_list_bottom_line);
        }
    }

    public void q(boolean z, boolean z2) {
        if (z) {
            this.dkm.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.dkm.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.dkm.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(dkd);
            if (j > 0) {
                sb.append("(");
                sb.append(ar.y(j));
                sb.append(")");
            }
            this.dkm.setText(sb.toString());
            return;
        }
        this.dkm.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.dkm.setText(dkd);
    }

    public View aBu() {
        return this.dkm;
    }
}
