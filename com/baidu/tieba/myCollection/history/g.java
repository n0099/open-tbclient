package com.baidu.tieba.myCollection.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import java.util.Date;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.d.b> {
    private View amq;
    private TextView cFB;
    private TextView cFC;
    private TextView cFD;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.cFB = (TextView) view.findViewById(t.g.title);
        this.cFC = (TextView) view.findViewById(t.g.content);
        this.cFD = (TextView) view.findViewById(t.g.time);
        this.amq = view.findViewById(t.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.myCollection.baseHistory.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            if (this.cFB != null && bVar.anv() != null) {
                if (bVar.getThreadType() == 33) {
                    this.cFB.setText(PhotoLiveCardData.getLiveIconTitle(bVar.anv()));
                } else {
                    this.cFB.setText(bVar.anv());
                }
            }
            if (this.cFC != null && bVar.getForumName() != null) {
                this.cFC.setText(bVar.getForumName());
            }
            if (this.cFD != null) {
                String e = aw.e(new Date(bVar.getTime()));
                if (e == null) {
                    e = "";
                }
                this.cFD.setText(e);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ar.k(this.mRootView, t.f.list_item_selector);
        ar.k(this.amq, t.d.cp_bg_line_b);
        ar.b(this.cFB, t.d.cp_cont_b, 1);
        ar.b(this.cFC, t.d.cp_cont_d, 1);
        ar.b(this.cFD, t.d.cp_cont_d, 1);
        return true;
    }
}
