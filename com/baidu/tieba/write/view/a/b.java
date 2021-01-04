package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b extends a {
    private static int mPadding;
    private TextView ocm;
    private TextView ocn;
    private TextView oco;
    private TextView ocp;

    public b(f fVar) {
        super(fVar);
        mPadding = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void H(View.OnClickListener onClickListener) {
        this.ocm.setTag(0);
        this.ocn.setTag(1);
        this.oco.setTag(2);
        this.ocp.setTag(3);
        this.ocm.setOnClickListener(onClickListener);
        this.ocn.setOnClickListener(onClickListener);
        this.oco.setOnClickListener(onClickListener);
        this.ocp.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.ocm = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.ocn = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.oco = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.ocp = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.ocm, R.color.CAM_X0107);
        ao.setViewTextColor(this.ocn, R.color.CAM_X0107);
        ao.setViewTextColor(this.oco, R.color.CAM_X0107);
        ao.setViewTextColor(this.ocp, R.color.CAM_X0107);
        this.ocm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.ocn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.ocp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.oco.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.ocm.setCompoundDrawablePadding(mPadding);
        this.ocn.setCompoundDrawablePadding(mPadding);
        this.ocp.setCompoundDrawablePadding(mPadding);
        this.oco.setCompoundDrawablePadding(mPadding);
    }
}
