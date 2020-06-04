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
    private TextView lXu;
    private TextView lXv;
    private TextView lXw;
    private TextView lXx;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void D(View.OnClickListener onClickListener) {
        this.lXu.setTag(0);
        this.lXv.setTag(1);
        this.lXw.setTag(2);
        this.lXx.setTag(3);
        this.lXu.setOnClickListener(onClickListener);
        this.lXv.setOnClickListener(onClickListener);
        this.lXw.setOnClickListener(onClickListener);
        this.lXx.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.lXu = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.lXv = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.lXw = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.lXx = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.lXu, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.lXv, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.lXw, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.lXx, (int) R.color.cp_cont_j);
        this.lXu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.lXv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.lXx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.lXw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.lXu.setCompoundDrawablePadding(mPadding);
        this.lXv.setCompoundDrawablePadding(mPadding);
        this.lXx.setCompoundDrawablePadding(mPadding);
        this.lXw.setCompoundDrawablePadding(mPadding);
    }
}
