package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class aa implements AdapterView.OnItemClickListener {
    final /* synthetic */ v dBQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(v vVar) {
        this.dBQ = vVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        q qVar;
        q qVar2;
        q qVar3;
        if (i >= 0) {
            qVar = this.dBQ.dBN;
            if (qVar != null) {
                qVar2 = this.dBQ.dBN;
                if (i < qVar2.getCount()) {
                    qVar3 = this.dBQ.dBN;
                    PersonPostModel.PostInfoList item = qVar3.getItem(i);
                    if (item != null) {
                        if (item.thread_type == 33) {
                            TiebaStatic.log("c10254");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.dBQ.getActivity(), String.valueOf(item.thread_id)).cj(String.valueOf(item.post_id)).bC(18005).qT()));
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.dBQ.getActivity()).createCfgForPersonCenter(String.valueOf(item.thread_id), String.valueOf(item.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
