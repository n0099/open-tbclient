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
    final /* synthetic */ k dEJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar) {
        this.dEJ = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        h hVar2;
        h hVar3;
        if (i >= 0) {
            hVar = this.dEJ.dEA;
            if (hVar != null) {
                hVar2 = this.dEJ.dEA;
                if (i < hVar2.getCount()) {
                    hVar3 = this.dEJ.dEA;
                    PersonPostModel.PostInfoList mz = hVar3.mz(i);
                    if (mz != null) {
                        if (mz.thread_type == 33) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.dEJ.getActivity(), String.valueOf(mz.thread_id)).ch(String.valueOf(mz.post_id)).bo(18005).oq()));
                            return;
                        }
                        this.dEJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.dEJ.getActivity()).createCfgForPersonCenter(String.valueOf(mz.thread_id), String.valueOf(mz.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
