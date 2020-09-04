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
    private ImageView aBC;
    private ImageView boN;
    private View boO;
    private TextView boQ;
    private BaseFragmentActivity hwW;
    private View mNoDataView;
    private e mNr;
    private c mNv;
    private AlbumImagePagerAdapter mNw;
    private TBSpecificationBtn mNx;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.boO && view == AlbumImageBrowseFragment.this.boN && AlbumImageBrowseFragment.this.mNw != null && AlbumImageBrowseFragment.this.mNv != null && AlbumImageBrowseFragment.this.hwW != null) {
                if (AlbumImageBrowseFragment.this.mNv.OL()) {
                    AlbumImageBrowseFragment.this.hwW.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.mNw.fp(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo DD = AlbumImageBrowseFragment.this.mNw.DD(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.mNv.isAdded(DD)) {
                        if (AlbumImageBrowseFragment.this.mNr.f(DD)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boN, false);
                            AlbumImageBrowseFragment.this.mNr.g(DD, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.mNr.g(DD)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boN, true);
                        AlbumImageBrowseFragment.this.mNr.g(DD, true);
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
            if (AlbumImageBrowseFragment.this.mNw != null && AlbumImageBrowseFragment.this.mNv != null) {
                ImageFileInfo DD = AlbumImageBrowseFragment.this.mNw.DD(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.mNv.isAdded(DD)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boN, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.boN, false);
                }
                if (AlbumImageBrowseFragment.this.mNv != null && AlbumImageBrowseFragment.this.mNv.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.mNv.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.boQ.setVisibility(8);
                } else if (DD == null || !DD.isGif()) {
                    AlbumImageBrowseFragment.this.boQ.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.boQ.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cz(AlbumImageBrowseFragment.this.mNv.isOriginalImg());
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
        this.hwW = getBaseFragmentActivity();
        if (this.mNr == null) {
            if (this.hwW instanceof AlbumFloatActivity) {
                this.mNr = ((AlbumFloatActivity) this.hwW).mNr;
            } else if (this.hwW instanceof AlbumActivity) {
                this.mNr = ((AlbumActivity) this.hwW).mNr;
            }
        }
        if (this.mNr != null) {
            this.mNv = this.mNr.dGj();
        }
    }

    public void a(e eVar) {
        this.mNr = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.hwW = getBaseFragmentActivity();
        if (this.mNr == null) {
            if (this.hwW instanceof AlbumFloatActivity) {
                this.mNr = ((AlbumFloatActivity) this.hwW).mNr;
            } else if (this.hwW instanceof AlbumActivity) {
                this.mNr = ((AlbumActivity) this.hwW).mNr;
            }
        }
        if (this.mNr != null) {
            this.mNv = this.mNr.dGj();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aBC = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.boN = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.boQ = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.boO = this.mRoot.findViewById(R.id.layout_bottom);
        this.mNx = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.mNx.setTextSize(R.dimen.tbds34);
        this.mNx.getStyleConfig().oZ(l.getDimens(this.hwW, R.dimen.tbds25));
        this.aBC.setOnClickListener(this.hwW);
        this.mNx.setOnClickListener(this.hwW);
        this.boN.setOnClickListener(this.mOnClickListener);
        this.boQ.setOnClickListener(this.hwW);
        this.boO.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.mNv != null && this.mNv.getWriteImagesInfo() != null) {
            this.boQ.setVisibility(this.mNv.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oy() {
        this.mNr.Os();
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
        if (this.mNv == null && this.mNr != null) {
            this.mNv = this.mNr.dGj();
        }
        if (this.mNv != null && (OQ = this.mNv.OQ()) != null && (currentIndex = this.mNv.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.mNw = new AlbumImagePagerAdapter(this.hwW);
            this.mViewPager.setAdapter(this.mNw);
            if (this.mCurrentIndex == 0 && OQ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(OQ, this.mCurrentIndex);
                if (this.mNv.isAdded(imageFileInfo)) {
                    a(this.boN, true);
                } else {
                    a(this.boN, false);
                }
                if (this.mNv != null && this.mNv.getWriteImagesInfo() != null) {
                    z = this.mNv.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.boQ.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.boQ.setVisibility(8);
                } else {
                    this.boQ.setVisibility(0);
                }
            }
            this.mNw.setData(OQ);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cz(this.mNv.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.mNw != null) {
            this.mNw.setData(null);
        }
    }

    public View OT() {
        return this.aBC;
    }

    public View OU() {
        return this.mNx;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ap.setNavbarIconSrc(this.aBC, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.mNv != null) {
            cz(this.mNv.isOriginalImg());
        }
        if (this.mNw != null) {
            this.mNw.notifyDataSetChanged();
        }
        this.mNx.bkF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.hwW != null) {
            ap.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.mNx != null) {
                int count = this.mNv != null ? y.getCount(this.mNv.ON()) : 0;
                this.mNx.setText(this.hwW.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.mNv != null ? this.mNv.getMaxImagesAllowed() : 1)}));
                this.mNx.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo DD;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.mNw != null && (DD = this.mNw.DD(this.mCurrentIndex)) != null && DD.getFilePath() != null && DD.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.boN, z);
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
        return this.boQ;
    }

    public void cz(boolean z) {
        long j;
        if (this.hwW != null && this.boQ != null) {
            if (this.mNw != null) {
                ImageFileInfo DD = this.mNw.DD(this.mCurrentIndex);
                j = DD != null ? n.getFileSize(DD.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hwW.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(at.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ap.setViewTextColor(this.boQ, R.color.cp_link_tip_a);
                this.boQ.setText(sb2);
                this.boQ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.boQ, R.color.cp_cont_f);
            this.boQ.setText(string);
            this.boQ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
