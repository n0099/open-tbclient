package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends BaseFragment {
    private View Rh;
    private com.baidu.tbadk.img.b ayo;
    private AlbumActivity gAM;
    private View gAR;
    private c gAS;
    private ImageView gAT;
    private View gAU;
    private TextView gAV;
    private e gAx;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aEq = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gAS != null && b.this.gAx != null && b.this.gAM != null && b.this.gAS.uq(b.this.aEq)) {
                ImageFileInfo oV = b.this.gAS.oV(b.this.aEq);
                if (b.this.gAx.isAdded(oV)) {
                    if (b.this.gAM.f(oV)) {
                        b.this.c(b.this.gAT, false);
                        b.this.gAM.E(b.this.aEq, false);
                    }
                } else if (b.this.gAM.e(oV)) {
                    b.this.c(b.this.gAT, true);
                    b.this.gAM.E(b.this.aEq, true);
                }
                b.this.bxV();
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aEq = i;
            if (b.this.gAS != null && b.this.gAx != null) {
                ImageFileInfo oV = b.this.gAS.oV(b.this.aEq);
                if (b.this.gAx.isAdded(oV)) {
                    b.this.c(b.this.gAT, true);
                } else {
                    b.this.c(b.this.gAT, false);
                }
                if (oV.isGif()) {
                    b.this.gAV.setVisibility(8);
                } else {
                    b.this.gAV.setVisibility(0);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gAM = (AlbumActivity) getBaseFragmentActivity();
        this.gAx = this.gAM.bxI();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Rh = layoutInflater.inflate(d.j.album_big_image_view, (ViewGroup) null);
        this.gAR = this.Rh.findViewById(d.h.img_back);
        this.gAR.setOnClickListener(this.gAM);
        this.gAT = (ImageView) this.Rh.findViewById(d.h.img_choose);
        this.gAT.setOnClickListener(this.mOnClickListener);
        this.mViewPager = (ViewPager) this.Rh.findViewById(d.h.viewPager);
        this.ayo = this.gAM.aoS();
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.Rh.findViewById(d.h.album_no_data);
        this.gAU = this.Rh.findViewById(d.h.btn_next_step);
        this.gAU.setOnClickListener(this.gAM);
        this.gAV = (TextView) this.Rh.findViewById(d.h.original_select_btn);
        this.gAV.setOnClickListener(this.gAM);
        if (this.gAx.isOriginalImg()) {
            this.gAM.bxM();
        }
        return this.Rh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxV() {
        if (this.gAx.isOriginalImg()) {
            this.gAM.bxM();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            ahj();
        }
    }

    private void bxW() {
        int currentIndex;
        if (this.gAx == null && this.gAM != null) {
            this.gAx = this.gAM.bxI();
        }
        if (this.gAx != null && this.gAx.bya() != null && (currentIndex = this.gAx.getCurrentIndex()) >= 0) {
            this.aEq = currentIndex;
            if (this.aEq > this.gAx.bya().size() - 1) {
                this.aEq = this.gAx.bya().size() - 1;
            }
            this.gAx.setCurrentIndex(-1);
            this.gAS = null;
            this.gAS = new c(this.gAM, this.ayo);
            this.mViewPager.setAdapter(this.gAS);
            if (this.aEq == 0 && this.gAx.bya() != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.gAx.bya(), this.aEq);
                if (this.gAx.isAdded(imageFileInfo)) {
                    c(this.gAT, true);
                } else {
                    c(this.gAT, false);
                }
                if (imageFileInfo.isGif()) {
                    this.gAV.setVisibility(8);
                } else {
                    this.gAV.setVisibility(0);
                }
            }
            this.gAS.setData(this.gAx.bya());
            this.mViewPager.setCurrentItem(this.aEq, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gAS != null) {
            this.gAS.setData(null);
        }
    }

    public View bkj() {
        return this.gAR;
    }

    public View bxX() {
        return this.gAU;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gAM.getLayoutMode().ah(i == 1);
        this.gAM.getLayoutMode().t(this.Rh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(d.g.ic_post_edit_select_s);
            } else {
                imageView.setImageResource(d.g.ic_post_edit_select_n);
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo oV;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gAS != null && (oV = this.gAS.oV(this.aEq)) != null && oV.getFilePath() != null && oV.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.gAT, z);
        }
    }

    private void ahj() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bxW();
        }
    }

    public int getCurrentIndex() {
        return this.aEq;
    }

    public View bxS() {
        return this.gAV;
    }

    public void d(boolean z, long j) {
        if (this.gAM != null && this.gAV != null) {
            String string = this.gAM.getResources().getString(d.l.original_img);
            if (z) {
                this.gAV.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.G(j));
                    sb.append(")");
                }
                this.gAV.setText(sb.toString());
                this.gAV.setTextColor(this.gAM.getResources().getColor(d.e.cp_link_tip_a));
                return;
            }
            this.gAV.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gAV.setText(string);
            this.gAV.setTextColor(this.gAM.getResources().getColor(d.e.cp_cont_i));
        }
    }
}
