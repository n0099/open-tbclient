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
    private TextView eTX;
    private View.OnClickListener eTY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((PbActivity) b.this.mH.getOrignalPage()).skipToLoginActivity();
            ((PbActivity) b.this.mH.getOrignalPage()).iN(true);
        }
    };
    private TbPageContext<PbActivity> mH;
    private View mRootView;

    public b(TbPageContext<PbActivity> tbPageContext) {
        this.mH = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View ld() {
        this.mRootView = LayoutInflater.from(this.mH.getPageActivity()).inflate(d.j.login_see_more_layout, (ViewGroup) null);
        this.eTX = (TextView) this.mRootView.findViewById(d.h.login_button);
        this.eTX.setOnClickListener(this.eTY);
        dy(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void dy(int i) {
        com.baidu.tbadk.n.a.a(this.mH, this.mRootView);
    }
}
