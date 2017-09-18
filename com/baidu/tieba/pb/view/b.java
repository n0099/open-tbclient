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
    private TextView fab;
    private View.OnClickListener fac = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((PbActivity) b.this.mF.getOrignalPage()).skipToLoginActivity();
            ((PbActivity) b.this.mF.getOrignalPage()).jd(true);
        }
    };
    private TbPageContext<PbActivity> mF;
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.mF = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View lb() {
        this.mRootView = LayoutInflater.from(this.mF.getPageActivity()).inflate(d.j.login_see_more_layout, (ViewGroup) null);
        this.fab = (TextView) this.mRootView.findViewById(d.h.login_button);
        this.fab.setOnClickListener(this.fac);
        dq(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void dq(int i) {
        com.baidu.tbadk.o.a.a(this.mF, this.mRootView);
    }
}
