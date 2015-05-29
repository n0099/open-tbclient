package com.baidu.tieba.myCollection.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import java.util.Date;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.e.c> {
    private TextView bHK;
    private TextView bHL;
    private TextView bHM;
    private View mLine;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.bHK = (TextView) view.findViewById(q.title);
        this.bHL = (TextView) view.findViewById(q.content);
        this.bHM = (TextView) view.findViewById(q.time);
        this.mLine = view.findViewById(q.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(com.baidu.tieba.myCollection.baseHistory.b bVar) {
        super.z(bVar);
        if (bVar != null) {
            if (this.bHK != null && bVar.ZO() != null) {
                this.bHK.setText(bVar.ZO());
            }
            if (this.bHL != null && bVar.getForumName() != null) {
                this.bHL.setText(bVar.getForumName());
            }
            if (this.bHM != null) {
                String e = bb.e(new Date(bVar.getTime()));
                if (e == null) {
                    e = "";
                }
                this.bHM.setText(e);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ay.i(this.mRootView, p.list_item_selector);
        ay.i(this.mLine, n.cp_bg_line_b);
        ay.b(this.bHK, n.cp_cont_b, 1);
        ay.b(this.bHL, n.cp_cont_d, 1);
        ay.b(this.bHM, n.cp_cont_d, 1);
        return true;
    }
}
