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
    private TbPageContext<PbActivity> ajr;
    private TextView etx;
    private View.OnClickListener ety = new c(this);
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.ajr = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View le() {
        this.mRootView = LayoutInflater.from(this.ajr.getPageActivity()).inflate(w.j.login_see_more_layout, (ViewGroup) null);
        this.etx = (TextView) this.mRootView.findViewById(w.h.login_button);
        this.etx.setOnClickListener(this.ety);
        di(TbadkCoreApplication.m9getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void di(int i) {
        com.baidu.tbadk.m.a.a(this.ajr, this.mRootView);
    }
}
