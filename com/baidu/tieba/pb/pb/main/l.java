package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class l extends ad.a {
    private ViewGroup klD;
    private TextView mTitle;
    private View mTopLine;

    public l(View view) {
        super(view);
        this.mTopLine = view.findViewById(R.id.pb_child_title_top_line);
        this.klD = (ViewGroup) view.findViewById(R.id.rl_pb_child_title_area);
        this.mTitle = (TextView) view.findViewById(R.id.tv_pb_child_title);
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        this.mTitle.setText(eVar.getTitle());
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.klD, R.color.cp_bg_line_e);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
    }
}
