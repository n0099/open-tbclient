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
/* loaded from: classes10.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView Ug;
    private ImageView axm;
    private View axn;
    private TextView axo;
    private TextView axp;
    private AlbumImagePagerAdapter kIC;
    private c kIt;
    private AlbumActivity kIz;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.axn && view == AlbumImageBrowseFragment.this.axm && AlbumImageBrowseFragment.this.kIC != null && AlbumImageBrowseFragment.this.kIt != null && AlbumImageBrowseFragment.this.kIz != null) {
                if (AlbumImageBrowseFragment.this.kIt.xV()) {
                    AlbumImageBrowseFragment.this.kIz.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.kIC.cz(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo ye = AlbumImageBrowseFragment.this.kIC.ye(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.kIt.isAdded(ye)) {
                        if (AlbumImageBrowseFragment.this.kIz.f(ye)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axm, false);
                            AlbumImageBrowseFragment.this.kIz.f(ye, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.kIz.e(ye)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axm, true);
                        AlbumImageBrowseFragment.this.kIz.f(ye, true);
                    }
                    AlbumImageBrowseFragment.this.xP();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.kIC != null && AlbumImageBrowseFragment.this.kIt != null) {
                ImageFileInfo ye = AlbumImageBrowseFragment.this.kIC.ye(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.kIt.isAdded(ye)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axm, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axm, false);
                }
                if (AlbumImageBrowseFragment.this.kIt != null && AlbumImageBrowseFragment.this.kIt.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.kIt.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.axp.setVisibility(8);
                } else if (ye == null || !ye.isGif()) {
                    AlbumImageBrowseFragment.this.axp.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.axp.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bh(AlbumImageBrowseFragment.this.kIt.isOriginalImg());
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
        this.kIz = (AlbumActivity) getBaseFragmentActivity();
        this.kIt = this.kIz.cSf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.Ug = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.axm = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.axo = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.axp = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.axn = this.mRoot.findViewById(R.id.layout_bottom);
        this.Ug.setOnClickListener(this.kIz);
        this.axo.setOnClickListener(this.kIz);
        this.axm.setOnClickListener(this.mOnClickListener);
        this.axp.setOnClickListener(this.kIz);
        this.axn.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kIt != null && this.kIt.getWriteImagesInfo() != null) {
            this.axp.setVisibility(this.kIt.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xP() {
        this.kIz.xC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            xT();
        }
    }

    private void xQ() {
        List<ImageFileInfo> ya;
        int currentIndex;
        boolean z = true;
        if (this.kIt == null && this.kIz != null) {
            this.kIt = this.kIz.cSf();
        }
        if (this.kIt != null && (ya = this.kIt.ya()) != null && (currentIndex = this.kIt.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.kIC = new AlbumImagePagerAdapter(this.kIz);
            this.mViewPager.setAdapter(this.kIC);
            if (this.mCurrentIndex == 0 && ya != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(ya, this.mCurrentIndex);
                if (this.kIt.isAdded(imageFileInfo)) {
                    a(this.axm, true);
                } else {
                    a(this.axm, false);
                }
                if (this.kIt != null && this.kIt.getWriteImagesInfo() != null) {
                    z = this.kIt.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.axp.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.axp.setVisibility(8);
                } else {
                    this.axp.setVisibility(0);
                }
            }
            this.kIC.setData(ya);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bh(this.kIt.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.kIC != null) {
            this.kIC.setData(null);
        }
    }

    public View xR() {
        return this.Ug;
    }

    public View xS() {
        return this.axo;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mRoot);
        am.setNavbarIconSrc(this.Ug, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.kIt != null) {
            bh(this.kIt.isOriginalImg());
        }
        if (this.kIC != null) {
            this.kIC.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.kIz != null) {
            am.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.axo != null) {
                int count = this.kIt != null ? v.getCount(this.kIt.xX()) : 0;
                this.axo.setText(this.kIz.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kIt != null ? this.kIt.getMaxImagesAllowed() : 1)}));
                this.axo.setEnabled(count > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo ye;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.kIC != null && (ye = this.kIC.ye(this.mCurrentIndex)) != null && ye.getFilePath() != null && ye.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.axm, z);
        }
    }

    private void xT() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            xQ();
        }
    }

    public View xN() {
        return this.axp;
    }

    public void bh(boolean z) {
        long j;
        if (this.kIz != null && this.axp != null) {
            if (this.kIC != null) {
                ImageFileInfo ye = this.kIC.ye(this.mCurrentIndex);
                j = ye != null ? m.getFileSize(ye.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.kIz.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.setViewTextColor(this.axp, (int) R.color.cp_link_tip_a);
                this.axp.setText(sb2);
                this.axp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.setViewTextColor(this.axp, (int) R.color.cp_cont_f);
            this.axp.setText(string);
            this.axp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
