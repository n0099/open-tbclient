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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView aFn;
    private ImageView bvK;
    private View bvL;
    private TextView bvN;
    private BaseFragmentActivity hSW;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private e nmM;
    private c nmQ;
    private AlbumImagePagerAdapter nmR;
    private TBSpecificationBtn nmS;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bvL && view == AlbumImageBrowseFragment.this.bvK && AlbumImageBrowseFragment.this.nmR != null && AlbumImageBrowseFragment.this.nmQ != null && AlbumImageBrowseFragment.this.hSW != null) {
                if (AlbumImageBrowseFragment.this.nmQ.Qt()) {
                    AlbumImageBrowseFragment.this.hSW.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.nmR.fJ(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo EK = AlbumImageBrowseFragment.this.nmR.EK(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.nmQ.isAdded(EK)) {
                        if (AlbumImageBrowseFragment.this.nmM.f(EK)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bvK, false);
                            AlbumImageBrowseFragment.this.nmM.g(EK, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.nmM.g(EK)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bvK, true);
                        AlbumImageBrowseFragment.this.nmM.g(EK, true);
                    }
                    AlbumImageBrowseFragment.this.Qg();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.nmR != null && AlbumImageBrowseFragment.this.nmQ != null) {
                ImageFileInfo EK = AlbumImageBrowseFragment.this.nmR.EK(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.nmQ.isAdded(EK)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bvK, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bvK, false);
                }
                if (AlbumImageBrowseFragment.this.nmQ != null && AlbumImageBrowseFragment.this.nmQ.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.nmQ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.bvN.setVisibility(8);
                } else if (EK == null || !EK.isGif()) {
                    AlbumImageBrowseFragment.this.bvN.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bvN.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cD(AlbumImageBrowseFragment.this.nmQ.isOriginalImg());
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
        this.hSW = getBaseFragmentActivity();
        if (this.nmM == null) {
            if (this.hSW instanceof AlbumFloatActivity) {
                this.nmM = ((AlbumFloatActivity) this.hSW).nmM;
            } else if (this.hSW instanceof AlbumActivity) {
                this.nmM = ((AlbumActivity) this.hSW).nmM;
            }
        }
        if (this.nmM != null) {
            this.nmQ = this.nmM.dNP();
        }
    }

    public void a(e eVar) {
        this.nmM = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.hSW = getBaseFragmentActivity();
        if (this.nmM == null) {
            if (this.hSW instanceof AlbumFloatActivity) {
                this.nmM = ((AlbumFloatActivity) this.hSW).nmM;
            } else if (this.hSW instanceof AlbumActivity) {
                this.nmM = ((AlbumActivity) this.hSW).nmM;
            }
        }
        if (this.nmM != null) {
            this.nmQ = this.nmM.dNP();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aFn = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bvK = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.bvN = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bvL = this.mRoot.findViewById(R.id.layout_bottom);
        this.nmS = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.nmS.setTextSize(R.dimen.tbds34);
        this.nmS.getStyleConfig().pK(l.getDimens(this.hSW, R.dimen.tbds25));
        this.aFn.setOnClickListener(this.hSW);
        this.nmS.setOnClickListener(this.hSW);
        this.bvK.setOnClickListener(this.mOnClickListener);
        this.bvN.setOnClickListener(this.hSW);
        this.bvL.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.nmQ != null && this.nmQ.getWriteImagesInfo() != null) {
            this.bvN.setVisibility(this.nmQ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qg() {
        this.nmM.Qa();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Qi();
        }
    }

    private void Qh() {
        List<ImageFileInfo> Qy;
        int currentIndex;
        boolean z = true;
        if (this.nmQ == null && this.nmM != null) {
            this.nmQ = this.nmM.dNP();
        }
        if (this.nmQ != null && (Qy = this.nmQ.Qy()) != null && (currentIndex = this.nmQ.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.nmR = new AlbumImagePagerAdapter(this.hSW);
            this.mViewPager.setAdapter(this.nmR);
            if (this.mCurrentIndex == 0 && Qy != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(Qy, this.mCurrentIndex);
                if (this.nmQ.isAdded(imageFileInfo)) {
                    a(this.bvK, true);
                } else {
                    a(this.bvK, false);
                }
                if (this.nmQ != null && this.nmQ.getWriteImagesInfo() != null) {
                    z = this.nmQ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.bvN.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.bvN.setVisibility(8);
                } else {
                    this.bvN.setVisibility(0);
                }
            }
            this.nmR.setData(Qy);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cD(this.nmQ.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.nmR != null) {
            this.nmR.setData(null);
        }
    }

    public View QB() {
        return this.aFn;
    }

    public View QC() {
        return this.nmS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ap.setNavbarIconSrc(this.aFn, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.nmQ != null) {
            cD(this.nmQ.isOriginalImg());
        }
        if (this.nmR != null) {
            this.nmR.notifyDataSetChanged();
        }
        this.nmS.bok();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.hSW != null) {
            ap.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.nmS != null) {
                int count = this.nmQ != null ? y.getCount(this.nmQ.Qv()) : 0;
                this.nmS.setText(this.hSW.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nmQ != null ? this.nmQ.getMaxImagesAllowed() : 1)}));
                this.nmS.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo EK;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.nmR != null && (EK = this.nmR.EK(this.mCurrentIndex)) != null && EK.getFilePath() != null && EK.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bvK, z);
        }
    }

    private void Qi() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Qh();
        }
    }

    public View Qo() {
        return this.bvN;
    }

    public void cD(boolean z) {
        long j;
        if (this.hSW != null && this.bvN != null) {
            if (this.nmR != null) {
                ImageFileInfo EK = this.nmR.EK(this.mCurrentIndex);
                j = EK != null ? n.getFileSize(EK.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hSW.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(at.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ap.setViewTextColor(this.bvN, R.color.cp_link_tip_a);
                this.bvN.setText(sb2);
                this.bvN.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.bvN, R.color.cp_cont_f);
            this.bvN.setText(string);
            this.bvN.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
