package com.baidu.tieba.myCollection.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import java.util.Date;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.d.b> {
    private TextView bYu;
    private TextView bYv;
    private TextView bYw;
    private View mLine;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.bYu = (TextView) view.findViewById(i.f.title);
        this.bYv = (TextView) view.findViewById(i.f.content);
        this.bYw = (TextView) view.findViewById(i.f.time);
        this.mLine = view.findViewById(i.f.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.myCollection.baseHistory.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            if (this.bYu != null && bVar.acn() != null) {
                if (bVar.sv() == 33) {
                    this.bYu.setText(PhotoLiveCardData.getLiveIconTitle(bVar.acn()));
                } else {
                    this.bYu.setText(bVar.acn());
                }
            }
            if (this.bYv != null && bVar.getForumName() != null) {
                this.bYv.setText(bVar.getForumName());
            }
            if (this.bYw != null) {
                String e = aq.e(new Date(bVar.getTime()));
                if (e == null) {
                    e = "";
                }
                this.bYw.setText(e);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        al.h(this.mRootView, i.e.list_item_selector);
        al.h(this.mLine, i.c.cp_bg_line_b);
        al.b(this.bYu, i.c.cp_cont_b, 1);
        al.b(this.bYv, i.c.cp_cont_d, 1);
        al.b(this.bYw, i.c.cp_cont_d, 1);
        return true;
    }
}
