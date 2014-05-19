package com.baidu.tieba.mention;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        com.baidu.tbadk.core.e eVar;
        com.baidu.tbadk.core.e eVar2;
        imageView = this.a.i;
        if (view == imageView && TbadkApplication.isLogin()) {
            eVar = this.a.m;
            TiebaStatic.eventStat(eVar, "msg_newchat_tab_c", "click", 1, new Object[0]);
            new az(TbConfig.ST_TYPE_PCHAT, TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT).start();
            MessageManager messageManager = MessageManager.getInstance();
            eVar2 = this.a.m;
            messageManager.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.c(eVar2, 12011, false)));
        }
    }
}
