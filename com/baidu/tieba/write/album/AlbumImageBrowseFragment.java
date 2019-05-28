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
    private c jFB;
    private AlbumActivity jFP;
    private AlbumImagePagerAdapter jFT;
    private ImageView jFU;
    private View jFV;
    private TextView jFW;
    private TextView jFX;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int boZ = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.jFV && view == AlbumImageBrowseFragment.this.jFU && AlbumImageBrowseFragment.this.jFT != null && AlbumImageBrowseFragment.this.jFB != null && AlbumImageBrowseFragment.this.jFP != null) {
                if (AlbumImageBrowseFragment.this.jFB.cxe()) {
                    AlbumImageBrowseFragment.this.jFP.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jFT.Cm(AlbumImageBrowseFragment.this.boZ)) {
                    ImageFileInfo wQ = AlbumImageBrowseFragment.this.jFT.wQ(AlbumImageBrowseFragment.this.boZ);
                    if (AlbumImageBrowseFragment.this.jFB.isAdded(wQ)) {
                        if (AlbumImageBrowseFragment.this.jFP.f(wQ)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jFU, false);
                            AlbumImageBrowseFragment.this.jFP.f(wQ, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jFP.e(wQ)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jFU, true);
                        AlbumImageBrowseFragment.this.jFP.f(wQ, true);
                    }
                    AlbumImageBrowseFragment.this.cwZ();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.boZ = i;
            if (AlbumImageBrowseFragment.this.jFT != null && AlbumImageBrowseFragment.this.jFB != null) {
                ImageFileInfo wQ = AlbumImageBrowseFragment.this.jFT.wQ(AlbumImageBrowseFragment.this.boZ);
                if (AlbumImageBrowseFragment.this.jFB.isAdded(wQ)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jFU, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jFU, false);
                }
                if (AlbumImageBrowseFragment.this.jFB != null && AlbumImageBrowseFragment.this.jFB.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jFB.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.jFX.setVisibility(8);
                } else if (wQ == null || !wQ.isGif()) {
                    AlbumImageBrowseFragment.this.jFX.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.jFX.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.rO(AlbumImageBrowseFragment.this.jFB.isOriginalImg());
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
        this.jFP = (AlbumActivity) getBaseFragmentActivity();
        this.jFB = this.jFP.cwP();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bBg = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.bBg.findViewById(R.id.img_back);
        this.jFU = (ImageView) this.bBg.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.bBg.findViewById(R.id.viewPager);
        this.mNoDataView = this.bBg.findViewById(R.id.album_no_data);
        this.jFW = (TextView) this.bBg.findViewById(R.id.btn_next_step);
        this.jFX = (TextView) this.bBg.findViewById(R.id.original_select_btn);
        this.jFV = this.bBg.findViewById(R.id.layout_bottom);
        this.mBackBtn.setOnClickListener(this.jFP);
        this.jFW.setOnClickListener(this.jFP);
        this.jFU.setOnClickListener(this.mOnClickListener);
        this.jFX.setOnClickListener(this.jFP);
        this.jFV.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jFB != null && this.jFB.getWriteImagesInfo() != null) {
            this.jFX.setVisibility(this.jFB.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.bBg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwZ() {
        this.jFP.cwN();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aHL();
        }
    }

    private void cxa() {
        List<ImageFileInfo> cxi;
        int currentIndex;
        boolean z = true;
        if (this.jFB == null && this.jFP != null) {
            this.jFB = this.jFP.cwP();
        }
        if (this.jFB != null && (cxi = this.jFB.cxi()) != null && (currentIndex = this.jFB.getCurrentIndex()) >= 0) {
            this.boZ = currentIndex;
            this.jFT = new AlbumImagePagerAdapter(this.jFP);
            this.mViewPager.setAdapter(this.jFT);
            if (this.boZ == 0 && cxi != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(cxi, this.boZ);
                if (this.jFB.isAdded(imageFileInfo)) {
                    c(this.jFU, true);
                } else {
                    c(this.jFU, false);
                }
                if (this.jFB != null && this.jFB.getWriteImagesInfo() != null) {
                    z = this.jFB.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.jFX.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.jFX.setVisibility(8);
                } else {
                    this.jFX.setVisibility(0);
                }
            }
            this.jFT.setData(cxi);
            this.mViewPager.setCurrentItem(this.boZ, false);
            rO(this.jFB.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.jFT != null) {
            this.jFT.setData(null);
        }
    }

    public View chW() {
        return this.mBackBtn;
    }

    public View cxb() {
        return this.jFW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.bBg);
        al.a(this.mBackBtn, (int) R.drawable.icon_return_bg_s, (int) R.drawable.icon_return_bg, i);
        if (this.jFB != null) {
            rO(this.jFB.isOriginalImg());
        }
        if (this.jFT != null) {
            this.jFT.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.jFP != null) {
            al.c(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.jFW != null) {
                int Z = this.jFB != null ? v.Z(this.jFB.cxg()) : 0;
                this.jFW.setText(this.jFP.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(Z), Integer.valueOf(this.jFB != null ? this.jFB.getMaxImagesAllowed() : 1)}));
                this.jFW.setEnabled(Z > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo wQ;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jFT != null && (wQ = this.jFT.wQ(this.boZ)) != null && wQ.getFilePath() != null && wQ.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.jFU, z);
        }
    }

    private void aHL() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            cxa();
        }
    }

    public View cwX() {
        return this.jFX;
    }

    public void rO(boolean z) {
        long j;
        if (this.jFP != null && this.jFX != null) {
            if (this.jFT != null) {
                ImageFileInfo wQ = this.jFT.wQ(this.boZ);
                j = wQ != null ? m.jn(wQ.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.jFP.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ap.aT(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.j(this.jFX, R.color.cp_link_tip_a);
                this.jFX.setText(sb2);
                this.jFX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.j(this.jFX, R.color.cp_cont_f);
            this.jFX.setText(string);
            this.jFX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
