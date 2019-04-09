package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView jrk;
    private TextView jrl;
    private TextView jrm;
    private TextView jrn;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void x(View.OnClickListener onClickListener) {
        this.jrk.setTag(0);
        this.jrl.setTag(1);
        this.jrm.setTag(2);
        this.jrn.setTag(3);
        this.jrk.setOnClickListener(onClickListener);
        this.jrl.setOnClickListener(onClickListener);
        this.jrm.setOnClickListener(onClickListener);
        this.jrn.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.jrk = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.jrl = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.jrm = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.jrn = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.j(this.jrk, d.C0277d.cp_cont_j);
        al.j(this.jrl, d.C0277d.cp_cont_j);
        al.j(this.jrm, d.C0277d.cp_cont_j);
        al.j(this.jrn, d.C0277d.cp_cont_j);
        this.jrk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.jrl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.jrn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.jrm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.jrk.setCompoundDrawablePadding(mPadding);
        this.jrl.setCompoundDrawablePadding(mPadding);
        this.jrn.setCompoundDrawablePadding(mPadding);
        this.jrm.setCompoundDrawablePadding(mPadding);
    }
}
