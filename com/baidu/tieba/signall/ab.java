package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001260));
    }
}
