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
    final /* synthetic */ k dhb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar) {
        this.dhb = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        h hVar2;
        h hVar3;
        if (i >= 0) {
            hVar = this.dhb.dgS;
            if (hVar != null) {
                hVar2 = this.dhb.dgS;
                if (i < hVar2.getCount()) {
                    hVar3 = this.dhb.dgS;
                    PersonPostModel.PostInfoList lA = hVar3.lA(i);
                    if (lA != null) {
                        if (lA.thread_type == 33) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.dhb.getActivity(), String.valueOf(lA.thread_id)).cm(String.valueOf(lA.post_id)).bD(18005).rC()));
                            return;
                        }
                        this.dhb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.dhb.getActivity()).createCfgForPersonCenter(String.valueOf(lA.thread_id), String.valueOf(lA.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
