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
    private TextView jri;
    private TextView jrj;
    private TextView jrk;
    private TextView jrl;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void x(View.OnClickListener onClickListener) {
        this.jri.setTag(0);
        this.jrj.setTag(1);
        this.jrk.setTag(2);
        this.jrl.setTag(3);
        this.jri.setOnClickListener(onClickListener);
        this.jrj.setOnClickListener(onClickListener);
        this.jrk.setOnClickListener(onClickListener);
        this.jrl.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.jri = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.jrj = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.jrk = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.jrl = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.j(this.jri, d.C0236d.cp_cont_j);
        al.j(this.jrj, d.C0236d.cp_cont_j);
        al.j(this.jrk, d.C0236d.cp_cont_j);
        al.j(this.jrl, d.C0236d.cp_cont_j);
        this.jri.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.jrj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.jrl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.jrk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.jri.setCompoundDrawablePadding(mPadding);
        this.jrj.setCompoundDrawablePadding(mPadding);
        this.jrl.setCompoundDrawablePadding(mPadding);
        this.jrk.setCompoundDrawablePadding(mPadding);
    }
}
