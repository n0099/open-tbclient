package com.baidu.tieba.myCollection.history;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, com.baidu.tbadk.mvc.d.b> {
    private TextView apF;
    private TextView bYO;
    private TextView eUa;
    private View mLine;
    private View mRootView;

    public b(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        this.mRootView = view2;
        this.eUa = (TextView) view2.findViewById(d.g.title);
        this.apF = (TextView) view2.findViewById(d.g.content);
        this.apF.setSingleLine();
        this.apF.setEllipsize(TextUtils.TruncateAt.END);
        this.bYO = (TextView) view2.findViewById(d.g.time);
        this.mLine = view2.findViewById(d.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.D(aVar);
        if (aVar != null) {
            if (this.eUa != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.eUa.setText(String.format(getString(d.k.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.eUa.setText(aVar.getDescription());
                    }
                } else if (aVar.aTd() != null) {
                    if (aVar.isShareThread()) {
                        this.eUa.setText(String.format("%s%s", getString(d.k.pb_history_share_prefix), aVar.aTd()));
                    } else {
                        this.eUa.setText(aVar.aTd());
                    }
                }
            }
            if (this.apF != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.apF.setText(String.format(getString(d.k.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.apF.setText(aVar.getForumName());
                }
            }
            if (this.bYO != null) {
                String f = an.f(new Date(aVar.getTime()));
                if (f == null) {
                    f = "";
                }
                this.bYO.setText(f);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ak.i(this.mRootView, d.f.list_item_selector);
        ak.i(this.mLine, d.C0126d.cp_bg_line_b);
        ak.c(this.eUa, d.C0126d.cp_cont_b, 1);
        ak.c(this.apF, d.C0126d.cp_cont_d, 1);
        ak.c(this.bYO, d.C0126d.cp_cont_d, 1);
        return true;
    }
}
