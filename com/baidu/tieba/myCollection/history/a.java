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
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView ddO;
    private TextView fqW;
    private TextView irw;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.irw = (TextView) view.findViewById(R.id.title);
        this.ddO = (TextView) view.findViewById(R.id.content);
        this.ddO.setSingleLine();
        this.ddO.setEllipsize(TextUtils.TruncateAt.END);
        this.fqW = (TextView) view.findViewById(R.id.time);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ag(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.ag(aVar);
        if (aVar != null) {
            if (this.irw != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.irw.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.irw.setText(aVar.getDescription());
                    }
                } else if (aVar.cgk() != null) {
                    if (aVar.isShareThread()) {
                        this.irw.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.cgk()));
                    } else {
                        this.irw.setText(aVar.cgk());
                    }
                }
            }
            if (this.ddO != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.ddO.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.ddO.setText(aVar.getForumName());
                }
            }
            if (this.fqW != null) {
                String j = aq.j(new Date(aVar.getTime()));
                if (j == null) {
                    j = "";
                }
                this.fqW.setText(j);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        am.setBackgroundResource(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.irw, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.ddO, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.fqW, R.color.cp_cont_d, 1);
        return true;
    }
}
