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
    private View aHS;
    private c hEB;
    private ImageView hEC;
    private View hED;
    private TextView hEE;
    private TextView hEF;
    private e hEk;
    private AlbumActivity hEx;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager qV;
    private int bvf = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.hED && view == b.this.hEC && b.this.hEB != null && b.this.hEk != null && b.this.hEx != null) {
                if (b.this.hEk.bGn()) {
                    b.this.hEx.showToast(d.j.album_choose_switch_tip);
                } else if (b.this.hEB.xn(b.this.bvf)) {
                    ImageFileInfo st = b.this.hEB.st(b.this.bvf);
                    if (b.this.hEk.isAdded(st)) {
                        if (b.this.hEx.d(st)) {
                            b.this.c(b.this.hEC, false);
                            b.this.hEx.f(st, false);
                        }
                    } else if (b.this.hEx.c(st)) {
                        b.this.c(b.this.hEC, true);
                        b.this.hEx.f(st, true);
                    }
                    b.this.bGi();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.bvf = i;
            if (b.this.hEB != null && b.this.hEk != null) {
                ImageFileInfo st = b.this.hEB.st(b.this.bvf);
                if (b.this.hEk.isAdded(st)) {
                    b.this.c(b.this.hEC, true);
                } else {
                    b.this.c(b.this.hEC, false);
                }
                if (st == null || !st.isGif()) {
                    b.this.hEF.setVisibility(0);
                } else {
                    b.this.hEF.setVisibility(8);
                }
                b.this.nE(b.this.hEk.isOriginalImg());
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
        this.hEx = (AlbumActivity) getBaseFragmentActivity();
        this.hEk = this.hEx.bFX();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aHS = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.aHS.findViewById(d.g.img_back);
        this.hEC = (ImageView) this.aHS.findViewById(d.g.img_choose);
        this.qV = (ViewPager) this.aHS.findViewById(d.g.viewPager);
        this.mNoDataView = this.aHS.findViewById(d.g.album_no_data);
        this.hEE = (TextView) this.aHS.findViewById(d.g.btn_next_step);
        this.hEF = (TextView) this.aHS.findViewById(d.g.original_select_btn);
        this.hED = this.aHS.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hEx);
        this.hEE.setOnClickListener(this.hEx);
        this.hEC.setOnClickListener(this.mOnClickListener);
        this.hEF.setOnClickListener(this.hEx);
        this.hED.setOnClickListener(this.mOnClickListener);
        this.qV.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.aHS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGi() {
        this.hEx.bFV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Xo();
        }
    }

    private void bGj() {
        List<ImageFileInfo> bGr;
        int currentIndex;
        if (this.hEk == null && this.hEx != null) {
            this.hEk = this.hEx.bFX();
        }
        if (this.hEk != null && (bGr = this.hEk.bGr()) != null && (currentIndex = this.hEk.getCurrentIndex()) >= 0) {
            this.bvf = currentIndex;
            this.hEB = new c(this.hEx);
            this.qV.setAdapter(this.hEB);
            if (this.bvf == 0 && bGr != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(bGr, this.bvf);
                if (this.hEk.isAdded(imageFileInfo)) {
                    c(this.hEC, true);
                } else {
                    c(this.hEC, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hEF.setVisibility(8);
                } else {
                    this.hEF.setVisibility(0);
                }
            }
            this.hEB.setData(bGr);
            this.qV.setCurrentItem(this.bvf, false);
            nE(this.hEk.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hEB != null) {
            this.hEB.setData(null);
        }
    }

    public View brl() {
        return this.mBackBtn;
    }

    public View bGk() {
        return this.hEE;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.aHS);
        aj.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hEk != null) {
            nE(this.hEk.isOriginalImg());
        }
        if (this.hEB != null) {
            this.hEB.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hEx != null) {
            aj.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hEE != null) {
                int D = this.hEk != null ? v.D(this.hEk.bGp()) : 0;
                this.hEE.setText(this.hEx.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(D), Integer.valueOf(this.hEk != null ? this.hEk.getMaxImagesAllowed() : 1)}));
                this.hEE.setEnabled(D > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo st;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hEB != null && (st = this.hEB.st(this.bvf)) != null && st.getFilePath() != null && st.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hEC, z);
        }
    }

    private void Xo() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.qV.setVisibility(0);
            bGj();
        }
    }

    public View bGg() {
        return this.hEF;
    }

    public void nE(boolean z) {
        long j;
        if (this.hEx != null && this.hEF != null) {
            if (this.hEB != null) {
                ImageFileInfo st = this.hEB.st(this.bvf);
                j = st != null ? com.baidu.tbadk.core.util.k.dV(st.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hEx.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.O(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                aj.r(this.hEF, d.C0141d.cp_link_tip_a);
                this.hEF.setText(sb2);
                this.hEF.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            aj.r(this.hEF, d.C0141d.cp_cont_f);
            this.hEF.setText(string);
            this.hEF.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
