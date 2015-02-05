package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.tbadkCore.bubble.BubbleListData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.tbadkCore.bubble.k {
    final /* synthetic */ b bVi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bVi = bVar;
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
            this.bVi.agv().agy();
            return;
        }
        this.bVi.bUY = bubbleListData.m257clone();
        hVar = this.bVi.bUX;
        if (hVar.agP() > 0) {
            List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
            if (b_info != null && b_info.size() != 0) {
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null) {
                        int bcode = bubbleData.getBcode();
                        hVar3 = this.bVi.bUX;
                        if (bcode == hVar3.agP()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            hVar4 = this.bVi.bUX;
                            hVar5 = this.bVi.bUX;
                            hVar4.hU(hVar5.agP());
                            hVar6 = this.bVi.bUX;
                            hVar7 = this.bVi.bUX;
                            int agP = hVar7.agP();
                            context = this.bVi.mContext;
                            int M = com.baidu.adp.lib.util.l.M(context);
                            context2 = this.bVi.mContext;
                            hVar6.w(agP, M, com.baidu.adp.lib.util.l.N(context2));
                        } else {
                            continue;
                        }
                    }
                }
                hVar2 = this.bVi.bUX;
                hVar2.hV(-1);
            } else {
                return;
            }
        }
        this.bVi.afk();
        this.bVi.agv().b(this.bVi);
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.k
    public void b(BubbleListData bubbleListData) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        this.bVi.bVb = false;
        this.bVi.bUY = null;
        if (bubbleListData == null) {
            context = this.bVi.mContext;
            UtilHelper.showToast(context, com.baidu.tieba.z.neterror);
        } else if (bubbleListData.getError_code().equals("0")) {
            context2 = this.bVi.mContext;
            UtilHelper.showToast(context2, com.baidu.tieba.z.neterror);
        } else if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
            context4 = this.bVi.mContext;
            UtilHelper.showToast(context4, bubbleListData.getError_msg());
        } else {
            context3 = this.bVi.mContext;
            UtilHelper.showToast(context3, com.baidu.tieba.z.neterror);
        }
        if (this.bVi.agv() != null) {
            this.bVi.agv().agy();
        }
    }
}
