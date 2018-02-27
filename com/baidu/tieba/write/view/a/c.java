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
    private TextView hIm;
    private TextView hIn;
    private TextView hIo;
    private TextView hIp;

    public c(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void r(View.OnClickListener onClickListener) {
        this.hIm.setTag(0);
        this.hIn.setTag(1);
        this.hIo.setTag(2);
        this.hIp.setTag(3);
        this.hIm.setOnClickListener(onClickListener);
        this.hIn.setOnClickListener(onClickListener);
        this.hIo.setOnClickListener(onClickListener);
        this.hIp.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.hIm = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hIn = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hIo = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hIp = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        aj.r(this.hIm, d.C0141d.cp_cont_j);
        aj.r(this.hIn, d.C0141d.cp_cont_j);
        aj.r(this.hIo, d.C0141d.cp_cont_j);
        aj.r(this.hIp, d.C0141d.cp_cont_j);
        this.hIm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hIn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hIp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hIo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hIm.setCompoundDrawablePadding(mPadding);
        this.hIn.setCompoundDrawablePadding(mPadding);
        this.hIp.setCompoundDrawablePadding(mPadding);
        this.hIo.setCompoundDrawablePadding(mPadding);
    }
}
