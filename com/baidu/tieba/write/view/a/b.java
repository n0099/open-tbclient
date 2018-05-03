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
    private TextView hfk;
    private TextView hfl;
    private TextView hfm;
    private TextView hfn;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void t(View.OnClickListener onClickListener) {
        this.hfk.setTag(0);
        this.hfl.setTag(1);
        this.hfm.setTag(2);
        this.hfn.setTag(3);
        this.hfk.setOnClickListener(onClickListener);
        this.hfl.setOnClickListener(onClickListener);
        this.hfm.setOnClickListener(onClickListener);
        this.hfn.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.i.pic_rorate_view, (ViewGroup) null);
        this.hfk = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hfl = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hfm = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hfn = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        ak.h(this.hfk, d.C0126d.cp_cont_j);
        ak.h(this.hfl, d.C0126d.cp_cont_j);
        ak.h(this.hfm, d.C0126d.cp_cont_j);
        ak.h(this.hfn, d.C0126d.cp_cont_j);
        this.hfk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hfl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hfn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hfm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hfk.setCompoundDrawablePadding(mPadding);
        this.hfl.setCompoundDrawablePadding(mPadding);
        this.hfn.setCompoundDrawablePadding(mPadding);
        this.hfm.setCompoundDrawablePadding(mPadding);
    }
}
