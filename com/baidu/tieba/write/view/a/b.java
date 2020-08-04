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
    private TextView mzW;
    private TextView mzX;
    private TextView mzY;
    private TextView mzZ;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void E(View.OnClickListener onClickListener) {
        this.mzW.setTag(0);
        this.mzX.setTag(1);
        this.mzY.setTag(2);
        this.mzZ.setTag(3);
        this.mzW.setOnClickListener(onClickListener);
        this.mzX.setOnClickListener(onClickListener);
        this.mzY.setOnClickListener(onClickListener);
        this.mzZ.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.mzW = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.mzX = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.mzY = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.mzZ = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mzW, R.color.cp_cont_j);
        ao.setViewTextColor(this.mzX, R.color.cp_cont_j);
        ao.setViewTextColor(this.mzY, R.color.cp_cont_j);
        ao.setViewTextColor(this.mzZ, R.color.cp_cont_j);
        this.mzW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.mzX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.mzZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.mzY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.mzW.setCompoundDrawablePadding(mPadding);
        this.mzX.setCompoundDrawablePadding(mPadding);
        this.mzZ.setCompoundDrawablePadding(mPadding);
        this.mzY.setCompoundDrawablePadding(mPadding);
    }
}
