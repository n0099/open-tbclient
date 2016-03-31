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
    final /* synthetic */ s dst;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, int i) {
        super(i);
        this.dst = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonBarActivity aBf;
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
        PersonBarActivity aBf2;
        View view3;
        String str;
        this.dst.Je.nj();
        if (socketResponsedMessage == null) {
            this.dst.showToast(this.dst.getPageContext().getString(t.j.neterror));
        } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
            ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
            if (responseGetLivableForumList.getError() == 0) {
                aBf = this.dst.aBf();
                if (aBf != null) {
                    aBf2 = this.dst.aBf();
                    if (aBf2.getRequestCode() != 23011) {
                        view3 = this.dst.dsk;
                        view3.setVisibility(8);
                        adVar = this.dst.dsd;
                        if (adVar == null) {
                            arrayList = this.dst.list;
                            arrayList.addAll(responseGetLivableForumList.getData());
                            this.dst.UI();
                            adVar2 = this.dst.dsd;
                            arrayList2 = this.dst.list;
                            adVar2.Z(arrayList2);
                            this.dst.hasMore = responseGetLivableForumList.hasMore();
                            this.dst.gE(true);
                            adVar3 = this.dst.dsd;
                            adVar3.notifyDataSetChanged();
                            this.dst.dsg++;
                            return;
                        }
                        return;
                    }
                }
                z = this.dst.dsn;
                if (!z) {
                    this.dst.dsn = true;
                    BdListView bdListView = this.dst.Je;
                    view2 = this.dst.dsk;
                    bdListView.addHeaderView(view2);
                    int miniLevel = responseGetLivableForumList.getMiniLevel();
                    if (miniLevel <= 0) {
                        miniLevel = 0;
                    }
                    textView = this.dst.dsl;
                    textView.setText(this.dst.getResources().getString(t.j.level_above_six_tip, Integer.valueOf(miniLevel)));
                    textView2 = this.dst.dsl;
                    com.baidu.tbadk.core.util.at.b(textView2, t.d.cp_cont_c, 1);
                    textView3 = this.dst.dsl;
                    com.baidu.tbadk.core.util.at.l(textView3, t.d.bg_page_setting);
                }
                view = this.dst.dsk;
                view.setVisibility(0);
                adVar = this.dst.dsd;
                if (adVar == null) {
                }
            } else {
                this.dst.showToast(responseGetLivableForumList.getErrorString());
                s.a aVar = this.dst.dsc;
                str = this.dst.dsj;
                aVar.ml(str);
            }
        }
    }
}
