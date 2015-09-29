package com.baidu.tieba.myCollection.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import java.util.Date;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.d.b> {
    private TextView ccg;
    private TextView cch;
    private TextView cci;
    private View mLine;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.ccg = (TextView) view.findViewById(i.f.title);
        this.cch = (TextView) view.findViewById(i.f.content);
        this.cci = (TextView) view.findViewById(i.f.time);
        this.mLine = view.findViewById(i.f.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.myCollection.baseHistory.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            if (this.ccg != null && bVar.adG() != null) {
                if (bVar.sq() == 33) {
                    this.ccg.setText(PhotoLiveCardData.getLiveIconTitle(bVar.adG()));
                } else {
                    this.ccg.setText(bVar.adG());
                }
            }
            if (this.cch != null && bVar.getForumName() != null) {
                this.cch.setText(bVar.getForumName());
            }
            if (this.cci != null) {
                String e = ar.e(new Date(bVar.getTime()));
                if (e == null) {
                    e = "";
                }
                this.cci.setText(e);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        am.i(this.mRootView, i.e.list_item_selector);
        am.i(this.mLine, i.c.cp_bg_line_b);
        am.b(this.ccg, i.c.cp_cont_b, 1);
        am.b(this.cch, i.c.cp_cont_d, 1);
        am.b(this.cci, i.c.cp_cont_d, 1);
        return true;
    }
}
