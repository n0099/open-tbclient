package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.b {
    private TextView hFb;
    private View.OnClickListener hFc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((PbActivity) a.this.mPageContext.getOrignalPage()).skipToLoginActivity();
            ((PbActivity) a.this.mPageContext.getOrignalPage()).nm(true);
        }
    };
    private TbPageContext<PbActivity> mPageContext;
    private View mRootView;

    public a(TbPageContext<PbActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View oM() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.login_see_more_layout, (ViewGroup) null);
        this.hFb = (TextView) this.mRootView.findViewById(d.g.login_button);
        this.hFb.setOnClickListener(this.hFc);
        ib(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void ib(int i) {
        com.baidu.tbadk.r.a.a(this.mPageContext, this.mRootView);
    }
}
