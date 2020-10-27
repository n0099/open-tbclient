package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class l extends af.a {
    private ViewGroup llj;
    private View mRootView;
    private TextView mTitle;
    private View mTopLine;

    public l(View view) {
        super(view);
        this.mRootView = view;
        this.mTopLine = view.findViewById(R.id.pb_child_title_top_line);
        this.llj = (ViewGroup) view.findViewById(R.id.rl_pb_child_title_area);
        this.mTitle = (TextView) view.findViewById(R.id.tv_pb_child_title);
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        this.mTitle.setText(eVar.getTitle());
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.llj, R.color.cp_bg_line_e);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void Fx(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
