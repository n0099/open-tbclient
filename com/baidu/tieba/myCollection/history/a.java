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
    private TextView euj;
    private TextView gSJ;
    private TextView kkM;
    private TextView kkN;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.kkM = (TextView) view.findViewById(R.id.title);
        this.euj = (TextView) view.findViewById(R.id.content);
        this.euj.setSingleLine();
        this.euj.setEllipsize(TextUtils.TruncateAt.END);
        this.gSJ = (TextView) view.findViewById(R.id.time);
        this.kkN = (TextView) view.findViewById(R.id.live_status);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aq(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.aq(aVar);
        if (aVar != null) {
            if (this.kkM != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        if (StringUtils.isNull(aVar.getUserName())) {
                            this.kkM.setText(getString(R.string.pb_history_default_user_name));
                        } else {
                            this.kkM.setText(aVar.getUserName());
                        }
                    } else {
                        this.kkM.setText(aVar.getDescription());
                    }
                } else if (aVar.cSf() != null) {
                    if (aVar.isShareThread()) {
                        this.kkM.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.cSf()));
                    } else {
                        this.kkM.setText(aVar.cSf());
                    }
                }
            }
            if (this.euj != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.euj.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getThreadType() == 49) {
                    this.euj.setText(String.format(getString(R.string.pb_history_user_name), getString(R.string.pb_history_default_user_name)));
                } else if (aVar.getForumName() != null) {
                    this.euj.setText(aVar.getForumName());
                }
            }
            if (aVar.getThreadType() == 49) {
                this.kkN.setVisibility(aVar.cSi() ? 0 : 8);
            } else {
                this.kkN.setVisibility(8);
            }
            if (this.gSJ != null) {
                String l = at.l(new Date(aVar.getTime()));
                if (l == null) {
                    l = "";
                }
                this.gSJ.setText(l);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        ap.setBackgroundResource(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.kkM, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.euj, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.gSJ, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.kkN, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.bjQ().oj(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).b("LEFT_RIGHT", R.color.cp_other_b, R.color.cp_cont_h).aZ(this.kkN);
        return true;
    }
}
