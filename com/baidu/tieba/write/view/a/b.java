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
    private TextView lCV;
    private TextView lCW;
    private TextView lCX;
    private TextView lCY;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void E(View.OnClickListener onClickListener) {
        this.lCV.setTag(0);
        this.lCW.setTag(1);
        this.lCX.setTag(2);
        this.lCY.setTag(3);
        this.lCV.setOnClickListener(onClickListener);
        this.lCW.setOnClickListener(onClickListener);
        this.lCX.setOnClickListener(onClickListener);
        this.lCY.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.lCV = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.lCW = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.lCX = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.lCY = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.lCV, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.lCW, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.lCX, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.lCY, (int) R.color.cp_cont_j);
        this.lCV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.lCW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.lCY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.lCX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.lCV.setCompoundDrawablePadding(mPadding);
        this.lCW.setCompoundDrawablePadding(mPadding);
        this.lCY.setCompoundDrawablePadding(mPadding);
        this.lCX.setCompoundDrawablePadding(mPadding);
    }
}
