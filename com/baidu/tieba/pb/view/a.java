package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.b {
    private TextView glm;
    private View.OnClickListener gln = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((PbActivity) a.this.mPageContext.getOrignalPage()).skipToLoginActivity();
            ((PbActivity) a.this.mPageContext.getOrignalPage()).kJ(true);
        }
    };
    private TbPageContext<PbActivity> mPageContext;
    private View mRootView;

    public a(TbPageContext<PbActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View oD() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.login_see_more_layout, (ViewGroup) null);
        this.glm = (TextView) this.mRootView.findViewById(e.g.login_button);
        this.glm.setOnClickListener(this.gln);
        ey(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void ey(int i) {
        com.baidu.tbadk.o.a.a(this.mPageContext, this.mRootView);
    }
}
