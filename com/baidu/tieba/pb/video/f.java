package com.baidu.tieba.pb.video;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e esK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.esK = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        br brVar;
        br brVar2;
        ImageView imageView;
        br brVar3;
        br brVar4;
        br brVar5;
        if (view != null) {
            if (view != this.esK.esG && view != this.esK.esH) {
                imageView = this.esK.amD;
                if (view != imageView) {
                    if (view == this.esK.esI) {
                        if (com.baidu.adp.lib.util.k.hB()) {
                            brVar3 = this.esK.esJ;
                            if (brVar3 != null) {
                                brVar4 = this.esK.esJ;
                                if (brVar4.channelId > 0) {
                                    if (TbadkCoreApplication.isLogin()) {
                                        brVar5 = this.esK.esJ;
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0036a.a(brVar5.channelId, this.esK.bdY.getUniqueId())));
                                        return;
                                    }
                                    bg.aM(this.esK.bdY.getActivity());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        this.esK.bdY.showToast(w.l.no_network_guide);
                        return;
                    }
                    return;
                }
            }
            brVar = this.esK.esJ;
            if (brVar != null) {
                Activity activity = this.esK.bdY.getActivity();
                brVar2 = this.esK.esJ;
                this.esK.bdY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(activity, brVar2.channelId, 2)));
            }
            TiebaStatic.log(new as("c11923").s("obj_id", 1));
        }
    }
}
