package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView jST;
    private TextView jSU;
    private TextView jSV;
    private TextView jSW;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void C(View.OnClickListener onClickListener) {
        this.jST.setTag(0);
        this.jSU.setTag(1);
        this.jSV.setTag(2);
        this.jSW.setTag(3);
        this.jST.setOnClickListener(onClickListener);
        this.jSU.setOnClickListener(onClickListener);
        this.jSV.setOnClickListener(onClickListener);
        this.jSW.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.jST = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.jSU = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.jSV = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.jSW = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.jST, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jSU, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jSV, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jSW, (int) R.color.cp_cont_j);
        this.jST.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.jSU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.jSW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.jSV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.jST.setCompoundDrawablePadding(mPadding);
        this.jSU.setCompoundDrawablePadding(mPadding);
        this.jSW.setCompoundDrawablePadding(mPadding);
        this.jSV.setCompoundDrawablePadding(mPadding);
    }
}
