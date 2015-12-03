package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.data.MyLikeForum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ i cMn;
    private final /* synthetic */ MyLikeForum cMo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, MyLikeForum myLikeForum) {
        this.cMn = iVar;
        this.cMo = myLikeForum;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        boolean z;
        String str;
        String str2;
        Context context2;
        Context context3;
        context = this.cMn.mContext;
        if (bj.ah(context)) {
            String forumName = this.cMo.getForumName();
            String.valueOf(this.cMo.getForumId());
            if (ax.aR(forumName)) {
                z = this.cMn.isSelf;
                if (!z) {
                    str = this.cMn.userId;
                    if (str != null) {
                        av r = new av("c10619").r("obj_type", 2);
                        str2 = this.cMn.userId;
                        TiebaStatic.log(r.ab("obj_id", str2));
                    }
                } else {
                    TiebaStatic.log(new av("c10593").r("obj_type", 2));
                }
                MessageManager messageManager = MessageManager.getInstance();
                context2 = this.cMn.mContext;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context2.getApplicationContext()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                if (!TbadkCoreApplication.isLogin()) {
                    context3 = this.cMn.mContext;
                    TiebaStatic.eventStat(context3.getApplicationContext(), "notlogin_5", "click", 1, new Object[0]);
                }
            }
        }
    }
}
