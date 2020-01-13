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
/* loaded from: classes11.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView Uw;
    private ImageView axV;
    private View axW;
    private TextView axX;
    private TextView axY;
    private c kLU;
    private AlbumActivity kMa;
    private AlbumImagePagerAdapter kMd;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.axW && view == AlbumImageBrowseFragment.this.axV && AlbumImageBrowseFragment.this.kMd != null && AlbumImageBrowseFragment.this.kLU != null && AlbumImageBrowseFragment.this.kMa != null) {
                if (AlbumImageBrowseFragment.this.kLU.yl()) {
                    AlbumImageBrowseFragment.this.kMa.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.kMd.cA(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo yj = AlbumImageBrowseFragment.this.kMd.yj(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.kLU.isAdded(yj)) {
                        if (AlbumImageBrowseFragment.this.kMa.f(yj)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axV, false);
                            AlbumImageBrowseFragment.this.kMa.f(yj, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.kMa.e(yj)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axV, true);
                        AlbumImageBrowseFragment.this.kMa.f(yj, true);
                    }
                    AlbumImageBrowseFragment.this.yf();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.kMd != null && AlbumImageBrowseFragment.this.kLU != null) {
                ImageFileInfo yj = AlbumImageBrowseFragment.this.kMd.yj(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.kLU.isAdded(yj)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axV, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axV, false);
                }
                if (AlbumImageBrowseFragment.this.kLU != null && AlbumImageBrowseFragment.this.kLU.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.kLU.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.axY.setVisibility(8);
                } else if (yj == null || !yj.isGif()) {
                    AlbumImageBrowseFragment.this.axY.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.axY.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bl(AlbumImageBrowseFragment.this.kLU.isOriginalImg());
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
        this.kMa = (AlbumActivity) getBaseFragmentActivity();
        this.kLU = this.kMa.cTi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.Uw = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.axV = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.axX = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.axY = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.axW = this.mRoot.findViewById(R.id.layout_bottom);
        this.Uw.setOnClickListener(this.kMa);
        this.axX.setOnClickListener(this.kMa);
        this.axV.setOnClickListener(this.mOnClickListener);
        this.axY.setOnClickListener(this.kMa);
        this.axW.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kLU != null && this.kLU.getWriteImagesInfo() != null) {
            this.axY.setVisibility(this.kLU.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yf() {
        this.kMa.xS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            yj();
        }
    }

    private void yg() {
        List<ImageFileInfo> yq;
        int currentIndex;
        boolean z = true;
        if (this.kLU == null && this.kMa != null) {
            this.kLU = this.kMa.cTi();
        }
        if (this.kLU != null && (yq = this.kLU.yq()) != null && (currentIndex = this.kLU.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.kMd = new AlbumImagePagerAdapter(this.kMa);
            this.mViewPager.setAdapter(this.kMd);
            if (this.mCurrentIndex == 0 && yq != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(yq, this.mCurrentIndex);
                if (this.kLU.isAdded(imageFileInfo)) {
                    a(this.axV, true);
                } else {
                    a(this.axV, false);
                }
                if (this.kLU != null && this.kLU.getWriteImagesInfo() != null) {
                    z = this.kLU.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.axY.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.axY.setVisibility(8);
                } else {
                    this.axY.setVisibility(0);
                }
            }
            this.kMd.setData(yq);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bl(this.kLU.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.kMd != null) {
            this.kMd.setData(null);
        }
    }

    public View yh() {
        return this.Uw;
    }

    public View yi() {
        return this.axX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mRoot);
        am.setNavbarIconSrc(this.Uw, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.kLU != null) {
            bl(this.kLU.isOriginalImg());
        }
        if (this.kMd != null) {
            this.kMd.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.kMa != null) {
            am.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.axX != null) {
                int count = this.kLU != null ? v.getCount(this.kLU.yn()) : 0;
                this.axX.setText(this.kMa.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kLU != null ? this.kLU.getMaxImagesAllowed() : 1)}));
                this.axX.setEnabled(count > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo yj;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.kMd != null && (yj = this.kMd.yj(this.mCurrentIndex)) != null && yj.getFilePath() != null && yj.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.axV, z);
        }
    }

    private void yj() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            yg();
        }
    }

    public View yd() {
        return this.axY;
    }

    public void bl(boolean z) {
        long j;
        if (this.kMa != null && this.axY != null) {
            if (this.kMd != null) {
                ImageFileInfo yj = this.kMd.yj(this.mCurrentIndex);
                j = yj != null ? m.getFileSize(yj.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.kMa.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.setViewTextColor(this.axY, (int) R.color.cp_link_tip_a);
                this.axY.setText(sb2);
                this.axY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.setViewTextColor(this.axY, (int) R.color.cp_cont_f);
            this.axY.setText(string);
            this.axY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
