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
    private AlbumActivity gGN;
    private View gGS;
    private c gGT;
    private ImageView gGU;
    private TextView gGV;
    private TextView gGW;
    private View gGX;
    private e gGy;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aDG = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.gGX && view == b.this.gGU && b.this.gGT != null && b.this.gGy != null && b.this.gGN != null && b.this.gGT.uP(b.this.aDG)) {
                ImageFileInfo oP = b.this.gGT.oP(b.this.aDG);
                if (b.this.gGy.isAdded(oP)) {
                    if (b.this.gGN.e(oP)) {
                        b.this.c(b.this.gGU, false);
                        b.this.gGN.F(b.this.aDG, false);
                    }
                } else if (b.this.gGN.d(oP)) {
                    b.this.c(b.this.gGU, true);
                    b.this.gGN.F(b.this.aDG, true);
                }
                b.this.bzw();
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aDG = i;
            if (b.this.gGT != null && b.this.gGy != null) {
                ImageFileInfo oP = b.this.gGT.oP(b.this.aDG);
                if (b.this.gGy.isAdded(oP)) {
                    b.this.c(b.this.gGU, true);
                } else {
                    b.this.c(b.this.gGU, false);
                }
                if (oP.isGif()) {
                    b.this.gGW.setVisibility(8);
                } else {
                    b.this.gGW.setVisibility(0);
                }
                if (oP != null) {
                    b.this.np(b.this.gGy.isOriginalImg());
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
        this.gGN = (AlbumActivity) getBaseFragmentActivity();
        this.gGy = this.gGN.bzj();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Rt = layoutInflater.inflate(d.j.album_big_image_view, (ViewGroup) null);
        this.gGS = this.Rt.findViewById(d.h.img_back);
        this.gGS.setOnClickListener(this.gGN);
        this.gGU = (ImageView) this.Rt.findViewById(d.h.img_choose);
        this.gGU.setOnClickListener(this.mOnClickListener);
        this.mViewPager = (ViewPager) this.Rt.findViewById(d.h.viewPager);
        this.axw = this.gGN.aLU();
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.Rt.findViewById(d.h.album_no_data);
        this.gGV = (TextView) this.Rt.findViewById(d.h.btn_next_step);
        this.gGV.setOnClickListener(this.gGN);
        this.gGW = (TextView) this.Rt.findViewById(d.h.original_select_btn);
        this.gGW.setOnClickListener(this.gGN);
        this.gGX = this.Rt.findViewById(d.h.layout_bottom);
        this.gGX.setOnClickListener(this.mOnClickListener);
        return this.Rt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzw() {
        if (this.gGy.isOriginalImg()) {
            this.gGN.bzi();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            NI();
        }
    }

    private void bzx() {
        int currentIndex;
        if (this.gGy == null && this.gGN != null) {
            this.gGy = this.gGN.bzj();
        }
        if (this.gGy != null && this.gGy.bzB() != null && (currentIndex = this.gGy.getCurrentIndex()) >= 0) {
            this.aDG = currentIndex;
            if (this.aDG > this.gGy.bzB().size() - 1) {
                this.aDG = this.gGy.bzB().size() - 1;
            }
            this.gGy.setCurrentIndex(-1);
            this.gGT = null;
            this.gGT = new c(this.gGN, this.axw);
            this.mViewPager.setAdapter(this.gGT);
            if (this.aDG == 0 && this.gGy.bzB() != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.gGy.bzB(), this.aDG);
                if (this.gGy.isAdded(imageFileInfo)) {
                    c(this.gGU, true);
                } else {
                    c(this.gGU, false);
                }
                if (imageFileInfo.isGif()) {
                    this.gGW.setVisibility(8);
                } else {
                    this.gGW.setVisibility(0);
                }
            }
            this.gGT.setData(this.gGy.bzB());
            this.mViewPager.setCurrentItem(this.aDG, false);
            if (this.gGy.isOriginalImg()) {
                np(this.gGy.isOriginalImg());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gGT != null) {
            this.gGT.setData(null);
        }
    }

    public View biX() {
        return this.gGS;
    }

    public View bzy() {
        return this.gGV;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gGN.getLayoutMode().ai(i == 1);
        this.gGN.getLayoutMode().t(this.Rt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(d.g.ic_post_edit_select_s);
            } else {
                imageView.setImageResource(d.g.ic_post_edit_select_n);
            }
            if (this.gGV != null && this.gGN != null) {
                int t = this.gGy != null ? v.t(this.gGy.bzz()) : 0;
                this.gGV.setText(this.gGN.getString(d.l.image_selected_list_count, new Object[]{Integer.valueOf(t)}));
                this.gGV.setEnabled(t > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo oP;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gGT != null && (oP = this.gGT.oP(this.aDG)) != null && oP.getFilePath() != null && oP.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.gGU, z);
        }
    }

    private void NI() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bzx();
        }
    }

    public int getCurrentIndex() {
        return this.aDG;
    }

    public View bzs() {
        return this.gGW;
    }

    public void np(boolean z) {
        long j;
        if (this.gGN != null && this.gGW != null) {
            if (this.gGT != null) {
                ImageFileInfo oP = this.gGT.oP(this.aDG);
                j = oP != null ? com.baidu.tbadk.core.util.k.dr(oP.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.gGN.getResources().getString(d.l.original_img);
            if (z) {
                this.gGW.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.F(j));
                    sb.append(")");
                }
                this.gGW.setText(sb.toString());
                this.gGW.setTextColor(this.gGN.getResources().getColor(d.e.cp_link_tip_a));
                return;
            }
            this.gGW.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gGW.setText(string);
            this.gGW.setTextColor(this.gGN.getResources().getColor(d.e.cp_cont_i));
        }
    }
}
