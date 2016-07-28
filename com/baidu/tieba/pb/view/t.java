package com.baidu.tieba.pb.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.EcommProductDetailActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ PbReplyEcommCard elP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbReplyEcommCard pbReplyEcommCard) {
        this.elP = pbReplyEcommCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DealInfoData dealInfoData;
        DealInfoData dealInfoData2;
        if (bn.ab(this.elP.getContext())) {
            dealInfoData = this.elP.elO;
            if (dealInfoData != null) {
                MessageManager messageManager = MessageManager.getInstance();
                Context context = this.elP.getContext();
                dealInfoData2 = this.elP.elO;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EcommProductDetailActivityConfig(context, dealInfoData2.productId, false)));
            }
        }
    }
}
