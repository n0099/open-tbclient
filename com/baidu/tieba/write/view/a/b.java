package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends a {
    private static int mPadding;
    private TextView jSA;
    private TextView jSx;
    private TextView jSy;
    private TextView jSz;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void B(View.OnClickListener onClickListener) {
        this.jSx.setTag(0);
        this.jSy.setTag(1);
        this.jSz.setTag(2);
        this.jSA.setTag(3);
        this.jSx.setOnClickListener(onClickListener);
        this.jSy.setOnClickListener(onClickListener);
        this.jSz.setOnClickListener(onClickListener);
        this.jSA.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.jSx = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.jSy = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.jSz = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.jSA = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.j(this.jSx, R.color.cp_cont_j);
        am.j(this.jSy, R.color.cp_cont_j);
        am.j(this.jSz, R.color.cp_cont_j);
        am.j(this.jSA, R.color.cp_cont_j);
        this.jSx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.jSy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.jSA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.jSz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.jSx.setCompoundDrawablePadding(mPadding);
        this.jSy.setCompoundDrawablePadding(mPadding);
        this.jSA.setCompoundDrawablePadding(mPadding);
        this.jSz.setCompoundDrawablePadding(mPadding);
    }
}
