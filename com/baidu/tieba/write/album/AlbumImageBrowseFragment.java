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
    private View ano;
    private c hVX;
    private AlbumActivity hWl;
    private AlbumImagePagerAdapter hWp;
    private ImageView hWq;
    private View hWr;
    private TextView hWs;
    private TextView hWt;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.hWr && view == AlbumImageBrowseFragment.this.hWq && AlbumImageBrowseFragment.this.hWp != null && AlbumImageBrowseFragment.this.hVX != null && AlbumImageBrowseFragment.this.hWl != null) {
                if (AlbumImageBrowseFragment.this.hVX.bPe()) {
                    AlbumImageBrowseFragment.this.hWl.showToast(e.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hWp.xs(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo sg = AlbumImageBrowseFragment.this.hWp.sg(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.hVX.isAdded(sg)) {
                        if (AlbumImageBrowseFragment.this.hWl.d(sg)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hWq, false);
                            AlbumImageBrowseFragment.this.hWl.f(sg, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.hWl.c(sg)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hWq, true);
                        AlbumImageBrowseFragment.this.hWl.f(sg, true);
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
            if (AlbumImageBrowseFragment.this.hWp != null && AlbumImageBrowseFragment.this.hVX != null) {
                ImageFileInfo sg = AlbumImageBrowseFragment.this.hWp.sg(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.hVX.isAdded(sg)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hWq, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hWq, false);
                }
                if (AlbumImageBrowseFragment.this.hVX != null && AlbumImageBrowseFragment.this.hVX.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.hVX.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.hWt.setVisibility(8);
                } else if (sg == null || !sg.isGif()) {
                    AlbumImageBrowseFragment.this.hWt.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hWt.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.oz(AlbumImageBrowseFragment.this.hVX.isOriginalImg());
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
        this.hWl = (AlbumActivity) getBaseFragmentActivity();
        this.hVX = this.hWl.bOO();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ano = layoutInflater.inflate(e.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.ano.findViewById(e.g.img_back);
        this.hWq = (ImageView) this.ano.findViewById(e.g.img_choose);
        this.mViewPager = (ViewPager) this.ano.findViewById(e.g.viewPager);
        this.mNoDataView = this.ano.findViewById(e.g.album_no_data);
        this.hWs = (TextView) this.ano.findViewById(e.g.btn_next_step);
        this.hWt = (TextView) this.ano.findViewById(e.g.original_select_btn);
        this.hWr = this.ano.findViewById(e.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hWl);
        this.hWs.setOnClickListener(this.hWl);
        this.hWq.setOnClickListener(this.mOnClickListener);
        this.hWt.setOnClickListener(this.hWl);
        this.hWr.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hVX != null && this.hVX.getWriteImagesInfo() != null) {
            this.hWt.setVisibility(this.hVX.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.ano;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOZ() {
        this.hWl.bOM();
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
        if (this.hVX == null && this.hWl != null) {
            this.hVX = this.hWl.bOO();
        }
        if (this.hVX != null && (bPi = this.hVX.bPi()) != null && (currentIndex = this.hVX.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.hWp = new AlbumImagePagerAdapter(this.hWl);
            this.mViewPager.setAdapter(this.hWp);
            if (this.mCurrentIndex == 0 && bPi != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(bPi, this.mCurrentIndex);
                if (this.hVX.isAdded(imageFileInfo)) {
                    c(this.hWq, true);
                } else {
                    c(this.hWq, false);
                }
                if (this.hVX != null && this.hVX.getWriteImagesInfo() != null) {
                    z = this.hVX.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.hWt.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.hWt.setVisibility(8);
                } else {
                    this.hWt.setVisibility(0);
                }
            }
            this.hWp.setData(bPi);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            oz(this.hVX.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hWp != null) {
            this.hWp.setData(null);
        }
    }

    public View bzd() {
        return this.mBackBtn;
    }

    public View bPb() {
        return this.hWs;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.ano);
        al.a(this.mBackBtn, e.f.icon_return_bg_s, e.f.icon_return_bg, i);
        if (this.hVX != null) {
            oz(this.hVX.isOriginalImg());
        }
        if (this.hWp != null) {
            this.hWp.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hWl != null) {
            al.c(imageView, z ? e.f.ic_post_edit_select_s : e.f.icon_image_clear_select);
            if (this.hWs != null) {
                int H = this.hVX != null ? v.H(this.hVX.bPg()) : 0;
                this.hWs.setText(this.hWl.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(H), Integer.valueOf(this.hVX != null ? this.hVX.getMaxImagesAllowed() : 1)}));
                this.hWs.setEnabled(H > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sg;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hWp != null && (sg = this.hWp.sg(this.mCurrentIndex)) != null && sg.getFilePath() != null && sg.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hWq, z);
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
        return this.hWt;
    }

    public void oz(boolean z) {
        long j;
        if (this.hWl != null && this.hWt != null) {
            if (this.hWp != null) {
                ImageFileInfo sg = this.hWp.sg(this.mCurrentIndex);
                j = sg != null ? l.fx(sg.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hWl.getResources().getString(e.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ao.ac(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.h(this.hWt, e.d.cp_link_tip_a);
                this.hWt.setText(sb2);
                this.hWt.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.h(this.hWt, e.d.cp_cont_f);
            this.hWt.setText(string);
            this.hWt.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
