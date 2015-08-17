package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class s implements AdapterView.OnItemClickListener {
    final /* synthetic */ p clq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.clq = pVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        o oVar;
        o oVar2;
        o oVar3;
        if (i >= 0) {
            oVar = this.clq.cln;
            if (oVar != null) {
                oVar2 = this.clq.cln;
                if (i < oVar2.getCount()) {
                    oVar3 = this.clq.cln;
                    PersonPostModel.PostInfoList postInfoList = (PersonPostModel.PostInfoList) oVar3.getItem(i);
                    if (postInfoList != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.clq.getActivity()).createCfgForPersonCenter(String.valueOf(postInfoList.thread_id), String.valueOf(postInfoList.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
