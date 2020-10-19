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
    private TextView nrX;
    private TextView nrY;
    private TextView nrZ;
    private TextView nsa;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void F(View.OnClickListener onClickListener) {
        this.nrX.setTag(0);
        this.nrY.setTag(1);
        this.nrZ.setTag(2);
        this.nsa.setTag(3);
        this.nrX.setOnClickListener(onClickListener);
        this.nrY.setOnClickListener(onClickListener);
        this.nrZ.setOnClickListener(onClickListener);
        this.nsa.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.nrX = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.nrY = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.nrZ = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.nsa = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nrX, R.color.cp_cont_j);
        ap.setViewTextColor(this.nrY, R.color.cp_cont_j);
        ap.setViewTextColor(this.nrZ, R.color.cp_cont_j);
        ap.setViewTextColor(this.nsa, R.color.cp_cont_j);
        this.nrX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.nrY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.nsa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.nrZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.nrX.setCompoundDrawablePadding(mPadding);
        this.nrY.setCompoundDrawablePadding(mPadding);
        this.nsa.setCompoundDrawablePadding(mPadding);
        this.nrZ.setCompoundDrawablePadding(mPadding);
    }
}
