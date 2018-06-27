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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private View abt;
    private AlbumActivity hsG;
    private AlbumImagePagerAdapter hsK;
    private ImageView hsL;
    private View hsM;
    private TextView hsN;
    private TextView hsO;
    private c hss;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aOZ = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.hsM && view == AlbumImageBrowseFragment.this.hsL && AlbumImageBrowseFragment.this.hsK != null && AlbumImageBrowseFragment.this.hss != null && AlbumImageBrowseFragment.this.hsG != null) {
                if (AlbumImageBrowseFragment.this.hss.bHk()) {
                    AlbumImageBrowseFragment.this.hsG.showToast(d.k.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hsK.vr(AlbumImageBrowseFragment.this.aOZ)) {
                    ImageFileInfo qf = AlbumImageBrowseFragment.this.hsK.qf(AlbumImageBrowseFragment.this.aOZ);
                    if (AlbumImageBrowseFragment.this.hss.isAdded(qf)) {
                        if (AlbumImageBrowseFragment.this.hsG.d(qf)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hsL, false);
                            AlbumImageBrowseFragment.this.hsG.f(qf, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.hsG.c(qf)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hsL, true);
                        AlbumImageBrowseFragment.this.hsG.f(qf, true);
                    }
                    AlbumImageBrowseFragment.this.bHf();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.aOZ = i;
            if (AlbumImageBrowseFragment.this.hsK != null && AlbumImageBrowseFragment.this.hss != null) {
                ImageFileInfo qf = AlbumImageBrowseFragment.this.hsK.qf(AlbumImageBrowseFragment.this.aOZ);
                if (AlbumImageBrowseFragment.this.hss.isAdded(qf)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hsL, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hsL, false);
                }
                if (qf == null || !qf.isGif()) {
                    AlbumImageBrowseFragment.this.hsO.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hsO.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.nE(AlbumImageBrowseFragment.this.hss.isOriginalImg());
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
        this.hsG = (AlbumActivity) getBaseFragmentActivity();
        this.hss = this.hsG.bGU();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.abt = layoutInflater.inflate(d.i.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.abt.findViewById(d.g.img_back);
        this.hsL = (ImageView) this.abt.findViewById(d.g.img_choose);
        this.mViewPager = (ViewPager) this.abt.findViewById(d.g.viewPager);
        this.mNoDataView = this.abt.findViewById(d.g.album_no_data);
        this.hsN = (TextView) this.abt.findViewById(d.g.btn_next_step);
        this.hsO = (TextView) this.abt.findViewById(d.g.original_select_btn);
        this.hsM = this.abt.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hsG);
        this.hsN.setOnClickListener(this.hsG);
        this.hsL.setOnClickListener(this.mOnClickListener);
        this.hsO.setOnClickListener(this.hsG);
        this.hsM.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.abt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHf() {
        this.hsG.bGS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            TE();
        }
    }

    private void bHg() {
        List<ImageFileInfo> bHo;
        int currentIndex;
        if (this.hss == null && this.hsG != null) {
            this.hss = this.hsG.bGU();
        }
        if (this.hss != null && (bHo = this.hss.bHo()) != null && (currentIndex = this.hss.getCurrentIndex()) >= 0) {
            this.aOZ = currentIndex;
            this.hsK = new AlbumImagePagerAdapter(this.hsG);
            this.mViewPager.setAdapter(this.hsK);
            if (this.aOZ == 0 && bHo != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) w.d(bHo, this.aOZ);
                if (this.hss.isAdded(imageFileInfo)) {
                    c(this.hsL, true);
                } else {
                    c(this.hsL, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hsO.setVisibility(8);
                } else {
                    this.hsO.setVisibility(0);
                }
            }
            this.hsK.setData(bHo);
            this.mViewPager.setCurrentItem(this.aOZ, false);
            nE(this.hss.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hsK != null) {
            this.hsK.setData(null);
        }
    }

    public View brU() {
        return this.mBackBtn;
    }

    public View bHh() {
        return this.hsN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.abt);
        am.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hss != null) {
            nE(this.hss.isOriginalImg());
        }
        if (this.hsK != null) {
            this.hsK.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hsG != null) {
            am.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hsN != null) {
                int z2 = this.hss != null ? w.z(this.hss.bHm()) : 0;
                this.hsN.setText(this.hsG.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(z2), Integer.valueOf(this.hss != null ? this.hss.getMaxImagesAllowed() : 1)}));
                this.hsN.setEnabled(z2 > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo qf;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hsK != null && (qf = this.hsK.qf(this.aOZ)) != null && qf.getFilePath() != null && qf.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hsL, z);
        }
    }

    private void TE() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bHg();
        }
    }

    public View bHd() {
        return this.hsO;
    }

    public void nE(boolean z) {
        long j;
        if (this.hsG != null && this.hsO != null) {
            if (this.hsK != null) {
                ImageFileInfo qf = this.hsK.qf(this.aOZ);
                j = qf != null ? l.ep(qf.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hsG.getResources().getString(d.k.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ap.K(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.h(this.hsO, d.C0142d.cp_link_tip_a);
                this.hsO.setText(sb2);
                this.hsO.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.h(this.hsO, d.C0142d.cp_cont_f);
            this.hsO.setText(string);
            this.hsO.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
