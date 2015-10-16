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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String dkD = TbadkCoreApplication.m411getInst().getResources().getString(i.h.original_img);
    private Runnable ajG;
    private ViewGroup bNs;
    private AlbumActivity djW;
    private String dkE;
    private String dkF;
    private Button dkG;
    private View dkH;
    private HorizontalCustomScrollView dkI;
    private LinearLayout dkJ;
    private RelativeLayout dkK;
    private ImageView dkL;
    private TextView dkM;
    private Fragment[] dkN;
    private String[] dkO;
    private FrameLayout[] dkP;
    private View[] dkQ;
    private int dkR;
    private Handler mHandler;

    public q(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.dkE = "tag_image";
        this.dkF = "tag_b_image";
        this.mHandler = new Handler();
        this.djW = albumActivity;
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(i.g.album_activity);
        this.bNs = (ViewGroup) albumActivity.findViewById(i.f.parent);
        this.dkG = (Button) albumActivity.findViewById(i.f.btn_done);
        this.dkG.setOnClickListener(albumActivity);
        this.dkI = (HorizontalCustomScrollView) albumActivity.findViewById(i.f.bottom_scroll);
        this.dkJ = (LinearLayout) albumActivity.findViewById(i.f.bottom_container);
        this.dkK = (RelativeLayout) albumActivity.findViewById(i.f.lay_bottom);
        this.dkL = (ImageView) albumActivity.findViewById(i.f.add_more);
        this.dkH = albumActivity.findViewById(i.f.bottom_shadow);
        this.dkM = (TextView) albumActivity.findViewById(i.f.original_select_btn);
        this.dkM.setOnClickListener(albumActivity);
        this.dkR = (int) this.djW.getResources().getDimension(i.d.ds90);
    }

    public void lM(int i) {
        this.dkP = new FrameLayout[i];
        this.dkQ = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.dkP[i2] = (FrameLayout) LayoutInflater.from(this.djW.getPageContext().getPageActivity()).inflate(i.g.album_bottom_item_view, (ViewGroup) null);
            this.dkQ[i2 * 4] = this.dkP[i2].findViewById(i.f.line_top);
            this.dkQ[(i2 * 4) + 1] = this.dkP[i2].findViewById(i.f.line_left);
            this.dkQ[(i2 * 4) + 2] = this.dkP[i2].findViewById(i.f.line_right);
            this.dkQ[(i2 * 4) + 3] = this.dkP[i2].findViewById(i.f.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(i.f.item_iv);
    }

    public void aBA() {
        this.dkN = new Fragment[2];
        this.dkO = new String[2];
        this.dkN[0] = new ac();
        this.dkO[0] = this.dkE;
        this.dkN[1] = new b();
        this.dkO[1] = this.dkF;
    }

    public Fragment lN(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dkN[i];
    }

    public String lO(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dkO[i];
    }

    public void onChangeSkinType(int i) {
        this.djW.getLayoutMode().ad(i == 1);
        this.djW.getLayoutMode().k(this.bNs);
    }

    public Button aBB() {
        return this.dkG;
    }

    public View aBC() {
        Fragment lN = lN(0);
        if (lN == null || !(lN instanceof ac)) {
            return null;
        }
        return ((ac) lN).akd();
    }

    public View aBD() {
        Fragment lN = lN(1);
        if (lN == null || !(lN instanceof b)) {
            return null;
        }
        return ((b) lN).akd();
    }

    public void n(boolean z, String str) {
        this.dkG.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.dkG.setText(str);
    }

    public void f(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.dkP.length;
            for (int i = 0; i < length; i++) {
                if (this.dkP[i] != null && (a = a(this.dkP[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.dkR, this.dkR));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dkR, this.dkR);
                    layoutParams.rightMargin = (int) this.djW.getResources().getDimension(i.d.ds10);
                    this.dkP[i].setLayoutParams(layoutParams);
                    this.dkJ.addView(this.dkP[i], this.dkJ.getChildCount() - 1);
                    a((HorizontalScrollView) this.dkI);
                    a.setOnClickListener(new r(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.dkR, this.dkR));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.djW.aBf().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.djW.aBf().a(imageFileInfo, new s(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.dkR, this.dkR));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.dkJ.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.dkJ.getChildAt(i) != null && (this.dkJ.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.dkJ.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.dkJ.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void gT(boolean z) {
        if (this.dkL != null) {
            if (z) {
                this.dkL.setVisibility(0);
            } else {
                this.dkL.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.dkI != null) {
            if (this.ajG == null) {
                this.ajG = new t(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.ajG);
            this.mHandler.postDelayed(this.ajG, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.ajG != null) {
            this.mHandler.removeCallbacks(this.ajG);
        }
        if (this.djW.aBf() != null) {
            this.djW.aBf().Cm();
        }
    }

    public void lP(int i) {
        if (i == 1) {
            an.c(this.dkK, i.c.album_list_bottom_bigimage_bg, 0);
            an.i((View) this.dkG, i.e.post_button_bg_bigimage);
            an.c(this.dkL, i.e.btn_add_pic_bigimage, 0);
            an.d(this.dkH, i.c.album_list_bottom_bigimage_line, 0);
            for (View view : this.dkQ) {
                an.d(view, i.c.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        an.i(this.dkK, i.c.album_list_bottom_bg);
        an.i((View) this.dkG, i.e.post_button_bg);
        an.i(this.dkL, i.e.btn_add_pic);
        an.j(this.dkH, i.c.album_list_bottom_line);
        for (View view2 : this.dkQ) {
            an.j(view2, i.c.album_list_bottom_line);
        }
    }

    public void q(boolean z, boolean z2) {
        if (z) {
            this.dkM.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.dkM.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.dkM.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(dkD);
            if (j > 0) {
                sb.append("(");
                sb.append(as.y(j));
                sb.append(")");
            }
            this.dkM.setText(sb.toString());
            return;
        }
        this.dkM.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.dkM.setText(dkD);
    }

    public View aBE() {
        return this.dkM;
    }
}
