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
    private c kLZ;
    private AlbumActivity kMf;
    private AlbumImagePagerAdapter kMi;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.axW && view == AlbumImageBrowseFragment.this.axV && AlbumImageBrowseFragment.this.kMi != null && AlbumImageBrowseFragment.this.kLZ != null && AlbumImageBrowseFragment.this.kMf != null) {
                if (AlbumImageBrowseFragment.this.kLZ.yl()) {
                    AlbumImageBrowseFragment.this.kMf.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.kMi.cA(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo yj = AlbumImageBrowseFragment.this.kMi.yj(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.kLZ.isAdded(yj)) {
                        if (AlbumImageBrowseFragment.this.kMf.f(yj)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axV, false);
                            AlbumImageBrowseFragment.this.kMf.f(yj, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.kMf.e(yj)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axV, true);
                        AlbumImageBrowseFragment.this.kMf.f(yj, true);
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
            if (AlbumImageBrowseFragment.this.kMi != null && AlbumImageBrowseFragment.this.kLZ != null) {
                ImageFileInfo yj = AlbumImageBrowseFragment.this.kMi.yj(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.kLZ.isAdded(yj)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axV, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axV, false);
                }
                if (AlbumImageBrowseFragment.this.kLZ != null && AlbumImageBrowseFragment.this.kLZ.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.kLZ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.axY.setVisibility(8);
                } else if (yj == null || !yj.isGif()) {
                    AlbumImageBrowseFragment.this.axY.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.axY.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bl(AlbumImageBrowseFragment.this.kLZ.isOriginalImg());
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
        this.kMf = (AlbumActivity) getBaseFragmentActivity();
        this.kLZ = this.kMf.cTk();
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
        this.Uw.setOnClickListener(this.kMf);
        this.axX.setOnClickListener(this.kMf);
        this.axV.setOnClickListener(this.mOnClickListener);
        this.axY.setOnClickListener(this.kMf);
        this.axW.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kLZ != null && this.kLZ.getWriteImagesInfo() != null) {
            this.axY.setVisibility(this.kLZ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yf() {
        this.kMf.xS();
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
        if (this.kLZ == null && this.kMf != null) {
            this.kLZ = this.kMf.cTk();
        }
        if (this.kLZ != null && (yq = this.kLZ.yq()) != null && (currentIndex = this.kLZ.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.kMi = new AlbumImagePagerAdapter(this.kMf);
            this.mViewPager.setAdapter(this.kMi);
            if (this.mCurrentIndex == 0 && yq != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(yq, this.mCurrentIndex);
                if (this.kLZ.isAdded(imageFileInfo)) {
                    a(this.axV, true);
                } else {
                    a(this.axV, false);
                }
                if (this.kLZ != null && this.kLZ.getWriteImagesInfo() != null) {
                    z = this.kLZ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.axY.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.axY.setVisibility(8);
                } else {
                    this.axY.setVisibility(0);
                }
            }
            this.kMi.setData(yq);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bl(this.kLZ.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.kMi != null) {
            this.kMi.setData(null);
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
        if (this.kLZ != null) {
            bl(this.kLZ.isOriginalImg());
        }
        if (this.kMi != null) {
            this.kMi.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.kMf != null) {
            am.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.axX != null) {
                int count = this.kLZ != null ? v.getCount(this.kLZ.yn()) : 0;
                this.axX.setText(this.kMf.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kLZ != null ? this.kLZ.getMaxImagesAllowed() : 1)}));
                this.axX.setEnabled(count > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo yj;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.kMi != null && (yj = this.kMi.yj(this.mCurrentIndex)) != null && yj.getFilePath() != null && yj.getFilePath().equals(imageFileInfo.getFilePath())) {
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
        if (this.kMf != null && this.axY != null) {
            if (this.kMi != null) {
                ImageFileInfo yj = this.kMi.yj(this.mCurrentIndex);
                j = yj != null ? m.getFileSize(yj.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.kMf.getResources().getString(R.string.original_img);
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
