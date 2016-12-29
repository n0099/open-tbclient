package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    public final TextView VO;
    public final View aDT;
    private View.OnClickListener aMS = new f(this);
    private PbActivity dYB;
    public final View ehG;

    public e(PbActivity pbActivity) {
        this.dYB = pbActivity;
        this.aDT = this.dYB.findViewById(r.g.manga_navigation_bar_back);
        this.VO = (TextView) this.dYB.findViewById(r.g.manga_navigation_bar_title);
        this.ehG = this.dYB.findViewById(r.g.manga_browser_navigation_bar);
        this.aDT.setOnClickListener(this.aMS);
    }

    public void setTitle(String str) {
        this.VO.setText(str);
    }

    public void show() {
        this.ehG.setVisibility(0);
    }
}
