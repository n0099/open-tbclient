package com.baidu.tieba.myCollection.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import java.util.Date;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.d.b> {
    private TextView ccS;
    private TextView ccT;
    private TextView ccU;
    private View mLine;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.ccS = (TextView) view.findViewById(i.f.title);
        this.ccT = (TextView) view.findViewById(i.f.content);
        this.ccU = (TextView) view.findViewById(i.f.time);
        this.mLine = view.findViewById(i.f.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.myCollection.baseHistory.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            if (this.ccS != null && bVar.adX() != null) {
                if (bVar.sq() == 33) {
                    this.ccS.setText(PhotoLiveCardData.getLiveIconTitle(bVar.adX()));
                } else {
                    this.ccS.setText(bVar.adX());
                }
            }
            if (this.ccT != null && bVar.getForumName() != null) {
                this.ccT.setText(bVar.getForumName());
            }
            if (this.ccU != null) {
                String e = as.e(new Date(bVar.getTime()));
                if (e == null) {
                    e = "";
                }
                this.ccU.setText(e);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        an.i(this.mRootView, i.e.list_item_selector);
        an.i(this.mLine, i.c.cp_bg_line_b);
        an.b(this.ccS, i.c.cp_cont_b, 1);
        an.b(this.ccT, i.c.cp_cont_d, 1);
        an.b(this.ccU, i.c.cp_cont_d, 1);
        return true;
    }
}
