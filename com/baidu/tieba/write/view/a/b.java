package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView hxB;
    private TextView hxC;
    private TextView hxD;
    private TextView hxE;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(f.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void u(View.OnClickListener onClickListener) {
        this.hxB.setTag(0);
        this.hxC.setTag(1);
        this.hxD.setTag(2);
        this.hxE.setTag(3);
        this.hxB.setOnClickListener(onClickListener);
        this.hxC.setOnClickListener(onClickListener);
        this.hxD.setOnClickListener(onClickListener);
        this.hxE.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(f.h.pic_rorate_view, (ViewGroup) null);
        this.hxB = (TextView) this.mRootView.findViewById(f.g.rotate_left);
        this.hxC = (TextView) this.mRootView.findViewById(f.g.rotate_right);
        this.hxD = (TextView) this.mRootView.findViewById(f.g.rotate_left_right);
        this.hxE = (TextView) this.mRootView.findViewById(f.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.h(this.hxB, f.d.cp_cont_j);
        am.h(this.hxC, f.d.cp_cont_j);
        am.h(this.hxD, f.d.cp_cont_j);
        am.h(this.hxE, f.d.cp_cont_j);
        this.hxB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hxC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hxE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hxD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hxB.setCompoundDrawablePadding(mPadding);
        this.hxC.setCompoundDrawablePadding(mPadding);
        this.hxE.setCompoundDrawablePadding(mPadding);
        this.hxD.setCompoundDrawablePadding(mPadding);
    }
}
