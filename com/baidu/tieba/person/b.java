package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            gVar = this.a.i;
            if (intValue < gVar.getCount()) {
                gVar2 = this.a.i;
                ForumData forumData = (ForumData) gVar2.getItem(intValue);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003006, new com.baidu.tbadk.core.atomData.ar(this.a, com.baidu.adp.lib.f.b.a(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
            }
        }
    }
}
