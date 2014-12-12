package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ k bHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar) {
        this.bHG = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        g gVar3;
        if (i >= 0) {
            gVar = this.bHG.bHy;
            if (gVar != null) {
                gVar2 = this.bHG.bHy;
                if (i < gVar2.getCount()) {
                    gVar3 = this.bHG.bHy;
                    PersonPostModel.PostList hj = gVar3.hj(i);
                    if (hj != null) {
                        this.bHG.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bHG.getActivity()).createCfgForPersonCenter(String.valueOf(hj.thread_id), String.valueOf(hj.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
