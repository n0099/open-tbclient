package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.b {
    private TextView fcn;
    private View.OnClickListener fco = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((PbActivity) b.this.mPageContext.getOrignalPage()).skipToLoginActivity();
            ((PbActivity) b.this.mPageContext.getOrignalPage()).iK(true);
        }
    };
    private TbPageContext<PbActivity> mPageContext;
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View kX() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.login_see_more_layout, (ViewGroup) null);
        this.fcn = (TextView) this.mRootView.findViewById(d.g.login_button);
        this.fcn.setOnClickListener(this.fco);
        dz(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void dz(int i) {
        com.baidu.tbadk.o.a.a(this.mPageContext, this.mRootView);
    }
}
