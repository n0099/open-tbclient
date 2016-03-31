package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.data.MyLikeForum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ i duN;
    private final /* synthetic */ MyLikeForum duO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, MyLikeForum myLikeForum) {
        this.duN = iVar;
        this.duO = myLikeForum;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        boolean z;
        String str;
        String str2;
        Context context2;
        Context context3;
        context = this.duN.mContext;
        if (bl.ad(context)) {
            String forumName = this.duO.getForumName();
            String.valueOf(this.duO.getForumId());
            if (ay.aS(forumName)) {
                z = this.duN.isSelf;
                if (!z) {
                    str = this.duN.userId;
                    if (str != null) {
                        aw r = new aw("c10619").r("obj_type", 2);
                        str2 = this.duN.userId;
                        TiebaStatic.log(r.ac("obj_id", str2));
                    }
                } else {
                    TiebaStatic.log(new aw("c10593").r("obj_type", 2));
                }
                MessageManager messageManager = MessageManager.getInstance();
                context2 = this.duN.mContext;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context2).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                if (!TbadkCoreApplication.isLogin()) {
                    context3 = this.duN.mContext;
                    TiebaStatic.eventStat(context3.getApplicationContext(), "notlogin_5", "click", 1, new Object[0]);
                }
            }
        }
    }
}
