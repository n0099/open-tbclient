package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes2.dex */
class h implements a.b {
    private final /* synthetic */ com.baidu.tieba.im.widget.b deQ;
    final /* synthetic */ SelectFriendActivity dlo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SelectFriendActivity selectFriendActivity, com.baidu.tieba.im.widget.b bVar) {
        this.dlo = selectFriendActivity;
        this.deQ = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ((InputMethodManager) this.dlo.getPageContext().getPageActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.deQ.getWindowToken(), 2);
        aVar.dismiss();
    }
}
