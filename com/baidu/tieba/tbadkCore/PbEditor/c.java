package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.tbadkCore.bubble.BubbleListData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.tbadkCore.bubble.k {
    final /* synthetic */ b bTq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bTq = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.k
    public void a(BubbleListData bubbleListData) {
        com.baidu.tieba.tbadkCore.bubble.h hVar;
        com.baidu.tieba.tbadkCore.bubble.h hVar2;
        com.baidu.tieba.tbadkCore.bubble.h hVar3;
        com.baidu.tieba.tbadkCore.bubble.h hVar4;
        com.baidu.tieba.tbadkCore.bubble.h hVar5;
        com.baidu.tieba.tbadkCore.bubble.h hVar6;
        com.baidu.tieba.tbadkCore.bubble.h hVar7;
        Context context;
        Context context2;
        if (bubbleListData == null) {
            this.bTq.afW().afZ();
            return;
        }
        this.bTq.bTg = bubbleListData.m257clone();
        hVar = this.bTq.bTf;
        if (hVar.agp() > 0) {
            List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
            if (b_info != null && b_info.size() != 0) {
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null) {
                        int bcode = bubbleData.getBcode();
                        hVar3 = this.bTq.bTf;
                        if (bcode == hVar3.agp()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            hVar4 = this.bTq.bTf;
                            hVar5 = this.bTq.bTf;
                            hVar4.hL(hVar5.agp());
                            hVar6 = this.bTq.bTf;
                            hVar7 = this.bTq.bTf;
                            int agp = hVar7.agp();
                            context = this.bTq.mContext;
                            int M = com.baidu.adp.lib.util.l.M(context);
                            context2 = this.bTq.mContext;
                            hVar6.w(agp, M, com.baidu.adp.lib.util.l.N(context2));
                        } else {
                            continue;
                        }
                    }
                }
                hVar2 = this.bTq.bTf;
                hVar2.hM(-1);
            } else {
                return;
            }
        }
        this.bTq.aeL();
        this.bTq.afW().b(this.bTq);
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.k
    public void b(BubbleListData bubbleListData) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        this.bTq.bTj = false;
        this.bTq.bTg = null;
        if (bubbleListData == null) {
            context = this.bTq.mContext;
            UtilHelper.showToast(context, com.baidu.tieba.z.neterror);
        } else if (bubbleListData.getError_code().equals("0")) {
            context2 = this.bTq.mContext;
            UtilHelper.showToast(context2, com.baidu.tieba.z.neterror);
        } else if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
            context4 = this.bTq.mContext;
            UtilHelper.showToast(context4, bubbleListData.getError_msg());
        } else {
            context3 = this.bTq.mContext;
            UtilHelper.showToast(context3, com.baidu.tieba.z.neterror);
        }
        if (this.bTq.afW() != null) {
            this.bTq.afW().afZ();
        }
    }
}
