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
    private View Tl;
    private AlbumActivity hbA;
    private AlbumImagePagerAdapter hbE;
    private ImageView hbF;
    private View hbG;
    private TextView hbH;
    private TextView hbI;
    private c hbn;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aFG = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != AlbumImageBrowseFragment.this.hbG && view2 == AlbumImageBrowseFragment.this.hbF && AlbumImageBrowseFragment.this.hbE != null && AlbumImageBrowseFragment.this.hbn != null && AlbumImageBrowseFragment.this.hbA != null) {
                if (AlbumImageBrowseFragment.this.hbn.bBF()) {
                    AlbumImageBrowseFragment.this.hbA.showToast(d.k.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hbE.uR(AlbumImageBrowseFragment.this.aFG)) {
                    ImageFileInfo pN = AlbumImageBrowseFragment.this.hbE.pN(AlbumImageBrowseFragment.this.aFG);
                    if (AlbumImageBrowseFragment.this.hbn.isAdded(pN)) {
                        if (AlbumImageBrowseFragment.this.hbA.d(pN)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hbF, false);
                            AlbumImageBrowseFragment.this.hbA.f(pN, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.hbA.c(pN)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hbF, true);
                        AlbumImageBrowseFragment.this.hbA.f(pN, true);
                    }
                    AlbumImageBrowseFragment.this.bBA();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.aFG = i;
            if (AlbumImageBrowseFragment.this.hbE != null && AlbumImageBrowseFragment.this.hbn != null) {
                ImageFileInfo pN = AlbumImageBrowseFragment.this.hbE.pN(AlbumImageBrowseFragment.this.aFG);
                if (AlbumImageBrowseFragment.this.hbn.isAdded(pN)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hbF, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hbF, false);
                }
                if (pN == null || !pN.isGif()) {
                    AlbumImageBrowseFragment.this.hbI.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hbI.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.nn(AlbumImageBrowseFragment.this.hbn.isOriginalImg());
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
        this.hbA = (AlbumActivity) getBaseFragmentActivity();
        this.hbn = this.hbA.bBp();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Tl = layoutInflater.inflate(d.i.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.Tl.findViewById(d.g.img_back);
        this.hbF = (ImageView) this.Tl.findViewById(d.g.img_choose);
        this.mViewPager = (ViewPager) this.Tl.findViewById(d.g.viewPager);
        this.mNoDataView = this.Tl.findViewById(d.g.album_no_data);
        this.hbH = (TextView) this.Tl.findViewById(d.g.btn_next_step);
        this.hbI = (TextView) this.Tl.findViewById(d.g.original_select_btn);
        this.hbG = this.Tl.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hbA);
        this.hbH.setOnClickListener(this.hbA);
        this.hbF.setOnClickListener(this.mOnClickListener);
        this.hbI.setOnClickListener(this.hbA);
        this.hbG.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.Tl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBA() {
        this.hbA.bBn();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            PP();
        }
    }

    private void bBB() {
        List<ImageFileInfo> bBJ;
        int currentIndex;
        if (this.hbn == null && this.hbA != null) {
            this.hbn = this.hbA.bBp();
        }
        if (this.hbn != null && (bBJ = this.hbn.bBJ()) != null && (currentIndex = this.hbn.getCurrentIndex()) >= 0) {
            this.aFG = currentIndex;
            this.hbE = new AlbumImagePagerAdapter(this.hbA);
            this.mViewPager.setAdapter(this.hbE);
            if (this.aFG == 0 && bBJ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(bBJ, this.aFG);
                if (this.hbn.isAdded(imageFileInfo)) {
                    c(this.hbF, true);
                } else {
                    c(this.hbF, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hbI.setVisibility(8);
                } else {
                    this.hbI.setVisibility(0);
                }
            }
            this.hbE.setData(bBJ);
            this.mViewPager.setCurrentItem(this.aFG, false);
            nn(this.hbn.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hbE != null) {
            this.hbE.setData(null);
        }
    }

    public View bmv() {
        return this.mBackBtn;
    }

    public View bBC() {
        return this.hbH;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.Tl);
        ak.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hbn != null) {
            nn(this.hbn.isOriginalImg());
        }
        if (this.hbE != null) {
            this.hbE.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hbA != null) {
            ak.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hbH != null) {
                int v = this.hbn != null ? v.v(this.hbn.bBH()) : 0;
                this.hbH.setText(this.hbA.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(v), Integer.valueOf(this.hbn != null ? this.hbn.getMaxImagesAllowed() : 1)}));
                this.hbH.setEnabled(v > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo pN;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hbE != null && (pN = this.hbE.pN(this.aFG)) != null && pN.getFilePath() != null && pN.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hbF, z);
        }
    }

    private void PP() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bBB();
        }
    }

    public View bBy() {
        return this.hbI;
    }

    public void nn(boolean z) {
        long j;
        if (this.hbA != null && this.hbI != null) {
            if (this.hbE != null) {
                ImageFileInfo pN = this.hbE.pN(this.aFG);
                j = pN != null ? k.dM(pN.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hbA.getResources().getString(d.k.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(an.G(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ak.h(this.hbI, d.C0126d.cp_link_tip_a);
                this.hbI.setText(sb2);
                this.hbI.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ak.h(this.hbI, d.C0126d.cp_cont_f);
            this.hbI.setText(string);
            this.hbI.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
