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
    final /* synthetic */ s cOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, int i) {
        super(i);
        this.cOw = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonBarActivity aoI;
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
        PersonBarActivity aoI2;
        View view3;
        String str;
        this.cOw.mListView.completePullRefresh();
        if (socketResponsedMessage == null) {
            this.cOw.showToast(this.cOw.getPageContext().getString(n.j.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                aoI = this.cOw.aoI();
                if (aoI != null) {
                    aoI2 = this.cOw.aoI();
                    if (aoI2.getRequestCode() != 23011) {
                        view3 = this.cOw.cOo;
                        view3.setVisibility(8);
                        adVar = this.cOw.cOh;
                        if (adVar == null) {
                            arrayList = this.cOw.rN;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.cOw.removalDuplicate();
                            adVar2 = this.cOw.cOh;
                            arrayList2 = this.cOw.rN;
                            adVar2.X(arrayList2);
                            this.cOw.hasMore = responseGetLivableForumList.hasMore();
                            this.cOw.fC(true);
                            adVar3 = this.cOw.cOh;
                            adVar3.notifyDataSetChanged();
                            this.cOw.cOk++;
                            return;
                        }
                        return;
                    }
                }
                z = this.cOw.cOr;
                if (!z) {
                    this.cOw.cOr = true;
                    BdListView bdListView = this.cOw.mListView;
                    view2 = this.cOw.cOo;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.cOw.cOp;
                    textView.setText(this.cOw.getResources().getString(n.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.cOw.cOp;
                    com.baidu.tbadk.core.util.as.b(textView2, n.d.cp_cont_c, 1);
                    textView3 = this.cOw.cOp;
                    com.baidu.tbadk.core.util.as.j((View) textView3, n.d.bg_page_setting);
                }
                view = this.cOw.cOo;
                view.setVisibility(0);
                adVar = this.cOw.cOh;
                if (adVar == null) {
                }
            } else {
                this.cOw.showToast(responseGetLivableForumList.getErrorString());
                u.a aVar = this.cOw.cOg;
                str = this.cOw.cOn;
                aVar.kT(str);
            }
        }
    }
}
