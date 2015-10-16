package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class y implements AdapterView.OnItemClickListener {
    final /* synthetic */ u csi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.csi = uVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        p pVar;
        p pVar2;
        p pVar3;
        if (i >= 0) {
            pVar = this.csi.csf;
            if (pVar != null) {
                pVar2 = this.csi.csf;
                if (i < pVar2.getCount()) {
                    pVar3 = this.csi.csf;
                    PersonPostModel.PostInfoList item = pVar3.getItem(i);
                    if (item != null) {
                        if (item.thread_type == 33) {
                            TiebaStatic.log("c10254");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.csi.getActivity(), String.valueOf(item.thread_id)).cg(String.valueOf(item.post_id)).bs(18005).rk()));
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.csi.getActivity()).createCfgForPersonCenter(String.valueOf(item.thread_id), String.valueOf(item.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
