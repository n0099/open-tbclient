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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private AlbumImagePagerAdapter jQB;
    private ImageView jQC;
    private View jQD;
    private TextView jQE;
    private TextView jQF;
    private c jQj;
    private AlbumActivity jQx;
    private ImageView mBackBtn;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int bqk = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.jQD && view == AlbumImageBrowseFragment.this.jQC && AlbumImageBrowseFragment.this.jQB != null && AlbumImageBrowseFragment.this.jQj != null && AlbumImageBrowseFragment.this.jQx != null) {
                if (AlbumImageBrowseFragment.this.jQj.cBn()) {
                    AlbumImageBrowseFragment.this.jQx.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jQB.CZ(AlbumImageBrowseFragment.this.bqk)) {
                    ImageFileInfo xy = AlbumImageBrowseFragment.this.jQB.xy(AlbumImageBrowseFragment.this.bqk);
                    if (AlbumImageBrowseFragment.this.jQj.isAdded(xy)) {
                        if (AlbumImageBrowseFragment.this.jQx.f(xy)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jQC, false);
                            AlbumImageBrowseFragment.this.jQx.f(xy, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jQx.e(xy)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jQC, true);
                        AlbumImageBrowseFragment.this.jQx.f(xy, true);
                    }
                    AlbumImageBrowseFragment.this.cBi();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.bqk = i;
            if (AlbumImageBrowseFragment.this.jQB != null && AlbumImageBrowseFragment.this.jQj != null) {
                ImageFileInfo xy = AlbumImageBrowseFragment.this.jQB.xy(AlbumImageBrowseFragment.this.bqk);
                if (AlbumImageBrowseFragment.this.jQj.isAdded(xy)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jQC, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jQC, false);
                }
                if (AlbumImageBrowseFragment.this.jQj != null && AlbumImageBrowseFragment.this.jQj.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jQj.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.jQF.setVisibility(8);
                } else if (xy == null || !xy.isGif()) {
                    AlbumImageBrowseFragment.this.jQF.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.jQF.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.si(AlbumImageBrowseFragment.this.jQj.isOriginalImg());
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
        this.jQx = (AlbumActivity) getBaseFragmentActivity();
        this.jQj = this.jQx.cAY();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.jQC = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.jQE = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.jQF = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.jQD = this.mRoot.findViewById(R.id.layout_bottom);
        this.mBackBtn.setOnClickListener(this.jQx);
        this.jQE.setOnClickListener(this.jQx);
        this.jQC.setOnClickListener(this.mOnClickListener);
        this.jQF.setOnClickListener(this.jQx);
        this.jQD.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jQj != null && this.jQj.getWriteImagesInfo() != null) {
            this.jQF.setVisibility(this.jQj.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBi() {
        this.jQx.cAW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aJO();
        }
    }

    private void cBj() {
        List<ImageFileInfo> cBr;
        int currentIndex;
        boolean z = true;
        if (this.jQj == null && this.jQx != null) {
            this.jQj = this.jQx.cAY();
        }
        if (this.jQj != null && (cBr = this.jQj.cBr()) != null && (currentIndex = this.jQj.getCurrentIndex()) >= 0) {
            this.bqk = currentIndex;
            this.jQB = new AlbumImagePagerAdapter(this.jQx);
            this.mViewPager.setAdapter(this.jQB);
            if (this.bqk == 0 && cBr != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(cBr, this.bqk);
                if (this.jQj.isAdded(imageFileInfo)) {
                    c(this.jQC, true);
                } else {
                    c(this.jQC, false);
                }
                if (this.jQj != null && this.jQj.getWriteImagesInfo() != null) {
                    z = this.jQj.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.jQF.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.jQF.setVisibility(8);
                } else {
                    this.jQF.setVisibility(0);
                }
            }
            this.jQB.setData(cBr);
            this.mViewPager.setCurrentItem(this.bqk, false);
            si(this.jQj.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.jQB != null) {
            this.jQB.setData(null);
        }
    }

    public View clS() {
        return this.mBackBtn;
    }

    public View cBk() {
        return this.jQE;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mRoot);
        am.a(this.mBackBtn, (int) R.drawable.icon_return_bg_s, (int) R.drawable.icon_return_bg, i);
        if (this.jQj != null) {
            si(this.jQj.isOriginalImg());
        }
        if (this.jQB != null) {
            this.jQB.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.jQx != null) {
            am.c(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.jQE != null) {
                int Z = this.jQj != null ? v.Z(this.jQj.cBp()) : 0;
                this.jQE.setText(this.jQx.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(Z), Integer.valueOf(this.jQj != null ? this.jQj.getMaxImagesAllowed() : 1)}));
                this.jQE.setEnabled(Z > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo xy;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jQB != null && (xy = this.jQB.xy(this.bqk)) != null && xy.getFilePath() != null && xy.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.jQC, z);
        }
    }

    private void aJO() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            cBj();
        }
    }

    public View cBg() {
        return this.jQF;
    }

    public void si(boolean z) {
        long j;
        if (this.jQx != null && this.jQF != null) {
            if (this.jQB != null) {
                ImageFileInfo xy = this.jQB.xy(this.bqk);
                j = xy != null ? m.jw(xy.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.jQx.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.aU(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.j(this.jQF, R.color.cp_link_tip_a);
                this.jQF.setText(sb2);
                this.jQF.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.j(this.jQF, R.color.cp_cont_f);
            this.jQF.setText(string);
            this.jQF.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
