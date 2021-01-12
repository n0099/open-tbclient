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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes7.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ViewPager Zi;
    private ImageView aCK;
    private ImageView bHH;
    private View bHI;
    private TextView bHK;
    private BaseFragmentActivity iEK;
    private View mNoDataView;
    private View mRoot;
    private e nTF;
    private c nTJ;
    private AlbumImagePagerAdapter nTK;
    private TBSpecificationBtn nTL;
    private int bHL = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bHI && view == AlbumImageBrowseFragment.this.bHH && AlbumImageBrowseFragment.this.nTK != null && AlbumImageBrowseFragment.this.nTJ != null && AlbumImageBrowseFragment.this.iEK != null) {
                if (AlbumImageBrowseFragment.this.nTJ.SX()) {
                    AlbumImageBrowseFragment.this.iEK.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.nTK.eN(AlbumImageBrowseFragment.this.bHL)) {
                    ImageFileInfo EP = AlbumImageBrowseFragment.this.nTK.EP(AlbumImageBrowseFragment.this.bHL);
                    if (com.baidu.tieba.write.b.b.j(EP)) {
                        AlbumImageBrowseFragment.this.iEK.showToast(R.string.album_choose_image_low_quality_tip);
                        return;
                    }
                    if (AlbumImageBrowseFragment.this.nTJ.isAdded(EP)) {
                        if (AlbumImageBrowseFragment.this.nTF.f(EP)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHH, false);
                            AlbumImageBrowseFragment.this.nTF.g(EP, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.nTF.g(EP)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHH, true);
                        AlbumImageBrowseFragment.this.nTF.g(EP, true);
                    }
                    AlbumImageBrowseFragment.this.SK();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.bHL = i;
            if (AlbumImageBrowseFragment.this.nTK != null && AlbumImageBrowseFragment.this.nTJ != null) {
                ImageFileInfo EP = AlbumImageBrowseFragment.this.nTK.EP(AlbumImageBrowseFragment.this.bHL);
                if (AlbumImageBrowseFragment.this.nTJ.isAdded(EP)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHH, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHH, false);
                }
                if (AlbumImageBrowseFragment.this.nTJ != null && AlbumImageBrowseFragment.this.nTJ.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.nTJ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.bHK.setVisibility(8);
                } else if (EP == null || !EP.isGif()) {
                    AlbumImageBrowseFragment.this.bHK.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bHK.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.df(AlbumImageBrowseFragment.this.nTJ.isOriginalImg());
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
        this.iEK = getBaseFragmentActivity();
        if (this.nTF == null) {
            if (this.iEK instanceof AlbumFloatActivity) {
                this.nTF = ((AlbumFloatActivity) this.iEK).nTF;
            } else if (this.iEK instanceof AlbumActivity) {
                this.nTF = ((AlbumActivity) this.iEK).nTF;
            }
        }
        if (this.nTF != null) {
            this.nTJ = this.nTF.dUD();
        }
    }

    public void a(e eVar) {
        this.nTF = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iEK = getBaseFragmentActivity();
        if (this.nTF == null) {
            if (this.iEK instanceof AlbumFloatActivity) {
                this.nTF = ((AlbumFloatActivity) this.iEK).nTF;
            } else if (this.iEK instanceof AlbumActivity) {
                this.nTF = ((AlbumActivity) this.iEK).nTF;
            }
        }
        if (this.nTF != null) {
            this.nTJ = this.nTF.dUD();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aCK = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bHH = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.Zi = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.bHK = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bHI = this.mRoot.findViewById(R.id.layout_bottom);
        this.nTL = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.nTL.setTextSize(R.dimen.tbds34);
        this.nTL.getStyleConfig().pJ(l.getDimens(this.iEK, R.dimen.tbds25));
        this.aCK.setOnClickListener(this.iEK);
        this.nTL.setOnClickListener(this.iEK);
        this.bHH.setOnClickListener(this.mOnClickListener);
        this.bHK.setOnClickListener(this.iEK);
        this.bHI.setOnClickListener(this.mOnClickListener);
        this.Zi.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.nTJ != null && this.nTJ.getWriteImagesInfo() != null) {
            this.bHK.setVisibility(this.nTJ.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SK() {
        this.nTF.SE();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            SM();
        }
    }

    private void SL() {
        List<ImageFileInfo> Tc;
        int currentIndex;
        boolean z = true;
        if (this.nTJ == null && this.nTF != null) {
            this.nTJ = this.nTF.dUD();
        }
        if (this.nTJ != null && (Tc = this.nTJ.Tc()) != null && (currentIndex = this.nTJ.getCurrentIndex()) >= 0) {
            this.bHL = currentIndex;
            this.nTK = new AlbumImagePagerAdapter(this.iEK);
            this.Zi.setAdapter(this.nTK);
            if (this.bHL == 0 && Tc != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) x.getItem(Tc, this.bHL);
                if (this.nTJ.isAdded(imageFileInfo)) {
                    a(this.bHH, true);
                } else {
                    a(this.bHH, false);
                }
                if (this.nTJ != null && this.nTJ.getWriteImagesInfo() != null) {
                    z = this.nTJ.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.bHK.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.bHK.setVisibility(8);
                } else {
                    this.bHK.setVisibility(0);
                }
            }
            this.nTK.setData(Tc);
            this.Zi.setCurrentItem(this.bHL, false);
            df(this.nTJ.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.nTK != null) {
            this.nTK.setData(null);
        }
    }

    public View Tf() {
        return this.aCK;
    }

    public View Tg() {
        return this.nTL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ao.setNavbarIconSrc(this.aCK, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.nTJ != null) {
            df(this.nTJ.isOriginalImg());
        }
        if (this.nTK != null) {
            this.nTK.notifyDataSetChanged();
        }
        this.nTL.btV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.iEK != null) {
            if (z) {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324_select, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            if (this.nTL != null) {
                int count = this.nTJ != null ? x.getCount(this.nTJ.SZ()) : 0;
                this.nTL.setText(this.iEK.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nTJ != null ? this.nTJ.getMaxImagesAllowed() : 1)}));
                this.nTL.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo EP;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.nTK != null && (EP = this.nTK.EP(this.bHL)) != null && EP.getFilePath() != null && EP.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bHH, z);
        }
    }

    private void SM() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.Zi.setVisibility(0);
            SL();
        }
    }

    public View SS() {
        return this.bHK;
    }

    public void df(boolean z) {
        long j;
        if (this.iEK != null && this.bHK != null) {
            if (this.nTK != null) {
                ImageFileInfo EP = this.nTK.EP(this.bHL);
                j = EP != null ? n.getFileSize(EP.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.iEK.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(at.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ao.setViewTextColor(this.bHK, R.color.CAM_X0302);
                this.bHK.setText(sb2);
                this.bHK.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_select16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ao.setViewTextColor(this.bHK, R.color.CAM_X0106);
            this.bHK.setText(string);
            this.bHK.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_selection16, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
