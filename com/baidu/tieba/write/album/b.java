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
    private View Ry;
    private ViewPager aDT;
    private com.baidu.tbadk.img.b ayc;
    private AlbumActivity gRD;
    private View gRI;
    private c gRJ;
    private ImageView gRK;
    private TextView gRL;
    private TextView gRM;
    private View gRN;
    private e gRn;
    private View mNoDataView;
    private int aEm = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.gRN && view == b.this.gRK && b.this.gRJ != null && b.this.gRn != null && b.this.gRD != null && b.this.gRJ.vm(b.this.aEm)) {
                ImageFileInfo pj = b.this.gRJ.pj(b.this.aEm);
                if (b.this.gRn.isAdded(pj)) {
                    if (b.this.gRD.e(pj)) {
                        b.this.c(b.this.gRK, false);
                        b.this.gRD.H(b.this.aEm, false);
                    }
                } else if (b.this.gRD.d(pj)) {
                    b.this.c(b.this.gRK, true);
                    b.this.gRD.H(b.this.aEm, true);
                }
                b.this.bCZ();
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aEm = i;
            if (b.this.gRJ != null && b.this.gRn != null) {
                ImageFileInfo pj = b.this.gRJ.pj(b.this.aEm);
                if (b.this.gRn.isAdded(pj)) {
                    b.this.c(b.this.gRK, true);
                } else {
                    b.this.c(b.this.gRK, false);
                }
                if (pj.isGif()) {
                    b.this.gRM.setVisibility(8);
                } else {
                    b.this.gRM.setVisibility(0);
                }
                if (pj != null) {
                    b.this.nu(b.this.gRn.isOriginalImg());
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
        this.gRD = (AlbumActivity) getBaseFragmentActivity();
        this.gRn = this.gRD.bCM();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Ry = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.gRI = this.Ry.findViewById(d.g.img_back);
        this.gRI.setOnClickListener(this.gRD);
        this.gRK = (ImageView) this.Ry.findViewById(d.g.img_choose);
        this.gRK.setOnClickListener(this.mOnClickListener);
        this.aDT = (ViewPager) this.Ry.findViewById(d.g.viewPager);
        this.ayc = this.gRD.aOP();
        this.aDT.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.Ry.findViewById(d.g.album_no_data);
        this.gRL = (TextView) this.Ry.findViewById(d.g.btn_next_step);
        this.gRL.setOnClickListener(this.gRD);
        this.gRM = (TextView) this.Ry.findViewById(d.g.original_select_btn);
        this.gRM.setOnClickListener(this.gRD);
        this.gRN = this.Ry.findViewById(d.g.layout_bottom);
        this.gRN.setOnClickListener(this.mOnClickListener);
        return this.Ry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCZ() {
        if (this.gRn.isOriginalImg()) {
            this.gRD.bCL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Oa();
        }
    }

    private void bDa() {
        int currentIndex;
        if (this.gRn == null && this.gRD != null) {
            this.gRn = this.gRD.bCM();
        }
        if (this.gRn != null && this.gRn.bDe() != null && (currentIndex = this.gRn.getCurrentIndex()) >= 0) {
            this.aEm = currentIndex;
            if (this.aEm > this.gRn.bDe().size() - 1) {
                this.aEm = this.gRn.bDe().size() - 1;
            }
            this.gRn.setCurrentIndex(-1);
            this.gRJ = null;
            this.gRJ = new c(this.gRD, this.ayc);
            this.aDT.setAdapter(this.gRJ);
            if (this.aEm == 0 && this.gRn.bDe() != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.gRn.bDe(), this.aEm);
                if (this.gRn.isAdded(imageFileInfo)) {
                    c(this.gRK, true);
                } else {
                    c(this.gRK, false);
                }
                if (imageFileInfo.isGif()) {
                    this.gRM.setVisibility(8);
                } else {
                    this.gRM.setVisibility(0);
                }
            }
            this.gRJ.setData(this.gRn.bDe());
            this.aDT.setCurrentItem(this.aEm, false);
            if (this.gRn.isOriginalImg()) {
                nu(this.gRn.isOriginalImg());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gRJ != null) {
            this.gRJ.setData(null);
        }
    }

    public View bmj() {
        return this.gRI;
    }

    public View bDb() {
        return this.gRL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gRD.getLayoutMode().ag(i == 1);
        this.gRD.getLayoutMode().t(this.Ry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(d.f.ic_post_edit_select_s);
            } else {
                imageView.setImageResource(d.f.ic_post_edit_select_n);
            }
            if (this.gRL != null && this.gRD != null) {
                int u = this.gRn != null ? v.u(this.gRn.bDc()) : 0;
                this.gRL.setText(this.gRD.getString(d.j.image_selected_list_count, new Object[]{Integer.valueOf(u)}));
                this.gRL.setEnabled(u > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo pj;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gRJ != null && (pj = this.gRJ.pj(this.aEm)) != null && pj.getFilePath() != null && pj.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.gRK, z);
        }
    }

    private void Oa() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.aDT.setVisibility(0);
            bDa();
        }
    }

    public int getCurrentIndex() {
        return this.aEm;
    }

    public View bCV() {
        return this.gRM;
    }

    public void nu(boolean z) {
        long j;
        if (this.gRD != null && this.gRM != null) {
            if (this.gRJ != null) {
                ImageFileInfo pj = this.gRJ.pj(this.aEm);
                j = pj != null ? com.baidu.tbadk.core.util.k.dx(pj.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.gRD.getResources().getString(d.j.original_img);
            if (z) {
                this.gRM.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.G(j));
                    sb.append(")");
                }
                this.gRM.setText(sb.toString());
                this.gRM.setTextColor(this.gRD.getResources().getColor(d.C0080d.cp_link_tip_a));
                return;
            }
            this.gRM.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gRM.setText(string);
            this.gRM.setTextColor(this.gRD.getResources().getColor(d.C0080d.cp_cont_i));
        }
    }
}
