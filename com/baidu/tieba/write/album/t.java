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
    private static final String eYm = TbadkCoreApplication.m11getInst().getResources().getString(t.j.original_img);
    private Runnable ajA;
    private ViewGroup cwT;
    private AlbumActivity eXM;
    private int eYA;
    private String eYn;
    private String eYo;
    private Button eYp;
    private View eYq;
    private HorizontalCustomScrollView eYr;
    private LinearLayout eYs;
    private RelativeLayout eYt;
    private ImageView eYu;
    private TextView eYv;
    private Fragment[] eYw;
    private String[] eYx;
    private FrameLayout[] eYy;
    private View[] eYz;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.eYn = "tag_image";
        this.eYo = "tag_b_image";
        this.mHandler = new Handler();
        this.eXM = albumActivity;
        d(albumActivity);
    }

    private void d(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(t.h.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.cwT = (ViewGroup) albumActivity.findViewById(t.g.parent);
        this.eYp = (Button) albumActivity.findViewById(t.g.btn_done);
        this.eYp.setOnClickListener(albumActivity);
        this.eYr = (HorizontalCustomScrollView) albumActivity.findViewById(t.g.bottom_scroll);
        this.eYs = (LinearLayout) albumActivity.findViewById(t.g.bottom_container);
        this.eYt = (RelativeLayout) albumActivity.findViewById(t.g.lay_bottom);
        this.eYu = (ImageView) albumActivity.findViewById(t.g.add_more);
        this.eYq = albumActivity.findViewById(t.g.bottom_shadow);
        this.eYv = (TextView) albumActivity.findViewById(t.g.original_select_btn);
        this.eYv.setOnClickListener(albumActivity);
        this.eYA = (int) this.eXM.getResources().getDimension(t.e.ds90);
    }

    public void qO(int i) {
        this.eYy = new FrameLayout[i];
        this.eYz = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.eYy[i2] = (FrameLayout) LayoutInflater.from(this.eXM.getPageContext().getPageActivity()).inflate(t.h.album_bottom_item_view, (ViewGroup) null);
            this.eYz[i2 * 4] = this.eYy[i2].findViewById(t.g.line_top);
            this.eYz[(i2 * 4) + 1] = this.eYy[i2].findViewById(t.g.line_left);
            this.eYz[(i2 * 4) + 2] = this.eYy[i2].findViewById(t.g.line_right);
            this.eYz[(i2 * 4) + 3] = this.eYy[i2].findViewById(t.g.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(t.g.item_iv);
    }

    public void bbE() {
        this.eYw = new Fragment[2];
        this.eYx = new String[2];
        this.eYw[0] = new ag();
        this.eYx[0] = this.eYn;
        this.eYw[1] = new e();
        this.eYx[1] = this.eYo;
    }

    public Fragment qP(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.eYw[i];
    }

    public String qQ(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.eYx[i];
    }

    public void onChangeSkinType(int i) {
        this.eXM.getLayoutMode().ae(i == 1);
        this.eXM.getLayoutMode().x(this.cwT);
        for (int i2 = 0; i2 < this.eYw.length; i2++) {
            if (this.eYw[i2] != null && (this.eYw[i2] instanceof ag)) {
                ((ag) this.eYw[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button bbF() {
        return this.eYp;
    }

    public View bbG() {
        Fragment qP = qP(0);
        if (qP == null || !(qP instanceof ag)) {
            return null;
        }
        return ((ag) qP).aEo();
    }

    public View bbH() {
        Fragment qP = qP(1);
        if (qP == null || !(qP instanceof e)) {
            return null;
        }
        return ((e) qP).aEo();
    }

    public void p(boolean z, String str) {
        this.eYp.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.eYp.setText(str);
    }

    public void g(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.eYy.length;
            for (int i = 0; i < length; i++) {
                if (this.eYy[i] != null && (a = a(this.eYy[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.eYA, this.eYA));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eYA, this.eYA);
                    layoutParams.rightMargin = (int) this.eXM.getResources().getDimension(t.e.ds10);
                    this.eYy[i].setLayoutParams(layoutParams);
                    this.eYs.addView(this.eYy[i], this.eYs.getChildCount() - 1);
                    a((HorizontalScrollView) this.eYr);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.eYA, this.eYA));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.eXM.YI().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.eXM.YI().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.eYA, this.eYA));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.eYs.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.eYs.getChildAt(i) != null && (this.eYs.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.eYs.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.eYs.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void kv(boolean z) {
        if (this.eYu != null) {
            if (z) {
                this.eYu.setVisibility(0);
            } else {
                this.eYu.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.eYr != null) {
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
        if (this.eXM.YI() != null) {
            this.eXM.YI().CN();
        }
    }

    public void qR(int i) {
        if (i == 1) {
            at.d(this.eYt, t.d.album_list_bottom_bigimage_bg, 0);
            at.k(this.eYp, t.f.post_button_bg_bigimage);
            at.d(this.eYu, t.f.btn_add_pic_bigimage, 0);
            at.e(this.eYq, t.d.album_list_bottom_bigimage_line, 0);
            for (View view : this.eYz) {
                at.e(view, t.d.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        at.k(this.eYt, t.d.album_list_bottom_bg);
        at.k(this.eYp, t.f.post_button_bg);
        at.k(this.eYu, t.f.btn_add_pic);
        at.l(this.eYq, t.d.album_list_bottom_line);
        for (View view2 : this.eYz) {
            at.l(view2, t.d.album_list_bottom_line);
        }
    }

    public void y(boolean z, boolean z2) {
        if (z) {
            this.eYv.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.eYv.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.eYv.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(eYm);
            if (j > 0) {
                sb.append("(");
                sb.append(ay.I(j));
                sb.append(")");
            }
            this.eYv.setText(sb.toString());
            return;
        }
        this.eYv.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.eYv.setText(eYm);
    }

    public View bbI() {
        return this.eYv;
    }
}
