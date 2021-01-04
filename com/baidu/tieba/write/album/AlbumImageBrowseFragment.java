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
/* loaded from: classes8.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ViewPager Zk;
    private ImageView aHx;
    private ImageView bMt;
    private View bMu;
    private TextView bMw;
    private BaseFragmentActivity iJr;
    private View mNoDataView;
    private View mRoot;
    private e nYl;
    private c nYp;
    private AlbumImagePagerAdapter nYq;
    private TBSpecificationBtn nYr;
    private int bMx = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bMu && view == AlbumImageBrowseFragment.this.bMt && AlbumImageBrowseFragment.this.nYq != null && AlbumImageBrowseFragment.this.nYp != null && AlbumImageBrowseFragment.this.iJr != null) {
                if (AlbumImageBrowseFragment.this.nYp.WP()) {
                    AlbumImageBrowseFragment.this.iJr.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.nYq.gu(AlbumImageBrowseFragment.this.bMx)) {
                    ImageFileInfo Gv = AlbumImageBrowseFragment.this.nYq.Gv(AlbumImageBrowseFragment.this.bMx);
                    if (com.baidu.tieba.write.b.b.j(Gv)) {
                        AlbumImageBrowseFragment.this.iJr.showToast(R.string.album_choose_image_low_quality_tip);
                        return;
                    }
                    if (AlbumImageBrowseFragment.this.nYp.isAdded(Gv)) {
                        if (AlbumImageBrowseFragment.this.nYl.f(Gv)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMt, false);
                            AlbumImageBrowseFragment.this.nYl.g(Gv, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.nYl.g(Gv)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMt, true);
                        AlbumImageBrowseFragment.this.nYl.g(Gv, true);
                    }
                    AlbumImageBrowseFragment.this.WC();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.bMx = i;
            if (AlbumImageBrowseFragment.this.nYq != null && AlbumImageBrowseFragment.this.nYp != null) {
                ImageFileInfo Gv = AlbumImageBrowseFragment.this.nYq.Gv(AlbumImageBrowseFragment.this.bMx);
                if (AlbumImageBrowseFragment.this.nYp.isAdded(Gv)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMt, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMt, false);
                }
                if (AlbumImageBrowseFragment.this.nYp != null && AlbumImageBrowseFragment.this.nYp.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.nYp.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.bMw.setVisibility(8);
                } else if (Gv == null || !Gv.isGif()) {
                    AlbumImageBrowseFragment.this.bMw.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bMw.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.dj(AlbumImageBrowseFragment.this.nYp.isOriginalImg());
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
        this.iJr = getBaseFragmentActivity();
        if (this.nYl == null) {
            if (this.iJr instanceof AlbumFloatActivity) {
                this.nYl = ((AlbumFloatActivity) this.iJr).nYl;
            } else if (this.iJr instanceof AlbumActivity) {
                this.nYl = ((AlbumActivity) this.iJr).nYl;
            }
        }
        if (this.nYl != null) {
            this.nYp = this.nYl.dYu();
        }
    }

    public void a(e eVar) {
        this.nYl = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iJr = getBaseFragmentActivity();
        if (this.nYl == null) {
            if (this.iJr instanceof AlbumFloatActivity) {
                this.nYl = ((AlbumFloatActivity) this.iJr).nYl;
            } else if (this.iJr instanceof AlbumActivity) {
                this.nYl = ((AlbumActivity) this.iJr).nYl;
            }
        }
        if (this.nYl != null) {
            this.nYp = this.nYl.dYu();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aHx = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bMt = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.Zk = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.bMw = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bMu = this.mRoot.findViewById(R.id.layout_bottom);
        this.nYr = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.nYr.setTextSize(R.dimen.tbds34);
        this.nYr.getStyleConfig().rp(l.getDimens(this.iJr, R.dimen.tbds25));
        this.aHx.setOnClickListener(this.iJr);
        this.nYr.setOnClickListener(this.iJr);
        this.bMt.setOnClickListener(this.mOnClickListener);
        this.bMw.setOnClickListener(this.iJr);
        this.bMu.setOnClickListener(this.mOnClickListener);
        this.Zk.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.nYp != null && this.nYp.getWriteImagesInfo() != null) {
            this.bMw.setVisibility(this.nYp.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WC() {
        this.nYl.Ww();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            WE();
        }
    }

    private void WD() {
        List<ImageFileInfo> WU;
        int currentIndex;
        boolean z = true;
        if (this.nYp == null && this.nYl != null) {
            this.nYp = this.nYl.dYu();
        }
        if (this.nYp != null && (WU = this.nYp.WU()) != null && (currentIndex = this.nYp.getCurrentIndex()) >= 0) {
            this.bMx = currentIndex;
            this.nYq = new AlbumImagePagerAdapter(this.iJr);
            this.Zk.setAdapter(this.nYq);
            if (this.bMx == 0 && WU != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) x.getItem(WU, this.bMx);
                if (this.nYp.isAdded(imageFileInfo)) {
                    a(this.bMt, true);
                } else {
                    a(this.bMt, false);
                }
                if (this.nYp != null && this.nYp.getWriteImagesInfo() != null) {
                    z = this.nYp.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.bMw.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.bMw.setVisibility(8);
                } else {
                    this.bMw.setVisibility(0);
                }
            }
            this.nYq.setData(WU);
            this.Zk.setCurrentItem(this.bMx, false);
            dj(this.nYp.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.nYq != null) {
            this.nYq.setData(null);
        }
    }

    public View WX() {
        return this.aHx;
    }

    public View WY() {
        return this.nYr;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ao.setNavbarIconSrc(this.aHx, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.nYp != null) {
            dj(this.nYp.isOriginalImg());
        }
        if (this.nYq != null) {
            this.nYq.notifyDataSetChanged();
        }
        this.nYr.bxO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.iJr != null) {
            if (z) {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324_select, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            if (this.nYr != null) {
                int count = this.nYp != null ? x.getCount(this.nYp.WR()) : 0;
                this.nYr.setText(this.iJr.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nYp != null ? this.nYp.getMaxImagesAllowed() : 1)}));
                this.nYr.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo Gv;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.nYq != null && (Gv = this.nYq.Gv(this.bMx)) != null && Gv.getFilePath() != null && Gv.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bMt, z);
        }
    }

    private void WE() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.Zk.setVisibility(0);
            WD();
        }
    }

    public View WK() {
        return this.bMw;
    }

    public void dj(boolean z) {
        long j;
        if (this.iJr != null && this.bMw != null) {
            if (this.nYq != null) {
                ImageFileInfo Gv = this.nYq.Gv(this.bMx);
                j = Gv != null ? n.getFileSize(Gv.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.iJr.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(at.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ao.setViewTextColor(this.bMw, R.color.CAM_X0302);
                this.bMw.setText(sb2);
                this.bMw.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_select16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ao.setViewTextColor(this.bMw, R.color.CAM_X0106);
            this.bMw.setText(string);
            this.bMw.setCompoundDrawablesWithIntrinsicBounds(WebPManager.a(R.drawable.icon_pure_image_ok_selection16, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
