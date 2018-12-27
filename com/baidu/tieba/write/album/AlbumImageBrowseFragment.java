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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private View amM;
    private c hUQ;
    private AlbumActivity hVe;
    private AlbumImagePagerAdapter hVi;
    private ImageView hVj;
    private View hVk;
    private TextView hVl;
    private TextView hVm;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.hVk && view == AlbumImageBrowseFragment.this.hVj && AlbumImageBrowseFragment.this.hVi != null && AlbumImageBrowseFragment.this.hUQ != null && AlbumImageBrowseFragment.this.hVe != null) {
                if (AlbumImageBrowseFragment.this.hUQ.bOw()) {
                    AlbumImageBrowseFragment.this.hVe.showToast(e.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hVi.xq(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo se = AlbumImageBrowseFragment.this.hVi.se(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.hUQ.isAdded(se)) {
                        if (AlbumImageBrowseFragment.this.hVe.d(se)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hVj, false);
                            AlbumImageBrowseFragment.this.hVe.f(se, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.hVe.c(se)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hVj, true);
                        AlbumImageBrowseFragment.this.hVe.f(se, true);
                    }
                    AlbumImageBrowseFragment.this.bOr();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.hVi != null && AlbumImageBrowseFragment.this.hUQ != null) {
                ImageFileInfo se = AlbumImageBrowseFragment.this.hVi.se(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.hUQ.isAdded(se)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hVj, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hVj, false);
                }
                if (AlbumImageBrowseFragment.this.hUQ != null && AlbumImageBrowseFragment.this.hUQ.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.hUQ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.hVm.setVisibility(8);
                } else if (se == null || !se.isGif()) {
                    AlbumImageBrowseFragment.this.hVm.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hVm.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.oy(AlbumImageBrowseFragment.this.hUQ.isOriginalImg());
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
        this.hVe = (AlbumActivity) getBaseFragmentActivity();
        this.hUQ = this.hVe.bOg();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.amM = layoutInflater.inflate(e.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.amM.findViewById(e.g.img_back);
        this.hVj = (ImageView) this.amM.findViewById(e.g.img_choose);
        this.mViewPager = (ViewPager) this.amM.findViewById(e.g.viewPager);
        this.mNoDataView = this.amM.findViewById(e.g.album_no_data);
        this.hVl = (TextView) this.amM.findViewById(e.g.btn_next_step);
        this.hVm = (TextView) this.amM.findViewById(e.g.original_select_btn);
        this.hVk = this.amM.findViewById(e.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hVe);
        this.hVl.setOnClickListener(this.hVe);
        this.hVj.setOnClickListener(this.mOnClickListener);
        this.hVm.setOnClickListener(this.hVe);
        this.hVk.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hUQ != null && this.hUQ.getWriteImagesInfo() != null) {
            this.hVm.setVisibility(this.hUQ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.amM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOr() {
        this.hVe.bOe();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aaC();
        }
    }

    private void bOs() {
        List<ImageFileInfo> bOA;
        int currentIndex;
        boolean z = true;
        if (this.hUQ == null && this.hVe != null) {
            this.hUQ = this.hVe.bOg();
        }
        if (this.hUQ != null && (bOA = this.hUQ.bOA()) != null && (currentIndex = this.hUQ.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.hVi = new AlbumImagePagerAdapter(this.hVe);
            this.mViewPager.setAdapter(this.hVi);
            if (this.mCurrentIndex == 0 && bOA != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(bOA, this.mCurrentIndex);
                if (this.hUQ.isAdded(imageFileInfo)) {
                    c(this.hVj, true);
                } else {
                    c(this.hVj, false);
                }
                if (this.hUQ != null && this.hUQ.getWriteImagesInfo() != null) {
                    z = this.hUQ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.hVm.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.hVm.setVisibility(8);
                } else {
                    this.hVm.setVisibility(0);
                }
            }
            this.hVi.setData(bOA);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            oy(this.hUQ.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hVi != null) {
            this.hVi.setData(null);
        }
    }

    public View byu() {
        return this.mBackBtn;
    }

    public View bOt() {
        return this.hVl;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.amM);
        al.a(this.mBackBtn, e.f.icon_return_bg_s, e.f.icon_return_bg, i);
        if (this.hUQ != null) {
            oy(this.hUQ.isOriginalImg());
        }
        if (this.hVi != null) {
            this.hVi.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hVe != null) {
            al.c(imageView, z ? e.f.ic_post_edit_select_s : e.f.icon_image_clear_select);
            if (this.hVl != null) {
                int H = this.hUQ != null ? v.H(this.hUQ.bOy()) : 0;
                this.hVl.setText(this.hVe.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(H), Integer.valueOf(this.hUQ != null ? this.hUQ.getMaxImagesAllowed() : 1)}));
                this.hVl.setEnabled(H > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo se;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hVi != null && (se = this.hVi.se(this.mCurrentIndex)) != null && se.getFilePath() != null && se.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hVj, z);
        }
    }

    private void aaC() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bOs();
        }
    }

    public View bOp() {
        return this.hVm;
    }

    public void oy(boolean z) {
        long j;
        if (this.hVe != null && this.hVm != null) {
            if (this.hVi != null) {
                ImageFileInfo se = this.hVi.se(this.mCurrentIndex);
                j = se != null ? l.fn(se.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hVe.getResources().getString(e.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ao.ac(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.h(this.hVm, e.d.cp_link_tip_a);
                this.hVm.setText(sb2);
                this.hVm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.h(this.hVm, e.d.cp_cont_f);
            this.hVm.setText(string);
            this.hVm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
