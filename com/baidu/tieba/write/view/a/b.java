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
    private TextView iaA;
    private TextView iax;
    private TextView iay;
    private TextView iaz;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(e.C0210e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void w(View.OnClickListener onClickListener) {
        this.iax.setTag(0);
        this.iay.setTag(1);
        this.iaz.setTag(2);
        this.iaA.setTag(3);
        this.iax.setOnClickListener(onClickListener);
        this.iay.setOnClickListener(onClickListener);
        this.iaz.setOnClickListener(onClickListener);
        this.iaA.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(e.h.pic_rorate_view, (ViewGroup) null);
        this.iax = (TextView) this.mRootView.findViewById(e.g.rotate_left);
        this.iay = (TextView) this.mRootView.findViewById(e.g.rotate_right);
        this.iaz = (TextView) this.mRootView.findViewById(e.g.rotate_left_right);
        this.iaA = (TextView) this.mRootView.findViewById(e.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.h(this.iax, e.d.cp_cont_j);
        al.h(this.iay, e.d.cp_cont_j);
        al.h(this.iaz, e.d.cp_cont_j);
        al.h(this.iaA, e.d.cp_cont_j);
        this.iax.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.iay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.iaA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.iaz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.iax.setCompoundDrawablePadding(mPadding);
        this.iay.setCompoundDrawablePadding(mPadding);
        this.iaA.setCompoundDrawablePadding(mPadding);
        this.iaz.setCompoundDrawablePadding(mPadding);
    }
}
