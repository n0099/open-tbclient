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
    private c jmR;
    private AlbumActivity jnf;
    private AlbumImagePagerAdapter jnj;
    private ImageView jnk;
    private View jnl;
    private TextView jnm;
    private TextView jnn;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int biR = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.jnl && view == AlbumImageBrowseFragment.this.jnk && AlbumImageBrowseFragment.this.jnj != null && AlbumImageBrowseFragment.this.jmR != null && AlbumImageBrowseFragment.this.jnf != null) {
                if (AlbumImageBrowseFragment.this.jmR.coV()) {
                    AlbumImageBrowseFragment.this.jnf.showToast(d.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jnj.Bh(AlbumImageBrowseFragment.this.biR)) {
                    ImageFileInfo vP = AlbumImageBrowseFragment.this.jnj.vP(AlbumImageBrowseFragment.this.biR);
                    if (AlbumImageBrowseFragment.this.jmR.isAdded(vP)) {
                        if (AlbumImageBrowseFragment.this.jnf.e(vP)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jnk, false);
                            AlbumImageBrowseFragment.this.jnf.f(vP, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jnf.d(vP)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jnk, true);
                        AlbumImageBrowseFragment.this.jnf.f(vP, true);
                    }
                    AlbumImageBrowseFragment.this.coQ();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.biR = i;
            if (AlbumImageBrowseFragment.this.jnj != null && AlbumImageBrowseFragment.this.jmR != null) {
                ImageFileInfo vP = AlbumImageBrowseFragment.this.jnj.vP(AlbumImageBrowseFragment.this.biR);
                if (AlbumImageBrowseFragment.this.jmR.isAdded(vP)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jnk, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jnk, false);
                }
                if (AlbumImageBrowseFragment.this.jmR != null && AlbumImageBrowseFragment.this.jmR.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jmR.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.jnn.setVisibility(8);
                } else if (vP == null || !vP.isGif()) {
                    AlbumImageBrowseFragment.this.jnn.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.jnn.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.qZ(AlbumImageBrowseFragment.this.jmR.isOriginalImg());
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
        this.jnf = (AlbumActivity) getBaseFragmentActivity();
        this.jmR = this.jnf.coF();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.btW = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.btW.findViewById(d.g.img_back);
        this.jnk = (ImageView) this.btW.findViewById(d.g.img_choose);
        this.mViewPager = (ViewPager) this.btW.findViewById(d.g.viewPager);
        this.mNoDataView = this.btW.findViewById(d.g.album_no_data);
        this.jnm = (TextView) this.btW.findViewById(d.g.btn_next_step);
        this.jnn = (TextView) this.btW.findViewById(d.g.original_select_btn);
        this.jnl = this.btW.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.jnf);
        this.jnm.setOnClickListener(this.jnf);
        this.jnk.setOnClickListener(this.mOnClickListener);
        this.jnn.setOnClickListener(this.jnf);
        this.jnl.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jmR != null && this.jmR.getWriteImagesInfo() != null) {
            this.jnn.setVisibility(this.jmR.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.btW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coQ() {
        this.jnf.coD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aBv();
        }
    }

    private void coR() {
        List<ImageFileInfo> coZ;
        int currentIndex;
        boolean z = true;
        if (this.jmR == null && this.jnf != null) {
            this.jmR = this.jnf.coF();
        }
        if (this.jmR != null && (coZ = this.jmR.coZ()) != null && (currentIndex = this.jmR.getCurrentIndex()) >= 0) {
            this.biR = currentIndex;
            this.jnj = new AlbumImagePagerAdapter(this.jnf);
            this.mViewPager.setAdapter(this.jnj);
            if (this.biR == 0 && coZ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(coZ, this.biR);
                if (this.jmR.isAdded(imageFileInfo)) {
                    c(this.jnk, true);
                } else {
                    c(this.jnk, false);
                }
                if (this.jmR != null && this.jmR.getWriteImagesInfo() != null) {
                    z = this.jmR.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.jnn.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.jnn.setVisibility(8);
                } else {
                    this.jnn.setVisibility(0);
                }
            }
            this.jnj.setData(coZ);
            this.mViewPager.setCurrentItem(this.biR, false);
            qZ(this.jmR.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.jnj != null) {
            this.jnj.setData(null);
        }
    }

    public View bZS() {
        return this.mBackBtn;
    }

    public View coS() {
        return this.jnm;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.btW);
        al.a(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.jmR != null) {
            qZ(this.jmR.isOriginalImg());
        }
        if (this.jnj != null) {
            this.jnj.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.jnf != null) {
            al.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.jnm != null) {
                int S = this.jmR != null ? v.S(this.jmR.coX()) : 0;
                this.jnm.setText(this.jnf.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(S), Integer.valueOf(this.jmR != null ? this.jmR.getMaxImagesAllowed() : 1)}));
                this.jnm.setEnabled(S > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo vP;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jnj != null && (vP = this.jnj.vP(this.biR)) != null && vP.getFilePath() != null && vP.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.jnk, z);
        }
    }

    private void aBv() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            coR();
        }
    }

    public View coO() {
        return this.jnn;
    }

    public void qZ(boolean z) {
        long j;
        if (this.jnf != null && this.jnn != null) {
            if (this.jnj != null) {
                ImageFileInfo vP = this.jnj.vP(this.biR);
                j = vP != null ? m.iC(vP.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.jnf.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ap.aE(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.j(this.jnn, d.C0236d.cp_link_tip_a);
                this.jnn.setText(sb2);
                this.jnn.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.j(this.jnn, d.C0236d.cp_cont_f);
            this.jnn.setText(string);
            this.jnn.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
