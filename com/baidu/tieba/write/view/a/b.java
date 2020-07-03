package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b extends a {
    private static int mPadding;
    private TextView mrR;
    private TextView mrS;
    private TextView mrT;
    private TextView mrU;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void E(View.OnClickListener onClickListener) {
        this.mrR.setTag(0);
        this.mrS.setTag(1);
        this.mrT.setTag(2);
        this.mrU.setTag(3);
        this.mrR.setOnClickListener(onClickListener);
        this.mrS.setOnClickListener(onClickListener);
        this.mrT.setOnClickListener(onClickListener);
        this.mrU.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.mrR = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.mrS = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.mrT = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.mrU = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.mrR, (int) R.color.cp_cont_j);
        an.setViewTextColor(this.mrS, (int) R.color.cp_cont_j);
        an.setViewTextColor(this.mrT, (int) R.color.cp_cont_j);
        an.setViewTextColor(this.mrU, (int) R.color.cp_cont_j);
        this.mrR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.mrS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.mrU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.mrT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.mrR.setCompoundDrawablePadding(mPadding);
        this.mrS.setCompoundDrawablePadding(mPadding);
        this.mrU.setCompoundDrawablePadding(mPadding);
        this.mrT.setCompoundDrawablePadding(mPadding);
    }
}
