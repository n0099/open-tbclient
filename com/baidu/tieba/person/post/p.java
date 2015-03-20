package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ k bRB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar) {
        this.bRB = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        g gVar3;
        if (i >= 0) {
            gVar = this.bRB.bRt;
            if (gVar != null) {
                gVar2 = this.bRB.bRt;
                if (i < gVar2.getCount()) {
                    gVar3 = this.bRB.bRt;
                    PersonPostModel.PostList hB = gVar3.hB(i);
                    if (hB != null) {
                        this.bRB.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bRB.getActivity()).createCfgForPersonCenter(String.valueOf(hB.thread_id), String.valueOf(hB.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
