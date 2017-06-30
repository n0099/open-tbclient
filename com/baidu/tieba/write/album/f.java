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
    private View Qr;
    private com.baidu.tbadk.img.b awS;
    private View geD;
    private k geE;
    private ImageView geF;
    private View geG;
    private TextView geH;
    private p gei;
    private AlbumActivity gex;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aCI = -1;
    private View.OnClickListener mOnClickListener = new g(this);
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new h(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gex = (AlbumActivity) getBaseFragmentActivity();
        this.gei = this.gex.brM();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Qr = layoutInflater.inflate(w.j.album_big_image_view, (ViewGroup) null);
        this.geD = this.Qr.findViewById(w.h.img_back);
        this.geD.setOnClickListener(this.gex);
        this.geF = (ImageView) this.Qr.findViewById(w.h.img_choose);
        this.geF.setOnClickListener(this.mOnClickListener);
        this.mViewPager = (ViewPager) this.Qr.findViewById(w.h.viewPager);
        this.awS = this.gex.akX();
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.Qr.findViewById(w.h.album_no_data);
        this.geG = this.Qr.findViewById(w.h.btn_next_step);
        this.geG.setOnClickListener(this.gex);
        this.geH = (TextView) this.Qr.findViewById(w.h.original_select_btn);
        this.geH.setOnClickListener(this.gex);
        if (this.gei.isOriginalImg()) {
            this.gex.brR();
        }
        return this.Qr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bse() {
        if (this.gei.isOriginalImg()) {
            this.gex.brR();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            aen();
        }
    }

    private void bsf() {
        int currentIndex;
        if (this.gei == null && this.gex != null) {
            this.gei = this.gex.brM();
        }
        if (this.gei != null && this.gei.bsm() != null && (currentIndex = this.gei.getCurrentIndex()) >= 0) {
            this.aCI = currentIndex;
            if (this.aCI > this.gei.bsm().size() - 1) {
                this.aCI = this.gei.bsm().size() - 1;
            }
            this.gei.tz(-1);
            this.geE = null;
            this.geE = new k(this.gex, this.awS);
            this.mViewPager.setAdapter(this.geE);
            if (this.aCI == 0 && this.gei.bsm() != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.z.c(this.gei.bsm(), this.aCI);
                if (this.gei.isAdded(imageFileInfo)) {
                    c(this.geF, true);
                } else {
                    c(this.geF, false);
                }
                if (imageFileInfo.isGif()) {
                    this.geH.setVisibility(8);
                } else {
                    this.geH.setVisibility(0);
                }
            }
            this.geE.setData(this.gei.bsm());
            this.mViewPager.setCurrentItem(this.aCI, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.geE != null) {
            this.geE.setData(null);
        }
    }

    public View bgZ() {
        return this.geD;
    }

    public View bsg() {
        return this.geG;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gex.getLayoutMode().ah(i == 1);
        this.gex.getLayoutMode().t(this.Qr);
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
        ImageFileInfo tD;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.geE != null && (tD = this.geE.tD(this.aCI)) != null && tD.getFilePath() != null && tD.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.geF, z);
        }
    }

    private void aen() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bsf();
        }
    }

    public int getCurrentIndex() {
        return this.aCI;
    }

    public View brZ() {
        return this.geH;
    }

    public void b(boolean z, long j) {
        if (this.gex != null && this.geH != null) {
            String string = this.gex.getResources().getString(w.l.original_img);
            if (z) {
                this.geH.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(w.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(com.baidu.tbadk.core.util.aw.G(j));
                    sb.append(")");
                }
                this.geH.setText(sb.toString());
                this.geH.setTextColor(this.gex.getResources().getColor(w.e.cp_link_tip_a));
                return;
            }
            this.geH.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(w.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.geH.setText(string);
            this.geH.setTextColor(this.gex.getResources().getColor(w.e.cp_cont_i));
        }
    }
}
