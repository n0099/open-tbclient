package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.c.ad;
import com.baidu.tieba.c.ae;
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
        com.baidu.tieba.b.n nVar;
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.size()) {
                    PostActivity postActivity = this.a;
                    int i3 = this.c;
                    nVar = this.a.k;
                    ImageActivity.a(postActivity, arrayList, i3, nVar);
                    return;
                }
                if (((com.baidu.tieba.a.j) this.b.get(i2)).a() == 3) {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    stringBuffer.append("size=");
                    stringBuffer.append(com.baidu.tieba.a.h.g());
                    stringBuffer.append("&src=");
                    stringBuffer.append(ad.f(((com.baidu.tieba.a.j) this.b.get(i2)).f()));
                    arrayList.add(stringBuffer.toString());
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            ae.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
