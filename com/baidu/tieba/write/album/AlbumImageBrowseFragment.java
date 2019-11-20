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
    private ImageView Nj;
    private ImageView apv;
    private View apw;
    private TextView apx;
    private TextView apy;
    private c jNF;
    private AlbumActivity jNL;
    private AlbumImagePagerAdapter jNO;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int apz = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.apw && view == AlbumImageBrowseFragment.this.apv && AlbumImageBrowseFragment.this.jNO != null && AlbumImageBrowseFragment.this.jNF != null && AlbumImageBrowseFragment.this.jNL != null) {
                if (AlbumImageBrowseFragment.this.jNF.vX()) {
                    AlbumImageBrowseFragment.this.jNL.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jNO.ch(AlbumImageBrowseFragment.this.apz)) {
                    ImageFileInfo wd = AlbumImageBrowseFragment.this.jNO.wd(AlbumImageBrowseFragment.this.apz);
                    if (AlbumImageBrowseFragment.this.jNF.isAdded(wd)) {
                        if (AlbumImageBrowseFragment.this.jNL.f(wd)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apv, false);
                            AlbumImageBrowseFragment.this.jNL.f(wd, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jNL.e(wd)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apv, true);
                        AlbumImageBrowseFragment.this.jNL.f(wd, true);
                    }
                    AlbumImageBrowseFragment.this.vR();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.apz = i;
            if (AlbumImageBrowseFragment.this.jNO != null && AlbumImageBrowseFragment.this.jNF != null) {
                ImageFileInfo wd = AlbumImageBrowseFragment.this.jNO.wd(AlbumImageBrowseFragment.this.apz);
                if (AlbumImageBrowseFragment.this.jNF.isAdded(wd)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apv, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apv, false);
                }
                if (AlbumImageBrowseFragment.this.jNF != null && AlbumImageBrowseFragment.this.jNF.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jNF.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.apy.setVisibility(8);
                } else if (wd == null || !wd.isGif()) {
                    AlbumImageBrowseFragment.this.apy.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.apy.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.aQ(AlbumImageBrowseFragment.this.jNF.isOriginalImg());
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
        this.jNL = (AlbumActivity) getBaseFragmentActivity();
        this.jNF = this.jNL.cyd();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.Nj = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.apv = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.apx = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.apy = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.apw = this.mRoot.findViewById(R.id.layout_bottom);
        this.Nj.setOnClickListener(this.jNL);
        this.apx.setOnClickListener(this.jNL);
        this.apv.setOnClickListener(this.mOnClickListener);
        this.apy.setOnClickListener(this.jNL);
        this.apw.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jNF != null && this.jNF.getWriteImagesInfo() != null) {
            this.apy.setVisibility(this.jNF.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vR() {
        this.jNL.vE();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            vV();
        }
    }

    private void vS() {
        List<ImageFileInfo> wc;
        int currentIndex;
        boolean z = true;
        if (this.jNF == null && this.jNL != null) {
            this.jNF = this.jNL.cyd();
        }
        if (this.jNF != null && (wc = this.jNF.wc()) != null && (currentIndex = this.jNF.getCurrentIndex()) >= 0) {
            this.apz = currentIndex;
            this.jNO = new AlbumImagePagerAdapter(this.jNL);
            this.mViewPager.setAdapter(this.jNO);
            if (this.apz == 0 && wc != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(wc, this.apz);
                if (this.jNF.isAdded(imageFileInfo)) {
                    a(this.apv, true);
                } else {
                    a(this.apv, false);
                }
                if (this.jNF != null && this.jNF.getWriteImagesInfo() != null) {
                    z = this.jNF.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.apy.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.apy.setVisibility(8);
                } else {
                    this.apy.setVisibility(0);
                }
            }
            this.jNO.setData(wc);
            this.mViewPager.setCurrentItem(this.apz, false);
            aQ(this.jNF.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.jNO != null) {
            this.jNO.setData(null);
        }
    }

    public View vT() {
        return this.Nj;
    }

    public View vU() {
        return this.apx;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mRoot);
        am.setNavbarIconSrc(this.Nj, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.jNF != null) {
            aQ(this.jNF.isOriginalImg());
        }
        if (this.jNO != null) {
            this.jNO.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.jNL != null) {
            am.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.apx != null) {
                int count = this.jNF != null ? v.getCount(this.jNF.vZ()) : 0;
                this.apx.setText(this.jNL.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.jNF != null ? this.jNF.getMaxImagesAllowed() : 1)}));
                this.apx.setEnabled(count > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo wd;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jNO != null && (wd = this.jNO.wd(this.apz)) != null && wd.getFilePath() != null && wd.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.apv, z);
        }
    }

    private void vV() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            vS();
        }
    }

    public View vP() {
        return this.apy;
    }

    public void aQ(boolean z) {
        long j;
        if (this.jNL != null && this.apy != null) {
            if (this.jNO != null) {
                ImageFileInfo wd = this.jNO.wd(this.apz);
                j = wd != null ? m.getFileSize(wd.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.jNL.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.setViewTextColor(this.apy, (int) R.color.cp_link_tip_a);
                this.apy.setText(sb2);
                this.apy.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.setViewTextColor(this.apy, (int) R.color.cp_cont_f);
            this.apy.setText(string);
            this.apy.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
