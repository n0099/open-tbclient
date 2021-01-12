package com.baidu.tieba.myCollection.history;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes7.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.myCollection.baseHistory.a, b> {
    private TextView fio;
    private TextView hUq;
    private TextView lpB;
    private TextView lpC;
    private View mLine;
    private View mRootView;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.lpB = (TextView) view.findViewById(R.id.title);
        this.fio = (TextView) view.findViewById(R.id.content);
        this.fio.setSingleLine();
        this.fio.setEllipsize(TextUtils.TruncateAt.END);
        this.hUq = (TextView) view.findViewById(R.id.time);
        this.lpC = (TextView) view.findViewById(R.id.live_status);
        this.mLine = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aw(com.baidu.tieba.myCollection.baseHistory.a aVar) {
        super.aw(aVar);
        if (aVar != null) {
            if (this.lpB != null) {
                if (aVar.getThreadType() == 49) {
                    if (StringUtils.isNull(aVar.getDescription())) {
                        if (StringUtils.isNull(aVar.getUserName())) {
                            this.lpB.setText(getString(R.string.pb_history_default_user_name));
                        } else {
                            this.lpB.setText(aVar.getUserName());
                        }
                    } else {
                        this.lpB.setText(aVar.getDescription());
                    }
                } else if (aVar.dfL() != null) {
                    if (aVar.isShareThread()) {
                        this.lpB.setText(String.format("%s%s", getString(R.string.pb_history_share_prefix), aVar.dfL()));
                    } else {
                        this.lpB.setText(aVar.dfL());
                    }
                }
            }
            if (this.fio != null) {
                if (aVar.getThreadType() == 49 && !TextUtils.isEmpty(aVar.getUserName())) {
                    this.fio.setText(String.format(getString(R.string.pb_history_user_name), aVar.getUserName()));
                } else if (aVar.getThreadType() == 49) {
                    this.fio.setText(String.format(getString(R.string.pb_history_user_name), getString(R.string.pb_history_default_user_name)));
                } else if (aVar.getForumName() != null) {
                    this.fio.setText(aVar.getForumName());
                }
            }
            if (aVar.getThreadType() == 49) {
                this.lpC.setVisibility(aVar.isLive() ? 0 : 8);
            } else {
                this.lpC.setVisibility(8);
            }
            if (this.hUq != null) {
                String l = at.l(new Date(aVar.getTime()));
                if (l == null) {
                    l = "";
                }
                this.hUq.setText(l);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    @SuppressLint({"ResourceAsColor"})
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.mRootView, R.drawable.list_item_selector);
        ao.setBackgroundResource(this.mLine, R.color.CAM_X0204);
        ao.setViewTextColor(this.lpB, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.fio, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.hUq, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.lpC, R.color.CAM_X0101);
        com.baidu.tbadk.core.util.f.a.btb().oQ(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).b("LEFT_RIGHT", R.color.CAM_X0308, R.color.CAM_X0301).bz(this.lpC);
        return true;
    }
}
