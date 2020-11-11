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
    private TextView nKq;
    private TextView nKr;
    private TextView nKs;
    private TextView nKt;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void G(View.OnClickListener onClickListener) {
        this.nKq.setTag(0);
        this.nKr.setTag(1);
        this.nKs.setTag(2);
        this.nKt.setTag(3);
        this.nKq.setOnClickListener(onClickListener);
        this.nKr.setOnClickListener(onClickListener);
        this.nKs.setOnClickListener(onClickListener);
        this.nKt.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.nKq = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.nKr = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.nKs = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.nKt = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nKq, R.color.cp_cont_j);
        ap.setViewTextColor(this.nKr, R.color.cp_cont_j);
        ap.setViewTextColor(this.nKs, R.color.cp_cont_j);
        ap.setViewTextColor(this.nKt, R.color.cp_cont_j);
        this.nKq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.nKr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.nKt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.nKs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.nKq.setCompoundDrawablePadding(mPadding);
        this.nKr.setCompoundDrawablePadding(mPadding);
        this.nKt.setCompoundDrawablePadding(mPadding);
        this.nKs.setCompoundDrawablePadding(mPadding);
    }
}
