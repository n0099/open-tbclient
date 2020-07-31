package com.baidu.tieba.myCollection.history;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes18.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView eko;
    private TextView gGh;
    private TextView jVo;
    private TextView jVp;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.jVo = (TextView) view.findViewById(R.id.title);
        this.eko = (TextView) view.findViewById(R.id.content);
        this.eko.setSingleLine();
        this.eko.setEllipsize(TextUtils.TruncateAt.END);
        this.gGh = (TextView) view.findViewById(R.id.time);
        this.jVp = (TextView) view.findViewById(R.id.live_status);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ao(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.ao(aVar);
        if (aVar != null) {
            if (this.jVo != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        if (StringUtils.isNull(aVar.getUserName())) {
                            this.jVo.setText(getString(R.string.pb_history_default_user_name));
                        } else {
                            this.jVo.setText(aVar.getUserName());
                        }
                    } else {
                        this.jVo.setText(aVar.getDescription());
                    }
                } else if (aVar.cHq() != null) {
                    if (aVar.isShareThread()) {
                        this.jVo.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.cHq()));
                    } else {
                        this.jVo.setText(aVar.cHq());
                    }
                }
            }
            if (this.eko != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.eko.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getThreadType() == 49) {
                    this.eko.setText(String.format(getString(R.string.pb_history_user_name), getString(R.string.pb_history_default_user_name)));
                } else if (aVar.getForumName() != null) {
                    this.eko.setText(aVar.getForumName());
                }
            }
            if (aVar.getThreadType() == 49) {
                this.jVp.setVisibility(aVar.cHt() ? 0 : 8);
            } else {
                this.jVp.setVisibility(8);
            }
            if (this.gGh != null) {
                String l = as.l(new Date(aVar.getTime()));
                if (l == null) {
                    l = "";
                }
                this.gGh.setText(l);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        ao.setBackgroundResource(this.mLine, R.color.cp_bg_line_c);
        ao.setViewTextColor(this.jVo, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.eko, R.color.cp_cont_d, 1);
        ao.setViewTextColor(this.gGh, R.color.cp_cont_d, 1);
        ao.setViewTextColor(this.jVp, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.e.a.bbr().mf(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).b("LEFT_RIGHT", R.color.cp_other_b, R.color.cp_cont_h).aX(this.jVp);
        return true;
    }
}
