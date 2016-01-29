package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class g implements a.b {
    private final /* synthetic */ com.baidu.tieba.im.widget.b cdC;
    final /* synthetic */ SelectFriendActivity clY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SelectFriendActivity selectFriendActivity, com.baidu.tieba.im.widget.b bVar) {
        this.clY = selectFriendActivity;
        this.cdC = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.clY.getSystemService("input_method")).hideSoftInputFromWindow(this.cdC.getWindowToken(), 2);
    }
}
