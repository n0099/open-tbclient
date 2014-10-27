package com.baidu.tieba.mention;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ r bnF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.bnF = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        imageView = this.bnF.ajm;
        if (view == imageView && TbadkApplication.isLogin()) {
            baseFragmentActivity = this.bnF.axV;
            TiebaStatic.eventStat(baseFragmentActivity, "msg_newchat_tab_c", "click", 1, new Object[0]);
            TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            MessageManager messageManager = MessageManager.getInstance();
            baseFragmentActivity2 = this.bnF.axV;
            messageManager.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(baseFragmentActivity2, 12011, false)));
        }
    }
}
