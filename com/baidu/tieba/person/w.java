package com.baidu.tieba.person;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends HttpMessageListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(u uVar, int i) {
        super(i);
        this.a = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        af afVar;
        af afVar2;
        int i;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        int i2;
        int i3;
        int i4;
        String str;
        ad adVar;
        ad adVar2;
        ad adVar3;
        af afVar3;
        this.a.l = false;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                afVar = this.a.f;
                ArrayList<ForumData> b = afVar.b().b();
                afVar2 = this.a.f;
                int a = afVar2.b().a();
                i = this.a.d;
                if (i < a) {
                    afVar3 = this.a.f;
                    afVar3.b().a(a - 1);
                }
                if (b != null) {
                    i2 = this.a.d;
                    if (i2 >= 0) {
                        i3 = this.a.d;
                        if (i3 < b.size()) {
                            i4 = this.a.d;
                            b.remove(i4);
                            com.baidu.tieba.ai c = com.baidu.tieba.ai.c();
                            str = this.a.e;
                            c.f(str);
                            adVar = this.a.c;
                            if (adVar != null) {
                                this.a.a(true);
                                adVar2 = this.a.c;
                                adVar2.a(b);
                                adVar3 = this.a.c;
                                adVar3.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.a.a(com.baidu.tieba.y.success);
                forumData = this.a.k;
                if (forumData != null) {
                    forumData2 = this.a.k;
                    if (!TextUtils.isEmpty(forumData2.getId())) {
                        u uVar = this.a;
                        forumData3 = this.a.k;
                        uVar.a(new CustomMessage(2003004, forumData3.getId()));
                        return;
                    }
                    return;
                }
                return;
            }
            this.a.b(httpResponsedMessage.getErrorString());
        }
    }
}
