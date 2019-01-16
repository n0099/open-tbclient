package com.baidu.tieba.myCollection.history;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, com.baidu.tbadk.mvc.d.b> {
    private TextView aKL;
    private TextView cGN;
    private TextView fLG;
    private View mLine;
    private View mRootView;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.fLG = (TextView) view.findViewById(e.g.title);
        this.aKL = (TextView) view.findViewById(e.g.content);
        this.aKL.setSingleLine();
        this.aKL.setEllipsize(TextUtils.TruncateAt.END);
        this.cGN = (TextView) view.findViewById(e.g.time);
        this.mLine = view.findViewById(e.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void L(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.L(aVar);
        if (aVar != null) {
            if (this.fLG != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.fLG.setText(String.format(getString(e.j.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.fLG.setText(aVar.getDescription());
                    }
                } else if (aVar.beY() != null) {
                    if (aVar.isShareThread()) {
                        this.fLG.setText(String.format("%s%s", getString(e.j.pb_history_share_prefix), aVar.beY()));
                    } else {
                        this.fLG.setText(aVar.beY());
                    }
                }
            }
            if (this.aKL != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.aKL.setText(String.format(getString(e.j.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.aKL.setText(aVar.getForumName());
                }
            }
            if (this.cGN != null) {
                String g = ao.g(new Date(aVar.getTime()));
                if (g == null) {
                    g = "";
                }
                this.cGN.setText(g);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.i(this.mRootView, e.f.list_item_selector);
        al.i(this.mLine, e.d.cp_bg_line_b);
        al.c(this.fLG, e.d.cp_cont_b, 1);
        al.c(this.aKL, e.d.cp_cont_d, 1);
        al.c(this.cGN, e.d.cp_cont_d, 1);
        return true;
    }
}
