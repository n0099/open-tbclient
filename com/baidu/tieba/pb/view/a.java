package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.b {
    private TextView fNy;
    private View.OnClickListener fNz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((PbActivity) a.this.mPageContext.getOrignalPage()).skipToLoginActivity();
            ((PbActivity) a.this.mPageContext.getOrignalPage()).jR(true);
        }
    };
    private TbPageContext<PbActivity> mPageContext;
    private View mRootView;

    public a(TbPageContext<PbActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View nn() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.login_see_more_layout, (ViewGroup) null);
        this.fNy = (TextView) this.mRootView.findViewById(d.g.login_button);
        this.fNy.setOnClickListener(this.fNz);
        dz(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void dz(int i) {
        com.baidu.tbadk.n.a.a(this.mPageContext, this.mRootView);
    }
}
