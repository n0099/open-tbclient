package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ k bRR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar) {
        this.bRR = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        g gVar3;
        if (i >= 0) {
            gVar = this.bRR.bRJ;
            if (gVar != null) {
                gVar2 = this.bRR.bRJ;
                if (i < gVar2.getCount()) {
                    gVar3 = this.bRR.bRJ;
                    PersonPostModel.PostList hE = gVar3.hE(i);
                    if (hE != null) {
                        this.bRR.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bRR.getActivity()).createCfgForPersonCenter(String.valueOf(hE.thread_id), String.valueOf(hE.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
