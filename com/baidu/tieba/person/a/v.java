package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ u dxY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.dxY = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        int id = view.getId();
        if (id == t.g.live_thread_item) {
            TiebaStatic.log(new aw("c10591"));
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.dxY.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyLiveActivityConfig(context2)));
        } else if (id == t.g.live_mission_item && (view.getTag() instanceof com.baidu.tieba.person.data.m)) {
            TiebaStatic.log("c10784");
            com.baidu.tieba.person.data.m mVar = (com.baidu.tieba.person.data.m) view.getTag();
            if (mVar.getUser() != null && mVar.aCm() != null && mVar.aCm().pw() != null) {
                context = this.dxY.mContext;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissonDetailsActivityConfig(context, 24004, mVar.aCm().pw().anchor_level.intValue(), mVar.getUser().portrait, mVar.getUser().name_show, MissonDetailsActivityConfig.FROM_PERSON)));
            }
        }
    }
}
