package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView mzU;
    private TextView mzV;
    private TextView mzW;
    private TextView mzX;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void E(View.OnClickListener onClickListener) {
        this.mzU.setTag(0);
        this.mzV.setTag(1);
        this.mzW.setTag(2);
        this.mzX.setTag(3);
        this.mzU.setOnClickListener(onClickListener);
        this.mzV.setOnClickListener(onClickListener);
        this.mzW.setOnClickListener(onClickListener);
        this.mzX.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.mzU = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.mzV = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.mzW = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.mzX = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mzU, R.color.cp_cont_j);
        ao.setViewTextColor(this.mzV, R.color.cp_cont_j);
        ao.setViewTextColor(this.mzW, R.color.cp_cont_j);
        ao.setViewTextColor(this.mzX, R.color.cp_cont_j);
        this.mzU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.mzV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.mzX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.mzW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.mzU.setCompoundDrawablePadding(mPadding);
        this.mzV.setCompoundDrawablePadding(mPadding);
        this.mzX.setCompoundDrawablePadding(mPadding);
        this.mzW.setCompoundDrawablePadding(mPadding);
    }
}
