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
    private ImageView aFv;
    private ImageView bxY;
    private View bxZ;
    private TextView byb;
    private BaseFragmentActivity ifx;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private e nzn;
    private c nzr;
    private AlbumImagePagerAdapter nzs;
    private TBSpecificationBtn nzt;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bxZ && view == AlbumImageBrowseFragment.this.bxY && AlbumImageBrowseFragment.this.nzs != null && AlbumImageBrowseFragment.this.nzr != null && AlbumImageBrowseFragment.this.ifx != null) {
                if (AlbumImageBrowseFragment.this.nzr.Ro()) {
                    AlbumImageBrowseFragment.this.ifx.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.nzs.fL(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo Fd = AlbumImageBrowseFragment.this.nzs.Fd(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.nzr.isAdded(Fd)) {
                        if (AlbumImageBrowseFragment.this.nzn.f(Fd)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bxY, false);
                            AlbumImageBrowseFragment.this.nzn.g(Fd, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.nzn.g(Fd)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bxY, true);
                        AlbumImageBrowseFragment.this.nzn.g(Fd, true);
                    }
                    AlbumImageBrowseFragment.this.Rb();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.nzs != null && AlbumImageBrowseFragment.this.nzr != null) {
                ImageFileInfo Fd = AlbumImageBrowseFragment.this.nzs.Fd(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.nzr.isAdded(Fd)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bxY, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bxY, false);
                }
                if (AlbumImageBrowseFragment.this.nzr != null && AlbumImageBrowseFragment.this.nzr.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.nzr.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.byb.setVisibility(8);
                } else if (Fd == null || !Fd.isGif()) {
                    AlbumImageBrowseFragment.this.byb.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.byb.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cJ(AlbumImageBrowseFragment.this.nzr.isOriginalImg());
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
        this.ifx = getBaseFragmentActivity();
        if (this.nzn == null) {
            if (this.ifx instanceof AlbumFloatActivity) {
                this.nzn = ((AlbumFloatActivity) this.ifx).nzn;
            } else if (this.ifx instanceof AlbumActivity) {
                this.nzn = ((AlbumActivity) this.ifx).nzn;
            }
        }
        if (this.nzn != null) {
            this.nzr = this.nzn.dQX();
        }
    }

    public void a(e eVar) {
        this.nzn = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ifx = getBaseFragmentActivity();
        if (this.nzn == null) {
            if (this.ifx instanceof AlbumFloatActivity) {
                this.nzn = ((AlbumFloatActivity) this.ifx).nzn;
            } else if (this.ifx instanceof AlbumActivity) {
                this.nzn = ((AlbumActivity) this.ifx).nzn;
            }
        }
        if (this.nzn != null) {
            this.nzr = this.nzn.dQX();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aFv = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bxY = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.byb = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bxZ = this.mRoot.findViewById(R.id.layout_bottom);
        this.nzt = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.nzt.setTextSize(R.dimen.tbds34);
        this.nzt.getStyleConfig().pV(l.getDimens(this.ifx, R.dimen.tbds25));
        this.aFv.setOnClickListener(this.ifx);
        this.nzt.setOnClickListener(this.ifx);
        this.bxY.setOnClickListener(this.mOnClickListener);
        this.byb.setOnClickListener(this.ifx);
        this.bxZ.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.nzr != null && this.nzr.getWriteImagesInfo() != null) {
            this.byb.setVisibility(this.nzr.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rb() {
        this.nzn.QV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Rd();
        }
    }

    private void Rc() {
        List<ImageFileInfo> Rt;
        int currentIndex;
        boolean z = true;
        if (this.nzr == null && this.nzn != null) {
            this.nzr = this.nzn.dQX();
        }
        if (this.nzr != null && (Rt = this.nzr.Rt()) != null && (currentIndex = this.nzr.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.nzs = new AlbumImagePagerAdapter(this.ifx);
            this.mViewPager.setAdapter(this.nzs);
            if (this.mCurrentIndex == 0 && Rt != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(Rt, this.mCurrentIndex);
                if (this.nzr.isAdded(imageFileInfo)) {
                    a(this.bxY, true);
                } else {
                    a(this.bxY, false);
                }
                if (this.nzr != null && this.nzr.getWriteImagesInfo() != null) {
                    z = this.nzr.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.byb.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.byb.setVisibility(8);
                } else {
                    this.byb.setVisibility(0);
                }
            }
            this.nzs.setData(Rt);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cJ(this.nzr.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.nzs != null) {
            this.nzs.setData(null);
        }
    }

    public View Rw() {
        return this.aFv;
    }

    public View Rx() {
        return this.nzt;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ap.setNavbarIconSrc(this.aFv, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.nzr != null) {
            cJ(this.nzr.isOriginalImg());
        }
        if (this.nzs != null) {
            this.nzs.notifyDataSetChanged();
        }
        this.nzt.bqd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.ifx != null) {
            ap.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.nzt != null) {
                int count = this.nzr != null ? y.getCount(this.nzr.Rq()) : 0;
                this.nzt.setText(this.ifx.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nzr != null ? this.nzr.getMaxImagesAllowed() : 1)}));
                this.nzt.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo Fd;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.nzs != null && (Fd = this.nzs.Fd(this.mCurrentIndex)) != null && Fd.getFilePath() != null && Fd.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bxY, z);
        }
    }

    private void Rd() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Rc();
        }
    }

    public View Rj() {
        return this.byb;
    }

    public void cJ(boolean z) {
        long j;
        if (this.ifx != null && this.byb != null) {
            if (this.nzs != null) {
                ImageFileInfo Fd = this.nzs.Fd(this.mCurrentIndex);
                j = Fd != null ? n.getFileSize(Fd.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.ifx.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(at.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ap.setViewTextColor(this.byb, R.color.cp_link_tip_a);
                this.byb.setText(sb2);
                this.byb.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.byb, R.color.cp_cont_f);
            this.byb.setText(string);
            this.byb.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
