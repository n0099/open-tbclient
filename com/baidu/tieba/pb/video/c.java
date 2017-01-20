package com.baidu.tieba.pb.video;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ets = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        bo boVar4;
        bo boVar5;
        if (view != null) {
            if (view == this.ets.eto || view == this.ets.etp) {
                boVar = this.ets.etr;
                if (boVar != null) {
                    Activity activity = this.ets.aWr.getActivity();
                    boVar2 = this.ets.etr;
                    this.ets.aWr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(activity, boVar2.channelId, 2)));
                }
                TiebaStatic.log(new ar("c11923").s("obj_id", 1));
            } else if (view == this.ets.etq) {
                if (com.baidu.adp.lib.util.k.gB()) {
                    boVar3 = this.ets.etr;
                    if (boVar3 != null) {
                        boVar4 = this.ets.etr;
                        if (boVar4.channelId > 0) {
                            if (TbadkCoreApplication.isLogin()) {
                                boVar5 = this.ets.etr;
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0033a.a(boVar5.channelId, this.ets.aWr.getUniqueId())));
                                return;
                            }
                            bf.aj(this.ets.aWr.getActivity());
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.ets.aWr.showToast(r.l.no_network_guide);
            }
        }
    }
}
