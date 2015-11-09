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
    final /* synthetic */ j ctm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.ctm = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        g gVar3;
        if (i >= 0) {
            gVar = this.ctm.ctd;
            if (gVar != null) {
                gVar2 = this.ctm.ctd;
                if (i < gVar2.getCount()) {
                    gVar3 = this.ctm.ctd;
                    PersonPostModel.PostInfoList jx = gVar3.jx(i);
                    if (jx != null) {
                        if (jx.thread_type == 33) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.ctm.getActivity(), String.valueOf(jx.thread_id)).ce(String.valueOf(jx.post_id)).bs(18005).ri()));
                            return;
                        }
                        this.ctm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ctm.getActivity()).createCfgForPersonCenter(String.valueOf(jx.thread_id), String.valueOf(jx.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
