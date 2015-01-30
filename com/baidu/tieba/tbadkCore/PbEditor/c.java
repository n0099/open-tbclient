package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.tbadkCore.bubble.BubbleListData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.tbadkCore.bubble.k {
    final /* synthetic */ b bVj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bVj = bVar;
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
            this.bVj.agA().agD();
            return;
        }
        this.bVj.bUZ = bubbleListData.m257clone();
        hVar = this.bVj.bUY;
        if (hVar.agU() > 0) {
            List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
            if (b_info != null && b_info.size() != 0) {
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null) {
                        int bcode = bubbleData.getBcode();
                        hVar3 = this.bVj.bUY;
                        if (bcode == hVar3.agU()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            hVar4 = this.bVj.bUY;
                            hVar5 = this.bVj.bUY;
                            hVar4.hU(hVar5.agU());
                            hVar6 = this.bVj.bUY;
                            hVar7 = this.bVj.bUY;
                            int agU = hVar7.agU();
                            context = this.bVj.mContext;
                            int M = com.baidu.adp.lib.util.l.M(context);
                            context2 = this.bVj.mContext;
                            hVar6.w(agU, M, com.baidu.adp.lib.util.l.N(context2));
                        } else {
                            continue;
                        }
                    }
                }
                hVar2 = this.bVj.bUY;
                hVar2.hV(-1);
            } else {
                return;
            }
        }
        this.bVj.afp();
        this.bVj.agA().b(this.bVj);
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.k
    public void b(BubbleListData bubbleListData) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        this.bVj.bVc = false;
        this.bVj.bUZ = null;
        if (bubbleListData == null) {
            context = this.bVj.mContext;
            UtilHelper.showToast(context, com.baidu.tieba.z.neterror);
        } else if (bubbleListData.getError_code().equals("0")) {
            context2 = this.bVj.mContext;
            UtilHelper.showToast(context2, com.baidu.tieba.z.neterror);
        } else if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
            context4 = this.bVj.mContext;
            UtilHelper.showToast(context4, bubbleListData.getError_msg());
        } else {
            context3 = this.bVj.mContext;
            UtilHelper.showToast(context3, com.baidu.tieba.z.neterror);
        }
        if (this.bVj.agA() != null) {
            this.bVj.agA().agD();
        }
    }
}
