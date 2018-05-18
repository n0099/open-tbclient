package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView hgo;
    private TextView hgp;
    private TextView hgq;
    private TextView hgr;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void t(View.OnClickListener onClickListener) {
        this.hgo.setTag(0);
        this.hgp.setTag(1);
        this.hgq.setTag(2);
        this.hgr.setTag(3);
        this.hgo.setOnClickListener(onClickListener);
        this.hgp.setOnClickListener(onClickListener);
        this.hgq.setOnClickListener(onClickListener);
        this.hgr.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.i.pic_rorate_view, (ViewGroup) null);
        this.hgo = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hgp = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hgq = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hgr = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        ak.h(this.hgo, d.C0126d.cp_cont_j);
        ak.h(this.hgp, d.C0126d.cp_cont_j);
        ak.h(this.hgq, d.C0126d.cp_cont_j);
        ak.h(this.hgr, d.C0126d.cp_cont_j);
        this.hgo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hgp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hgr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hgq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hgo.setCompoundDrawablePadding(mPadding);
        this.hgp.setCompoundDrawablePadding(mPadding);
        this.hgr.setCompoundDrawablePadding(mPadding);
        this.hgq.setCompoundDrawablePadding(mPadding);
    }
}
