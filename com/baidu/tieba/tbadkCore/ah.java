package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ U9InfoView dVZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(U9InfoView u9InfoView) {
        this.dVZ = u9InfoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        al alVar;
        al alVar2;
        Context context2;
        Context context3;
        al alVar3;
        com.baidu.tbadk.core.data.ai aiVar;
        com.baidu.tbadk.core.data.ai aiVar2;
        Context context4;
        Context context5;
        com.baidu.tbadk.core.data.ai aiVar3;
        context = this.dVZ.mContext;
        if (bi.ah(context) && com.baidu.adp.lib.util.k.jq()) {
            relativeLayout = this.dVZ.dVP;
            if (view != relativeLayout) {
                linearLayout = this.dVZ.dVQ;
                if (view == linearLayout) {
                    alVar = this.dVZ.news_info;
                    if (alVar != null) {
                        alVar2 = this.dVZ.news_info;
                        if (!TextUtils.isEmpty(alVar2.tZ())) {
                            context2 = this.dVZ.mContext;
                            TiebaStatic.eventStat(context2, "info_click", "click", 1, "page", "frs");
                            be wt = be.wt();
                            context3 = this.dVZ.mContext;
                            alVar3 = this.dVZ.news_info;
                            wt.c((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{alVar3.tZ()});
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aiVar = this.dVZ.top_code;
            if (aiVar != null) {
                aiVar2 = this.dVZ.top_code;
                if (!TextUtils.isEmpty(aiVar2.tQ())) {
                    context4 = this.dVZ.mContext;
                    TiebaStatic.eventStat(context4, "num_click", "click", 1, new Object[0]);
                    be wt2 = be.wt();
                    context5 = this.dVZ.mContext;
                    aiVar3 = this.dVZ.top_code;
                    wt2.c((TbPageContext) com.baidu.adp.base.l.C(context5), new String[]{aiVar3.tQ()});
                }
            }
        }
    }
}
