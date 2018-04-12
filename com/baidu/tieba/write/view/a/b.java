package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView hfn;
    private TextView hfo;
    private TextView hfp;
    private TextView hfq;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void t(View.OnClickListener onClickListener) {
        this.hfn.setTag(0);
        this.hfo.setTag(1);
        this.hfp.setTag(2);
        this.hfq.setTag(3);
        this.hfn.setOnClickListener(onClickListener);
        this.hfo.setOnClickListener(onClickListener);
        this.hfp.setOnClickListener(onClickListener);
        this.hfq.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.i.pic_rorate_view, (ViewGroup) null);
        this.hfn = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hfo = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hfp = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hfq = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        ak.h(this.hfn, d.C0126d.cp_cont_j);
        ak.h(this.hfo, d.C0126d.cp_cont_j);
        ak.h(this.hfp, d.C0126d.cp_cont_j);
        ak.h(this.hfq, d.C0126d.cp_cont_j);
        this.hfn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hfo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hfq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hfp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hfn.setCompoundDrawablePadding(mPadding);
        this.hfo.setCompoundDrawablePadding(mPadding);
        this.hfq.setCompoundDrawablePadding(mPadding);
        this.hfp.setCompoundDrawablePadding(mPadding);
    }
}
