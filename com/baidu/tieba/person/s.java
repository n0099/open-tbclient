package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import com.baidu.tieba.person.post.u;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ r cpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i) {
        super(i);
        this.cpq = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonBarActivity ais;
        boolean z;
        View view;
        View view2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        ac acVar;
        ArrayList arrayList;
        ac acVar2;
        ArrayList<ForumData> arrayList2;
        ac acVar3;
        PersonBarActivity ais2;
        View view3;
        String str;
        this.cpq.mListView.completePullRefresh();
        if (socketResponsedMessage == null) {
            this.cpq.showToast(this.cpq.getPageContext().getString(i.h.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                ais = this.cpq.ais();
                if (ais != null) {
                    ais2 = this.cpq.ais();
                    if (ais2.getRequestCode() != 23011) {
                        view3 = this.cpq.cph;
                        view3.setVisibility(8);
                        acVar = this.cpq.cpa;
                        if (acVar == null) {
                            arrayList = this.cpq.rK;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.cpq.removalDuplicate();
                            acVar2 = this.cpq.cpa;
                            arrayList2 = this.cpq.rK;
                            acVar2.S(arrayList2);
                            this.cpq.hasMore = responseGetLivableForumList.hasMore();
                            this.cpq.eV(true);
                            acVar3 = this.cpq.cpa;
                            acVar3.notifyDataSetChanged();
                            this.cpq.cpd++;
                            return;
                        }
                        return;
                    }
                }
                z = this.cpq.cpl;
                if (!z) {
                    this.cpq.cpl = true;
                    BdListView bdListView = this.cpq.mListView;
                    view2 = this.cpq.cph;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.cpq.cpi;
                    textView.setText(this.cpq.getResources().getString(i.h.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.cpq.cpi;
                    com.baidu.tbadk.core.util.an.b(textView2, i.c.cp_cont_c, 1);
                    textView3 = this.cpq.cpi;
                    com.baidu.tbadk.core.util.an.j((View) textView3, i.c.bg_page_setting);
                }
                view = this.cpq.cph;
                view.setVisibility(0);
                acVar = this.cpq.cpa;
                if (acVar == null) {
                }
            } else {
                this.cpq.showToast(responseGetLivableForumList.getErrorString());
                u.a aVar = this.cpq.coZ;
                str = this.cpq.cpg;
                aVar.kb(str);
            }
        }
    }
}
