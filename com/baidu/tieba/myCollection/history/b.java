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
    private TextView beo;
    private TextView cIH;
    private TextView fzs;
    private View mLine;
    private View mRootView;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.fzs = (TextView) view.findViewById(d.g.title);
        this.beo = (TextView) view.findViewById(d.g.content);
        this.beo.setSingleLine();
        this.beo.setEllipsize(TextUtils.TruncateAt.END);
        this.cIH = (TextView) view.findViewById(d.g.time);
        this.mLine = view.findViewById(d.g.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.aI(aVar);
        if (aVar != null) {
            if (this.fzs != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        this.fzs.setText(String.format(getString(d.j.pb_history_user_name), aVar.getUserName()));
                    } else {
                        this.fzs.setText(aVar.getDescription());
                    }
                } else if (aVar.aYi() != null) {
                    if (aVar.getThreadType() == 33) {
                        this.fzs.setText(PhotoLiveCardData.getLiveIconTitle(aVar.aYi()));
                    } else if (aVar.isShareThread()) {
                        this.fzs.setText(String.format("%s%s", getString(d.j.pb_history_share_prefix), aVar.aYi()));
                    } else {
                        this.fzs.setText(aVar.aYi());
                    }
                }
            }
            if (this.beo != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.beo.setText(String.format(getString(d.j.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getForumName() != null) {
                    this.beo.setText(aVar.getForumName());
                }
            }
            if (this.cIH != null) {
                String e = am.e(new Date(aVar.getTime()));
                if (e == null) {
                    e = "";
                }
                this.cIH.setText(e);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.p
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.s(this.mRootView, d.f.list_item_selector);
        aj.s(this.mLine, d.C0141d.cp_bg_line_b);
        aj.e(this.fzs, d.C0141d.cp_cont_b, 1);
        aj.e(this.beo, d.C0141d.cp_cont_d, 1);
        aj.e(this.cIH, d.C0141d.cp_cont_d, 1);
        return true;
    }
}
