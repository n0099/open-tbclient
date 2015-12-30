package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList dWW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AtSelectFriendList atSelectFriendList) {
        this.dWW = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean adQ;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.dWW.cgA;
        linearLayout.removeView(view);
        adQ = this.dWW.adQ();
        if (!adQ) {
            this.dWW.adO();
        }
        aVar = this.dWW.dWV;
        if (aVar != null) {
            aVar2 = this.dWW.dWV;
            aVar2.a(view, view.getTag());
        }
    }
}
