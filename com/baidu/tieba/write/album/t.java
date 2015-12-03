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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String dLr = TbadkCoreApplication.m411getInst().getResources().getString(n.i.original_img);
    private Runnable alw;
    private ViewGroup ccR;
    private AlbumActivity dKK;
    private TextView dLA;
    private Fragment[] dLB;
    private String[] dLC;
    private FrameLayout[] dLD;
    private View[] dLE;
    private int dLF;
    private String dLs;
    private String dLt;
    private Button dLu;
    private View dLv;
    private HorizontalCustomScrollView dLw;
    private LinearLayout dLx;
    private RelativeLayout dLy;
    private ImageView dLz;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.dLs = "tag_image";
        this.dLt = "tag_b_image";
        this.mHandler = new Handler();
        this.dKK = albumActivity;
        d(albumActivity);
    }

    private void d(AlbumActivity albumActivity) {
        albumActivity.setContentView(n.g.album_activity);
        this.ccR = (ViewGroup) albumActivity.findViewById(n.f.parent);
        this.dLu = (Button) albumActivity.findViewById(n.f.btn_done);
        this.dLu.setOnClickListener(albumActivity);
        this.dLw = (HorizontalCustomScrollView) albumActivity.findViewById(n.f.bottom_scroll);
        this.dLx = (LinearLayout) albumActivity.findViewById(n.f.bottom_container);
        this.dLy = (RelativeLayout) albumActivity.findViewById(n.f.lay_bottom);
        this.dLz = (ImageView) albumActivity.findViewById(n.f.add_more);
        this.dLv = albumActivity.findViewById(n.f.bottom_shadow);
        this.dLA = (TextView) albumActivity.findViewById(n.f.original_select_btn);
        this.dLA.setOnClickListener(albumActivity);
        this.dLF = (int) this.dKK.getResources().getDimension(n.d.ds90);
    }

    public void nm(int i) {
        this.dLD = new FrameLayout[i];
        this.dLE = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.dLD[i2] = (FrameLayout) LayoutInflater.from(this.dKK.getPageContext().getPageActivity()).inflate(n.g.album_bottom_item_view, (ViewGroup) null);
            this.dLE[i2 * 4] = this.dLD[i2].findViewById(n.f.line_top);
            this.dLE[(i2 * 4) + 1] = this.dLD[i2].findViewById(n.f.line_left);
            this.dLE[(i2 * 4) + 2] = this.dLD[i2].findViewById(n.f.line_right);
            this.dLE[(i2 * 4) + 3] = this.dLD[i2].findViewById(n.f.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(n.f.item_iv);
    }

    public void aHJ() {
        this.dLB = new Fragment[2];
        this.dLC = new String[2];
        this.dLB[0] = new ag();
        this.dLC[0] = this.dLs;
        this.dLB[1] = new e();
        this.dLC[1] = this.dLt;
    }

    public Fragment nn(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dLB[i];
    }

    public String no(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dLC[i];
    }

    public void onChangeSkinType(int i) {
        this.dKK.getLayoutMode().af(i == 1);
        this.dKK.getLayoutMode().k(this.ccR);
        for (int i2 = 0; i2 < this.dLB.length; i2++) {
            if (this.dLB[i2] != null && (this.dLB[i2] instanceof ag)) {
                ((ag) this.dLB[i2]).onChangeSkinType(i);
            }
        }
    }

    public Button aHK() {
        return this.dLu;
    }

    public View aHL() {
        Fragment nn = nn(0);
        if (nn == null || !(nn instanceof ag)) {
            return null;
        }
        return ((ag) nn).apG();
    }

    public View aHM() {
        Fragment nn = nn(1);
        if (nn == null || !(nn instanceof e)) {
            return null;
        }
        return ((e) nn).apG();
    }

    public void o(boolean z, String str) {
        this.dLu.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.dLu.setText(str);
    }

    public void e(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.dLD.length;
            for (int i = 0; i < length; i++) {
                if (this.dLD[i] != null && (a = a(this.dLD[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.dLF, this.dLF));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dLF, this.dLF);
                    layoutParams.rightMargin = (int) this.dKK.getResources().getDimension(n.d.ds10);
                    this.dLD[i].setLayoutParams(layoutParams);
                    this.dLx.addView(this.dLD[i], this.dLx.getChildCount() - 1);
                    a((HorizontalScrollView) this.dLw);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.dLF, this.dLF));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.dKK.aHo().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.dKK.aHo().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.dLF, this.dLF));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.dLx.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.dLx.getChildAt(i) != null && (this.dLx.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.dLx.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.dLx.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void hE(boolean z) {
        if (this.dLz != null) {
            if (z) {
                this.dLz.setVisibility(0);
            } else {
                this.dLz.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.dLw != null) {
            if (this.alw == null) {
                this.alw = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.alw);
            this.mHandler.postDelayed(this.alw, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.alw != null) {
            this.mHandler.removeCallbacks(this.alw);
        }
        if (this.dKK.aHo() != null) {
            this.dKK.aHo().Dd();
        }
    }

    public void np(int i) {
        if (i == 1) {
            as.c(this.dLy, n.c.album_list_bottom_bigimage_bg, 0);
            as.i((View) this.dLu, n.e.post_button_bg_bigimage);
            as.c(this.dLz, n.e.btn_add_pic_bigimage, 0);
            as.d(this.dLv, n.c.album_list_bottom_bigimage_line, 0);
            for (View view : this.dLE) {
                as.d(view, n.c.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        as.i(this.dLy, n.c.album_list_bottom_bg);
        as.i((View) this.dLu, n.e.post_button_bg);
        as.i(this.dLz, n.e.btn_add_pic);
        as.j(this.dLv, n.c.album_list_bottom_line);
        for (View view2 : this.dLE) {
            as.j(view2, n.c.album_list_bottom_line);
        }
    }

    public void r(boolean z, boolean z2) {
        if (z) {
            this.dLA.setVisibility(0);
            a(z2, 0L);
            return;
        }
        this.dLA.setVisibility(8);
    }

    public void a(boolean z, long j) {
        if (z) {
            this.dLA.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_check_yuantu_h), (Drawable) null, (Drawable) null, (Drawable) null);
            StringBuilder sb = new StringBuilder();
            sb.append(dLr);
            if (j > 0) {
                sb.append("(");
                sb.append(ax.C(j));
                sb.append(")");
            }
            this.dLA.setText(sb.toString());
            return;
        }
        this.dLA.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_check_yuantu_n), (Drawable) null, (Drawable) null, (Drawable) null);
        this.dLA.setText(dLr);
    }

    public View aHN() {
        return this.dLA;
    }
}
