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
    final /* synthetic */ r cjC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i) {
        super(i);
        this.cjC = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonBarActivity agt;
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
        PersonBarActivity agt2;
        View view3;
        String str;
        this.cjC.mListView.completePullRefresh();
        if (socketResponsedMessage == null) {
            this.cjC.showToast(this.cjC.getPageContext().getString(i.h.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                agt = this.cjC.agt();
                if (agt != null) {
                    agt2 = this.cjC.agt();
                    if (agt2.getRequestCode() != 23011) {
                        view3 = this.cjC.cjt;
                        view3.setVisibility(8);
                        acVar = this.cjC.cjm;
                        if (acVar == null) {
                            arrayList = this.cjC.rK;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.cjC.removalDuplicate();
                            acVar2 = this.cjC.cjm;
                            arrayList2 = this.cjC.rK;
                            acVar2.R(arrayList2);
                            this.cjC.hasMore = responseGetLivableForumList.hasMore();
                            this.cjC.eP(true);
                            acVar3 = this.cjC.cjm;
                            acVar3.notifyDataSetChanged();
                            this.cjC.cjp++;
                            return;
                        }
                        return;
                    }
                }
                z = this.cjC.cjx;
                if (!z) {
                    this.cjC.cjx = true;
                    BdListView bdListView = this.cjC.mListView;
                    view2 = this.cjC.cjt;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.cjC.cju;
                    textView.setText(this.cjC.getResources().getString(i.h.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.cjC.cju;
                    com.baidu.tbadk.core.util.al.b(textView2, i.c.cp_cont_c, 1);
                    textView3 = this.cjC.cju;
                    com.baidu.tbadk.core.util.al.i((View) textView3, i.c.bg_page_setting);
                }
                view = this.cjC.cjt;
                view.setVisibility(0);
                acVar = this.cjC.cjm;
                if (acVar == null) {
                }
            } else {
                this.cjC.showToast(responseGetLivableForumList.getErrorString());
                u.a aVar = this.cjC.cjl;
                str = this.cjC.cjs;
                aVar.jG(str);
            }
        }
    }
}
