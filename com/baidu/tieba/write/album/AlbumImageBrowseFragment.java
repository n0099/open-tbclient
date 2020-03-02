package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes13.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView Wg;
    private ImageView aCm;
    private View aCn;
    private TextView aCo;
    private TextView aCp;
    private c kMH;
    private AlbumActivity kMN;
    private AlbumImagePagerAdapter kMQ;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.aCn && view == AlbumImageBrowseFragment.this.aCm && AlbumImageBrowseFragment.this.kMQ != null && AlbumImageBrowseFragment.this.kMH != null && AlbumImageBrowseFragment.this.kMN != null) {
                if (AlbumImageBrowseFragment.this.kMH.AE()) {
                    AlbumImageBrowseFragment.this.kMN.showToast(R.string.album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.kMQ.cQ(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo yq = AlbumImageBrowseFragment.this.kMQ.yq(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.kMH.isAdded(yq)) {
                        if (AlbumImageBrowseFragment.this.kMN.f(yq)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCm, false);
                            AlbumImageBrowseFragment.this.kMN.f(yq, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.kMN.e(yq)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCm, true);
                        AlbumImageBrowseFragment.this.kMN.f(yq, true);
                    }
                    AlbumImageBrowseFragment.this.Ay();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.kMQ != null && AlbumImageBrowseFragment.this.kMH != null) {
                ImageFileInfo yq = AlbumImageBrowseFragment.this.kMQ.yq(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.kMH.isAdded(yq)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCm, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aCm, false);
                }
                if (AlbumImageBrowseFragment.this.kMH != null && AlbumImageBrowseFragment.this.kMH.getWriteImagesInfo() != null) {
                    z = AlbumImageBrowseFragment.this.kMH.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    AlbumImageBrowseFragment.this.aCp.setVisibility(8);
                } else if (yq == null || !yq.isGif()) {
                    AlbumImageBrowseFragment.this.aCp.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.aCp.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bt(AlbumImageBrowseFragment.this.kMH.isOriginalImg());
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
        this.kMN = (AlbumActivity) getBaseFragmentActivity();
        this.kMH = this.kMN.cUA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.Wg = (ImageView) this.mRoot.findViewById(R.id.img_back);
        this.aCm = (ImageView) this.mRoot.findViewById(R.id.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(R.id.viewPager);
        this.mNoDataView = this.mRoot.findViewById(R.id.album_no_data);
        this.aCo = (TextView) this.mRoot.findViewById(R.id.btn_next_step);
        this.aCp = (TextView) this.mRoot.findViewById(R.id.original_select_btn);
        this.aCn = this.mRoot.findViewById(R.id.layout_bottom);
        this.Wg.setOnClickListener(this.kMN);
        this.aCo.setOnClickListener(this.kMN);
        this.aCm.setOnClickListener(this.mOnClickListener);
        this.aCp.setOnClickListener(this.kMN);
        this.aCn.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kMH != null && this.kMH.getWriteImagesInfo() != null) {
            this.aCp.setVisibility(this.kMH.getWriteImagesInfo().isEnableChooseOriginalImg() ? 0 : 4);
        }
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ay() {
        this.kMN.Al();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            AC();
        }
    }

    private void Az() {
        List<ImageFileInfo> AJ;
        int currentIndex;
        boolean z = true;
        if (this.kMH == null && this.kMN != null) {
            this.kMH = this.kMN.cUA();
        }
        if (this.kMH != null && (AJ = this.kMH.AJ()) != null && (currentIndex = this.kMH.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.kMQ = new AlbumImagePagerAdapter(this.kMN);
            this.mViewPager.setAdapter(this.kMQ);
            if (this.mCurrentIndex == 0 && AJ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(AJ, this.mCurrentIndex);
                if (this.kMH.isAdded(imageFileInfo)) {
                    a(this.aCm, true);
                } else {
                    a(this.aCm, false);
                }
                if (this.kMH != null && this.kMH.getWriteImagesInfo() != null) {
                    z = this.kMH.getWriteImagesInfo().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.aCp.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.aCp.setVisibility(8);
                } else {
                    this.aCp.setVisibility(0);
                }
            }
            this.kMQ.setData(AJ);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bt(this.kMH.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.kMQ != null) {
            this.kMQ.setData(null);
        }
    }

    public View AA() {
        return this.Wg;
    }

    public View AB() {
        return this.aCo;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mRoot);
        am.setNavbarIconSrc(this.Wg, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        if (this.kMH != null) {
            bt(this.kMH.isOriginalImg());
        }
        if (this.kMQ != null) {
            this.kMQ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.kMN != null) {
            am.setImageResource(imageView, z ? R.drawable.ic_post_edit_select_s : R.drawable.icon_image_clear_select);
            if (this.aCo != null) {
                int count = this.kMH != null ? v.getCount(this.kMH.AG()) : 0;
                this.aCo.setText(this.kMN.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.kMH != null ? this.kMH.getMaxImagesAllowed() : 1)}));
                this.aCo.setEnabled(count > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo yq;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.kMQ != null && (yq = this.kMQ.yq(this.mCurrentIndex)) != null && yq.getFilePath() != null && yq.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aCm, z);
        }
    }

    private void AC() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Az();
        }
    }

    public View Aw() {
        return this.aCp;
    }

    public void bt(boolean z) {
        long j;
        if (this.kMN != null && this.aCp != null) {
            if (this.kMQ != null) {
                ImageFileInfo yq = this.kMQ.yq(this.mCurrentIndex);
                j = yq != null ? m.getFileSize(yq.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.kMN.getResources().getString(R.string.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(aq.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                am.setViewTextColor(this.aCp, (int) R.color.cp_link_tip_a);
                this.aCp.setText(sb2);
                this.aCp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            am.setViewTextColor(this.aCp, (int) R.color.cp_cont_f);
            this.aCp.setText(string);
            this.aCp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
