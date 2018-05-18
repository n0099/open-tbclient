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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private View Th;
    private AlbumActivity hcB;
    private AlbumImagePagerAdapter hcF;
    private ImageView hcG;
    private View hcH;
    private TextView hcI;
    private TextView hcJ;
    private c hco;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aFH = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != AlbumImageBrowseFragment.this.hcH && view2 == AlbumImageBrowseFragment.this.hcG && AlbumImageBrowseFragment.this.hcF != null && AlbumImageBrowseFragment.this.hco != null && AlbumImageBrowseFragment.this.hcB != null) {
                if (AlbumImageBrowseFragment.this.hco.bBD()) {
                    AlbumImageBrowseFragment.this.hcB.showToast(d.k.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hcF.uQ(AlbumImageBrowseFragment.this.aFH)) {
                    ImageFileInfo pM = AlbumImageBrowseFragment.this.hcF.pM(AlbumImageBrowseFragment.this.aFH);
                    if (AlbumImageBrowseFragment.this.hco.isAdded(pM)) {
                        if (AlbumImageBrowseFragment.this.hcB.d(pM)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hcG, false);
                            AlbumImageBrowseFragment.this.hcB.f(pM, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.hcB.c(pM)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hcG, true);
                        AlbumImageBrowseFragment.this.hcB.f(pM, true);
                    }
                    AlbumImageBrowseFragment.this.bBy();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.aFH = i;
            if (AlbumImageBrowseFragment.this.hcF != null && AlbumImageBrowseFragment.this.hco != null) {
                ImageFileInfo pM = AlbumImageBrowseFragment.this.hcF.pM(AlbumImageBrowseFragment.this.aFH);
                if (AlbumImageBrowseFragment.this.hco.isAdded(pM)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hcG, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hcG, false);
                }
                if (pM == null || !pM.isGif()) {
                    AlbumImageBrowseFragment.this.hcJ.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hcJ.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.no(AlbumImageBrowseFragment.this.hco.isOriginalImg());
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
        this.hcB = (AlbumActivity) getBaseFragmentActivity();
        this.hco = this.hcB.bBn();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Th = layoutInflater.inflate(d.i.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.Th.findViewById(d.g.img_back);
        this.hcG = (ImageView) this.Th.findViewById(d.g.img_choose);
        this.mViewPager = (ViewPager) this.Th.findViewById(d.g.viewPager);
        this.mNoDataView = this.Th.findViewById(d.g.album_no_data);
        this.hcI = (TextView) this.Th.findViewById(d.g.btn_next_step);
        this.hcJ = (TextView) this.Th.findViewById(d.g.original_select_btn);
        this.hcH = this.Th.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hcB);
        this.hcI.setOnClickListener(this.hcB);
        this.hcG.setOnClickListener(this.mOnClickListener);
        this.hcJ.setOnClickListener(this.hcB);
        this.hcH.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.Th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBy() {
        this.hcB.bBl();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            PM();
        }
    }

    private void bBz() {
        List<ImageFileInfo> bBH;
        int currentIndex;
        if (this.hco == null && this.hcB != null) {
            this.hco = this.hcB.bBn();
        }
        if (this.hco != null && (bBH = this.hco.bBH()) != null && (currentIndex = this.hco.getCurrentIndex()) >= 0) {
            this.aFH = currentIndex;
            this.hcF = new AlbumImagePagerAdapter(this.hcB);
            this.mViewPager.setAdapter(this.hcF);
            if (this.aFH == 0 && bBH != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(bBH, this.aFH);
                if (this.hco.isAdded(imageFileInfo)) {
                    c(this.hcG, true);
                } else {
                    c(this.hcG, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hcJ.setVisibility(8);
                } else {
                    this.hcJ.setVisibility(0);
                }
            }
            this.hcF.setData(bBH);
            this.mViewPager.setCurrentItem(this.aFH, false);
            no(this.hco.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hcF != null) {
            this.hcF.setData(null);
        }
    }

    public View bmu() {
        return this.mBackBtn;
    }

    public View bBA() {
        return this.hcI;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.Th);
        ak.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hco != null) {
            no(this.hco.isOriginalImg());
        }
        if (this.hcF != null) {
            this.hcF.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hcB != null) {
            ak.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hcI != null) {
                int v = this.hco != null ? v.v(this.hco.bBF()) : 0;
                this.hcI.setText(this.hcB.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(v), Integer.valueOf(this.hco != null ? this.hco.getMaxImagesAllowed() : 1)}));
                this.hcI.setEnabled(v > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo pM;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hcF != null && (pM = this.hcF.pM(this.aFH)) != null && pM.getFilePath() != null && pM.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hcG, z);
        }
    }

    private void PM() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bBz();
        }
    }

    public View bBw() {
        return this.hcJ;
    }

    public void no(boolean z) {
        long j;
        if (this.hcB != null && this.hcJ != null) {
            if (this.hcF != null) {
                ImageFileInfo pM = this.hcF.pM(this.aFH);
                j = pM != null ? k.dM(pM.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hcB.getResources().getString(d.k.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(an.G(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ak.h(this.hcJ, d.C0126d.cp_link_tip_a);
                this.hcJ.setText(sb2);
                this.hcJ.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ak.h(this.hcJ, d.C0126d.cp_cont_f);
            this.hcJ.setText(string);
            this.hcJ.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
