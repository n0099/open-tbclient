package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class b extends a {
    private static int mPadding;
    private TextView kRo;
    private TextView kRp;
    private TextView kRq;
    private TextView kRr;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void D(View.OnClickListener onClickListener) {
        this.kRo.setTag(0);
        this.kRp.setTag(1);
        this.kRq.setTag(2);
        this.kRr.setTag(3);
        this.kRo.setOnClickListener(onClickListener);
        this.kRp.setOnClickListener(onClickListener);
        this.kRq.setOnClickListener(onClickListener);
        this.kRr.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.kRo = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.kRp = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.kRq = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.kRr = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kRo, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kRp, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kRq, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kRr, (int) R.color.cp_cont_j);
        this.kRo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.kRp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.kRr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.kRq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.kRo.setCompoundDrawablePadding(mPadding);
        this.kRp.setCompoundDrawablePadding(mPadding);
        this.kRr.setCompoundDrawablePadding(mPadding);
        this.kRq.setCompoundDrawablePadding(mPadding);
    }
}
