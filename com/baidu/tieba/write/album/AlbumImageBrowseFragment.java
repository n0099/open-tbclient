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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView avt;
    private ImageView biL;
    private View biM;
    private TextView biO;
    private BaseFragmentActivity hep;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private e mmG;
    private c mmK;
    private AlbumImagePagerAdapter mmL;
    private TBSpecificationBtn mmM;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.biM && view == AlbumImageBrowseFragment.this.biL && AlbumImageBrowseFragment.this.mmL != null && AlbumImageBrowseFragment.this.mmK != null && AlbumImageBrowseFragment.this.hep != null) {
                if (AlbumImageBrowseFragment.this.mmK.IM()) {
                    AlbumImageBrowseFragment.this.hep.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.mmL.dw(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo AL = AlbumImageBrowseFragment.this.mmL.AL(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.mmK.isAdded(AL)) {
                        if (AlbumImageBrowseFragment.this.mmG.f(AL)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.biL, false);
                            AlbumImageBrowseFragment.this.mmG.g(AL, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.mmG.g(AL)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.biL, true);
                        AlbumImageBrowseFragment.this.mmG.g(AL, true);
                    }
                    AlbumImageBrowseFragment.this.Iz();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.mmL != null && AlbumImageBrowseFragment.this.mmK != null) {
                ImageFileInfo AL = AlbumImageBrowseFragment.this.mmL.AL(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.mmK.isAdded(AL)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.biL, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.biL, false);
                }
                if (AlbumImageBrowseFragment.this.mmK != null && AlbumImageBrowseFragment.this.mmK.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.mmK.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.biO.setVisibility(8);
                } else if (AL == null || !AL.isGif()) {
                    AlbumImageBrowseFragment.this.biO.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.biO.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cn(AlbumImageBrowseFragment.this.mmK.isOriginalImg());
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
        this.hep = getBaseFragmentActivity();
        this.mmK = this.mmG.drn();
    }

    public void a(e eVar) {
        this.mmG = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.avt = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.biL = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.biO = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.biM = this.mRoot.findViewById(R.id.layout_bottom);
        this.mmM = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.mmM.setTextSize(R.dimen.tbds34);
        this.mmM.getStyleConfig().mA(l.getDimens(this.hep, R.dimen.tbds25));
        this.avt.setOnClickListener(this.hep);
        this.mmM.setOnClickListener(this.hep);
        this.biL.setOnClickListener(this.mOnClickListener);
        this.biO.setOnClickListener(this.hep);
        this.biM.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.mmK != null && this.mmK.getWriteImagesInfo() != null) {
            this.biO.setVisibility(this.mmK.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iz() {
        this.mmG.It();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            IB();
        }
    }

    private void IA() {
        List<ImageFileInfo> IR;
        int currentIndex;
        boolean z = true;
        if (this.mmK == null && this.mmG != null) {
            this.mmK = this.mmG.drn();
        }
        if (this.mmK != null && (IR = this.mmK.IR()) != null && (currentIndex = this.mmK.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.mmL = new AlbumImagePagerAdapter(this.hep);
            this.mViewPager.setAdapter(this.mmL);
            if (this.mCurrentIndex == 0 && IR != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) w.getItem(IR, this.mCurrentIndex);
                if (this.mmK.isAdded(imageFileInfo)) {
                    a(this.biL, true);
                } else {
                    a(this.biL, false);
                }
                if (this.mmK != null && this.mmK.getWriteImagesInfo() != null) {
                    z = this.mmK.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.biO.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.biO.setVisibility(8);
                } else {
                    this.biO.setVisibility(0);
                }
            }
            this.mmL.setData(IR);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cn(this.mmK.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.mmL != null) {
            this.mmL.setData(null);
        }
    }

    public View IV() {
        return this.avt;
    }

    public View IW() {
        return this.mmM;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        an.setNavbarIconSrc(this.avt, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.mmK != null) {
            cn(this.mmK.isOriginalImg());
        }
        if (this.mmL != null) {
            this.mmL.notifyDataSetChanged();
        }
        this.mmM.aYj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.hep != null) {
            an.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.mmM != null) {
                int count = this.mmK != null ? w.getCount(this.mmK.IO()) : 0;
                this.mmM.setText(this.hep.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.mmK != null ? this.mmK.getMaxImagesAllowed() : 1)}));
                this.mmM.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo AL;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.mmL != null && (AL = this.mmL.AL(this.mCurrentIndex)) != null && AL.getFilePath() != null && AL.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.biL, z);
        }
    }

    private void IB() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            IA();
        }
    }

    public View IH() {
        return this.biO;
    }

    public void cn(boolean z) {
        long j;
        if (this.hep != null && this.biO != null) {
            if (this.mmL != null) {
                ImageFileInfo AL = this.mmL.AL(this.mCurrentIndex);
                j = AL != null ? n.getFileSize(AL.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hep.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(ar.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                an.setViewTextColor(this.biO, (int) R.color.cp_link_tip_a);
                this.biO.setText(sb2);
                this.biO.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            an.setViewTextColor(this.biO, (int) R.color.cp_cont_f);
            this.biO.setText(string);
            this.biO.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
