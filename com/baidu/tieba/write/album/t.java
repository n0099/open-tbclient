package com.baidu.tieba.write.album;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.g<BaseFragmentActivity> {
    private Runnable aeb;
    private ViewGroup bsE;
    private final int ctX;
    private String ctY;
    private String ctZ;
    private AlbumActivity ctu;
    private Button cua;
    private View cub;
    private HorizontalCustomScrollView cuc;
    private LinearLayout cud;
    private RelativeLayout cue;
    private ImageView cuf;
    private Fragment[] cug;
    private String[] cuh;
    private FrameLayout[] cui;
    private View[] cuj;
    private int cuk;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.ctX = 2;
        this.ctY = "tag_image";
        this.ctZ = "tag_b_image";
        this.mHandler = new Handler();
        this.ctu = albumActivity;
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(com.baidu.tieba.w.album_activity);
        this.bsE = (ViewGroup) albumActivity.findViewById(com.baidu.tieba.v.parent);
        this.cua = (Button) albumActivity.findViewById(com.baidu.tieba.v.btn_done);
        this.cua.setOnClickListener(albumActivity);
        this.cuc = (HorizontalCustomScrollView) albumActivity.findViewById(com.baidu.tieba.v.bottom_scroll);
        this.cud = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.v.bottom_container);
        this.cue = (RelativeLayout) albumActivity.findViewById(com.baidu.tieba.v.lay_bottom);
        this.cuf = (ImageView) albumActivity.findViewById(com.baidu.tieba.v.add_more);
        this.cub = albumActivity.findViewById(com.baidu.tieba.v.bottom_shadow);
        this.cuk = (int) this.ctu.getResources().getDimension(com.baidu.tieba.t.ds90);
    }

    public void iQ(int i) {
        this.cui = new FrameLayout[i];
        this.cuj = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.cui[i2] = (FrameLayout) com.baidu.adp.lib.g.b.hH().inflate(this.ctu.getPageContext().getPageActivity(), com.baidu.tieba.w.album_bottom_item_view, null);
            this.cuj[i2 * 4] = this.cui[i2].findViewById(com.baidu.tieba.v.line_top);
            this.cuj[(i2 * 4) + 1] = this.cui[i2].findViewById(com.baidu.tieba.v.line_left);
            this.cuj[(i2 * 4) + 2] = this.cui[i2].findViewById(com.baidu.tieba.v.line_right);
            this.cuj[(i2 * 4) + 3] = this.cui[i2].findViewById(com.baidu.tieba.v.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(com.baidu.tieba.v.item_iv);
    }

    public void apP() {
        this.cug = new Fragment[2];
        this.cuh = new String[2];
        this.cug[0] = new ah();
        this.cuh[0] = this.ctY;
        this.cug[1] = new b();
        this.cuh[1] = this.ctZ;
    }

    public Fragment iR(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cug[i];
    }

    public String iS(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cuh[i];
    }

    public void onChangeSkinType(int i) {
        this.ctu.getLayoutMode().X(i == 1);
        this.ctu.getLayoutMode().h(this.bsE);
    }

    public Button apQ() {
        return this.cua;
    }

    public View apR() {
        Fragment iR = iR(0);
        if (iR == null || !(iR instanceof ah)) {
            return null;
        }
        return ((ah) iR).aes();
    }

    public View apS() {
        Fragment iR = iR(1);
        if (iR == null || !(iR instanceof b)) {
            return null;
        }
        return ((b) iR).aes();
    }

    public void k(boolean z, String str) {
        this.cua.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.cua.setText(str);
    }

    public void f(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.cui.length;
            for (int i = 0; i < length; i++) {
                if (this.cui[i] != null && (a = a(this.cui[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.cuk, this.cuk));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cuk, this.cuk);
                    layoutParams.rightMargin = (int) this.ctu.getResources().getDimension(com.baidu.tieba.t.ds10);
                    this.cui[i].setLayoutParams(layoutParams);
                    this.cud.addView(this.cui[i], this.cud.getChildCount() - 1);
                    a((HorizontalScrollView) this.cuc);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.x(this.cuk, this.cuk));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.ctu.apy().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.ctu.apy().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.x(this.cuk, this.cuk));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.cud.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.cud.getChildAt(i) != null && (this.cud.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.cud.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.cud.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void fe(boolean z) {
        if (this.cuf != null) {
            if (z) {
                this.cuf.setVisibility(0);
            } else {
                this.cuf.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.cuc != null) {
            if (this.aeb == null) {
                this.aeb = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.aeb);
            this.mHandler.postDelayed(this.aeb, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.aeb != null) {
            this.mHandler.removeCallbacks(this.aeb);
        }
        if (this.ctu.apy() != null) {
            this.ctu.apy().zA();
        }
    }

    public void iT(int i) {
        if (i == 1) {
            ba.c(this.cue, com.baidu.tieba.s.album_list_bottom_bigimage_bg, 0);
            ba.i((View) this.cua, com.baidu.tieba.u.post_button_bg_bigimage);
            ba.c(this.cuf, com.baidu.tieba.u.btn_add_pic_bigimage, 0);
            ba.d(this.cub, com.baidu.tieba.s.album_list_bottom_bigimage_line, 0);
            for (View view : this.cuj) {
                ba.d(view, com.baidu.tieba.s.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        ba.i(this.cue, com.baidu.tieba.s.album_list_bottom_bg);
        ba.i((View) this.cua, com.baidu.tieba.u.post_button_bg);
        ba.i(this.cuf, com.baidu.tieba.u.btn_add_pic);
        ba.j(this.cub, com.baidu.tieba.s.album_list_bottom_line);
        for (View view2 : this.cuj) {
            ba.j(view2, com.baidu.tieba.s.album_list_bottom_line);
        }
    }
}
