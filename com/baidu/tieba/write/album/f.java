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
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f extends BaseFragment {
    private View Qx;
    private com.baidu.tbadk.img.b avP;
    private AlbumActivity fTN;
    private View fTT;
    private k fTU;
    private ImageView fTV;
    private View fTW;
    private TextView fTX;
    private p fTx;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aBF = -1;
    private View.OnClickListener mOnClickListener = new g(this);
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new h(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fTN = (AlbumActivity) getBaseFragmentActivity();
        this.fTx = this.fTN.bnp();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Qx = layoutInflater.inflate(w.j.album_big_image_view, (ViewGroup) null);
        this.fTT = this.Qx.findViewById(w.h.img_back);
        this.fTT.setOnClickListener(this.fTN);
        this.fTV = (ImageView) this.Qx.findViewById(w.h.img_choose);
        this.fTV.setOnClickListener(this.mOnClickListener);
        this.mViewPager = (ViewPager) this.Qx.findViewById(w.h.viewPager);
        this.avP = this.fTN.ahn();
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.Qx.findViewById(w.h.album_no_data);
        this.fTW = this.Qx.findViewById(w.h.btn_next_step);
        this.fTW.setOnClickListener(this.fTN);
        this.fTX = (TextView) this.Qx.findViewById(w.h.original_select_btn);
        this.fTX.setOnClickListener(this.fTN);
        if (this.fTx.isOriginalImg()) {
            this.fTN.bnu();
        }
        return this.Qx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnH() {
        if (this.fTx.isOriginalImg()) {
            this.fTN.bnu();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aax();
        }
    }

    private void bnI() {
        int currentIndex;
        if (this.fTx == null && this.fTN != null) {
            this.fTx = this.fTN.bnp();
        }
        if (this.fTx != null && this.fTx.bnP() != null && (currentIndex = this.fTx.getCurrentIndex()) >= 0) {
            this.aBF = currentIndex;
            if (this.aBF > this.fTx.bnP().size() - 1) {
                this.aBF = this.fTx.bnP().size() - 1;
            }
            this.fTx.te(-1);
            this.fTU = null;
            this.fTU = new k(this.fTN, this.avP);
            this.mViewPager.setAdapter(this.fTU);
            if (this.aBF == 0 && this.fTx.bnP() != null) {
                if (this.fTx.isAdded((ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.fTx.bnP(), this.aBF))) {
                    c(this.fTV, true);
                } else {
                    c(this.fTV, false);
                }
            }
            this.fTU.setData(this.fTx.bnP());
            this.mViewPager.setCurrentItem(this.aBF, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.fTU != null) {
            this.fTU.setData(null);
        }
    }

    public View bcK() {
        return this.fTT;
    }

    public View bnJ() {
        return this.fTW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fTN.getLayoutMode().ah(i == 1);
        this.fTN.getLayoutMode().t(this.Qx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(w.g.ic_post_edit_select_s);
            } else {
                imageView.setImageResource(w.g.ic_post_edit_select_n);
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo ti;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.fTU != null && (ti = this.fTU.ti(this.aBF)) != null && ti.getFilePath() != null && ti.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.fTV, z);
        }
    }

    private void aax() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bnI();
        }
    }

    public int getCurrentIndex() {
        return this.aBF;
    }

    public View bnC() {
        return this.fTX;
    }

    public void b(boolean z, long j) {
        if (this.fTN != null && this.fTX != null) {
            String string = this.fTN.getResources().getString(w.l.original_img);
            if (z) {
                this.fTX.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(com.baidu.tbadk.core.util.au.F(j));
                    sb.append(")");
                }
                this.fTX.setText(sb.toString());
                this.fTX.setTextColor(this.fTN.getResources().getColor(w.e.cp_link_tip_a));
                return;
            }
            this.fTX.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.fTX.setText(string);
            this.fTX.setTextColor(this.fTN.getResources().getColor(w.e.cp_cont_i));
        }
    }
}
