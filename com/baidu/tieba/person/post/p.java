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
    final /* synthetic */ k enD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar) {
        this.enD = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        h hVar2;
        h hVar3;
        if (i >= 0) {
            hVar = this.enD.enu;
            if (hVar != null) {
                hVar2 = this.enD.enu;
                if (i < hVar2.getCount()) {
                    hVar3 = this.enD.enu;
                    PersonPostModel.PostInfoList ob = hVar3.ob(i);
                    if (ob != null) {
                        if (ob.thread_type == 33) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.enD.getActivity(), String.valueOf(ob.thread_id)).cg(String.valueOf(ob.post_id)).bp(18005).ol()));
                            return;
                        }
                        this.enD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.enD.getActivity()).createCfgForPersonCenter(String.valueOf(ob.thread_id), String.valueOf(ob.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
