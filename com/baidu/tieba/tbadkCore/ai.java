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
    final /* synthetic */ U9InfoView dGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(U9InfoView u9InfoView) {
        this.dGe = u9InfoView;
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
        context = this.dGe.mContext;
        if (bj.ah(context) && com.baidu.adp.lib.util.k.jh()) {
            relativeLayout = this.dGe.dFU;
            if (view != relativeLayout) {
                linearLayout = this.dGe.dFV;
                if (view == linearLayout) {
                    adVar = this.dGe.news_info;
                    if (!TextUtils.isEmpty(adVar.tb())) {
                        context2 = this.dGe.mContext;
                        TiebaStatic.eventStat(context2, "info_click", "click", 1, "page", "frs");
                        bf vn = bf.vn();
                        context3 = this.dGe.mContext;
                        adVar2 = this.dGe.news_info;
                        vn.b((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{adVar2.tb()});
                        return;
                    }
                    return;
                }
                return;
            }
            aaVar = this.dGe.top_code;
            if (!TextUtils.isEmpty(aaVar.sS())) {
                context4 = this.dGe.mContext;
                TiebaStatic.eventStat(context4, "num_click", "click", 1, new Object[0]);
                bf vn2 = bf.vn();
                context5 = this.dGe.mContext;
                aaVar2 = this.dGe.top_code;
                vn2.b((TbPageContext) com.baidu.adp.base.l.C(context5), new String[]{aaVar2.sS()});
            }
        }
    }
}
