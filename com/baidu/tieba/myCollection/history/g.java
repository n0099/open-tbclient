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
    private TextView cyU;
    private TextView cyV;
    private TextView cyW;
    private View mLine;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.cyU = (TextView) view.findViewById(n.g.title);
        this.cyV = (TextView) view.findViewById(n.g.content);
        this.cyW = (TextView) view.findViewById(n.g.time);
        this.mLine = view.findViewById(n.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.myCollection.baseHistory.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            if (this.cyU != null && bVar.ajx() != null) {
                if (bVar.getThreadType() == 33) {
                    this.cyU.setText(PhotoLiveCardData.getLiveIconTitle(bVar.ajx()));
                } else {
                    this.cyU.setText(bVar.ajx());
                }
            }
            if (this.cyV != null && bVar.getForumName() != null) {
                this.cyV.setText(bVar.getForumName());
            }
            if (this.cyW != null) {
                String e = ax.e(new Date(bVar.getTime()));
                if (e == null) {
                    e = "";
                }
                this.cyW.setText(e);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        as.i(this.mRootView, n.f.list_item_selector);
        as.i(this.mLine, n.d.cp_bg_line_b);
        as.b(this.cyU, n.d.cp_cont_b, 1);
        as.b(this.cyV, n.d.cp_cont_d, 1);
        as.b(this.cyW, n.d.cp_cont_d, 1);
        return true;
    }
}
