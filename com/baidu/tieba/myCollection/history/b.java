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
    private TextView ayD;
    private TextView cjY;
    private TextView fkz;
    private View mLine;
    private View mRootView;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.fkz = (TextView) view.findViewById(d.g.title);
        this.ayD = (TextView) view.findViewById(d.g.content);
        this.ayD.setSingleLine();
        this.ayD.setEllipsize(TextUtils.TruncateAt.END);
        this.cjY = (TextView) view.findViewById(d.g.time);
        this.mLine = view.findViewById(d.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.G(aVar);
        if (aVar != null) {
            if (this.fkz != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.fkz.setText(String.format(getString(d.k.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.fkz.setText(aVar.getDescription());
                    }
                } else if (aVar.aYG() != null) {
                    if (aVar.isShareThread()) {
                        this.fkz.setText(String.format("%s%s", getString(d.k.pb_history_share_prefix), aVar.aYG()));
                    } else {
                        this.fkz.setText(aVar.aYG());
                    }
                }
            }
            if (this.ayD != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.ayD.setText(String.format(getString(d.k.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.ayD.setText(aVar.getForumName());
                }
            }
            if (this.cjY != null) {
                String h = ap.h(new Date(aVar.getTime()));
                if (h == null) {
                    h = "";
                }
                this.cjY.setText(h);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.i(this.mRootView, d.f.list_item_selector);
        am.i(this.mLine, d.C0142d.cp_bg_line_b);
        am.c(this.fkz, d.C0142d.cp_cont_b, 1);
        am.c(this.ayD, d.C0142d.cp_cont_d, 1);
        am.c(this.cjY, d.C0142d.cp_cont_d, 1);
        return true;
    }
}
