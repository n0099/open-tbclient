package com.baidu.tieba.im.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.h {
    private BaseActivity On;
    private View auN;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public s(BaseActivity baseActivity) {
        this.On = null;
        this.On = baseActivity;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.On, w.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.On.getResources().getDimensionPixelSize(t.listview_item_margin), 0, this.On.getResources().getDimensionPixelSize(t.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(v.pb_more_text);
        this.auN = this.mRoot.findViewById(v.pb_more_view);
        this.auN.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(v.progress);
        cu(TbadkApplication.m251getInst().getSkinType());
        this.auN.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void cu(int i) {
        int color;
        this.On.getLayoutMode().h(this.auN);
        String string = this.On.getString(y.nearby_group_no_more);
        String charSequence = this.mTextView.getText() != null ? this.mTextView.getText().toString() : null;
        if (charSequence != null && charSequence.equals(string)) {
            color = aw.getColor(com.baidu.tieba.s.pb_list_morebutton_nomore_text);
        } else {
            color = aw.getColor(com.baidu.tieba.s.pb_more_txt);
        }
        this.mTextView.setTextColor(color);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void hide() {
        this.mRoot.setVisibility(8);
    }

    public void Ba() {
        this.mRoot.setVisibility(0);
    }

    public void DF() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.On.getText(y.loading));
        this.auN.setVisibility(0);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    public void Ep() {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(y.nearby_group_no_more);
        this.mTextView.setVisibility(0);
        this.auN.setVisibility(0);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    public void DG() {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(y.load_more);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
