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
    private View.OnClickListener faA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((PbActivity) b.this.oW.getOrignalPage()).skipToLoginActivity();
            ((PbActivity) b.this.oW.getOrignalPage()).jc(true);
        }
    };
    private TextView faz;
    private View mRootView;
    private TbPageContext<PbActivity> oW;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.oW = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View lj() {
        this.mRootView = LayoutInflater.from(this.oW.getPageActivity()).inflate(d.j.login_see_more_layout, (ViewGroup) null);
        this.faz = (TextView) this.mRootView.findViewById(d.h.login_button);
        this.faz.setOnClickListener(this.faA);
        dp(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void dp(int i) {
        com.baidu.tbadk.o.a.a(this.oW, this.mRootView);
    }
}
