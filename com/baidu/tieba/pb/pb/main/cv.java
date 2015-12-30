package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class cv extends x.a {
    public TextView cHV;
    public View cHW;

    public cv(View view) {
        super(view);
        this.cHV = (TextView) view.findViewById(n.g.pb_u9_text_view);
        this.cHW = view.findViewById(n.g.divide_line_up_pb_u9);
    }
}
