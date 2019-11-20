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
    private TextView cql;
    private TextView ewn;
    private TextView hzO;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.hzO = (TextView) view.findViewById(R.id.title);
        this.cql = (TextView) view.findViewById(R.id.content);
        this.cql.setSingleLine();
        this.cql.setEllipsize(TextUtils.TruncateAt.END);
        this.ewn = (TextView) view.findViewById(R.id.time);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ab(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.ab(aVar);
        if (aVar != null) {
            if (this.hzO != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.hzO.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.hzO.setText(aVar.getDescription());
                    }
                } else if (aVar.bNQ() != null) {
                    if (aVar.isShareThread()) {
                        this.hzO.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.bNQ()));
                    } else {
                        this.hzO.setText(aVar.bNQ());
                    }
                }
            }
            if (this.cql != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.cql.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.cql.setText(aVar.getForumName());
                }
            }
            if (this.ewn != null) {
                String j = aq.j(new Date(aVar.getTime()));
                if (j == null) {
                    j = "";
                }
                this.ewn.setText(j);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        am.setBackgroundResource(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.hzO, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.cql, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.ewn, R.color.cp_cont_d, 1);
        return true;
    }
}
