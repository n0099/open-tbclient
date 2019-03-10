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
    private TextView jrB;
    private TextView jrC;
    private TextView jrD;
    private TextView jrE;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void x(View.OnClickListener onClickListener) {
        this.jrB.setTag(0);
        this.jrC.setTag(1);
        this.jrD.setTag(2);
        this.jrE.setTag(3);
        this.jrB.setOnClickListener(onClickListener);
        this.jrC.setOnClickListener(onClickListener);
        this.jrD.setOnClickListener(onClickListener);
        this.jrE.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.jrB = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.jrC = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.jrD = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.jrE = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.j(this.jrB, d.C0236d.cp_cont_j);
        al.j(this.jrC, d.C0236d.cp_cont_j);
        al.j(this.jrD, d.C0236d.cp_cont_j);
        al.j(this.jrE, d.C0236d.cp_cont_j);
        this.jrB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.jrC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.jrE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.jrD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.jrB.setCompoundDrawablePadding(mPadding);
        this.jrC.setCompoundDrawablePadding(mPadding);
        this.jrE.setCompoundDrawablePadding(mPadding);
        this.jrD.setCompoundDrawablePadding(mPadding);
    }
}
