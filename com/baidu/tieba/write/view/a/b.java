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
    private TextView kQu;
    private TextView kQv;
    private TextView kQw;
    private TextView kQx;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void C(View.OnClickListener onClickListener) {
        this.kQu.setTag(0);
        this.kQv.setTag(1);
        this.kQw.setTag(2);
        this.kQx.setTag(3);
        this.kQu.setOnClickListener(onClickListener);
        this.kQv.setOnClickListener(onClickListener);
        this.kQw.setOnClickListener(onClickListener);
        this.kQx.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.kQu = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.kQv = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.kQw = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.kQx = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kQu, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kQv, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kQw, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kQx, (int) R.color.cp_cont_j);
        this.kQu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.kQv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.kQx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.kQw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.kQu.setCompoundDrawablePadding(mPadding);
        this.kQv.setCompoundDrawablePadding(mPadding);
        this.kQx.setCompoundDrawablePadding(mPadding);
        this.kQw.setCompoundDrawablePadding(mPadding);
    }
}
