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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseFragment {
    private View aGJ;
    private e hMZ;
    private AlbumActivity hNl;
    private c hNp;
    private ImageView hNq;
    private View hNr;
    private TextView hNs;
    private TextView hNt;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager qW;
    private int bsN = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.hNr && view == b.this.hNq && b.this.hNp != null && b.this.hMZ != null && b.this.hNl != null) {
                if (b.this.hMZ.bLY()) {
                    b.this.hNl.showToast(d.j.album_choose_switch_tip);
                } else if (b.this.hNp.yK(b.this.bsN)) {
                    ImageFileInfo sw = b.this.hNp.sw(b.this.bsN);
                    if (b.this.hMZ.isAdded(sw)) {
                        if (b.this.hNl.d(sw)) {
                            b.this.c(b.this.hNq, false);
                            b.this.hNl.f(sw, false);
                        }
                    } else if (b.this.hNl.c(sw)) {
                        b.this.c(b.this.hNq, true);
                        b.this.hNl.f(sw, true);
                    }
                    b.this.bLT();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.bsN = i;
            if (b.this.hNp != null && b.this.hMZ != null) {
                ImageFileInfo sw = b.this.hNp.sw(b.this.bsN);
                if (b.this.hMZ.isAdded(sw)) {
                    b.this.c(b.this.hNq, true);
                } else {
                    b.this.c(b.this.hNq, false);
                }
                if (sw == null || !sw.isGif()) {
                    b.this.hNt.setVisibility(0);
                } else {
                    b.this.hNt.setVisibility(8);
                }
                b.this.or(b.this.hMZ.isOriginalImg());
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
        this.hNl = (AlbumActivity) getBaseFragmentActivity();
        this.hMZ = this.hNl.bLI();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aGJ = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.aGJ.findViewById(d.g.img_back);
        this.hNq = (ImageView) this.aGJ.findViewById(d.g.img_choose);
        this.qW = (ViewPager) this.aGJ.findViewById(d.g.viewPager);
        this.mNoDataView = this.aGJ.findViewById(d.g.album_no_data);
        this.hNs = (TextView) this.aGJ.findViewById(d.g.btn_next_step);
        this.hNt = (TextView) this.aGJ.findViewById(d.g.original_select_btn);
        this.hNr = this.aGJ.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hNl);
        this.hNs.setOnClickListener(this.hNl);
        this.hNq.setOnClickListener(this.mOnClickListener);
        this.hNt.setOnClickListener(this.hNl);
        this.hNr.setOnClickListener(this.mOnClickListener);
        this.qW.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.aGJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLT() {
        this.hNl.bLG();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            WI();
        }
    }

    private void bLU() {
        List<ImageFileInfo> bMc;
        int currentIndex;
        if (this.hMZ == null && this.hNl != null) {
            this.hMZ = this.hNl.bLI();
        }
        if (this.hMZ != null && (bMc = this.hMZ.bMc()) != null && (currentIndex = this.hMZ.getCurrentIndex()) >= 0) {
            this.bsN = currentIndex;
            this.hNp = new c(this.hNl);
            this.qW.setAdapter(this.hNp);
            if (this.bsN == 0 && bMc != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(bMc, this.bsN);
                if (this.hMZ.isAdded(imageFileInfo)) {
                    c(this.hNq, true);
                } else {
                    c(this.hNq, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hNt.setVisibility(8);
                } else {
                    this.hNt.setVisibility(0);
                }
            }
            this.hNp.setData(bMc);
            this.qW.setCurrentItem(this.bsN, false);
            or(this.hMZ.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hNp != null) {
            this.hNp.setData(null);
        }
    }

    public View bwv() {
        return this.mBackBtn;
    }

    public View bLV() {
        return this.hNs;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.aGJ);
        aj.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hMZ != null) {
            or(this.hMZ.isOriginalImg());
        }
        if (this.hNp != null) {
            this.hNp.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hNl != null) {
            aj.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hNs != null) {
                int F = this.hMZ != null ? v.F(this.hMZ.bMa()) : 0;
                this.hNs.setText(this.hNl.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(F), Integer.valueOf(this.hMZ.getMaxImagesAllowed())}));
                this.hNs.setEnabled(F > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sw;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hNp != null && (sw = this.hNp.sw(this.bsN)) != null && sw.getFilePath() != null && sw.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hNq, z);
        }
    }

    private void WI() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.qW.setVisibility(0);
            bLU();
        }
    }

    public View bLR() {
        return this.hNt;
    }

    public void or(boolean z) {
        long j;
        if (this.hNl != null && this.hNt != null) {
            if (this.hNp != null) {
                ImageFileInfo sw = this.hNp.sw(this.bsN);
                j = sw != null ? com.baidu.tbadk.core.util.k.dE(sw.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hNl.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.O(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                aj.r(this.hNt, d.C0108d.cp_link_tip_a);
                this.hNt.setText(sb2);
                this.hNt.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            aj.r(this.hNt, d.C0108d.cp_cont_f);
            this.hNt.setText(string);
            this.hNt.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
