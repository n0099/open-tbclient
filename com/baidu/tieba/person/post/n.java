package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ i clg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.clg = iVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        f fVar;
        f fVar2;
        f fVar3;
        if (i >= 0) {
            fVar = this.clg.ckX;
            if (fVar != null) {
                fVar2 = this.clg.ckX;
                if (i < fVar2.getCount()) {
                    fVar3 = this.clg.ckX;
                    PersonPostModel.PostInfoList iN = fVar3.iN(i);
                    if (iN != null) {
                        this.clg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.clg.getActivity()).createCfgForPersonCenter(String.valueOf(iN.thread_id), String.valueOf(iN.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
