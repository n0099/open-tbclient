package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class b extends a {
    private static int mPadding;
    private TextView kQp;
    private TextView kQq;
    private TextView kQr;
    private TextView kQs;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void C(View.OnClickListener onClickListener) {
        this.kQp.setTag(0);
        this.kQq.setTag(1);
        this.kQr.setTag(2);
        this.kQs.setTag(3);
        this.kQp.setOnClickListener(onClickListener);
        this.kQq.setOnClickListener(onClickListener);
        this.kQr.setOnClickListener(onClickListener);
        this.kQs.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.kQp = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.kQq = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.kQr = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.kQs = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kQp, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kQq, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kQr, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kQs, (int) R.color.cp_cont_j);
        this.kQp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.kQq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.kQs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.kQr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.kQp.setCompoundDrawablePadding(mPadding);
        this.kQq.setCompoundDrawablePadding(mPadding);
        this.kQs.setCompoundDrawablePadding(mPadding);
        this.kQr.setCompoundDrawablePadding(mPadding);
    }
}
