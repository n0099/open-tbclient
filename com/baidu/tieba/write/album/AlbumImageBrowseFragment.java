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
    private ImageView aBA;
    private ImageView boK;
    private View boL;
    private TextView boN;
    private BaseFragmentActivity hwQ;
    private e mMZ;
    private c mNd;
    private AlbumImagePagerAdapter mNe;
    private TBSpecificationBtn mNf;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.boL && view == AlbumImageBrowseFragment.this.boK && AlbumImageBrowseFragment.this.mNe != null && AlbumImageBrowseFragment.this.mNd != null && AlbumImageBrowseFragment.this.hwQ != null) {
                if (AlbumImageBrowseFragment.this.mNd.OL()) {
                    AlbumImageBrowseFragment.this.hwQ.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.mNe.fp(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo DD = AlbumImageBrowseFragment.this.mNe.DD(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.mNd.isAdded(DD)) {
                        if (AlbumImageBrowseFragment.this.mMZ.f(DD)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boK, false);
                            AlbumImageBrowseFragment.this.mMZ.g(DD, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.mMZ.g(DD)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boK, true);
                        AlbumImageBrowseFragment.this.mMZ.g(DD, true);
                    }
                    AlbumImageBrowseFragment.this.Oy();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.mNe != null && AlbumImageBrowseFragment.this.mNd != null) {
                ImageFileInfo DD = AlbumImageBrowseFragment.this.mNe.DD(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.mNd.isAdded(DD)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boK, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boK, false);
                }
                if (AlbumImageBrowseFragment.this.mNd != null && AlbumImageBrowseFragment.this.mNd.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.mNd.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.boN.setVisibility(8);
                } else if (DD == null || !DD.isGif()) {
                    AlbumImageBrowseFragment.this.boN.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.boN.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cy(AlbumImageBrowseFragment.this.mNd.isOriginalImg());
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
        this.hwQ = getBaseFragmentActivity();
        if (this.mMZ == null) {
            if (this.hwQ instanceof AlbumFloatActivity) {
                this.mMZ = ((AlbumFloatActivity) this.hwQ).mMZ;
            } else if (this.hwQ instanceof AlbumActivity) {
                this.mMZ = ((AlbumActivity) this.hwQ).mMZ;
            }
        }
        if (this.mMZ != null) {
            this.mNd = this.mMZ.dGa();
        }
    }

    public void a(e eVar) {
        this.mMZ = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.hwQ = getBaseFragmentActivity();
        if (this.mMZ == null) {
            if (this.hwQ instanceof AlbumFloatActivity) {
                this.mMZ = ((AlbumFloatActivity) this.hwQ).mMZ;
            } else if (this.hwQ instanceof AlbumActivity) {
                this.mMZ = ((AlbumActivity) this.hwQ).mMZ;
            }
        }
        if (this.mMZ != null) {
            this.mNd = this.mMZ.dGa();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aBA = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.boK = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.boN = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.boL = this.mRoot.findViewById(R.id.layout_bottom);
        this.mNf = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.mNf.setTextSize(R.dimen.tbds34);
        this.mNf.getStyleConfig().oZ(l.getDimens(this.hwQ, R.dimen.tbds25));
        this.aBA.setOnClickListener(this.hwQ);
        this.mNf.setOnClickListener(this.hwQ);
        this.boK.setOnClickListener(this.mOnClickListener);
        this.boN.setOnClickListener(this.hwQ);
        this.boL.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.mNd != null && this.mNd.getWriteImagesInfo() != null) {
            this.boN.setVisibility(this.mNd.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oy() {
        this.mMZ.Os();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            OA();
        }
    }

    private void Oz() {
        List<ImageFileInfo> OQ;
        int currentIndex;
        boolean z = true;
        if (this.mNd == null && this.mMZ != null) {
            this.mNd = this.mMZ.dGa();
        }
        if (this.mNd != null && (OQ = this.mNd.OQ()) != null && (currentIndex = this.mNd.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.mNe = new AlbumImagePagerAdapter(this.hwQ);
            this.mViewPager.setAdapter(this.mNe);
            if (this.mCurrentIndex == 0 && OQ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(OQ, this.mCurrentIndex);
                if (this.mNd.isAdded(imageFileInfo)) {
                    a(this.boK, true);
                } else {
                    a(this.boK, false);
                }
                if (this.mNd != null && this.mNd.getWriteImagesInfo() != null) {
                    z = this.mNd.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.boN.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.boN.setVisibility(8);
                } else {
                    this.boN.setVisibility(0);
                }
            }
            this.mNe.setData(OQ);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cy(this.mNd.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.mNe != null) {
            this.mNe.setData(null);
        }
    }

    public View OT() {
        return this.aBA;
    }

    public View OU() {
        return this.mNf;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ap.setNavbarIconSrc(this.aBA, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.mNd != null) {
            cy(this.mNd.isOriginalImg());
        }
        if (this.mNe != null) {
            this.mNe.notifyDataSetChanged();
        }
        this.mNf.bkF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.hwQ != null) {
            ap.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.mNf != null) {
                int count = this.mNd != null ? y.getCount(this.mNd.ON()) : 0;
                this.mNf.setText(this.hwQ.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.mNd != null ? this.mNd.getMaxImagesAllowed() : 1)}));
                this.mNf.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo DD;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.mNe != null && (DD = this.mNe.DD(this.mCurrentIndex)) != null && DD.getFilePath() != null && DD.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.boK, z);
        }
    }

    private void OA() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Oz();
        }
    }

    public View OG() {
        return this.boN;
    }

    public void cy(boolean z) {
        long j;
        if (this.hwQ != null && this.boN != null) {
            if (this.mNe != null) {
                ImageFileInfo DD = this.mNe.DD(this.mCurrentIndex);
                j = DD != null ? n.getFileSize(DD.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hwQ.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(at.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ap.setViewTextColor(this.boN, R.color.cp_link_tip_a);
                this.boN.setText(sb2);
                this.boN.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.boN, R.color.cp_cont_f);
            this.boN.setText(string);
            this.boN.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
