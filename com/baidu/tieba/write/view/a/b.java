package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b extends a {
    private static int mPadding;
    private TextView oim;
    private TextView oin;
    private TextView oio;
    private TextView oip;

    public b(f fVar) {
        super(fVar);
        mPadding = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void H(View.OnClickListener onClickListener) {
        this.oim.setTag(0);
        this.oin.setTag(1);
        this.oio.setTag(2);
        this.oip.setTag(3);
        this.oim.setOnClickListener(onClickListener);
        this.oin.setOnClickListener(onClickListener);
        this.oio.setOnClickListener(onClickListener);
        this.oip.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.oim = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.oin = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.oio = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.oip = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.oim, R.color.CAM_X0107);
        ap.setViewTextColor(this.oin, R.color.CAM_X0107);
        ap.setViewTextColor(this.oio, R.color.CAM_X0107);
        ap.setViewTextColor(this.oip, R.color.CAM_X0107);
        this.oim.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.oin.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.oip.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.oio.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.oim.setCompoundDrawablePadding(mPadding);
        this.oin.setCompoundDrawablePadding(mPadding);
        this.oip.setCompoundDrawablePadding(mPadding);
        this.oio.setCompoundDrawablePadding(mPadding);
    }
}
