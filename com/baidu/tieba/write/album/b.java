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
    private com.baidu.tbadk.img.b ayl;
    private AlbumActivity gBF;
    private View gBK;
    private c gBL;
    private ImageView gBM;
    private View gBN;
    private TextView gBO;
    private e gBq;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aEn = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gBL != null && b.this.gBq != null && b.this.gBF != null && b.this.gBL.us(b.this.aEn)) {
                ImageFileInfo oX = b.this.gBL.oX(b.this.aEn);
                if (b.this.gBq.isAdded(oX)) {
                    if (b.this.gBF.f(oX)) {
                        b.this.c(b.this.gBM, false);
                        b.this.gBF.E(b.this.aEn, false);
                    }
                } else if (b.this.gBF.e(oX)) {
                    b.this.c(b.this.gBM, true);
                    b.this.gBF.E(b.this.aEn, true);
                }
                b.this.byg();
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aEn = i;
            if (b.this.gBL != null && b.this.gBq != null) {
                ImageFileInfo oX = b.this.gBL.oX(b.this.aEn);
                if (b.this.gBq.isAdded(oX)) {
                    b.this.c(b.this.gBM, true);
                } else {
                    b.this.c(b.this.gBM, false);
                }
                if (oX.isGif()) {
                    b.this.gBO.setVisibility(8);
                } else {
                    b.this.gBO.setVisibility(0);
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
        this.gBF = (AlbumActivity) getBaseFragmentActivity();
        this.gBq = this.gBF.bxT();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Rh = layoutInflater.inflate(d.j.album_big_image_view, (ViewGroup) null);
        this.gBK = this.Rh.findViewById(d.h.img_back);
        this.gBK.setOnClickListener(this.gBF);
        this.gBM = (ImageView) this.Rh.findViewById(d.h.img_choose);
        this.gBM.setOnClickListener(this.mOnClickListener);
        this.mViewPager = (ViewPager) this.Rh.findViewById(d.h.viewPager);
        this.ayl = this.gBF.apd();
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.Rh.findViewById(d.h.album_no_data);
        this.gBN = this.Rh.findViewById(d.h.btn_next_step);
        this.gBN.setOnClickListener(this.gBF);
        this.gBO = (TextView) this.Rh.findViewById(d.h.original_select_btn);
        this.gBO.setOnClickListener(this.gBF);
        if (this.gBq.isOriginalImg()) {
            this.gBF.bxX();
        }
        return this.Rh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byg() {
        if (this.gBq.isOriginalImg()) {
            this.gBF.bxX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            ahu();
        }
    }

    private void byh() {
        int currentIndex;
        if (this.gBq == null && this.gBF != null) {
            this.gBq = this.gBF.bxT();
        }
        if (this.gBq != null && this.gBq.byl() != null && (currentIndex = this.gBq.getCurrentIndex()) >= 0) {
            this.aEn = currentIndex;
            if (this.aEn > this.gBq.byl().size() - 1) {
                this.aEn = this.gBq.byl().size() - 1;
            }
            this.gBq.setCurrentIndex(-1);
            this.gBL = null;
            this.gBL = new c(this.gBF, this.ayl);
            this.mViewPager.setAdapter(this.gBL);
            if (this.aEn == 0 && this.gBq.byl() != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.gBq.byl(), this.aEn);
                if (this.gBq.isAdded(imageFileInfo)) {
                    c(this.gBM, true);
                } else {
                    c(this.gBM, false);
                }
                if (imageFileInfo.isGif()) {
                    this.gBO.setVisibility(8);
                } else {
                    this.gBO.setVisibility(0);
                }
            }
            this.gBL.setData(this.gBq.byl());
            this.mViewPager.setCurrentItem(this.aEn, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gBL != null) {
            this.gBL.setData(null);
        }
    }

    public View bku() {
        return this.gBK;
    }

    public View byi() {
        return this.gBN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gBF.getLayoutMode().ah(i == 1);
        this.gBF.getLayoutMode().t(this.Rh);
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
        ImageFileInfo oX;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gBL != null && (oX = this.gBL.oX(this.aEn)) != null && oX.getFilePath() != null && oX.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.gBM, z);
        }
    }

    private void ahu() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            byh();
        }
    }

    public int getCurrentIndex() {
        return this.aEn;
    }

    public View byd() {
        return this.gBO;
    }

    public void d(boolean z, long j) {
        if (this.gBF != null && this.gBO != null) {
            String string = this.gBF.getResources().getString(d.l.original_img);
            if (z) {
                this.gBO.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.G(j));
                    sb.append(")");
                }
                this.gBO.setText(sb.toString());
                this.gBO.setTextColor(this.gBF.getResources().getColor(d.e.cp_link_tip_a));
                return;
            }
            this.gBO.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gBO.setText(string);
            this.gBO.setTextColor(this.gBF.getResources().getColor(d.e.cp_cont_i));
        }
    }
}
