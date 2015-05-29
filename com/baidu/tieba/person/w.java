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
    final /* synthetic */ v bSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i) {
        super(i);
        this.bSb = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonBarActivity ael;
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
        PersonBarActivity ael2;
        View view3;
        String str;
        this.bSb.mListView.completePullRefresh();
        if (socketResponsedMessage == null) {
            this.bSb.showToast(this.bSb.getPageContext().getString(com.baidu.tieba.t.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                ael = this.bSb.ael();
                if (ael != null) {
                    ael2 = this.bSb.ael();
                    if (ael2.getRequestCode() != 23011) {
                        view3 = this.bSb.bRT;
                        view3.setVisibility(8);
                        agVar = this.bSb.bRM;
                        if (agVar == null) {
                            arrayList = this.bSb.rQ;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.bSb.removalDuplicate();
                            agVar2 = this.bSb.bRM;
                            arrayList2 = this.bSb.rQ;
                            agVar2.L(arrayList2);
                            this.bSb.hasMore = responseGetLivableForumList.hasMore();
                            this.bSb.eo(true);
                            agVar3 = this.bSb.bRM;
                            agVar3.notifyDataSetChanged();
                            this.bSb.bRP++;
                            return;
                        }
                        return;
                    }
                }
                z = this.bSb.bRW;
                if (!z) {
                    this.bSb.bRW = true;
                    BdListView bdListView = this.bSb.mListView;
                    view2 = this.bSb.bRT;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.bSb.bRU;
                    textView.setText(this.bSb.getResources().getString(com.baidu.tieba.t.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.bSb.bRU;
                    com.baidu.tbadk.core.util.ay.b(textView2, com.baidu.tieba.n.cp_cont_c, 1);
                    textView3 = this.bSb.bRU;
                    com.baidu.tbadk.core.util.ay.j((View) textView3, com.baidu.tieba.n.bg_page_setting);
                }
                view = this.bSb.bRT;
                view.setVisibility(0);
                agVar = this.bSb.bRM;
                if (agVar == null) {
                }
            } else {
                this.bSb.showToast(responseGetLivableForumList.getErrorString());
                com.baidu.tieba.person.post.z zVar = this.bSb.bRL;
                str = this.bSb.bRS;
                zVar.iF(str);
            }
        }
    }
}
