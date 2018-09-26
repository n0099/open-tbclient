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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private View adA;
    private AlbumActivity hBK;
    private AlbumImagePagerAdapter hBO;
    private ImageView hBP;
    private View hBQ;
    private TextView hBR;
    private TextView hBS;
    private c hBx;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aSn = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.hBQ && view == AlbumImageBrowseFragment.this.hBP && AlbumImageBrowseFragment.this.hBO != null && AlbumImageBrowseFragment.this.hBx != null && AlbumImageBrowseFragment.this.hBK != null) {
                if (AlbumImageBrowseFragment.this.hBx.bIP()) {
                    AlbumImageBrowseFragment.this.hBK.showToast(e.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hBO.vQ(AlbumImageBrowseFragment.this.aSn)) {
                    ImageFileInfo qG = AlbumImageBrowseFragment.this.hBO.qG(AlbumImageBrowseFragment.this.aSn);
                    if (AlbumImageBrowseFragment.this.hBx.isAdded(qG)) {
                        if (AlbumImageBrowseFragment.this.hBK.d(qG)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hBP, false);
                            AlbumImageBrowseFragment.this.hBK.f(qG, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.hBK.c(qG)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hBP, true);
                        AlbumImageBrowseFragment.this.hBK.f(qG, true);
                    }
                    AlbumImageBrowseFragment.this.bIK();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.aSn = i;
            if (AlbumImageBrowseFragment.this.hBO != null && AlbumImageBrowseFragment.this.hBx != null) {
                ImageFileInfo qG = AlbumImageBrowseFragment.this.hBO.qG(AlbumImageBrowseFragment.this.aSn);
                if (AlbumImageBrowseFragment.this.hBx.isAdded(qG)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hBP, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hBP, false);
                }
                if (qG == null || !qG.isGif()) {
                    AlbumImageBrowseFragment.this.hBS.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hBS.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.nP(AlbumImageBrowseFragment.this.hBx.isOriginalImg());
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
        this.hBK = (AlbumActivity) getBaseFragmentActivity();
        this.hBx = this.hBK.bIz();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.adA = layoutInflater.inflate(e.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.adA.findViewById(e.g.img_back);
        this.hBP = (ImageView) this.adA.findViewById(e.g.img_choose);
        this.mViewPager = (ViewPager) this.adA.findViewById(e.g.viewPager);
        this.mNoDataView = this.adA.findViewById(e.g.album_no_data);
        this.hBR = (TextView) this.adA.findViewById(e.g.btn_next_step);
        this.hBS = (TextView) this.adA.findViewById(e.g.original_select_btn);
        this.hBQ = this.adA.findViewById(e.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hBK);
        this.hBR.setOnClickListener(this.hBK);
        this.hBP.setOnClickListener(this.mOnClickListener);
        this.hBS.setOnClickListener(this.hBK);
        this.hBQ.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.adA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIK() {
        this.hBK.bIx();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            VC();
        }
    }

    private void bIL() {
        List<ImageFileInfo> bIT;
        int currentIndex;
        if (this.hBx == null && this.hBK != null) {
            this.hBx = this.hBK.bIz();
        }
        if (this.hBx != null && (bIT = this.hBx.bIT()) != null && (currentIndex = this.hBx.getCurrentIndex()) >= 0) {
            this.aSn = currentIndex;
            this.hBO = new AlbumImagePagerAdapter(this.hBK);
            this.mViewPager.setAdapter(this.hBO);
            if (this.aSn == 0 && bIT != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(bIT, this.aSn);
                if (this.hBx.isAdded(imageFileInfo)) {
                    c(this.hBP, true);
                } else {
                    c(this.hBP, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hBS.setVisibility(8);
                } else {
                    this.hBS.setVisibility(0);
                }
            }
            this.hBO.setData(bIT);
            this.mViewPager.setCurrentItem(this.aSn, false);
            nP(this.hBx.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hBO != null) {
            this.hBO.setData(null);
        }
    }

    public View btb() {
        return this.mBackBtn;
    }

    public View bIM() {
        return this.hBR;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.adA);
        al.a(this.mBackBtn, e.f.icon_return_bg_s, e.f.icon_return_bg, i);
        if (this.hBx != null) {
            nP(this.hBx.isOriginalImg());
        }
        if (this.hBO != null) {
            this.hBO.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hBK != null) {
            al.c(imageView, z ? e.f.ic_post_edit_select_s : e.f.icon_image_clear_select);
            if (this.hBR != null) {
                int y = this.hBx != null ? v.y(this.hBx.bIR()) : 0;
                this.hBR.setText(this.hBK.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(y), Integer.valueOf(this.hBx != null ? this.hBx.getMaxImagesAllowed() : 1)}));
                this.hBR.setEnabled(y > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo qG;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hBO != null && (qG = this.hBO.qG(this.aSn)) != null && qG.getFilePath() != null && qG.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hBP, z);
        }
    }

    private void VC() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bIL();
        }
    }

    public View bII() {
        return this.hBS;
    }

    public void nP(boolean z) {
        long j;
        if (this.hBK != null && this.hBS != null) {
            if (this.hBO != null) {
                ImageFileInfo qG = this.hBO.qG(this.aSn);
                j = qG != null ? l.eF(qG.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hBK.getResources().getString(e.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ao.Q(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.h(this.hBS, e.d.cp_link_tip_a);
                this.hBS.setText(sb2);
                this.hBS.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.h(this.hBS, e.d.cp_cont_f);
            this.hBS.setText(string);
            this.hBS.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
