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
    private View btY;
    private c jmJ;
    private AlbumActivity jmX;
    private AlbumImagePagerAdapter jnb;
    private ImageView jnc;
    private View jnd;
    private TextView jne;
    private TextView jnf;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int biS = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.jnd && view == AlbumImageBrowseFragment.this.jnc && AlbumImageBrowseFragment.this.jnb != null && AlbumImageBrowseFragment.this.jmJ != null && AlbumImageBrowseFragment.this.jmX != null) {
                if (AlbumImageBrowseFragment.this.jmJ.coY()) {
                    AlbumImageBrowseFragment.this.jmX.showToast(d.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jnb.Bh(AlbumImageBrowseFragment.this.biS)) {
                    ImageFileInfo vP = AlbumImageBrowseFragment.this.jnb.vP(AlbumImageBrowseFragment.this.biS);
                    if (AlbumImageBrowseFragment.this.jmJ.isAdded(vP)) {
                        if (AlbumImageBrowseFragment.this.jmX.e(vP)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jnc, false);
                            AlbumImageBrowseFragment.this.jmX.f(vP, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jmX.d(vP)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jnc, true);
                        AlbumImageBrowseFragment.this.jmX.f(vP, true);
                    }
                    AlbumImageBrowseFragment.this.coT();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.biS = i;
            if (AlbumImageBrowseFragment.this.jnb != null && AlbumImageBrowseFragment.this.jmJ != null) {
                ImageFileInfo vP = AlbumImageBrowseFragment.this.jnb.vP(AlbumImageBrowseFragment.this.biS);
                if (AlbumImageBrowseFragment.this.jmJ.isAdded(vP)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jnc, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jnc, false);
                }
                if (AlbumImageBrowseFragment.this.jmJ != null && AlbumImageBrowseFragment.this.jmJ.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jmJ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.jnf.setVisibility(8);
                } else if (vP == null || !vP.isGif()) {
                    AlbumImageBrowseFragment.this.jnf.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.jnf.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.qZ(AlbumImageBrowseFragment.this.jmJ.isOriginalImg());
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
        this.jmX = (AlbumActivity) getBaseFragmentActivity();
        this.jmJ = this.jmX.coI();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.btY = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.btY.findViewById(d.g.img_back);
        this.jnc = (ImageView) this.btY.findViewById(d.g.img_choose);
        this.mViewPager = (ViewPager) this.btY.findViewById(d.g.viewPager);
        this.mNoDataView = this.btY.findViewById(d.g.album_no_data);
        this.jne = (TextView) this.btY.findViewById(d.g.btn_next_step);
        this.jnf = (TextView) this.btY.findViewById(d.g.original_select_btn);
        this.jnd = this.btY.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.jmX);
        this.jne.setOnClickListener(this.jmX);
        this.jnc.setOnClickListener(this.mOnClickListener);
        this.jnf.setOnClickListener(this.jmX);
        this.jnd.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jmJ != null && this.jmJ.getWriteImagesInfo() != null) {
            this.jnf.setVisibility(this.jmJ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.btY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coT() {
        this.jmX.coG();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aBu();
        }
    }

    private void coU() {
        List<ImageFileInfo> cpc;
        int currentIndex;
        boolean z = true;
        if (this.jmJ == null && this.jmX != null) {
            this.jmJ = this.jmX.coI();
        }
        if (this.jmJ != null && (cpc = this.jmJ.cpc()) != null && (currentIndex = this.jmJ.getCurrentIndex()) >= 0) {
            this.biS = currentIndex;
            this.jnb = new AlbumImagePagerAdapter(this.jmX);
            this.mViewPager.setAdapter(this.jnb);
            if (this.biS == 0 && cpc != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(cpc, this.biS);
                if (this.jmJ.isAdded(imageFileInfo)) {
                    c(this.jnc, true);
                } else {
                    c(this.jnc, false);
                }
                if (this.jmJ != null && this.jmJ.getWriteImagesInfo() != null) {
                    z = this.jmJ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.jnf.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.jnf.setVisibility(8);
                } else {
                    this.jnf.setVisibility(0);
                }
            }
            this.jnb.setData(cpc);
            this.mViewPager.setCurrentItem(this.biS, false);
            qZ(this.jmJ.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.jnb != null) {
            this.jnb.setData(null);
        }
    }

    public View bZU() {
        return this.mBackBtn;
    }

    public View coV() {
        return this.jne;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.btY);
        al.a(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.jmJ != null) {
            qZ(this.jmJ.isOriginalImg());
        }
        if (this.jnb != null) {
            this.jnb.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.jmX != null) {
            al.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.jne != null) {
                int S = this.jmJ != null ? v.S(this.jmJ.cpa()) : 0;
                this.jne.setText(this.jmX.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(S), Integer.valueOf(this.jmJ != null ? this.jmJ.getMaxImagesAllowed() : 1)}));
                this.jne.setEnabled(S > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo vP;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jnb != null && (vP = this.jnb.vP(this.biS)) != null && vP.getFilePath() != null && vP.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.jnc, z);
        }
    }

    private void aBu() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            coU();
        }
    }

    public View coR() {
        return this.jnf;
    }

    public void qZ(boolean z) {
        long j;
        if (this.jmX != null && this.jnf != null) {
            if (this.jnb != null) {
                ImageFileInfo vP = this.jnb.vP(this.biS);
                j = vP != null ? m.iC(vP.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.jmX.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ap.aE(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.j(this.jnf, d.C0277d.cp_link_tip_a);
                this.jnf.setText(sb2);
                this.jnf.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.j(this.jnf, d.C0277d.cp_cont_f);
            this.jnf.setText(string);
            this.jnf.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
