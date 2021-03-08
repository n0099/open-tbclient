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
/* loaded from: classes7.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView aFX;
    private ViewPager aaw;
    private ImageView bMR;
    private View bMS;
    private TextView bMU;
    private BaseFragmentActivity iMq;
    private View mNoDataView;
    private View mRoot;
    private e ogs;
    private c ogw;
    private AlbumImagePagerAdapter ogx;
    private TBSpecificationBtn ogy;
    private int bMV = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bMS && view == AlbumImageBrowseFragment.this.bMR && AlbumImageBrowseFragment.this.ogx != null && AlbumImageBrowseFragment.this.ogw != null && AlbumImageBrowseFragment.this.iMq != null) {
                if (AlbumImageBrowseFragment.this.ogw.UH()) {
                    AlbumImageBrowseFragment.this.iMq.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.ogx.eS(AlbumImageBrowseFragment.this.bMV)) {
                    ImageFileInfo Fk = AlbumImageBrowseFragment.this.ogx.Fk(AlbumImageBrowseFragment.this.bMV);
                    if (com.baidu.tieba.write.b.b.j(Fk)) {
                        AlbumImageBrowseFragment.this.iMq.showToast(R.string.album_choose_image_low_quality_tip);
                        return;
                    }
                    if (AlbumImageBrowseFragment.this.ogw.isAdded(Fk)) {
                        if (AlbumImageBrowseFragment.this.ogs.f(Fk)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMR, false);
                            AlbumImageBrowseFragment.this.ogs.g(Fk, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.ogs.g(Fk)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMR, true);
                        AlbumImageBrowseFragment.this.ogs.g(Fk, true);
                    }
                    AlbumImageBrowseFragment.this.Uu();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.bMV = i;
            if (AlbumImageBrowseFragment.this.ogx != null && AlbumImageBrowseFragment.this.ogw != null) {
                ImageFileInfo Fk = AlbumImageBrowseFragment.this.ogx.Fk(AlbumImageBrowseFragment.this.bMV);
                if (AlbumImageBrowseFragment.this.ogw.isAdded(Fk)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMR, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMR, false);
                }
                if (AlbumImageBrowseFragment.this.ogw != null && AlbumImageBrowseFragment.this.ogw.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.ogw.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.bMU.setVisibility(8);
                } else if (Fk == null || !Fk.isGif()) {
                    AlbumImageBrowseFragment.this.bMU.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bMU.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.dn(AlbumImageBrowseFragment.this.ogw.isOriginalImg());
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
        this.iMq = getBaseFragmentActivity();
        if (this.ogs == null) {
            if (this.iMq instanceof AlbumFloatActivity) {
                this.ogs = ((AlbumFloatActivity) this.iMq).ogs;
            } else if (this.iMq instanceof AlbumActivity) {
                this.ogs = ((AlbumActivity) this.iMq).ogs;
            }
        }
        if (this.ogs != null) {
            this.ogw = this.ogs.dXh();
        }
    }

    public void a(e eVar) {
        this.ogs = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iMq = getBaseFragmentActivity();
        if (this.ogs == null) {
            if (this.iMq instanceof AlbumFloatActivity) {
                this.ogs = ((AlbumFloatActivity) this.iMq).ogs;
            } else if (this.iMq instanceof AlbumActivity) {
                this.ogs = ((AlbumActivity) this.iMq).ogs;
            }
        }
        if (this.ogs != null) {
            this.ogw = this.ogs.dXh();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aFX = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bMR = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.aaw = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.bMU = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bMS = this.mRoot.findViewById(R.id.layout_bottom);
        this.ogy = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.ogy.setTextSize(R.dimen.tbds34);
        this.ogy.getStyleConfig().pP(l.getDimens(this.iMq, R.dimen.tbds25));
        this.aFX.setOnClickListener(this.iMq);
        this.ogy.setOnClickListener(this.iMq);
        this.bMR.setOnClickListener(this.mOnClickListener);
        this.bMU.setOnClickListener(this.iMq);
        this.bMS.setOnClickListener(this.mOnClickListener);
        this.aaw.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.ogw != null && this.ogw.getWriteImagesInfo() != null) {
            this.bMU.setVisibility(this.ogw.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uu() {
        this.ogs.Uo();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Uw();
        }
    }

    private void Uv() {
        List<ImageFileInfo> UM;
        int currentIndex;
        boolean z = true;
        if (this.ogw == null && this.ogs != null) {
            this.ogw = this.ogs.dXh();
        }
        if (this.ogw != null && (UM = this.ogw.UM()) != null && (currentIndex = this.ogw.getCurrentIndex()) >= 0) {
            this.bMV = currentIndex;
            this.ogx = new AlbumImagePagerAdapter(this.iMq);
            this.aaw.setAdapter(this.ogx);
            if (this.bMV == 0 && UM != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(UM, this.bMV);
                if (this.ogw.isAdded(imageFileInfo)) {
                    a(this.bMR, true);
                } else {
                    a(this.bMR, false);
                }
                if (this.ogw != null && this.ogw.getWriteImagesInfo() != null) {
                    z = this.ogw.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.bMU.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.bMU.setVisibility(8);
                } else {
                    this.bMU.setVisibility(0);
                }
            }
            this.ogx.setData(UM);
            this.aaw.setCurrentItem(this.bMV, false);
            dn(this.ogw.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.ogx != null) {
            this.ogx.setData(null);
        }
    }

    public View UP() {
        return this.aFX;
    }

    public View UQ() {
        return this.ogy;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ap.setNavbarIconSrc(this.aFX, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.ogw != null) {
            dn(this.ogw.isOriginalImg());
        }
        if (this.ogx != null) {
            this.ogx.notifyDataSetChanged();
        }
        this.ogy.bus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.iMq != null) {
            if (z) {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324_select, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            if (this.ogy != null) {
                int count = this.ogw != null ? y.getCount(this.ogw.UJ()) : 0;
                this.ogy.setText(this.iMq.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.ogw != null ? this.ogw.getMaxImagesAllowed() : 1)}));
                this.ogy.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo Fk;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.ogx != null && (Fk = this.ogx.Fk(this.bMV)) != null && Fk.getFilePath() != null && Fk.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bMR, z);
        }
    }

    private void Uw() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.aaw.setVisibility(0);
            Uv();
        }
    }

    public View UC() {
        return this.bMU;
    }

    public void dn(boolean z) {
        long j;
        if (this.iMq != null && this.bMU != null) {
            if (this.ogx != null) {
                ImageFileInfo Fk = this.ogx.Fk(this.bMV);
                j = Fk != null ? o.getFileSize(Fk.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.iMq.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(au.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ap.setViewTextColor(this.bMU, R.color.CAM_X0302);
                this.bMU.setText(sb2);
                this.bMU.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_select16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.bMU, R.color.CAM_X0106);
            this.bMU.setText(string);
            this.bMU.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_selection16, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
