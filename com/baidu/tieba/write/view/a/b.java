package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b extends a {
    private static int mPadding;
    private TextView ohM;
    private TextView ohN;
    private TextView ohO;
    private TextView ohP;

    public b(f fVar) {
        super(fVar);
        mPadding = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void H(View.OnClickListener onClickListener) {
        this.ohM.setTag(0);
        this.ohN.setTag(1);
        this.ohO.setTag(2);
        this.ohP.setTag(3);
        this.ohM.setOnClickListener(onClickListener);
        this.ohN.setOnClickListener(onClickListener);
        this.ohO.setOnClickListener(onClickListener);
        this.ohP.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.ohM = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.ohN = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.ohO = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.ohP = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.ohM, R.color.CAM_X0107);
        ap.setViewTextColor(this.ohN, R.color.CAM_X0107);
        ap.setViewTextColor(this.ohO, R.color.CAM_X0107);
        ap.setViewTextColor(this.ohP, R.color.CAM_X0107);
        this.ohM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.ohN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.ohP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.ohO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.ohM.setCompoundDrawablePadding(mPadding);
        this.ohN.setCompoundDrawablePadding(mPadding);
        this.ohP.setCompoundDrawablePadding(mPadding);
        this.ohO.setCompoundDrawablePadding(mPadding);
    }
}
