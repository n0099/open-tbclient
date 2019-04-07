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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private View bub;
    private AlbumActivity jmL;
    private AlbumImagePagerAdapter jmP;
    private ImageView jmQ;
    private View jmR;
    private TextView jmS;
    private TextView jmT;
    private c jmx;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int biV = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.jmR && view == AlbumImageBrowseFragment.this.jmQ && AlbumImageBrowseFragment.this.jmP != null && AlbumImageBrowseFragment.this.jmx != null && AlbumImageBrowseFragment.this.jmL != null) {
                if (AlbumImageBrowseFragment.this.jmx.coW()) {
                    AlbumImageBrowseFragment.this.jmL.showToast(d.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jmP.Bd(AlbumImageBrowseFragment.this.biV)) {
                    ImageFileInfo vL = AlbumImageBrowseFragment.this.jmP.vL(AlbumImageBrowseFragment.this.biV);
                    if (AlbumImageBrowseFragment.this.jmx.isAdded(vL)) {
                        if (AlbumImageBrowseFragment.this.jmL.e(vL)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jmQ, false);
                            AlbumImageBrowseFragment.this.jmL.f(vL, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jmL.d(vL)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jmQ, true);
                        AlbumImageBrowseFragment.this.jmL.f(vL, true);
                    }
                    AlbumImageBrowseFragment.this.coR();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.biV = i;
            if (AlbumImageBrowseFragment.this.jmP != null && AlbumImageBrowseFragment.this.jmx != null) {
                ImageFileInfo vL = AlbumImageBrowseFragment.this.jmP.vL(AlbumImageBrowseFragment.this.biV);
                if (AlbumImageBrowseFragment.this.jmx.isAdded(vL)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jmQ, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jmQ, false);
                }
                if (AlbumImageBrowseFragment.this.jmx != null && AlbumImageBrowseFragment.this.jmx.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jmx.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.jmT.setVisibility(8);
                } else if (vL == null || !vL.isGif()) {
                    AlbumImageBrowseFragment.this.jmT.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.jmT.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.qZ(AlbumImageBrowseFragment.this.jmx.isOriginalImg());
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
        this.jmL = (AlbumActivity) getBaseFragmentActivity();
        this.jmx = this.jmL.coG();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bub = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.bub.findViewById(d.g.img_back);
        this.jmQ = (ImageView) this.bub.findViewById(d.g.img_choose);
        this.mViewPager = (ViewPager) this.bub.findViewById(d.g.viewPager);
        this.mNoDataView = this.bub.findViewById(d.g.album_no_data);
        this.jmS = (TextView) this.bub.findViewById(d.g.btn_next_step);
        this.jmT = (TextView) this.bub.findViewById(d.g.original_select_btn);
        this.jmR = this.bub.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.jmL);
        this.jmS.setOnClickListener(this.jmL);
        this.jmQ.setOnClickListener(this.mOnClickListener);
        this.jmT.setOnClickListener(this.jmL);
        this.jmR.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jmx != null && this.jmx.getWriteImagesInfo() != null) {
            this.jmT.setVisibility(this.jmx.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.bub;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coR() {
        this.jmL.coE();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aBr();
        }
    }

    private void coS() {
        List<ImageFileInfo> cpa;
        int currentIndex;
        boolean z = true;
        if (this.jmx == null && this.jmL != null) {
            this.jmx = this.jmL.coG();
        }
        if (this.jmx != null && (cpa = this.jmx.cpa()) != null && (currentIndex = this.jmx.getCurrentIndex()) >= 0) {
            this.biV = currentIndex;
            this.jmP = new AlbumImagePagerAdapter(this.jmL);
            this.mViewPager.setAdapter(this.jmP);
            if (this.biV == 0 && cpa != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(cpa, this.biV);
                if (this.jmx.isAdded(imageFileInfo)) {
                    c(this.jmQ, true);
                } else {
                    c(this.jmQ, false);
                }
                if (this.jmx != null && this.jmx.getWriteImagesInfo() != null) {
                    z = this.jmx.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.jmT.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.jmT.setVisibility(8);
                } else {
                    this.jmT.setVisibility(0);
                }
            }
            this.jmP.setData(cpa);
            this.mViewPager.setCurrentItem(this.biV, false);
            qZ(this.jmx.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.jmP != null) {
            this.jmP.setData(null);
        }
    }

    public View bZQ() {
        return this.mBackBtn;
    }

    public View coT() {
        return this.jmS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.bub);
        al.a(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.jmx != null) {
            qZ(this.jmx.isOriginalImg());
        }
        if (this.jmP != null) {
            this.jmP.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.jmL != null) {
            al.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.jmS != null) {
                int S = this.jmx != null ? v.S(this.jmx.coY()) : 0;
                this.jmS.setText(this.jmL.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(S), Integer.valueOf(this.jmx != null ? this.jmx.getMaxImagesAllowed() : 1)}));
                this.jmS.setEnabled(S > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo vL;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jmP != null && (vL = this.jmP.vL(this.biV)) != null && vL.getFilePath() != null && vL.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.jmQ, z);
        }
    }

    private void aBr() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            coS();
        }
    }

    public View coP() {
        return this.jmT;
    }

    public void qZ(boolean z) {
        long j;
        if (this.jmL != null && this.jmT != null) {
            if (this.jmP != null) {
                ImageFileInfo vL = this.jmP.vL(this.biV);
                j = vL != null ? m.iD(vL.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.jmL.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ap.aE(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.j(this.jmT, d.C0277d.cp_link_tip_a);
                this.jmT.setText(sb2);
                this.jmT.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.j(this.jmT, d.C0277d.cp_cont_f);
            this.jmT.setText(string);
            this.jmT.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
