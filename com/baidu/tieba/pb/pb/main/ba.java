package com.baidu.tieba.pb.pb.main;

import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(PbActivity pbActivity, int i) {
        super(i);
        this.cjN = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ListAdapter adapter = this.cjN.getListView().getAdapter();
        if (adapter != null && (adapter instanceof BaseAdapter)) {
            ((BaseAdapter) adapter).notifyDataSetChanged();
        }
    }
}
