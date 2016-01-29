package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dc extends x.a {
    public TextView cPE;
    public View cPF;

    public dc(View view) {
        super(view);
        this.cPE = (TextView) view.findViewById(t.g.pb_u9_text_view);
        this.cPF = view.findViewById(t.g.divide_line_up_pb_u9);
    }
}
