package com.baidu.tieba.write.selectpoi;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SearchLocationActivityConfig;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ SelectLocationActivity czY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SelectLocationActivity selectLocationActivity) {
        this.czY = selectLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002012, new SearchLocationActivityConfig(this.czY.getPageContext().getPageActivity(), 23009)));
    }
}
