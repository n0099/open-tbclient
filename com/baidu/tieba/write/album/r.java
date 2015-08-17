package com.baidu.tieba.write.album;

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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private Runnable aku;
    private ViewGroup bJv;
    private AlbumActivity cPQ;
    private HorizontalCustomScrollView cQA;
    private LinearLayout cQB;
    private RelativeLayout cQC;
    private ImageView cQD;
    private Fragment[] cQE;
    private String[] cQF;
    private FrameLayout[] cQG;
    private View[] cQH;
    private int cQI;
    private String cQw;
    private String cQx;
    private Button cQy;
    private View cQz;
    private Handler mHandler;

    public r(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.cQw = "tag_image";
        this.cQx = "tag_b_image";
        this.mHandler = new Handler();
        this.cPQ = albumActivity;
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(i.g.album_activity);
        this.bJv = (ViewGroup) albumActivity.findViewById(i.f.parent);
        this.cQy = (Button) albumActivity.findViewById(i.f.btn_done);
        this.cQy.setOnClickListener(albumActivity);
        this.cQA = (HorizontalCustomScrollView) albumActivity.findViewById(i.f.bottom_scroll);
        this.cQB = (LinearLayout) albumActivity.findViewById(i.f.bottom_container);
        this.cQC = (RelativeLayout) albumActivity.findViewById(i.f.lay_bottom);
        this.cQD = (ImageView) albumActivity.findViewById(i.f.add_more);
        this.cQz = albumActivity.findViewById(i.f.bottom_shadow);
        this.cQI = (int) this.cPQ.getResources().getDimension(i.d.ds90);
    }

    public void kk(int i) {
        this.cQG = new FrameLayout[i];
        this.cQH = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.cQG[i2] = (FrameLayout) LayoutInflater.from(this.cPQ.getPageContext().getPageActivity()).inflate(i.g.album_bottom_item_view, (ViewGroup) null);
            this.cQH[i2 * 4] = this.cQG[i2].findViewById(i.f.line_top);
            this.cQH[(i2 * 4) + 1] = this.cQG[i2].findViewById(i.f.line_left);
            this.cQH[(i2 * 4) + 2] = this.cQG[i2].findViewById(i.f.line_right);
            this.cQH[(i2 * 4) + 3] = this.cQG[i2].findViewById(i.f.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(i.f.item_iv);
    }

    public void atS() {
        this.cQE = new Fragment[2];
        this.cQF = new String[2];
        this.cQE[0] = new ad();
        this.cQF[0] = this.cQw;
        this.cQE[1] = new c();
        this.cQF[1] = this.cQx;
    }

    public Fragment kl(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cQE[i];
    }

    public String km(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cQF[i];
    }

    public void onChangeSkinType(int i) {
        this.cPQ.getLayoutMode().ad(i == 1);
        this.cPQ.getLayoutMode().k(this.bJv);
    }

    public Button atT() {
        return this.cQy;
    }

    public View atU() {
        Fragment kl = kl(0);
        if (kl == null || !(kl instanceof ad)) {
            return null;
        }
        return ((ad) kl).ahK();
    }

    public View atV() {
        Fragment kl = kl(1);
        if (kl == null || !(kl instanceof c)) {
            return null;
        }
        return ((c) kl).ahK();
    }

    public void k(boolean z, String str) {
        this.cQy.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.cQy.setText(str);
    }

    public void f(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.cQG.length;
            for (int i = 0; i < length; i++) {
                if (this.cQG[i] != null && (a = a(this.cQG[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.cQI, this.cQI));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cQI, this.cQI);
                    layoutParams.rightMargin = (int) this.cPQ.getResources().getDimension(i.d.ds10);
                    this.cQG[i].setLayoutParams(layoutParams);
                    this.cQB.addView(this.cQG[i], this.cQB.getChildCount() - 1);
                    a((HorizontalScrollView) this.cQA);
                    a.setOnClickListener(new s(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.cQI, this.cQI));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.cPQ.atB().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.cPQ.atB().a(imageFileInfo, new t(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.cQI, this.cQI));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.cQB.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.cQB.getChildAt(i) != null && (this.cQB.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.cQB.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.cQB.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void fT(boolean z) {
        if (this.cQD != null) {
            if (z) {
                this.cQD.setVisibility(0);
            } else {
                this.cQD.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.cQA != null) {
            if (this.aku == null) {
                this.aku = new u(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.aku);
            this.mHandler.postDelayed(this.aku, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.aku != null) {
            this.mHandler.removeCallbacks(this.aku);
        }
        if (this.cPQ.atB() != null) {
            this.cPQ.atB().Cl();
        }
    }

    public void kn(int i) {
        if (i == 1) {
            com.baidu.tbadk.core.util.al.c(this.cQC, i.c.album_list_bottom_bigimage_bg, 0);
            com.baidu.tbadk.core.util.al.i((View) this.cQy, i.e.post_button_bg_bigimage);
            com.baidu.tbadk.core.util.al.c(this.cQD, i.e.btn_add_pic_bigimage, 0);
            com.baidu.tbadk.core.util.al.d(this.cQz, i.c.album_list_bottom_bigimage_line, 0);
            for (View view : this.cQH) {
                com.baidu.tbadk.core.util.al.d(view, i.c.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        com.baidu.tbadk.core.util.al.i(this.cQC, i.c.album_list_bottom_bg);
        com.baidu.tbadk.core.util.al.i((View) this.cQy, i.e.post_button_bg);
        com.baidu.tbadk.core.util.al.i(this.cQD, i.e.btn_add_pic);
        com.baidu.tbadk.core.util.al.j(this.cQz, i.c.album_list_bottom_line);
        for (View view2 : this.cQH) {
            com.baidu.tbadk.core.util.al.j(view2, i.c.album_list_bottom_line);
        }
    }
}
