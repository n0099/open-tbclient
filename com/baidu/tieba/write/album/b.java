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
    private View aId;
    private AlbumActivity hEK;
    private c hEO;
    private ImageView hEP;
    private View hEQ;
    private TextView hER;
    private TextView hES;
    private e hEx;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager qW;
    private int bvs = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.hEQ && view == b.this.hEP && b.this.hEO != null && b.this.hEx != null && b.this.hEK != null) {
                if (b.this.hEx.bGo()) {
                    b.this.hEK.showToast(d.j.album_choose_switch_tip);
                } else if (b.this.hEO.xm(b.this.bvs)) {
                    ImageFileInfo ss = b.this.hEO.ss(b.this.bvs);
                    if (b.this.hEx.isAdded(ss)) {
                        if (b.this.hEK.d(ss)) {
                            b.this.c(b.this.hEP, false);
                            b.this.hEK.f(ss, false);
                        }
                    } else if (b.this.hEK.c(ss)) {
                        b.this.c(b.this.hEP, true);
                        b.this.hEK.f(ss, true);
                    }
                    b.this.bGj();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.bvs = i;
            if (b.this.hEO != null && b.this.hEx != null) {
                ImageFileInfo ss = b.this.hEO.ss(b.this.bvs);
                if (b.this.hEx.isAdded(ss)) {
                    b.this.c(b.this.hEP, true);
                } else {
                    b.this.c(b.this.hEP, false);
                }
                if (ss == null || !ss.isGif()) {
                    b.this.hES.setVisibility(0);
                } else {
                    b.this.hES.setVisibility(8);
                }
                b.this.nE(b.this.hEx.isOriginalImg());
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
        this.hEK = (AlbumActivity) getBaseFragmentActivity();
        this.hEx = this.hEK.bFY();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aId = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.aId.findViewById(d.g.img_back);
        this.hEP = (ImageView) this.aId.findViewById(d.g.img_choose);
        this.qW = (ViewPager) this.aId.findViewById(d.g.viewPager);
        this.mNoDataView = this.aId.findViewById(d.g.album_no_data);
        this.hER = (TextView) this.aId.findViewById(d.g.btn_next_step);
        this.hES = (TextView) this.aId.findViewById(d.g.original_select_btn);
        this.hEQ = this.aId.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hEK);
        this.hER.setOnClickListener(this.hEK);
        this.hEP.setOnClickListener(this.mOnClickListener);
        this.hES.setOnClickListener(this.hEK);
        this.hEQ.setOnClickListener(this.mOnClickListener);
        this.qW.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.aId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGj() {
        this.hEK.bFW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Xp();
        }
    }

    private void bGk() {
        List<ImageFileInfo> bGs;
        int currentIndex;
        if (this.hEx == null && this.hEK != null) {
            this.hEx = this.hEK.bFY();
        }
        if (this.hEx != null && (bGs = this.hEx.bGs()) != null && (currentIndex = this.hEx.getCurrentIndex()) >= 0) {
            this.bvs = currentIndex;
            this.hEO = new c(this.hEK);
            this.qW.setAdapter(this.hEO);
            if (this.bvs == 0 && bGs != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(bGs, this.bvs);
                if (this.hEx.isAdded(imageFileInfo)) {
                    c(this.hEP, true);
                } else {
                    c(this.hEP, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hES.setVisibility(8);
                } else {
                    this.hES.setVisibility(0);
                }
            }
            this.hEO.setData(bGs);
            this.qW.setCurrentItem(this.bvs, false);
            nE(this.hEx.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hEO != null) {
            this.hEO.setData(null);
        }
    }

    public View brm() {
        return this.mBackBtn;
    }

    public View bGl() {
        return this.hER;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.aId);
        aj.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hEx != null) {
            nE(this.hEx.isOriginalImg());
        }
        if (this.hEO != null) {
            this.hEO.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hEK != null) {
            aj.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hER != null) {
                int D = this.hEx != null ? v.D(this.hEx.bGq()) : 0;
                this.hER.setText(this.hEK.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(D), Integer.valueOf(this.hEx != null ? this.hEx.getMaxImagesAllowed() : 1)}));
                this.hER.setEnabled(D > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo ss;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hEO != null && (ss = this.hEO.ss(this.bvs)) != null && ss.getFilePath() != null && ss.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hEP, z);
        }
    }

    private void Xp() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.qW.setVisibility(0);
            bGk();
        }
    }

    public View bGh() {
        return this.hES;
    }

    public void nE(boolean z) {
        long j;
        if (this.hEK != null && this.hES != null) {
            if (this.hEO != null) {
                ImageFileInfo ss = this.hEO.ss(this.bvs);
                j = ss != null ? com.baidu.tbadk.core.util.k.dV(ss.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hEK.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.O(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                aj.r(this.hES, d.C0140d.cp_link_tip_a);
                this.hES.setText(sb2);
                this.hES.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            aj.r(this.hES, d.C0140d.cp_cont_f);
            this.hES.setText(string);
            this.hES.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
