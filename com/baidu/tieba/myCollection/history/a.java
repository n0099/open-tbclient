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
/* loaded from: classes23.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView ewr;
    private TextView gWv;
    private TextView kts;
    private TextView ktt;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.kts = (TextView) view.findViewById(R.id.title);
        this.ewr = (TextView) view.findViewById(R.id.content);
        this.ewr.setSingleLine();
        this.ewr.setEllipsize(TextUtils.TruncateAt.END);
        this.gWv = (TextView) view.findViewById(R.id.time);
        this.ktt = (TextView) view.findViewById(R.id.live_status);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ar(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.ar(aVar);
        if (aVar != null) {
            if (this.kts != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        if (StringUtils.isNull(aVar.getUserName())) {
                            this.kts.setText(getString(R.string.pb_history_default_user_name));
                        } else {
                            this.kts.setText(aVar.getUserName());
                        }
                    } else {
                        this.kts.setText(aVar.getDescription());
                    }
                } else if (aVar.cVL() != null) {
                    if (aVar.isShareThread()) {
                        this.kts.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.cVL()));
                    } else {
                        this.kts.setText(aVar.cVL());
                    }
                }
            }
            if (this.ewr != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.ewr.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getThreadType() == 49) {
                    this.ewr.setText(String.format(getString(R.string.pb_history_user_name), getString(R.string.pb_history_default_user_name)));
                } else if (aVar.getForumName() != null) {
                    this.ewr.setText(aVar.getForumName());
                }
            }
            if (aVar.getThreadType() == 49) {
                this.ktt.setVisibility(aVar.cVO() ? 0 : 8);
            } else {
                this.ktt.setVisibility(8);
            }
            if (this.gWv != null) {
                String l = at.l(new Date(aVar.getTime()));
                if (l == null) {
                    l = "";
                }
                this.gWv.setText(l);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        ap.setBackgroundResource(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.kts, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.ewr, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.gWv, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.ktt, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.bkL().ov(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).b("LEFT_RIGHT", R.color.cp_other_b, R.color.cp_cont_h).bb(this.ktt);
        return true;
    }
}
