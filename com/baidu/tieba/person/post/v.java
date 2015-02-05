package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class v implements AdapterView.OnItemClickListener {
    final /* synthetic */ s bJB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.bJB = sVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        p pVar;
        p pVar2;
        p pVar3;
        if (i >= 0) {
            pVar = this.bJB.bJy;
            if (pVar != null) {
                pVar2 = this.bJB.bJy;
                if (i < pVar2.getCount()) {
                    pVar3 = this.bJB.bJy;
                    PersonPostModel.PostList postList = (PersonPostModel.PostList) pVar3.getItem(i);
                    if (postList != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bJB.getActivity()).createCfgForPersonCenter(String.valueOf(postList.thread_id), String.valueOf(postList.post_id), "person_post", 18005)));
                    }
                }
            }
        }
    }
}
