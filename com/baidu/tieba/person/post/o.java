package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ j bJs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.bJs = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        f fVar;
        f fVar2;
        f fVar3;
        if (i >= 0) {
            fVar = this.bJs.bJk;
            if (fVar != null) {
                fVar2 = this.bJs.bJk;
                if (i < fVar2.getCount()) {
                    fVar3 = this.bJs.bJk;
                    PersonPostModel.PostList hs = fVar3.hs(i);
                    if (hs != null) {
                        this.bJs.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bJs.getActivity()).createCfgForPersonCenter(String.valueOf(hs.thread_id), String.valueOf(hs.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
