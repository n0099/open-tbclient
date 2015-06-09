package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ v bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i) {
        super(i);
        this.bSc = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonBarActivity aem;
        boolean z;
        View view;
        View view2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        ag agVar;
        ArrayList arrayList;
        ag agVar2;
        ArrayList<ForumData> arrayList2;
        ag agVar3;
        PersonBarActivity aem2;
        View view3;
        String str;
        this.bSc.mListView.completePullRefresh();
        if (socketResponsedMessage == null) {
            this.bSc.showToast(this.bSc.getPageContext().getString(com.baidu.tieba.t.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                aem = this.bSc.aem();
                if (aem != null) {
                    aem2 = this.bSc.aem();
                    if (aem2.getRequestCode() != 23011) {
                        view3 = this.bSc.bRU;
                        view3.setVisibility(8);
                        agVar = this.bSc.bRN;
                        if (agVar == null) {
                            arrayList = this.bSc.rQ;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.bSc.removalDuplicate();
                            agVar2 = this.bSc.bRN;
                            arrayList2 = this.bSc.rQ;
                            agVar2.L(arrayList2);
                            this.bSc.hasMore = responseGetLivableForumList.hasMore();
                            this.bSc.eo(true);
                            agVar3 = this.bSc.bRN;
                            agVar3.notifyDataSetChanged();
                            this.bSc.bRQ++;
                            return;
                        }
                        return;
                    }
                }
                z = this.bSc.bRX;
                if (!z) {
                    this.bSc.bRX = true;
                    BdListView bdListView = this.bSc.mListView;
                    view2 = this.bSc.bRU;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.bSc.bRV;
                    textView.setText(this.bSc.getResources().getString(com.baidu.tieba.t.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.bSc.bRV;
                    com.baidu.tbadk.core.util.ay.b(textView2, com.baidu.tieba.n.cp_cont_c, 1);
                    textView3 = this.bSc.bRV;
                    com.baidu.tbadk.core.util.ay.j((View) textView3, com.baidu.tieba.n.bg_page_setting);
                }
                view = this.bSc.bRU;
                view.setVisibility(0);
                agVar = this.bSc.bRN;
                if (agVar == null) {
                }
            } else {
                this.bSc.showToast(responseGetLivableForumList.getErrorString());
                com.baidu.tieba.person.post.z zVar = this.bSc.bRM;
                str = this.bSc.bRT;
                zVar.iF(str);
            }
        }
    }
}
