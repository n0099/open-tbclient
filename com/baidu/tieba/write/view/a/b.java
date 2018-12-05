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
    private TextView hWf;
    private TextView hWg;
    private TextView hWh;
    private TextView hWi;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(e.C0210e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void w(View.OnClickListener onClickListener) {
        this.hWf.setTag(0);
        this.hWg.setTag(1);
        this.hWh.setTag(2);
        this.hWi.setTag(3);
        this.hWf.setOnClickListener(onClickListener);
        this.hWg.setOnClickListener(onClickListener);
        this.hWh.setOnClickListener(onClickListener);
        this.hWi.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(e.h.pic_rorate_view, (ViewGroup) null);
        this.hWf = (TextView) this.mRootView.findViewById(e.g.rotate_left);
        this.hWg = (TextView) this.mRootView.findViewById(e.g.rotate_right);
        this.hWh = (TextView) this.mRootView.findViewById(e.g.rotate_left_right);
        this.hWi = (TextView) this.mRootView.findViewById(e.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.h(this.hWf, e.d.cp_cont_j);
        al.h(this.hWg, e.d.cp_cont_j);
        al.h(this.hWh, e.d.cp_cont_j);
        al.h(this.hWi, e.d.cp_cont_j);
        this.hWf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hWg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hWi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hWh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hWf.setCompoundDrawablePadding(mPadding);
        this.hWg.setCompoundDrawablePadding(mPadding);
        this.hWi.setCompoundDrawablePadding(mPadding);
        this.hWh.setCompoundDrawablePadding(mPadding);
    }
}
