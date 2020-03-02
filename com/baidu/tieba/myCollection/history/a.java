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
/* loaded from: classes11.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView dhT;
    private TextView ftA;
    private TextView itt;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.itt = (TextView) view.findViewById(R.id.title);
        this.dhT = (TextView) view.findViewById(R.id.content);
        this.dhT.setSingleLine();
        this.dhT.setEllipsize(TextUtils.TruncateAt.END);
        this.ftA = (TextView) view.findViewById(R.id.time);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ai(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.ai(aVar);
        if (aVar != null) {
            if (this.itt != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.itt.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.itt.setText(aVar.getDescription());
                    }
                } else if (aVar.chR() != null) {
                    if (aVar.isShareThread()) {
                        this.itt.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.chR()));
                    } else {
                        this.itt.setText(aVar.chR());
                    }
                }
            }
            if (this.dhT != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.dhT.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.dhT.setText(aVar.getForumName());
                }
            }
            if (this.ftA != null) {
                String j = aq.j(new Date(aVar.getTime()));
                if (j == null) {
                    j = "";
                }
                this.ftA.setText(j);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        am.setBackgroundResource(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.itt, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.dhT, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.ftA, R.color.cp_cont_d, 1);
        return true;
    }
}
