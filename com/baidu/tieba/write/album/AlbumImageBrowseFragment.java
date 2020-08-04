package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView awy;
    private ImageView bjf;
    private View bjg;
    private TextView bji;
    private BaseFragmentActivity hjZ;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private e muL;
    private c muP;
    private AlbumImagePagerAdapter muQ;
    private TBSpecificationBtn muR;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bjg && view == AlbumImageBrowseFragment.this.bjf && AlbumImageBrowseFragment.this.muQ != null && AlbumImageBrowseFragment.this.muP != null && AlbumImageBrowseFragment.this.hjZ != null) {
                if (AlbumImageBrowseFragment.this.muP.IS()) {
                    AlbumImageBrowseFragment.this.hjZ.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.muQ.dw(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo Bk = AlbumImageBrowseFragment.this.muQ.Bk(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.muP.isAdded(Bk)) {
                        if (AlbumImageBrowseFragment.this.muL.f(Bk)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bjf, false);
                            AlbumImageBrowseFragment.this.muL.g(Bk, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.muL.g(Bk)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bjf, true);
                        AlbumImageBrowseFragment.this.muL.g(Bk, true);
                    }
                    AlbumImageBrowseFragment.this.IF();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.muQ != null && AlbumImageBrowseFragment.this.muP != null) {
                ImageFileInfo Bk = AlbumImageBrowseFragment.this.muQ.Bk(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.muP.isAdded(Bk)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bjf, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bjf, false);
                }
                if (AlbumImageBrowseFragment.this.muP != null && AlbumImageBrowseFragment.this.muP.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.muP.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.bji.setVisibility(8);
                } else if (Bk == null || !Bk.isGif()) {
                    AlbumImageBrowseFragment.this.bji.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bji.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cp(AlbumImageBrowseFragment.this.muP.isOriginalImg());
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
        this.hjZ = getBaseFragmentActivity();
        this.muP = this.muL.duE();
    }

    public void a(e eVar) {
        this.muL = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.awy = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bjf = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.bji = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bjg = this.mRoot.findViewById(R.id.layout_bottom);
        this.muR = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.muR.setTextSize(R.dimen.tbds34);
        this.muR.getStyleConfig().mT(l.getDimens(this.hjZ, R.dimen.tbds25));
        this.awy.setOnClickListener(this.hjZ);
        this.muR.setOnClickListener(this.hjZ);
        this.bjf.setOnClickListener(this.mOnClickListener);
        this.bji.setOnClickListener(this.hjZ);
        this.bjg.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.muP != null && this.muP.getWriteImagesInfo() != null) {
            this.bji.setVisibility(this.muP.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IF() {
        this.muL.Iz();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            IH();
        }
    }

    private void IG() {
        List<ImageFileInfo> IX;
        int currentIndex;
        boolean z = true;
        if (this.muP == null && this.muL != null) {
            this.muP = this.muL.duE();
        }
        if (this.muP != null && (IX = this.muP.IX()) != null && (currentIndex = this.muP.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.muQ = new AlbumImagePagerAdapter(this.hjZ);
            this.mViewPager.setAdapter(this.muQ);
            if (this.mCurrentIndex == 0 && IX != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) x.getItem(IX, this.mCurrentIndex);
                if (this.muP.isAdded(imageFileInfo)) {
                    a(this.bjf, true);
                } else {
                    a(this.bjf, false);
                }
                if (this.muP != null && this.muP.getWriteImagesInfo() != null) {
                    z = this.muP.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.bji.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.bji.setVisibility(8);
                } else {
                    this.bji.setVisibility(0);
                }
            }
            this.muQ.setData(IX);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cp(this.muP.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.muQ != null) {
            this.muQ.setData(null);
        }
    }

    public View Jb() {
        return this.awy;
    }

    public View Jc() {
        return this.muR;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ao.setNavbarIconSrc(this.awy, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.muP != null) {
            cp(this.muP.isOriginalImg());
        }
        if (this.muQ != null) {
            this.muQ.notifyDataSetChanged();
        }
        this.muR.bci();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.hjZ != null) {
            ao.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.muR != null) {
                int count = this.muP != null ? x.getCount(this.muP.IU()) : 0;
                this.muR.setText(this.hjZ.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.muP != null ? this.muP.getMaxImagesAllowed() : 1)}));
                this.muR.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo Bk;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.muQ != null && (Bk = this.muQ.Bk(this.mCurrentIndex)) != null && Bk.getFilePath() != null && Bk.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bjf, z);
        }
    }

    private void IH() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            IG();
        }
    }

    public View IN() {
        return this.bji;
    }

    public void cp(boolean z) {
        long j;
        if (this.hjZ != null && this.bji != null) {
            if (this.muQ != null) {
                ImageFileInfo Bk = this.muQ.Bk(this.mCurrentIndex);
                j = Bk != null ? n.getFileSize(Bk.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hjZ.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(as.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ao.setViewTextColor(this.bji, R.color.cp_link_tip_a);
                this.bji.setText(sb2);
                this.bji.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ao.setViewTextColor(this.bji, R.color.cp_cont_f);
            this.bji.setText(string);
            this.bji.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
