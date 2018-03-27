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
    private View aHT;
    private e hEI;
    private AlbumActivity hEV;
    private c hEZ;
    private ImageView hFa;
    private View hFb;
    private TextView hFc;
    private TextView hFd;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager qV;
    private int bvi = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.hFb && view == b.this.hFa && b.this.hEZ != null && b.this.hEI != null && b.this.hEV != null) {
                if (b.this.hEI.bGs()) {
                    b.this.hEV.showToast(d.j.album_choose_switch_tip);
                } else if (b.this.hEZ.xn(b.this.bvi)) {
                    ImageFileInfo st = b.this.hEZ.st(b.this.bvi);
                    if (b.this.hEI.isAdded(st)) {
                        if (b.this.hEV.d(st)) {
                            b.this.c(b.this.hFa, false);
                            b.this.hEV.f(st, false);
                        }
                    } else if (b.this.hEV.c(st)) {
                        b.this.c(b.this.hFa, true);
                        b.this.hEV.f(st, true);
                    }
                    b.this.bGn();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.bvi = i;
            if (b.this.hEZ != null && b.this.hEI != null) {
                ImageFileInfo st = b.this.hEZ.st(b.this.bvi);
                if (b.this.hEI.isAdded(st)) {
                    b.this.c(b.this.hFa, true);
                } else {
                    b.this.c(b.this.hFa, false);
                }
                if (st == null || !st.isGif()) {
                    b.this.hFd.setVisibility(0);
                } else {
                    b.this.hFd.setVisibility(8);
                }
                b.this.nJ(b.this.hEI.isOriginalImg());
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
        this.hEV = (AlbumActivity) getBaseFragmentActivity();
        this.hEI = this.hEV.bGc();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aHT = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.aHT.findViewById(d.g.img_back);
        this.hFa = (ImageView) this.aHT.findViewById(d.g.img_choose);
        this.qV = (ViewPager) this.aHT.findViewById(d.g.viewPager);
        this.mNoDataView = this.aHT.findViewById(d.g.album_no_data);
        this.hFc = (TextView) this.aHT.findViewById(d.g.btn_next_step);
        this.hFd = (TextView) this.aHT.findViewById(d.g.original_select_btn);
        this.hFb = this.aHT.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hEV);
        this.hFc.setOnClickListener(this.hEV);
        this.hFa.setOnClickListener(this.mOnClickListener);
        this.hFd.setOnClickListener(this.hEV);
        this.hFb.setOnClickListener(this.mOnClickListener);
        this.qV.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.aHT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGn() {
        this.hEV.bGa();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Xp();
        }
    }

    private void bGo() {
        List<ImageFileInfo> bGw;
        int currentIndex;
        if (this.hEI == null && this.hEV != null) {
            this.hEI = this.hEV.bGc();
        }
        if (this.hEI != null && (bGw = this.hEI.bGw()) != null && (currentIndex = this.hEI.getCurrentIndex()) >= 0) {
            this.bvi = currentIndex;
            this.hEZ = new c(this.hEV);
            this.qV.setAdapter(this.hEZ);
            if (this.bvi == 0 && bGw != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(bGw, this.bvi);
                if (this.hEI.isAdded(imageFileInfo)) {
                    c(this.hFa, true);
                } else {
                    c(this.hFa, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hFd.setVisibility(8);
                } else {
                    this.hFd.setVisibility(0);
                }
            }
            this.hEZ.setData(bGw);
            this.qV.setCurrentItem(this.bvi, false);
            nJ(this.hEI.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hEZ != null) {
            this.hEZ.setData(null);
        }
    }

    public View brm() {
        return this.mBackBtn;
    }

    public View bGp() {
        return this.hFc;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.aHT);
        aj.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hEI != null) {
            nJ(this.hEI.isOriginalImg());
        }
        if (this.hEZ != null) {
            this.hEZ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hEV != null) {
            aj.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hFc != null) {
                int D = this.hEI != null ? v.D(this.hEI.bGu()) : 0;
                this.hFc.setText(this.hEV.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(D), Integer.valueOf(this.hEI != null ? this.hEI.getMaxImagesAllowed() : 1)}));
                this.hFc.setEnabled(D > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo st;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hEZ != null && (st = this.hEZ.st(this.bvi)) != null && st.getFilePath() != null && st.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hFa, z);
        }
    }

    private void Xp() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.qV.setVisibility(0);
            bGo();
        }
    }

    public View bGl() {
        return this.hFd;
    }

    public void nJ(boolean z) {
        long j;
        if (this.hEV != null && this.hFd != null) {
            if (this.hEZ != null) {
                ImageFileInfo st = this.hEZ.st(this.bvi);
                j = st != null ? com.baidu.tbadk.core.util.k.dV(st.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hEV.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.O(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                aj.r(this.hFd, d.C0141d.cp_link_tip_a);
                this.hFd.setText(sb2);
                this.hFd.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            aj.r(this.hFd, d.C0141d.cp_cont_f);
            this.hFd.setText(string);
            this.hFd.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
