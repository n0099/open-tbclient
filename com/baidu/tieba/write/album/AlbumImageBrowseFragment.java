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
    private View aaV;
    private c htA;
    private AlbumActivity htN;
    private AlbumImagePagerAdapter htR;
    private ImageView htS;
    private View htT;
    private TextView htU;
    private TextView htV;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aOY = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.htT && view == AlbumImageBrowseFragment.this.htS && AlbumImageBrowseFragment.this.htR != null && AlbumImageBrowseFragment.this.htA != null && AlbumImageBrowseFragment.this.htN != null) {
                if (AlbumImageBrowseFragment.this.htA.bFV()) {
                    AlbumImageBrowseFragment.this.htN.showToast(d.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.htR.vq(AlbumImageBrowseFragment.this.aOY)) {
                    ImageFileInfo qc = AlbumImageBrowseFragment.this.htR.qc(AlbumImageBrowseFragment.this.aOY);
                    if (AlbumImageBrowseFragment.this.htA.isAdded(qc)) {
                        if (AlbumImageBrowseFragment.this.htN.d(qc)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.htS, false);
                            AlbumImageBrowseFragment.this.htN.f(qc, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.htN.c(qc)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.htS, true);
                        AlbumImageBrowseFragment.this.htN.f(qc, true);
                    }
                    AlbumImageBrowseFragment.this.bFQ();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.aOY = i;
            if (AlbumImageBrowseFragment.this.htR != null && AlbumImageBrowseFragment.this.htA != null) {
                ImageFileInfo qc = AlbumImageBrowseFragment.this.htR.qc(AlbumImageBrowseFragment.this.aOY);
                if (AlbumImageBrowseFragment.this.htA.isAdded(qc)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.htS, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.htS, false);
                }
                if (qc == null || !qc.isGif()) {
                    AlbumImageBrowseFragment.this.htV.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.htV.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.ns(AlbumImageBrowseFragment.this.htA.isOriginalImg());
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
        this.htN = (AlbumActivity) getBaseFragmentActivity();
        this.htA = this.htN.bFF();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aaV = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.aaV.findViewById(d.g.img_back);
        this.htS = (ImageView) this.aaV.findViewById(d.g.img_choose);
        this.mViewPager = (ViewPager) this.aaV.findViewById(d.g.viewPager);
        this.mNoDataView = this.aaV.findViewById(d.g.album_no_data);
        this.htU = (TextView) this.aaV.findViewById(d.g.btn_next_step);
        this.htV = (TextView) this.aaV.findViewById(d.g.original_select_btn);
        this.htT = this.aaV.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.htN);
        this.htU.setOnClickListener(this.htN);
        this.htS.setOnClickListener(this.mOnClickListener);
        this.htV.setOnClickListener(this.htN);
        this.htT.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.aaV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFQ() {
        this.htN.bFD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            TM();
        }
    }

    private void bFR() {
        List<ImageFileInfo> bFZ;
        int currentIndex;
        if (this.htA == null && this.htN != null) {
            this.htA = this.htN.bFF();
        }
        if (this.htA != null && (bFZ = this.htA.bFZ()) != null && (currentIndex = this.htA.getCurrentIndex()) >= 0) {
            this.aOY = currentIndex;
            this.htR = new AlbumImagePagerAdapter(this.htN);
            this.mViewPager.setAdapter(this.htR);
            if (this.aOY == 0 && bFZ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) w.d(bFZ, this.aOY);
                if (this.htA.isAdded(imageFileInfo)) {
                    c(this.htS, true);
                } else {
                    c(this.htS, false);
                }
                if (imageFileInfo.isGif()) {
                    this.htV.setVisibility(8);
                } else {
                    this.htV.setVisibility(0);
                }
            }
            this.htR.setData(bFZ);
            this.mViewPager.setCurrentItem(this.aOY, false);
            ns(this.htA.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.htR != null) {
            this.htR.setData(null);
        }
    }

    public View bqx() {
        return this.mBackBtn;
    }

    public View bFS() {
        return this.htU;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.aaV);
        am.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.htA != null) {
            ns(this.htA.isOriginalImg());
        }
        if (this.htR != null) {
            this.htR.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.htN != null) {
            am.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.htU != null) {
                int y = this.htA != null ? w.y(this.htA.bFX()) : 0;
                this.htU.setText(this.htN.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(y), Integer.valueOf(this.htA != null ? this.htA.getMaxImagesAllowed() : 1)}));
                this.htU.setEnabled(y > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo qc;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.htR != null && (qc = this.htR.qc(this.aOY)) != null && qc.getFilePath() != null && qc.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.htS, z);
        }
    }

    private void TM() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bFR();
        }
    }

    public View bFO() {
        return this.htV;
    }

    public void ns(boolean z) {
        long j;
        if (this.htN != null && this.htV != null) {
            if (this.htR != null) {
                ImageFileInfo qc = this.htR.qc(this.aOY);
                j = qc != null ? l.en(qc.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.htN.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ap.M(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.h(this.htV, d.C0140d.cp_link_tip_a);
                this.htV.setText(sb2);
                this.htV.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.h(this.htV, d.C0140d.cp_cont_f);
            this.htV.setText(string);
            this.htV.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
