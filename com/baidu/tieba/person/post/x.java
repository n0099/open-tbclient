package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.person.post.PersonPostModel;
/* loaded from: classes.dex */
class x implements AdapterView.OnItemClickListener {
    final /* synthetic */ u bEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.bEs = uVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        r rVar;
        r rVar2;
        r rVar3;
        if (i >= 0) {
            rVar = this.bEs.bEp;
            if (rVar != null) {
                rVar2 = this.bEs.bEp;
                if (i < rVar2.getCount()) {
                    rVar3 = this.bEs.bEp;
                    PersonPostModel.PostList postList = (PersonPostModel.PostList) rVar3.getItem(i);
                    if (postList != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bEs.getActivity()).createCfgForPersonCenter(String.valueOf(postList.thread_id), String.valueOf(postList.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
