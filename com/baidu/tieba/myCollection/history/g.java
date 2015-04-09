package com.baidu.tieba.myCollection.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.Date;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.e.c> {
    private View adg;
    private TextView bEP;
    private TextView bEQ;
    private TextView bER;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.bEP = (TextView) view.findViewById(v.title);
        this.bEQ = (TextView) view.findViewById(v.content);
        this.bER = (TextView) view.findViewById(v.time);
        this.adg = view.findViewById(v.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(com.baidu.tieba.myCollection.baseHistory.b bVar) {
        super.A(bVar);
        if (bVar != null) {
            if (this.bEP != null && bVar.Yo() != null) {
                this.bEP.setText(bVar.Yo());
            }
            if (this.bEQ != null && bVar.getForumName() != null) {
                this.bEQ.setText(bVar.getForumName());
            }
            if (this.bER != null) {
                String e = bd.e(new Date(bVar.getTime()));
                if (e == null) {
                    e = "";
                }
                this.bER.setText(e);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ba.i(this.mRootView, u.list_item_selector);
        ba.i(this.adg, s.cp_bg_line_b);
        ba.b(this.bEP, s.cp_cont_b, 1);
        ba.b(this.bEQ, s.cp_cont_d, 1);
        ba.b(this.bER, s.cp_cont_d, 1);
        return true;
    }
}
