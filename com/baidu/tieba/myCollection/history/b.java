package com.baidu.tieba.myCollection.history;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import java.util.Date;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, com.baidu.tbadk.mvc.d.b> {
    private TextView bSQ;
    private TextView dUm;
    private TextView hbN;
    private View mLine;
    private View mRootView;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.hbN = (TextView) view.findViewById(d.g.title);
        this.bSQ = (TextView) view.findViewById(d.g.content);
        this.bSQ.setSingleLine();
        this.bSQ.setEllipsize(TextUtils.TruncateAt.END);
        this.dUm = (TextView) view.findViewById(d.g.time);
        this.mLine = view.findViewById(d.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.af(aVar);
        if (aVar != null) {
            if (this.hbN != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.hbN.setText(String.format(getString(d.j.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.hbN.setText(aVar.getDescription());
                    }
                } else if (aVar.bFz() != null) {
                    if (aVar.isShareThread()) {
                        this.hbN.setText(String.format("%s%s", getString(d.j.pb_history_share_prefix), aVar.bFz()));
                    } else {
                        this.hbN.setText(aVar.bFz());
                    }
                }
            }
            if (this.bSQ != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.bSQ.setText(String.format(getString(d.j.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.bSQ.setText(aVar.getForumName());
                }
            }
            if (this.dUm != null) {
                String m = ap.m(new Date(aVar.getTime()));
                if (m == null) {
                    m = "";
                }
                this.dUm.setText(m);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.k(this.mRootView, d.f.list_item_selector);
        al.k(this.mLine, d.C0277d.cp_bg_line_b);
        al.d(this.hbN, d.C0277d.cp_cont_b, 1);
        al.d(this.bSQ, d.C0277d.cp_cont_d, 1);
        al.d(this.dUm, d.C0277d.cp_cont_d, 1);
        return true;
    }
}
