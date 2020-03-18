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
    private ImageView Wq;
    private ImageView aCB;
    private View aCC;
    private TextView aCD;
    private TextView aCE;
    private c kOC;
    private AlbumActivity kOJ;
    private AlbumImagePagerAdapter kOM;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.aCC && view == AlbumImageBrowseFragment.this.aCB && AlbumImageBrowseFragment.this.kOM != null && AlbumImageBrowseFragment.this.kOC != null && AlbumImageBrowseFragment.this.kOJ != null) {
                if (AlbumImageBrowseFragment.this.kOC.AL()) {
                    AlbumImageBrowseFragment.this.kOJ.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.kOM.cQ(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo yy = AlbumImageBrowseFragment.this.kOM.yy(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.kOC.isAdded(yy)) {
                        if (AlbumImageBrowseFragment.this.kOJ.f(yy)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCB, false);
                            AlbumImageBrowseFragment.this.kOJ.f(yy, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.kOJ.e(yy)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCB, true);
                        AlbumImageBrowseFragment.this.kOJ.f(yy, true);
                    }
                    AlbumImageBrowseFragment.this.AF();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.kOM != null && AlbumImageBrowseFragment.this.kOC != null) {
                ImageFileInfo yy = AlbumImageBrowseFragment.this.kOM.yy(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.kOC.isAdded(yy)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCB, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCB, false);
                }
                if (AlbumImageBrowseFragment.this.kOC != null && AlbumImageBrowseFragment.this.kOC.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.kOC.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.aCE.setVisibility(8);
                } else if (yy == null || !yy.isGif()) {
                    AlbumImageBrowseFragment.this.aCE.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.aCE.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bu(AlbumImageBrowseFragment.this.kOC.isOriginalImg());
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
        this.kOJ = (AlbumActivity) getBaseFragmentActivity();
        this.kOC = this.kOJ.cUW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.Wq = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.aCB = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.aCD = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.aCE = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.aCC = this.mRoot.findViewById(R.id.layout_bottom);
        this.Wq.setOnClickListener(this.kOJ);
        this.aCD.setOnClickListener(this.kOJ);
        this.aCB.setOnClickListener(this.mOnClickListener);
        this.aCE.setOnClickListener(this.kOJ);
        this.aCC.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kOC != null && this.kOC.getWriteImagesInfo() != null) {
            this.aCE.setVisibility(this.kOC.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AF() {
        this.kOJ.As();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            AJ();
        }
    }

    private void AG() {
        List<ImageFileInfo> AQ;
        int currentIndex;
        boolean z = true;
        if (this.kOC == null && this.kOJ != null) {
            this.kOC = this.kOJ.cUW();
        }
        if (this.kOC != null && (AQ = this.kOC.AQ()) != null && (currentIndex = this.kOC.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.kOM = new AlbumImagePagerAdapter(this.kOJ);
            this.mViewPager.setAdapter(this.kOM);
            if (this.mCurrentIndex == 0 && AQ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(AQ, this.mCurrentIndex);
                if (this.kOC.isAdded(imageFileInfo)) {
                    a(this.aCB, true);
                } else {
                    a(this.aCB, false);
                }
                if (this.kOC != null && this.kOC.getWriteImagesInfo() != null) {
                    z = this.kOC.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.aCE.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.aCE.setVisibility(8);
                } else {
                    this.aCE.setVisibility(0);
                }
            }
            this.kOM.setData(AQ);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bu(this.kOC.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.kOM != null) {
            this.kOM.setData(null);
        }
    }

    public View AH() {
        return this.Wq;
    }

    public View AI() {
        return this.aCD;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mRoot);
        am.setNavbarIconSrc(this.Wq, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.kOC != null) {
            bu(this.kOC.isOriginalImg());
        }
        if (this.kOM != null) {
            this.kOM.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.kOJ != null) {
            am.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.aCD != null) {
                int count = this.kOC != null ? v.getCount(this.kOC.AN()) : 0;
                this.aCD.setText(this.kOJ.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kOC != null ? this.kOC.getMaxImagesAllowed() : 1)}));
                this.aCD.setEnabled(count > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo yy;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.kOM != null && (yy = this.kOM.yy(this.mCurrentIndex)) != null && yy.getFilePath() != null && yy.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aCB, z);
        }
    }

    private void AJ() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            AG();
        }
    }

    public View AD() {
        return this.aCE;
    }

    public void bu(boolean z) {
        long j;
        if (this.kOJ != null && this.aCE != null) {
            if (this.kOM != null) {
                ImageFileInfo yy = this.kOM.yy(this.mCurrentIndex);
                j = yy != null ? m.getFileSize(yy.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.kOJ.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.setViewTextColor(this.aCE, (int) R.color.cp_link_tip_a);
                this.aCE.setText(sb2);
                this.aCE.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.setViewTextColor(this.aCE, (int) R.color.cp_cont_f);
            this.aCE.setText(string);
            this.aCE.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
