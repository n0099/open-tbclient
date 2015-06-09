package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class g implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tieba.im.widget.b bol;
    final /* synthetic */ SelectFriendActivity bwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SelectFriendActivity selectFriendActivity, com.baidu.tieba.im.widget.b bVar) {
        this.bwf = selectFriendActivity;
        this.bol = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.bwf.getSystemService("input_method")).hideSoftInputFromWindow(this.bol.getWindowToken(), 2);
    }
}
