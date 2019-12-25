package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends a {
    private static int mPadding;
    private TextView kMO;
    private TextView kMP;
    private TextView kMQ;
    private TextView kMR;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void D(View.OnClickListener onClickListener) {
        this.kMO.setTag(0);
        this.kMP.setTag(1);
        this.kMQ.setTag(2);
        this.kMR.setTag(3);
        this.kMO.setOnClickListener(onClickListener);
        this.kMP.setOnClickListener(onClickListener);
        this.kMQ.setOnClickListener(onClickListener);
        this.kMR.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.kMO = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.kMP = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.kMQ = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.kMR = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kMO, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kMP, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kMQ, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kMR, (int) R.color.cp_cont_j);
        this.kMO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.kMP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.kMR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.kMQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.kMO.setCompoundDrawablePadding(mPadding);
        this.kMP.setCompoundDrawablePadding(mPadding);
        this.kMR.setCompoundDrawablePadding(mPadding);
        this.kMQ.setCompoundDrawablePadding(mPadding);
    }
}
