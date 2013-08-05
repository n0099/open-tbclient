package com.baidu.tieba.mention;

import android.widget.ListView;
import com.baidu.tieba.util.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1300a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f1300a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        ListView listView2;
        e eVar;
        e eVar2;
        String portrait;
        e eVar3;
        try {
            listView = this.f1300a.d;
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            listView2 = this.f1300a.d;
            int lastVisiblePosition = listView2.getLastVisiblePosition();
            for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                eVar = this.f1300a.e;
                if (i < eVar.getCount()) {
                    eVar2 = this.f1300a.e;
                    com.baidu.tieba.data.u uVar = (com.baidu.tieba.data.u) eVar2.getItem(i);
                    if (uVar != null && (portrait = uVar.i().getPortrait()) != null && portrait.length() > 0) {
                        eVar3 = this.f1300a.e;
                        eVar3.e().d(portrait, new j(this));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            aj.b("MentionView", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
