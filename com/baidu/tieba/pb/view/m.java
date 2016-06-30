package com.baidu.tieba.pb.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.adp.base.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ PbGiftListView dYR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbGiftListView pbGiftListView) {
        this.dYR = pbGiftListView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String str;
        long j;
        String str2;
        long j2;
        long j3;
        context = this.dYR.mContext;
        TbPageContext tbPageContext = (TbPageContext) l.s(context);
        if (tbPageContext != null) {
            if (TbadkCoreApplication.isLogin()) {
                str = this.dYR.toUserName;
                if (!StringUtils.isNull(str)) {
                    Activity pageActivity = tbPageContext.getPageActivity();
                    j = this.dYR.toUserId;
                    str2 = this.dYR.toUserName;
                    j2 = this.dYR.threadId;
                    j3 = this.dYR.postId;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(pageActivity, j, str2, GiftTabActivityConfig.FROM_PB, j2, j3)));
                    return;
                }
                return;
            }
            bn.ab(tbPageContext.getPageActivity());
        }
    }
}
