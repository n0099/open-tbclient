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
    private TextView bST;
    private TextView dTG;
    private TextView hbB;
    private View mLine;
    private View mRootView;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.hbB = (TextView) view.findViewById(d.g.title);
        this.bST = (TextView) view.findViewById(d.g.content);
        this.bST.setSingleLine();
        this.bST.setEllipsize(TextUtils.TruncateAt.END);
        this.dTG = (TextView) view.findViewById(d.g.time);
        this.mLine = view.findViewById(d.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ad(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.ad(aVar);
        if (aVar != null) {
            if (this.hbB != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.hbB.setText(String.format(getString(d.j.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.hbB.setText(aVar.getDescription());
                    }
                } else if (aVar.bFw() != null) {
                    if (aVar.isShareThread()) {
                        this.hbB.setText(String.format("%s%s", getString(d.j.pb_history_share_prefix), aVar.bFw()));
                    } else {
                        this.hbB.setText(aVar.bFw());
                    }
                }
            }
            if (this.bST != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.bST.setText(String.format(getString(d.j.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.bST.setText(aVar.getForumName());
                }
            }
            if (this.dTG != null) {
                String m = ap.m(new Date(aVar.getTime()));
                if (m == null) {
                    m = "";
                }
                this.dTG.setText(m);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.k(this.mRootView, d.f.list_item_selector);
        al.k(this.mLine, d.C0277d.cp_bg_line_b);
        al.d(this.hbB, d.C0277d.cp_cont_b, 1);
        al.d(this.bST, d.C0277d.cp_cont_d, 1);
        al.d(this.dTG, d.C0277d.cp_cont_d, 1);
        return true;
    }
}
