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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private View abp;
    private AlbumImagePagerAdapter hoA;
    private ImageView hoB;
    private View hoC;
    private TextView hoD;
    private TextView hoE;
    private c hoj;
    private AlbumActivity how;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aOd = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.hoC && view == AlbumImageBrowseFragment.this.hoB && AlbumImageBrowseFragment.this.hoA != null && AlbumImageBrowseFragment.this.hoj != null && AlbumImageBrowseFragment.this.how != null) {
                if (AlbumImageBrowseFragment.this.hoj.bGJ()) {
                    AlbumImageBrowseFragment.this.how.showToast(d.k.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hoA.vi(AlbumImageBrowseFragment.this.aOd)) {
                    ImageFileInfo pY = AlbumImageBrowseFragment.this.hoA.pY(AlbumImageBrowseFragment.this.aOd);
                    if (AlbumImageBrowseFragment.this.hoj.isAdded(pY)) {
                        if (AlbumImageBrowseFragment.this.how.d(pY)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hoB, false);
                            AlbumImageBrowseFragment.this.how.f(pY, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.how.c(pY)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hoB, true);
                        AlbumImageBrowseFragment.this.how.f(pY, true);
                    }
                    AlbumImageBrowseFragment.this.bGE();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.aOd = i;
            if (AlbumImageBrowseFragment.this.hoA != null && AlbumImageBrowseFragment.this.hoj != null) {
                ImageFileInfo pY = AlbumImageBrowseFragment.this.hoA.pY(AlbumImageBrowseFragment.this.aOd);
                if (AlbumImageBrowseFragment.this.hoj.isAdded(pY)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hoB, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hoB, false);
                }
                if (pY == null || !pY.isGif()) {
                    AlbumImageBrowseFragment.this.hoE.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hoE.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.nw(AlbumImageBrowseFragment.this.hoj.isOriginalImg());
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
        this.how = (AlbumActivity) getBaseFragmentActivity();
        this.hoj = this.how.bGt();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.abp = layoutInflater.inflate(d.i.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.abp.findViewById(d.g.img_back);
        this.hoB = (ImageView) this.abp.findViewById(d.g.img_choose);
        this.mViewPager = (ViewPager) this.abp.findViewById(d.g.viewPager);
        this.mNoDataView = this.abp.findViewById(d.g.album_no_data);
        this.hoD = (TextView) this.abp.findViewById(d.g.btn_next_step);
        this.hoE = (TextView) this.abp.findViewById(d.g.original_select_btn);
        this.hoC = this.abp.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.how);
        this.hoD.setOnClickListener(this.how);
        this.hoB.setOnClickListener(this.mOnClickListener);
        this.hoE.setOnClickListener(this.how);
        this.hoC.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.abp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGE() {
        this.how.bGr();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Tk();
        }
    }

    private void bGF() {
        List<ImageFileInfo> bGN;
        int currentIndex;
        if (this.hoj == null && this.how != null) {
            this.hoj = this.how.bGt();
        }
        if (this.hoj != null && (bGN = this.hoj.bGN()) != null && (currentIndex = this.hoj.getCurrentIndex()) >= 0) {
            this.aOd = currentIndex;
            this.hoA = new AlbumImagePagerAdapter(this.how);
            this.mViewPager.setAdapter(this.hoA);
            if (this.aOd == 0 && bGN != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) w.c(bGN, this.aOd);
                if (this.hoj.isAdded(imageFileInfo)) {
                    c(this.hoB, true);
                } else {
                    c(this.hoB, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hoE.setVisibility(8);
                } else {
                    this.hoE.setVisibility(0);
                }
            }
            this.hoA.setData(bGN);
            this.mViewPager.setCurrentItem(this.aOd, false);
            nw(this.hoj.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hoA != null) {
            this.hoA.setData(null);
        }
    }

    public View brt() {
        return this.mBackBtn;
    }

    public View bGG() {
        return this.hoD;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.abp);
        al.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hoj != null) {
            nw(this.hoj.isOriginalImg());
        }
        if (this.hoA != null) {
            this.hoA.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.how != null) {
            al.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hoD != null) {
                int y = this.hoj != null ? w.y(this.hoj.bGL()) : 0;
                this.hoD.setText(this.how.getString(d.k.image_selected_list_count_max, new Object[]{Integer.valueOf(y), Integer.valueOf(this.hoj != null ? this.hoj.getMaxImagesAllowed() : 1)}));
                this.hoD.setEnabled(y > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo pY;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hoA != null && (pY = this.hoA.pY(this.aOd)) != null && pY.getFilePath() != null && pY.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hoB, z);
        }
    }

    private void Tk() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bGF();
        }
    }

    public View bGC() {
        return this.hoE;
    }

    public void nw(boolean z) {
        long j;
        if (this.how != null && this.hoE != null) {
            if (this.hoA != null) {
                ImageFileInfo pY = this.hoA.pY(this.aOd);
                j = pY != null ? l.em(pY.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.how.getResources().getString(d.k.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ao.J(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.h(this.hoE, d.C0141d.cp_link_tip_a);
                this.hoE.setText(sb2);
                this.hoE.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.h(this.hoE, d.C0141d.cp_cont_f);
            this.hoE.setText(string);
            this.hoE.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
