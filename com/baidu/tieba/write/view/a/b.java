package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView jrt;
    private TextView jru;
    private TextView jrv;
    private TextView jrw;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void x(View.OnClickListener onClickListener) {
        this.jrt.setTag(0);
        this.jru.setTag(1);
        this.jrv.setTag(2);
        this.jrw.setTag(3);
        this.jrt.setOnClickListener(onClickListener);
        this.jru.setOnClickListener(onClickListener);
        this.jrv.setOnClickListener(onClickListener);
        this.jrw.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.jrt = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.jru = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.jrv = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.jrw = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.j(this.jrt, d.C0277d.cp_cont_j);
        al.j(this.jru, d.C0277d.cp_cont_j);
        al.j(this.jrv, d.C0277d.cp_cont_j);
        al.j(this.jrw, d.C0277d.cp_cont_j);
        this.jrt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.jru.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.jrw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.jrv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.jrt.setCompoundDrawablePadding(mPadding);
        this.jru.setCompoundDrawablePadding(mPadding);
        this.jrw.setCompoundDrawablePadding(mPadding);
        this.jrv.setCompoundDrawablePadding(mPadding);
    }
}
