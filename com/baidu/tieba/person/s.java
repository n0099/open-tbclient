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
    final /* synthetic */ r cqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i) {
        super(i);
        this.cqM = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonBarActivity aiU;
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
        PersonBarActivity aiU2;
        View view3;
        String str;
        this.cqM.mListView.completePullRefresh();
        if (socketResponsedMessage == null) {
            this.cqM.showToast(this.cqM.getPageContext().getString(i.h.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                aiU = this.cqM.aiU();
                if (aiU != null) {
                    aiU2 = this.cqM.aiU();
                    if (aiU2.getRequestCode() != 23011) {
                        view3 = this.cqM.cqD;
                        view3.setVisibility(8);
                        acVar = this.cqM.cqw;
                        if (acVar == null) {
                            arrayList = this.cqM.rK;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.cqM.removalDuplicate();
                            acVar2 = this.cqM.cqw;
                            arrayList2 = this.cqM.rK;
                            acVar2.S(arrayList2);
                            this.cqM.hasMore = responseGetLivableForumList.hasMore();
                            this.cqM.eY(true);
                            acVar3 = this.cqM.cqw;
                            acVar3.notifyDataSetChanged();
                            this.cqM.cqz++;
                            return;
                        }
                        return;
                    }
                }
                z = this.cqM.cqH;
                if (!z) {
                    this.cqM.cqH = true;
                    BdListView bdListView = this.cqM.mListView;
                    view2 = this.cqM.cqD;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.cqM.cqE;
                    textView.setText(this.cqM.getResources().getString(i.h.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.cqM.cqE;
                    com.baidu.tbadk.core.util.an.b(textView2, i.c.cp_cont_c, 1);
                    textView3 = this.cqM.cqE;
                    com.baidu.tbadk.core.util.an.j((View) textView3, i.c.bg_page_setting);
                }
                view = this.cqM.cqD;
                view.setVisibility(0);
                acVar = this.cqM.cqw;
                if (acVar == null) {
                }
            } else {
                this.cqM.showToast(responseGetLivableForumList.getErrorString());
                u.a aVar = this.cqM.cqv;
                str = this.cqM.cqC;
                aVar.ke(str);
            }
        }
    }
}
