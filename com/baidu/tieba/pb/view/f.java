package com.baidu.tieba.pb.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ PbGiftListView eLr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbGiftListView pbGiftListView) {
        this.eLr = pbGiftListView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String str;
        long j;
        String str2;
        long j2;
        long j3;
        context = this.eLr.mContext;
        TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.k.Z(context);
        if (tbPageContext != null) {
            if (TbadkCoreApplication.isLogin()) {
                str = this.eLr.toUserName;
                if (!StringUtils.isNull(str)) {
                    Activity pageActivity = tbPageContext.getPageActivity();
                    j = this.eLr.toUserId;
                    str2 = this.eLr.toUserName;
                    j2 = this.eLr.threadId;
                    j3 = this.eLr.postId;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(pageActivity, j, str2, GiftTabActivityConfig.FROM_PB, j2, j3)));
                    return;
                }
                return;
            }
            bl.aN(tbPageContext.getPageActivity());
        }
    }
}
