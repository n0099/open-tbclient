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
    private TextView jKn;
    private TextView jKo;
    private TextView jKp;
    private TextView jKq;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void z(View.OnClickListener onClickListener) {
        this.jKn.setTag(0);
        this.jKo.setTag(1);
        this.jKp.setTag(2);
        this.jKq.setTag(3);
        this.jKn.setOnClickListener(onClickListener);
        this.jKo.setOnClickListener(onClickListener);
        this.jKp.setOnClickListener(onClickListener);
        this.jKq.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.jKn = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.jKo = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.jKp = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.jKq = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        al.j(this.jKn, R.color.cp_cont_j);
        al.j(this.jKo, R.color.cp_cont_j);
        al.j(this.jKp, R.color.cp_cont_j);
        al.j(this.jKq, R.color.cp_cont_j);
        this.jKn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.jKo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.jKq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.jKp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.jKn.setCompoundDrawablePadding(mPadding);
        this.jKo.setCompoundDrawablePadding(mPadding);
        this.jKq.setCompoundDrawablePadding(mPadding);
        this.jKp.setCompoundDrawablePadding(mPadding);
    }
}
