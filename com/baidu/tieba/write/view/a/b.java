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
    private TextView hOV;
    private TextView hOW;
    private TextView hOX;
    private TextView hOY;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(e.C0200e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void w(View.OnClickListener onClickListener) {
        this.hOV.setTag(0);
        this.hOW.setTag(1);
        this.hOX.setTag(2);
        this.hOY.setTag(3);
        this.hOV.setOnClickListener(onClickListener);
        this.hOW.setOnClickListener(onClickListener);
        this.hOX.setOnClickListener(onClickListener);
        this.hOY.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(e.h.pic_rorate_view, (ViewGroup) null);
        this.hOV = (TextView) this.mRootView.findViewById(e.g.rotate_left);
        this.hOW = (TextView) this.mRootView.findViewById(e.g.rotate_right);
        this.hOX = (TextView) this.mRootView.findViewById(e.g.rotate_left_right);
        this.hOY = (TextView) this.mRootView.findViewById(e.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.h(this.hOV, e.d.cp_cont_j);
        al.h(this.hOW, e.d.cp_cont_j);
        al.h(this.hOX, e.d.cp_cont_j);
        al.h(this.hOY, e.d.cp_cont_j);
        this.hOV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hOW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hOY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hOX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hOV.setCompoundDrawablePadding(mPadding);
        this.hOW.setCompoundDrawablePadding(mPadding);
        this.hOY.setCompoundDrawablePadding(mPadding);
        this.hOX.setCompoundDrawablePadding(mPadding);
    }
}
