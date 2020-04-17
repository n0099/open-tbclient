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
    private TextView lCR;
    private TextView lCS;
    private TextView lCT;
    private TextView lCU;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void E(View.OnClickListener onClickListener) {
        this.lCR.setTag(0);
        this.lCS.setTag(1);
        this.lCT.setTag(2);
        this.lCU.setTag(3);
        this.lCR.setOnClickListener(onClickListener);
        this.lCS.setOnClickListener(onClickListener);
        this.lCT.setOnClickListener(onClickListener);
        this.lCU.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.lCR = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.lCS = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.lCT = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.lCU = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.lCR, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.lCS, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.lCT, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.lCU, (int) R.color.cp_cont_j);
        this.lCR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.lCS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.lCU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.lCT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.lCR.setCompoundDrawablePadding(mPadding);
        this.lCS.setCompoundDrawablePadding(mPadding);
        this.lCU.setCompoundDrawablePadding(mPadding);
        this.lCT.setCompoundDrawablePadding(mPadding);
    }
}
