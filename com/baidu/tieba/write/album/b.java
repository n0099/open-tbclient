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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends BaseFragment {
    private View Rt;
    private com.baidu.tbadk.img.b axw;
    private AlbumActivity gGM;
    private View gGR;
    private c gGS;
    private ImageView gGT;
    private TextView gGU;
    private TextView gGV;
    private View gGW;
    private e gGx;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aDG = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.gGW && view == b.this.gGT && b.this.gGS != null && b.this.gGx != null && b.this.gGM != null && b.this.gGS.uP(b.this.aDG)) {
                ImageFileInfo oP = b.this.gGS.oP(b.this.aDG);
                if (b.this.gGx.isAdded(oP)) {
                    if (b.this.gGM.e(oP)) {
                        b.this.c(b.this.gGT, false);
                        b.this.gGM.F(b.this.aDG, false);
                    }
                } else if (b.this.gGM.d(oP)) {
                    b.this.c(b.this.gGT, true);
                    b.this.gGM.F(b.this.aDG, true);
                }
                b.this.bzv();
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aDG = i;
            if (b.this.gGS != null && b.this.gGx != null) {
                ImageFileInfo oP = b.this.gGS.oP(b.this.aDG);
                if (b.this.gGx.isAdded(oP)) {
                    b.this.c(b.this.gGT, true);
                } else {
                    b.this.c(b.this.gGT, false);
                }
                if (oP.isGif()) {
                    b.this.gGV.setVisibility(8);
                } else {
                    b.this.gGV.setVisibility(0);
                }
                if (oP != null) {
                    b.this.np(b.this.gGx.isOriginalImg());
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
        this.gGM = (AlbumActivity) getBaseFragmentActivity();
        this.gGx = this.gGM.bzi();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Rt = layoutInflater.inflate(d.j.album_big_image_view, (ViewGroup) null);
        this.gGR = this.Rt.findViewById(d.h.img_back);
        this.gGR.setOnClickListener(this.gGM);
        this.gGT = (ImageView) this.Rt.findViewById(d.h.img_choose);
        this.gGT.setOnClickListener(this.mOnClickListener);
        this.mViewPager = (ViewPager) this.Rt.findViewById(d.h.viewPager);
        this.axw = this.gGM.aLU();
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.Rt.findViewById(d.h.album_no_data);
        this.gGU = (TextView) this.Rt.findViewById(d.h.btn_next_step);
        this.gGU.setOnClickListener(this.gGM);
        this.gGV = (TextView) this.Rt.findViewById(d.h.original_select_btn);
        this.gGV.setOnClickListener(this.gGM);
        this.gGW = this.Rt.findViewById(d.h.layout_bottom);
        this.gGW.setOnClickListener(this.mOnClickListener);
        return this.Rt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzv() {
        if (this.gGx.isOriginalImg()) {
            this.gGM.bzh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            NI();
        }
    }

    private void bzw() {
        int currentIndex;
        if (this.gGx == null && this.gGM != null) {
            this.gGx = this.gGM.bzi();
        }
        if (this.gGx != null && this.gGx.bzA() != null && (currentIndex = this.gGx.getCurrentIndex()) >= 0) {
            this.aDG = currentIndex;
            if (this.aDG > this.gGx.bzA().size() - 1) {
                this.aDG = this.gGx.bzA().size() - 1;
            }
            this.gGx.setCurrentIndex(-1);
            this.gGS = null;
            this.gGS = new c(this.gGM, this.axw);
            this.mViewPager.setAdapter(this.gGS);
            if (this.aDG == 0 && this.gGx.bzA() != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.gGx.bzA(), this.aDG);
                if (this.gGx.isAdded(imageFileInfo)) {
                    c(this.gGT, true);
                } else {
                    c(this.gGT, false);
                }
                if (imageFileInfo.isGif()) {
                    this.gGV.setVisibility(8);
                } else {
                    this.gGV.setVisibility(0);
                }
            }
            this.gGS.setData(this.gGx.bzA());
            this.mViewPager.setCurrentItem(this.aDG, false);
            if (this.gGx.isOriginalImg()) {
                np(this.gGx.isOriginalImg());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gGS != null) {
            this.gGS.setData(null);
        }
    }

    public View biW() {
        return this.gGR;
    }

    public View bzx() {
        return this.gGU;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gGM.getLayoutMode().ai(i == 1);
        this.gGM.getLayoutMode().t(this.Rt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(d.g.ic_post_edit_select_s);
            } else {
                imageView.setImageResource(d.g.ic_post_edit_select_n);
            }
            if (this.gGU != null && this.gGM != null) {
                int t = this.gGx != null ? v.t(this.gGx.bzy()) : 0;
                this.gGU.setText(this.gGM.getString(d.l.image_selected_list_count, new Object[]{Integer.valueOf(t)}));
                this.gGU.setEnabled(t > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo oP;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gGS != null && (oP = this.gGS.oP(this.aDG)) != null && oP.getFilePath() != null && oP.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.gGT, z);
        }
    }

    private void NI() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bzw();
        }
    }

    public int getCurrentIndex() {
        return this.aDG;
    }

    public View bzr() {
        return this.gGV;
    }

    public void np(boolean z) {
        long j;
        if (this.gGM != null && this.gGV != null) {
            if (this.gGS != null) {
                ImageFileInfo oP = this.gGS.oP(this.aDG);
                j = oP != null ? com.baidu.tbadk.core.util.k.dr(oP.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.gGM.getResources().getString(d.l.original_img);
            if (z) {
                this.gGV.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.F(j));
                    sb.append(")");
                }
                this.gGV.setText(sb.toString());
                this.gGV.setTextColor(this.gGM.getResources().getColor(d.e.cp_link_tip_a));
                return;
            }
            this.gGV.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gGV.setText(string);
            this.gGV.setTextColor(this.gGM.getResources().getColor(d.e.cp_cont_i));
        }
    }
}
