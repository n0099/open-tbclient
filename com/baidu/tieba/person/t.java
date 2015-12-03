package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import com.baidu.tieba.n;
import com.baidu.tieba.person.post.u;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ s cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, int i) {
        super(i);
        this.cKg = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonBarActivity anx;
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
        PersonBarActivity anx2;
        View view3;
        String str;
        this.cKg.mListView.completePullRefresh();
        if (socketResponsedMessage == null) {
            this.cKg.showToast(this.cKg.getPageContext().getString(n.i.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                anx = this.cKg.anx();
                if (anx != null) {
                    anx2 = this.cKg.anx();
                    if (anx2.getRequestCode() != 23011) {
                        view3 = this.cKg.cJY;
                        view3.setVisibility(8);
                        adVar = this.cKg.cJR;
                        if (adVar == null) {
                            arrayList = this.cKg.list;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.cKg.removalDuplicate();
                            adVar2 = this.cKg.cJR;
                            arrayList2 = this.cKg.list;
                            adVar2.Y(arrayList2);
                            this.cKg.hasMore = responseGetLivableForumList.hasMore();
                            this.cKg.fD(true);
                            adVar3 = this.cKg.cJR;
                            adVar3.notifyDataSetChanged();
                            this.cKg.cJU++;
                            return;
                        }
                        return;
                    }
                }
                z = this.cKg.cKb;
                if (!z) {
                    this.cKg.cKb = true;
                    BdListView bdListView = this.cKg.mListView;
                    view2 = this.cKg.cJY;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.cKg.cJZ;
                    textView.setText(this.cKg.getResources().getString(n.i.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.cKg.cJZ;
                    com.baidu.tbadk.core.util.as.b(textView2, n.c.cp_cont_c, 1);
                    textView3 = this.cKg.cJZ;
                    com.baidu.tbadk.core.util.as.j((View) textView3, n.c.bg_page_setting);
                }
                view = this.cKg.cJY;
                view.setVisibility(0);
                adVar = this.cKg.cJR;
                if (adVar == null) {
                }
            } else {
                this.cKg.showToast(responseGetLivableForumList.getErrorString());
                u.a aVar = this.cKg.cJQ;
                str = this.cKg.cJX;
                aVar.kW(str);
            }
        }
    }
}
