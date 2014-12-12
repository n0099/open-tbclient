package com.baidu.tieba.selectpoi;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SearchLocationActivityConfig;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ SelectLocationActivity bNf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SelectLocationActivity selectLocationActivity) {
        this.bNf = selectLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002012, new SearchLocationActivityConfig(this.bNf.getPageContext().getPageActivity(), 23009)));
    }
}
