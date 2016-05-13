package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
import com.baidu.tieba.person.s;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ s dvP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, int i) {
        super(i);
        this.dvP = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonBarActivity aBF;
        boolean z;
        View view;
        View view2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        ae aeVar;
        ArrayList arrayList;
        ae aeVar2;
        ArrayList<ForumData> arrayList2;
        ae aeVar3;
        PersonBarActivity aBF2;
        View view3;
        String str;
        this.dvP.zu.k(2000L);
        if (socketResponsedMessage == null) {
            this.dvP.showToast(this.dvP.getPageContext().getString(t.j.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                aBF = this.dvP.aBF();
                if (aBF != null) {
                    aBF2 = this.dvP.aBF();
                    if (aBF2.getRequestCode() != 23011) {
                        view3 = this.dvP.dvG;
                        view3.setVisibility(8);
                        aeVar = this.dvP.dvz;
                        if (aeVar == null) {
                            arrayList = this.dvP.hS;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.dvP.UJ();
                            aeVar2 = this.dvP.dvz;
                            arrayList2 = this.dvP.hS;
                            aeVar2.ab(arrayList2);
                            this.dvP.hasMore = responseGetLivableForumList.hasMore();
                            this.dvP.hk(true);
                            aeVar3 = this.dvP.dvz;
                            aeVar3.notifyDataSetChanged();
                            this.dvP.dvC++;
                            return;
                        }
                        return;
                    }
                }
                z = this.dvP.dvJ;
                if (!z) {
                    this.dvP.dvJ = true;
                    BdListView bdListView = this.dvP.zu;
                    view2 = this.dvP.dvG;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.dvP.dvH;
                    textView.setText(this.dvP.getResources().getString(t.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.dvP.dvH;
                    com.baidu.tbadk.core.util.at.c(textView2, t.d.cp_cont_c, 1);
                    textView3 = this.dvP.dvH;
                    com.baidu.tbadk.core.util.at.l(textView3, t.d.bg_page_setting);
                }
                view = this.dvP.dvG;
                view.setVisibility(0);
                aeVar = this.dvP.dvz;
                if (aeVar == null) {
                }
            } else {
                this.dvP.showToast(responseGetLivableForumList.getErrorString());
                s.a aVar = this.dvP.dvy;
                str = this.dvP.dvF;
                aVar.mp(str);
            }
        }
    }
}
