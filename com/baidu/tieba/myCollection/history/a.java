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
    private TextView cbO;
    private TextView eiK;
    private TextView hzi;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.hzi = (TextView) view.findViewById(R.id.title);
        this.cbO = (TextView) view.findViewById(R.id.content);
        this.cbO.setSingleLine();
        this.cbO.setEllipsize(TextUtils.TruncateAt.END);
        this.eiK = (TextView) view.findViewById(R.id.time);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.af(aVar);
        if (aVar != null) {
            if (this.hzi != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.hzi.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.hzi.setText(aVar.getDescription());
                    }
                } else if (aVar.bPS() != null) {
                    if (aVar.isShareThread()) {
                        this.hzi.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.bPS()));
                    } else {
                        this.hzi.setText(aVar.bPS());
                    }
                }
            }
            if (this.cbO != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.cbO.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.cbO.setText(aVar.getForumName());
                }
            }
            if (this.eiK != null) {
                String m = aq.m(new Date(aVar.getTime()));
                if (m == null) {
                    m = "";
                }
                this.eiK.setText(m);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.k(this.mRootView, R.drawable.list_item_selector);
        am.k(this.mLine, R.color.cp_bg_line_b);
        am.f(this.hzi, R.color.cp_cont_b, 1);
        am.f(this.cbO, R.color.cp_cont_d, 1);
        am.f(this.eiK, R.color.cp_cont_d, 1);
        return true;
    }
}
