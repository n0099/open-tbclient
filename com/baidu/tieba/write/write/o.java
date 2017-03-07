package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList fPa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AtSelectFriendList atSelectFriendList) {
        this.fPa = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean auH;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.fPa.mLayout;
        linearLayout.removeView(view);
        auH = this.fPa.auH();
        if (!auH) {
            this.fPa.auF();
        }
        aVar = this.fPa.fOZ;
        if (aVar != null) {
            aVar2 = this.fPa.fOZ;
            aVar2.a(view, view.getTag());
        }
    }
}
