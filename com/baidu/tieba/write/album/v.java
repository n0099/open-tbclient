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
    private ViewGroup bvE;
    private AlbumActivity cxZ;
    private final int cyF;
    private String cyG;
    private String cyH;
    private Button cyI;
    private View cyJ;
    private HorizontalCustomScrollView cyK;
    private LinearLayout cyL;
    private RelativeLayout cyM;
    private ImageView cyN;
    private Fragment[] cyO;
    private String[] cyP;
    private FrameLayout[] cyQ;
    private View[] cyR;
    private int cyS;
    private Handler mHandler;

    public v(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.cyF = 2;
        this.cyG = "tag_image";
        this.cyH = "tag_b_image";
        this.mHandler = new Handler();
        this.cxZ = albumActivity;
        a(albumActivity);
    }

    private void a(AlbumActivity albumActivity) {
        albumActivity.setContentView(com.baidu.tieba.r.album_activity);
        this.bvE = (ViewGroup) albumActivity.findViewById(com.baidu.tieba.q.parent);
        this.cyI = (Button) albumActivity.findViewById(com.baidu.tieba.q.btn_done);
        this.cyI.setOnClickListener(albumActivity);
        this.cyK = (HorizontalCustomScrollView) albumActivity.findViewById(com.baidu.tieba.q.bottom_scroll);
        this.cyL = (LinearLayout) albumActivity.findViewById(com.baidu.tieba.q.bottom_container);
        this.cyM = (RelativeLayout) albumActivity.findViewById(com.baidu.tieba.q.lay_bottom);
        this.cyN = (ImageView) albumActivity.findViewById(com.baidu.tieba.q.add_more);
        this.cyJ = albumActivity.findViewById(com.baidu.tieba.q.bottom_shadow);
        this.cyS = (int) this.cxZ.getResources().getDimension(com.baidu.tieba.o.ds90);
    }

    public void jp(int i) {
        this.cyQ = new FrameLayout[i];
        this.cyR = new View[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            this.cyQ[i2] = (FrameLayout) com.baidu.adp.lib.g.b.hr().inflate(this.cxZ.getPageContext().getPageActivity(), com.baidu.tieba.r.album_bottom_item_view, null);
            this.cyR[i2 * 4] = this.cyQ[i2].findViewById(com.baidu.tieba.q.line_top);
            this.cyR[(i2 * 4) + 1] = this.cyQ[i2].findViewById(com.baidu.tieba.q.line_left);
            this.cyR[(i2 * 4) + 2] = this.cyQ[i2].findViewById(com.baidu.tieba.q.line_right);
            this.cyR[(i2 * 4) + 3] = this.cyQ[i2].findViewById(com.baidu.tieba.q.line_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbImageView a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return (TbImageView) frameLayout.findViewById(com.baidu.tieba.q.item_iv);
    }

    public void arU() {
        this.cyO = new Fragment[2];
        this.cyP = new String[2];
        this.cyO[0] = new aj();
        this.cyP[0] = this.cyG;
        this.cyO[1] = new b();
        this.cyP[1] = this.cyH;
    }

    public Fragment jq(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cyO[i];
    }

    public String jr(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.cyP[i];
    }

    public void onChangeSkinType(int i) {
        this.cxZ.getLayoutMode().ab(i == 1);
        this.cxZ.getLayoutMode().j(this.bvE);
    }

    public Button arV() {
        return this.cyI;
    }

    public View arW() {
        Fragment jq = jq(0);
        if (jq == null || !(jq instanceof aj)) {
            return null;
        }
        return ((aj) jq).afN();
    }

    public View arX() {
        Fragment jq = jq(1);
        if (jq == null || !(jq instanceof b)) {
            return null;
        }
        return ((b) jq).afN();
    }

    public void k(boolean z, String str) {
        this.cyI.setEnabled(z);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.cyI.setText(str);
    }

    public void f(ImageFileInfo imageFileInfo) {
        TbImageView a;
        if (imageFileInfo != null) {
            int length = this.cyQ.length;
            for (int i = 0; i < length; i++) {
                if (this.cyQ[i] != null && (a = a(this.cyQ[i])) != null && a.getTag() == null) {
                    a.setDefaultResource(0);
                    a.setDefaultBgResource(0);
                    a.setLayoutParams(new FrameLayout.LayoutParams(this.cyS, this.cyS));
                    a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cyS, this.cyS);
                    layoutParams.rightMargin = (int) this.cxZ.getResources().getDimension(com.baidu.tieba.o.ds10);
                    this.cyQ[i].setLayoutParams(layoutParams);
                    this.cyL.addView(this.cyQ[i], this.cyL.getChildCount() - 1);
                    a((HorizontalScrollView) this.cyK);
                    a.setOnClickListener(new w(this, imageFileInfo));
                    a.setTag(null);
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.y(this.cyS, this.cyS));
                    a.setTag(imageFileInfo.toCachedKey(false));
                    com.baidu.adp.widget.a.a a2 = this.cxZ.arD().a(imageFileInfo, false);
                    if (a2 != null) {
                        a2.a(a);
                        return;
                    } else {
                        this.cxZ.arD().a(imageFileInfo, new x(this, imageFileInfo), false);
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
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.y(this.cyS, this.cyS));
            if (!TextUtils.isEmpty(imageFileInfo.toCachedKey(false))) {
                int childCount = this.cyL.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.cyL.getChildAt(i) != null && (this.cyL.getChildAt(i) instanceof FrameLayout) && (a = a((frameLayout = (FrameLayout) this.cyL.getChildAt(i)))) != null && a.getTag() != null && a.getTag().equals(imageFileInfo.toCachedKey(false))) {
                        a.setTag(null);
                        a.setImageDrawable(null);
                        this.cyL.removeView(frameLayout);
                        return;
                    }
                }
            }
        }
    }

    public void fy(boolean z) {
        if (this.cyN != null) {
            if (z) {
                this.cyN.setVisibility(0);
            } else {
                this.cyN.setVisibility(8);
            }
        }
    }

    private void a(HorizontalScrollView horizontalScrollView) {
        if (this.cyK != null) {
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
        if (this.cxZ.arD() != null) {
            this.cxZ.arD().As();
        }
    }

    public void js(int i) {
        if (i == 1) {
            ay.c(this.cyM, com.baidu.tieba.n.album_list_bottom_bigimage_bg, 0);
            ay.i((View) this.cyI, com.baidu.tieba.p.post_button_bg_bigimage);
            ay.c(this.cyN, com.baidu.tieba.p.btn_add_pic_bigimage, 0);
            ay.d(this.cyJ, com.baidu.tieba.n.album_list_bottom_bigimage_line, 0);
            for (View view : this.cyR) {
                ay.d(view, com.baidu.tieba.n.album_list_bottom_bigimage_line, 0);
            }
            return;
        }
        ay.i(this.cyM, com.baidu.tieba.n.album_list_bottom_bg);
        ay.i((View) this.cyI, com.baidu.tieba.p.post_button_bg);
        ay.i(this.cyN, com.baidu.tieba.p.btn_add_pic);
        ay.j(this.cyJ, com.baidu.tieba.n.album_list_bottom_line);
        for (View view2 : this.cyR) {
            ay.j(view2, com.baidu.tieba.n.album_list_bottom_line);
        }
    }
}
