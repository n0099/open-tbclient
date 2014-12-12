package com.baidu.tieba.pb.main;

import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class x implements CustomMessageTask.CustomRunnable<TbPageContext<?>> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<TbPageContext<?>> customMessage) {
        ListAdapter adapter;
        TbPageContext<?> data = customMessage.getData();
        if (data.getOrignalPage() instanceof PbActivity) {
            PbActivity pbActivity = (PbActivity) data.getOrignalPage();
            if (!pbActivity.isFinishing() && (adapter = pbActivity.getListView().getAdapter()) != null && (adapter instanceof BaseAdapter)) {
                ((BaseAdapter) adapter).notifyDataSetChanged();
            }
        }
        return null;
    }
}
