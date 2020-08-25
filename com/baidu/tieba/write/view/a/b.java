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
    private TextView mSl;
    private TextView mSm;
    private TextView mSn;
    private TextView mSo;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void F(View.OnClickListener onClickListener) {
        this.mSl.setTag(0);
        this.mSm.setTag(1);
        this.mSn.setTag(2);
        this.mSo.setTag(3);
        this.mSl.setOnClickListener(onClickListener);
        this.mSm.setOnClickListener(onClickListener);
        this.mSn.setOnClickListener(onClickListener);
        this.mSo.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.mSl = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.mSm = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.mSn = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.mSo = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mSl, R.color.cp_cont_j);
        ap.setViewTextColor(this.mSm, R.color.cp_cont_j);
        ap.setViewTextColor(this.mSn, R.color.cp_cont_j);
        ap.setViewTextColor(this.mSo, R.color.cp_cont_j);
        this.mSl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.mSm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.mSo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.mSn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.mSl.setCompoundDrawablePadding(mPadding);
        this.mSm.setCompoundDrawablePadding(mPadding);
        this.mSo.setCompoundDrawablePadding(mPadding);
        this.mSn.setCompoundDrawablePadding(mPadding);
    }
}
