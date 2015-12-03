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
    final /* synthetic */ j cQY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.cQY = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        g gVar3;
        if (i >= 0) {
            gVar = this.cQY.cQP;
            if (gVar != null) {
                gVar2 = this.cQY.cQP;
                if (i < gVar2.getCount()) {
                    gVar3 = this.cQY.cQP;
                    PersonPostModel.PostInfoList ku = gVar3.ku(i);
                    if (ku != null) {
                        if (ku.thread_type == 33) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.cQY.getActivity(), String.valueOf(ku.thread_id)).cl(String.valueOf(ku.post_id)).bv(18005).rw()));
                            return;
                        }
                        this.cQY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.cQY.getActivity()).createCfgForPersonCenter(String.valueOf(ku.thread_id), String.valueOf(ku.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
