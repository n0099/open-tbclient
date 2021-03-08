package com.baidu.tieba.write.view.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class b extends a {
    private static int mPadding;
    private TextView okr;
    private TextView oks;
    private TextView okt;
    private TextView oku;

    public b(f fVar) {
        super(fVar);
        mPadding = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void I(View.OnClickListener onClickListener) {
        this.okr.setTag(0);
        this.oks.setTag(1);
        this.okt.setTag(2);
        this.oku.setTag(3);
        this.okr.setOnClickListener(onClickListener);
        this.oks.setOnClickListener(onClickListener);
        this.okt.setOnClickListener(onClickListener);
        this.oku.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.okr = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.oks = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.okt = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.oku = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.okr, R.color.CAM_X0107);
        ap.setViewTextColor(this.oks, R.color.CAM_X0107);
        ap.setViewTextColor(this.okt, R.color.CAM_X0107);
        ap.setViewTextColor(this.oku, R.color.CAM_X0107);
        this.okr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.oks.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.oku.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.okt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.okr.setCompoundDrawablePadding(mPadding);
        this.oks.setCompoundDrawablePadding(mPadding);
        this.oku.setCompoundDrawablePadding(mPadding);
        this.okt.setCompoundDrawablePadding(mPadding);
    }
}
