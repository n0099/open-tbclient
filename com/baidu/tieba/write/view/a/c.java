package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends a {
    private static int mPadding;
    private TextView hRb;
    private TextView hRc;
    private TextView hRd;
    private TextView hRe;

    public c(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void q(View.OnClickListener onClickListener) {
        this.hRb.setTag(0);
        this.hRc.setTag(1);
        this.hRd.setTag(2);
        this.hRe.setTag(3);
        this.hRb.setOnClickListener(onClickListener);
        this.hRc.setOnClickListener(onClickListener);
        this.hRd.setOnClickListener(onClickListener);
        this.hRe.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.bXZ.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.hRb = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hRc = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hRd = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hRe = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        aj.r(this.hRb, d.C0108d.cp_cont_j);
        aj.r(this.hRc, d.C0108d.cp_cont_j);
        aj.r(this.hRd, d.C0108d.cp_cont_j);
        aj.r(this.hRe, d.C0108d.cp_cont_j);
        this.hRb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hRc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hRe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hRd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hRb.setCompoundDrawablePadding(mPadding);
        this.hRc.setCompoundDrawablePadding(mPadding);
        this.hRe.setCompoundDrawablePadding(mPadding);
        this.hRd.setCompoundDrawablePadding(mPadding);
    }
}
