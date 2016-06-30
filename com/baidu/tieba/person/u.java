package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import com.baidu.tieba.person.t;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ t eeh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(t tVar, int i) {
        super(i);
        this.eeh = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonBarActivity aKx;
        boolean z;
        View view;
        View view2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        af afVar;
        ArrayList arrayList;
        af afVar2;
        ArrayList<ForumData> arrayList2;
        af afVar3;
        PersonBarActivity aKx2;
        View view3;
        String str;
        this.eeh.zt.k(2000L);
        if (socketResponsedMessage == null) {
            this.eeh.showToast(this.eeh.getPageContext().getString(u.j.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                aKx = this.eeh.aKx();
                if (aKx != null) {
                    aKx2 = this.eeh.aKx();
                    if (aKx2.getRequestCode() != 23011) {
                        view3 = this.eeh.edY;
                        view3.setVisibility(8);
                        afVar = this.eeh.edR;
                        if (afVar == null) {
                            arrayList = this.eeh.hR;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.eeh.aaW();
                            afVar2 = this.eeh.edR;
                            arrayList2 = this.eeh.hR;
                            afVar2.am(arrayList2);
                            this.eeh.hasMore = responseGetLivableForumList.hasMore();
                            this.eeh.m15if(true);
                            afVar3 = this.eeh.edR;
                            afVar3.notifyDataSetChanged();
                            this.eeh.edU++;
                            return;
                        }
                        return;
                    }
                }
                z = this.eeh.eeb;
                if (!z) {
                    this.eeh.eeb = true;
                    BdListView bdListView = this.eeh.zt;
                    view2 = this.eeh.edY;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.eeh.edZ;
                    textView.setText(this.eeh.getResources().getString(u.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.eeh.edZ;
                    com.baidu.tbadk.core.util.av.c(textView2, u.d.cp_cont_c, 1);
                    textView3 = this.eeh.edZ;
                    com.baidu.tbadk.core.util.av.l(textView3, u.d.common_color_10238);
                }
                view = this.eeh.edY;
                view.setVisibility(0);
                afVar = this.eeh.edR;
                if (afVar == null) {
                }
            } else {
                this.eeh.showToast(responseGetLivableForumList.getErrorString());
                t.a aVar = this.eeh.edQ;
                str = this.eeh.edX;
                aVar.nU(str);
            }
        }
    }
}
