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
    private TbPageContext<PbActivity> alI;
    private TextView eYE;
    private View.OnClickListener eYF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((PbActivity) b.this.alI.getOrignalPage()).skipToLoginActivity();
            ((PbActivity) b.this.alI.getOrignalPage()).iZ(true);
        }
    };
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.alI = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View lk() {
        this.mRootView = LayoutInflater.from(this.alI.getPageActivity()).inflate(d.j.login_see_more_layout, (ViewGroup) null);
        this.eYE = (TextView) this.mRootView.findViewById(d.h.login_button);
        this.eYE.setOnClickListener(this.eYF);
        dp(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void dp(int i) {
        com.baidu.tbadk.o.a.a(this.alI, this.mRootView);
    }
}
