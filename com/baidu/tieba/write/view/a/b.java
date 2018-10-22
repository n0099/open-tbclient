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
    private TextView hNl;
    private TextView hNm;
    private TextView hNn;
    private TextView hNo;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(e.C0175e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void u(View.OnClickListener onClickListener) {
        this.hNl.setTag(0);
        this.hNm.setTag(1);
        this.hNn.setTag(2);
        this.hNo.setTag(3);
        this.hNl.setOnClickListener(onClickListener);
        this.hNm.setOnClickListener(onClickListener);
        this.hNn.setOnClickListener(onClickListener);
        this.hNo.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(e.h.pic_rorate_view, (ViewGroup) null);
        this.hNl = (TextView) this.mRootView.findViewById(e.g.rotate_left);
        this.hNm = (TextView) this.mRootView.findViewById(e.g.rotate_right);
        this.hNn = (TextView) this.mRootView.findViewById(e.g.rotate_left_right);
        this.hNo = (TextView) this.mRootView.findViewById(e.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.h(this.hNl, e.d.cp_cont_j);
        al.h(this.hNm, e.d.cp_cont_j);
        al.h(this.hNn, e.d.cp_cont_j);
        al.h(this.hNo, e.d.cp_cont_j);
        this.hNl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hNm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hNo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hNn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hNl.setCompoundDrawablePadding(mPadding);
        this.hNm.setCompoundDrawablePadding(mPadding);
        this.hNo.setCompoundDrawablePadding(mPadding);
        this.hNn.setCompoundDrawablePadding(mPadding);
    }
}
