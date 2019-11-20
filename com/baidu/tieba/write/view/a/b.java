package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView jSc;
    private TextView jSd;
    private TextView jSe;
    private TextView jSf;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void C(View.OnClickListener onClickListener) {
        this.jSc.setTag(0);
        this.jSd.setTag(1);
        this.jSe.setTag(2);
        this.jSf.setTag(3);
        this.jSc.setOnClickListener(onClickListener);
        this.jSd.setOnClickListener(onClickListener);
        this.jSe.setOnClickListener(onClickListener);
        this.jSf.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.jSc = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.jSd = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.jSe = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.jSf = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.jSc, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jSd, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jSe, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jSf, (int) R.color.cp_cont_j);
        this.jSc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.jSd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.jSf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.jSe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.jSc.setCompoundDrawablePadding(mPadding);
        this.jSd.setCompoundDrawablePadding(mPadding);
        this.jSf.setCompoundDrawablePadding(mPadding);
        this.jSe.setCompoundDrawablePadding(mPadding);
    }
}
