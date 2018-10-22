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
    private c hIK;
    private AlbumActivity hIY;
    private AlbumImagePagerAdapter hJc;
    private ImageView hJd;
    private View hJe;
    private TextView hJf;
    private TextView hJg;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aWO = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.hJe && view == AlbumImageBrowseFragment.this.hJd && AlbumImageBrowseFragment.this.hJc != null && AlbumImageBrowseFragment.this.hIK != null && AlbumImageBrowseFragment.this.hIY != null) {
                if (AlbumImageBrowseFragment.this.hIK.bMb()) {
                    AlbumImageBrowseFragment.this.hIY.showToast(e.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hJc.wn(AlbumImageBrowseFragment.this.aWO)) {
                    ImageFileInfo re = AlbumImageBrowseFragment.this.hJc.re(AlbumImageBrowseFragment.this.aWO);
                    if (AlbumImageBrowseFragment.this.hIK.isAdded(re)) {
                        if (AlbumImageBrowseFragment.this.hIY.d(re)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hJd, false);
                            AlbumImageBrowseFragment.this.hIY.f(re, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.hIY.c(re)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hJd, true);
                        AlbumImageBrowseFragment.this.hIY.f(re, true);
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
            if (AlbumImageBrowseFragment.this.hJc != null && AlbumImageBrowseFragment.this.hIK != null) {
                ImageFileInfo re = AlbumImageBrowseFragment.this.hJc.re(AlbumImageBrowseFragment.this.aWO);
                if (AlbumImageBrowseFragment.this.hIK.isAdded(re)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hJd, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hJd, false);
                }
                if (AlbumImageBrowseFragment.this.hIK != null && AlbumImageBrowseFragment.this.hIK.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.hIK.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.hJg.setVisibility(8);
                } else if (re == null || !re.isGif()) {
                    AlbumImageBrowseFragment.this.hJg.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hJg.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.of(AlbumImageBrowseFragment.this.hIK.isOriginalImg());
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
        this.hIY = (AlbumActivity) getBaseFragmentActivity();
        this.hIK = this.hIY.bLL();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aix = layoutInflater.inflate(e.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.aix.findViewById(e.g.img_back);
        this.hJd = (ImageView) this.aix.findViewById(e.g.img_choose);
        this.mViewPager = (ViewPager) this.aix.findViewById(e.g.viewPager);
        this.mNoDataView = this.aix.findViewById(e.g.album_no_data);
        this.hJf = (TextView) this.aix.findViewById(e.g.btn_next_step);
        this.hJg = (TextView) this.aix.findViewById(e.g.original_select_btn);
        this.hJe = this.aix.findViewById(e.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hIY);
        this.hJf.setOnClickListener(this.hIY);
        this.hJd.setOnClickListener(this.mOnClickListener);
        this.hJg.setOnClickListener(this.hIY);
        this.hJe.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hIK != null && this.hIK.getWriteImagesInfo() != null) {
            this.hJg.setVisibility(this.hIK.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.aix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLW() {
        this.hIY.bLJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Zk();
        }
    }

    private void bLX() {
        List<ImageFileInfo> bMf;
        int currentIndex;
        boolean z = true;
        if (this.hIK == null && this.hIY != null) {
            this.hIK = this.hIY.bLL();
        }
        if (this.hIK != null && (bMf = this.hIK.bMf()) != null && (currentIndex = this.hIK.getCurrentIndex()) >= 0) {
            this.aWO = currentIndex;
            this.hJc = new AlbumImagePagerAdapter(this.hIY);
            this.mViewPager.setAdapter(this.hJc);
            if (this.aWO == 0 && bMf != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(bMf, this.aWO);
                if (this.hIK.isAdded(imageFileInfo)) {
                    c(this.hJd, true);
                } else {
                    c(this.hJd, false);
                }
                if (this.hIK != null && this.hIK.getWriteImagesInfo() != null) {
                    z = this.hIK.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.hJg.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.hJg.setVisibility(8);
                } else {
                    this.hJg.setVisibility(0);
                }
            }
            this.hJc.setData(bMf);
            this.mViewPager.setCurrentItem(this.aWO, false);
            of(this.hIK.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hJc != null) {
            this.hJc.setData(null);
        }
    }

    public View bwq() {
        return this.mBackBtn;
    }

    public View bLY() {
        return this.hJf;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.aix);
        al.a(this.mBackBtn, e.f.icon_return_bg_s, e.f.icon_return_bg, i);
        if (this.hIK != null) {
            of(this.hIK.isOriginalImg());
        }
        if (this.hJc != null) {
            this.hJc.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hIY != null) {
            al.c(imageView, z ? e.f.ic_post_edit_select_s : e.f.icon_image_clear_select);
            if (this.hJf != null) {
                int I = this.hIK != null ? v.I(this.hIK.bMd()) : 0;
                this.hJf.setText(this.hIY.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(I), Integer.valueOf(this.hIK != null ? this.hIK.getMaxImagesAllowed() : 1)}));
                this.hJf.setEnabled(I > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo re;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hJc != null && (re = this.hJc.re(this.aWO)) != null && re.getFilePath() != null && re.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hJd, z);
        }
    }

    private void Zk() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bLX();
        }
    }

    public View bLU() {
        return this.hJg;
    }

    public void of(boolean z) {
        long j;
        if (this.hIY != null && this.hJg != null) {
            if (this.hJc != null) {
                ImageFileInfo re = this.hJc.re(this.aWO);
                j = re != null ? l.eV(re.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hIY.getResources().getString(e.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ao.S(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.h(this.hJg, e.d.cp_link_tip_a);
                this.hJg.setText(sb2);
                this.hJg.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.h(this.hJg, e.d.cp_cont_f);
            this.hJg.setText(string);
            this.hJg.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
