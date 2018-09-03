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
import com.baidu.tieba.f;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, com.baidu.tbadk.mvc.d.b> {
    private TextView ayn;
    private TextView clG;
    private TextView fkF;
    private View mLine;
    private View mRootView;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.fkF = (TextView) view.findViewById(f.g.title);
        this.ayn = (TextView) view.findViewById(f.g.content);
        this.ayn.setSingleLine();
        this.ayn.setEllipsize(TextUtils.TruncateAt.END);
        this.clG = (TextView) view.findViewById(f.g.time);
        this.mLine = view.findViewById(f.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.G(aVar);
        if (aVar != null) {
            if (this.fkF != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.fkF.setText(String.format(getString(f.j.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.fkF.setText(aVar.getDescription());
                    }
                } else if (aVar.aWY() != null) {
                    if (aVar.isShareThread()) {
                        this.fkF.setText(String.format("%s%s", getString(f.j.pb_history_share_prefix), aVar.aWY()));
                    } else {
                        this.fkF.setText(aVar.aWY());
                    }
                }
            }
            if (this.ayn != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.ayn.setText(String.format(getString(f.j.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.ayn.setText(aVar.getForumName());
                }
            }
            if (this.clG != null) {
                String g = ap.g(new Date(aVar.getTime()));
                if (g == null) {
                    g = "";
                }
                this.clG.setText(g);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.i(this.mRootView, f.C0146f.list_item_selector);
        am.i(this.mLine, f.d.cp_bg_line_b);
        am.c(this.fkF, f.d.cp_cont_b, 1);
        am.c(this.ayn, f.d.cp_cont_d, 1);
        am.c(this.clG, f.d.cp_cont_d, 1);
        return true;
    }
}
