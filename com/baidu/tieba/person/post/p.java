package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ k bUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar) {
        this.bUy = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        g gVar3;
        if (i >= 0) {
            gVar = this.bUy.bUq;
            if (gVar != null) {
                gVar2 = this.bUy.bUq;
                if (i < gVar2.getCount()) {
                    gVar3 = this.bUy.bUq;
                    PersonPostModel.PostList hT = gVar3.hT(i);
                    if (hT != null) {
                        this.bUy.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bUy.getActivity()).createCfgForPersonCenter(String.valueOf(hT.thread_id), String.valueOf(hT.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
