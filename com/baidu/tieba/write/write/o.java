package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList fcw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.fcw = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean akC;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.fcw.cwC;
        linearLayout.removeView(view);
        akC = this.fcw.akC();
        if (!akC) {
            this.fcw.akA();
        }
        aVar = this.fcw.fcv;
        if (aVar != null) {
            aVar2 = this.fcw.fcv;
            aVar2.a(view, view.getTag());
        }
    }
}
