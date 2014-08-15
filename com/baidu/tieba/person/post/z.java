package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
/* loaded from: classes.dex */
public class z {
    BdListView a;
    EnterGuideCenterView b;
    ProgressBar c;

    public BdListView a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(View view) {
        this.b = null;
        this.a = (BdListView) view.findViewById(com.baidu.tieba.u.list);
        this.b = (EnterGuideCenterView) view.findViewById(com.baidu.tieba.u.post_guid_center_root);
        this.b.a(com.baidu.tieba.t.pic_emotion05, com.baidu.tieba.t.pic_emotion05_1);
        this.c = (ProgressBar) view.findViewById(com.baidu.tieba.u.progress);
    }
}
