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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseFragment {
    private View aGK;
    private e hDa;
    private AlbumActivity hDn;
    private c hDr;
    private ImageView hDs;
    private View hDt;
    private TextView hDu;
    private TextView hDv;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager qW;
    private int btf = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.hDt && view == b.this.hDs && b.this.hDr != null && b.this.hDa != null && b.this.hDn != null) {
                if (b.this.hDa.bFA()) {
                    b.this.hDn.showToast(d.j.album_choose_switch_tip);
                } else if (b.this.hDr.xn(b.this.btf)) {
                    ImageFileInfo sp = b.this.hDr.sp(b.this.btf);
                    if (b.this.hDa.isAdded(sp)) {
                        if (b.this.hDn.d(sp)) {
                            b.this.c(b.this.hDs, false);
                            b.this.hDn.f(sp, false);
                        }
                    } else if (b.this.hDn.c(sp)) {
                        b.this.c(b.this.hDs, true);
                        b.this.hDn.f(sp, true);
                    }
                    b.this.bFv();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.btf = i;
            if (b.this.hDr != null && b.this.hDa != null) {
                ImageFileInfo sp = b.this.hDr.sp(b.this.btf);
                if (b.this.hDa.isAdded(sp)) {
                    b.this.c(b.this.hDs, true);
                } else {
                    b.this.c(b.this.hDs, false);
                }
                if (sp == null || !sp.isGif()) {
                    b.this.hDv.setVisibility(0);
                } else {
                    b.this.hDv.setVisibility(8);
                }
                b.this.nx(b.this.hDa.isOriginalImg());
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
        this.hDn = (AlbumActivity) getBaseFragmentActivity();
        this.hDa = this.hDn.bFk();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aGK = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.aGK.findViewById(d.g.img_back);
        this.hDs = (ImageView) this.aGK.findViewById(d.g.img_choose);
        this.qW = (ViewPager) this.aGK.findViewById(d.g.viewPager);
        this.mNoDataView = this.aGK.findViewById(d.g.album_no_data);
        this.hDu = (TextView) this.aGK.findViewById(d.g.btn_next_step);
        this.hDv = (TextView) this.aGK.findViewById(d.g.original_select_btn);
        this.hDt = this.aGK.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hDn);
        this.hDu.setOnClickListener(this.hDn);
        this.hDs.setOnClickListener(this.mOnClickListener);
        this.hDv.setOnClickListener(this.hDn);
        this.hDt.setOnClickListener(this.mOnClickListener);
        this.qW.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.aGK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFv() {
        this.hDn.bFi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Wy();
        }
    }

    private void bFw() {
        List<ImageFileInfo> bFE;
        int currentIndex;
        if (this.hDa == null && this.hDn != null) {
            this.hDa = this.hDn.bFk();
        }
        if (this.hDa != null && (bFE = this.hDa.bFE()) != null && (currentIndex = this.hDa.getCurrentIndex()) >= 0) {
            this.btf = currentIndex;
            this.hDr = new c(this.hDn);
            this.qW.setAdapter(this.hDr);
            if (this.btf == 0 && bFE != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(bFE, this.btf);
                if (this.hDa.isAdded(imageFileInfo)) {
                    c(this.hDs, true);
                } else {
                    c(this.hDs, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hDv.setVisibility(8);
                } else {
                    this.hDv.setVisibility(0);
                }
            }
            this.hDr.setData(bFE);
            this.qW.setCurrentItem(this.btf, false);
            nx(this.hDa.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hDr != null) {
            this.hDr.setData(null);
        }
    }

    public View bpR() {
        return this.mBackBtn;
    }

    public View bFx() {
        return this.hDu;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.aGK);
        aj.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hDa != null) {
            nx(this.hDa.isOriginalImg());
        }
        if (this.hDr != null) {
            this.hDr.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hDn != null) {
            aj.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hDu != null) {
                int D = this.hDa != null ? v.D(this.hDa.bFC()) : 0;
                this.hDu.setText(this.hDn.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(D), Integer.valueOf(this.hDa.getMaxImagesAllowed())}));
                this.hDu.setEnabled(D > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sp;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hDr != null && (sp = this.hDr.sp(this.btf)) != null && sp.getFilePath() != null && sp.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hDs, z);
        }
    }

    private void Wy() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.qW.setVisibility(0);
            bFw();
        }
    }

    public View bFt() {
        return this.hDv;
    }

    public void nx(boolean z) {
        long j;
        if (this.hDn != null && this.hDv != null) {
            if (this.hDr != null) {
                ImageFileInfo sp = this.hDr.sp(this.btf);
                j = sp != null ? com.baidu.tbadk.core.util.k.dK(sp.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hDn.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.O(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                aj.r(this.hDv, d.C0108d.cp_link_tip_a);
                this.hDv.setText(sb2);
                this.hDv.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            aj.r(this.hDv, d.C0108d.cp_cont_f);
            this.hDv.setText(string);
            this.hDv.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
