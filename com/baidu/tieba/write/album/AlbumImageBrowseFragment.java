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
/* loaded from: classes13.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView Wg;
    private ImageView aCl;
    private View aCm;
    private TextView aCn;
    private TextView aCo;
    private c kMF;
    private AlbumActivity kML;
    private AlbumImagePagerAdapter kMO;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.aCm && view == AlbumImageBrowseFragment.this.aCl && AlbumImageBrowseFragment.this.kMO != null && AlbumImageBrowseFragment.this.kMF != null && AlbumImageBrowseFragment.this.kML != null) {
                if (AlbumImageBrowseFragment.this.kMF.AC()) {
                    AlbumImageBrowseFragment.this.kML.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.kMO.cQ(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo yq = AlbumImageBrowseFragment.this.kMO.yq(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.kMF.isAdded(yq)) {
                        if (AlbumImageBrowseFragment.this.kML.f(yq)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCl, false);
                            AlbumImageBrowseFragment.this.kML.f(yq, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.kML.e(yq)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCl, true);
                        AlbumImageBrowseFragment.this.kML.f(yq, true);
                    }
                    AlbumImageBrowseFragment.this.Aw();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.kMO != null && AlbumImageBrowseFragment.this.kMF != null) {
                ImageFileInfo yq = AlbumImageBrowseFragment.this.kMO.yq(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.kMF.isAdded(yq)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCl, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCl, false);
                }
                if (AlbumImageBrowseFragment.this.kMF != null && AlbumImageBrowseFragment.this.kMF.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.kMF.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.aCo.setVisibility(8);
                } else if (yq == null || !yq.isGif()) {
                    AlbumImageBrowseFragment.this.aCo.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.aCo.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bt(AlbumImageBrowseFragment.this.kMF.isOriginalImg());
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
        this.kML = (AlbumActivity) getBaseFragmentActivity();
        this.kMF = this.kML.cUy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.Wg = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.aCl = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.aCn = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.aCo = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.aCm = this.mRoot.findViewById(R.id.layout_bottom);
        this.Wg.setOnClickListener(this.kML);
        this.aCn.setOnClickListener(this.kML);
        this.aCl.setOnClickListener(this.mOnClickListener);
        this.aCo.setOnClickListener(this.kML);
        this.aCm.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kMF != null && this.kMF.getWriteImagesInfo() != null) {
            this.aCo.setVisibility(this.kMF.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aw() {
        this.kML.Aj();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            AA();
        }
    }

    private void Ax() {
        List<ImageFileInfo> AH;
        int currentIndex;
        boolean z = true;
        if (this.kMF == null && this.kML != null) {
            this.kMF = this.kML.cUy();
        }
        if (this.kMF != null && (AH = this.kMF.AH()) != null && (currentIndex = this.kMF.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.kMO = new AlbumImagePagerAdapter(this.kML);
            this.mViewPager.setAdapter(this.kMO);
            if (this.mCurrentIndex == 0 && AH != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(AH, this.mCurrentIndex);
                if (this.kMF.isAdded(imageFileInfo)) {
                    a(this.aCl, true);
                } else {
                    a(this.aCl, false);
                }
                if (this.kMF != null && this.kMF.getWriteImagesInfo() != null) {
                    z = this.kMF.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.aCo.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.aCo.setVisibility(8);
                } else {
                    this.aCo.setVisibility(0);
                }
            }
            this.kMO.setData(AH);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bt(this.kMF.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.kMO != null) {
            this.kMO.setData(null);
        }
    }

    public View Ay() {
        return this.Wg;
    }

    public View Az() {
        return this.aCn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mRoot);
        am.setNavbarIconSrc(this.Wg, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.kMF != null) {
            bt(this.kMF.isOriginalImg());
        }
        if (this.kMO != null) {
            this.kMO.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.kML != null) {
            am.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.aCn != null) {
                int count = this.kMF != null ? v.getCount(this.kMF.AE()) : 0;
                this.aCn.setText(this.kML.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kMF != null ? this.kMF.getMaxImagesAllowed() : 1)}));
                this.aCn.setEnabled(count > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo yq;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.kMO != null && (yq = this.kMO.yq(this.mCurrentIndex)) != null && yq.getFilePath() != null && yq.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aCl, z);
        }
    }

    private void AA() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Ax();
        }
    }

    public View Au() {
        return this.aCo;
    }

    public void bt(boolean z) {
        long j;
        if (this.kML != null && this.aCo != null) {
            if (this.kMO != null) {
                ImageFileInfo yq = this.kMO.yq(this.mCurrentIndex);
                j = yq != null ? m.getFileSize(yq.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.kML.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.setViewTextColor(this.aCo, (int) R.color.cp_link_tip_a);
                this.aCo.setText(sb2);
                this.aCo.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.setViewTextColor(this.aCo, (int) R.color.cp_cont_f);
            this.aCo.setText(string);
            this.aCo.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
