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
/* loaded from: classes8.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView fkH;
    private TextView hYL;
    private TextView lxF;
    private TextView lxG;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.lxF = (TextView) view.findViewById(R.id.title);
        this.fkH = (TextView) view.findViewById(R.id.content);
        this.fkH.setSingleLine();
        this.fkH.setEllipsize(TextUtils.TruncateAt.END);
        this.hYL = (TextView) view.findViewById(R.id.time);
        this.lxG = (TextView) view.findViewById(R.id.live_status);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aw(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.aw(aVar);
        if (aVar != null) {
            if (this.lxF != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        if (StringUtils.isNull(aVar.getUserName())) {
                            this.lxF.setText(getString(R.string.pb_history_default_user_name));
                        } else {
                            this.lxF.setText(aVar.getUserName());
                        }
                    } else {
                        this.lxF.setText(aVar.getDescription());
                    }
                } else if (aVar.dhM() != null) {
                    if (aVar.isShareThread()) {
                        this.lxF.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.dhM()));
                    } else {
                        this.lxF.setText(aVar.dhM());
                    }
                }
            }
            if (this.fkH != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.fkH.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getThreadType() == 49) {
                    this.fkH.setText(String.format(getString(R.string.pb_history_user_name), getString(R.string.pb_history_default_user_name)));
                } else if (aVar.getForumName() != null) {
                    this.fkH.setText(aVar.getForumName());
                }
            }
            if (aVar.getThreadType() == 49) {
                this.lxG.setVisibility(aVar.isLive() ? 0 : 8);
            } else {
                this.lxG.setVisibility(8);
            }
            if (this.hYL != null) {
                String l = au.l(new Date(aVar.getTime()));
                if (l == null) {
                    l = "";
                }
                this.hYL.setText(l);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        ap.setBackgroundResource(this.mLine, R.color.CAM_X0204);
        ap.setViewTextColor(this.lxF, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.fkH, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.hYL, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.lxG, R.color.CAM_X0101);
        com.baidu.tbadk.core.util.f.a.btv().oV(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).b("LEFT_RIGHT", R.color.CAM_X0308, R.color.CAM_X0301).bv(this.lxG);
        return true;
    }
}
