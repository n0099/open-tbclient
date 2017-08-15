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
    private View Sf;
    private com.baidu.tbadk.img.b azc;
    private e gBJ;
    private AlbumActivity gBZ;
    private View gCe;
    private c gCf;
    private ImageView gCg;
    private View gCh;
    private TextView gCi;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aEY = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.album.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gCf != null && b.this.gBJ != null && b.this.gBZ != null && b.this.gCf.uo(b.this.aEY)) {
                ImageFileInfo oC = b.this.gCf.oC(b.this.aEY);
                if (b.this.gBJ.isAdded(oC)) {
                    if (b.this.gBZ.f(oC)) {
                        b.this.c(b.this.gCg, false);
                        b.this.gBZ.I(b.this.aEY, false);
                    }
                } else if (b.this.gBZ.e(oC)) {
                    b.this.c(b.this.gCg, true);
                    b.this.gBZ.I(b.this.aEY, true);
                }
                b.this.byM();
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.write.album.b.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            b.this.aEY = i;
            if (b.this.gCf != null && b.this.gBJ != null) {
                ImageFileInfo oC = b.this.gCf.oC(b.this.aEY);
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
        this.gBJ = this.gBZ.byz();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Sf = layoutInflater.inflate(d.j.album_big_image_view, (ViewGroup) null);
        this.gCe = this.Sf.findViewById(d.h.img_back);
        this.gCe.setOnClickListener(this.gBZ);
        this.gCg = (ImageView) this.Sf.findViewById(d.h.img_choose);
        this.gCg.setOnClickListener(this.mOnClickListener);
        this.mViewPager = (ViewPager) this.Sf.findViewById(d.h.viewPager);
        this.azc = this.gBZ.anq();
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.Sf.findViewById(d.h.album_no_data);
        this.gCh = this.Sf.findViewById(d.h.btn_next_step);
        this.gCh.setOnClickListener(this.gBZ);
        this.gCi = (TextView) this.Sf.findViewById(d.h.original_select_btn);
        this.gCi.setOnClickListener(this.gBZ);
        if (this.gBJ.isOriginalImg()) {
            this.gBZ.byD();
        }
        return this.Sf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byM() {
        if (this.gBJ.isOriginalImg()) {
            this.gBZ.byD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            afR();
        }
    }

    private void byN() {
        int currentIndex;
        if (this.gBJ == null && this.gBZ != null) {
            this.gBJ = this.gBZ.byz();
        }
        if (this.gBJ != null && this.gBJ.byR() != null && (currentIndex = this.gBJ.getCurrentIndex()) >= 0) {
            this.aEY = currentIndex;
            if (this.aEY > this.gBJ.byR().size() - 1) {
                this.aEY = this.gBJ.byR().size() - 1;
            }
            this.gBJ.setCurrentIndex(-1);
            this.gCf = null;
            this.gCf = new c(this.gBZ, this.azc);
            this.mViewPager.setAdapter(this.gCf);
            if (this.aEY == 0 && this.gBJ.byR() != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) u.c(this.gBJ.byR(), this.aEY);
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
            this.gCf.setData(this.gBJ.byR());
            this.mViewPager.setCurrentItem(this.aEY, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.gCf != null) {
            this.gCf.setData(null);
        }
    }

    public View blq() {
        return this.gCe;
    }

    public View byO() {
        return this.gCh;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gBZ.getLayoutMode().ah(i == 1);
        this.gBZ.getLayoutMode().t(this.Sf);
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
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.gCf != null && (oC = this.gCf.oC(this.aEY)) != null && oC.getFilePath() != null && oC.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.gCg, z);
        }
    }

    private void afR() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            byN();
        }
    }

    public int getCurrentIndex() {
        return this.aEY;
    }

    public View byJ() {
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
