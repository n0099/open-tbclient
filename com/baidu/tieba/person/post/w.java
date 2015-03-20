package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class w implements AdapterView.OnItemClickListener {
    final /* synthetic */ t bRL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bRL = tVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        q qVar;
        q qVar2;
        q qVar3;
        if (i >= 0) {
            qVar = this.bRL.bRI;
            if (qVar != null) {
                qVar2 = this.bRL.bRI;
                if (i < qVar2.getCount()) {
                    qVar3 = this.bRL.bRI;
                    PersonPostModel.PostList postList = (PersonPostModel.PostList) qVar3.getItem(i);
                    if (postList != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bRL.getActivity()).createCfgForPersonCenter(String.valueOf(postList.thread_id), String.valueOf(postList.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
