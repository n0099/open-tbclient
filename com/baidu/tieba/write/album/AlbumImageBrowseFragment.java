package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ViewPager Ze;
    private ImageView aEx;
    private ImageView bLr;
    private View bLs;
    private TextView bLu;
    private BaseFragmentActivity iKt;
    private View mNoDataView;
    private View mRoot;
    private e odM;
    private c odQ;
    private AlbumImagePagerAdapter odR;
    private TBSpecificationBtn odS;
    private int bLv = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bLs && view == AlbumImageBrowseFragment.this.bLr && AlbumImageBrowseFragment.this.odR != null && AlbumImageBrowseFragment.this.odQ != null && AlbumImageBrowseFragment.this.iKt != null) {
                if (AlbumImageBrowseFragment.this.odQ.UE()) {
                    AlbumImageBrowseFragment.this.iKt.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.odR.eR(AlbumImageBrowseFragment.this.bLv)) {
                    ImageFileInfo Fh = AlbumImageBrowseFragment.this.odR.Fh(AlbumImageBrowseFragment.this.bLv);
                    if (com.baidu.tieba.write.b.b.j(Fh)) {
                        AlbumImageBrowseFragment.this.iKt.showToast(R.string.album_choose_image_low_quality_tip);
                        return;
                    }
                    if (AlbumImageBrowseFragment.this.odQ.isAdded(Fh)) {
                        if (AlbumImageBrowseFragment.this.odM.f(Fh)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bLr, false);
                            AlbumImageBrowseFragment.this.odM.g(Fh, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.odM.g(Fh)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bLr, true);
                        AlbumImageBrowseFragment.this.odM.g(Fh, true);
                    }
                    AlbumImageBrowseFragment.this.Ur();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.bLv = i;
            if (AlbumImageBrowseFragment.this.odR != null && AlbumImageBrowseFragment.this.odQ != null) {
                ImageFileInfo Fh = AlbumImageBrowseFragment.this.odR.Fh(AlbumImageBrowseFragment.this.bLv);
                if (AlbumImageBrowseFragment.this.odQ.isAdded(Fh)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bLr, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bLr, false);
                }
                if (AlbumImageBrowseFragment.this.odQ != null && AlbumImageBrowseFragment.this.odQ.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.odQ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.bLu.setVisibility(8);
                } else if (Fh == null || !Fh.isGif()) {
                    AlbumImageBrowseFragment.this.bLu.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bLu.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.dn(AlbumImageBrowseFragment.this.odQ.isOriginalImg());
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iKt = getBaseFragmentActivity();
        if (this.odM == null) {
            if (this.iKt instanceof AlbumFloatActivity) {
                this.odM = ((AlbumFloatActivity) this.iKt).odM;
            } else if (this.iKt instanceof AlbumActivity) {
                this.odM = ((AlbumActivity) this.iKt).odM;
            }
        }
        if (this.odM != null) {
            this.odQ = this.odM.dWR();
        }
    }

    public void a(e eVar) {
        this.odM = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iKt = getBaseFragmentActivity();
        if (this.odM == null) {
            if (this.iKt instanceof AlbumFloatActivity) {
                this.odM = ((AlbumFloatActivity) this.iKt).odM;
            } else if (this.iKt instanceof AlbumActivity) {
                this.odM = ((AlbumActivity) this.iKt).odM;
            }
        }
        if (this.odM != null) {
            this.odQ = this.odM.dWR();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aEx = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bLr = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.Ze = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.bLu = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bLs = this.mRoot.findViewById(R.id.layout_bottom);
        this.odS = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.odS.setTextSize(R.dimen.tbds34);
        this.odS.getStyleConfig().pO(l.getDimens(this.iKt, R.dimen.tbds25));
        this.aEx.setOnClickListener(this.iKt);
        this.odS.setOnClickListener(this.iKt);
        this.bLr.setOnClickListener(this.mOnClickListener);
        this.bLu.setOnClickListener(this.iKt);
        this.bLs.setOnClickListener(this.mOnClickListener);
        this.Ze.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.odQ != null && this.odQ.getWriteImagesInfo() != null) {
            this.bLu.setVisibility(this.odQ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ur() {
        this.odM.Ul();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Ut();
        }
    }

    private void Us() {
        List<ImageFileInfo> UJ;
        int currentIndex;
        boolean z = true;
        if (this.odQ == null && this.odM != null) {
            this.odQ = this.odM.dWR();
        }
        if (this.odQ != null && (UJ = this.odQ.UJ()) != null && (currentIndex = this.odQ.getCurrentIndex()) >= 0) {
            this.bLv = currentIndex;
            this.odR = new AlbumImagePagerAdapter(this.iKt);
            this.Ze.setAdapter(this.odR);
            if (this.bLv == 0 && UJ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(UJ, this.bLv);
                if (this.odQ.isAdded(imageFileInfo)) {
                    a(this.bLr, true);
                } else {
                    a(this.bLr, false);
                }
                if (this.odQ != null && this.odQ.getWriteImagesInfo() != null) {
                    z = this.odQ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.bLu.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.bLu.setVisibility(8);
                } else {
                    this.bLu.setVisibility(0);
                }
            }
            this.odR.setData(UJ);
            this.Ze.setCurrentItem(this.bLv, false);
            dn(this.odQ.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.odR != null) {
            this.odR.setData(null);
        }
    }

    public View UM() {
        return this.aEx;
    }

    public View UN() {
        return this.odS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ap.setNavbarIconSrc(this.aEx, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.odQ != null) {
            dn(this.odQ.isOriginalImg());
        }
        if (this.odR != null) {
            this.odR.notifyDataSetChanged();
        }
        this.odS.bup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.iKt != null) {
            if (z) {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324_select, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            if (this.odS != null) {
                int count = this.odQ != null ? y.getCount(this.odQ.UG()) : 0;
                this.odS.setText(this.iKt.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.odQ != null ? this.odQ.getMaxImagesAllowed() : 1)}));
                this.odS.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo Fh;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.odR != null && (Fh = this.odR.Fh(this.bLv)) != null && Fh.getFilePath() != null && Fh.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bLr, z);
        }
    }

    private void Ut() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.Ze.setVisibility(0);
            Us();
        }
    }

    public View Uz() {
        return this.bLu;
    }

    public void dn(boolean z) {
        long j;
        if (this.iKt != null && this.bLu != null) {
            if (this.odR != null) {
                ImageFileInfo Fh = this.odR.Fh(this.bLv);
                j = Fh != null ? o.getFileSize(Fh.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.iKt.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(au.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ap.setViewTextColor(this.bLu, R.color.CAM_X0302);
                this.bLu.setText(sb2);
                this.bLu.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_select16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.bLu, R.color.CAM_X0106);
            this.bLu.setText(string);
            this.bLu.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_selection16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
