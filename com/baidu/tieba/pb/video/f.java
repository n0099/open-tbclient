package com.baidu.tieba.pb.video;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e eJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.eJw = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        bt btVar4;
        bt btVar5;
        if (view != null) {
            if (view == this.eJw.eJn || view == this.eJw.eJo || view == this.eJw.eJp) {
                btVar = this.eJw.bcX;
                if (btVar != null) {
                    Activity activity = this.eJw.bhX.getActivity();
                    btVar2 = this.eJw.bcX;
                    this.eJw.bhX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(activity, btVar2.channelId, 2)));
                }
                TiebaStatic.log(new au("c11923").r("obj_id", 1));
            } else if (view == this.eJw.eJu) {
                if (com.baidu.adp.lib.util.k.hA()) {
                    btVar3 = this.eJw.bcX;
                    if (btVar3 != null) {
                        btVar4 = this.eJw.bcX;
                        if (btVar4.channelId > 0) {
                            if (TbadkCoreApplication.isLogin()) {
                                btVar5 = this.eJw.bcX;
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0038a.a(btVar5.channelId, this.eJw.bhX.getUniqueId())));
                                return;
                            }
                            bl.aM(this.eJw.bhX.getActivity());
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.eJw.bhX.showToast(w.l.no_network_guide);
            }
        }
    }
}
