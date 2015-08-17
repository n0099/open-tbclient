package com.baidu.tieba.write.selectpoi;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SearchLocationActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ SelectLocationActivity cRN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SelectLocationActivity selectLocationActivity) {
        this.cRN = selectLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SEARCH_LOCATION_PAGE, new SearchLocationActivityConfig(this.cRN.getPageContext().getPageActivity(), 23009)));
    }
}
