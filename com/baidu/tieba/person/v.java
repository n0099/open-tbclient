package com.baidu.tieba.person;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends HttpMessageListener {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(t tVar, int i) {
        super(i);
        this.a = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ae aeVar;
        ae aeVar2;
        int i;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        int i2;
        int i3;
        int i4;
        String str;
        ac acVar;
        ac acVar2;
        ac acVar3;
        ae aeVar3;
        this.a.l = false;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                aeVar = this.a.f;
                ArrayList<ForumData> c = aeVar.b().c();
                aeVar2 = this.a.f;
                int a = aeVar2.b().a();
                i = this.a.d;
                if (i < a) {
                    aeVar3 = this.a.f;
                    aeVar3.b().a(a - 1);
                }
                if (c != null) {
                    i2 = this.a.d;
                    if (i2 >= 0) {
                        i3 = this.a.d;
                        if (i3 < c.size()) {
                            i4 = this.a.d;
                            c.remove(i4);
                            com.baidu.tieba.ai c2 = com.baidu.tieba.ai.c();
                            str = this.a.e;
                            c2.e(str);
                            acVar = this.a.c;
                            if (acVar != null) {
                                this.a.a(true);
                                acVar2 = this.a.c;
                                acVar2.a(c);
                                acVar3 = this.a.c;
                                acVar3.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.a.a(com.baidu.tieba.x.success);
                forumData = this.a.k;
                if (forumData != null) {
                    forumData2 = this.a.k;
                    if (!TextUtils.isEmpty(forumData2.getId())) {
                        t tVar = this.a;
                        forumData3 = this.a.k;
                        tVar.a(new CustomMessage(2003004, forumData3.getId()));
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
