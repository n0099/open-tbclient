package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class g implements a.b {
    private final /* synthetic */ com.baidu.tieba.im.widget.b dkv;
    final /* synthetic */ SelectFriendActivity dsU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SelectFriendActivity selectFriendActivity, com.baidu.tieba.im.widget.b bVar) {
        this.dsU = selectFriendActivity;
        this.dkv = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        ((InputMethodManager) this.dsU.getSystemService("input_method")).hideSoftInputFromWindow(this.dkv.getWindowToken(), 2);
    }
}
