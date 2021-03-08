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
/* loaded from: classes7.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView fmg;
    private TextView iaI;
    private TextView lzW;
    private TextView lzX;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.lzW = (TextView) view.findViewById(R.id.title);
        this.fmg = (TextView) view.findViewById(R.id.content);
        this.fmg.setSingleLine();
        this.fmg.setEllipsize(TextUtils.TruncateAt.END);
        this.iaI = (TextView) view.findViewById(R.id.time);
        this.lzX = (TextView) view.findViewById(R.id.live_status);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ay(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.ay(aVar);
        if (aVar != null) {
            if (this.lzW != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        if (StringUtils.isNull(aVar.getUserName())) {
                            this.lzW.setText(getString(R.string.pb_history_default_user_name));
                        } else {
                            this.lzW.setText(aVar.getUserName());
                        }
                    } else {
                        this.lzW.setText(aVar.getDescription());
                    }
                } else if (aVar.dic() != null) {
                    if (aVar.isShareThread()) {
                        this.lzW.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.dic()));
                    } else {
                        this.lzW.setText(aVar.dic());
                    }
                }
            }
            if (this.fmg != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.fmg.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getThreadType() == 49) {
                    this.fmg.setText(String.format(getString(R.string.pb_history_user_name), getString(R.string.pb_history_default_user_name)));
                } else if (aVar.getForumName() != null) {
                    this.fmg.setText(aVar.getForumName());
                }
            }
            if (aVar.getThreadType() == 49) {
                this.lzX.setVisibility(aVar.isLive() ? 0 : 8);
            } else {
                this.lzX.setVisibility(8);
            }
            if (this.iaI != null) {
                String l = au.l(new Date(aVar.getTime()));
                if (l == null) {
                    l = "";
                }
                this.iaI.setText(l);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        ap.setBackgroundResource(this.mLine, R.color.CAM_X0204);
        ap.setViewTextColor(this.lzW, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.fmg, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.iaI, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.lzX, R.color.CAM_X0101);
        com.baidu.tbadk.core.util.f.a.bty().oW(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).b("LEFT_RIGHT", R.color.CAM_X0308, R.color.CAM_X0301).bv(this.lzX);
        return true;
    }
}
