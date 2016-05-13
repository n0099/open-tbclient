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
    private static final String eYl = TbadkCoreApplication.m11getInst().getResources().getString(t.j.original_img);
    private Runnable ajA;
    private ViewGroup cwT;
    private AlbumActivity eXL;
    private String eYm;
    private String eYn;
    private Button eYo;
    private View eYp;
    private HorizontalCustomScrollView eYq;
    private LinearLayout eYr;
    private RelativeLayout eYs;
    private ImageView eYt;
    private TextView eYu;
    private Fragment[] eYv;
    private String[] eYw;
    private FrameLayout[] eYx;
    private View[] eYy;
    private int eYz;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.eYm = "tag_image";
        this.eYn = "tag_b_image";
        this.mHandler = new Handler();
        this.eXL = albumActivity;
        d(albumActivity);
    }

    private void d(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(t.h.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.cwT = (ViewGroup) albumActivity.findViewById(t.g.parent);
        this.eYo = (Button) albumActivity.findViewById(t.g.btn_done);
        this.eYo.setOnClickListener(albumActivity);
        this.eYq = (HorizontalCustomScrollView) albumActivity.findViewById(t.g.bottom_scroll);
        this.eYr = (LinearLayout) albumActivity.findViewById(t.g.bottom_container);
        this.eYs = (RelativeLayout) albumActivity.findViewById(t.g.lay_bottom);
        this.eYt = (ImageView) albumActivity.findViewById(t.g.add_more);
        this.eYp = albumActivity.findViewById(t.g.bottom_shadow);
        this.eYu = (TextView) albumActivity.findViewById(t.g.original_select_btn);
        this.eYu.setOnClickListener(albumActivity);
        this.eYz = (int) this.eXL.getResources().getDimension(t.e.ds90);
    }

    public void qN(int i) {
        this.eYx = new FrameLayout[i];
        this.eYy = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.eYx[i2] = (FrameLayout) LayoutInflater.from(this.eXL.getPageContext().getPageActivity()).inflate(t.h.album_bottom_item_view, (ViewGroup) null);
            this.eYy[i2 * 4] = this.eYx[i2].findViewById(t.g.line_top);
            this.eYy[(i2 * 4) + 1] = this.eYx[i2].findViewById(t.g.line_left);
            this.eYy[(i2 * 4) + 2] = this.eYx[i2].findViewById(t.g.line_right);
            this.eYy[(i2 * 4) + 3] = this.eYx[i2].findViewById(t.g.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(t.g.item_iv);
    }

    public void bbL() {
        this.eYv = new Fragment[2];
        this.eYw = new String[2];
        this.eYv[0] = new ag();
        this.eYw[0] = this.eYm;
        this.eYv[1] = new e();
        this.eYw[1] = this.eYn;
    }

    public Fragment qO(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.eYv[i];
    }

    public String qP(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.eYw[i];
    }

    public void onChangeSkinType(int i) {
        this.eXL.getLayoutMode().ae(i == 1);
        this.eXL.getLayoutMode().x(this.cwT);
        for (int i2 = 0; i2 < this.eYv.length; i2++) {
            if (this.eYv[i2] != null && (this.eYv[i2] instanceof ag)) {
                ((ag) this.eYv[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button bbM() {
        return this.eYo;
    }

    public View bbN() {
        Fragment qO = qO(0);
        if (qO == null || !(qO instanceof ag)) {
            return null;
        }
        return ((ag) qO).aEr();
    }

    public View bbO() {
        Fragment qO = qO(1);
        if (qO == null || !(qO instanceof e)) {
            return null;
        }
        return ((e) qO).aEr();
    }

    public void p(boolean z, String str) {
        this.eYo.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.eYo.setText(str);
    }

    public void g(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.eYx.length;
            for (int i = 0; i < length; i++) {
                if (this.eYx[i] != null && (a = a(this.eYx[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.eYz, this.eYz));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eYz, this.eYz);
                    layoutParams.rightMargin = (int) this.eXL.getResources().getDimension(t.e.ds10);
                    this.eYx[i].setLayoutParams(layoutParams);
                    this.eYr.addView(this.eYx[i], this.eYr.getChildCount() - 1);
                    a((HorizontalScrollView) this.eYq);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.eYz, this.eYz));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.eXL.YK().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.eXL.YK().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.eYz, this.eYz));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.eYr.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.eYr.getChildAt(i) != null && (this.eYr.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.eYr.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.eYr.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void kv(boolean z) {
        if (this.eYt != null) {
            if (z) {
                this.eYt.setVisibility(0);
            } else {
                this.eYt.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.eYq != null) {
            if (this.ajA == null) {
                this.ajA = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.ajA);
            this.mHandler.postDelayed(this.ajA, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.ajA != null) {
            this.mHandler.removeCallbacks(this.ajA);
        }
        if (this.eXL.YK() != null) {
            this.eXL.YK().CO();
        }
    }

    public void qQ(int i) {
        if (i == 1) {
            at.d(this.eYs, t.d.album_list_bottom_bigimage_bg, 0);
            at.k(this.eYo, t.f.post_button_bg_bigimage);
            at.d(this.eYt, t.f.btn_add_pic_bigimage, 0);
            at.e(this.eYp, t.d.album_list_bottom_bigimage_line, 0);
            for (View view : this.eYy) {
                at.e(view, t.d.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        at.k(this.eYs, t.d.album_list_bottom_bg);
        at.k(this.eYo, t.f.post_button_bg);
        at.k(this.eYt, t.f.btn_add_pic);
        at.l(this.eYp, t.d.album_list_bottom_line);
        for (View view2 : this.eYy) {
            at.l(view2, t.d.album_list_bottom_line);
        }
    }

    public void y(boolean z, boolean z2) {
        if (z) {
            this.eYu.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.eYu.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.eYu.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(eYl);
            if (j > 0) {
                sb.append("(");
                sb.append(ay.I(j));
                sb.append(")");
            }
            this.eYu.setText(sb.toString());
            return;
        }
        this.eYu.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.eYu.setText(eYl);
    }

    public View bbP() {
        return this.eYu;
    }
}
