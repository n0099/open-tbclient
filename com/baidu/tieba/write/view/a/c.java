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
    private TextView hHd;
    private TextView hHe;
    private TextView hHf;
    private TextView hHg;

    public c(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void r(View.OnClickListener onClickListener) {
        this.hHd.setTag(0);
        this.hHe.setTag(1);
        this.hHf.setTag(2);
        this.hHg.setTag(3);
        this.hHd.setOnClickListener(onClickListener);
        this.hHe.setOnClickListener(onClickListener);
        this.hHf.setOnClickListener(onClickListener);
        this.hHg.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.bYo.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.hHd = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hHe = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hHf = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hHg = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        aj.r(this.hHd, d.C0108d.cp_cont_j);
        aj.r(this.hHe, d.C0108d.cp_cont_j);
        aj.r(this.hHf, d.C0108d.cp_cont_j);
        aj.r(this.hHg, d.C0108d.cp_cont_j);
        this.hHd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hHe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hHg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hHf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hHd.setCompoundDrawablePadding(mPadding);
        this.hHe.setCompoundDrawablePadding(mPadding);
        this.hHg.setCompoundDrawablePadding(mPadding);
        this.hHf.setCompoundDrawablePadding(mPadding);
    }
}
