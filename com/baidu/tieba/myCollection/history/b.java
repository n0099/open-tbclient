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
    private TextView aBk;
    private TextView crz;
    private TextView fsc;
    private View mLine;
    private View mRootView;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.fsc = (TextView) view.findViewById(e.g.title);
        this.aBk = (TextView) view.findViewById(e.g.content);
        this.aBk.setSingleLine();
        this.aBk.setEllipsize(TextUtils.TruncateAt.END);
        this.crz = (TextView) view.findViewById(e.g.time);
        this.mLine = view.findViewById(e.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void H(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.H(aVar);
        if (aVar != null) {
            if (this.fsc != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.fsc.setText(String.format(getString(e.j.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.fsc.setText(aVar.getDescription());
                    }
                } else if (aVar.aZl() != null) {
                    if (aVar.isShareThread()) {
                        this.fsc.setText(String.format("%s%s", getString(e.j.pb_history_share_prefix), aVar.aZl()));
                    } else {
                        this.fsc.setText(aVar.aZl());
                    }
                }
            }
            if (this.aBk != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.aBk.setText(String.format(getString(e.j.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.aBk.setText(aVar.getForumName());
                }
            }
            if (this.crz != null) {
                String g = ao.g(new Date(aVar.getTime()));
                if (g == null) {
                    g = "";
                }
                this.crz.setText(g);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.i(this.mRootView, e.f.list_item_selector);
        al.i(this.mLine, e.d.cp_bg_line_b);
        al.c(this.fsc, e.d.cp_cont_b, 1);
        al.c(this.aBk, e.d.cp_cont_d, 1);
        al.c(this.crz, e.d.cp_cont_d, 1);
        return true;
    }
}
