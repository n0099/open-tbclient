package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class g implements a.b {
    private final /* synthetic */ com.baidu.tieba.im.widget.b bFT;
    final /* synthetic */ SelectFriendActivity bNZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SelectFriendActivity selectFriendActivity, com.baidu.tieba.im.widget.b bVar) {
        this.bNZ = selectFriendActivity;
        this.bFT = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.bNZ.getSystemService("input_method")).hideSoftInputFromWindow(this.bFT.getWindowToken(), 2);
    }
}
