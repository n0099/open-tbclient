package com.baidu.tieba.myCollection.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
import java.util.Date;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.d.b> {
    private TextView cuU;
    private TextView cuV;
    private TextView cuW;
    private View mLine;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.cuU = (TextView) view.findViewById(n.f.title);
        this.cuV = (TextView) view.findViewById(n.f.content);
        this.cuW = (TextView) view.findViewById(n.f.time);
        this.mLine = view.findViewById(n.f.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.myCollection.baseHistory.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            if (this.cuU != null && bVar.aik() != null) {
                if (bVar.getThreadType() == 33) {
                    this.cuU.setText(PhotoLiveCardData.getLiveIconTitle(bVar.aik()));
                } else {
                    this.cuU.setText(bVar.aik());
                }
            }
            if (this.cuV != null && bVar.getForumName() != null) {
                this.cuV.setText(bVar.getForumName());
            }
            if (this.cuW != null) {
                String e = ax.e(new Date(bVar.getTime()));
                if (e == null) {
                    e = "";
                }
                this.cuW.setText(e);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        as.i(this.mRootView, n.e.list_item_selector);
        as.i(this.mLine, n.c.cp_bg_line_b);
        as.b(this.cuU, n.c.cp_cont_b, 1);
        as.b(this.cuV, n.c.cp_cont_d, 1);
        as.b(this.cuW, n.c.cp_cont_d, 1);
        return true;
    }
}
