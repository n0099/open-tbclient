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
/* loaded from: classes24.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView fdq;
    private TextView hMy;
    private TextView loQ;
    private TextView loR;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.loQ = (TextView) view.findViewById(R.id.title);
        this.fdq = (TextView) view.findViewById(R.id.content);
        this.fdq.setSingleLine();
        this.fdq.setEllipsize(TextUtils.TruncateAt.END);
        this.hMy = (TextView) view.findViewById(R.id.time);
        this.loR = (TextView) view.findViewById(R.id.live_status);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.au(aVar);
        if (aVar != null) {
            if (this.loQ != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        if (StringUtils.isNull(aVar.getUserName())) {
                            this.loQ.setText(getString(R.string.pb_history_default_user_name));
                        } else {
                            this.loQ.setText(aVar.getUserName());
                        }
                    } else {
                        this.loQ.setText(aVar.getDescription());
                    }
                } else if (aVar.djN() != null) {
                    if (aVar.isShareThread()) {
                        this.loQ.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.djN()));
                    } else {
                        this.loQ.setText(aVar.djN());
                    }
                }
            }
            if (this.fdq != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.fdq.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getThreadType() == 49) {
                    this.fdq.setText(String.format(getString(R.string.pb_history_user_name), getString(R.string.pb_history_default_user_name)));
                } else if (aVar.getForumName() != null) {
                    this.fdq.setText(aVar.getForumName());
                }
            }
            if (aVar.getThreadType() == 49) {
                this.loR.setVisibility(aVar.djQ() ? 0 : 8);
            } else {
                this.loR.setVisibility(8);
            }
            if (this.hMy != null) {
                String l = au.l(new Date(aVar.getTime()));
                if (l == null) {
                    l = "";
                }
                this.hMy.setText(l);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        ap.setBackgroundResource(this.mLine, R.color.CAM_X0204);
        ap.setViewTextColor(this.loQ, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.fdq, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.hMy, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.loR, R.color.CAM_X0101);
        com.baidu.tbadk.core.util.e.a.buz().qm(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).b("LEFT_RIGHT", R.color.CAM_X0308, R.color.CAM_X0301).bq(this.loR);
        return true;
    }
}
