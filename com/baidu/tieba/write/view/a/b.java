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
    private TextView mrU;
    private TextView mrV;
    private TextView mrW;
    private TextView mrX;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void E(View.OnClickListener onClickListener) {
        this.mrU.setTag(0);
        this.mrV.setTag(1);
        this.mrW.setTag(2);
        this.mrX.setTag(3);
        this.mrU.setOnClickListener(onClickListener);
        this.mrV.setOnClickListener(onClickListener);
        this.mrW.setOnClickListener(onClickListener);
        this.mrX.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.mrU = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.mrV = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.mrW = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.mrX = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.mrU, (int) R.color.cp_cont_j);
        an.setViewTextColor(this.mrV, (int) R.color.cp_cont_j);
        an.setViewTextColor(this.mrW, (int) R.color.cp_cont_j);
        an.setViewTextColor(this.mrX, (int) R.color.cp_cont_j);
        this.mrU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.mrV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.mrX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.mrW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.mrU.setCompoundDrawablePadding(mPadding);
        this.mrV.setCompoundDrawablePadding(mPadding);
        this.mrX.setCompoundDrawablePadding(mPadding);
        this.mrW.setCompoundDrawablePadding(mPadding);
    }
}
