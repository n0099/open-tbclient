package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.data.MyLikeForum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ l eqg;
    private final /* synthetic */ MyLikeForum eqh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, MyLikeForum myLikeForum) {
        this.eqg = lVar;
        this.eqh = myLikeForum;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        boolean z;
        String str;
        String str2;
        Context context2;
        Context context3;
        context = this.eqg.mContext;
        if (bn.ab(context)) {
            String forumName = this.eqh.getForumName();
            String.valueOf(this.eqh.getForumId());
            if (ba.aM(forumName)) {
                z = this.eqg.isSelf;
                if (!z) {
                    str = this.eqg.userId;
                    if (str != null) {
                        ay s = new ay("c10619").s("obj_type", 2);
                        str2 = this.eqg.userId;
                        TiebaStatic.log(s.ab("obj_id", str2));
                    }
                } else {
                    TiebaStatic.log(new ay("c10593").s("obj_type", 2));
                }
                MessageManager messageManager = MessageManager.getInstance();
                context2 = this.eqg.mContext;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context2).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                if (!TbadkCoreApplication.isLogin()) {
                    context3 = this.eqg.mContext;
                    TiebaStatic.eventStat(context3.getApplicationContext(), "notlogin_5", "click", 1, new Object[0]);
                }
            }
        }
    }
}
