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
    private TextView jRr;
    private TextView jRs;
    private TextView jRt;
    private TextView jRu;

    public b(e eVar) {
        super(eVar);
        mPadding = eVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void B(View.OnClickListener onClickListener) {
        this.jRr.setTag(0);
        this.jRs.setTag(1);
        this.jRt.setTag(2);
        this.jRu.setTag(3);
        this.jRr.setOnClickListener(onClickListener);
        this.jRs.setOnClickListener(onClickListener);
        this.jRt.setOnClickListener(onClickListener);
        this.jRu.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.jRr = (TextView) this.mRootView.findViewById(R.id.rotate_left);
        this.jRs = (TextView) this.mRootView.findViewById(R.id.rotate_right);
        this.jRt = (TextView) this.mRootView.findViewById(R.id.rotate_left_right);
        this.jRu = (TextView) this.mRootView.findViewById(R.id.rotate_up_down);
    }

    public void onChangeSkinType() {
        am.j(this.jRr, R.color.cp_cont_j);
        am.j(this.jRs, R.color.cp_cont_j);
        am.j(this.jRt, R.color.cp_cont_j);
        am.j(this.jRu, R.color.cp_cont_j);
        this.jRr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.jRs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.jRu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.jRt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.jRr.setCompoundDrawablePadding(mPadding);
        this.jRs.setCompoundDrawablePadding(mPadding);
        this.jRu.setCompoundDrawablePadding(mPadding);
        this.jRt.setCompoundDrawablePadding(mPadding);
    }
}
