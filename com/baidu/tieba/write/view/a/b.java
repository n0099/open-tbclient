package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView hZq;
    private TextView hZr;
    private TextView hZs;
    private TextView hZt;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(e.C0210e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void w(View.OnClickListener onClickListener) {
        this.hZq.setTag(0);
        this.hZr.setTag(1);
        this.hZs.setTag(2);
        this.hZt.setTag(3);
        this.hZq.setOnClickListener(onClickListener);
        this.hZr.setOnClickListener(onClickListener);
        this.hZs.setOnClickListener(onClickListener);
        this.hZt.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(e.h.pic_rorate_view, (ViewGroup) null);
        this.hZq = (TextView) this.mRootView.findViewById(e.g.rotate_left);
        this.hZr = (TextView) this.mRootView.findViewById(e.g.rotate_right);
        this.hZs = (TextView) this.mRootView.findViewById(e.g.rotate_left_right);
        this.hZt = (TextView) this.mRootView.findViewById(e.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.h(this.hZq, e.d.cp_cont_j);
        al.h(this.hZr, e.d.cp_cont_j);
        al.h(this.hZs, e.d.cp_cont_j);
        al.h(this.hZt, e.d.cp_cont_j);
        this.hZq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hZr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hZt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hZs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hZq.setCompoundDrawablePadding(mPadding);
        this.hZr.setCompoundDrawablePadding(mPadding);
        this.hZt.setCompoundDrawablePadding(mPadding);
        this.hZs.setCompoundDrawablePadding(mPadding);
    }
}
