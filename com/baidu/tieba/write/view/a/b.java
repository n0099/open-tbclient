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
    private TextView nZZ;
    private TextView oaa;
    private TextView oab;
    private TextView oac;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void F(View.OnClickListener onClickListener) {
        this.nZZ.setTag(0);
        this.oaa.setTag(1);
        this.oab.setTag(2);
        this.oac.setTag(3);
        this.nZZ.setOnClickListener(onClickListener);
        this.oaa.setOnClickListener(onClickListener);
        this.oab.setOnClickListener(onClickListener);
        this.oac.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.nZZ = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.oaa = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.oab = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.oac = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nZZ, R.color.CAM_X0107);
        ap.setViewTextColor(this.oaa, R.color.CAM_X0107);
        ap.setViewTextColor(this.oab, R.color.CAM_X0107);
        ap.setViewTextColor(this.oac, R.color.CAM_X0107);
        this.nZZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.oaa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.oac.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.oab.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.nZZ.setCompoundDrawablePadding(mPadding);
        this.oaa.setCompoundDrawablePadding(mPadding);
        this.oac.setCompoundDrawablePadding(mPadding);
        this.oab.setCompoundDrawablePadding(mPadding);
    }
}
