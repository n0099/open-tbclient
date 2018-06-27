package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView hws;
    private TextView hwt;
    private TextView hwu;
    private TextView hwv;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void w(View.OnClickListener onClickListener) {
        this.hws.setTag(0);
        this.hwt.setTag(1);
        this.hwu.setTag(2);
        this.hwv.setTag(3);
        this.hws.setOnClickListener(onClickListener);
        this.hwt.setOnClickListener(onClickListener);
        this.hwu.setOnClickListener(onClickListener);
        this.hwv.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.i.pic_rorate_view, (ViewGroup) null);
        this.hws = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hwt = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hwu = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hwv = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.h(this.hws, d.C0142d.cp_cont_j);
        am.h(this.hwt, d.C0142d.cp_cont_j);
        am.h(this.hwu, d.C0142d.cp_cont_j);
        am.h(this.hwv, d.C0142d.cp_cont_j);
        this.hws.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hwt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hwv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hwu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hws.setCompoundDrawablePadding(mPadding);
        this.hwt.setCompoundDrawablePadding(mPadding);
        this.hwv.setCompoundDrawablePadding(mPadding);
        this.hwu.setCompoundDrawablePadding(mPadding);
    }
}
