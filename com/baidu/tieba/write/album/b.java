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
    private View Ry;
    private ViewPager aDL;
    private com.baidu.tbadk.img.b axU;
    private View gQA;
    private c gQB;
    private ImageView gQC;
    private TextView gQD;
    private TextView gQE;
    private View gQF;
    private e gQf;
    private AlbumActivity gQv;
    private View mNoDataView;
    private int aEe = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.gQF && view == b.this.gQC && b.this.gQB != null && b.this.gQf != null && b.this.gQv != null && b.this.gQB.vi(b.this.aEe)) {
                ImageFileInfo pi = b.this.gQB.pi(b.this.aEe);
                if (b.this.gQf.isAdded(pi)) {
                    if (b.this.gQv.e(pi)) {
                        b.this.c(b.this.gQC, false);
                        b.this.gQv.G(b.this.aEe, false);
                    }
                } else if (b.this.gQv.d(pi)) {
                    b.this.c(b.this.gQC, true);
                    b.this.gQv.G(b.this.aEe, true);
                }
                b.this.bCN();
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aEe = i;
            if (b.this.gQB != null && b.this.gQf != null) {
                ImageFileInfo pi = b.this.gQB.pi(b.this.aEe);
                if (b.this.gQf.isAdded(pi)) {
                    b.this.c(b.this.gQC, true);
                } else {
                    b.this.c(b.this.gQC, false);
                }
                if (pi.isGif()) {
                    b.this.gQE.setVisibility(8);
                } else {
                    b.this.gQE.setVisibility(0);
                }
                if (pi != null) {
                    b.this.nm(b.this.gQf.isOriginalImg());
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
        this.gQv = (AlbumActivity) getBaseFragmentActivity();
        this.gQf = this.gQv.bCA();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Ry = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.gQA = this.Ry.findViewById(d.g.img_back);
        this.gQA.setOnClickListener(this.gQv);
        this.gQC = (ImageView) this.Ry.findViewById(d.g.img_choose);
        this.gQC.setOnClickListener(this.mOnClickListener);
        this.aDL = (ViewPager) this.Ry.findViewById(d.g.viewPager);
        this.axU = this.gQv.aOH();
        this.aDL.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.Ry.findViewById(d.g.album_no_data);
        this.gQD = (TextView) this.Ry.findViewById(d.g.btn_next_step);
        this.gQD.setOnClickListener(this.gQv);
        this.gQE = (TextView) this.Ry.findViewById(d.g.original_select_btn);
        this.gQE.setOnClickListener(this.gQv);
        this.gQF = this.Ry.findViewById(d.g.layout_bottom);
        this.gQF.setOnClickListener(this.mOnClickListener);
        return this.Ry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCN() {
        if (this.gQf.isOriginalImg()) {
            this.gQv.bCz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            NP();
        }
    }

    private void bCO() {
        int currentIndex;
        if (this.gQf == null && this.gQv != null) {
            this.gQf = this.gQv.bCA();
        }
        if (this.gQf != null && this.gQf.bCS() != null && (currentIndex = this.gQf.getCurrentIndex()) >= 0) {
            this.aEe = currentIndex;
            if (this.aEe > this.gQf.bCS().size() - 1) {
                this.aEe = this.gQf.bCS().size() - 1;
            }
            this.gQf.setCurrentIndex(-1);
            this.gQB = null;
            this.gQB = new c(this.gQv, this.axU);
            this.aDL.setAdapter(this.gQB);
            if (this.aEe == 0 && this.gQf.bCS() != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.gQf.bCS(), this.aEe);
                if (this.gQf.isAdded(imageFileInfo)) {
                    c(this.gQC, true);
                } else {
                    c(this.gQC, false);
                }
                if (imageFileInfo.isGif()) {
                    this.gQE.setVisibility(8);
                } else {
                    this.gQE.setVisibility(0);
                }
            }
            this.gQB.setData(this.gQf.bCS());
            this.aDL.setCurrentItem(this.aEe, false);
            if (this.gQf.isOriginalImg()) {
                nm(this.gQf.isOriginalImg());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gQB != null) {
            this.gQB.setData(null);
        }
    }

    public View blY() {
        return this.gQA;
    }

    public View bCP() {
        return this.gQD;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gQv.getLayoutMode().ag(i == 1);
        this.gQv.getLayoutMode().t(this.Ry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(d.f.ic_post_edit_select_s);
            } else {
                imageView.setImageResource(d.f.ic_post_edit_select_n);
            }
            if (this.gQD != null && this.gQv != null) {
                int u = this.gQf != null ? v.u(this.gQf.bCQ()) : 0;
                this.gQD.setText(this.gQv.getString(d.j.image_selected_list_count, new Object[]{Integer.valueOf(u)}));
                this.gQD.setEnabled(u > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo pi;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gQB != null && (pi = this.gQB.pi(this.aEe)) != null && pi.getFilePath() != null && pi.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.gQC, z);
        }
    }

    private void NP() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.aDL.setVisibility(0);
            bCO();
        }
    }

    public int getCurrentIndex() {
        return this.aEe;
    }

    public View bCJ() {
        return this.gQE;
    }

    public void nm(boolean z) {
        long j;
        if (this.gQv != null && this.gQE != null) {
            if (this.gQB != null) {
                ImageFileInfo pi = this.gQB.pi(this.aEe);
                j = pi != null ? com.baidu.tbadk.core.util.k.dx(pi.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.gQv.getResources().getString(d.j.original_img);
            if (z) {
                this.gQE.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.G(j));
                    sb.append(")");
                }
                this.gQE.setText(sb.toString());
                this.gQE.setTextColor(this.gQv.getResources().getColor(d.C0080d.cp_link_tip_a));
                return;
            }
            this.gQE.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gQE.setText(string);
            this.gQE.setTextColor(this.gQv.getResources().getColor(d.C0080d.cp_cont_i));
        }
    }
}
