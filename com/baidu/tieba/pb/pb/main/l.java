package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class l extends af.a {
    private ViewGroup lrz;
    private View mRootView;
    private TextView mTitle;
    private View mTopLine;

    public l(View view) {
        super(view);
        this.mRootView = view;
        this.mTopLine = view.findViewById(R.id.pb_child_title_top_line);
        this.lrz = (ViewGroup) view.findViewById(R.id.rl_pb_child_title_area);
        this.mTitle = (TextView) view.findViewById(R.id.tv_pb_child_title);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.mTitle).oV(R.string.F_X02);
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        this.mTitle.setText(eVar.getTitle());
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lrz, R.color.CAM_X0205);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void Gi(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
