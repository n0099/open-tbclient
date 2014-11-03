package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.person.post.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ l bEi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.bEi = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        h hVar2;
        h hVar3;
        if (i >= 0) {
            hVar = this.bEi.bDZ;
            if (hVar != null) {
                hVar2 = this.bEi.bDZ;
                if (i < hVar2.getCount()) {
                    hVar3 = this.bEi.bDZ;
                    PersonPostModel.PostList ha = hVar3.ha(i);
                    if (ha != null) {
                        this.bEi.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bEi.getActivity()).createCfgForPersonCenter(String.valueOf(ha.thread_id), String.valueOf(ha.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
