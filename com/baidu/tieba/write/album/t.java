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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String fQC = TbadkCoreApplication.m10getInst().getResources().getString(u.j.original_img);
    private Runnable akV;
    private ViewGroup dfg;
    private String fQD;
    private String fQE;
    private Button fQF;
    private View fQG;
    private HorizontalCustomScrollView fQH;
    private LinearLayout fQI;
    private RelativeLayout fQJ;
    private ImageView fQK;
    private TextView fQL;
    private Fragment[] fQM;
    private String[] fQN;
    private FrameLayout[] fQO;
    private View[] fQP;
    private int fQQ;
    private AlbumActivity fQb;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.fQD = "tag_image";
        this.fQE = "tag_b_image";
        this.mHandler = new Handler();
        this.fQb = albumActivity;
        e(albumActivity);
    }

    private void e(AlbumActivity albumActivity) {
        View inflate = LayoutInflater.from(albumActivity.getPageContext().getPageActivity()).inflate(u.h.album_activity, (ViewGroup) null);
        if (Build.VERSION.SDK_INT < 16) {
            inflate.setLayerType(1, null);
        }
        albumActivity.setContentView(inflate);
        this.dfg = (ViewGroup) albumActivity.findViewById(u.g.parent);
        this.fQF = (Button) albumActivity.findViewById(u.g.btn_done);
        this.fQF.setOnClickListener(albumActivity);
        this.fQH = (HorizontalCustomScrollView) albumActivity.findViewById(u.g.bottom_scroll);
        this.fQI = (LinearLayout) albumActivity.findViewById(u.g.bottom_container);
        this.fQJ = (RelativeLayout) albumActivity.findViewById(u.g.lay_bottom);
        this.fQK = (ImageView) albumActivity.findViewById(u.g.add_more);
        this.fQG = albumActivity.findViewById(u.g.bottom_shadow);
        this.fQL = (TextView) albumActivity.findViewById(u.g.original_select_btn);
        this.fQL.setOnClickListener(albumActivity);
        this.fQQ = (int) this.fQb.getResources().getDimension(u.e.ds90);
    }

    public void sy(int i) {
        this.fQO = new FrameLayout[i];
        this.fQP = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.fQO[i2] = (FrameLayout) LayoutInflater.from(this.fQb.getPageContext().getPageActivity()).inflate(u.h.album_bottom_item_view, (ViewGroup) null);
            this.fQP[i2 * 4] = this.fQO[i2].findViewById(u.g.line_top);
            this.fQP[(i2 * 4) + 1] = this.fQO[i2].findViewById(u.g.line_left);
            this.fQP[(i2 * 4) + 2] = this.fQO[i2].findViewById(u.g.line_right);
            this.fQP[(i2 * 4) + 3] = this.fQO[i2].findViewById(u.g.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(u.g.item_iv);
    }

    public void bnD() {
        this.fQM = new Fragment[2];
        this.fQN = new String[2];
        this.fQM[0] = new ag();
        this.fQN[0] = this.fQD;
        this.fQM[1] = new e();
        this.fQN[1] = this.fQE;
    }

    public Fragment sz(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fQM[i];
    }

    public String sA(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fQN[i];
    }

    public void onChangeSkinType(int i) {
        this.fQb.getLayoutMode().af(i == 1);
        this.fQb.getLayoutMode().w(this.dfg);
        for (int i2 = 0; i2 < this.fQM.length; i2++) {
            if (this.fQM[i2] != null && (this.fQM[i2] instanceof ag)) {
                ((ag) this.fQM[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button bnE() {
        return this.fQF;
    }

    public View bnF() {
        Fragment sz = sz(0);
        if (sz == null || !(sz instanceof ag)) {
            return null;
        }
        return ((ag) sz).aQp();
    }

    public View bnG() {
        Fragment sz = sz(1);
        if (sz == null || !(sz instanceof e)) {
            return null;
        }
        return ((e) sz).aQp();
    }

    public void o(boolean z, String str) {
        this.fQF.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.fQF.setText(str);
    }

    public void h(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.fQO.length;
            for (int i = 0; i < length; i++) {
                if (this.fQO[i] != null && (a = a(this.fQO[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.fQQ, this.fQQ));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fQQ, this.fQQ);
                    layoutParams.rightMargin = (int) this.fQb.getResources().getDimension(u.e.ds10);
                    this.fQO[i].setLayoutParams(layoutParams);
                    this.fQI.addView(this.fQO[i], this.fQI.getChildCount() - 1);
                    a((HorizontalScrollView) this.fQH);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.fQQ, this.fQQ));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.fQb.afG().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.e(a);
                        return;
                    } else {
                        this.fQb.afG().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.fQQ, this.fQQ));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.fQI.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.fQI.getChildAt(i) != null && (this.fQI.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.fQI.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.fQI.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void lu(boolean z) {
        if (this.fQK != null) {
            if (z) {
                this.fQK.setVisibility(0);
            } else {
                this.fQK.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.fQH != null) {
            if (this.akV == null) {
                this.akV = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.akV);
            this.mHandler.postDelayed(this.akV, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.akV != null) {
            this.mHandler.removeCallbacks(this.akV);
        }
        if (this.fQb.afG() != null) {
            this.fQb.afG().CV();
        }
    }

    public void sB(int i) {
        if (i == 1) {
            av.d(this.fQJ, u.d.common_color_10100, 0);
            av.k(this.fQF, u.f.post_button_bg_bigimage);
            av.d(this.fQK, u.f.btn_add_pic_bigimage, 0);
            av.e(this.fQG, u.d.common_color_10101, 0);
            for (View view : this.fQP) {
                av.e(view, u.d.common_color_10101, 0);
            }
            return;
        }
        av.k(this.fQJ, u.d.common_color_10099);
        av.k(this.fQF, u.f.post_button_bg);
        av.k(this.fQK, u.f.btn_add_pic);
        av.l(this.fQG, u.d.cp_cont_e);
        for (View view2 : this.fQP) {
            av.l(view2, u.d.cp_cont_e);
        }
    }

    public void z(boolean z, boolean z2) {
        if (z) {
            this.fQL.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.fQL.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.fQL.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(fQC);
            if (j > 0) {
                sb.append("(");
                sb.append(ba.G(j));
                sb.append(")");
            }
            this.fQL.setText(sb.toString());
            return;
        }
        this.fQL.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fQL.setText(fQC);
    }

    public View bnH() {
        return this.fQL;
    }
}
