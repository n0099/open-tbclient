package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ U9InfoView cQI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(U9InfoView u9InfoView) {
        this.cQI = u9InfoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        com.baidu.tbadk.core.data.ab abVar;
        Context context2;
        Context context3;
        com.baidu.tbadk.core.data.ab abVar2;
        com.baidu.tbadk.core.data.y yVar;
        Context context4;
        Context context5;
        com.baidu.tbadk.core.data.y yVar2;
        context = this.cQI.mContext;
        if (bb.ah(context) && com.baidu.adp.lib.util.k.jc()) {
            relativeLayout = this.cQI.cQy;
            if (view != relativeLayout) {
                linearLayout = this.cQI.cQz;
                if (view == linearLayout) {
                    abVar = this.cQI.news_info;
                    if (!TextUtils.isEmpty(abVar.sQ())) {
                        context2 = this.cQI.mContext;
                        TiebaStatic.eventStat(context2, "info_click", "click", 1, "page", "frs");
                        ax uX = ax.uX();
                        context3 = this.cQI.mContext;
                        abVar2 = this.cQI.news_info;
                        uX.b((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{abVar2.sQ()});
                        return;
                    }
                    return;
                }
                return;
            }
            yVar = this.cQI.top_code;
            if (!TextUtils.isEmpty(yVar.sK())) {
                context4 = this.cQI.mContext;
                TiebaStatic.eventStat(context4, "num_click", "click", 1, new Object[0]);
                ax uX2 = ax.uX();
                context5 = this.cQI.mContext;
                yVar2 = this.cQI.top_code;
                uX2.b((TbPageContext) com.baidu.adp.base.l.C(context5), new String[]{yVar2.sK()});
            }
        }
    }
}
