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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String gaH = TbadkCoreApplication.m9getInst().getResources().getString(t.j.original_img);
    private Runnable aoc;
    private ViewGroup dqN;
    private String gaI;
    private String gaJ;
    private Button gaK;
    private View gaL;
    private HorizontalCustomScrollView gaM;
    private LinearLayout gaN;
    private RelativeLayout gaO;
    private ImageView gaP;
    private TextView gaQ;
    private Fragment[] gaR;
    private String[] gaS;
    private FrameLayout[] gaT;
    private View[] gaU;
    private int gaV;
    private AlbumActivity gaf;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gaI = "tag_image";
        this.gaJ = "tag_b_image";
        this.mHandler = new Handler();
        this.gaf = albumActivity;
        e(albumActivity);
    }

    private void e(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(t.h.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.dqN = (ViewGroup) albumActivity.findViewById(t.g.parent);
        this.gaK = (Button) albumActivity.findViewById(t.g.btn_done);
        this.gaK.setOnClickListener(albumActivity);
        this.gaM = (HorizontalCustomScrollView) albumActivity.findViewById(t.g.bottom_scroll);
        this.gaN = (LinearLayout) albumActivity.findViewById(t.g.bottom_container);
        this.gaO = (RelativeLayout) albumActivity.findViewById(t.g.lay_bottom);
        this.gaP = (ImageView) albumActivity.findViewById(t.g.add_more);
        this.gaL = albumActivity.findViewById(t.g.bottom_shadow);
        this.gaQ = (TextView) albumActivity.findViewById(t.g.original_select_btn);
        this.gaQ.setOnClickListener(albumActivity);
        this.gaV = (int) this.gaf.getResources().getDimension(t.e.ds90);
    }

    public void sZ(int i) {
        this.gaT = new FrameLayout[i];
        this.gaU = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.gaT[i2] = (FrameLayout) LayoutInflater.from(this.gaf.getPageContext().getPageActivity()).inflate(t.h.album_bottom_item_view, (ViewGroup) null);
            this.gaU[i2 * 4] = this.gaT[i2].findViewById(t.g.line_top);
            this.gaU[(i2 * 4) + 1] = this.gaT[i2].findViewById(t.g.line_left);
            this.gaU[(i2 * 4) + 2] = this.gaT[i2].findViewById(t.g.line_right);
            this.gaU[(i2 * 4) + 3] = this.gaT[i2].findViewById(t.g.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(t.g.item_iv);
    }

    public void brT() {
        this.gaR = new Fragment[2];
        this.gaS = new String[2];
        this.gaR[0] = new ag();
        this.gaS[0] = this.gaI;
        this.gaR[1] = new e();
        this.gaS[1] = this.gaJ;
    }

    public Fragment ta(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gaR[i];
    }

    public String tb(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gaS[i];
    }

    public void onChangeSkinType(int i) {
        this.gaf.getLayoutMode().ah(i == 1);
        this.gaf.getLayoutMode().x(this.dqN);
        for (int i2 = 0; i2 < this.gaR.length; i2++) {
            if (this.gaR[i2] != null && (this.gaR[i2] instanceof ag)) {
                ((ag) this.gaR[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button brU() {
        return this.gaK;
    }

    public View brV() {
        Fragment ta = ta(0);
        if (ta == null || !(ta instanceof ag)) {
            return null;
        }
        return ((ag) ta).bdG();
    }

    public View brW() {
        Fragment ta = ta(1);
        if (ta == null || !(ta instanceof e)) {
            return null;
        }
        return ((e) ta).bdG();
    }

    public void n(boolean z, String str) {
        this.gaK.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.gaK.setText(str);
    }

    public void h(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.gaT.length;
            for (int i = 0; i < length; i++) {
                if (this.gaT[i] != null && (a = a(this.gaT[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.gaV, this.gaV));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.gaV, this.gaV);
                    layoutParams.rightMargin = (int) this.gaf.getResources().getDimension(t.e.ds10);
                    this.gaT[i].setLayoutParams(layoutParams);
                    this.gaN.addView(this.gaT[i], this.gaN.getChildCount() - 1);
                    a((HorizontalScrollView) this.gaM);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(this.gaV, this.gaV));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.gaf.akr().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.e(a);
                        return;
                    } else {
                        this.gaf.akr().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(this.gaV, this.gaV));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.gaN.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.gaN.getChildAt(i) != null && (this.gaN.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.gaN.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.gaN.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void lK(boolean z) {
        if (this.gaP != null) {
            if (z) {
                this.gaP.setVisibility(0);
            } else {
                this.gaP.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.gaM != null) {
            if (this.aoc == null) {
                this.aoc = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.aoc);
            this.mHandler.postDelayed(this.aoc, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.aoc != null) {
            this.mHandler.removeCallbacks(this.aoc);
        }
        if (this.gaf.akr() != null) {
            this.gaf.akr().Eq();
        }
    }

    public void tc(int i) {
        if (i == 1) {
            av.d(this.gaO, t.d.common_color_10100, 0);
            av.k(this.gaK, t.f.post_button_bg_bigimage);
            av.d(this.gaP, t.f.btn_add_pic_bigimage, 0);
            av.e(this.gaL, t.d.common_color_10101, 0);
            for (View view : this.gaU) {
                av.e(view, t.d.common_color_10101, 0);
            }
            return;
        }
        av.k(this.gaO, t.d.common_color_10099);
        av.k(this.gaK, t.f.post_button_bg);
        av.k(this.gaP, t.f.btn_add_pic);
        av.l(this.gaL, t.d.cp_cont_e);
        for (View view2 : this.gaU) {
            av.l(view2, t.d.cp_cont_e);
        }
    }

    public void C(boolean z, boolean z2) {
        if (z) {
            this.gaQ.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.gaQ.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.gaQ.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(gaH);
            if (j > 0) {
                sb.append("(");
                sb.append(ba.H(j));
                sb.append(")");
            }
            this.gaQ.setText(sb.toString());
            return;
        }
        this.gaQ.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gaQ.setText(gaH);
    }

    public View brX() {
        return this.gaQ;
    }
}
