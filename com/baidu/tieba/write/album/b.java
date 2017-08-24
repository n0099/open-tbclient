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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends BaseFragment {
    private View Sg;
    private com.baidu.tbadk.img.b azd;
    private e gBJ;
    private AlbumActivity gBZ;
    private View gCe;
    private c gCf;
    private ImageView gCg;
    private View gCh;
    private TextView gCi;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aEZ = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gCf != null && b.this.gBJ != null && b.this.gBZ != null && b.this.gCf.uo(b.this.aEZ)) {
                ImageFileInfo oC = b.this.gCf.oC(b.this.aEZ);
                if (b.this.gBJ.isAdded(oC)) {
                    if (b.this.gBZ.f(oC)) {
                        b.this.c(b.this.gCg, false);
                        b.this.gBZ.I(b.this.aEZ, false);
                    }
                } else if (b.this.gBZ.e(oC)) {
                    b.this.c(b.this.gCg, true);
                    b.this.gBZ.I(b.this.aEZ, true);
                }
                b.this.byE();
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aEZ = i;
            if (b.this.gCf != null && b.this.gBJ != null) {
                ImageFileInfo oC = b.this.gCf.oC(b.this.aEZ);
                if (b.this.gBJ.isAdded(oC)) {
                    b.this.c(b.this.gCg, true);
                } else {
                    b.this.c(b.this.gCg, false);
                }
                if (oC.isGif()) {
                    b.this.gCi.setVisibility(8);
                } else {
                    b.this.gCi.setVisibility(0);
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
        this.gBZ = (AlbumActivity) getBaseFragmentActivity();
        this.gBJ = this.gBZ.byr();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Sg = layoutInflater.inflate(d.j.album_big_image_view, (ViewGroup) null);
        this.gCe = this.Sg.findViewById(d.h.img_back);
        this.gCe.setOnClickListener(this.gBZ);
        this.gCg = (ImageView) this.Sg.findViewById(d.h.img_choose);
        this.gCg.setOnClickListener(this.mOnClickListener);
        this.mViewPager = (ViewPager) this.Sg.findViewById(d.h.viewPager);
        this.azd = this.gBZ.ank();
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.Sg.findViewById(d.h.album_no_data);
        this.gCh = this.Sg.findViewById(d.h.btn_next_step);
        this.gCh.setOnClickListener(this.gBZ);
        this.gCi = (TextView) this.Sg.findViewById(d.h.original_select_btn);
        this.gCi.setOnClickListener(this.gBZ);
        if (this.gBJ.isOriginalImg()) {
            this.gBZ.byv();
        }
        return this.Sg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byE() {
        if (this.gBJ.isOriginalImg()) {
            this.gBZ.byv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            afL();
        }
    }

    private void byF() {
        int currentIndex;
        if (this.gBJ == null && this.gBZ != null) {
            this.gBJ = this.gBZ.byr();
        }
        if (this.gBJ != null && this.gBJ.byJ() != null && (currentIndex = this.gBJ.getCurrentIndex()) >= 0) {
            this.aEZ = currentIndex;
            if (this.aEZ > this.gBJ.byJ().size() - 1) {
                this.aEZ = this.gBJ.byJ().size() - 1;
            }
            this.gBJ.setCurrentIndex(-1);
            this.gCf = null;
            this.gCf = new c(this.gBZ, this.azd);
            this.mViewPager.setAdapter(this.gCf);
            if (this.aEZ == 0 && this.gBJ.byJ() != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) u.c(this.gBJ.byJ(), this.aEZ);
                if (this.gBJ.isAdded(imageFileInfo)) {
                    c(this.gCg, true);
                } else {
                    c(this.gCg, false);
                }
                if (imageFileInfo.isGif()) {
                    this.gCi.setVisibility(8);
                } else {
                    this.gCi.setVisibility(0);
                }
            }
            this.gCf.setData(this.gBJ.byJ());
            this.mViewPager.setCurrentItem(this.aEZ, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gCf != null) {
            this.gCf.setData(null);
        }
    }

    public View blk() {
        return this.gCe;
    }

    public View byG() {
        return this.gCh;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gBZ.getLayoutMode().ah(i == 1);
        this.gBZ.getLayoutMode().t(this.Sg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(d.g.ic_post_edit_select_s);
            } else {
                imageView.setImageResource(d.g.ic_post_edit_select_n);
            }
        }
    }

    public void g(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo oC;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gCf != null && (oC = this.gCf.oC(this.aEZ)) != null && oC.getFilePath() != null && oC.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.gCg, z);
        }
    }

    private void afL() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            byF();
        }
    }

    public int getCurrentIndex() {
        return this.aEZ;
    }

    public View byB() {
        return this.gCi;
    }

    public void d(boolean z, long j) {
        if (this.gBZ != null && this.gCi != null) {
            String string = this.gBZ.getResources().getString(d.l.original_img);
            if (z) {
                this.gCi.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(al.H(j));
                    sb.append(")");
                }
                this.gCi.setText(sb.toString());
                this.gCi.setTextColor(this.gBZ.getResources().getColor(d.e.cp_link_tip_a));
                return;
            }
            this.gCi.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.gCi.setText(string);
            this.gCi.setTextColor(this.gBZ.getResources().getColor(d.e.cp_cont_i));
        }
    }
}
