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
    private View acX;
    private TextView bEC;
    private TextView bED;
    private TextView bEE;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.bEC = (TextView) view.findViewById(v.title);
        this.bED = (TextView) view.findViewById(v.content);
        this.bEE = (TextView) view.findViewById(v.time);
        this.acX = view.findViewById(v.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(com.baidu.tieba.myCollection.baseHistory.b bVar) {
        super.A(bVar);
        if (bVar != null) {
            if (this.bEC != null && bVar.Yc() != null) {
                this.bEC.setText(bVar.Yc());
            }
            if (this.bED != null && bVar.getForumName() != null) {
                this.bED.setText(bVar.getForumName());
            }
            if (this.bEE != null) {
                String e = bd.e(new Date(bVar.getTime()));
                if (e == null) {
                    e = "";
                }
                this.bEE.setText(e);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ba.i(this.mRootView, u.list_item_selector);
        ba.i(this.acX, s.cp_bg_line_b);
        ba.b(this.bEC, s.cp_cont_b, 1);
        ba.b(this.bED, s.cp_cont_d, 1);
        ba.b(this.bEE, s.cp_cont_d, 1);
        return true;
    }
}
