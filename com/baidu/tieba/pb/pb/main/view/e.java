package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    public final TextView Wu;
    public final View aEA;
    private View.OnClickListener aNB = new f(this);
    public final View eDF;
    private PbActivity eug;

    public e(PbActivity pbActivity) {
        this.eug = pbActivity;
        this.aEA = this.eug.findViewById(r.g.manga_navigation_bar_back);
        this.Wu = (TextView) this.eug.findViewById(r.g.manga_navigation_bar_title);
        this.eDF = this.eug.findViewById(r.g.manga_browser_navigation_bar);
        this.aEA.setOnClickListener(this.aNB);
    }

    public void setTitle(String str) {
        this.Wu.setText(str);
    }

    public void show() {
        this.eDF.setVisibility(0);
    }
}
