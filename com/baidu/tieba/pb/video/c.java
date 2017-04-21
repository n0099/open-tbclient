package com.baidu.tieba.pb.video;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b exa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.exa = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bp bpVar;
        bp bpVar2;
        ImageView imageView;
        bp bpVar3;
        bp bpVar4;
        bp bpVar5;
        if (view != null) {
            if (view != this.exa.ewW && view != this.exa.ewX) {
                imageView = this.exa.amu;
                if (view != imageView) {
                    if (view == this.exa.ewY) {
                        if (com.baidu.adp.lib.util.k.hB()) {
                            bpVar3 = this.exa.ewZ;
                            if (bpVar3 != null) {
                                bpVar4 = this.exa.ewZ;
                                if (bpVar4.channelId > 0) {
                                    if (TbadkCoreApplication.isLogin()) {
                                        bpVar5 = this.exa.ewZ;
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0031a.a(bpVar5.channelId, this.exa.bdG.getUniqueId())));
                                        return;
                                    }
                                    bg.aJ(this.exa.bdG.getActivity());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        this.exa.bdG.showToast(w.l.no_network_guide);
                        return;
                    }
                    return;
                }
            }
            bpVar = this.exa.ewZ;
            if (bpVar != null) {
                Activity activity = this.exa.bdG.getActivity();
                bpVar2 = this.exa.ewZ;
                this.exa.bdG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(activity, bpVar2.channelId, 2)));
            }
            TiebaStatic.log(new as("c11923").s("obj_id", 1));
        }
    }
}
