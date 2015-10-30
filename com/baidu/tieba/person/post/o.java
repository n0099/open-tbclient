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
    final /* synthetic */ j crQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.crQ = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        g gVar3;
        if (i >= 0) {
            gVar = this.crQ.crH;
            if (gVar != null) {
                gVar2 = this.crQ.crH;
                if (i < gVar2.getCount()) {
                    gVar3 = this.crQ.crH;
                    PersonPostModel.PostInfoList jj = gVar3.jj(i);
                    if (jj != null) {
                        if (jj.thread_type == 33) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.crQ.getActivity(), String.valueOf(jj.thread_id)).cg(String.valueOf(jj.post_id)).bs(18005).rh()));
                            return;
                        }
                        this.crQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.crQ.getActivity()).createCfgForPersonCenter(String.valueOf(jj.thread_id), String.valueOf(jj.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
