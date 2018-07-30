package com.baidu.tieba.myCollection.history;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, com.baidu.tbadk.mvc.d.b> {
    private TextView ayq;
    private TextView clJ;
    private TextView fkL;
    private View mLine;
    private View mRootView;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.fkL = (TextView) view.findViewById(d.g.title);
        this.ayq = (TextView) view.findViewById(d.g.content);
        this.ayq.setSingleLine();
        this.ayq.setEllipsize(TextUtils.TruncateAt.END);
        this.clJ = (TextView) view.findViewById(d.g.time);
        this.mLine = view.findViewById(d.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.G(aVar);
        if (aVar != null) {
            if (this.fkL != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.fkL.setText(String.format(getString(d.j.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.fkL.setText(aVar.getDescription());
                    }
                } else if (aVar.aXc() != null) {
                    if (aVar.isShareThread()) {
                        this.fkL.setText(String.format("%s%s", getString(d.j.pb_history_share_prefix), aVar.aXc()));
                    } else {
                        this.fkL.setText(aVar.aXc());
                    }
                }
            }
            if (this.ayq != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.ayq.setText(String.format(getString(d.j.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.ayq.setText(aVar.getForumName());
                }
            }
            if (this.clJ != null) {
                String g = ap.g(new Date(aVar.getTime()));
                if (g == null) {
                    g = "";
                }
                this.clJ.setText(g);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.i(this.mRootView, d.f.list_item_selector);
        am.i(this.mLine, d.C0140d.cp_bg_line_b);
        am.c(this.fkL, d.C0140d.cp_cont_b, 1);
        am.c(this.ayq, d.C0140d.cp_cont_d, 1);
        am.c(this.clJ, d.C0140d.cp_cont_d, 1);
        return true;
    }
}
