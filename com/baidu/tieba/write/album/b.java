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
    private View Sd;
    private com.baidu.tbadk.img.b azb;
    private AlbumActivity gAh;
    private View gAm;
    private c gAn;
    private ImageView gAo;
    private View gAp;
    private TextView gAq;
    private e gzR;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aEX = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gAn != null && b.this.gzR != null && b.this.gAh != null && b.this.gAn.uf(b.this.aEX)) {
                ImageFileInfo os = b.this.gAn.os(b.this.aEX);
                if (b.this.gzR.isAdded(os)) {
                    if (b.this.gAh.f(os)) {
                        b.this.c(b.this.gAo, false);
                        b.this.gAh.I(b.this.aEX, false);
                    }
                } else if (b.this.gAh.e(os)) {
                    b.this.c(b.this.gAo, true);
                    b.this.gAh.I(b.this.aEX, true);
                }
                b.this.byf();
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aEX = i;
            if (b.this.gAn != null && b.this.gzR != null) {
                ImageFileInfo os = b.this.gAn.os(b.this.aEX);
                if (b.this.gzR.isAdded(os)) {
                    b.this.c(b.this.gAo, true);
                } else {
                    b.this.c(b.this.gAo, false);
                }
                if (os.isGif()) {
                    b.this.gAq.setVisibility(8);
                } else {
                    b.this.gAq.setVisibility(0);
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
        this.gAh = (AlbumActivity) getBaseFragmentActivity();
        this.gzR = this.gAh.bxR();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Sd = layoutInflater.inflate(d.j.album_big_image_view, (ViewGroup) null);
        this.gAm = this.Sd.findViewById(d.h.img_back);
        this.gAm.setOnClickListener(this.gAh);
        this.gAo = (ImageView) this.Sd.findViewById(d.h.img_choose);
        this.gAo.setOnClickListener(this.mOnClickListener);
        this.mViewPager = (ViewPager) this.Sd.findViewById(d.h.viewPager);
        this.azb = this.gAh.amK();
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.Sd.findViewById(d.h.album_no_data);
        this.gAp = this.Sd.findViewById(d.h.btn_next_step);
        this.gAp.setOnClickListener(this.gAh);
        this.gAq = (TextView) this.Sd.findViewById(d.h.original_select_btn);
        this.gAq.setOnClickListener(this.gAh);
        if (this.gzR.isOriginalImg()) {
            this.gAh.bxV();
        }
        return this.Sd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byf() {
        if (this.gzR.isOriginalImg()) {
            this.gAh.bxV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            afu();
        }
    }

    private void byg() {
        int currentIndex;
        if (this.gzR == null && this.gAh != null) {
            this.gzR = this.gAh.bxR();
        }
        if (this.gzR != null && this.gzR.byk() != null && (currentIndex = this.gzR.getCurrentIndex()) >= 0) {
            this.aEX = currentIndex;
            if (this.aEX > this.gzR.byk().size() - 1) {
                this.aEX = this.gzR.byk().size() - 1;
            }
            this.gzR.ub(-1);
            this.gAn = null;
            this.gAn = new c(this.gAh, this.azb);
            this.mViewPager.setAdapter(this.gAn);
            if (this.aEX == 0 && this.gzR.byk() != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) u.c(this.gzR.byk(), this.aEX);
                if (this.gzR.isAdded(imageFileInfo)) {
                    c(this.gAo, true);
                } else {
                    c(this.gAo, false);
                }
                if (imageFileInfo.isGif()) {
                    this.gAq.setVisibility(8);
                } else {
                    this.gAq.setVisibility(0);
                }
            }
            this.gAn.setData(this.gzR.byk());
            this.mViewPager.setCurrentItem(this.aEX, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gAn != null) {
            this.gAn.setData(null);
        }
    }

    public View bkK() {
        return this.gAm;
    }

    public View byh() {
        return this.gAp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gAh.getLayoutMode().ah(i == 1);
        this.gAh.getLayoutMode().t(this.Sd);
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
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gAn != null && (os = this.gAn.os(this.aEX)) != null && os.getFilePath() != null && os.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.gAo, z);
        }
    }

    private void afu() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            byg();
        }
    }

    public int getCurrentIndex() {
        return this.aEX;
    }

    public View byc() {
        return this.gAq;
    }

    public void d(boolean z, long j) {
        if (this.gAh != null && this.gAq != null) {
            String string = this.gAh.getResources().getString(d.l.original_img);
            if (z) {
                this.gAq.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(al.H(j));
                    sb.append(")");
                }
                this.gAq.setText(sb.toString());
                this.gAq.setTextColor(this.gAh.getResources().getColor(d.e.cp_link_tip_a));
                return;
            }
            this.gAq.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gAq.setText(string);
            this.gAq.setTextColor(this.gAh.getResources().getColor(d.e.cp_cont_i));
        }
    }
}
