package com.baidu.tieba.pb.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.EcommProductDetailActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ PbReplyEcommCard eGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbReplyEcommCard pbReplyEcommCard) {
        this.eGL = pbReplyEcommCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DealInfoData dealInfoData;
        DealInfoData dealInfoData2;
        String str;
        DealInfoData dealInfoData3;
        if (bk.ak(this.eGL.getContext())) {
            dealInfoData = this.eGL.eGK;
            if (dealInfoData != null) {
                MessageManager messageManager = MessageManager.getInstance();
                Context context = this.eGL.getContext();
                dealInfoData2 = this.eGL.eGK;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EcommProductDetailActivityConfig(context, dealInfoData2.productId, false)));
                av avVar = new av("c11425");
                str = this.eGL.TY;
                av ab = avVar.ab("tid", str);
                dealInfoData3 = this.eGL.eGK;
                TiebaStatic.log(ab.g("obj_id", dealInfoData3.productId));
            }
        }
    }
}
