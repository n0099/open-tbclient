package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import com.baidu.tieba.person.post.p;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ r ciI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i) {
        super(i);
        this.ciI = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonBarActivity agd;
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
        PersonBarActivity agd2;
        View view3;
        String str;
        this.ciI.mListView.completePullRefresh();
        if (socketResponsedMessage == null) {
            this.ciI.showToast(this.ciI.getPageContext().getString(i.C0057i.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                agd = this.ciI.agd();
                if (agd != null) {
                    agd2 = this.ciI.agd();
                    if (agd2.getRequestCode() != 23011) {
                        view3 = this.ciI.ciz;
                        view3.setVisibility(8);
                        acVar = this.ciI.cis;
                        if (acVar == null) {
                            arrayList = this.ciI.rM;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.ciI.removalDuplicate();
                            acVar2 = this.ciI.cis;
                            arrayList2 = this.ciI.rM;
                            acVar2.R(arrayList2);
                            this.ciI.hasMore = responseGetLivableForumList.hasMore();
                            this.ciI.eG(true);
                            acVar3 = this.ciI.cis;
                            acVar3.notifyDataSetChanged();
                            this.ciI.civ++;
                            return;
                        }
                        return;
                    }
                }
                z = this.ciI.ciD;
                if (!z) {
                    this.ciI.ciD = true;
                    BdListView bdListView = this.ciI.mListView;
                    view2 = this.ciI.ciz;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.ciI.ciA;
                    textView.setText(this.ciI.getResources().getString(i.C0057i.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.ciI.ciA;
                    com.baidu.tbadk.core.util.al.b(textView2, i.c.cp_cont_c, 1);
                    textView3 = this.ciI.ciA;
                    com.baidu.tbadk.core.util.al.j((View) textView3, i.c.bg_page_setting);
                }
                view = this.ciI.ciz;
                view.setVisibility(0);
                acVar = this.ciI.cis;
                if (acVar == null) {
                }
            } else {
                this.ciI.showToast(responseGetLivableForumList.getErrorString());
                p.a aVar = this.ciI.cir;
                str = this.ciI.ciy;
                aVar.jz(str);
            }
        }
    }
}
