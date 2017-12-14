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
    private TextView hiU;
    private TextView hiV;
    private TextView hiW;
    private TextView hiX;

    public c(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void q(View.OnClickListener onClickListener) {
        this.hiU.setTag(0);
        this.hiV.setTag(1);
        this.hiW.setTag(2);
        this.hiX.setTag(3);
        this.hiU.setOnClickListener(onClickListener);
        this.hiV.setOnClickListener(onClickListener);
        this.hiW.setOnClickListener(onClickListener);
        this.hiX.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.bkK.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.hiU = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hiV = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hiW = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hiX = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        aj.i(this.hiU, d.C0096d.cp_cont_j);
        aj.i(this.hiV, d.C0096d.cp_cont_j);
        aj.i(this.hiW, d.C0096d.cp_cont_j);
        aj.i(this.hiX, d.C0096d.cp_cont_j);
        this.hiU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hiV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hiX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hiW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hiU.setCompoundDrawablePadding(mPadding);
        this.hiV.setCompoundDrawablePadding(mPadding);
        this.hiX.setCompoundDrawablePadding(mPadding);
        this.hiW.setCompoundDrawablePadding(mPadding);
    }
}
