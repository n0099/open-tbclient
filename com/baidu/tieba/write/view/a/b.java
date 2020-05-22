package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b extends a {
    private static int mPadding;
    private TextView lWj;
    private TextView lWk;
    private TextView lWl;
    private TextView lWm;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void D(View.OnClickListener onClickListener) {
        this.lWj.setTag(0);
        this.lWk.setTag(1);
        this.lWl.setTag(2);
        this.lWm.setTag(3);
        this.lWj.setOnClickListener(onClickListener);
        this.lWk.setOnClickListener(onClickListener);
        this.lWl.setOnClickListener(onClickListener);
        this.lWm.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.lWj = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.lWk = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.lWl = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.lWm = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.lWj, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.lWk, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.lWl, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.lWm, (int) R.color.cp_cont_j);
        this.lWj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.lWk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.lWm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.lWl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.lWj.setCompoundDrawablePadding(mPadding);
        this.lWk.setCompoundDrawablePadding(mPadding);
        this.lWm.setCompoundDrawablePadding(mPadding);
        this.lWl.setCompoundDrawablePadding(mPadding);
    }
}
