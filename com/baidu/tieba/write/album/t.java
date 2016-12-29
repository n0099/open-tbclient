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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String fyX = TbadkCoreApplication.m9getInst().getResources().getString(r.j.original_img);
    private Runnable aog;
    private ViewGroup cyf;
    private String fyY;
    private String fyZ;
    private AlbumActivity fyo;
    private Button fza;
    private View fzb;
    private HorizontalCustomScrollView fzc;
    private LinearLayout fzd;
    private RelativeLayout fze;
    private ImageView fzf;
    private TextView fzg;
    private Fragment[] fzh;
    private String[] fzi;
    private FrameLayout[] fzj;
    private View[] fzk;
    private int fzl;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.fyY = "tag_image";
        this.fyZ = "tag_b_image";
        this.mHandler = new Handler();
        this.fyo = albumActivity;
        e(albumActivity);
    }

    private void e(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(r.h.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.cyf = (ViewGroup) albumActivity.findViewById(r.g.parent);
        this.fza = (Button) albumActivity.findViewById(r.g.btn_done);
        this.fza.setOnClickListener(albumActivity);
        this.fzc = (HorizontalCustomScrollView) albumActivity.findViewById(r.g.bottom_scroll);
        this.fzd = (LinearLayout) albumActivity.findViewById(r.g.bottom_container);
        this.fze = (RelativeLayout) albumActivity.findViewById(r.g.lay_bottom);
        this.fzf = (ImageView) albumActivity.findViewById(r.g.add_more);
        this.fzb = albumActivity.findViewById(r.g.bottom_shadow);
        this.fzg = (TextView) albumActivity.findViewById(r.g.original_select_btn);
        this.fzg.setOnClickListener(albumActivity);
        this.fzl = (int) this.fyo.getResources().getDimension(r.e.ds90);
    }

    public void si(int i) {
        this.fzj = new FrameLayout[i];
        this.fzk = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.fzj[i2] = (FrameLayout) LayoutInflater.from(this.fyo.getPageContext().getPageActivity()).inflate(r.h.album_bottom_item_view, (ViewGroup) null);
            this.fzk[i2 * 4] = this.fzj[i2].findViewById(r.g.line_top);
            this.fzk[(i2 * 4) + 1] = this.fzj[i2].findViewById(r.g.line_left);
            this.fzk[(i2 * 4) + 2] = this.fzj[i2].findViewById(r.g.line_right);
            this.fzk[(i2 * 4) + 3] = this.fzj[i2].findViewById(r.g.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(r.g.item_iv);
    }

    public void blP() {
        this.fzh = new Fragment[2];
        this.fzi = new String[2];
        this.fzh[0] = new ag();
        this.fzi[0] = this.fyY;
        this.fzh[1] = new e();
        this.fzi[1] = this.fyZ;
    }

    public Fragment sj(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fzh[i];
    }

    public String sk(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fzi[i];
    }

    public void onChangeSkinType(int i) {
        this.fyo.getLayoutMode().ai(i == 1);
        this.fyo.getLayoutMode().x(this.cyf);
        for (int i2 = 0; i2 < this.fzh.length; i2++) {
            if (this.fzh[i2] != null && (this.fzh[i2] instanceof ag)) {
                ((ag) this.fzh[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button blQ() {
        return this.fza;
    }

    public View blR() {
        Fragment sj = sj(0);
        if (sj == null || !(sj instanceof ag)) {
            return null;
        }
        return ((ag) sj).baC();
    }

    public View blS() {
        Fragment sj = sj(1);
        if (sj == null || !(sj instanceof e)) {
            return null;
        }
        return ((e) sj).baC();
    }

    public void o(boolean z, String str) {
        this.fza.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.fza.setText(str);
    }

    public void g(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.fzj.length;
            for (int i = 0; i < length; i++) {
                if (this.fzj[i] != null && (a = a(this.fzj[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.fzl, this.fzl));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fzl, this.fzl);
                    layoutParams.rightMargin = (int) this.fyo.getResources().getDimension(r.e.ds10);
                    this.fzj[i].setLayoutParams(layoutParams);
                    this.fzd.addView(this.fzj[i], this.fzd.getChildCount() - 1);
                    a((HorizontalScrollView) this.fzc);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(this.fzl, this.fzl));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.fyo.ahb().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.e(a);
                        return;
                    } else {
                        this.fyo.ahb().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(this.fzl, this.fzl));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.fzd.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.fzd.getChildAt(i) != null && (this.fzd.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.fzd.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.fzd.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void lz(boolean z) {
        if (this.fzf != null) {
            if (z) {
                this.fzf.setVisibility(0);
            } else {
                this.fzf.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.fzc != null) {
            if (this.aog == null) {
                this.aog = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.aog);
            this.mHandler.postDelayed(this.aog, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.aog != null) {
            this.mHandler.removeCallbacks(this.aog);
        }
        if (this.fyo.ahb() != null) {
            this.fyo.ahb().Ed();
        }
    }

    public void sl(int i) {
        if (i == 1) {
            ar.d(this.fze, r.d.common_color_10100, 0);
            ar.k(this.fza, r.f.post_button_bg_bigimage);
            ar.d(this.fzf, r.f.btn_add_pic_bigimage, 0);
            ar.e(this.fzb, r.d.common_color_10101, 0);
            for (View view : this.fzk) {
                ar.e(view, r.d.common_color_10101, 0);
            }
            return;
        }
        ar.k(this.fze, r.d.common_color_10099);
        ar.k(this.fza, r.f.post_button_bg);
        ar.k(this.fzf, r.f.btn_add_pic);
        ar.l(this.fzb, r.d.cp_cont_e);
        for (View view2 : this.fzk) {
            ar.l(view2, r.d.cp_cont_e);
        }
    }

    public void H(boolean z, boolean z2) {
        if (z) {
            this.fzg.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.fzg.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.fzg.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(fyX);
            if (j > 0) {
                sb.append("(");
                sb.append(av.G(j));
                sb.append(")");
            }
            this.fzg.setText(sb.toString());
            return;
        }
        this.fzg.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fzg.setText(fyX);
    }

    public View blT() {
        return this.fzg;
    }
}
