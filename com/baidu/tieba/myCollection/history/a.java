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
/* loaded from: classes8.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView ddE;
    private TextView fnN;
    private TextView inS;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.inS = (TextView) view.findViewById(R.id.title);
        this.ddE = (TextView) view.findViewById(R.id.content);
        this.ddE.setSingleLine();
        this.ddE.setEllipsize(TextUtils.TruncateAt.END);
        this.fnN = (TextView) view.findViewById(R.id.time);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ag(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.ag(aVar);
        if (aVar != null) {
            if (this.inS != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.inS.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.inS.setText(aVar.getDescription());
                    }
                } else if (aVar.cfc() != null) {
                    if (aVar.isShareThread()) {
                        this.inS.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.cfc()));
                    } else {
                        this.inS.setText(aVar.cfc());
                    }
                }
            }
            if (this.ddE != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.ddE.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.ddE.setText(aVar.getForumName());
                }
            }
            if (this.fnN != null) {
                String j = aq.j(new Date(aVar.getTime()));
                if (j == null) {
                    j = "";
                }
                this.fnN.setText(j);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        am.setBackgroundResource(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.inS, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.ddE, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.fnN, R.color.cp_cont_d, 1);
        return true;
    }
}
