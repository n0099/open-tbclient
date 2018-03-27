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
    private TextView hIK;
    private TextView hIL;
    private TextView hIM;
    private TextView hIN;

    public c(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void r(View.OnClickListener onClickListener) {
        this.hIK.setTag(0);
        this.hIL.setTag(1);
        this.hIM.setTag(2);
        this.hIN.setTag(3);
        this.hIK.setOnClickListener(onClickListener);
        this.hIL.setOnClickListener(onClickListener);
        this.hIM.setOnClickListener(onClickListener);
        this.hIN.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.hIK = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hIL = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hIM = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hIN = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        aj.r(this.hIK, d.C0141d.cp_cont_j);
        aj.r(this.hIL, d.C0141d.cp_cont_j);
        aj.r(this.hIM, d.C0141d.cp_cont_j);
        aj.r(this.hIN, d.C0141d.cp_cont_j);
        this.hIK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hIL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hIN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hIM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hIK.setCompoundDrawablePadding(mPadding);
        this.hIL.setCompoundDrawablePadding(mPadding);
        this.hIN.setCompoundDrawablePadding(mPadding);
        this.hIM.setCompoundDrawablePadding(mPadding);
    }
}
