package com.baidu.tieba.myCollection.history;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes24.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView eIB;
    private TextView hls;
    private TextView kIE;
    private TextView kIF;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.kIE = (TextView) view.findViewById(R.id.title);
        this.eIB = (TextView) view.findViewById(R.id.content);
        this.eIB.setSingleLine();
        this.eIB.setEllipsize(TextUtils.TruncateAt.END);
        this.hls = (TextView) view.findViewById(R.id.time);
        this.kIF = (TextView) view.findViewById(R.id.live_status);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.au(aVar);
        if (aVar != null) {
            if (this.kIE != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        if (StringUtils.isNull(aVar.getUserName())) {
                            this.kIE.setText(getString(R.string.pb_history_default_user_name));
                        } else {
                            this.kIE.setText(aVar.getUserName());
                        }
                    } else {
                        this.kIE.setText(aVar.getDescription());
                    }
                } else if (aVar.cZu() != null) {
                    if (aVar.isShareThread()) {
                        this.kIE.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.cZu()));
                    } else {
                        this.kIE.setText(aVar.cZu());
                    }
                }
            }
            if (this.eIB != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.eIB.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getThreadType() == 49) {
                    this.eIB.setText(String.format(getString(R.string.pb_history_user_name), getString(R.string.pb_history_default_user_name)));
                } else if (aVar.getForumName() != null) {
                    this.eIB.setText(aVar.getForumName());
                }
            }
            if (aVar.getThreadType() == 49) {
                this.kIF.setVisibility(aVar.cZx() ? 0 : 8);
            } else {
                this.kIF.setVisibility(8);
            }
            if (this.hls != null) {
                String l = at.l(new Date(aVar.getTime()));
                if (l == null) {
                    l = "";
                }
                this.hls.setText(l);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        ap.setBackgroundResource(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.kIE, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.eIB, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.hls, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.kIF, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.bnv().oT(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).b("LEFT_RIGHT", R.color.cp_other_b, R.color.cp_cont_h).bf(this.kIF);
        return true;
    }
}
