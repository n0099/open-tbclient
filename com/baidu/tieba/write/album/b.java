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
    private com.baidu.tbadk.img.b axk;
    private View gGC;
    private c gGD;
    private ImageView gGE;
    private TextView gGF;
    private TextView gGG;
    private View gGH;
    private e gGi;
    private AlbumActivity gGx;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aDt = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.gGH && view == b.this.gGE && b.this.gGD != null && b.this.gGi != null && b.this.gGx != null && b.this.gGD.uO(b.this.aDt)) {
                ImageFileInfo oO = b.this.gGD.oO(b.this.aDt);
                if (b.this.gGi.isAdded(oO)) {
                    if (b.this.gGx.e(oO)) {
                        b.this.c(b.this.gGE, false);
                        b.this.gGx.F(b.this.aDt, false);
                    }
                } else if (b.this.gGx.d(oO)) {
                    b.this.c(b.this.gGE, true);
                    b.this.gGx.F(b.this.aDt, true);
                }
                b.this.bzp();
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aDt = i;
            if (b.this.gGD != null && b.this.gGi != null) {
                ImageFileInfo oO = b.this.gGD.oO(b.this.aDt);
                if (b.this.gGi.isAdded(oO)) {
                    b.this.c(b.this.gGE, true);
                } else {
                    b.this.c(b.this.gGE, false);
                }
                if (oO.isGif()) {
                    b.this.gGG.setVisibility(8);
                } else {
                    b.this.gGG.setVisibility(0);
                }
                if (oO != null) {
                    b.this.no(b.this.gGi.isOriginalImg());
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
        this.gGx = (AlbumActivity) getBaseFragmentActivity();
        this.gGi = this.gGx.bzc();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Rh = layoutInflater.inflate(d.j.album_big_image_view, (ViewGroup) null);
        this.gGC = this.Rh.findViewById(d.h.img_back);
        this.gGC.setOnClickListener(this.gGx);
        this.gGE = (ImageView) this.Rh.findViewById(d.h.img_choose);
        this.gGE.setOnClickListener(this.mOnClickListener);
        this.mViewPager = (ViewPager) this.Rh.findViewById(d.h.viewPager);
        this.axk = this.gGx.aLP();
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.Rh.findViewById(d.h.album_no_data);
        this.gGF = (TextView) this.Rh.findViewById(d.h.btn_next_step);
        this.gGF.setOnClickListener(this.gGx);
        this.gGG = (TextView) this.Rh.findViewById(d.h.original_select_btn);
        this.gGG.setOnClickListener(this.gGx);
        this.gGH = this.Rh.findViewById(d.h.layout_bottom);
        this.gGH.setOnClickListener(this.mOnClickListener);
        return this.Rh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzp() {
        if (this.gGi.isOriginalImg()) {
            this.gGx.bzb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            NC();
        }
    }

    private void bzq() {
        int currentIndex;
        if (this.gGi == null && this.gGx != null) {
            this.gGi = this.gGx.bzc();
        }
        if (this.gGi != null && this.gGi.bzu() != null && (currentIndex = this.gGi.getCurrentIndex()) >= 0) {
            this.aDt = currentIndex;
            if (this.aDt > this.gGi.bzu().size() - 1) {
                this.aDt = this.gGi.bzu().size() - 1;
            }
            this.gGi.setCurrentIndex(-1);
            this.gGD = null;
            this.gGD = new c(this.gGx, this.axk);
            this.mViewPager.setAdapter(this.gGD);
            if (this.aDt == 0 && this.gGi.bzu() != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.gGi.bzu(), this.aDt);
                if (this.gGi.isAdded(imageFileInfo)) {
                    c(this.gGE, true);
                } else {
                    c(this.gGE, false);
                }
                if (imageFileInfo.isGif()) {
                    this.gGG.setVisibility(8);
                } else {
                    this.gGG.setVisibility(0);
                }
            }
            this.gGD.setData(this.gGi.bzu());
            this.mViewPager.setCurrentItem(this.aDt, false);
            if (this.gGi.isOriginalImg()) {
                no(this.gGi.isOriginalImg());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gGD != null) {
            this.gGD.setData(null);
        }
    }

    public View biR() {
        return this.gGC;
    }

    public View bzr() {
        return this.gGF;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gGx.getLayoutMode().ah(i == 1);
        this.gGx.getLayoutMode().t(this.Rh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(d.g.ic_post_edit_select_s);
            } else {
                imageView.setImageResource(d.g.ic_post_edit_select_n);
            }
            if (this.gGF != null && this.gGx != null) {
                int t = this.gGi != null ? v.t(this.gGi.bzs()) : 0;
                this.gGF.setText(this.gGx.getString(d.l.image_selected_list_count, new Object[]{Integer.valueOf(t)}));
                this.gGF.setEnabled(t > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo oO;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gGD != null && (oO = this.gGD.oO(this.aDt)) != null && oO.getFilePath() != null && oO.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.gGE, z);
        }
    }

    private void NC() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bzq();
        }
    }

    public int getCurrentIndex() {
        return this.aDt;
    }

    public View bzl() {
        return this.gGG;
    }

    public void no(boolean z) {
        long j;
        if (this.gGx != null && this.gGG != null) {
            if (this.gGD != null) {
                ImageFileInfo oO = this.gGD.oO(this.aDt);
                j = oO != null ? com.baidu.tbadk.core.util.k.dq(oO.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.gGx.getResources().getString(d.l.original_img);
            if (z) {
                this.gGG.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.G(j));
                    sb.append(")");
                }
                this.gGG.setText(sb.toString());
                this.gGG.setTextColor(this.gGx.getResources().getColor(d.e.cp_link_tip_a));
                return;
            }
            this.gGG.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gGG.setText(string);
            this.gGG.setTextColor(this.gGx.getResources().getColor(d.e.cp_cont_i));
        }
    }
}
