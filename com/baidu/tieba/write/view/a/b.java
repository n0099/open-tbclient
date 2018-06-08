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
    private TextView hsj;
    private TextView hsk;
    private TextView hsl;
    private TextView hsm;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void t(View.OnClickListener onClickListener) {
        this.hsj.setTag(0);
        this.hsk.setTag(1);
        this.hsl.setTag(2);
        this.hsm.setTag(3);
        this.hsj.setOnClickListener(onClickListener);
        this.hsk.setOnClickListener(onClickListener);
        this.hsl.setOnClickListener(onClickListener);
        this.hsm.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.i.pic_rorate_view, (ViewGroup) null);
        this.hsj = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hsk = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hsl = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hsm = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.h(this.hsj, d.C0141d.cp_cont_j);
        al.h(this.hsk, d.C0141d.cp_cont_j);
        al.h(this.hsl, d.C0141d.cp_cont_j);
        al.h(this.hsm, d.C0141d.cp_cont_j);
        this.hsj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hsk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hsm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hsl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hsj.setCompoundDrawablePadding(mPadding);
        this.hsk.setCompoundDrawablePadding(mPadding);
        this.hsm.setCompoundDrawablePadding(mPadding);
        this.hsl.setCompoundDrawablePadding(mPadding);
    }
}
