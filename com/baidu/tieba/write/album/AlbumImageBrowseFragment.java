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
    private c jNO;
    private AlbumActivity jOc;
    private AlbumImagePagerAdapter jOg;
    private ImageView jOh;
    private View jOi;
    private TextView jOj;
    private TextView jOk;
    private ImageView mBackBtn;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int bpM = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.jOi && view == AlbumImageBrowseFragment.this.jOh && AlbumImageBrowseFragment.this.jOg != null && AlbumImageBrowseFragment.this.jNO != null && AlbumImageBrowseFragment.this.jOc != null) {
                if (AlbumImageBrowseFragment.this.jNO.cAz()) {
                    AlbumImageBrowseFragment.this.jOc.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.jOg.CV(AlbumImageBrowseFragment.this.bpM)) {
                    ImageFileInfo xv = AlbumImageBrowseFragment.this.jOg.xv(AlbumImageBrowseFragment.this.bpM);
                    if (AlbumImageBrowseFragment.this.jNO.isAdded(xv)) {
                        if (AlbumImageBrowseFragment.this.jOc.f(xv)) {
                            AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jOh, false);
                            AlbumImageBrowseFragment.this.jOc.f(xv, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.jOc.e(xv)) {
                        AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jOh, true);
                        AlbumImageBrowseFragment.this.jOc.f(xv, true);
                    }
                    AlbumImageBrowseFragment.this.cAu();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.bpM = i;
            if (AlbumImageBrowseFragment.this.jOg != null && AlbumImageBrowseFragment.this.jNO != null) {
                ImageFileInfo xv = AlbumImageBrowseFragment.this.jOg.xv(AlbumImageBrowseFragment.this.bpM);
                if (AlbumImageBrowseFragment.this.jNO.isAdded(xv)) {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jOh, true);
                } else {
                    AlbumImageBrowseFragment.this.c(AlbumImageBrowseFragment.this.jOh, false);
                }
                if (AlbumImageBrowseFragment.this.jNO != null && AlbumImageBrowseFragment.this.jNO.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.jNO.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.jOk.setVisibility(8);
                } else if (xv == null || !xv.isGif()) {
                    AlbumImageBrowseFragment.this.jOk.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.jOk.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.sf(AlbumImageBrowseFragment.this.jNO.isOriginalImg());
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
        this.jOc = (AlbumActivity) getBaseFragmentActivity();
        this.jNO = this.jOc.cAk();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.jOh = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.jOj = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.jOk = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.jOi = this.mRoot.findViewById(R.id.layout_bottom);
        this.mBackBtn.setOnClickListener(this.jOc);
        this.jOj.setOnClickListener(this.jOc);
        this.jOh.setOnClickListener(this.mOnClickListener);
        this.jOk.setOnClickListener(this.jOc);
        this.jOi.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jNO != null && this.jNO.getWriteImagesInfo() != null) {
            this.jOk.setVisibility(this.jNO.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAu() {
        this.jOc.cAi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aJk();
        }
    }

    private void cAv() {
        List<ImageFileInfo> cAD;
        int currentIndex;
        boolean z = true;
        if (this.jNO == null && this.jOc != null) {
            this.jNO = this.jOc.cAk();
        }
        if (this.jNO != null && (cAD = this.jNO.cAD()) != null && (currentIndex = this.jNO.getCurrentIndex()) >= 0) {
            this.bpM = currentIndex;
            this.jOg = new AlbumImagePagerAdapter(this.jOc);
            this.mViewPager.setAdapter(this.jOg);
            if (this.bpM == 0 && cAD != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(cAD, this.bpM);
                if (this.jNO.isAdded(imageFileInfo)) {
                    c(this.jOh, true);
                } else {
                    c(this.jOh, false);
                }
                if (this.jNO != null && this.jNO.getWriteImagesInfo() != null) {
                    z = this.jNO.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.jOk.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.jOk.setVisibility(8);
                } else {
                    this.jOk.setVisibility(0);
                }
            }
            this.jOg.setData(cAD);
            this.mViewPager.setCurrentItem(this.bpM, false);
            sf(this.jNO.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.jOg != null) {
            this.jOg.setData(null);
        }
    }

    public View clg() {
        return this.mBackBtn;
    }

    public View cAw() {
        return this.jOj;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mRoot);
        am.a(this.mBackBtn, (int) R.drawable.icon_return_bg_s, (int) R.drawable.icon_return_bg, i);
        if (this.jNO != null) {
            sf(this.jNO.isOriginalImg());
        }
        if (this.jOg != null) {
            this.jOg.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.jOc != null) {
            am.c(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.jOj != null) {
                int Z = this.jNO != null ? v.Z(this.jNO.cAB()) : 0;
                this.jOj.setText(this.jOc.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(Z), Integer.valueOf(this.jNO != null ? this.jNO.getMaxImagesAllowed() : 1)}));
                this.jOj.setEnabled(Z > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo xv;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.jOg != null && (xv = this.jOg.xv(this.bpM)) != null && xv.getFilePath() != null && xv.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.jOh, z);
        }
    }

    private void aJk() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            cAv();
        }
    }

    public View cAs() {
        return this.jOk;
    }

    public void sf(boolean z) {
        long j;
        if (this.jOc != null && this.jOk != null) {
            if (this.jOg != null) {
                ImageFileInfo xv = this.jOg.xv(this.bpM);
                j = xv != null ? m.ju(xv.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.jOc.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.aU(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.j(this.jOk, R.color.cp_link_tip_a);
                this.jOk.setText(sb2);
                this.jOk.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.j(this.jOk, R.color.cp_cont_f);
            this.jOk.setText(string);
            this.jOk.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
