package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.util.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ U9InfoView crI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(U9InfoView u9InfoView) {
        this.crI = u9InfoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        com.baidu.tbadk.core.data.aa aaVar;
        Context context2;
        Context context3;
        com.baidu.tbadk.core.data.aa aaVar2;
        com.baidu.tbadk.core.data.x xVar;
        Context context4;
        Context context5;
        com.baidu.tbadk.core.data.x xVar2;
        context = this.crI.mContext;
        if (bq.ae(context) && com.baidu.adp.lib.util.n.isNetOk()) {
            relativeLayout = this.crI.crx;
            if (view != relativeLayout) {
                linearLayout = this.crI.cry;
                if (view == linearLayout) {
                    aaVar = this.crI.news_info;
                    if (!TextUtils.isEmpty(aaVar.rH())) {
                        context2 = this.crI.mContext;
                        TiebaStatic.eventStat(context2, "info_click", "click", 1, "page", "frs");
                        bi tO = bi.tO();
                        context3 = this.crI.mContext;
                        aaVar2 = this.crI.news_info;
                        tO.b((TbPageContext) com.baidu.adp.base.n.D(context3), new String[]{aaVar2.rH()});
                        return;
                    }
                    return;
                }
                return;
            }
            xVar = this.crI.top_code;
            if (!TextUtils.isEmpty(xVar.rB())) {
                context4 = this.crI.mContext;
                TiebaStatic.eventStat(context4, "num_click", "click", 1, new Object[0]);
                bi tO2 = bi.tO();
                context5 = this.crI.mContext;
                xVar2 = this.crI.top_code;
                tO2.b((TbPageContext) com.baidu.adp.base.n.D(context5), new String[]{xVar2.rB()});
            }
        }
    }
}
