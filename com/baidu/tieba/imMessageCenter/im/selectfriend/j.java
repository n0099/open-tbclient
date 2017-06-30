package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes2.dex */
class j implements a.b {
    private final /* synthetic */ com.baidu.tieba.im.widget.b dmL;
    final /* synthetic */ SelectFriendActivity dtk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SelectFriendActivity selectFriendActivity, com.baidu.tieba.im.widget.b bVar) {
        this.dtk = selectFriendActivity;
        this.dmL = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.dtk.getSystemService("input_method")).hideSoftInputFromWindow(this.dmL.getWindowToken(), 2);
    }
}
