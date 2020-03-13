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
    private ImageView aCn;
    private View aCo;
    private TextView aCp;
    private TextView aCq;
    private c kMT;
    private AlbumActivity kMZ;
    private AlbumImagePagerAdapter kNc;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.aCo && view == AlbumImageBrowseFragment.this.aCn && AlbumImageBrowseFragment.this.kNc != null && AlbumImageBrowseFragment.this.kMT != null && AlbumImageBrowseFragment.this.kMZ != null) {
                if (AlbumImageBrowseFragment.this.kMT.AE()) {
                    AlbumImageBrowseFragment.this.kMZ.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.kNc.cQ(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo yq = AlbumImageBrowseFragment.this.kNc.yq(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.kMT.isAdded(yq)) {
                        if (AlbumImageBrowseFragment.this.kMZ.f(yq)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCn, false);
                            AlbumImageBrowseFragment.this.kMZ.f(yq, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.kMZ.e(yq)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCn, true);
                        AlbumImageBrowseFragment.this.kMZ.f(yq, true);
                    }
                    AlbumImageBrowseFragment.this.Ay();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.kNc != null && AlbumImageBrowseFragment.this.kMT != null) {
                ImageFileInfo yq = AlbumImageBrowseFragment.this.kNc.yq(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.kMT.isAdded(yq)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCn, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCn, false);
                }
                if (AlbumImageBrowseFragment.this.kMT != null && AlbumImageBrowseFragment.this.kMT.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.kMT.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.aCq.setVisibility(8);
                } else if (yq == null || !yq.isGif()) {
                    AlbumImageBrowseFragment.this.aCq.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.aCq.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bt(AlbumImageBrowseFragment.this.kMT.isOriginalImg());
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
        this.kMZ = (AlbumActivity) getBaseFragmentActivity();
        this.kMT = this.kMZ.cUB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.Wg = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.aCn = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.aCp = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.aCq = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.aCo = this.mRoot.findViewById(R.id.layout_bottom);
        this.Wg.setOnClickListener(this.kMZ);
        this.aCp.setOnClickListener(this.kMZ);
        this.aCn.setOnClickListener(this.mOnClickListener);
        this.aCq.setOnClickListener(this.kMZ);
        this.aCo.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kMT != null && this.kMT.getWriteImagesInfo() != null) {
            this.aCq.setVisibility(this.kMT.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ay() {
        this.kMZ.Al();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            AC();
        }
    }

    private void Az() {
        List<ImageFileInfo> AJ;
        int currentIndex;
        boolean z = true;
        if (this.kMT == null && this.kMZ != null) {
            this.kMT = this.kMZ.cUB();
        }
        if (this.kMT != null && (AJ = this.kMT.AJ()) != null && (currentIndex = this.kMT.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.kNc = new AlbumImagePagerAdapter(this.kMZ);
            this.mViewPager.setAdapter(this.kNc);
            if (this.mCurrentIndex == 0 && AJ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(AJ, this.mCurrentIndex);
                if (this.kMT.isAdded(imageFileInfo)) {
                    a(this.aCn, true);
                } else {
                    a(this.aCn, false);
                }
                if (this.kMT != null && this.kMT.getWriteImagesInfo() != null) {
                    z = this.kMT.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.aCq.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.aCq.setVisibility(8);
                } else {
                    this.aCq.setVisibility(0);
                }
            }
            this.kNc.setData(AJ);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bt(this.kMT.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.kNc != null) {
            this.kNc.setData(null);
        }
    }

    public View AA() {
        return this.Wg;
    }

    public View AB() {
        return this.aCp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mRoot);
        am.setNavbarIconSrc(this.Wg, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.kMT != null) {
            bt(this.kMT.isOriginalImg());
        }
        if (this.kNc != null) {
            this.kNc.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.kMZ != null) {
            am.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.aCp != null) {
                int count = this.kMT != null ? v.getCount(this.kMT.AG()) : 0;
                this.aCp.setText(this.kMZ.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kMT != null ? this.kMT.getMaxImagesAllowed() : 1)}));
                this.aCp.setEnabled(count > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo yq;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.kNc != null && (yq = this.kNc.yq(this.mCurrentIndex)) != null && yq.getFilePath() != null && yq.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aCn, z);
        }
    }

    private void AC() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Az();
        }
    }

    public View Aw() {
        return this.aCq;
    }

    public void bt(boolean z) {
        long j;
        if (this.kMZ != null && this.aCq != null) {
            if (this.kNc != null) {
                ImageFileInfo yq = this.kNc.yq(this.mCurrentIndex);
                j = yq != null ? m.getFileSize(yq.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.kMZ.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.setViewTextColor(this.aCq, (int) R.color.cp_link_tip_a);
                this.aCq.setText(sb2);
                this.aCq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.setViewTextColor(this.aCq, (int) R.color.cp_cont_f);
            this.aCq.setText(string);
            this.aCq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
