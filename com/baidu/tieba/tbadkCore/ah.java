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
public class ah implements View.OnClickListener {
    final /* synthetic */ U9InfoView cIi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(U9InfoView u9InfoView) {
        this.cIi = u9InfoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        com.baidu.tbadk.core.data.z zVar;
        Context context2;
        Context context3;
        com.baidu.tbadk.core.data.z zVar2;
        com.baidu.tbadk.core.data.w wVar;
        Context context4;
        Context context5;
        com.baidu.tbadk.core.data.w wVar2;
        context = this.cIi.mContext;
        if (bb.ah(context) && com.baidu.adp.lib.util.k.jf()) {
            relativeLayout = this.cIi.cHY;
            if (view != relativeLayout) {
                linearLayout = this.cIi.cHZ;
                if (view == linearLayout) {
                    zVar = this.cIi.news_info;
                    if (!TextUtils.isEmpty(zVar.sL())) {
                        context2 = this.cIi.mContext;
                        TiebaStatic.eventStat(context2, "info_click", "click", 1, "page", "frs");
                        ax uR = ax.uR();
                        context3 = this.cIi.mContext;
                        zVar2 = this.cIi.news_info;
                        uR.b((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{zVar2.sL()});
                        return;
                    }
                    return;
                }
                return;
            }
            wVar = this.cIi.top_code;
            if (!TextUtils.isEmpty(wVar.sF())) {
                context4 = this.cIi.mContext;
                TiebaStatic.eventStat(context4, "num_click", "click", 1, new Object[0]);
                ax uR2 = ax.uR();
                context5 = this.cIi.mContext;
                wVar2 = this.cIi.top_code;
                uR2.b((TbPageContext) com.baidu.adp.base.l.C(context5), new String[]{wVar2.sF()});
            }
        }
    }
}
