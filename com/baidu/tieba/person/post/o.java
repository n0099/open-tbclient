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
    final /* synthetic */ j crF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.crF = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        g gVar3;
        if (i >= 0) {
            gVar = this.crF.crw;
            if (gVar != null) {
                gVar2 = this.crF.crw;
                if (i < gVar2.getCount()) {
                    gVar3 = this.crF.crw;
                    PersonPostModel.PostInfoList jj = gVar3.jj(i);
                    if (jj != null) {
                        if (jj.thread_type == 33) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.crF.getActivity(), String.valueOf(jj.thread_id)).cf(String.valueOf(jj.post_id)).bs(18005).rk()));
                            return;
                        }
                        this.crF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.crF.getActivity()).createCfgForPersonCenter(String.valueOf(jj.thread_id), String.valueOf(jj.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
