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
    private Runnable aej;
    private ViewGroup bsU;
    private AlbumActivity ctK;
    private int cuA;
    private final int cun;
    private String cuo;
    private String cup;
    private Button cuq;
    private View cur;
    private HorizontalCustomScrollView cus;
    private LinearLayout cut;
    private RelativeLayout cuu;
    private ImageView cuv;
    private Fragment[] cuw;
    private String[] cux;
    private FrameLayout[] cuy;
    private View[] cuz;
    private Handler mHandler;

    public t(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.cun = 2;
        this.cuo = "tag_image";
        this.cup = "tag_b_image";
        this.mHandler = new Handler();
        this.ctK = albumActivity;
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(com.baidu.tieba.w.album_activity);
        this.bsU = (ViewGroup) albumActivity.findViewById(com.baidu.tieba.v.parent);
        this.cuq = (Button) albumActivity.findViewById(com.baidu.tieba.v.btn_done);
        this.cuq.setOnClickListener(albumActivity);
        this.cus = (HorizontalCustomScrollView) albumActivity.findViewById(com.baidu.tieba.v.bottom_scroll);
        this.cut = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.v.bottom_container);
        this.cuu = (RelativeLayout) albumActivity.findViewById(com.baidu.tieba.v.lay_bottom);
        this.cuv = (ImageView) albumActivity.findViewById(com.baidu.tieba.v.add_more);
        this.cur = albumActivity.findViewById(com.baidu.tieba.v.bottom_shadow);
        this.cuA = (int) this.ctK.getResources().getDimension(com.baidu.tieba.t.ds90);
    }

    public void iT(int i) {
        this.cuy = new FrameLayout[i];
        this.cuz = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.cuy[i2] = (FrameLayout) com.baidu.adp.lib.g.b.hH().inflate(this.ctK.getPageContext().getPageActivity(), com.baidu.tieba.w.album_bottom_item_view, null);
            this.cuz[i2 * 4] = this.cuy[i2].findViewById(com.baidu.tieba.v.line_top);
            this.cuz[(i2 * 4) + 1] = this.cuy[i2].findViewById(com.baidu.tieba.v.line_left);
            this.cuz[(i2 * 4) + 2] = this.cuy[i2].findViewById(com.baidu.tieba.v.line_right);
            this.cuz[(i2 * 4) + 3] = this.cuy[i2].findViewById(com.baidu.tieba.v.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(com.baidu.tieba.v.item_iv);
    }

    public void aqe() {
        this.cuw = new Fragment[2];
        this.cux = new String[2];
        this.cuw[0] = new ah();
        this.cux[0] = this.cuo;
        this.cuw[1] = new b();
        this.cux[1] = this.cup;
    }

    public Fragment iU(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cuw[i];
    }

    public String iV(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cux[i];
    }

    public void onChangeSkinType(int i) {
        this.ctK.getLayoutMode().X(i == 1);
        this.ctK.getLayoutMode().h(this.bsU);
    }

    public Button aqf() {
        return this.cuq;
    }

    public View aqg() {
        Fragment iU = iU(0);
        if (iU == null || !(iU instanceof ah)) {
            return null;
        }
        return ((ah) iU).aeH();
    }

    public View aqh() {
        Fragment iU = iU(1);
        if (iU == null || !(iU instanceof b)) {
            return null;
        }
        return ((b) iU).aeH();
    }

    public void k(boolean z, String str) {
        this.cuq.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.cuq.setText(str);
    }

    public void f(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.cuy.length;
            for (int i = 0; i < length; i++) {
                if (this.cuy[i] != null && (a = a(this.cuy[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.cuA, this.cuA));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cuA, this.cuA);
                    layoutParams.rightMargin = (int) this.ctK.getResources().getDimension(com.baidu.tieba.t.ds10);
                    this.cuy[i].setLayoutParams(layoutParams);
                    this.cut.addView(this.cuy[i], this.cut.getChildCount() - 1);
                    a((HorizontalScrollView) this.cus);
                    a.setOnClickListener(new u(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.x(this.cuA, this.cuA));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.ctK.apN().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.ctK.apN().a(imageFileInfo, new v(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.x(this.cuA, this.cuA));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.cut.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.cut.getChildAt(i) != null && (this.cut.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.cut.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.cut.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void fc(boolean z) {
        if (this.cuv != null) {
            if (z) {
                this.cuv.setVisibility(0);
            } else {
                this.cuv.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.cus != null) {
            if (this.aej == null) {
                this.aej = new w(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.aej);
            this.mHandler.postDelayed(this.aej, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.aej != null) {
            this.mHandler.removeCallbacks(this.aej);
        }
        if (this.ctK.apN() != null) {
            this.ctK.apN().zG();
        }
    }

    public void iW(int i) {
        if (i == 1) {
            ba.c(this.cuu, com.baidu.tieba.s.album_list_bottom_bigimage_bg, 0);
            ba.i((View) this.cuq, com.baidu.tieba.u.post_button_bg_bigimage);
            ba.c(this.cuv, com.baidu.tieba.u.btn_add_pic_bigimage, 0);
            ba.d(this.cur, com.baidu.tieba.s.album_list_bottom_bigimage_line, 0);
            for (View view : this.cuz) {
                ba.d(view, com.baidu.tieba.s.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        ba.i(this.cuu, com.baidu.tieba.s.album_list_bottom_bg);
        ba.i((View) this.cuq, com.baidu.tieba.u.post_button_bg);
        ba.i(this.cuv, com.baidu.tieba.u.btn_add_pic);
        ba.j(this.cur, com.baidu.tieba.s.album_list_bottom_line);
        for (View view2 : this.cuz) {
            ba.j(view2, com.baidu.tieba.s.album_list_bottom_line);
        }
    }
}
