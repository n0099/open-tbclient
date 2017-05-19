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
    private View QK;
    private com.baidu.tbadk.img.b awf;
    private p fLQ;
    private AlbumActivity fMg;
    private View fMm;
    private k fMn;
    private ImageView fMo;
    private View fMp;
    private TextView fMq;
    private View mNoDataView;
    private ViewPager mViewPager;
    private int aBS = -1;
    private View.OnClickListener mOnClickListener = new g(this);
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new h(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fMg = (AlbumActivity) getBaseFragmentActivity();
        this.fLQ = this.fMg.blS();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.QK = layoutInflater.inflate(w.j.album_big_image_view, (ViewGroup) null);
        this.fMm = this.QK.findViewById(w.h.img_back);
        this.fMm.setOnClickListener(this.fMg);
        this.fMo = (ImageView) this.QK.findViewById(w.h.img_choose);
        this.fMo.setOnClickListener(this.mOnClickListener);
        this.mViewPager = (ViewPager) this.QK.findViewById(w.h.viewPager);
        this.awf = this.fMg.afY();
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mNoDataView = this.QK.findViewById(w.h.album_no_data);
        this.fMp = this.QK.findViewById(w.h.btn_next_step);
        this.fMp.setOnClickListener(this.fMg);
        this.fMq = (TextView) this.QK.findViewById(w.h.original_select_btn);
        this.fMq.setOnClickListener(this.fMg);
        if (this.fLQ.isOriginalImg()) {
            this.fMg.blX();
        }
        return this.QK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmk() {
        if (this.fLQ.isOriginalImg()) {
            this.fMg.blX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Zu();
        }
    }

    private void bml() {
        int currentIndex;
        if (this.fLQ == null && this.fMg != null) {
            this.fLQ = this.fMg.blS();
        }
        if (this.fLQ != null && this.fLQ.bms() != null && (currentIndex = this.fLQ.getCurrentIndex()) >= 0) {
            this.aBS = currentIndex;
            if (this.aBS > this.fLQ.bms().size() - 1) {
                this.aBS = this.fLQ.bms().size() - 1;
            }
            this.fLQ.sJ(-1);
            this.fMn = null;
            this.fMn = new k(this.fMg, this.awf);
            this.mViewPager.setAdapter(this.fMn);
            if (this.aBS == 0 && this.fLQ.bms() != null) {
                if (this.fLQ.isAdded((ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.fLQ.bms(), this.aBS))) {
                    c(this.fMo, true);
                } else {
                    c(this.fMo, false);
                }
            }
            this.fMn.setData(this.fLQ.bms());
            this.mViewPager.setCurrentItem(this.aBS, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.fMn != null) {
            this.fMn.setData(null);
        }
    }

    public View bbq() {
        return this.fMm;
    }

    public View bmm() {
        return this.fMp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fMg.getLayoutMode().ai(i == 1);
        this.fMg.getLayoutMode().t(this.QK);
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
        ImageFileInfo sN;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.fMn != null && (sN = this.fMn.sN(this.aBS)) != null && sN.getFilePath() != null && sN.getFilePath().equals(imageFileInfo.getFilePath())) {
            c(this.fMo, z);
        }
    }

    private void Zu() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            bml();
        }
    }

    public int getCurrentIndex() {
        return this.aBS;
    }

    public View bmf() {
        return this.fMq;
    }

    public void a(boolean z, long j) {
        if (this.fMg != null && this.fMq != null) {
            String string = this.fMg.getResources().getString(w.l.original_img);
            if (z) {
                this.fMq.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.ic_post_image_original_s), (Drawable) null, (Drawable) null, (Drawable) null);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(com.baidu.tbadk.core.util.au.F(j));
                    sb.append(")");
                }
                this.fMq.setText(sb.toString());
                this.fMq.setTextColor(this.fMg.getResources().getColor(w.e.cp_link_tip_a));
                return;
            }
            this.fMq.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.ic_post_image_original_n), (Drawable) null, (Drawable) null, (Drawable) null);
            this.fMq.setText(string);
            this.fMq.setTextColor(this.fMg.getResources().getColor(w.e.cp_cont_i));
        }
    }
}
