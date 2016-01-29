package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import com.baidu.tieba.person.post.v;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ s cXR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, int i) {
        super(i);
        this.cXR = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonBarActivity atz;
        boolean z;
        View view;
        View view2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        ad adVar;
        ArrayList arrayList;
        ad adVar2;
        ArrayList<ForumData> arrayList2;
        ad adVar3;
        PersonBarActivity atz2;
        View view3;
        String str;
        this.cXR.IY.nr();
        if (socketResponsedMessage == null) {
            this.cXR.showToast(this.cXR.getPageContext().getString(t.j.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                atz = this.cXR.atz();
                if (atz != null) {
                    atz2 = this.cXR.atz();
                    if (atz2.getRequestCode() != 23011) {
                        view3 = this.cXR.cXI;
                        view3.setVisibility(8);
                        adVar = this.cXR.cXB;
                        if (adVar == null) {
                            arrayList = this.cXR.rV;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.cXR.SR();
                            adVar2 = this.cXR.cXB;
                            arrayList2 = this.cXR.rV;
                            adVar2.Y(arrayList2);
                            this.cXR.hasMore = responseGetLivableForumList.hasMore();
                            this.cXR.fR(true);
                            adVar3 = this.cXR.cXB;
                            adVar3.notifyDataSetChanged();
                            this.cXR.cXE++;
                            return;
                        }
                        return;
                    }
                }
                z = this.cXR.cXL;
                if (!z) {
                    this.cXR.cXL = true;
                    BdListView bdListView = this.cXR.IY;
                    view2 = this.cXR.cXI;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.cXR.cXJ;
                    textView.setText(this.cXR.getResources().getString(t.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.cXR.cXJ;
                    com.baidu.tbadk.core.util.ar.b(textView2, t.d.cp_cont_c, 1);
                    textView3 = this.cXR.cXJ;
                    com.baidu.tbadk.core.util.ar.l(textView3, t.d.bg_page_setting);
                }
                view = this.cXR.cXI;
                view.setVisibility(0);
                adVar = this.cXR.cXB;
                if (adVar == null) {
                }
            } else {
                this.cXR.showToast(responseGetLivableForumList.getErrorString());
                v.a aVar = this.cXR.cXA;
                str = this.cXR.cXH;
                aVar.ld(str);
            }
        }
    }
}
