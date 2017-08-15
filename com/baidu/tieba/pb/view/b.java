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
    private TextView fax;
    private View.OnClickListener fay = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((PbActivity) b.this.oV.getOrignalPage()).skipToLoginActivity();
            ((PbActivity) b.this.oV.getOrignalPage()).jc(true);
        }
    };
    private View mRootView;
    private TbPageContext<PbActivity> oV;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.oV = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View lk() {
        this.mRootView = LayoutInflater.from(this.oV.getPageActivity()).inflate(d.j.login_see_more_layout, (ViewGroup) null);
        this.fax = (TextView) this.mRootView.findViewById(d.h.login_button);
        this.fax.setOnClickListener(this.fay);
        dp(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void dp(int i) {
        com.baidu.tbadk.o.a.a(this.oV, this.mRootView);
    }
}
