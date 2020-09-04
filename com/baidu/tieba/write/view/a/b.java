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
    private TextView mSF;
    private TextView mSG;
    private TextView mSH;
    private TextView mSI;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void F(View.OnClickListener onClickListener) {
        this.mSF.setTag(0);
        this.mSG.setTag(1);
        this.mSH.setTag(2);
        this.mSI.setTag(3);
        this.mSF.setOnClickListener(onClickListener);
        this.mSG.setOnClickListener(onClickListener);
        this.mSH.setOnClickListener(onClickListener);
        this.mSI.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.mSF = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.mSG = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.mSH = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.mSI = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mSF, R.color.cp_cont_j);
        ap.setViewTextColor(this.mSG, R.color.cp_cont_j);
        ap.setViewTextColor(this.mSH, R.color.cp_cont_j);
        ap.setViewTextColor(this.mSI, R.color.cp_cont_j);
        this.mSF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.mSG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.mSI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.mSH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.mSF.setCompoundDrawablePadding(mPadding);
        this.mSG.setCompoundDrawablePadding(mPadding);
        this.mSI.setCompoundDrawablePadding(mPadding);
        this.mSH.setCompoundDrawablePadding(mPadding);
    }
}
