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
    private TextView bSS;
    private TextView dTF;
    private TextView hbA;
    private View mLine;
    private View mRootView;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.hbA = (TextView) view.findViewById(d.g.title);
        this.bSS = (TextView) view.findViewById(d.g.content);
        this.bSS.setSingleLine();
        this.bSS.setEllipsize(TextUtils.TruncateAt.END);
        this.dTF = (TextView) view.findViewById(d.g.time);
        this.mLine = view.findViewById(d.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ad(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.ad(aVar);
        if (aVar != null) {
            if (this.hbA != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.hbA.setText(String.format(getString(d.j.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.hbA.setText(aVar.getDescription());
                    }
                } else if (aVar.bFw() != null) {
                    if (aVar.isShareThread()) {
                        this.hbA.setText(String.format("%s%s", getString(d.j.pb_history_share_prefix), aVar.bFw()));
                    } else {
                        this.hbA.setText(aVar.bFw());
                    }
                }
            }
            if (this.bSS != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.bSS.setText(String.format(getString(d.j.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.bSS.setText(aVar.getForumName());
                }
            }
            if (this.dTF != null) {
                String m = ap.m(new Date(aVar.getTime()));
                if (m == null) {
                    m = "";
                }
                this.dTF.setText(m);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.k(this.mRootView, d.f.list_item_selector);
        al.k(this.mLine, d.C0277d.cp_bg_line_b);
        al.d(this.hbA, d.C0277d.cp_cont_b, 1);
        al.d(this.bSS, d.C0277d.cp_cont_d, 1);
        al.d(this.dTF, d.C0277d.cp_cont_d, 1);
        return true;
    }
}
