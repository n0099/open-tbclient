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
public class m implements View.OnClickListener {
    final /* synthetic */ j dxJ;
    private final /* synthetic */ MyLikeForum dxK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, MyLikeForum myLikeForum) {
        this.dxJ = jVar;
        this.dxK = myLikeForum;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        boolean z;
        String str;
        String str2;
        Context context2;
        Context context3;
        context = this.dxJ.mContext;
        if (bl.ac(context)) {
            String forumName = this.dxK.getForumName();
            String.valueOf(this.dxK.getForumId());
            if (ay.aL(forumName)) {
                z = this.dxJ.isSelf;
                if (!z) {
                    str = this.dxJ.userId;
                    if (str != null) {
                        aw s = new aw("c10619").s("obj_type", 2);
                        str2 = this.dxJ.userId;
                        TiebaStatic.log(s.ac("obj_id", str2));
                    }
                } else {
                    TiebaStatic.log(new aw("c10593").s("obj_type", 2));
                }
                MessageManager messageManager = MessageManager.getInstance();
                context2 = this.dxJ.mContext;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context2).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                if (!TbadkCoreApplication.isLogin()) {
                    context3 = this.dxJ.mContext;
                    TiebaStatic.eventStat(context3.getApplicationContext(), "notlogin_5", "click", 1, new Object[0]);
                }
            }
        }
    }
}
