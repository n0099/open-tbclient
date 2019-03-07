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
    private View btW;
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
    private int biR = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.jmS && view == AlbumImageBrowseFragment.this.jmR && AlbumImageBrowseFragment.this.jmQ != null && AlbumImageBrowseFragment.this.jmy != null && AlbumImageBrowseFragment.this.jmM != null) {
                if (AlbumImageBrowseFragment.this.jmy.coL()) {
                    AlbumImageBrowseFragment.this.jmM.showToast(d.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jmQ.Bg(AlbumImageBrowseFragment.this.biR)) {
                    ImageFileInfo vP = AlbumImageBrowseFragment.this.jmQ.vP(AlbumImageBrowseFragment.this.biR);
                    if (AlbumImageBrowseFragment.this.jmy.isAdded(vP)) {
                        if (AlbumImageBrowseFragment.this.jmM.e(vP)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jmR, false);
                            AlbumImageBrowseFragment.this.jmM.f(vP, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jmM.d(vP)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jmR, true);
                        AlbumImageBrowseFragment.this.jmM.f(vP, true);
                    }
                    AlbumImageBrowseFragment.this.coG();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.biR = i;
            if (AlbumImageBrowseFragment.this.jmQ != null && AlbumImageBrowseFragment.this.jmy != null) {
                ImageFileInfo vP = AlbumImageBrowseFragment.this.jmQ.vP(AlbumImageBrowseFragment.this.biR);
                if (AlbumImageBrowseFragment.this.jmy.isAdded(vP)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jmR, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jmR, false);
                }
                if (AlbumImageBrowseFragment.this.jmy != null && AlbumImageBrowseFragment.this.jmy.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jmy.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.jmU.setVisibility(8);
                } else if (vP == null || !vP.isGif()) {
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
        this.jmy = this.jmM.cov();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.btW = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.btW.findViewById(d.g.img_back);
        this.jmR = (ImageView) this.btW.findViewById(d.g.img_choose);
        this.mViewPager = (ViewPager) this.btW.findViewById(d.g.viewPager);
        this.mNoDataView = this.btW.findViewById(d.g.album_no_data);
        this.jmT = (TextView) this.btW.findViewById(d.g.btn_next_step);
        this.jmU = (TextView) this.btW.findViewById(d.g.original_select_btn);
        this.jmS = this.btW.findViewById(d.g.layout_bottom);
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
        return this.btW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coG() {
        this.jmM.cot();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aBu();
        }
    }

    private void coH() {
        List<ImageFileInfo> coP;
        int currentIndex;
        boolean z = true;
        if (this.jmy == null && this.jmM != null) {
            this.jmy = this.jmM.cov();
        }
        if (this.jmy != null && (coP = this.jmy.coP()) != null && (currentIndex = this.jmy.getCurrentIndex()) >= 0) {
            this.biR = currentIndex;
            this.jmQ = new AlbumImagePagerAdapter(this.jmM);
            this.mViewPager.setAdapter(this.jmQ);
            if (this.biR == 0 && coP != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(coP, this.biR);
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
            this.jmQ.setData(coP);
            this.mViewPager.setCurrentItem(this.biR, false);
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

    public View bZR() {
        return this.mBackBtn;
    }

    public View coI() {
        return this.jmT;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.btW);
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
                int S = this.jmy != null ? v.S(this.jmy.coN()) : 0;
                this.jmT.setText(this.jmM.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(S), Integer.valueOf(this.jmy != null ? this.jmy.getMaxImagesAllowed() : 1)}));
                this.jmT.setEnabled(S > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo vP;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jmQ != null && (vP = this.jmQ.vP(this.biR)) != null && vP.getFilePath() != null && vP.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.jmR, z);
        }
    }

    private void aBu() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            coH();
        }
    }

    public View coE() {
        return this.jmU;
    }

    public void qZ(boolean z) {
        long j;
        if (this.jmM != null && this.jmU != null) {
            if (this.jmQ != null) {
                ImageFileInfo vP = this.jmQ.vP(this.biR);
                j = vP != null ? m.iC(vP.getFilePath()) : 0L;
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
                al.j(this.jmU, d.C0236d.cp_link_tip_a);
                this.jmU.setText(sb2);
                this.jmU.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.j(this.jmU, d.C0236d.cp_cont_f);
            this.jmU.setText(string);
            this.jmU.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
