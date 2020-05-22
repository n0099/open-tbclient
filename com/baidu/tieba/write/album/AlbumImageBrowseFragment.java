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
    private ImageView atr;
    private TextView bdA;
    private TextView bdB;
    private ImageView bdy;
    private View bdz;
    private c lRm;
    private AlbumActivity lRt;
    private AlbumImagePagerAdapter lRx;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bdz && view == AlbumImageBrowseFragment.this.bdy && AlbumImageBrowseFragment.this.lRx != null && AlbumImageBrowseFragment.this.lRm != null && AlbumImageBrowseFragment.this.lRt != null) {
                if (AlbumImageBrowseFragment.this.lRm.Hz()) {
                    AlbumImageBrowseFragment.this.lRt.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.lRx.dk(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo zH = AlbumImageBrowseFragment.this.lRx.zH(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.lRm.isAdded(zH)) {
                        if (AlbumImageBrowseFragment.this.lRt.f(zH)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bdy, false);
                            AlbumImageBrowseFragment.this.lRt.f(zH, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.lRt.e(zH)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bdy, true);
                        AlbumImageBrowseFragment.this.lRt.f(zH, true);
                    }
                    AlbumImageBrowseFragment.this.Hm();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.lRx != null && AlbumImageBrowseFragment.this.lRm != null) {
                ImageFileInfo zH = AlbumImageBrowseFragment.this.lRx.zH(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.lRm.isAdded(zH)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bdy, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bdy, false);
                }
                if (AlbumImageBrowseFragment.this.lRm != null && AlbumImageBrowseFragment.this.lRm.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.lRm.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.bdB.setVisibility(8);
                } else if (zH == null || !zH.isGif()) {
                    AlbumImageBrowseFragment.this.bdB.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bdB.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.ci(AlbumImageBrowseFragment.this.lRm.isOriginalImg());
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
        this.lRt = (AlbumActivity) getBaseFragmentActivity();
        this.lRm = this.lRt.dmG();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.atr = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bdy = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.bdA = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.bdB = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bdz = this.mRoot.findViewById(R.id.layout_bottom);
        this.atr.setOnClickListener(this.lRt);
        this.bdA.setOnClickListener(this.lRt);
        this.bdy.setOnClickListener(this.mOnClickListener);
        this.bdB.setOnClickListener(this.lRt);
        this.bdz.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.lRm != null && this.lRm.getWriteImagesInfo() != null) {
            this.bdB.setVisibility(this.lRm.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hm() {
        this.lRt.Hg();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Ho();
        }
    }

    private void Hn() {
        List<ImageFileInfo> HE;
        int currentIndex;
        boolean z = true;
        if (this.lRm == null && this.lRt != null) {
            this.lRm = this.lRt.dmG();
        }
        if (this.lRm != null && (HE = this.lRm.HE()) != null && (currentIndex = this.lRm.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.lRx = new AlbumImagePagerAdapter(this.lRt);
            this.mViewPager.setAdapter(this.lRx);
            if (this.mCurrentIndex == 0 && HE != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(HE, this.mCurrentIndex);
                if (this.lRm.isAdded(imageFileInfo)) {
                    a(this.bdy, true);
                } else {
                    a(this.bdy, false);
                }
                if (this.lRm != null && this.lRm.getWriteImagesInfo() != null) {
                    z = this.lRm.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.bdB.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.bdB.setVisibility(8);
                } else {
                    this.bdB.setVisibility(0);
                }
            }
            this.lRx.setData(HE);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            ci(this.lRm.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.lRx != null) {
            this.lRx.setData(null);
        }
    }

    public View HI() {
        return this.atr;
    }

    public View HJ() {
        return this.bdA;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mRoot);
        am.setNavbarIconSrc(this.atr, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.lRm != null) {
            ci(this.lRm.isOriginalImg());
        }
        if (this.lRx != null) {
            this.lRx.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.lRt != null) {
            am.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.bdA != null) {
                int count = this.lRm != null ? v.getCount(this.lRm.HB()) : 0;
                this.bdA.setText(this.lRt.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.lRm != null ? this.lRm.getMaxImagesAllowed() : 1)}));
                this.bdA.setEnabled(count > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo zH;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.lRx != null && (zH = this.lRx.zH(this.mCurrentIndex)) != null && zH.getFilePath() != null && zH.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bdy, z);
        }
    }

    private void Ho() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Hn();
        }
    }

    public View Hu() {
        return this.bdB;
    }

    public void ci(boolean z) {
        long j;
        if (this.lRt != null && this.bdB != null) {
            if (this.lRx != null) {
                ImageFileInfo zH = this.lRx.zH(this.mCurrentIndex);
                j = zH != null ? m.getFileSize(zH.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.lRt.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.setViewTextColor(this.bdB, (int) R.color.cp_link_tip_a);
                this.bdB.setText(sb2);
                this.bdB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.setViewTextColor(this.bdB, (int) R.color.cp_cont_f);
            this.bdB.setText(string);
            this.bdB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
