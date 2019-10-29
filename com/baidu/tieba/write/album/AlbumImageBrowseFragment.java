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
    private ImageView NK;
    private ImageView apN;
    private View apO;
    private TextView apP;
    private TextView apQ;
    private AlbumActivity jOC;
    private AlbumImagePagerAdapter jOF;
    private c jOw;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int apR = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.apO && view == AlbumImageBrowseFragment.this.apN && AlbumImageBrowseFragment.this.jOF != null && AlbumImageBrowseFragment.this.jOw != null && AlbumImageBrowseFragment.this.jOC != null) {
                if (AlbumImageBrowseFragment.this.jOw.vW()) {
                    AlbumImageBrowseFragment.this.jOC.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jOF.ch(AlbumImageBrowseFragment.this.apR)) {
                    ImageFileInfo we = AlbumImageBrowseFragment.this.jOF.we(AlbumImageBrowseFragment.this.apR);
                    if (AlbumImageBrowseFragment.this.jOw.isAdded(we)) {
                        if (AlbumImageBrowseFragment.this.jOC.f(we)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apN, false);
                            AlbumImageBrowseFragment.this.jOC.f(we, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jOC.e(we)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apN, true);
                        AlbumImageBrowseFragment.this.jOC.f(we, true);
                    }
                    AlbumImageBrowseFragment.this.vQ();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.apR = i;
            if (AlbumImageBrowseFragment.this.jOF != null && AlbumImageBrowseFragment.this.jOw != null) {
                ImageFileInfo we = AlbumImageBrowseFragment.this.jOF.we(AlbumImageBrowseFragment.this.apR);
                if (AlbumImageBrowseFragment.this.jOw.isAdded(we)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apN, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apN, false);
                }
                if (AlbumImageBrowseFragment.this.jOw != null && AlbumImageBrowseFragment.this.jOw.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jOw.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.apQ.setVisibility(8);
                } else if (we == null || !we.isGif()) {
                    AlbumImageBrowseFragment.this.apQ.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.apQ.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.aQ(AlbumImageBrowseFragment.this.jOw.isOriginalImg());
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
        this.jOC = (AlbumActivity) getBaseFragmentActivity();
        this.jOw = this.jOC.cyf();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.NK = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.apN = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.apP = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.apQ = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.apO = this.mRoot.findViewById(R.id.layout_bottom);
        this.NK.setOnClickListener(this.jOC);
        this.apP.setOnClickListener(this.jOC);
        this.apN.setOnClickListener(this.mOnClickListener);
        this.apQ.setOnClickListener(this.jOC);
        this.apO.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jOw != null && this.jOw.getWriteImagesInfo() != null) {
            this.apQ.setVisibility(this.jOw.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ() {
        this.jOC.vD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            vU();
        }
    }

    private void vR() {
        List<ImageFileInfo> wb;
        int currentIndex;
        boolean z = true;
        if (this.jOw == null && this.jOC != null) {
            this.jOw = this.jOC.cyf();
        }
        if (this.jOw != null && (wb = this.jOw.wb()) != null && (currentIndex = this.jOw.getCurrentIndex()) >= 0) {
            this.apR = currentIndex;
            this.jOF = new AlbumImagePagerAdapter(this.jOC);
            this.mViewPager.setAdapter(this.jOF);
            if (this.apR == 0 && wb != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(wb, this.apR);
                if (this.jOw.isAdded(imageFileInfo)) {
                    a(this.apN, true);
                } else {
                    a(this.apN, false);
                }
                if (this.jOw != null && this.jOw.getWriteImagesInfo() != null) {
                    z = this.jOw.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.apQ.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.apQ.setVisibility(8);
                } else {
                    this.apQ.setVisibility(0);
                }
            }
            this.jOF.setData(wb);
            this.mViewPager.setCurrentItem(this.apR, false);
            aQ(this.jOw.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.jOF != null) {
            this.jOF.setData(null);
        }
    }

    public View vS() {
        return this.NK;
    }

    public View vT() {
        return this.apP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mRoot);
        am.setNavbarIconSrc(this.NK, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.jOw != null) {
            aQ(this.jOw.isOriginalImg());
        }
        if (this.jOF != null) {
            this.jOF.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.jOC != null) {
            am.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.apP != null) {
                int count = this.jOw != null ? v.getCount(this.jOw.vY()) : 0;
                this.apP.setText(this.jOC.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.jOw != null ? this.jOw.getMaxImagesAllowed() : 1)}));
                this.apP.setEnabled(count > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo we;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jOF != null && (we = this.jOF.we(this.apR)) != null && we.getFilePath() != null && we.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.apN, z);
        }
    }

    private void vU() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            vR();
        }
    }

    public View vO() {
        return this.apQ;
    }

    public void aQ(boolean z) {
        long j;
        if (this.jOC != null && this.apQ != null) {
            if (this.jOF != null) {
                ImageFileInfo we = this.jOF.we(this.apR);
                j = we != null ? m.getFileSize(we.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.jOC.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.setViewTextColor(this.apQ, (int) R.color.cp_link_tip_a);
                this.apQ.setText(sb2);
                this.apQ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.setViewTextColor(this.apQ, (int) R.color.cp_cont_f);
            this.apQ.setText(string);
            this.apQ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
