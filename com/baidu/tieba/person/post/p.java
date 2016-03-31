package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ k dBB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar) {
        this.dBB = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        h hVar2;
        h hVar3;
        if (i >= 0) {
            hVar = this.dBB.dBs;
            if (hVar != null) {
                hVar2 = this.dBB.dBs;
                if (i < hVar2.getCount()) {
                    hVar3 = this.dBB.dBs;
                    PersonPostModel.PostInfoList mJ = hVar3.mJ(i);
                    if (mJ != null) {
                        if (mJ.thread_type == 33) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.dBB.getActivity(), String.valueOf(mJ.thread_id)).cj(String.valueOf(mJ.post_id)).bC(18005).qT()));
                            return;
                        }
                        this.dBB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.dBB.getActivity()).createCfgForPersonCenter(String.valueOf(mJ.thread_id), String.valueOf(mJ.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
