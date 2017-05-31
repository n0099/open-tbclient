package com.baidu.tieba.pb.video;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e ezY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.ezY = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bs bsVar5;
        if (view != null) {
            if (view == this.ezY.ezP || view == this.ezY.ezQ || view == this.ezY.ezR) {
                bsVar = this.ezY.baU;
                if (bsVar != null) {
                    Activity activity = this.ezY.bfa.getActivity();
                    bsVar2 = this.ezY.baU;
                    this.ezY.bfa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(activity, bsVar2.channelId, 2)));
                }
                TiebaStatic.log(new as("c11923").r("obj_id", 1));
            } else if (view == this.ezY.ezW) {
                if (com.baidu.adp.lib.util.k.hB()) {
                    bsVar3 = this.ezY.baU;
                    if (bsVar3 != null) {
                        bsVar4 = this.ezY.baU;
                        if (bsVar4.channelId > 0) {
                            if (TbadkCoreApplication.isLogin()) {
                                bsVar5 = this.ezY.baU;
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0036a.a(bsVar5.channelId, this.ezY.bfa.getUniqueId())));
                                return;
                            }
                            bh.aM(this.ezY.bfa.getActivity());
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.ezY.bfa.showToast(w.l.no_network_guide);
            }
        }
    }
}
