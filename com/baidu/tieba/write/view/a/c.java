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
    private TextView hgb;
    private TextView hgc;
    private TextView hgd;
    private TextView hge;

    public c(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void q(View.OnClickListener onClickListener) {
        this.hgb.setTag(0);
        this.hgc.setTag(1);
        this.hgd.setTag(2);
        this.hge.setTag(3);
        this.hgb.setOnClickListener(onClickListener);
        this.hgc.setOnClickListener(onClickListener);
        this.hgd.setOnClickListener(onClickListener);
        this.hge.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.bkJ.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.hgb = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hgc = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hgd = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hge = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        aj.i(this.hgb, d.C0082d.cp_cont_j);
        aj.i(this.hgc, d.C0082d.cp_cont_j);
        aj.i(this.hgd, d.C0082d.cp_cont_j);
        aj.i(this.hge, d.C0082d.cp_cont_j);
        this.hgb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hgc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hge.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hgd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hgb.setCompoundDrawablePadding(mPadding);
        this.hgc.setCompoundDrawablePadding(mPadding);
        this.hge.setCompoundDrawablePadding(mPadding);
        this.hgd.setCompoundDrawablePadding(mPadding);
    }
}
