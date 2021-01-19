package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class b extends a {
    private static int mPadding;
    private TextView nXG;
    private TextView nXH;
    private TextView nXI;
    private TextView nXJ;

    public b(f fVar) {
        super(fVar);
        mPadding = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void H(View.OnClickListener onClickListener) {
        this.nXG.setTag(0);
        this.nXH.setTag(1);
        this.nXI.setTag(2);
        this.nXJ.setTag(3);
        this.nXG.setOnClickListener(onClickListener);
        this.nXH.setOnClickListener(onClickListener);
        this.nXI.setOnClickListener(onClickListener);
        this.nXJ.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.nXG = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.nXH = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.nXI = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.nXJ = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.nXG, R.color.CAM_X0107);
        ao.setViewTextColor(this.nXH, R.color.CAM_X0107);
        ao.setViewTextColor(this.nXI, R.color.CAM_X0107);
        ao.setViewTextColor(this.nXJ, R.color.CAM_X0107);
        this.nXG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.nXH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.nXJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.nXI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.nXG.setCompoundDrawablePadding(mPadding);
        this.nXH.setCompoundDrawablePadding(mPadding);
        this.nXJ.setCompoundDrawablePadding(mPadding);
        this.nXI.setCompoundDrawablePadding(mPadding);
    }
}
