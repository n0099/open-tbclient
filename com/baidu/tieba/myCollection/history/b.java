package com.baidu.tieba.myCollection.history;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, com.baidu.tbadk.mvc.d.b> {
    private TextView bel;
    private TextView cIE;
    private TextView fzc;
    private View mLine;
    private View mRootView;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.fzc = (TextView) view.findViewById(d.g.title);
        this.bel = (TextView) view.findViewById(d.g.content);
        this.bel.setSingleLine();
        this.bel.setEllipsize(TextUtils.TruncateAt.END);
        this.cIE = (TextView) view.findViewById(d.g.time);
        this.mLine = view.findViewById(d.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.aI(aVar);
        if (aVar != null) {
            if (this.fzc != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.fzc.setText(String.format(getString(d.j.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.fzc.setText(aVar.getDescription());
                    }
                } else if (aVar.aYh() != null) {
                    if (aVar.getThreadType() == 33) {
                        this.fzc.setText(PhotoLiveCardData.getLiveIconTitle(aVar.aYh()));
                    } else if (aVar.isShareThread()) {
                        this.fzc.setText(String.format("%s%s", getString(d.j.pb_history_share_prefix), aVar.aYh()));
                    } else {
                        this.fzc.setText(aVar.aYh());
                    }
                }
            }
            if (this.bel != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.bel.setText(String.format(getString(d.j.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.bel.setText(aVar.getForumName());
                }
            }
            if (this.cIE != null) {
                String e = am.e(new Date(aVar.getTime()));
                if (e == null) {
                    e = "";
                }
                this.cIE.setText(e);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.s(this.mRootView, d.f.list_item_selector);
        aj.s(this.mLine, d.C0141d.cp_bg_line_b);
        aj.e(this.fzc, d.C0141d.cp_cont_b, 1);
        aj.e(this.bel, d.C0141d.cp_cont_d, 1);
        aj.e(this.cIE, d.C0141d.cp_cont_d, 1);
        return true;
    }
}
