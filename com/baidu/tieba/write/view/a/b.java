package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView hxA;
    private TextView hxB;
    private TextView hxC;
    private TextView hxz;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void u(View.OnClickListener onClickListener) {
        this.hxz.setTag(0);
        this.hxA.setTag(1);
        this.hxB.setTag(2);
        this.hxC.setTag(3);
        this.hxz.setOnClickListener(onClickListener);
        this.hxA.setOnClickListener(onClickListener);
        this.hxB.setOnClickListener(onClickListener);
        this.hxC.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.hxz = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hxA = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hxB = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hxC = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.h(this.hxz, d.C0140d.cp_cont_j);
        am.h(this.hxA, d.C0140d.cp_cont_j);
        am.h(this.hxB, d.C0140d.cp_cont_j);
        am.h(this.hxC, d.C0140d.cp_cont_j);
        this.hxz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hxA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hxC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hxB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hxz.setCompoundDrawablePadding(mPadding);
        this.hxA.setCompoundDrawablePadding(mPadding);
        this.hxC.setCompoundDrawablePadding(mPadding);
        this.hxB.setCompoundDrawablePadding(mPadding);
    }
}
