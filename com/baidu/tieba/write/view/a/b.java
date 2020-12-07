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
    private TextView nZX;
    private TextView nZY;
    private TextView nZZ;
    private TextView oaa;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void F(View.OnClickListener onClickListener) {
        this.nZX.setTag(0);
        this.nZY.setTag(1);
        this.nZZ.setTag(2);
        this.oaa.setTag(3);
        this.nZX.setOnClickListener(onClickListener);
        this.nZY.setOnClickListener(onClickListener);
        this.nZZ.setOnClickListener(onClickListener);
        this.oaa.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.nZX = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.nZY = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.nZZ = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.oaa = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nZX, R.color.CAM_X0107);
        ap.setViewTextColor(this.nZY, R.color.CAM_X0107);
        ap.setViewTextColor(this.nZZ, R.color.CAM_X0107);
        ap.setViewTextColor(this.oaa, R.color.CAM_X0107);
        this.nZX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.nZY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.oaa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.nZZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.nZX.setCompoundDrawablePadding(mPadding);
        this.nZY.setCompoundDrawablePadding(mPadding);
        this.oaa.setCompoundDrawablePadding(mPadding);
        this.nZZ.setCompoundDrawablePadding(mPadding);
    }
}
