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
    private View ajk;
    private AlbumActivity hKI;
    private AlbumImagePagerAdapter hKM;
    private ImageView hKN;
    private View hKO;
    private TextView hKP;
    private TextView hKQ;
    private c hKu;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.hKO && view == AlbumImageBrowseFragment.this.hKN && AlbumImageBrowseFragment.this.hKM != null && AlbumImageBrowseFragment.this.hKu != null && AlbumImageBrowseFragment.this.hKI != null) {
                if (AlbumImageBrowseFragment.this.hKu.bLA()) {
                    AlbumImageBrowseFragment.this.hKI.showToast(e.j.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.hKM.wG(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo rx2 = AlbumImageBrowseFragment.this.hKM.rx(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.hKu.isAdded(rx2)) {
                        if (AlbumImageBrowseFragment.this.hKI.d(rx2)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hKN, false);
                            AlbumImageBrowseFragment.this.hKI.f(rx2, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.hKI.c(rx2)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hKN, true);
                        AlbumImageBrowseFragment.this.hKI.f(rx2, true);
                    }
                    AlbumImageBrowseFragment.this.bLv();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.hKM != null && AlbumImageBrowseFragment.this.hKu != null) {
                ImageFileInfo rx2 = AlbumImageBrowseFragment.this.hKM.rx(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.hKu.isAdded(rx2)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hKN, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.hKN, false);
                }
                if (AlbumImageBrowseFragment.this.hKu != null && AlbumImageBrowseFragment.this.hKu.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.hKu.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.hKQ.setVisibility(8);
                } else if (rx2 == null || !rx2.isGif()) {
                    AlbumImageBrowseFragment.this.hKQ.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.hKQ.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.ot(AlbumImageBrowseFragment.this.hKu.isOriginalImg());
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
        this.hKI = (AlbumActivity) getBaseFragmentActivity();
        this.hKu = this.hKI.bLk();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ajk = layoutInflater.inflate(e.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.ajk.findViewById(e.g.img_back);
        this.hKN = (ImageView) this.ajk.findViewById(e.g.img_choose);
        this.mViewPager = (ViewPager) this.ajk.findViewById(e.g.viewPager);
        this.mNoDataView = this.ajk.findViewById(e.g.album_no_data);
        this.hKP = (TextView) this.ajk.findViewById(e.g.btn_next_step);
        this.hKQ = (TextView) this.ajk.findViewById(e.g.original_select_btn);
        this.hKO = this.ajk.findViewById(e.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hKI);
        this.hKP.setOnClickListener(this.hKI);
        this.hKN.setOnClickListener(this.mOnClickListener);
        this.hKQ.setOnClickListener(this.hKI);
        this.hKO.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hKu != null && this.hKu.getWriteImagesInfo() != null) {
            this.hKQ.setVisibility(this.hKu.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.ajk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLv() {
        this.hKI.bLi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Zu();
        }
    }

    private void bLw() {
        List<ImageFileInfo> bLE;
        int currentIndex;
        boolean z = true;
        if (this.hKu == null && this.hKI != null) {
            this.hKu = this.hKI.bLk();
        }
        if (this.hKu != null && (bLE = this.hKu.bLE()) != null && (currentIndex = this.hKu.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.hKM = new AlbumImagePagerAdapter(this.hKI);
            this.mViewPager.setAdapter(this.hKM);
            if (this.mCurrentIndex == 0 && bLE != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(bLE, this.mCurrentIndex);
                if (this.hKu.isAdded(imageFileInfo)) {
                    c(this.hKN, true);
                } else {
                    c(this.hKN, false);
                }
                if (this.hKu != null && this.hKu.getWriteImagesInfo() != null) {
                    z = this.hKu.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.hKQ.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.hKQ.setVisibility(8);
                } else {
                    this.hKQ.setVisibility(0);
                }
            }
            this.hKM.setData(bLE);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            ot(this.hKu.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hKM != null) {
            this.hKM.setData(null);
        }
    }

    public View bvM() {
        return this.mBackBtn;
    }

    public View bLx() {
        return this.hKP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(getPageContext(), this.ajk);
        al.a(this.mBackBtn, e.f.icon_return_bg_s, e.f.icon_return_bg, i);
        if (this.hKu != null) {
            ot(this.hKu.isOriginalImg());
        }
        if (this.hKM != null) {
            this.hKM.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hKI != null) {
            al.c(imageView, z ? e.f.ic_post_edit_select_s : e.f.icon_image_clear_select);
            if (this.hKP != null) {
                int H = this.hKu != null ? v.H(this.hKu.bLC()) : 0;
                this.hKP.setText(this.hKI.getString(e.j.image_selected_list_count_max, new Object[]{Integer.valueOf(H), Integer.valueOf(this.hKu != null ? this.hKu.getMaxImagesAllowed() : 1)}));
                this.hKP.setEnabled(H > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo rx2;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hKM != null && (rx2 = this.hKM.rx(this.mCurrentIndex)) != null && rx2.getFilePath() != null && rx2.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hKN, z);
        }
    }

    private void Zu() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bLw();
        }
    }

    public View bLt() {
        return this.hKQ;
    }

    public void ot(boolean z) {
        long j;
        if (this.hKI != null && this.hKQ != null) {
            if (this.hKM != null) {
                ImageFileInfo rx2 = this.hKM.rx(this.mCurrentIndex);
                j = rx2 != null ? l.eV(rx2.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hKI.getResources().getString(e.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ao.U(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.h(this.hKQ, e.d.cp_link_tip_a);
                this.hKQ.setText(sb2);
                this.hKQ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.h(this.hKQ, e.d.cp_cont_f);
            this.hKQ.setText(string);
            this.hKQ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
