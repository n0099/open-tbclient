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
    private View Se;
    private ViewPager aEy;
    private e heY;
    private AlbumActivity hfk;
    private c hfo;
    private ImageView hfp;
    private View hfq;
    private TextView hfr;
    private TextView hfs;
    private ImageView mBackBtn;
    private View mNoDataView;
    private int aES = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.hfq && view == b.this.hfp && b.this.hfo != null && b.this.heY != null && b.this.hfk != null) {
                if (b.this.heY.bGp()) {
                    b.this.hfk.showToast(d.j.album_choose_switch_tip);
                } else if (b.this.hfo.vT(b.this.aES)) {
                    ImageFileInfo pC = b.this.hfo.pC(b.this.aES);
                    if (b.this.heY.isAdded(pC)) {
                        if (b.this.hfk.d(pC)) {
                            b.this.c(b.this.hfp, false);
                            b.this.hfk.f(pC, false);
                        }
                    } else if (b.this.hfk.c(pC)) {
                        b.this.c(b.this.hfp, true);
                        b.this.hfk.f(pC, true);
                    }
                    b.this.bGk();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aES = i;
            if (b.this.hfo != null && b.this.heY != null) {
                ImageFileInfo pC = b.this.hfo.pC(b.this.aES);
                if (b.this.heY.isAdded(pC)) {
                    b.this.c(b.this.hfp, true);
                } else {
                    b.this.c(b.this.hfp, false);
                }
                if (pC == null || !pC.isGif()) {
                    b.this.hfs.setVisibility(0);
                } else {
                    b.this.hfs.setVisibility(8);
                }
                b.this.nX(b.this.heY.isOriginalImg());
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
        this.hfk = (AlbumActivity) getBaseFragmentActivity();
        this.heY = this.hfk.bFZ();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Se = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.Se.findViewById(d.g.img_back);
        this.hfp = (ImageView) this.Se.findViewById(d.g.img_choose);
        this.aEy = (ViewPager) this.Se.findViewById(d.g.viewPager);
        this.mNoDataView = this.Se.findViewById(d.g.album_no_data);
        this.hfr = (TextView) this.Se.findViewById(d.g.btn_next_step);
        this.hfs = (TextView) this.Se.findViewById(d.g.original_select_btn);
        this.hfq = this.Se.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hfk);
        this.hfr.setOnClickListener(this.hfk);
        this.hfp.setOnClickListener(this.mOnClickListener);
        this.hfs.setOnClickListener(this.hfk);
        this.hfq.setOnClickListener(this.mOnClickListener);
        this.aEy.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.Se;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGk() {
        this.hfk.bFX();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Pj();
        }
    }

    private void bGl() {
        List<ImageFileInfo> bGt;
        int currentIndex;
        if (this.heY == null && this.hfk != null) {
            this.heY = this.hfk.bFZ();
        }
        if (this.heY != null && (bGt = this.heY.bGt()) != null && (currentIndex = this.heY.getCurrentIndex()) >= 0) {
            this.aES = currentIndex;
            this.hfo = new c(this.hfk);
            this.aEy.setAdapter(this.hfo);
            if (this.aES == 0 && bGt != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(bGt, this.aES);
                if (this.heY.isAdded(imageFileInfo)) {
                    c(this.hfp, true);
                } else {
                    c(this.hfp, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hfs.setVisibility(8);
                } else {
                    this.hfs.setVisibility(0);
                }
            }
            this.hfo.setData(bGt);
            this.aEy.setCurrentItem(this.aES, false);
            nX(this.heY.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hfo != null) {
            this.hfo.setData(null);
        }
    }

    public View boM() {
        return this.mBackBtn;
    }

    public View bGm() {
        return this.hfr;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.Se);
        aj.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.heY != null) {
            nX(this.heY.isOriginalImg());
        }
        if (this.hfo != null) {
            this.hfo.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hfk != null) {
            aj.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hfr != null) {
                int v = this.heY != null ? v.v(this.heY.bGr()) : 0;
                this.hfr.setText(this.hfk.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(v), Integer.valueOf(this.heY.getMaxImagesAllowed())}));
                this.hfr.setEnabled(v > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo pC;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hfo != null && (pC = this.hfo.pC(this.aES)) != null && pC.getFilePath() != null && pC.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hfp, z);
        }
    }

    private void Pj() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.aEy.setVisibility(0);
            bGl();
        }
    }

    public View bGi() {
        return this.hfs;
    }

    public void nX(boolean z) {
        long j;
        if (this.hfk != null && this.hfs != null) {
            if (this.hfo != null) {
                ImageFileInfo pC = this.hfo.pC(this.aES);
                j = pC != null ? com.baidu.tbadk.core.util.k.dx(pC.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hfk.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.G(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                aj.i(this.hfs, d.C0096d.cp_link_tip_a);
                this.hfs.setText(sb2);
                this.hfs.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            aj.i(this.hfs, d.C0096d.cp_cont_f);
            this.hfs.setText(string);
            this.hfs.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
