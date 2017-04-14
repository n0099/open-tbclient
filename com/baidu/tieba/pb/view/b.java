package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.c {
    private TbPageContext<PbActivity> ajT;
    private TextView evw;
    private View.OnClickListener evx = new c(this);
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.ajT = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View le() {
        this.mRootView = LayoutInflater.from(this.ajT.getPageActivity()).inflate(w.j.login_see_more_layout, (ViewGroup) null);
        this.evw = (TextView) this.mRootView.findViewById(w.h.login_button);
        this.evw.setOnClickListener(this.evx);
        dk(TbadkCoreApplication.m9getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void dk(int i) {
        com.baidu.tbadk.m.a.a(this.ajT, this.mRootView);
    }
}
