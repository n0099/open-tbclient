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
    final /* synthetic */ j cmb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.cmb = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        g gVar3;
        if (i >= 0) {
            gVar = this.cmb.clS;
            if (gVar != null) {
                gVar2 = this.cmb.clS;
                if (i < gVar2.getCount()) {
                    gVar3 = this.cmb.clS;
                    PersonPostModel.PostInfoList iZ = gVar3.iZ(i);
                    if (iZ != null) {
                        if (iZ.thread_type == 33) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.cmb.getActivity(), String.valueOf(iZ.thread_id)).cf(String.valueOf(iZ.post_id)).bs(18005).ro()));
                            return;
                        }
                        this.cmb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.cmb.getActivity()).createCfgForPersonCenter(String.valueOf(iZ.thread_id), String.valueOf(iZ.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
