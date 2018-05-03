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
    private AlbumImagePagerAdapter hbB;
    private ImageView hbC;
    private View hbD;
    private TextView hbE;
    private TextView hbF;
    private c hbk;
    private AlbumActivity hbx;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aFG = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != AlbumImageBrowseFragment.this.hbD && view2 == AlbumImageBrowseFragment.this.hbC && AlbumImageBrowseFragment.this.hbB != null && AlbumImageBrowseFragment.this.hbk != null && AlbumImageBrowseFragment.this.hbx != null) {
                if (AlbumImageBrowseFragment.this.hbk.bBF()) {
                    AlbumImageBrowseFragment.this.hbx.showToast(d.k.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hbB.uR(AlbumImageBrowseFragment.this.aFG)) {
                    ImageFileInfo pN = AlbumImageBrowseFragment.this.hbB.pN(AlbumImageBrowseFragment.this.aFG);
                    if (AlbumImageBrowseFragment.this.hbk.isAdded(pN)) {
                        if (AlbumImageBrowseFragment.this.hbx.d(pN)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hbC, false);
                            AlbumImageBrowseFragment.this.hbx.f(pN, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.hbx.c(pN)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hbC, true);
                        AlbumImageBrowseFragment.this.hbx.f(pN, true);
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
            if (AlbumImageBrowseFragment.this.hbB != null && AlbumImageBrowseFragment.this.hbk != null) {
                ImageFileInfo pN = AlbumImageBrowseFragment.this.hbB.pN(AlbumImageBrowseFragment.this.aFG);
                if (AlbumImageBrowseFragment.this.hbk.isAdded(pN)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hbC, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hbC, false);
                }
                if (pN == null || !pN.isGif()) {
                    AlbumImageBrowseFragment.this.hbF.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hbF.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.nn(AlbumImageBrowseFragment.this.hbk.isOriginalImg());
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
        this.hbx = (AlbumActivity) getBaseFragmentActivity();
        this.hbk = this.hbx.bBp();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Tl = layoutInflater.inflate(d.i.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.Tl.findViewById(d.g.img_back);
        this.hbC = (ImageView) this.Tl.findViewById(d.g.img_choose);
        this.mViewPager = (ViewPager) this.Tl.findViewById(d.g.viewPager);
        this.mNoDataView = this.Tl.findViewById(d.g.album_no_data);
        this.hbE = (TextView) this.Tl.findViewById(d.g.btn_next_step);
        this.hbF = (TextView) this.Tl.findViewById(d.g.original_select_btn);
        this.hbD = this.Tl.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hbx);
        this.hbE.setOnClickListener(this.hbx);
        this.hbC.setOnClickListener(this.mOnClickListener);
        this.hbF.setOnClickListener(this.hbx);
        this.hbD.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.Tl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBA() {
        this.hbx.bBn();
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
        if (this.hbk == null && this.hbx != null) {
            this.hbk = this.hbx.bBp();
        }
        if (this.hbk != null && (bBJ = this.hbk.bBJ()) != null && (currentIndex = this.hbk.getCurrentIndex()) >= 0) {
            this.aFG = currentIndex;
            this.hbB = new AlbumImagePagerAdapter(this.hbx);
            this.mViewPager.setAdapter(this.hbB);
            if (this.aFG == 0 && bBJ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(bBJ, this.aFG);
                if (this.hbk.isAdded(imageFileInfo)) {
                    c(this.hbC, true);
                } else {
                    c(this.hbC, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hbF.setVisibility(8);
                } else {
                    this.hbF.setVisibility(0);
                }
            }
            this.hbB.setData(bBJ);
            this.mViewPager.setCurrentItem(this.aFG, false);
            nn(this.hbk.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hbB != null) {
            this.hbB.setData(null);
        }
    }

    public View bmv() {
        return this.mBackBtn;
    }

    public View bBC() {
        return this.hbE;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.Tl);
        ak.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hbk != null) {
            nn(this.hbk.isOriginalImg());
        }
        if (this.hbB != null) {
            this.hbB.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hbx != null) {
            ak.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hbE != null) {
                int v = this.hbk != null ? v.v(this.hbk.bBH()) : 0;
                this.hbE.setText(this.hbx.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(v), Integer.valueOf(this.hbk != null ? this.hbk.getMaxImagesAllowed() : 1)}));
                this.hbE.setEnabled(v > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo pN;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hbB != null && (pN = this.hbB.pN(this.aFG)) != null && pN.getFilePath() != null && pN.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hbC, z);
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
        return this.hbF;
    }

    public void nn(boolean z) {
        long j;
        if (this.hbx != null && this.hbF != null) {
            if (this.hbB != null) {
                ImageFileInfo pN = this.hbB.pN(this.aFG);
                j = pN != null ? k.dM(pN.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hbx.getResources().getString(d.k.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(an.G(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ak.h(this.hbF, d.C0126d.cp_link_tip_a);
                this.hbF.setText(sb2);
                this.hbF.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ak.h(this.hbF, d.C0126d.cp_cont_f);
            this.hbF.setText(string);
            this.hbF.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
