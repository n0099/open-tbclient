package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ U9InfoView bVH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(U9InfoView u9InfoView) {
        this.bVH = u9InfoView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        com.baidu.tbadk.core.data.aa aaVar;
        Context context;
        com.baidu.tbadk.core.data.aa aaVar2;
        com.baidu.tbadk.core.data.x xVar;
        Context context2;
        com.baidu.tbadk.core.data.x xVar2;
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            relativeLayout = this.bVH.bVw;
            if (view != relativeLayout) {
                linearLayout = this.bVH.bVx;
                if (view == linearLayout) {
                    aaVar = this.bVH.news_info;
                    if (!TextUtils.isEmpty(aaVar.nR())) {
                        bh pK = bh.pK();
                        context = this.bVH.mContext;
                        aaVar2 = this.bVH.news_info;
                        pK.b((TbPageContext) com.baidu.adp.base.m.D(context), new String[]{aaVar2.nR()});
                        return;
                    }
                    return;
                }
                return;
            }
            xVar = this.bVH.top_code;
            if (!TextUtils.isEmpty(xVar.nL())) {
                bh pK2 = bh.pK();
                context2 = this.bVH.mContext;
                xVar2 = this.bVH.top_code;
                pK2.b((TbPageContext) com.baidu.adp.base.m.D(context2), new String[]{xVar2.nL()});
            }
        }
    }
}
