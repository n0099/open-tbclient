package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView jKq;
    private TextView jKr;
    private TextView jKs;
    private TextView jKt;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void z(View.OnClickListener onClickListener) {
        this.jKq.setTag(0);
        this.jKr.setTag(1);
        this.jKs.setTag(2);
        this.jKt.setTag(3);
        this.jKq.setOnClickListener(onClickListener);
        this.jKr.setOnClickListener(onClickListener);
        this.jKs.setOnClickListener(onClickListener);
        this.jKt.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.jKq = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.jKr = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.jKs = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.jKt = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.j(this.jKq, R.color.cp_cont_j);
        al.j(this.jKr, R.color.cp_cont_j);
        al.j(this.jKs, R.color.cp_cont_j);
        al.j(this.jKt, R.color.cp_cont_j);
        this.jKq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.jKr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.jKt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.jKs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.jKq.setCompoundDrawablePadding(mPadding);
        this.jKr.setCompoundDrawablePadding(mPadding);
        this.jKt.setCompoundDrawablePadding(mPadding);
        this.jKs.setCompoundDrawablePadding(mPadding);
    }
}
