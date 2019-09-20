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
    private TextView jUU;
    private TextView jUV;
    private TextView jUW;
    private TextView jUX;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void B(View.OnClickListener onClickListener) {
        this.jUU.setTag(0);
        this.jUV.setTag(1);
        this.jUW.setTag(2);
        this.jUX.setTag(3);
        this.jUU.setOnClickListener(onClickListener);
        this.jUV.setOnClickListener(onClickListener);
        this.jUW.setOnClickListener(onClickListener);
        this.jUX.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.jUU = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.jUV = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.jUW = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.jUX = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.j(this.jUU, R.color.cp_cont_j);
        am.j(this.jUV, R.color.cp_cont_j);
        am.j(this.jUW, R.color.cp_cont_j);
        am.j(this.jUX, R.color.cp_cont_j);
        this.jUU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.jUV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.jUX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.jUW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.jUU.setCompoundDrawablePadding(mPadding);
        this.jUV.setCompoundDrawablePadding(mPadding);
        this.jUX.setCompoundDrawablePadding(mPadding);
        this.jUW.setCompoundDrawablePadding(mPadding);
    }
}
