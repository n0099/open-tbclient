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
    private View amM;
    private c hRF;
    private AlbumActivity hRT;
    private AlbumImagePagerAdapter hRX;
    private ImageView hRY;
    private View hRZ;
    private TextView hSa;
    private TextView hSb;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.hRZ && view == AlbumImageBrowseFragment.this.hRY && AlbumImageBrowseFragment.this.hRX != null && AlbumImageBrowseFragment.this.hRF != null && AlbumImageBrowseFragment.this.hRT != null) {
                if (AlbumImageBrowseFragment.this.hRF.bNG()) {
                    AlbumImageBrowseFragment.this.hRT.showToast(e.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hRX.xd(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo rR = AlbumImageBrowseFragment.this.hRX.rR(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.hRF.isAdded(rR)) {
                        if (AlbumImageBrowseFragment.this.hRT.d(rR)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hRY, false);
                            AlbumImageBrowseFragment.this.hRT.f(rR, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.hRT.c(rR)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hRY, true);
                        AlbumImageBrowseFragment.this.hRT.f(rR, true);
                    }
                    AlbumImageBrowseFragment.this.bNB();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.hRX != null && AlbumImageBrowseFragment.this.hRF != null) {
                ImageFileInfo rR = AlbumImageBrowseFragment.this.hRX.rR(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.hRF.isAdded(rR)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hRY, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hRY, false);
                }
                if (AlbumImageBrowseFragment.this.hRF != null && AlbumImageBrowseFragment.this.hRF.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.hRF.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.hSb.setVisibility(8);
                } else if (rR == null || !rR.isGif()) {
                    AlbumImageBrowseFragment.this.hSb.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hSb.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.ov(AlbumImageBrowseFragment.this.hRF.isOriginalImg());
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
        this.hRT = (AlbumActivity) getBaseFragmentActivity();
        this.hRF = this.hRT.bNq();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.amM = layoutInflater.inflate(e.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.amM.findViewById(e.g.img_back);
        this.hRY = (ImageView) this.amM.findViewById(e.g.img_choose);
        this.mViewPager = (ViewPager) this.amM.findViewById(e.g.viewPager);
        this.mNoDataView = this.amM.findViewById(e.g.album_no_data);
        this.hSa = (TextView) this.amM.findViewById(e.g.btn_next_step);
        this.hSb = (TextView) this.amM.findViewById(e.g.original_select_btn);
        this.hRZ = this.amM.findViewById(e.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hRT);
        this.hSa.setOnClickListener(this.hRT);
        this.hRY.setOnClickListener(this.mOnClickListener);
        this.hSb.setOnClickListener(this.hRT);
        this.hRZ.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hRF != null && this.hRF.getWriteImagesInfo() != null) {
            this.hSb.setVisibility(this.hRF.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.amM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNB() {
        this.hRT.bNo();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aaA();
        }
    }

    private void bNC() {
        List<ImageFileInfo> bNK;
        int currentIndex;
        boolean z = true;
        if (this.hRF == null && this.hRT != null) {
            this.hRF = this.hRT.bNq();
        }
        if (this.hRF != null && (bNK = this.hRF.bNK()) != null && (currentIndex = this.hRF.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.hRX = new AlbumImagePagerAdapter(this.hRT);
            this.mViewPager.setAdapter(this.hRX);
            if (this.mCurrentIndex == 0 && bNK != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(bNK, this.mCurrentIndex);
                if (this.hRF.isAdded(imageFileInfo)) {
                    c(this.hRY, true);
                } else {
                    c(this.hRY, false);
                }
                if (this.hRF != null && this.hRF.getWriteImagesInfo() != null) {
                    z = this.hRF.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.hSb.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.hSb.setVisibility(8);
                } else {
                    this.hSb.setVisibility(0);
                }
            }
            this.hRX.setData(bNK);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            ov(this.hRF.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hRX != null) {
            this.hRX.setData(null);
        }
    }

    public View bxF() {
        return this.mBackBtn;
    }

    public View bND() {
        return this.hSa;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.amM);
        al.a(this.mBackBtn, e.f.icon_return_bg_s, e.f.icon_return_bg, i);
        if (this.hRF != null) {
            ov(this.hRF.isOriginalImg());
        }
        if (this.hRX != null) {
            this.hRX.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hRT != null) {
            al.c(imageView, z ? e.f.ic_post_edit_select_s : e.f.icon_image_clear_select);
            if (this.hSa != null) {
                int H = this.hRF != null ? v.H(this.hRF.bNI()) : 0;
                this.hSa.setText(this.hRT.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(H), Integer.valueOf(this.hRF != null ? this.hRF.getMaxImagesAllowed() : 1)}));
                this.hSa.setEnabled(H > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo rR;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hRX != null && (rR = this.hRX.rR(this.mCurrentIndex)) != null && rR.getFilePath() != null && rR.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hRY, z);
        }
    }

    private void aaA() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bNC();
        }
    }

    public View bNz() {
        return this.hSb;
    }

    public void ov(boolean z) {
        long j;
        if (this.hRT != null && this.hSb != null) {
            if (this.hRX != null) {
                ImageFileInfo rR = this.hRX.rR(this.mCurrentIndex);
                j = rR != null ? l.fn(rR.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hRT.getResources().getString(e.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ao.ab(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.h(this.hSb, e.d.cp_link_tip_a);
                this.hSb.setText(sb2);
                this.hSb.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.h(this.hSb, e.d.cp_cont_f);
            this.hSb.setText(string);
            this.hSb.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
