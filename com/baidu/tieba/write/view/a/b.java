package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView nLR;
    private TextView nLS;
    private TextView nLT;
    private TextView nLU;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void F(View.OnClickListener onClickListener) {
        this.nLR.setTag(0);
        this.nLS.setTag(1);
        this.nLT.setTag(2);
        this.nLU.setTag(3);
        this.nLR.setOnClickListener(onClickListener);
        this.nLS.setOnClickListener(onClickListener);
        this.nLT.setOnClickListener(onClickListener);
        this.nLU.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.nLR = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.nLS = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.nLT = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.nLU = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nLR, R.color.CAM_X0107);
        ap.setViewTextColor(this.nLS, R.color.CAM_X0107);
        ap.setViewTextColor(this.nLT, R.color.CAM_X0107);
        ap.setViewTextColor(this.nLU, R.color.CAM_X0107);
        this.nLR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.nLS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.nLU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.nLT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.nLR.setCompoundDrawablePadding(mPadding);
        this.nLS.setCompoundDrawablePadding(mPadding);
        this.nLU.setCompoundDrawablePadding(mPadding);
        this.nLT.setCompoundDrawablePadding(mPadding);
    }
}
