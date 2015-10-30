package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AtSelectFriendList atSelectFriendList) {
        this.doF = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean Zg;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.doF.bNb;
        linearLayout.removeView(view);
        Zg = this.doF.Zg();
        if (!Zg) {
            this.doF.Ze();
        }
        aVar = this.doF.doE;
        if (aVar != null) {
            aVar2 = this.doF.doE;
            aVar2.a(view, view.getTag());
        }
    }
}
