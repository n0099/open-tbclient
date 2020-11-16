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
    private ImageView aEA;
    private TextView bCB;
    private ImageView bCy;
    private View bCz;
    private BaseFragmentActivity imj;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private e nGI;
    private c nGM;
    private AlbumImagePagerAdapter nGN;
    private TBSpecificationBtn nGO;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bCz && view == AlbumImageBrowseFragment.this.bCy && AlbumImageBrowseFragment.this.nGN != null && AlbumImageBrowseFragment.this.nGM != null && AlbumImageBrowseFragment.this.imj != null) {
                if (AlbumImageBrowseFragment.this.nGM.Tn()) {
                    AlbumImageBrowseFragment.this.imj.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.nGN.fU(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo FO = AlbumImageBrowseFragment.this.nGN.FO(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.nGM.isAdded(FO)) {
                        if (AlbumImageBrowseFragment.this.nGI.f(FO)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bCy, false);
                            AlbumImageBrowseFragment.this.nGI.g(FO, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.nGI.g(FO)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bCy, true);
                        AlbumImageBrowseFragment.this.nGI.g(FO, true);
                    }
                    AlbumImageBrowseFragment.this.Ta();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.nGN != null && AlbumImageBrowseFragment.this.nGM != null) {
                ImageFileInfo FO = AlbumImageBrowseFragment.this.nGN.FO(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.nGM.isAdded(FO)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bCy, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bCy, false);
                }
                if (AlbumImageBrowseFragment.this.nGM != null && AlbumImageBrowseFragment.this.nGM.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.nGM.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.bCB.setVisibility(8);
                } else if (FO == null || !FO.isGif()) {
                    AlbumImageBrowseFragment.this.bCB.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bCB.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cS(AlbumImageBrowseFragment.this.nGM.isOriginalImg());
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
        this.imj = getBaseFragmentActivity();
        if (this.nGI == null) {
            if (this.imj instanceof AlbumFloatActivity) {
                this.nGI = ((AlbumFloatActivity) this.imj).nGI;
            } else if (this.imj instanceof AlbumActivity) {
                this.nGI = ((AlbumActivity) this.imj).nGI;
            }
        }
        if (this.nGI != null) {
            this.nGM = this.nGI.dTw();
        }
    }

    public void a(e eVar) {
        this.nGI = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.imj = getBaseFragmentActivity();
        if (this.nGI == null) {
            if (this.imj instanceof AlbumFloatActivity) {
                this.nGI = ((AlbumFloatActivity) this.imj).nGI;
            } else if (this.imj instanceof AlbumActivity) {
                this.nGI = ((AlbumActivity) this.imj).nGI;
            }
        }
        if (this.nGI != null) {
            this.nGM = this.nGI.dTw();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aEA = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bCy = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.bCB = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bCz = this.mRoot.findViewById(R.id.layout_bottom);
        this.nGO = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.nGO.setTextSize(R.dimen.tbds34);
        this.nGO.getStyleConfig().qD(l.getDimens(this.imj, R.dimen.tbds25));
        this.aEA.setOnClickListener(this.imj);
        this.nGO.setOnClickListener(this.imj);
        this.bCy.setOnClickListener(this.mOnClickListener);
        this.bCB.setOnClickListener(this.imj);
        this.bCz.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.nGM != null && this.nGM.getWriteImagesInfo() != null) {
            this.bCB.setVisibility(this.nGM.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ta() {
        this.nGI.SU();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Tc();
        }
    }

    private void Tb() {
        List<ImageFileInfo> Ts;
        int currentIndex;
        boolean z = true;
        if (this.nGM == null && this.nGI != null) {
            this.nGM = this.nGI.dTw();
        }
        if (this.nGM != null && (Ts = this.nGM.Ts()) != null && (currentIndex = this.nGM.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.nGN = new AlbumImagePagerAdapter(this.imj);
            this.mViewPager.setAdapter(this.nGN);
            if (this.mCurrentIndex == 0 && Ts != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(Ts, this.mCurrentIndex);
                if (this.nGM.isAdded(imageFileInfo)) {
                    a(this.bCy, true);
                } else {
                    a(this.bCy, false);
                }
                if (this.nGM != null && this.nGM.getWriteImagesInfo() != null) {
                    z = this.nGM.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.bCB.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.bCB.setVisibility(8);
                } else {
                    this.bCB.setVisibility(0);
                }
            }
            this.nGN.setData(Ts);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cS(this.nGM.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.nGN != null) {
            this.nGN.setData(null);
        }
    }

    public View Tv() {
        return this.aEA;
    }

    public View Tw() {
        return this.nGO;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ap.setNavbarIconSrc(this.aEA, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.nGM != null) {
            cS(this.nGM.isOriginalImg());
        }
        if (this.nGN != null) {
            this.nGN.notifyDataSetChanged();
        }
        this.nGO.brT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.imj != null) {
            if (z) {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324_select, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            if (this.nGO != null) {
                int count = this.nGM != null ? y.getCount(this.nGM.Tp()) : 0;
                this.nGO.setText(this.imj.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nGM != null ? this.nGM.getMaxImagesAllowed() : 1)}));
                this.nGO.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo FO;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.nGN != null && (FO = this.nGN.FO(this.mCurrentIndex)) != null && FO.getFilePath() != null && FO.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bCy, z);
        }
    }

    private void Tc() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Tb();
        }
    }

    public View Ti() {
        return this.bCB;
    }

    public void cS(boolean z) {
        long j;
        if (this.imj != null && this.bCB != null) {
            if (this.nGN != null) {
                ImageFileInfo FO = this.nGN.FO(this.mCurrentIndex);
                j = FO != null ? n.getFileSize(FO.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.imj.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(au.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ap.setViewTextColor(this.bCB, R.color.CAM_X0302);
                this.bCB.setText(sb2);
                this.bCB.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_select16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.bCB, R.color.CAM_X0106);
            this.bCB.setText(string);
            this.bCB.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_selection16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
