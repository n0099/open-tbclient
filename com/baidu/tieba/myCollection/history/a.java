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
/* loaded from: classes18.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView eun;
    private TextView gSN;
    private TextView kkT;
    private TextView kkU;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.kkT = (TextView) view.findViewById(R.id.title);
        this.eun = (TextView) view.findViewById(R.id.content);
        this.eun.setSingleLine();
        this.eun.setEllipsize(TextUtils.TruncateAt.END);
        this.gSN = (TextView) view.findViewById(R.id.time);
        this.kkU = (TextView) view.findViewById(R.id.live_status);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aq(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.aq(aVar);
        if (aVar != null) {
            if (this.kkT != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        if (StringUtils.isNull(aVar.getUserName())) {
                            this.kkT.setText(getString(R.string.pb_history_default_user_name));
                        } else {
                            this.kkT.setText(aVar.getUserName());
                        }
                    } else {
                        this.kkT.setText(aVar.getDescription());
                    }
                } else if (aVar.cSg() != null) {
                    if (aVar.isShareThread()) {
                        this.kkT.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.cSg()));
                    } else {
                        this.kkT.setText(aVar.cSg());
                    }
                }
            }
            if (this.eun != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.eun.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getThreadType() == 49) {
                    this.eun.setText(String.format(getString(R.string.pb_history_user_name), getString(R.string.pb_history_default_user_name)));
                } else if (aVar.getForumName() != null) {
                    this.eun.setText(aVar.getForumName());
                }
            }
            if (aVar.getThreadType() == 49) {
                this.kkU.setVisibility(aVar.cSj() ? 0 : 8);
            } else {
                this.kkU.setVisibility(8);
            }
            if (this.gSN != null) {
                String l = at.l(new Date(aVar.getTime()));
                if (l == null) {
                    l = "";
                }
                this.gSN.setText(l);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        ap.setBackgroundResource(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.kkT, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.eun, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.gSN, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.kkU, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.bjQ().oj(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).b("LEFT_RIGHT", R.color.cp_other_b, R.color.cp_cont_h).aZ(this.kkU);
        return true;
    }
}
