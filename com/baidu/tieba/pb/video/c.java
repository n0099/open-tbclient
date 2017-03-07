package com.baidu.tieba.pb.video;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b ewF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ewF = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bq bqVar;
        bq bqVar2;
        ImageView imageView;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        if (view != null) {
            if (view != this.ewF.ewB && view != this.ewF.ewC) {
                imageView = this.ewF.amg;
                if (view != imageView) {
                    if (view == this.ewF.ewD) {
                        if (com.baidu.adp.lib.util.k.hv()) {
                            bqVar3 = this.ewF.ewE;
                            if (bqVar3 != null) {
                                bqVar4 = this.ewF.ewE;
                                if (bqVar4.channelId > 0) {
                                    if (TbadkCoreApplication.isLogin()) {
                                        bqVar5 = this.ewF.ewE;
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0032a.a(bqVar5.channelId, this.ewF.bcF.getUniqueId())));
                                        return;
                                    }
                                    bg.aH(this.ewF.bcF.getActivity());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        this.ewF.bcF.showToast(w.l.no_network_guide);
                        return;
                    }
                    return;
                }
            }
            bqVar = this.ewF.ewE;
            if (bqVar != null) {
                Activity activity = this.ewF.bcF.getActivity();
                bqVar2 = this.ewF.ewE;
                this.ewF.bcF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(activity, bqVar2.channelId, 2)));
            }
            TiebaStatic.log(new as("c11923").s("obj_id", 1));
        }
    }
}
