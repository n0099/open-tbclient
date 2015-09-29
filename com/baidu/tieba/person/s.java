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
    final /* synthetic */ r cpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i) {
        super(i);
        this.cpf = rVar;
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
        this.cpf.mListView.completePullRefresh();
        if (socketResponsedMessage == null) {
            this.cpf.showToast(this.cpf.getPageContext().getString(i.h.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                ais = this.cpf.ais();
                if (ais != null) {
                    ais2 = this.cpf.ais();
                    if (ais2.getRequestCode() != 23011) {
                        view3 = this.cpf.coW;
                        view3.setVisibility(8);
                        acVar = this.cpf.coP;
                        if (acVar == null) {
                            arrayList = this.cpf.rK;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.cpf.removalDuplicate();
                            acVar2 = this.cpf.coP;
                            arrayList2 = this.cpf.rK;
                            acVar2.S(arrayList2);
                            this.cpf.hasMore = responseGetLivableForumList.hasMore();
                            this.cpf.eV(true);
                            acVar3 = this.cpf.coP;
                            acVar3.notifyDataSetChanged();
                            this.cpf.coS++;
                            return;
                        }
                        return;
                    }
                }
                z = this.cpf.cpa;
                if (!z) {
                    this.cpf.cpa = true;
                    BdListView bdListView = this.cpf.mListView;
                    view2 = this.cpf.coW;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.cpf.coX;
                    textView.setText(this.cpf.getResources().getString(i.h.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.cpf.coX;
                    com.baidu.tbadk.core.util.am.b(textView2, i.c.cp_cont_c, 1);
                    textView3 = this.cpf.coX;
                    com.baidu.tbadk.core.util.am.j((View) textView3, i.c.bg_page_setting);
                }
                view = this.cpf.coW;
                view.setVisibility(0);
                acVar = this.cpf.coP;
                if (acVar == null) {
                }
            } else {
                this.cpf.showToast(responseGetLivableForumList.getErrorString());
                u.a aVar = this.cpf.coO;
                str = this.cpf.coV;
                aVar.kb(str);
            }
        }
    }
}
