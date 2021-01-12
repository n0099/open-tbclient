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
    private TextView nXF;
    private TextView nXG;
    private TextView nXH;
    private TextView nXI;

    public b(f fVar) {
        super(fVar);
        mPadding = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void H(View.OnClickListener onClickListener) {
        this.nXF.setTag(0);
        this.nXG.setTag(1);
        this.nXH.setTag(2);
        this.nXI.setTag(3);
        this.nXF.setOnClickListener(onClickListener);
        this.nXG.setOnClickListener(onClickListener);
        this.nXH.setOnClickListener(onClickListener);
        this.nXI.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.nXF = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.nXG = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.nXH = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.nXI = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.nXF, R.color.CAM_X0107);
        ao.setViewTextColor(this.nXG, R.color.CAM_X0107);
        ao.setViewTextColor(this.nXH, R.color.CAM_X0107);
        ao.setViewTextColor(this.nXI, R.color.CAM_X0107);
        this.nXF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.nXG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.nXI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.nXH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.nXF.setCompoundDrawablePadding(mPadding);
        this.nXG.setCompoundDrawablePadding(mPadding);
        this.nXI.setCompoundDrawablePadding(mPadding);
        this.nXH.setCompoundDrawablePadding(mPadding);
    }
}
