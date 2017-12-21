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
    private TextView hiZ;
    private TextView hja;
    private TextView hjb;
    private TextView hjc;

    public c(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void q(View.OnClickListener onClickListener) {
        this.hiZ.setTag(0);
        this.hja.setTag(1);
        this.hjb.setTag(2);
        this.hjc.setTag(3);
        this.hiZ.setOnClickListener(onClickListener);
        this.hja.setOnClickListener(onClickListener);
        this.hjb.setOnClickListener(onClickListener);
        this.hjc.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.bkO.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.hiZ = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hja = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hjb = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hjc = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        aj.i(this.hiZ, d.C0095d.cp_cont_j);
        aj.i(this.hja, d.C0095d.cp_cont_j);
        aj.i(this.hjb, d.C0095d.cp_cont_j);
        aj.i(this.hjc, d.C0095d.cp_cont_j);
        this.hiZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hja.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hjc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hjb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hiZ.setCompoundDrawablePadding(mPadding);
        this.hja.setCompoundDrawablePadding(mPadding);
        this.hjc.setCompoundDrawablePadding(mPadding);
        this.hjb.setCompoundDrawablePadding(mPadding);
    }
}
