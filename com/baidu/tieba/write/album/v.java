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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.g<BaseFragmentActivity> {
    private Runnable afn;
    private ViewGroup bvF;
    private final int cyG;
    private String cyH;
    private String cyI;
    private Button cyJ;
    private View cyK;
    private HorizontalCustomScrollView cyL;
    private LinearLayout cyM;
    private RelativeLayout cyN;
    private ImageView cyO;
    private Fragment[] cyP;
    private String[] cyQ;
    private FrameLayout[] cyR;
    private View[] cyS;
    private int cyT;
    private AlbumActivity cya;
    private Handler mHandler;

    public v(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.cyG = 2;
        this.cyH = "tag_image";
        this.cyI = "tag_b_image";
        this.mHandler = new Handler();
        this.cya = albumActivity;
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(com.baidu.tieba.r.album_activity);
        this.bvF = (ViewGroup) albumActivity.findViewById(com.baidu.tieba.q.parent);
        this.cyJ = (Button) albumActivity.findViewById(com.baidu.tieba.q.btn_done);
        this.cyJ.setOnClickListener(albumActivity);
        this.cyL = (HorizontalCustomScrollView) albumActivity.findViewById(com.baidu.tieba.q.bottom_scroll);
        this.cyM = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.q.bottom_container);
        this.cyN = (RelativeLayout) albumActivity.findViewById(com.baidu.tieba.q.lay_bottom);
        this.cyO = (ImageView) albumActivity.findViewById(com.baidu.tieba.q.add_more);
        this.cyK = albumActivity.findViewById(com.baidu.tieba.q.bottom_shadow);
        this.cyT = (int) this.cya.getResources().getDimension(com.baidu.tieba.o.ds90);
    }

    public void jp(int i) {
        this.cyR = new FrameLayout[i];
        this.cyS = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.cyR[i2] = (FrameLayout) com.baidu.adp.lib.g.b.hr().inflate(this.cya.getPageContext().getPageActivity(), com.baidu.tieba.r.album_bottom_item_view, null);
            this.cyS[i2 * 4] = this.cyR[i2].findViewById(com.baidu.tieba.q.line_top);
            this.cyS[(i2 * 4) + 1] = this.cyR[i2].findViewById(com.baidu.tieba.q.line_left);
            this.cyS[(i2 * 4) + 2] = this.cyR[i2].findViewById(com.baidu.tieba.q.line_right);
            this.cyS[(i2 * 4) + 3] = this.cyR[i2].findViewById(com.baidu.tieba.q.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(com.baidu.tieba.q.item_iv);
    }

    public void arV() {
        this.cyP = new Fragment[2];
        this.cyQ = new String[2];
        this.cyP[0] = new aj();
        this.cyQ[0] = this.cyH;
        this.cyP[1] = new b();
        this.cyQ[1] = this.cyI;
    }

    public Fragment jq(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cyP[i];
    }

    public String jr(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cyQ[i];
    }

    public void onChangeSkinType(int i) {
        this.cya.getLayoutMode().ab(i == 1);
        this.cya.getLayoutMode().j(this.bvF);
    }

    public Button arW() {
        return this.cyJ;
    }

    public View arX() {
        Fragment jq = jq(0);
        if (jq == null || !(jq instanceof aj)) {
            return null;
        }
        return ((aj) jq).afO();
    }

    public View arY() {
        Fragment jq = jq(1);
        if (jq == null || !(jq instanceof b)) {
            return null;
        }
        return ((b) jq).afO();
    }

    public void k(boolean z, String str) {
        this.cyJ.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.cyJ.setText(str);
    }

    public void f(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.cyR.length;
            for (int i = 0; i < length; i++) {
                if (this.cyR[i] != null && (a = a(this.cyR[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.cyT, this.cyT));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cyT, this.cyT);
                    layoutParams.rightMargin = (int) this.cya.getResources().getDimension(com.baidu.tieba.o.ds10);
                    this.cyR[i].setLayoutParams(layoutParams);
                    this.cyM.addView(this.cyR[i], this.cyM.getChildCount() - 1);
                    a((HorizontalScrollView) this.cyL);
                    a.setOnClickListener(new w(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.y(this.cyT, this.cyT));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.cya.arE().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.cya.arE().a(imageFileInfo, new x(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.y(this.cyT, this.cyT));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.cyM.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.cyM.getChildAt(i) != null && (this.cyM.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.cyM.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.cyM.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void fy(boolean z) {
        if (this.cyO != null) {
            if (z) {
                this.cyO.setVisibility(0);
            } else {
                this.cyO.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.cyL != null) {
            if (this.afn == null) {
                this.afn = new y(this, horizontalScrollView);
            }
            this.mHandler.removeCallbacks(this.afn);
            this.mHandler.postDelayed(this.afn, 10L);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null && this.afn != null) {
            this.mHandler.removeCallbacks(this.afn);
        }
        if (this.cya.arE() != null) {
            this.cya.arE().At();
        }
    }

    public void js(int i) {
        if (i == 1) {
            ay.c(this.cyN, com.baidu.tieba.n.album_list_bottom_bigimage_bg, 0);
            ay.i((View) this.cyJ, com.baidu.tieba.p.post_button_bg_bigimage);
            ay.c(this.cyO, com.baidu.tieba.p.btn_add_pic_bigimage, 0);
            ay.d(this.cyK, com.baidu.tieba.n.album_list_bottom_bigimage_line, 0);
            for (View view : this.cyS) {
                ay.d(view, com.baidu.tieba.n.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        ay.i(this.cyN, com.baidu.tieba.n.album_list_bottom_bg);
        ay.i((View) this.cyJ, com.baidu.tieba.p.post_button_bg);
        ay.i(this.cyO, com.baidu.tieba.p.btn_add_pic);
        ay.j(this.cyK, com.baidu.tieba.n.album_list_bottom_line);
        for (View view2 : this.cyS) {
            ay.j(view2, com.baidu.tieba.n.album_list_bottom_line);
        }
    }
}
