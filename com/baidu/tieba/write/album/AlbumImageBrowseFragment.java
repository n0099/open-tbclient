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
    private View aix;
    private c hIJ;
    private AlbumActivity hIX;
    private AlbumImagePagerAdapter hJb;
    private ImageView hJc;
    private View hJd;
    private TextView hJe;
    private TextView hJf;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aWO = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.hJd && view == AlbumImageBrowseFragment.this.hJc && AlbumImageBrowseFragment.this.hJb != null && AlbumImageBrowseFragment.this.hIJ != null && AlbumImageBrowseFragment.this.hIX != null) {
                if (AlbumImageBrowseFragment.this.hIJ.bMb()) {
                    AlbumImageBrowseFragment.this.hIX.showToast(e.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hJb.wn(AlbumImageBrowseFragment.this.aWO)) {
                    ImageFileInfo re = AlbumImageBrowseFragment.this.hJb.re(AlbumImageBrowseFragment.this.aWO);
                    if (AlbumImageBrowseFragment.this.hIJ.isAdded(re)) {
                        if (AlbumImageBrowseFragment.this.hIX.d(re)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hJc, false);
                            AlbumImageBrowseFragment.this.hIX.f(re, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.hIX.c(re)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hJc, true);
                        AlbumImageBrowseFragment.this.hIX.f(re, true);
                    }
                    AlbumImageBrowseFragment.this.bLW();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.aWO = i;
            if (AlbumImageBrowseFragment.this.hJb != null && AlbumImageBrowseFragment.this.hIJ != null) {
                ImageFileInfo re = AlbumImageBrowseFragment.this.hJb.re(AlbumImageBrowseFragment.this.aWO);
                if (AlbumImageBrowseFragment.this.hIJ.isAdded(re)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hJc, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hJc, false);
                }
                if (AlbumImageBrowseFragment.this.hIJ != null && AlbumImageBrowseFragment.this.hIJ.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.hIJ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.hJf.setVisibility(8);
                } else if (re == null || !re.isGif()) {
                    AlbumImageBrowseFragment.this.hJf.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hJf.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.of(AlbumImageBrowseFragment.this.hIJ.isOriginalImg());
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
        this.hIX = (AlbumActivity) getBaseFragmentActivity();
        this.hIJ = this.hIX.bLL();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aix = layoutInflater.inflate(e.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.aix.findViewById(e.g.img_back);
        this.hJc = (ImageView) this.aix.findViewById(e.g.img_choose);
        this.mViewPager = (ViewPager) this.aix.findViewById(e.g.viewPager);
        this.mNoDataView = this.aix.findViewById(e.g.album_no_data);
        this.hJe = (TextView) this.aix.findViewById(e.g.btn_next_step);
        this.hJf = (TextView) this.aix.findViewById(e.g.original_select_btn);
        this.hJd = this.aix.findViewById(e.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hIX);
        this.hJe.setOnClickListener(this.hIX);
        this.hJc.setOnClickListener(this.mOnClickListener);
        this.hJf.setOnClickListener(this.hIX);
        this.hJd.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hIJ != null && this.hIJ.getWriteImagesInfo() != null) {
            this.hJf.setVisibility(this.hIJ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.aix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLW() {
        this.hIX.bLJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Zj();
        }
    }

    private void bLX() {
        List<ImageFileInfo> bMf;
        int currentIndex;
        boolean z = true;
        if (this.hIJ == null && this.hIX != null) {
            this.hIJ = this.hIX.bLL();
        }
        if (this.hIJ != null && (bMf = this.hIJ.bMf()) != null && (currentIndex = this.hIJ.getCurrentIndex()) >= 0) {
            this.aWO = currentIndex;
            this.hJb = new AlbumImagePagerAdapter(this.hIX);
            this.mViewPager.setAdapter(this.hJb);
            if (this.aWO == 0 && bMf != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(bMf, this.aWO);
                if (this.hIJ.isAdded(imageFileInfo)) {
                    c(this.hJc, true);
                } else {
                    c(this.hJc, false);
                }
                if (this.hIJ != null && this.hIJ.getWriteImagesInfo() != null) {
                    z = this.hIJ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.hJf.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.hJf.setVisibility(8);
                } else {
                    this.hJf.setVisibility(0);
                }
            }
            this.hJb.setData(bMf);
            this.mViewPager.setCurrentItem(this.aWO, false);
            of(this.hIJ.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hJb != null) {
            this.hJb.setData(null);
        }
    }

    public View bwq() {
        return this.mBackBtn;
    }

    public View bLY() {
        return this.hJe;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.aix);
        al.a(this.mBackBtn, e.f.icon_return_bg_s, e.f.icon_return_bg, i);
        if (this.hIJ != null) {
            of(this.hIJ.isOriginalImg());
        }
        if (this.hJb != null) {
            this.hJb.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hIX != null) {
            al.c(imageView, z ? e.f.ic_post_edit_select_s : e.f.icon_image_clear_select);
            if (this.hJe != null) {
                int I = this.hIJ != null ? v.I(this.hIJ.bMd()) : 0;
                this.hJe.setText(this.hIX.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(I), Integer.valueOf(this.hIJ != null ? this.hIJ.getMaxImagesAllowed() : 1)}));
                this.hJe.setEnabled(I > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo re;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hJb != null && (re = this.hJb.re(this.aWO)) != null && re.getFilePath() != null && re.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hJc, z);
        }
    }

    private void Zj() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bLX();
        }
    }

    public View bLU() {
        return this.hJf;
    }

    public void of(boolean z) {
        long j;
        if (this.hIX != null && this.hJf != null) {
            if (this.hJb != null) {
                ImageFileInfo re = this.hJb.re(this.aWO);
                j = re != null ? l.eV(re.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hIX.getResources().getString(e.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ao.S(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.h(this.hJf, e.d.cp_link_tip_a);
                this.hJf.setText(sb2);
                this.hJf.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.h(this.hJf, e.d.cp_cont_f);
            this.hJf.setText(string);
            this.hJf.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
