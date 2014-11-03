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
    private BaseActivity Or;
    private View auW;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public s(BaseActivity baseActivity) {
        this.Or = null;
        this.Or = baseActivity;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.Or, w.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.Or.getResources().getDimensionPixelSize(t.listview_item_margin), 0, this.Or.getResources().getDimensionPixelSize(t.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(v.pb_more_text);
        this.auW = this.mRoot.findViewById(v.pb_more_view);
        this.auW.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(v.progress);
        cu(TbadkApplication.m251getInst().getSkinType());
        this.auW.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void cu(int i) {
        int color;
        this.Or.getLayoutMode().h(this.auW);
        String string = this.Or.getString(y.nearby_group_no_more);
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

    public void Bc() {
        this.mRoot.setVisibility(0);
    }

    public void DH() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.Or.getText(y.loading));
        this.auW.setVisibility(0);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    public void Er() {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(y.nearby_group_no_more);
        this.mTextView.setVisibility(0);
        this.auW.setVisibility(0);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    public void DI() {
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
