package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ U9InfoView bXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(U9InfoView u9InfoView) {
        this.bXy = u9InfoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        com.baidu.tbadk.core.data.ab abVar;
        Context context;
        com.baidu.tbadk.core.data.ab abVar2;
        com.baidu.tbadk.core.data.y yVar;
        Context context2;
        com.baidu.tbadk.core.data.y yVar2;
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            relativeLayout = this.bXy.bXn;
            if (view != relativeLayout) {
                linearLayout = this.bXy.bXo;
                if (view == linearLayout) {
                    abVar = this.bXy.news_info;
                    if (!TextUtils.isEmpty(abVar.nN())) {
                        bm pO = bm.pO();
                        context = this.bXy.mContext;
                        abVar2 = this.bXy.news_info;
                        pO.b((TbPageContext) com.baidu.adp.base.m.D(context), new String[]{abVar2.nN()});
                        return;
                    }
                    return;
                }
                return;
            }
            yVar = this.bXy.top_code;
            if (!TextUtils.isEmpty(yVar.nH())) {
                bm pO2 = bm.pO();
                context2 = this.bXy.mContext;
                yVar2 = this.bXy.top_code;
                pO2.b((TbPageContext) com.baidu.adp.base.m.D(context2), new String[]{yVar2.nH()});
            }
        }
    }
}
