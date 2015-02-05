package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.bubble.BubbleListData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ b bVi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.bVi = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BubbleListData bubbleListData;
        Context context;
        Context context2;
        com.baidu.tieba.tbadkCore.bubble.x xVar;
        Context context3;
        Context context4;
        com.baidu.tieba.tbadkCore.bubble.x xVar2;
        if (view instanceof com.baidu.tieba.tbadkCore.bubble.z) {
            int intValue = ((Integer) view.getTag()).intValue();
            bubbleListData = this.bVi.bUY;
            BubbleListData.BubbleData bubbleData = bubbleListData.getB_info().get(intValue);
            boolean loadBoolean = TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false);
            if (bubbleData != null && !bubbleData.isDef()) {
                if (bubbleData.getBcode() != 0 && !bubbleData.canUse() && !loadBoolean) {
                    if (bubbleData.isFree()) {
                        context3 = this.bVi.mContext;
                        if (context3 instanceof TbPageContextSupport) {
                            context4 = this.bVi.mContext;
                            TbPageContext pageContext = ((TbPageContextSupport) context4).getPageContext();
                            xVar2 = this.bVi.bVg;
                            com.baidu.tieba.tbadkCore.bubble.m.a(pageContext, bubbleData, xVar2);
                            return;
                        }
                        return;
                    }
                    context = this.bVi.mContext;
                    if (context instanceof TbPageContextSupport) {
                        context2 = this.bVi.mContext;
                        TbPageContext pageContext2 = ((TbPageContextSupport) context2).getPageContext();
                        xVar = this.bVi.bVh;
                        com.baidu.tieba.tbadkCore.bubble.m.b(pageContext2, bubbleData, xVar);
                        return;
                    }
                    return;
                }
                this.bVi.hL(bubbleData.getBcode());
            }
        }
    }
}
