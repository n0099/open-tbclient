package com.baidu.tieba.pb.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.EcommProductDetailActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ PbReplyEcommCard eAc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbReplyEcommCard pbReplyEcommCard) {
        this.eAc = pbReplyEcommCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DealInfoData dealInfoData;
        DealInfoData dealInfoData2;
        String str;
        DealInfoData dealInfoData3;
        if (bm.ak(this.eAc.getContext())) {
            dealInfoData = this.eAc.eAb;
            if (dealInfoData != null) {
                MessageManager messageManager = MessageManager.getInstance();
                Context context = this.eAc.getContext();
                dealInfoData2 = this.eAc.eAb;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EcommProductDetailActivityConfig(context, dealInfoData2.productId, false)));
                ax axVar = new ax("c11425");
                str = this.eAc.TB;
                ax ab = axVar.ab("tid", str);
                dealInfoData3 = this.eAc.eAb;
                TiebaStatic.log(ab.g("obj_id", dealInfoData3.productId));
            }
        }
    }
}
