package com.baidu.tieba.mention;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        imageView = this.a.i;
        if (view == imageView && TbadkApplication.isLogin()) {
            baseFragmentActivity = this.a.m;
            TiebaStatic.eventStat(baseFragmentActivity, "msg_newchat_tab_c", "click", 1, new Object[0]);
            TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            MessageManager messageManager = MessageManager.getInstance();
            baseFragmentActivity2 = this.a.m;
            messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.d(baseFragmentActivity2, 12011, false)));
        }
    }
}
