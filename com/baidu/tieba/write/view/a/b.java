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
    private TextView nEw;
    private TextView nEx;
    private TextView nEy;
    private TextView nEz;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void F(View.OnClickListener onClickListener) {
        this.nEw.setTag(0);
        this.nEx.setTag(1);
        this.nEy.setTag(2);
        this.nEz.setTag(3);
        this.nEw.setOnClickListener(onClickListener);
        this.nEx.setOnClickListener(onClickListener);
        this.nEy.setOnClickListener(onClickListener);
        this.nEz.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.nEw = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.nEx = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.nEy = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.nEz = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nEw, R.color.cp_cont_j);
        ap.setViewTextColor(this.nEx, R.color.cp_cont_j);
        ap.setViewTextColor(this.nEy, R.color.cp_cont_j);
        ap.setViewTextColor(this.nEz, R.color.cp_cont_j);
        this.nEw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.nEx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.nEz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.nEy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.nEw.setCompoundDrawablePadding(mPadding);
        this.nEx.setCompoundDrawablePadding(mPadding);
        this.nEz.setCompoundDrawablePadding(mPadding);
        this.nEy.setCompoundDrawablePadding(mPadding);
    }
}
