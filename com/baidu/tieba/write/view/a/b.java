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
    private TextView hFY;
    private TextView hFZ;
    private TextView hGa;
    private TextView hGb;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(e.C0141e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void u(View.OnClickListener onClickListener) {
        this.hFY.setTag(0);
        this.hFZ.setTag(1);
        this.hGa.setTag(2);
        this.hGb.setTag(3);
        this.hFY.setOnClickListener(onClickListener);
        this.hFZ.setOnClickListener(onClickListener);
        this.hGa.setOnClickListener(onClickListener);
        this.hGb.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(e.h.pic_rorate_view, (ViewGroup) null);
        this.hFY = (TextView) this.mRootView.findViewById(e.g.rotate_left);
        this.hFZ = (TextView) this.mRootView.findViewById(e.g.rotate_right);
        this.hGa = (TextView) this.mRootView.findViewById(e.g.rotate_left_right);
        this.hGb = (TextView) this.mRootView.findViewById(e.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.h(this.hFY, e.d.cp_cont_j);
        al.h(this.hFZ, e.d.cp_cont_j);
        al.h(this.hGa, e.d.cp_cont_j);
        al.h(this.hGb, e.d.cp_cont_j);
        this.hFY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hFZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hGb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hGa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hFY.setCompoundDrawablePadding(mPadding);
        this.hFZ.setCompoundDrawablePadding(mPadding);
        this.hGb.setCompoundDrawablePadding(mPadding);
        this.hGa.setCompoundDrawablePadding(mPadding);
    }
}
