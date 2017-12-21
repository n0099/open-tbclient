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
    private View Sf;
    private ViewPager aEB;
    private e hfd;
    private AlbumActivity hfp;
    private c hft;
    private ImageView hfu;
    private View hfv;
    private TextView hfw;
    private TextView hfx;
    private ImageView mBackBtn;
    private View mNoDataView;
    private int aEV = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.hfv && view == b.this.hfu && b.this.hft != null && b.this.hfd != null && b.this.hfp != null) {
                if (b.this.hfd.bGq()) {
                    b.this.hfp.showToast(d.j.album_choose_switch_tip);
                } else if (b.this.hft.vT(b.this.aEV)) {
                    ImageFileInfo pC = b.this.hft.pC(b.this.aEV);
                    if (b.this.hfd.isAdded(pC)) {
                        if (b.this.hfp.d(pC)) {
                            b.this.c(b.this.hfu, false);
                            b.this.hfp.f(pC, false);
                        }
                    } else if (b.this.hfp.c(pC)) {
                        b.this.c(b.this.hfu, true);
                        b.this.hfp.f(pC, true);
                    }
                    b.this.bGl();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aEV = i;
            if (b.this.hft != null && b.this.hfd != null) {
                ImageFileInfo pC = b.this.hft.pC(b.this.aEV);
                if (b.this.hfd.isAdded(pC)) {
                    b.this.c(b.this.hfu, true);
                } else {
                    b.this.c(b.this.hfu, false);
                }
                if (pC == null || !pC.isGif()) {
                    b.this.hfx.setVisibility(0);
                } else {
                    b.this.hfx.setVisibility(8);
                }
                b.this.nX(b.this.hfd.isOriginalImg());
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
        this.hfp = (AlbumActivity) getBaseFragmentActivity();
        this.hfd = this.hfp.bGa();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Sf = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.Sf.findViewById(d.g.img_back);
        this.hfu = (ImageView) this.Sf.findViewById(d.g.img_choose);
        this.aEB = (ViewPager) this.Sf.findViewById(d.g.viewPager);
        this.mNoDataView = this.Sf.findViewById(d.g.album_no_data);
        this.hfw = (TextView) this.Sf.findViewById(d.g.btn_next_step);
        this.hfx = (TextView) this.Sf.findViewById(d.g.original_select_btn);
        this.hfv = this.Sf.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hfp);
        this.hfw.setOnClickListener(this.hfp);
        this.hfu.setOnClickListener(this.mOnClickListener);
        this.hfx.setOnClickListener(this.hfp);
        this.hfv.setOnClickListener(this.mOnClickListener);
        this.aEB.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.Sf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGl() {
        this.hfp.bFY();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Pj();
        }
    }

    private void bGm() {
        List<ImageFileInfo> bGu;
        int currentIndex;
        if (this.hfd == null && this.hfp != null) {
            this.hfd = this.hfp.bGa();
        }
        if (this.hfd != null && (bGu = this.hfd.bGu()) != null && (currentIndex = this.hfd.getCurrentIndex()) >= 0) {
            this.aEV = currentIndex;
            this.hft = new c(this.hfp);
            this.aEB.setAdapter(this.hft);
            if (this.aEV == 0 && bGu != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(bGu, this.aEV);
                if (this.hfd.isAdded(imageFileInfo)) {
                    c(this.hfu, true);
                } else {
                    c(this.hfu, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hfx.setVisibility(8);
                } else {
                    this.hfx.setVisibility(0);
                }
            }
            this.hft.setData(bGu);
            this.aEB.setCurrentItem(this.aEV, false);
            nX(this.hfd.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hft != null) {
            this.hft.setData(null);
        }
    }

    public View boN() {
        return this.mBackBtn;
    }

    public View bGn() {
        return this.hfw;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.Sf);
        aj.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hfd != null) {
            nX(this.hfd.isOriginalImg());
        }
        if (this.hft != null) {
            this.hft.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hfp != null) {
            aj.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hfw != null) {
                int v = this.hfd != null ? v.v(this.hfd.bGs()) : 0;
                this.hfw.setText(this.hfp.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(v), Integer.valueOf(this.hfd.getMaxImagesAllowed())}));
                this.hfw.setEnabled(v > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo pC;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hft != null && (pC = this.hft.pC(this.aEV)) != null && pC.getFilePath() != null && pC.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hfu, z);
        }
    }

    private void Pj() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.aEB.setVisibility(0);
            bGm();
        }
    }

    public View bGj() {
        return this.hfx;
    }

    public void nX(boolean z) {
        long j;
        if (this.hfp != null && this.hfx != null) {
            if (this.hft != null) {
                ImageFileInfo pC = this.hft.pC(this.aEV);
                j = pC != null ? com.baidu.tbadk.core.util.k.dx(pC.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hfp.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.G(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                aj.i(this.hfx, d.C0095d.cp_link_tip_a);
                this.hfx.setText(sb2);
                this.hfx.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            aj.i(this.hfx, d.C0095d.cp_cont_f);
            this.hfx.setText(string);
            this.hfx.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
