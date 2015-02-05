package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.tbadkCore.bubble.BubbleListData;
import com.baidu.tieba.tbadkCore.bubble.SetBubbleResultData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.tbadkCore.bubble.l {
    final /* synthetic */ b bVi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.bVi = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.l
    public void a(SetBubbleResultData setBubbleResultData) {
        String str;
        com.baidu.tieba.tbadkCore.bubble.h hVar;
        Context context;
        BubbleListData bubbleListData;
        BubbleListData bubbleListData2;
        BubbleListData bubbleListData3;
        BubbleListData bubbleListData4;
        BubbleListData bubbleListData5;
        BubbleListData bubbleListData6;
        int i;
        BubbleListData bubbleListData7;
        BubbleListData bubbleListData8;
        BubbleListData bubbleListData9;
        BubbleListData bubbleListData10;
        BubbleListData bubbleListData11;
        if (setBubbleResultData == null || setBubbleResultData.getB_info() == null) {
            this.bVi.agv().agy();
            return;
        }
        this.bVi.bVa = setBubbleResultData.getB_info().getB_url();
        TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
        str = this.bVi.bVa;
        m255getInst.setDefaultBubble(str);
        hVar = this.bVi.bUX;
        int agO = hVar.agO();
        if (agO == 0) {
            TbadkCoreApplication.m255getInst().setDefaultBubble("");
            bubbleListData11 = this.bVi.bUY;
            for (BubbleListData.BubbleData bubbleData : bubbleListData11.getB_info()) {
                if (bubbleData.getBcode() != 0) {
                    if (bubbleData.isDef()) {
                        bubbleData.setIs_def(0);
                    }
                } else {
                    bubbleData.setIs_def(1);
                }
            }
        } else if (setBubbleResultData.getB_info().canUser()) {
            bubbleListData10 = this.bVi.bUY;
            for (BubbleListData.BubbleData bubbleData2 : bubbleListData10.getB_info()) {
                if (bubbleData2.getBcode() == agO) {
                    bubbleData2.setIs_def(1);
                } else if (bubbleData2.isDef()) {
                    bubbleData2.setIs_def(0);
                }
                if (bubbleData2.getBcode() == agO) {
                    bubbleData2.setCan_use(1);
                }
            }
        } else {
            context = this.bVi.mContext;
            UtilHelper.showToast(context, com.baidu.tieba.z.bubble_setdefualt_error);
            bubbleListData = this.bVi.bUY;
            if (bubbleListData != null) {
                bubbleListData2 = this.bVi.bUY;
                if (bubbleListData2.getB_info() != null) {
                    bubbleListData3 = this.bVi.bUY;
                    if (bubbleListData3.getB_info().size() > 0) {
                        bubbleListData4 = this.bVi.bUY;
                        if (bubbleListData4.getB_info().get(0).getBcode() == 0) {
                            this.bVi.bUZ = 0;
                            int i2 = 0;
                            while (true) {
                                bubbleListData5 = this.bVi.bUY;
                                if (i2 >= bubbleListData5.getB_info().size()) {
                                    break;
                                }
                                bubbleListData8 = this.bVi.bUY;
                                if (bubbleListData8.getB_info().get(i2).isDef()) {
                                    this.bVi.bUZ = i2;
                                    break;
                                }
                                i2++;
                            }
                            bubbleListData6 = this.bVi.bUY;
                            List<BubbleListData.BubbleData> b_info = bubbleListData6.getB_info();
                            i = this.bVi.bUZ;
                            b_info.get(i).setIs_def(0);
                            bubbleListData7 = this.bVi.bUY;
                            bubbleListData7.getB_info().get(0).setIs_def(1);
                        } else {
                            BubbleListData.BubbleData bubbleData3 = new BubbleListData.BubbleData();
                            bubbleData3.setBcode(0);
                            bubbleListData9 = this.bVi.bUY;
                            bubbleListData9.getB_info().add(0, bubbleData3);
                        }
                    }
                }
            }
        }
        this.bVi.afk();
        this.bVi.agv().b(this.bVi);
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.l
    public void b(SetBubbleResultData setBubbleResultData) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        if (setBubbleResultData == null) {
            context = this.bVi.mContext;
            UtilHelper.showToast(context, com.baidu.tieba.z.neterror);
        } else if (setBubbleResultData.getError_code().equals("0")) {
            context2 = this.bVi.mContext;
            UtilHelper.showToast(context2, com.baidu.tieba.z.neterror);
        } else if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
            context4 = this.bVi.mContext;
            UtilHelper.showToast(context4, setBubbleResultData.getError_msg());
        } else {
            context3 = this.bVi.mContext;
            UtilHelper.showToast(context3, com.baidu.tieba.z.neterror);
        }
        if (this.bVi.agv() != null) {
            this.bVi.agv().agy();
        }
    }
}
