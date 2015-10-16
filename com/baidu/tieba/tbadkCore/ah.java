package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ U9InfoView cYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(U9InfoView u9InfoView) {
        this.cYz = u9InfoView;
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
        context = this.cYz.mContext;
        if (bd.ah(context) && com.baidu.adp.lib.util.k.jd()) {
            relativeLayout = this.cYz.cYp;
            if (view != relativeLayout) {
                linearLayout = this.cYz.cYq;
                if (view == linearLayout) {
                    aaVar = this.cYz.news_info;
                    if (!TextUtils.isEmpty(aaVar.sN())) {
                        context2 = this.cYz.mContext;
                        TiebaStatic.eventStat(context2, "info_click", "click", 1, "page", "frs");
                        az uW = az.uW();
                        context3 = this.cYz.mContext;
                        aaVar2 = this.cYz.news_info;
                        uW.b((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{aaVar2.sN()});
                        return;
                    }
                    return;
                }
                return;
            }
            xVar = this.cYz.top_code;
            if (!TextUtils.isEmpty(xVar.sH())) {
                context4 = this.cYz.mContext;
                TiebaStatic.eventStat(context4, "num_click", "click", 1, new Object[0]);
                az uW2 = az.uW();
                context5 = this.cYz.mContext;
                xVar2 = this.cYz.top_code;
                uW2.b((TbPageContext) com.baidu.adp.base.l.C(context5), new String[]{xVar2.sH()});
            }
        }
    }
}
