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
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ j cVA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.cVA = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        g gVar3;
        if (i >= 0) {
            gVar = this.cVA.cVr;
            if (gVar != null) {
                gVar2 = this.cVA.cVr;
                if (i < gVar2.getCount()) {
                    gVar3 = this.cVA.cVr;
                    PersonPostModel.PostInfoList kR = gVar3.kR(i);
                    if (kR != null) {
                        if (kR.thread_type == 33) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.cVA.getActivity(), String.valueOf(kR.thread_id)).cn(String.valueOf(kR.post_id)).bo(18005).rf()));
                            return;
                        }
                        this.cVA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.cVA.getActivity()).createCfgForPersonCenter(String.valueOf(kR.thread_id), String.valueOf(kR.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
