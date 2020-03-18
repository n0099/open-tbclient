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
    private TextView kSR;
    private TextView kSS;
    private TextView kST;
    private TextView kSU;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void D(View.OnClickListener onClickListener) {
        this.kSR.setTag(0);
        this.kSS.setTag(1);
        this.kST.setTag(2);
        this.kSU.setTag(3);
        this.kSR.setOnClickListener(onClickListener);
        this.kSS.setOnClickListener(onClickListener);
        this.kST.setOnClickListener(onClickListener);
        this.kSU.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.kSR = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.kSS = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.kST = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.kSU = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kSR, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kSS, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kST, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.kSU, (int) R.color.cp_cont_j);
        this.kSR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.kSS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.kSU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.kST.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.kSR.setCompoundDrawablePadding(mPadding);
        this.kSS.setCompoundDrawablePadding(mPadding);
        this.kSU.setCompoundDrawablePadding(mPadding);
        this.kST.setCompoundDrawablePadding(mPadding);
    }
}
