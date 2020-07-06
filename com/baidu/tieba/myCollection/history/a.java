package com.baidu.tieba.myCollection.history;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes11.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView eee;
    private TextView gAK;
    private TextView jMQ;
    private TextView jMR;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.jMQ = (TextView) view.findViewById(R.id.title);
        this.eee = (TextView) view.findViewById(R.id.content);
        this.eee.setSingleLine();
        this.eee.setEllipsize(TextUtils.TruncateAt.END);
        this.gAK = (TextView) view.findViewById(R.id.time);
        this.jMR = (TextView) view.findViewById(R.id.live_status);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ao(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.ao(aVar);
        if (aVar != null) {
            if (this.jMQ != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        if (StringUtils.isNull(aVar.getUserName())) {
                            this.jMQ.setText(getString(R.string.pb_history_default_user_name));
                        } else {
                            this.jMQ.setText(aVar.getUserName());
                        }
                    } else {
                        this.jMQ.setText(aVar.getDescription());
                    }
                } else if (aVar.cDI() != null) {
                    if (aVar.isShareThread()) {
                        this.jMQ.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.cDI()));
                    } else {
                        this.jMQ.setText(aVar.cDI());
                    }
                }
            }
            if (this.eee != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.eee.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getThreadType() == 49) {
                    this.eee.setText(String.format(getString(R.string.pb_history_user_name), getString(R.string.pb_history_default_user_name)));
                } else if (aVar.getForumName() != null) {
                    this.eee.setText(aVar.getForumName());
                }
            }
            if (aVar.getThreadType() == 49) {
                this.jMR.setVisibility(aVar.cDL() ? 0 : 8);
            } else {
                this.jMR.setVisibility(8);
            }
            if (this.gAK != null) {
                String j = ar.j(new Date(aVar.getTime()));
                if (j == null) {
                    j = "";
                }
                this.gAK.setText(j);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        an.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        an.setBackgroundResource(this.mLine, R.color.cp_bg_line_c);
        an.setViewTextColor(this.jMQ, R.color.cp_cont_b, 1);
        an.setViewTextColor(this.eee, R.color.cp_cont_d, 1);
        an.setViewTextColor(this.gAK, R.color.cp_cont_d, 1);
        an.setViewTextColor(this.jMR, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.aXq().lL(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).b("LEFT_RIGHT", R.color.cp_other_b, R.color.cp_cont_h).aR(this.jMR);
        return true;
    }
}
