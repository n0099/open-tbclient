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
    private View anp;
    private c hVY;
    private AlbumActivity hWm;
    private AlbumImagePagerAdapter hWq;
    private ImageView hWr;
    private View hWs;
    private TextView hWt;
    private TextView hWu;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.hWs && view == AlbumImageBrowseFragment.this.hWr && AlbumImageBrowseFragment.this.hWq != null && AlbumImageBrowseFragment.this.hVY != null && AlbumImageBrowseFragment.this.hWm != null) {
                if (AlbumImageBrowseFragment.this.hVY.bPe()) {
                    AlbumImageBrowseFragment.this.hWm.showToast(e.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hWq.xs(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo sg = AlbumImageBrowseFragment.this.hWq.sg(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.hVY.isAdded(sg)) {
                        if (AlbumImageBrowseFragment.this.hWm.d(sg)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hWr, false);
                            AlbumImageBrowseFragment.this.hWm.f(sg, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.hWm.c(sg)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hWr, true);
                        AlbumImageBrowseFragment.this.hWm.f(sg, true);
                    }
                    AlbumImageBrowseFragment.this.bOZ();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.hWq != null && AlbumImageBrowseFragment.this.hVY != null) {
                ImageFileInfo sg = AlbumImageBrowseFragment.this.hWq.sg(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.hVY.isAdded(sg)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hWr, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hWr, false);
                }
                if (AlbumImageBrowseFragment.this.hVY != null && AlbumImageBrowseFragment.this.hVY.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.hVY.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.hWu.setVisibility(8);
                } else if (sg == null || !sg.isGif()) {
                    AlbumImageBrowseFragment.this.hWu.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hWu.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.oz(AlbumImageBrowseFragment.this.hVY.isOriginalImg());
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
        this.hWm = (AlbumActivity) getBaseFragmentActivity();
        this.hVY = this.hWm.bOO();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.anp = layoutInflater.inflate(e.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.anp.findViewById(e.g.img_back);
        this.hWr = (ImageView) this.anp.findViewById(e.g.img_choose);
        this.mViewPager = (ViewPager) this.anp.findViewById(e.g.viewPager);
        this.mNoDataView = this.anp.findViewById(e.g.album_no_data);
        this.hWt = (TextView) this.anp.findViewById(e.g.btn_next_step);
        this.hWu = (TextView) this.anp.findViewById(e.g.original_select_btn);
        this.hWs = this.anp.findViewById(e.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hWm);
        this.hWt.setOnClickListener(this.hWm);
        this.hWr.setOnClickListener(this.mOnClickListener);
        this.hWu.setOnClickListener(this.hWm);
        this.hWs.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hVY != null && this.hVY.getWriteImagesInfo() != null) {
            this.hWu.setVisibility(this.hVY.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.anp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOZ() {
        this.hWm.bOM();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aaZ();
        }
    }

    private void bPa() {
        List<ImageFileInfo> bPi;
        int currentIndex;
        boolean z = true;
        if (this.hVY == null && this.hWm != null) {
            this.hVY = this.hWm.bOO();
        }
        if (this.hVY != null && (bPi = this.hVY.bPi()) != null && (currentIndex = this.hVY.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.hWq = new AlbumImagePagerAdapter(this.hWm);
            this.mViewPager.setAdapter(this.hWq);
            if (this.mCurrentIndex == 0 && bPi != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(bPi, this.mCurrentIndex);
                if (this.hVY.isAdded(imageFileInfo)) {
                    c(this.hWr, true);
                } else {
                    c(this.hWr, false);
                }
                if (this.hVY != null && this.hVY.getWriteImagesInfo() != null) {
                    z = this.hVY.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.hWu.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.hWu.setVisibility(8);
                } else {
                    this.hWu.setVisibility(0);
                }
            }
            this.hWq.setData(bPi);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            oz(this.hVY.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hWq != null) {
            this.hWq.setData(null);
        }
    }

    public View bzd() {
        return this.mBackBtn;
    }

    public View bPb() {
        return this.hWt;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.anp);
        al.a(this.mBackBtn, e.f.icon_return_bg_s, e.f.icon_return_bg, i);
        if (this.hVY != null) {
            oz(this.hVY.isOriginalImg());
        }
        if (this.hWq != null) {
            this.hWq.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hWm != null) {
            al.c(imageView, z ? e.f.ic_post_edit_select_s : e.f.icon_image_clear_select);
            if (this.hWt != null) {
                int H = this.hVY != null ? v.H(this.hVY.bPg()) : 0;
                this.hWt.setText(this.hWm.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(H), Integer.valueOf(this.hVY != null ? this.hVY.getMaxImagesAllowed() : 1)}));
                this.hWt.setEnabled(H > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sg;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hWq != null && (sg = this.hWq.sg(this.mCurrentIndex)) != null && sg.getFilePath() != null && sg.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hWr, z);
        }
    }

    private void aaZ() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bPa();
        }
    }

    public View bOX() {
        return this.hWu;
    }

    public void oz(boolean z) {
        long j;
        if (this.hWm != null && this.hWu != null) {
            if (this.hWq != null) {
                ImageFileInfo sg = this.hWq.sg(this.mCurrentIndex);
                j = sg != null ? l.fx(sg.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hWm.getResources().getString(e.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ao.ac(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.h(this.hWu, e.d.cp_link_tip_a);
                this.hWu.setText(sb2);
                this.hWu.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.h(this.hWu, e.d.cp_cont_f);
            this.hWu.setText(string);
            this.hWu.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
