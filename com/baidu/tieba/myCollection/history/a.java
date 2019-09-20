package com.baidu.tieba.myCollection.history;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView ccP;
    private TextView ekB;
    private TextView hBW;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.hBW = (TextView) view.findViewById(R.id.title);
        this.ccP = (TextView) view.findViewById(R.id.content);
        this.ccP.setSingleLine();
        this.ccP.setEllipsize(TextUtils.TruncateAt.END);
        this.ekB = (TextView) view.findViewById(R.id.time);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.af(aVar);
        if (aVar != null) {
            if (this.hBW != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.hBW.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.hBW.setText(aVar.getDescription());
                    }
                } else if (aVar.bQU() != null) {
                    if (aVar.isShareThread()) {
                        this.hBW.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.bQU()));
                    } else {
                        this.hBW.setText(aVar.bQU());
                    }
                }
            }
            if (this.ccP != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.ccP.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.ccP.setText(aVar.getForumName());
                }
            }
            if (this.ekB != null) {
                String m = aq.m(new Date(aVar.getTime()));
                if (m == null) {
                    m = "";
                }
                this.ekB.setText(m);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.k(this.mRootView, R.drawable.list_item_selector);
        am.k(this.mLine, R.color.cp_bg_line_c);
        am.f(this.hBW, R.color.cp_cont_b, 1);
        am.f(this.ccP, R.color.cp_cont_d, 1);
        am.f(this.ekB, R.color.cp_cont_d, 1);
        return true;
    }
}
