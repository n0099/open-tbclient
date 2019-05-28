package com.baidu.tieba.myCollection.history;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView caL;
    private TextView eeg;
    private TextView hsV;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.hsV = (TextView) view.findViewById(R.id.title);
        this.caL = (TextView) view.findViewById(R.id.content);
        this.caL.setSingleLine();
        this.caL.setEllipsize(TextUtils.TruncateAt.END);
        this.eeg = (TextView) view.findViewById(R.id.time);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.af(aVar);
        if (aVar != null) {
            if (this.hsV != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.hsV.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.hsV.setText(aVar.getDescription());
                    }
                } else if (aVar.bNj() != null) {
                    if (aVar.isShareThread()) {
                        this.hsV.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.bNj()));
                    } else {
                        this.hsV.setText(aVar.bNj());
                    }
                }
            }
            if (this.caL != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.caL.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.caL.setText(aVar.getForumName());
                }
            }
            if (this.eeg != null) {
                String m = ap.m(new Date(aVar.getTime()));
                if (m == null) {
                    m = "";
                }
                this.eeg.setText(m);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.k(this.mRootView, R.drawable.list_item_selector);
        al.k(this.mLine, R.color.cp_bg_line_b);
        al.f(this.hsV, R.color.cp_cont_b, 1);
        al.f(this.caL, R.color.cp_cont_d, 1);
        al.f(this.eeg, R.color.cp_cont_d, 1);
        return true;
    }
}
