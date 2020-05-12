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
    private ImageView aWn;
    private View aWo;
    private TextView aWp;
    private TextView aWq;
    private ImageView aox;
    private c lxX;
    private AlbumActivity lye;
    private AlbumImagePagerAdapter lyh;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.aWo && view == AlbumImageBrowseFragment.this.aWn && AlbumImageBrowseFragment.this.lyh != null && AlbumImageBrowseFragment.this.lxX != null && AlbumImageBrowseFragment.this.lye != null) {
                if (AlbumImageBrowseFragment.this.lxX.FI()) {
                    AlbumImageBrowseFragment.this.lye.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.lyh.df(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo yZ = AlbumImageBrowseFragment.this.lyh.yZ(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.lxX.isAdded(yZ)) {
                        if (AlbumImageBrowseFragment.this.lye.f(yZ)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWn, false);
                            AlbumImageBrowseFragment.this.lye.f(yZ, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.lye.e(yZ)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWn, true);
                        AlbumImageBrowseFragment.this.lye.f(yZ, true);
                    }
                    AlbumImageBrowseFragment.this.FC();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.lyh != null && AlbumImageBrowseFragment.this.lxX != null) {
                ImageFileInfo yZ = AlbumImageBrowseFragment.this.lyh.yZ(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.lxX.isAdded(yZ)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWn, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWn, false);
                }
                if (AlbumImageBrowseFragment.this.lxX != null && AlbumImageBrowseFragment.this.lxX.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.lxX.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.aWq.setVisibility(8);
                } else if (yZ == null || !yZ.isGif()) {
                    AlbumImageBrowseFragment.this.aWq.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.aWq.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bY(AlbumImageBrowseFragment.this.lxX.isOriginalImg());
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
        this.lye = (AlbumActivity) getBaseFragmentActivity();
        this.lxX = this.lye.dfq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aox = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.aWn = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.aWp = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.aWq = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.aWo = this.mRoot.findViewById(R.id.layout_bottom);
        this.aox.setOnClickListener(this.lye);
        this.aWp.setOnClickListener(this.lye);
        this.aWn.setOnClickListener(this.mOnClickListener);
        this.aWq.setOnClickListener(this.lye);
        this.aWo.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.lxX != null && this.lxX.getWriteImagesInfo() != null) {
            this.aWq.setVisibility(this.lxX.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FC() {
        this.lye.Fp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            FG();
        }
    }

    private void FD() {
        List<ImageFileInfo> FN;
        int currentIndex;
        boolean z = true;
        if (this.lxX == null && this.lye != null) {
            this.lxX = this.lye.dfq();
        }
        if (this.lxX != null && (FN = this.lxX.FN()) != null && (currentIndex = this.lxX.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.lyh = new AlbumImagePagerAdapter(this.lye);
            this.mViewPager.setAdapter(this.lyh);
            if (this.mCurrentIndex == 0 && FN != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(FN, this.mCurrentIndex);
                if (this.lxX.isAdded(imageFileInfo)) {
                    a(this.aWn, true);
                } else {
                    a(this.aWn, false);
                }
                if (this.lxX != null && this.lxX.getWriteImagesInfo() != null) {
                    z = this.lxX.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.aWq.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.aWq.setVisibility(8);
                } else {
                    this.aWq.setVisibility(0);
                }
            }
            this.lyh.setData(FN);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bY(this.lxX.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.lyh != null) {
            this.lyh.setData(null);
        }
    }

    public View FE() {
        return this.aox;
    }

    public View FF() {
        return this.aWp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mRoot);
        am.setNavbarIconSrc(this.aox, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.lxX != null) {
            bY(this.lxX.isOriginalImg());
        }
        if (this.lyh != null) {
            this.lyh.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.lye != null) {
            am.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.aWp != null) {
                int count = this.lxX != null ? v.getCount(this.lxX.FK()) : 0;
                this.aWp.setText(this.lye.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.lxX != null ? this.lxX.getMaxImagesAllowed() : 1)}));
                this.aWp.setEnabled(count > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo yZ;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.lyh != null && (yZ = this.lyh.yZ(this.mCurrentIndex)) != null && yZ.getFilePath() != null && yZ.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aWn, z);
        }
    }

    private void FG() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            FD();
        }
    }

    public View FA() {
        return this.aWq;
    }

    public void bY(boolean z) {
        long j;
        if (this.lye != null && this.aWq != null) {
            if (this.lyh != null) {
                ImageFileInfo yZ = this.lyh.yZ(this.mCurrentIndex);
                j = yZ != null ? m.getFileSize(yZ.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.lye.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.setViewTextColor(this.aWq, (int) R.color.cp_link_tip_a);
                this.aWq.setText(sb2);
                this.aWq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.setViewTextColor(this.aWq, (int) R.color.cp_cont_f);
            this.aWq.setText(string);
            this.aWq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
