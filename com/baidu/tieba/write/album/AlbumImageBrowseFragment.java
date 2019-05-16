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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private View bBg;
    private c jFA;
    private AlbumActivity jFO;
    private AlbumImagePagerAdapter jFS;
    private ImageView jFT;
    private View jFU;
    private TextView jFV;
    private TextView jFW;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int boZ = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.jFU && view == AlbumImageBrowseFragment.this.jFT && AlbumImageBrowseFragment.this.jFS != null && AlbumImageBrowseFragment.this.jFA != null && AlbumImageBrowseFragment.this.jFO != null) {
                if (AlbumImageBrowseFragment.this.jFA.cxc()) {
                    AlbumImageBrowseFragment.this.jFO.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jFS.Cm(AlbumImageBrowseFragment.this.boZ)) {
                    ImageFileInfo wQ = AlbumImageBrowseFragment.this.jFS.wQ(AlbumImageBrowseFragment.this.boZ);
                    if (AlbumImageBrowseFragment.this.jFA.isAdded(wQ)) {
                        if (AlbumImageBrowseFragment.this.jFO.f(wQ)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jFT, false);
                            AlbumImageBrowseFragment.this.jFO.f(wQ, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jFO.e(wQ)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jFT, true);
                        AlbumImageBrowseFragment.this.jFO.f(wQ, true);
                    }
                    AlbumImageBrowseFragment.this.cwX();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.boZ = i;
            if (AlbumImageBrowseFragment.this.jFS != null && AlbumImageBrowseFragment.this.jFA != null) {
                ImageFileInfo wQ = AlbumImageBrowseFragment.this.jFS.wQ(AlbumImageBrowseFragment.this.boZ);
                if (AlbumImageBrowseFragment.this.jFA.isAdded(wQ)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jFT, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jFT, false);
                }
                if (AlbumImageBrowseFragment.this.jFA != null && AlbumImageBrowseFragment.this.jFA.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jFA.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.jFW.setVisibility(8);
                } else if (wQ == null || !wQ.isGif()) {
                    AlbumImageBrowseFragment.this.jFW.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.jFW.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.rO(AlbumImageBrowseFragment.this.jFA.isOriginalImg());
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
        this.jFO = (AlbumActivity) getBaseFragmentActivity();
        this.jFA = this.jFO.cwN();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bBg = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.bBg.findViewById(R.id.img_back);
        this.jFT = (ImageView) this.bBg.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.bBg.findViewById(R.id.viewPager);
        this.mNoDataView = this.bBg.findViewById(R.id.album_no_data);
        this.jFV = (TextView) this.bBg.findViewById(R.id.btn_next_step);
        this.jFW = (TextView) this.bBg.findViewById(R.id.original_select_btn);
        this.jFU = this.bBg.findViewById(R.id.layout_bottom);
        this.mBackBtn.setOnClickListener(this.jFO);
        this.jFV.setOnClickListener(this.jFO);
        this.jFT.setOnClickListener(this.mOnClickListener);
        this.jFW.setOnClickListener(this.jFO);
        this.jFU.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jFA != null && this.jFA.getWriteImagesInfo() != null) {
            this.jFW.setVisibility(this.jFA.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.bBg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwX() {
        this.jFO.cwL();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aHI();
        }
    }

    private void cwY() {
        List<ImageFileInfo> cxg;
        int currentIndex;
        boolean z = true;
        if (this.jFA == null && this.jFO != null) {
            this.jFA = this.jFO.cwN();
        }
        if (this.jFA != null && (cxg = this.jFA.cxg()) != null && (currentIndex = this.jFA.getCurrentIndex()) >= 0) {
            this.boZ = currentIndex;
            this.jFS = new AlbumImagePagerAdapter(this.jFO);
            this.mViewPager.setAdapter(this.jFS);
            if (this.boZ == 0 && cxg != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(cxg, this.boZ);
                if (this.jFA.isAdded(imageFileInfo)) {
                    c(this.jFT, true);
                } else {
                    c(this.jFT, false);
                }
                if (this.jFA != null && this.jFA.getWriteImagesInfo() != null) {
                    z = this.jFA.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.jFW.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.jFW.setVisibility(8);
                } else {
                    this.jFW.setVisibility(0);
                }
            }
            this.jFS.setData(cxg);
            this.mViewPager.setCurrentItem(this.boZ, false);
            rO(this.jFA.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.jFS != null) {
            this.jFS.setData(null);
        }
    }

    public View chU() {
        return this.mBackBtn;
    }

    public View cwZ() {
        return this.jFV;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.bBg);
        al.a(this.mBackBtn, (int) R.drawable.icon_return_bg_s, (int) R.drawable.icon_return_bg, i);
        if (this.jFA != null) {
            rO(this.jFA.isOriginalImg());
        }
        if (this.jFS != null) {
            this.jFS.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.jFO != null) {
            al.c(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.jFV != null) {
                int Z = this.jFA != null ? v.Z(this.jFA.cxe()) : 0;
                this.jFV.setText(this.jFO.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(Z), Integer.valueOf(this.jFA != null ? this.jFA.getMaxImagesAllowed() : 1)}));
                this.jFV.setEnabled(Z > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo wQ;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jFS != null && (wQ = this.jFS.wQ(this.boZ)) != null && wQ.getFilePath() != null && wQ.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.jFT, z);
        }
    }

    private void aHI() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            cwY();
        }
    }

    public View cwV() {
        return this.jFW;
    }

    public void rO(boolean z) {
        long j;
        if (this.jFO != null && this.jFW != null) {
            if (this.jFS != null) {
                ImageFileInfo wQ = this.jFS.wQ(this.boZ);
                j = wQ != null ? m.jn(wQ.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.jFO.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ap.aT(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.j(this.jFW, R.color.cp_link_tip_a);
                this.jFW.setText(sb2);
                this.jFW.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.j(this.jFW, R.color.cp_cont_f);
            this.jFW.setText(string);
            this.jFW.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
