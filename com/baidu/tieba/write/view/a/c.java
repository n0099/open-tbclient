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
    private TextView hGJ;
    private TextView hGK;
    private TextView hGL;
    private TextView hGM;

    public c(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(d.e.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void r(View.OnClickListener onClickListener) {
        this.hGJ.setTag(0);
        this.hGK.setTag(1);
        this.hGL.setTag(2);
        this.hGM.setTag(3);
        this.hGJ.setOnClickListener(onClickListener);
        this.hGK.setOnClickListener(onClickListener);
        this.hGL.setOnClickListener(onClickListener);
        this.hGM.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.bYg.getPageActivity()).inflate(d.h.pic_rorate_view, (ViewGroup) null);
        this.hGJ = (TextView) this.mRootView.findViewById(d.g.rotate_left);
        this.hGK = (TextView) this.mRootView.findViewById(d.g.rotate_right);
        this.hGL = (TextView) this.mRootView.findViewById(d.g.rotate_left_right);
        this.hGM = (TextView) this.mRootView.findViewById(d.g.rotate_up_down);
    }

    public void onChangeSkinType() {
        aj.r(this.hGJ, d.C0107d.cp_cont_j);
        aj.r(this.hGK, d.C0107d.cp_cont_j);
        aj.r(this.hGL, d.C0107d.cp_cont_j);
        aj.r(this.hGM, d.C0107d.cp_cont_j);
        this.hGJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.hGK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.hGM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.hGL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.hGJ.setCompoundDrawablePadding(mPadding);
        this.hGK.setCompoundDrawablePadding(mPadding);
        this.hGM.setCompoundDrawablePadding(mPadding);
        this.hGL.setCompoundDrawablePadding(mPadding);
    }
}
