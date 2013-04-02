package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.c.af;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.pb.ImageActivity;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ PostActivity a;
    private ArrayList b;
    private int c;

    public w(PostActivity postActivity, ArrayList arrayList, int i) {
        this.a = postActivity;
        this.b = arrayList;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.r rVar;
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.b.size()) {
                    if (((com.baidu.tieba.a.k) this.b.get(i2)).a() == 3) {
                        StringBuffer stringBuffer = new StringBuffer(100);
                        stringBuffer.append("size=");
                        stringBuffer.append(com.baidu.tieba.a.i.g());
                        stringBuffer.append("&src=");
                        stringBuffer.append(af.f(((com.baidu.tieba.a.k) this.b.get(i2)).f()));
                        arrayList.add(stringBuffer.toString());
                    }
                    i = i2 + 1;
                } else {
                    PostActivity postActivity = this.a;
                    int i3 = this.c;
                    rVar = this.a.n;
                    ImageActivity.a(postActivity, arrayList, i3, rVar);
                    return;
                }
            }
        } catch (Exception e) {
            ag.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
