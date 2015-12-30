package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ h dpQ;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, Context context) {
        this.dpQ = hVar;
        this.val$context = context;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        gVar = this.dpQ.dpP;
        TagInfo item = gVar.getItem(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB, item));
        this.dpQ.aJ(this.val$context);
    }
}
