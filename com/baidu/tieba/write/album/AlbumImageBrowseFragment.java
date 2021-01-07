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
    private e nYk;
    private c nYo;
    private AlbumImagePagerAdapter nYp;
    private TBSpecificationBtn nYq;
    private int bMx = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bMu && view == AlbumImageBrowseFragment.this.bMt && AlbumImageBrowseFragment.this.nYp != null && AlbumImageBrowseFragment.this.nYo != null && AlbumImageBrowseFragment.this.iJr != null) {
                if (AlbumImageBrowseFragment.this.nYo.WQ()) {
                    AlbumImageBrowseFragment.this.iJr.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.nYp.gu(AlbumImageBrowseFragment.this.bMx)) {
                    ImageFileInfo Gv = AlbumImageBrowseFragment.this.nYp.Gv(AlbumImageBrowseFragment.this.bMx);
                    if (com.baidu.tieba.write.b.b.j(Gv)) {
                        AlbumImageBrowseFragment.this.iJr.showToast(R.string.album_choose_image_low_quality_tip);
                        return;
                    }
                    if (AlbumImageBrowseFragment.this.nYo.isAdded(Gv)) {
                        if (AlbumImageBrowseFragment.this.nYk.f(Gv)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMt, false);
                            AlbumImageBrowseFragment.this.nYk.g(Gv, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.nYk.g(Gv)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMt, true);
                        AlbumImageBrowseFragment.this.nYk.g(Gv, true);
                    }
                    AlbumImageBrowseFragment.this.WD();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.bMx = i;
            if (AlbumImageBrowseFragment.this.nYp != null && AlbumImageBrowseFragment.this.nYo != null) {
                ImageFileInfo Gv = AlbumImageBrowseFragment.this.nYp.Gv(AlbumImageBrowseFragment.this.bMx);
                if (AlbumImageBrowseFragment.this.nYo.isAdded(Gv)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMt, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMt, false);
                }
                if (AlbumImageBrowseFragment.this.nYo != null && AlbumImageBrowseFragment.this.nYo.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.nYo.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.bMw.setVisibility(8);
                } else if (Gv == null || !Gv.isGif()) {
                    AlbumImageBrowseFragment.this.bMw.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bMw.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.dj(AlbumImageBrowseFragment.this.nYo.isOriginalImg());
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
        if (this.nYk == null) {
            if (this.iJr instanceof AlbumFloatActivity) {
                this.nYk = ((AlbumFloatActivity) this.iJr).nYk;
            } else if (this.iJr instanceof AlbumActivity) {
                this.nYk = ((AlbumActivity) this.iJr).nYk;
            }
        }
        if (this.nYk != null) {
            this.nYo = this.nYk.dYv();
        }
    }

    public void a(e eVar) {
        this.nYk = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iJr = getBaseFragmentActivity();
        if (this.nYk == null) {
            if (this.iJr instanceof AlbumFloatActivity) {
                this.nYk = ((AlbumFloatActivity) this.iJr).nYk;
            } else if (this.iJr instanceof AlbumActivity) {
                this.nYk = ((AlbumActivity) this.iJr).nYk;
            }
        }
        if (this.nYk != null) {
            this.nYo = this.nYk.dYv();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aHx = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.bMt = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.Zk = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.bMw = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.bMu = this.mRoot.findViewById(R.id.layout_bottom);
        this.nYq = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.nYq.setTextSize(R.dimen.tbds34);
        this.nYq.getStyleConfig().rp(l.getDimens(this.iJr, R.dimen.tbds25));
        this.aHx.setOnClickListener(this.iJr);
        this.nYq.setOnClickListener(this.iJr);
        this.bMt.setOnClickListener(this.mOnClickListener);
        this.bMw.setOnClickListener(this.iJr);
        this.bMu.setOnClickListener(this.mOnClickListener);
        this.Zk.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.nYo != null && this.nYo.getWriteImagesInfo() != null) {
            this.bMw.setVisibility(this.nYo.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WD() {
        this.nYk.Wx();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            WF();
        }
    }

    private void WE() {
        List<ImageFileInfo> WV;
        int currentIndex;
        boolean z = true;
        if (this.nYo == null && this.nYk != null) {
            this.nYo = this.nYk.dYv();
        }
        if (this.nYo != null && (WV = this.nYo.WV()) != null && (currentIndex = this.nYo.getCurrentIndex()) >= 0) {
            this.bMx = currentIndex;
            this.nYp = new AlbumImagePagerAdapter(this.iJr);
            this.Zk.setAdapter(this.nYp);
            if (this.bMx == 0 && WV != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) x.getItem(WV, this.bMx);
                if (this.nYo.isAdded(imageFileInfo)) {
                    a(this.bMt, true);
                } else {
                    a(this.bMt, false);
                }
                if (this.nYo != null && this.nYo.getWriteImagesInfo() != null) {
                    z = this.nYo.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.bMw.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.bMw.setVisibility(8);
                } else {
                    this.bMw.setVisibility(0);
                }
            }
            this.nYp.setData(WV);
            this.Zk.setCurrentItem(this.bMx, false);
            dj(this.nYo.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.nYp != null) {
            this.nYp.setData(null);
        }
    }

    public View WY() {
        return this.aHx;
    }

    public View WZ() {
        return this.nYq;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ao.setNavbarIconSrc(this.aHx, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.nYo != null) {
            dj(this.nYo.isOriginalImg());
        }
        if (this.nYp != null) {
            this.nYp.notifyDataSetChanged();
        }
        this.nYq.bxP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.iJr != null) {
            if (z) {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324_select, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            if (this.nYq != null) {
                int count = this.nYo != null ? x.getCount(this.nYo.WS()) : 0;
                this.nYq.setText(this.iJr.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.nYo != null ? this.nYo.getMaxImagesAllowed() : 1)}));
                this.nYq.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo Gv;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.nYp != null && (Gv = this.nYp.Gv(this.bMx)) != null && Gv.getFilePath() != null && Gv.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bMt, z);
        }
    }

    private void WF() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.Zk.setVisibility(0);
            WE();
        }
    }

    public View WL() {
        return this.bMw;
    }

    public void dj(boolean z) {
        long j;
        if (this.iJr != null && this.bMw != null) {
            if (this.nYp != null) {
                ImageFileInfo Gv = this.nYp.Gv(this.bMx);
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
