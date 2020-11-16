package com.baidu.tieba.myCollection.history;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes23.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView eVT;
    private TextView hCR;
    private TextView lbq;
    private TextView lbr;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.lbq = (TextView) view.findViewById(R.id.title);
        this.eVT = (TextView) view.findViewById(R.id.content);
        this.eVT.setSingleLine();
        this.eVT.setEllipsize(TextUtils.TruncateAt.END);
        this.hCR = (TextView) view.findViewById(R.id.time);
        this.lbr = (TextView) view.findViewById(R.id.live_status);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.au(aVar);
        if (aVar != null) {
            if (this.lbq != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        if (StringUtils.isNull(aVar.getUserName())) {
                            this.lbq.setText(getString(R.string.pb_history_default_user_name));
                        } else {
                            this.lbq.setText(aVar.getUserName());
                        }
                    } else {
                        this.lbq.setText(aVar.getDescription());
                    }
                } else if (aVar.deB() != null) {
                    if (aVar.isShareThread()) {
                        this.lbq.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.deB()));
                    } else {
                        this.lbq.setText(aVar.deB());
                    }
                }
            }
            if (this.eVT != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.eVT.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getThreadType() == 49) {
                    this.eVT.setText(String.format(getString(R.string.pb_history_user_name), getString(R.string.pb_history_default_user_name)));
                } else if (aVar.getForumName() != null) {
                    this.eVT.setText(aVar.getForumName());
                }
            }
            if (aVar.getThreadType() == 49) {
                this.lbr.setVisibility(aVar.deE() ? 0 : 8);
            } else {
                this.lbr.setVisibility(8);
            }
            if (this.hCR != null) {
                String l = au.l(new Date(aVar.getTime()));
                if (l == null) {
                    l = "";
                }
                this.hCR.setText(l);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        ap.setBackgroundResource(this.mLine, R.color.CAM_X0204);
        ap.setViewTextColor(this.lbq, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.eVT, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.hCR, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.lbr, R.color.CAM_X0101);
        com.baidu.tbadk.core.util.e.a.brc().pM(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).b("LEFT_RIGHT", R.color.CAM_X0308, R.color.CAM_X0301).bn(this.lbr);
        return true;
    }
}
