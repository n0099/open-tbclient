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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private c jMH;
    private AlbumActivity jMV;
    private AlbumImagePagerAdapter jMZ;
    private ImageView jNa;
    private View jNb;
    private TextView jNc;
    private TextView jNd;
    private ImageView mBackBtn;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int bpM = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.jNb && view == AlbumImageBrowseFragment.this.jNa && AlbumImageBrowseFragment.this.jMZ != null && AlbumImageBrowseFragment.this.jMH != null && AlbumImageBrowseFragment.this.jMV != null) {
                if (AlbumImageBrowseFragment.this.jMH.cAe()) {
                    AlbumImageBrowseFragment.this.jMV.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jMZ.CT(AlbumImageBrowseFragment.this.bpM)) {
                    ImageFileInfo xt = AlbumImageBrowseFragment.this.jMZ.xt(AlbumImageBrowseFragment.this.bpM);
                    if (AlbumImageBrowseFragment.this.jMH.isAdded(xt)) {
                        if (AlbumImageBrowseFragment.this.jMV.f(xt)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jNa, false);
                            AlbumImageBrowseFragment.this.jMV.f(xt, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jMV.e(xt)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jNa, true);
                        AlbumImageBrowseFragment.this.jMV.f(xt, true);
                    }
                    AlbumImageBrowseFragment.this.czZ();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.bpM = i;
            if (AlbumImageBrowseFragment.this.jMZ != null && AlbumImageBrowseFragment.this.jMH != null) {
                ImageFileInfo xt = AlbumImageBrowseFragment.this.jMZ.xt(AlbumImageBrowseFragment.this.bpM);
                if (AlbumImageBrowseFragment.this.jMH.isAdded(xt)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jNa, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jNa, false);
                }
                if (AlbumImageBrowseFragment.this.jMH != null && AlbumImageBrowseFragment.this.jMH.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jMH.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.jNd.setVisibility(8);
                } else if (xt == null || !xt.isGif()) {
                    AlbumImageBrowseFragment.this.jNd.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.jNd.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.se(AlbumImageBrowseFragment.this.jMH.isOriginalImg());
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
        this.jMV = (AlbumActivity) getBaseFragmentActivity();
        this.jMH = this.jMV.czP();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.jNa = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.jNc = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.jNd = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.jNb = this.mRoot.findViewById(R.id.layout_bottom);
        this.mBackBtn.setOnClickListener(this.jMV);
        this.jNc.setOnClickListener(this.jMV);
        this.jNa.setOnClickListener(this.mOnClickListener);
        this.jNd.setOnClickListener(this.jMV);
        this.jNb.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jMH != null && this.jMH.getWriteImagesInfo() != null) {
            this.jNd.setVisibility(this.jMH.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czZ() {
        this.jMV.czN();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aJi();
        }
    }

    private void cAa() {
        List<ImageFileInfo> cAi;
        int currentIndex;
        boolean z = true;
        if (this.jMH == null && this.jMV != null) {
            this.jMH = this.jMV.czP();
        }
        if (this.jMH != null && (cAi = this.jMH.cAi()) != null && (currentIndex = this.jMH.getCurrentIndex()) >= 0) {
            this.bpM = currentIndex;
            this.jMZ = new AlbumImagePagerAdapter(this.jMV);
            this.mViewPager.setAdapter(this.jMZ);
            if (this.bpM == 0 && cAi != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(cAi, this.bpM);
                if (this.jMH.isAdded(imageFileInfo)) {
                    c(this.jNa, true);
                } else {
                    c(this.jNa, false);
                }
                if (this.jMH != null && this.jMH.getWriteImagesInfo() != null) {
                    z = this.jMH.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.jNd.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.jNd.setVisibility(8);
                } else {
                    this.jNd.setVisibility(0);
                }
            }
            this.jMZ.setData(cAi);
            this.mViewPager.setCurrentItem(this.bpM, false);
            se(this.jMH.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.jMZ != null) {
            this.jMZ.setData(null);
        }
    }

    public View ckO() {
        return this.mBackBtn;
    }

    public View cAb() {
        return this.jNc;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mRoot);
        am.a(this.mBackBtn, (int) R.drawable.icon_return_bg_s, (int) R.drawable.icon_return_bg, i);
        if (this.jMH != null) {
            se(this.jMH.isOriginalImg());
        }
        if (this.jMZ != null) {
            this.jMZ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.jMV != null) {
            am.c(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.jNc != null) {
                int Z = this.jMH != null ? v.Z(this.jMH.cAg()) : 0;
                this.jNc.setText(this.jMV.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(Z), Integer.valueOf(this.jMH != null ? this.jMH.getMaxImagesAllowed() : 1)}));
                this.jNc.setEnabled(Z > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo xt;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jMZ != null && (xt = this.jMZ.xt(this.bpM)) != null && xt.getFilePath() != null && xt.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.jNa, z);
        }
    }

    private void aJi() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            cAa();
        }
    }

    public View czX() {
        return this.jNd;
    }

    public void se(boolean z) {
        long j;
        if (this.jMV != null && this.jNd != null) {
            if (this.jMZ != null) {
                ImageFileInfo xt = this.jMZ.xt(this.bpM);
                j = xt != null ? m.ju(xt.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.jMV.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.aU(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.j(this.jNd, R.color.cp_link_tip_a);
                this.jNd.setText(sb2);
                this.jNd.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.j(this.jNd, R.color.cp_cont_f);
            this.jNd.setText(string);
            this.jNd.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
