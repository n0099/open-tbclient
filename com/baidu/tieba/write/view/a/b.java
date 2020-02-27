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
    private TextView kRa;
    private TextView kRb;
    private TextView kRc;
    private TextView kRd;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void D(View.OnClickListener onClickListener) {
        this.kRa.setTag(0);
        this.kRb.setTag(1);
        this.kRc.setTag(2);
        this.kRd.setTag(3);
        this.kRa.setOnClickListener(onClickListener);
        this.kRb.setOnClickListener(onClickListener);
        this.kRc.setOnClickListener(onClickListener);
        this.kRd.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.kRa = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.kRb = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.kRc = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.kRd = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kRa, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kRb, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kRc, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kRd, (int) R.color.cp_cont_j);
        this.kRa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.kRb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.kRd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.kRc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.kRa.setCompoundDrawablePadding(mPadding);
        this.kRb.setCompoundDrawablePadding(mPadding);
        this.kRd.setCompoundDrawablePadding(mPadding);
        this.kRc.setCompoundDrawablePadding(mPadding);
    }
}
