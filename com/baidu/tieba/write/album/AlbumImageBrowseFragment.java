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
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private View aaW;
    private c htC;
    private AlbumActivity htP;
    private AlbumImagePagerAdapter htT;
    private ImageView htU;
    private View htV;
    private TextView htW;
    private TextView htX;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aOV = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.htV && view == AlbumImageBrowseFragment.this.htU && AlbumImageBrowseFragment.this.htT != null && AlbumImageBrowseFragment.this.htC != null && AlbumImageBrowseFragment.this.htP != null) {
                if (AlbumImageBrowseFragment.this.htC.bFZ()) {
                    AlbumImageBrowseFragment.this.htP.showToast(f.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.htT.vq(AlbumImageBrowseFragment.this.aOV)) {
                    ImageFileInfo qc = AlbumImageBrowseFragment.this.htT.qc(AlbumImageBrowseFragment.this.aOV);
                    if (AlbumImageBrowseFragment.this.htC.isAdded(qc)) {
                        if (AlbumImageBrowseFragment.this.htP.d(qc)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.htU, false);
                            AlbumImageBrowseFragment.this.htP.f(qc, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.htP.c(qc)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.htU, true);
                        AlbumImageBrowseFragment.this.htP.f(qc, true);
                    }
                    AlbumImageBrowseFragment.this.bFU();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.aOV = i;
            if (AlbumImageBrowseFragment.this.htT != null && AlbumImageBrowseFragment.this.htC != null) {
                ImageFileInfo qc = AlbumImageBrowseFragment.this.htT.qc(AlbumImageBrowseFragment.this.aOV);
                if (AlbumImageBrowseFragment.this.htC.isAdded(qc)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.htU, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.htU, false);
                }
                if (qc == null || !qc.isGif()) {
                    AlbumImageBrowseFragment.this.htX.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.htX.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.ns(AlbumImageBrowseFragment.this.htC.isOriginalImg());
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
        this.htP = (AlbumActivity) getBaseFragmentActivity();
        this.htC = this.htP.bFJ();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aaW = layoutInflater.inflate(f.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.aaW.findViewById(f.g.img_back);
        this.htU = (ImageView) this.aaW.findViewById(f.g.img_choose);
        this.mViewPager = (ViewPager) this.aaW.findViewById(f.g.viewPager);
        this.mNoDataView = this.aaW.findViewById(f.g.album_no_data);
        this.htW = (TextView) this.aaW.findViewById(f.g.btn_next_step);
        this.htX = (TextView) this.aaW.findViewById(f.g.original_select_btn);
        this.htV = this.aaW.findViewById(f.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.htP);
        this.htW.setOnClickListener(this.htP);
        this.htU.setOnClickListener(this.mOnClickListener);
        this.htX.setOnClickListener(this.htP);
        this.htV.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.aaW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFU() {
        this.htP.bFH();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            TP();
        }
    }

    private void bFV() {
        List<ImageFileInfo> bGd;
        int currentIndex;
        if (this.htC == null && this.htP != null) {
            this.htC = this.htP.bFJ();
        }
        if (this.htC != null && (bGd = this.htC.bGd()) != null && (currentIndex = this.htC.getCurrentIndex()) >= 0) {
            this.aOV = currentIndex;
            this.htT = new AlbumImagePagerAdapter(this.htP);
            this.mViewPager.setAdapter(this.htT);
            if (this.aOV == 0 && bGd != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) w.d(bGd, this.aOV);
                if (this.htC.isAdded(imageFileInfo)) {
                    c(this.htU, true);
                } else {
                    c(this.htU, false);
                }
                if (imageFileInfo.isGif()) {
                    this.htX.setVisibility(8);
                } else {
                    this.htX.setVisibility(0);
                }
            }
            this.htT.setData(bGd);
            this.mViewPager.setCurrentItem(this.aOV, false);
            ns(this.htC.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.htT != null) {
            this.htT.setData(null);
        }
    }

    public View bqy() {
        return this.mBackBtn;
    }

    public View bFW() {
        return this.htW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.aaW);
        am.b(this.mBackBtn, f.C0146f.icon_return_bg_s, f.C0146f.icon_return_bg, i);
        if (this.htC != null) {
            ns(this.htC.isOriginalImg());
        }
        if (this.htT != null) {
            this.htT.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.htP != null) {
            am.c(imageView, z ? f.C0146f.ic_post_edit_select_s : f.C0146f.icon_image_clear_select);
            if (this.htW != null) {
                int y = this.htC != null ? w.y(this.htC.bGb()) : 0;
                this.htW.setText(this.htP.getString(f.j.image_selected_list_count_max, new Object[]{Integer.valueOf(y), Integer.valueOf(this.htC != null ? this.htC.getMaxImagesAllowed() : 1)}));
                this.htW.setEnabled(y > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo qc;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.htT != null && (qc = this.htT.qc(this.aOV)) != null && qc.getFilePath() != null && qc.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.htU, z);
        }
    }

    private void TP() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bFV();
        }
    }

    public View bFS() {
        return this.htX;
    }

    public void ns(boolean z) {
        long j;
        if (this.htP != null && this.htX != null) {
            if (this.htT != null) {
                ImageFileInfo qc = this.htT.qc(this.aOV);
                j = qc != null ? l.en(qc.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.htP.getResources().getString(f.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ap.M(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.h(this.htX, f.d.cp_link_tip_a);
                this.htX.setText(sb2);
                this.htX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.h(this.htX, f.d.cp_cont_f);
            this.htX.setText(string);
            this.htX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
