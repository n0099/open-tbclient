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
    private TextView ncA;
    private TextView ncB;
    private TextView ncy;
    private TextView ncz;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void F(View.OnClickListener onClickListener) {
        this.ncy.setTag(0);
        this.ncz.setTag(1);
        this.ncA.setTag(2);
        this.ncB.setTag(3);
        this.ncy.setOnClickListener(onClickListener);
        this.ncz.setOnClickListener(onClickListener);
        this.ncA.setOnClickListener(onClickListener);
        this.ncB.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.ncy = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.ncz = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.ncA = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.ncB = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.ncy, R.color.cp_cont_j);
        ap.setViewTextColor(this.ncz, R.color.cp_cont_j);
        ap.setViewTextColor(this.ncA, R.color.cp_cont_j);
        ap.setViewTextColor(this.ncB, R.color.cp_cont_j);
        this.ncy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.ncz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.ncB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.ncA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.ncy.setCompoundDrawablePadding(mPadding);
        this.ncz.setCompoundDrawablePadding(mPadding);
        this.ncB.setCompoundDrawablePadding(mPadding);
        this.ncA.setCompoundDrawablePadding(mPadding);
    }
}
