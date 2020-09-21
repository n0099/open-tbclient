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
    private ImageView aCi;
    private ImageView brW;
    private View brX;
    private TextView brZ;
    private BaseFragmentActivity hEa;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private e mXo;
    private c mXs;
    private AlbumImagePagerAdapter mXt;
    private TBSpecificationBtn mXu;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.brX && view == AlbumImageBrowseFragment.this.brW && AlbumImageBrowseFragment.this.mXt != null && AlbumImageBrowseFragment.this.mXs != null && AlbumImageBrowseFragment.this.hEa != null) {
                if (AlbumImageBrowseFragment.this.mXs.Po()) {
                    AlbumImageBrowseFragment.this.hEa.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.mXt.fA(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo Ee = AlbumImageBrowseFragment.this.mXt.Ee(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.mXs.isAdded(Ee)) {
                        if (AlbumImageBrowseFragment.this.mXo.f(Ee)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.brW, false);
                            AlbumImageBrowseFragment.this.mXo.g(Ee, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.mXo.g(Ee)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.brW, true);
                        AlbumImageBrowseFragment.this.mXo.g(Ee, true);
                    }
                    AlbumImageBrowseFragment.this.Pb();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.mXt != null && AlbumImageBrowseFragment.this.mXs != null) {
                ImageFileInfo Ee = AlbumImageBrowseFragment.this.mXt.Ee(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.mXs.isAdded(Ee)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.brW, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.brW, false);
                }
                if (AlbumImageBrowseFragment.this.mXs != null && AlbumImageBrowseFragment.this.mXs.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.mXs.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.brZ.setVisibility(8);
                } else if (Ee == null || !Ee.isGif()) {
                    AlbumImageBrowseFragment.this.brZ.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.brZ.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cA(AlbumImageBrowseFragment.this.mXs.isOriginalImg());
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
        this.hEa = getBaseFragmentActivity();
        if (this.mXo == null) {
            if (this.hEa instanceof AlbumFloatActivity) {
                this.mXo = ((AlbumFloatActivity) this.hEa).mXo;
            } else if (this.hEa instanceof AlbumActivity) {
                this.mXo = ((AlbumActivity) this.hEa).mXo;
            }
        }
        if (this.mXo != null) {
            this.mXs = this.mXo.dKd();
        }
    }

    public void a(e eVar) {
        this.mXo = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.hEa = getBaseFragmentActivity();
        if (this.mXo == null) {
            if (this.hEa instanceof AlbumFloatActivity) {
                this.mXo = ((AlbumFloatActivity) this.hEa).mXo;
            } else if (this.hEa instanceof AlbumActivity) {
                this.mXo = ((AlbumActivity) this.hEa).mXo;
            }
        }
        if (this.mXo != null) {
            this.mXs = this.mXo.dKd();
        }
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.aCi = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.brW = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.brZ = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.brX = this.mRoot.findViewById(R.id.layout_bottom);
        this.mXu = (TBSpecificationBtn) this.mRoot.findViewById(R.id.next_step);
        this.mXu.setTextSize(R.dimen.tbds34);
        this.mXu.getStyleConfig().pl(l.getDimens(this.hEa, R.dimen.tbds25));
        this.aCi.setOnClickListener(this.hEa);
        this.mXu.setOnClickListener(this.hEa);
        this.brW.setOnClickListener(this.mOnClickListener);
        this.brZ.setOnClickListener(this.hEa);
        this.brX.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.mXs != null && this.mXs.getWriteImagesInfo() != null) {
            this.brZ.setVisibility(this.mXs.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.mRoot.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pb() {
        this.mXo.OV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Pd();
        }
    }

    private void Pc() {
        List<ImageFileInfo> Pt;
        int currentIndex;
        boolean z = true;
        if (this.mXs == null && this.mXo != null) {
            this.mXs = this.mXo.dKd();
        }
        if (this.mXs != null && (Pt = this.mXs.Pt()) != null && (currentIndex = this.mXs.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.mXt = new AlbumImagePagerAdapter(this.hEa);
            this.mViewPager.setAdapter(this.mXt);
            if (this.mCurrentIndex == 0 && Pt != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(Pt, this.mCurrentIndex);
                if (this.mXs.isAdded(imageFileInfo)) {
                    a(this.brW, true);
                } else {
                    a(this.brW, false);
                }
                if (this.mXs != null && this.mXs.getWriteImagesInfo() != null) {
                    z = this.mXs.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.brZ.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.brZ.setVisibility(8);
                } else {
                    this.brZ.setVisibility(0);
                }
            }
            this.mXt.setData(Pt);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cA(this.mXs.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.mXt != null) {
            this.mXt.setData(null);
        }
    }

    public View Pw() {
        return this.aCi;
    }

    public View Px() {
        return this.mXu;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRoot);
        ap.setNavbarIconSrc(this.aCi, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.mXs != null) {
            cA(this.mXs.isOriginalImg());
        }
        if (this.mXt != null) {
            this.mXt.notifyDataSetChanged();
        }
        this.mXu.blA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.hEa != null) {
            ap.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.mXu != null) {
                int count = this.mXs != null ? y.getCount(this.mXs.Pq()) : 0;
                this.mXu.setText(this.hEa.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.mXs != null ? this.mXs.getMaxImagesAllowed() : 1)}));
                this.mXu.setEnabled(count > 0);
            }
        }
    }

    public void f(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo Ee;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.mXt != null && (Ee = this.mXt.Ee(this.mCurrentIndex)) != null && Ee.getFilePath() != null && Ee.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.brW, z);
        }
    }

    private void Pd() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Pc();
        }
    }

    public View Pj() {
        return this.brZ;
    }

    public void cA(boolean z) {
        long j;
        if (this.hEa != null && this.brZ != null) {
            if (this.mXt != null) {
                ImageFileInfo Ee = this.mXt.Ee(this.mCurrentIndex);
                j = Ee != null ? n.getFileSize(Ee.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hEa.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(at.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                ap.setViewTextColor(this.brZ, R.color.cp_link_tip_a);
                this.brZ.setText(sb2);
                this.brZ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.brZ, R.color.cp_cont_f);
            this.brZ.setText(string);
            this.brZ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
