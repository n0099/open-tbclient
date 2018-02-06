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
    private TextView hIA;
    private TextView hIB;
    private TextView hIC;
    private TextView hIz;

    public c(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void r(View.OnClickListener onClickListener) {
        this.hIz.setTag(0);
        this.hIA.setTag(1);
        this.hIB.setTag(2);
        this.hIC.setTag(3);
        this.hIz.setOnClickListener(onClickListener);
        this.hIA.setOnClickListener(onClickListener);
        this.hIB.setOnClickListener(onClickListener);
        this.hIC.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.hIz = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hIA = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hIB = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hIC = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        aj.r(this.hIz, d.C0140d.cp_cont_j);
        aj.r(this.hIA, d.C0140d.cp_cont_j);
        aj.r(this.hIB, d.C0140d.cp_cont_j);
        aj.r(this.hIC, d.C0140d.cp_cont_j);
        this.hIz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hIA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hIC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hIB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hIz.setCompoundDrawablePadding(mPadding);
        this.hIA.setCompoundDrawablePadding(mPadding);
        this.hIC.setCompoundDrawablePadding(mPadding);
        this.hIB.setCompoundDrawablePadding(mPadding);
    }
}
