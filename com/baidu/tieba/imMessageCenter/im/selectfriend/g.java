package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes2.dex */
class g implements a.b {
    private final /* synthetic */ com.baidu.tieba.im.widget.b cZq;
    final /* synthetic */ SelectFriendActivity dfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SelectFriendActivity selectFriendActivity, com.baidu.tieba.im.widget.b bVar) {
        this.dfT = selectFriendActivity;
        this.cZq = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.dfT.getSystemService("input_method")).hideSoftInputFromWindow(this.cZq.getWindowToken(), 2);
    }
}
