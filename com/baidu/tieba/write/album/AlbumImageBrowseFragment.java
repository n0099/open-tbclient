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
    private View buc;
    private AlbumActivity jmM;
    private AlbumImagePagerAdapter jmQ;
    private ImageView jmR;
    private View jmS;
    private TextView jmT;
    private TextView jmU;
    private c jmy;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int biW = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.jmS && view == AlbumImageBrowseFragment.this.jmR && AlbumImageBrowseFragment.this.jmQ != null && AlbumImageBrowseFragment.this.jmy != null && AlbumImageBrowseFragment.this.jmM != null) {
                if (AlbumImageBrowseFragment.this.jmy.coW()) {
                    AlbumImageBrowseFragment.this.jmM.showToast(d.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jmQ.Bd(AlbumImageBrowseFragment.this.biW)) {
                    ImageFileInfo vL = AlbumImageBrowseFragment.this.jmQ.vL(AlbumImageBrowseFragment.this.biW);
                    if (AlbumImageBrowseFragment.this.jmy.isAdded(vL)) {
                        if (AlbumImageBrowseFragment.this.jmM.e(vL)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jmR, false);
                            AlbumImageBrowseFragment.this.jmM.f(vL, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jmM.d(vL)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jmR, true);
                        AlbumImageBrowseFragment.this.jmM.f(vL, true);
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
            AlbumImageBrowseFragment.this.biW = i;
            if (AlbumImageBrowseFragment.this.jmQ != null && AlbumImageBrowseFragment.this.jmy != null) {
                ImageFileInfo vL = AlbumImageBrowseFragment.this.jmQ.vL(AlbumImageBrowseFragment.this.biW);
                if (AlbumImageBrowseFragment.this.jmy.isAdded(vL)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jmR, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jmR, false);
                }
                if (AlbumImageBrowseFragment.this.jmy != null && AlbumImageBrowseFragment.this.jmy.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jmy.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.jmU.setVisibility(8);
                } else if (vL == null || !vL.isGif()) {
                    AlbumImageBrowseFragment.this.jmU.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.jmU.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.qZ(AlbumImageBrowseFragment.this.jmy.isOriginalImg());
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
        this.jmM = (AlbumActivity) getBaseFragmentActivity();
        this.jmy = this.jmM.coG();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.buc = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.buc.findViewById(d.g.img_back);
        this.jmR = (ImageView) this.buc.findViewById(d.g.img_choose);
        this.mViewPager = (ViewPager) this.buc.findViewById(d.g.viewPager);
        this.mNoDataView = this.buc.findViewById(d.g.album_no_data);
        this.jmT = (TextView) this.buc.findViewById(d.g.btn_next_step);
        this.jmU = (TextView) this.buc.findViewById(d.g.original_select_btn);
        this.jmS = this.buc.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.jmM);
        this.jmT.setOnClickListener(this.jmM);
        this.jmR.setOnClickListener(this.mOnClickListener);
        this.jmU.setOnClickListener(this.jmM);
        this.jmS.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jmy != null && this.jmy.getWriteImagesInfo() != null) {
            this.jmU.setVisibility(this.jmy.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.buc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coR() {
        this.jmM.coE();
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
        if (this.jmy == null && this.jmM != null) {
            this.jmy = this.jmM.coG();
        }
        if (this.jmy != null && (cpa = this.jmy.cpa()) != null && (currentIndex = this.jmy.getCurrentIndex()) >= 0) {
            this.biW = currentIndex;
            this.jmQ = new AlbumImagePagerAdapter(this.jmM);
            this.mViewPager.setAdapter(this.jmQ);
            if (this.biW == 0 && cpa != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(cpa, this.biW);
                if (this.jmy.isAdded(imageFileInfo)) {
                    c(this.jmR, true);
                } else {
                    c(this.jmR, false);
                }
                if (this.jmy != null && this.jmy.getWriteImagesInfo() != null) {
                    z = this.jmy.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.jmU.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.jmU.setVisibility(8);
                } else {
                    this.jmU.setVisibility(0);
                }
            }
            this.jmQ.setData(cpa);
            this.mViewPager.setCurrentItem(this.biW, false);
            qZ(this.jmy.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.jmQ != null) {
            this.jmQ.setData(null);
        }
    }

    public View bZQ() {
        return this.mBackBtn;
    }

    public View coT() {
        return this.jmT;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.buc);
        al.a(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.jmy != null) {
            qZ(this.jmy.isOriginalImg());
        }
        if (this.jmQ != null) {
            this.jmQ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.jmM != null) {
            al.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.jmT != null) {
                int S = this.jmy != null ? v.S(this.jmy.coY()) : 0;
                this.jmT.setText(this.jmM.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(S), Integer.valueOf(this.jmy != null ? this.jmy.getMaxImagesAllowed() : 1)}));
                this.jmT.setEnabled(S > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo vL;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jmQ != null && (vL = this.jmQ.vL(this.biW)) != null && vL.getFilePath() != null && vL.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.jmR, z);
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
        return this.jmU;
    }

    public void qZ(boolean z) {
        long j;
        if (this.jmM != null && this.jmU != null) {
            if (this.jmQ != null) {
                ImageFileInfo vL = this.jmQ.vL(this.biW);
                j = vL != null ? m.iD(vL.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.jmM.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ap.aE(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.j(this.jmU, d.C0277d.cp_link_tip_a);
                this.jmU.setText(sb2);
                this.jmU.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.j(this.jmU, d.C0277d.cp_cont_f);
            this.jmU.setText(string);
            this.jmU.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
