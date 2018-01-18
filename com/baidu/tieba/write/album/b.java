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
    private View aGH;
    private e hCG;
    private AlbumActivity hCT;
    private c hCX;
    private ImageView hCY;
    private View hCZ;
    private TextView hDa;
    private TextView hDb;
    private ImageView mBackBtn;
    private View mNoDataView;
    private ViewPager qW;
    private int bsW = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != b.this.hCZ && view == b.this.hCY && b.this.hCX != null && b.this.hCG != null && b.this.hCT != null) {
                if (b.this.hCG.bFy()) {
                    b.this.hCT.showToast(d.j.album_choose_switch_tip);
                } else if (b.this.hCX.xn(b.this.bsW)) {
                    ImageFileInfo sp = b.this.hCX.sp(b.this.bsW);
                    if (b.this.hCG.isAdded(sp)) {
                        if (b.this.hCT.d(sp)) {
                            b.this.c(b.this.hCY, false);
                            b.this.hCT.f(sp, false);
                        }
                    } else if (b.this.hCT.c(sp)) {
                        b.this.c(b.this.hCY, true);
                        b.this.hCT.f(sp, true);
                    }
                    b.this.bFt();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.bsW = i;
            if (b.this.hCX != null && b.this.hCG != null) {
                ImageFileInfo sp = b.this.hCX.sp(b.this.bsW);
                if (b.this.hCG.isAdded(sp)) {
                    b.this.c(b.this.hCY, true);
                } else {
                    b.this.c(b.this.hCY, false);
                }
                if (sp == null || !sp.isGif()) {
                    b.this.hDb.setVisibility(0);
                } else {
                    b.this.hDb.setVisibility(8);
                }
                b.this.nu(b.this.hCG.isOriginalImg());
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
        this.hCT = (AlbumActivity) getBaseFragmentActivity();
        this.hCG = this.hCT.bFi();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aGH = layoutInflater.inflate(d.h.album_big_image_view, (ViewGroup) null);
        this.mBackBtn = (ImageView) this.aGH.findViewById(d.g.img_back);
        this.hCY = (ImageView) this.aGH.findViewById(d.g.img_choose);
        this.qW = (ViewPager) this.aGH.findViewById(d.g.viewPager);
        this.mNoDataView = this.aGH.findViewById(d.g.album_no_data);
        this.hDa = (TextView) this.aGH.findViewById(d.g.btn_next_step);
        this.hDb = (TextView) this.aGH.findViewById(d.g.original_select_btn);
        this.hCZ = this.aGH.findViewById(d.g.layout_bottom);
        this.mBackBtn.setOnClickListener(this.hCT);
        this.hDa.setOnClickListener(this.hCT);
        this.hCY.setOnClickListener(this.mOnClickListener);
        this.hDb.setOnClickListener(this.hCT);
        this.hCZ.setOnClickListener(this.mOnClickListener);
        this.qW.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.aGH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFt() {
        this.hCT.bFg();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Ww();
        }
    }

    private void bFu() {
        List<ImageFileInfo> bFC;
        int currentIndex;
        if (this.hCG == null && this.hCT != null) {
            this.hCG = this.hCT.bFi();
        }
        if (this.hCG != null && (bFC = this.hCG.bFC()) != null && (currentIndex = this.hCG.getCurrentIndex()) >= 0) {
            this.bsW = currentIndex;
            this.hCX = new c(this.hCT);
            this.qW.setAdapter(this.hCX);
            if (this.bsW == 0 && bFC != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(bFC, this.bsW);
                if (this.hCG.isAdded(imageFileInfo)) {
                    c(this.hCY, true);
                } else {
                    c(this.hCY, false);
                }
                if (imageFileInfo.isGif()) {
                    this.hDb.setVisibility(8);
                } else {
                    this.hDb.setVisibility(0);
                }
            }
            this.hCX.setData(bFC);
            this.qW.setCurrentItem(this.bsW, false);
            nu(this.hCG.isOriginalImg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.hCX != null) {
            this.hCX.setData(null);
        }
    }

    public View bpP() {
        return this.mBackBtn;
    }

    public View bFv() {
        return this.hDa;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(getPageContext(), this.aGH);
        aj.b(this.mBackBtn, d.f.icon_return_bg_s, d.f.icon_return_bg, i);
        if (this.hCG != null) {
            nu(this.hCG.isOriginalImg());
        }
        if (this.hCX != null) {
            this.hCX.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null && this.hCT != null) {
            aj.c(imageView, z ? d.f.ic_post_edit_select_s : d.f.icon_image_clear_select);
            if (this.hDa != null) {
                int D = this.hCG != null ? v.D(this.hCG.bFA()) : 0;
                this.hDa.setText(this.hCT.getString(d.j.image_selected_list_count_max, new Object[]{Integer.valueOf(D), Integer.valueOf(this.hCG.getMaxImagesAllowed())}));
                this.hDa.setEnabled(D > 0);
            }
        }
    }

    public void h(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo sp;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.hCX != null && (sp = this.hCX.sp(this.bsW)) != null && sp.getFilePath() != null && sp.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.hCY, z);
        }
    }

    private void Ww() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.qW.setVisibility(0);
            bFu();
        }
    }

    public View bFr() {
        return this.hDb;
    }

    public void nu(boolean z) {
        long j;
        if (this.hCT != null && this.hDb != null) {
            if (this.hCX != null) {
                ImageFileInfo sp = this.hCX.sp(this.bsW);
                j = sp != null ? com.baidu.tbadk.core.util.k.dE(sp.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.hCT.getResources().getString(d.j.original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(am.O(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                aj.r(this.hDb, d.C0107d.cp_link_tip_a);
                this.hDb.setText(sb2);
                this.hDb.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            aj.r(this.hDb, d.C0107d.cp_cont_f);
            this.hDb.setText(string);
            this.hDb.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
