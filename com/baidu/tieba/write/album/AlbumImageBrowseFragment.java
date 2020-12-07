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
    private BaseFragmentActivity ixc;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private e nUO;
    private c nUS;
    private AlbumImagePagerAdapter nUT;
    private TBSpecificationBtn nUU;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bHH && view == AlbumImageBrowseFragment.this.bHG && AlbumImageBrowseFragment.this.nUT != null && AlbumImageBrowseFragment.this.nUS != null && AlbumImageBrowseFragment.this.ixc != null) {
                if (AlbumImageBrowseFragment.this.nUS.VN()) {
                    AlbumImageBrowseFragment.this.ixc.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.nUT.gt(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo GD = AlbumImageBrowseFragment.this.nUT.GD(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (com.baidu.tieba.write.c.b.l(GD)) {
                        AlbumImageBrowseFragment.this.ixc.showToast(R.string.album_choose_image_low_quality_tip);
                        return;
                    }
                    if (AlbumImageBrowseFragment.this.nUS.isAdded(GD)) {
                        if (AlbumImageBrowseFragment.this.nUO.f(GD)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHG, false);
                            AlbumImageBrowseFragment.this.nUO.g(GD, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.nUO.g(GD)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHG, true);
                        AlbumImageBrowseFragment.this.nUO.g(GD, true);
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
            if (AlbumImageBrowseFragment.this.nUT != null && AlbumImageBrowseFragment.this.nUS != null) {
                ImageFileInfo GD = AlbumImageBrowseFragment.this.nUT.GD(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.nUS.isAdded(GD)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHG, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHG, false);
                }
                if (AlbumImageBrowseFragment.this.nUS != null && AlbumImageBrowseFragment.this.nUS.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.nUS.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.bHJ.setVisibility(8);
                } else if (GD == null || !GD.isGif()) {
                    AlbumImageBrowseFragment.this.bHJ.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bHJ.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.dg(AlbumImageBrowseFragment.this.nUS.isOriginalImg());
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
        this.ixc = getBaseFragmentActivity();
        if (this.nUO == null) {
            if (this.ixc instanceof AlbumFloatActivity) {
                this.nUO = ((AlbumFloatActivity) this.ixc).nUO;
            } else if (this.ixc instanceof AlbumActivity) {
                this.nUO = ((AlbumActivity) this.ixc).nUO;
            }
        }
        if (this.nUO != null) {
            this.nUS = this.nUO.dYQ();
        }
    }

    public void a(e eVar) {
        this.nUO = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ixc = getBaseFragmentActivity();
        if (this.nUO == null) {
            if (this.ixc instanceof AlbumFloatActivity) {
                this.nUO = ((AlbumFloatActivity) this.ixc).nUO;
            } else if (this.ixc instanceof AlbumActivity) {
                this.nUO = ((AlbumActivity) this.ixc).nUO;
            }
        }
        if (this.nUO != null) {
            this.nUS = this.nUO.dYQ();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aHg = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bHG = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.bHJ = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bHH = this.mRoot.findViewById(R.id.layout_bottom);
        this.nUU = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.nUU.setTextSize(R.dimen.tbds34);
        this.nUU.getStyleConfig().re(l.getDimens(this.ixc, R.dimen.tbds25));
        this.aHg.setOnClickListener(this.ixc);
        this.nUU.setOnClickListener(this.ixc);
        this.bHG.setOnClickListener(this.mOnClickListener);
        this.bHJ.setOnClickListener(this.ixc);
        this.bHH.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.nUS != null && this.nUS.getWriteImagesInfo() != null) {
            this.bHJ.setVisibility(this.nUS.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VA() {
        this.nUO.Vu();
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
        if (this.nUS == null && this.nUO != null) {
            this.nUS = this.nUO.dYQ();
        }
        if (this.nUS != null && (VS = this.nUS.VS()) != null && (currentIndex = this.nUS.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.nUT = new AlbumImagePagerAdapter(this.ixc);
            this.mViewPager.setAdapter(this.nUT);
            if (this.mCurrentIndex == 0 && VS != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(VS, this.mCurrentIndex);
                if (this.nUS.isAdded(imageFileInfo)) {
                    a(this.bHG, true);
                } else {
                    a(this.bHG, false);
                }
                if (this.nUS != null && this.nUS.getWriteImagesInfo() != null) {
                    z = this.nUS.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.bHJ.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.bHJ.setVisibility(8);
                } else {
                    this.bHJ.setVisibility(0);
                }
            }
            this.nUT.setData(VS);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            dg(this.nUS.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.nUT != null) {
            this.nUT.setData(null);
        }
    }

    public View VV() {
        return this.aHg;
    }

    public View VW() {
        return this.nUU;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ap.setNavbarIconSrc(this.aHg, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.nUS != null) {
            dg(this.nUS.isOriginalImg());
        }
        if (this.nUT != null) {
            this.nUT.notifyDataSetChanged();
        }
        this.nUU.bvt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.ixc != null) {
            if (z) {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324_select, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            if (this.nUU != null) {
                int count = this.nUS != null ? y.getCount(this.nUS.VP()) : 0;
                this.nUU.setText(this.ixc.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nUS != null ? this.nUS.getMaxImagesAllowed() : 1)}));
                this.nUU.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo GD;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.nUT != null && (GD = this.nUT.GD(this.mCurrentIndex)) != null && GD.getFilePath() != null && GD.getFilePath().equals(imageFileInfo.getFilePath())) {
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
        if (this.ixc != null && this.bHJ != null) {
            if (this.nUT != null) {
                ImageFileInfo GD = this.nUT.GD(this.mCurrentIndex);
                j = GD != null ? n.getFileSize(GD.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.ixc.getResources().getString(R.string.original_img);
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
