package com.baidu.tieba.write;

import android.widget.ProgressBar;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AtListActivity atListActivity, int i) {
        super(i);
        this.a = atListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AtomicBoolean atomicBoolean;
        ProgressBar progressBar;
        j jVar;
        if (customResponsedMessage instanceof GetContactListResponsedMessage) {
            atomicBoolean = this.a.m;
            atomicBoolean.set(false);
            progressBar = this.a.k;
            progressBar.setVisibility(8);
            List<com.baidu.tbadk.coreExtra.relationship.b> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
            this.a.a = contacts;
            jVar = this.a.i;
            if (jVar != null) {
                this.a.c();
            }
        }
    }
}
