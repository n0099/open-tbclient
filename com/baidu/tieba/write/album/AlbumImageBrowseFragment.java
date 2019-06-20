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
    private c jFE;
    private AlbumActivity jFS;
    private AlbumImagePagerAdapter jFW;
    private ImageView jFX;
    private View jFY;
    private TextView jFZ;
    private TextView jGa;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int boZ = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.jFY && view == AlbumImageBrowseFragment.this.jFX && AlbumImageBrowseFragment.this.jFW != null && AlbumImageBrowseFragment.this.jFE != null && AlbumImageBrowseFragment.this.jFS != null) {
                if (AlbumImageBrowseFragment.this.jFE.cxd()) {
                    AlbumImageBrowseFragment.this.jFS.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jFW.Cm(AlbumImageBrowseFragment.this.boZ)) {
                    ImageFileInfo wQ = AlbumImageBrowseFragment.this.jFW.wQ(AlbumImageBrowseFragment.this.boZ);
                    if (AlbumImageBrowseFragment.this.jFE.isAdded(wQ)) {
                        if (AlbumImageBrowseFragment.this.jFS.f(wQ)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jFX, false);
                            AlbumImageBrowseFragment.this.jFS.f(wQ, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jFS.e(wQ)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jFX, true);
                        AlbumImageBrowseFragment.this.jFS.f(wQ, true);
                    }
                    AlbumImageBrowseFragment.this.cwY();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.boZ = i;
            if (AlbumImageBrowseFragment.this.jFW != null && AlbumImageBrowseFragment.this.jFE != null) {
                ImageFileInfo wQ = AlbumImageBrowseFragment.this.jFW.wQ(AlbumImageBrowseFragment.this.boZ);
                if (AlbumImageBrowseFragment.this.jFE.isAdded(wQ)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jFX, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jFX, false);
                }
                if (AlbumImageBrowseFragment.this.jFE != null && AlbumImageBrowseFragment.this.jFE.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jFE.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.jGa.setVisibility(8);
                } else if (wQ == null || !wQ.isGif()) {
                    AlbumImageBrowseFragment.this.jGa.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.jGa.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.rP(AlbumImageBrowseFragment.this.jFE.isOriginalImg());
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
        this.jFS = (AlbumActivity) getBaseFragmentActivity();
        this.jFE = this.jFS.cwO();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bBg = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.bBg.findViewById(R.id.img_back);
        this.jFX = (ImageView) this.bBg.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.bBg.findViewById(R.id.viewPager);
        this.mNoDataView = this.bBg.findViewById(R.id.album_no_data);
        this.jFZ = (TextView) this.bBg.findViewById(R.id.btn_next_step);
        this.jGa = (TextView) this.bBg.findViewById(R.id.original_select_btn);
        this.jFY = this.bBg.findViewById(R.id.layout_bottom);
        this.mBackBtn.setOnClickListener(this.jFS);
        this.jFZ.setOnClickListener(this.jFS);
        this.jFX.setOnClickListener(this.mOnClickListener);
        this.jGa.setOnClickListener(this.jFS);
        this.jFY.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jFE != null && this.jFE.getWriteImagesInfo() != null) {
            this.jGa.setVisibility(this.jFE.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.bBg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwY() {
        this.jFS.cwM();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aHL();
        }
    }

    private void cwZ() {
        List<ImageFileInfo> cxh;
        int currentIndex;
        boolean z = true;
        if (this.jFE == null && this.jFS != null) {
            this.jFE = this.jFS.cwO();
        }
        if (this.jFE != null && (cxh = this.jFE.cxh()) != null && (currentIndex = this.jFE.getCurrentIndex()) >= 0) {
            this.boZ = currentIndex;
            this.jFW = new AlbumImagePagerAdapter(this.jFS);
            this.mViewPager.setAdapter(this.jFW);
            if (this.boZ == 0 && cxh != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(cxh, this.boZ);
                if (this.jFE.isAdded(imageFileInfo)) {
                    c(this.jFX, true);
                } else {
                    c(this.jFX, false);
                }
                if (this.jFE != null && this.jFE.getWriteImagesInfo() != null) {
                    z = this.jFE.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.jGa.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.jGa.setVisibility(8);
                } else {
                    this.jGa.setVisibility(0);
                }
            }
            this.jFW.setData(cxh);
            this.mViewPager.setCurrentItem(this.boZ, false);
            rP(this.jFE.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.jFW != null) {
            this.jFW.setData(null);
        }
    }

    public View chX() {
        return this.mBackBtn;
    }

    public View cxa() {
        return this.jFZ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.bBg);
        al.a(this.mBackBtn, (int) R.drawable.icon_return_bg_s, (int) R.drawable.icon_return_bg, i);
        if (this.jFE != null) {
            rP(this.jFE.isOriginalImg());
        }
        if (this.jFW != null) {
            this.jFW.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.jFS != null) {
            al.c(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.jFZ != null) {
                int Z = this.jFE != null ? v.Z(this.jFE.cxf()) : 0;
                this.jFZ.setText(this.jFS.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(Z), Integer.valueOf(this.jFE != null ? this.jFE.getMaxImagesAllowed() : 1)}));
                this.jFZ.setEnabled(Z > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo wQ;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jFW != null && (wQ = this.jFW.wQ(this.boZ)) != null && wQ.getFilePath() != null && wQ.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.jFX, z);
        }
    }

    private void aHL() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            cwZ();
        }
    }

    public View cwW() {
        return this.jGa;
    }

    public void rP(boolean z) {
        long j;
        if (this.jFS != null && this.jGa != null) {
            if (this.jFW != null) {
                ImageFileInfo wQ = this.jFW.wQ(this.boZ);
                j = wQ != null ? m.jm(wQ.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.jFS.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ap.aT(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                al.j(this.jGa, R.color.cp_link_tip_a);
                this.jGa.setText(sb2);
                this.jGa.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            al.j(this.jGa, R.color.cp_cont_f);
            this.jGa.setText(string);
            this.jGa.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
