package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ U9InfoView dyK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(U9InfoView u9InfoView) {
        this.dyK = u9InfoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        com.baidu.tbadk.core.data.ad adVar;
        Context context2;
        Context context3;
        com.baidu.tbadk.core.data.ad adVar2;
        com.baidu.tbadk.core.data.aa aaVar;
        Context context4;
        Context context5;
        com.baidu.tbadk.core.data.aa aaVar2;
        context = this.dyK.mContext;
        if (bj.ah(context) && com.baidu.adp.lib.util.k.jg()) {
            relativeLayout = this.dyK.dyA;
            if (view != relativeLayout) {
                linearLayout = this.dyK.dyB;
                if (view == linearLayout) {
                    adVar = this.dyK.news_info;
                    if (!TextUtils.isEmpty(adVar.tr())) {
                        context2 = this.dyK.mContext;
                        TiebaStatic.eventStat(context2, "info_click", "click", 1, "page", "frs");
                        bf vD = bf.vD();
                        context3 = this.dyK.mContext;
                        adVar2 = this.dyK.news_info;
                        vD.b((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{adVar2.tr()});
                        return;
                    }
                    return;
                }
                return;
            }
            aaVar = this.dyK.top_code;
            if (!TextUtils.isEmpty(aaVar.ti())) {
                context4 = this.dyK.mContext;
                TiebaStatic.eventStat(context4, "num_click", "click", 1, new Object[0]);
                bf vD2 = bf.vD();
                context5 = this.dyK.mContext;
                aaVar2 = this.dyK.top_code;
                vD2.b((TbPageContext) com.baidu.adp.base.l.C(context5), new String[]{aaVar2.ti()});
            }
        }
    }
}
