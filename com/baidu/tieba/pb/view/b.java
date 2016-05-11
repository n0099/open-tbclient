package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.c {
    private TbPageContext<PbActivity> DV;
    private TextView drQ;
    private View.OnClickListener drR = new c(this);
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.DV = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View jn() {
        this.mRootView = LayoutInflater.from(this.DV.getPageActivity()).inflate(t.h.login_see_more_layout, (ViewGroup) null);
        this.drQ = (TextView) this.mRootView.findViewById(t.g.login_button);
        this.drQ.setOnClickListener(this.drR);
        cS(TbadkCoreApplication.m11getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void cS(int i) {
        com.baidu.tbadk.i.a.a(this.DV, this.mRootView);
    }
}
