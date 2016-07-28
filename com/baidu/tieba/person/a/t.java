package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s eqt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.eqt = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        int id = view.getId();
        if (id == u.g.live_thread_item) {
            TiebaStatic.log(new ay("c10591"));
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.eqt.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyLiveActivityConfig(context2)));
        } else if (id == u.g.live_mission_item && (view.getTag() instanceof com.baidu.tieba.person.data.l)) {
            TiebaStatic.log("c10784");
            com.baidu.tieba.person.data.l lVar = (com.baidu.tieba.person.data.l) view.getTag();
            if (lVar.getUser() != null && lVar.aNL() != null && lVar.aNL().oY() != null) {
                context = this.eqt.mContext;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissonDetailsActivityConfig(context, 24004, lVar.aNL().oY().anchor_level.intValue(), lVar.getUser().portrait, lVar.getUser().name_show, MissonDetailsActivityConfig.FROM_PERSON)));
            }
        }
    }
}
