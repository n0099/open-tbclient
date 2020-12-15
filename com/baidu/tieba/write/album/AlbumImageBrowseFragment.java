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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView aHg;
    private ImageView bHG;
    private View bHH;
    private TextView bHJ;
    private BaseFragmentActivity ixe;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private e nUQ;
    private c nUU;
    private AlbumImagePagerAdapter nUV;
    private TBSpecificationBtn nUW;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bHH && view == AlbumImageBrowseFragment.this.bHG && AlbumImageBrowseFragment.this.nUV != null && AlbumImageBrowseFragment.this.nUU != null && AlbumImageBrowseFragment.this.ixe != null) {
                if (AlbumImageBrowseFragment.this.nUU.VN()) {
                    AlbumImageBrowseFragment.this.ixe.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.nUV.gt(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo GD = AlbumImageBrowseFragment.this.nUV.GD(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (com.baidu.tieba.write.c.b.l(GD)) {
                        AlbumImageBrowseFragment.this.ixe.showToast(R.string.album_choose_image_low_quality_tip);
                        return;
                    }
                    if (AlbumImageBrowseFragment.this.nUU.isAdded(GD)) {
                        if (AlbumImageBrowseFragment.this.nUQ.f(GD)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHG, false);
                            AlbumImageBrowseFragment.this.nUQ.g(GD, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.nUQ.g(GD)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHG, true);
                        AlbumImageBrowseFragment.this.nUQ.g(GD, true);
                    }
                    AlbumImageBrowseFragment.this.VA();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.nUV != null && AlbumImageBrowseFragment.this.nUU != null) {
                ImageFileInfo GD = AlbumImageBrowseFragment.this.nUV.GD(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.nUU.isAdded(GD)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHG, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHG, false);
                }
                if (AlbumImageBrowseFragment.this.nUU != null && AlbumImageBrowseFragment.this.nUU.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.nUU.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.bHJ.setVisibility(8);
                } else if (GD == null || !GD.isGif()) {
                    AlbumImageBrowseFragment.this.bHJ.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bHJ.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.dg(AlbumImageBrowseFragment.this.nUU.isOriginalImg());
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
        this.ixe = getBaseFragmentActivity();
        if (this.nUQ == null) {
            if (this.ixe instanceof AlbumFloatActivity) {
                this.nUQ = ((AlbumFloatActivity) this.ixe).nUQ;
            } else if (this.ixe instanceof AlbumActivity) {
                this.nUQ = ((AlbumActivity) this.ixe).nUQ;
            }
        }
        if (this.nUQ != null) {
            this.nUU = this.nUQ.dYR();
        }
    }

    public void a(e eVar) {
        this.nUQ = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ixe = getBaseFragmentActivity();
        if (this.nUQ == null) {
            if (this.ixe instanceof AlbumFloatActivity) {
                this.nUQ = ((AlbumFloatActivity) this.ixe).nUQ;
            } else if (this.ixe instanceof AlbumActivity) {
                this.nUQ = ((AlbumActivity) this.ixe).nUQ;
            }
        }
        if (this.nUQ != null) {
            this.nUU = this.nUQ.dYR();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aHg = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bHG = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.bHJ = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bHH = this.mRoot.findViewById(R.id.layout_bottom);
        this.nUW = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.nUW.setTextSize(R.dimen.tbds34);
        this.nUW.getStyleConfig().re(l.getDimens(this.ixe, R.dimen.tbds25));
        this.aHg.setOnClickListener(this.ixe);
        this.nUW.setOnClickListener(this.ixe);
        this.bHG.setOnClickListener(this.mOnClickListener);
        this.bHJ.setOnClickListener(this.ixe);
        this.bHH.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.nUU != null && this.nUU.getWriteImagesInfo() != null) {
            this.bHJ.setVisibility(this.nUU.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VA() {
        this.nUQ.Vu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            VC();
        }
    }

    private void VB() {
        List<ImageFileInfo> VS;
        int currentIndex;
        boolean z = true;
        if (this.nUU == null && this.nUQ != null) {
            this.nUU = this.nUQ.dYR();
        }
        if (this.nUU != null && (VS = this.nUU.VS()) != null && (currentIndex = this.nUU.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.nUV = new AlbumImagePagerAdapter(this.ixe);
            this.mViewPager.setAdapter(this.nUV);
            if (this.mCurrentIndex == 0 && VS != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(VS, this.mCurrentIndex);
                if (this.nUU.isAdded(imageFileInfo)) {
                    a(this.bHG, true);
                } else {
                    a(this.bHG, false);
                }
                if (this.nUU != null && this.nUU.getWriteImagesInfo() != null) {
                    z = this.nUU.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.bHJ.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.bHJ.setVisibility(8);
                } else {
                    this.bHJ.setVisibility(0);
                }
            }
            this.nUV.setData(VS);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            dg(this.nUU.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.nUV != null) {
            this.nUV.setData(null);
        }
    }

    public View VV() {
        return this.aHg;
    }

    public View VW() {
        return this.nUW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ap.setNavbarIconSrc(this.aHg, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.nUU != null) {
            dg(this.nUU.isOriginalImg());
        }
        if (this.nUV != null) {
            this.nUV.notifyDataSetChanged();
        }
        this.nUW.bvt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.ixe != null) {
            if (z) {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324_select, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            if (this.nUW != null) {
                int count = this.nUU != null ? y.getCount(this.nUU.VP()) : 0;
                this.nUW.setText(this.ixe.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nUU != null ? this.nUU.getMaxImagesAllowed() : 1)}));
                this.nUW.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo GD;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.nUV != null && (GD = this.nUV.GD(this.mCurrentIndex)) != null && GD.getFilePath() != null && GD.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bHG, z);
        }
    }

    private void VC() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            VB();
        }
    }

    public View VI() {
        return this.bHJ;
    }

    public void dg(boolean z) {
        long j;
        if (this.ixe != null && this.bHJ != null) {
            if (this.nUV != null) {
                ImageFileInfo GD = this.nUV.GD(this.mCurrentIndex);
                j = GD != null ? n.getFileSize(GD.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.ixe.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(au.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ap.setViewTextColor(this.bHJ, R.color.CAM_X0302);
                this.bHJ.setText(sb2);
                this.bHJ.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_select16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.bHJ, R.color.CAM_X0106);
            this.bHJ.setText(string);
            this.bHJ.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_selection16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
