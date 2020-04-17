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
/* loaded from: classes2.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView aWi;
    private View aWj;
    private TextView aWk;
    private TextView aWl;
    private ImageView aor;
    private c lxT;
    private AlbumActivity lya;
    private AlbumImagePagerAdapter lyd;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.aWj && view == AlbumImageBrowseFragment.this.aWi && AlbumImageBrowseFragment.this.lyd != null && AlbumImageBrowseFragment.this.lxT != null && AlbumImageBrowseFragment.this.lya != null) {
                if (AlbumImageBrowseFragment.this.lxT.FJ()) {
                    AlbumImageBrowseFragment.this.lya.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.lyd.df(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo yZ = AlbumImageBrowseFragment.this.lyd.yZ(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.lxT.isAdded(yZ)) {
                        if (AlbumImageBrowseFragment.this.lya.f(yZ)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWi, false);
                            AlbumImageBrowseFragment.this.lya.f(yZ, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.lya.e(yZ)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWi, true);
                        AlbumImageBrowseFragment.this.lya.f(yZ, true);
                    }
                    AlbumImageBrowseFragment.this.FD();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.lyd != null && AlbumImageBrowseFragment.this.lxT != null) {
                ImageFileInfo yZ = AlbumImageBrowseFragment.this.lyd.yZ(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.lxT.isAdded(yZ)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWi, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWi, false);
                }
                if (AlbumImageBrowseFragment.this.lxT != null && AlbumImageBrowseFragment.this.lxT.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.lxT.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.aWl.setVisibility(8);
                } else if (yZ == null || !yZ.isGif()) {
                    AlbumImageBrowseFragment.this.aWl.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.aWl.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bY(AlbumImageBrowseFragment.this.lxT.isOriginalImg());
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
        this.lya = (AlbumActivity) getBaseFragmentActivity();
        this.lxT = this.lya.dfs();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aor = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.aWi = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.aWk = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.aWl = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.aWj = this.mRoot.findViewById(R.id.layout_bottom);
        this.aor.setOnClickListener(this.lya);
        this.aWk.setOnClickListener(this.lya);
        this.aWi.setOnClickListener(this.mOnClickListener);
        this.aWl.setOnClickListener(this.lya);
        this.aWj.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.lxT != null && this.lxT.getWriteImagesInfo() != null) {
            this.aWl.setVisibility(this.lxT.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        this.lya.Fq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            FH();
        }
    }

    private void FE() {
        List<ImageFileInfo> FO;
        int currentIndex;
        boolean z = true;
        if (this.lxT == null && this.lya != null) {
            this.lxT = this.lya.dfs();
        }
        if (this.lxT != null && (FO = this.lxT.FO()) != null && (currentIndex = this.lxT.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.lyd = new AlbumImagePagerAdapter(this.lya);
            this.mViewPager.setAdapter(this.lyd);
            if (this.mCurrentIndex == 0 && FO != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(FO, this.mCurrentIndex);
                if (this.lxT.isAdded(imageFileInfo)) {
                    a(this.aWi, true);
                } else {
                    a(this.aWi, false);
                }
                if (this.lxT != null && this.lxT.getWriteImagesInfo() != null) {
                    z = this.lxT.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.aWl.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.aWl.setVisibility(8);
                } else {
                    this.aWl.setVisibility(0);
                }
            }
            this.lyd.setData(FO);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bY(this.lxT.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.lyd != null) {
            this.lyd.setData(null);
        }
    }

    public View FF() {
        return this.aor;
    }

    public View FG() {
        return this.aWk;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mRoot);
        am.setNavbarIconSrc(this.aor, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.lxT != null) {
            bY(this.lxT.isOriginalImg());
        }
        if (this.lyd != null) {
            this.lyd.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.lya != null) {
            am.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.aWk != null) {
                int count = this.lxT != null ? v.getCount(this.lxT.FL()) : 0;
                this.aWk.setText(this.lya.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.lxT != null ? this.lxT.getMaxImagesAllowed() : 1)}));
                this.aWk.setEnabled(count > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo yZ;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.lyd != null && (yZ = this.lyd.yZ(this.mCurrentIndex)) != null && yZ.getFilePath() != null && yZ.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aWi, z);
        }
    }

    private void FH() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            FE();
        }
    }

    public View FB() {
        return this.aWl;
    }

    public void bY(boolean z) {
        long j;
        if (this.lya != null && this.aWl != null) {
            if (this.lyd != null) {
                ImageFileInfo yZ = this.lyd.yZ(this.mCurrentIndex);
                j = yZ != null ? m.getFileSize(yZ.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.lya.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.setViewTextColor(this.aWl, (int) R.color.cp_link_tip_a);
                this.aWl.setText(sb2);
                this.aWl.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.setViewTextColor(this.aWl, (int) R.color.cp_cont_f);
            this.aWl.setText(string);
            this.aWl.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
