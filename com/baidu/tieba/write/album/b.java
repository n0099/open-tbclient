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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends BaseFragment {
    private View QE;
    private com.baidu.tbadk.img.b axK;
    private e gyG;
    private AlbumActivity gyW;
    private View gzb;
    private c gzc;
    private ImageView gzd;
    private View gze;
    private TextView gzf;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aDH = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gzc != null && b.this.gyG != null && b.this.gyW != null && b.this.gzc.uf(b.this.aDH)) {
                ImageFileInfo os = b.this.gzc.os(b.this.aDH);
                if (b.this.gyG.isAdded(os)) {
                    if (b.this.gyW.f(os)) {
                        b.this.c(b.this.gzd, false);
                        b.this.gyW.H(b.this.aDH, false);
                    }
                } else if (b.this.gyW.e(os)) {
                    b.this.c(b.this.gzd, true);
                    b.this.gyW.H(b.this.aDH, true);
                }
                b.this.bxY();
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aDH = i;
            if (b.this.gzc != null && b.this.gyG != null) {
                ImageFileInfo os = b.this.gzc.os(b.this.aDH);
                if (b.this.gyG.isAdded(os)) {
                    b.this.c(b.this.gzd, true);
                } else {
                    b.this.c(b.this.gzd, false);
                }
                if (os.isGif()) {
                    b.this.gzf.setVisibility(8);
                } else {
                    b.this.gzf.setVisibility(0);
                }
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
        this.gyW = (AlbumActivity) getBaseFragmentActivity();
        this.gyG = this.gyW.bxK();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.QE = layoutInflater.inflate(d.j.album_big_image_view, (ViewGroup) null);
        this.gzb = this.QE.findViewById(d.h.img_back);
        this.gzb.setOnClickListener(this.gyW);
        this.gzd = (ImageView) this.QE.findViewById(d.h.img_choose);
        this.gzd.setOnClickListener(this.mOnClickListener);
        this.mViewPager = (ViewPager) this.QE.findViewById(d.h.viewPager);
        this.axK = this.gyW.amx();
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.QE.findViewById(d.h.album_no_data);
        this.gze = this.QE.findViewById(d.h.btn_next_step);
        this.gze.setOnClickListener(this.gyW);
        this.gzf = (TextView) this.QE.findViewById(d.h.original_select_btn);
        this.gzf.setOnClickListener(this.gyW);
        if (this.gyG.isOriginalImg()) {
            this.gyW.bxO();
        }
        return this.QE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxY() {
        if (this.gyG.isOriginalImg()) {
            this.gyW.bxO();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            afp();
        }
    }

    private void bxZ() {
        int currentIndex;
        if (this.gyG == null && this.gyW != null) {
            this.gyG = this.gyW.bxK();
        }
        if (this.gyG != null && this.gyG.byd() != null && (currentIndex = this.gyG.getCurrentIndex()) >= 0) {
            this.aDH = currentIndex;
            if (this.aDH > this.gyG.byd().size() - 1) {
                this.aDH = this.gyG.byd().size() - 1;
            }
            this.gyG.ub(-1);
            this.gzc = null;
            this.gzc = new c(this.gyW, this.axK);
            this.mViewPager.setAdapter(this.gzc);
            if (this.aDH == 0 && this.gyG.byd() != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) u.c(this.gyG.byd(), this.aDH);
                if (this.gyG.isAdded(imageFileInfo)) {
                    c(this.gzd, true);
                } else {
                    c(this.gzd, false);
                }
                if (imageFileInfo.isGif()) {
                    this.gzf.setVisibility(8);
                } else {
                    this.gzf.setVisibility(0);
                }
            }
            this.gzc.setData(this.gyG.byd());
            this.mViewPager.setCurrentItem(this.aDH, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gzc != null) {
            this.gzc.setData(null);
        }
    }

    public View bkA() {
        return this.gzb;
    }

    public View bya() {
        return this.gze;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gyW.getLayoutMode().ah(i == 1);
        this.gyW.getLayoutMode().t(this.QE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(d.g.ic_post_edit_select_s);
            } else {
                imageView.setImageResource(d.g.ic_post_edit_select_n);
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo os;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gzc != null && (os = this.gzc.os(this.aDH)) != null && os.getFilePath() != null && os.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.gzd, z);
        }
    }

    private void afp() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bxZ();
        }
    }

    public int getCurrentIndex() {
        return this.aDH;
    }

    public View bxV() {
        return this.gzf;
    }

    public void d(boolean z, long j) {
        if (this.gyW != null && this.gzf != null) {
            String string = this.gyW.getResources().getString(d.l.original_img);
            if (z) {
                this.gzf.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(al.H(j));
                    sb.append(")");
                }
                this.gzf.setText(sb.toString());
                this.gzf.setTextColor(this.gyW.getResources().getColor(d.e.cp_link_tip_a));
                return;
            }
            this.gzf.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gzf.setText(string);
            this.gzf.setTextColor(this.gyW.getResources().getColor(d.e.cp_cont_i));
        }
    }
}
