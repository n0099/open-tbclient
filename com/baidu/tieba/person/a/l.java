package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.data.MyLikeForum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ i daj;
    private final /* synthetic */ MyLikeForum dak;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, MyLikeForum myLikeForum) {
        this.daj = iVar;
        this.dak = myLikeForum;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        boolean z;
        String str;
        String str2;
        Context context2;
        Context context3;
        context = this.daj.mContext;
        if (bi.ah(context)) {
            String forumName = this.dak.getForumName();
            String.valueOf(this.dak.getForumId());
            if (aw.aQ(forumName)) {
                z = this.daj.isSelf;
                if (!z) {
                    str = this.daj.userId;
                    if (str != null) {
                        au r = new au("c10619").r("obj_type", 2);
                        str2 = this.daj.userId;
                        TiebaStatic.log(r.aa("obj_id", str2));
                    }
                } else {
                    TiebaStatic.log(new au("c10593").r("obj_type", 2));
                }
                MessageManager messageManager = MessageManager.getInstance();
                context2 = this.daj.mContext;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context2.getApplicationContext()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                if (!TbadkCoreApplication.isLogin()) {
                    context3 = this.daj.mContext;
                    TiebaStatic.eventStat(context3.getApplicationContext(), "notlogin_5", "click", 1, new Object[0]);
                }
            }
        }
    }
}
