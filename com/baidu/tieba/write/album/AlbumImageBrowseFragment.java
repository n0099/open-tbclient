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
    private ImageView aGl;
    private ImageView bEj;
    private View bEk;
    private TextView bEm;
    private BaseFragmentActivity ilu;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private e nFh;
    private c nFl;
    private AlbumImagePagerAdapter nFm;
    private TBSpecificationBtn nFn;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bEk && view == AlbumImageBrowseFragment.this.bEj && AlbumImageBrowseFragment.this.nFm != null && AlbumImageBrowseFragment.this.nFl != null && AlbumImageBrowseFragment.this.ilu != null) {
                if (AlbumImageBrowseFragment.this.nFl.TW()) {
                    AlbumImageBrowseFragment.this.ilu.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.nFm.fY(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo Fq = AlbumImageBrowseFragment.this.nFm.Fq(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.nFl.isAdded(Fq)) {
                        if (AlbumImageBrowseFragment.this.nFh.f(Fq)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bEj, false);
                            AlbumImageBrowseFragment.this.nFh.g(Fq, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.nFh.g(Fq)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bEj, true);
                        AlbumImageBrowseFragment.this.nFh.g(Fq, true);
                    }
                    AlbumImageBrowseFragment.this.TJ();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.nFm != null && AlbumImageBrowseFragment.this.nFl != null) {
                ImageFileInfo Fq = AlbumImageBrowseFragment.this.nFm.Fq(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.nFl.isAdded(Fq)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bEj, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bEj, false);
                }
                if (AlbumImageBrowseFragment.this.nFl != null && AlbumImageBrowseFragment.this.nFl.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.nFl.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.bEm.setVisibility(8);
                } else if (Fq == null || !Fq.isGif()) {
                    AlbumImageBrowseFragment.this.bEm.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bEm.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cQ(AlbumImageBrowseFragment.this.nFl.isOriginalImg());
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
        this.ilu = getBaseFragmentActivity();
        if (this.nFh == null) {
            if (this.ilu instanceof AlbumFloatActivity) {
                this.nFh = ((AlbumFloatActivity) this.ilu).nFh;
            } else if (this.ilu instanceof AlbumActivity) {
                this.nFh = ((AlbumActivity) this.ilu).nFh;
            }
        }
        if (this.nFh != null) {
            this.nFl = this.nFh.dTx();
        }
    }

    public void a(e eVar) {
        this.nFh = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ilu = getBaseFragmentActivity();
        if (this.nFh == null) {
            if (this.ilu instanceof AlbumFloatActivity) {
                this.nFh = ((AlbumFloatActivity) this.ilu).nFh;
            } else if (this.ilu instanceof AlbumActivity) {
                this.nFh = ((AlbumActivity) this.ilu).nFh;
            }
        }
        if (this.nFh != null) {
            this.nFl = this.nFh.dTx();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aGl = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bEj = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.bEm = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bEk = this.mRoot.findViewById(R.id.layout_bottom);
        this.nFn = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.nFn.setTextSize(R.dimen.tbds34);
        this.nFn.getStyleConfig().qf(l.getDimens(this.ilu, R.dimen.tbds25));
        this.aGl.setOnClickListener(this.ilu);
        this.nFn.setOnClickListener(this.ilu);
        this.bEj.setOnClickListener(this.mOnClickListener);
        this.bEm.setOnClickListener(this.ilu);
        this.bEk.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.nFl != null && this.nFl.getWriteImagesInfo() != null) {
            this.bEm.setVisibility(this.nFl.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TJ() {
        this.nFh.TD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            TL();
        }
    }

    private void TK() {
        List<ImageFileInfo> Ub;
        int currentIndex;
        boolean z = true;
        if (this.nFl == null && this.nFh != null) {
            this.nFl = this.nFh.dTx();
        }
        if (this.nFl != null && (Ub = this.nFl.Ub()) != null && (currentIndex = this.nFl.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.nFm = new AlbumImagePagerAdapter(this.ilu);
            this.mViewPager.setAdapter(this.nFm);
            if (this.mCurrentIndex == 0 && Ub != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(Ub, this.mCurrentIndex);
                if (this.nFl.isAdded(imageFileInfo)) {
                    a(this.bEj, true);
                } else {
                    a(this.bEj, false);
                }
                if (this.nFl != null && this.nFl.getWriteImagesInfo() != null) {
                    z = this.nFl.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.bEm.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.bEm.setVisibility(8);
                } else {
                    this.bEm.setVisibility(0);
                }
            }
            this.nFm.setData(Ub);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cQ(this.nFl.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.nFm != null) {
            this.nFm.setData(null);
        }
    }

    public View Ue() {
        return this.aGl;
    }

    public View Uf() {
        return this.nFn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ap.setNavbarIconSrc(this.aGl, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.nFl != null) {
            cQ(this.nFl.isOriginalImg());
        }
        if (this.nFm != null) {
            this.nFm.notifyDataSetChanged();
        }
        this.nFn.bsD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.ilu != null) {
            ap.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.nFn != null) {
                int count = this.nFl != null ? y.getCount(this.nFl.TY()) : 0;
                this.nFn.setText(this.ilu.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nFl != null ? this.nFl.getMaxImagesAllowed() : 1)}));
                this.nFn.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo Fq;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.nFm != null && (Fq = this.nFm.Fq(this.mCurrentIndex)) != null && Fq.getFilePath() != null && Fq.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bEj, z);
        }
    }

    private void TL() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            TK();
        }
    }

    public View TR() {
        return this.bEm;
    }

    public void cQ(boolean z) {
        long j;
        if (this.ilu != null && this.bEm != null) {
            if (this.nFm != null) {
                ImageFileInfo Fq = this.nFm.Fq(this.mCurrentIndex);
                j = Fq != null ? n.getFileSize(Fq.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.ilu.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(at.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ap.setViewTextColor(this.bEm, R.color.cp_link_tip_a);
                this.bEm.setText(sb2);
                this.bEm.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.bEm, R.color.cp_cont_f);
            this.bEm.setText(string);
            this.bEm.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
