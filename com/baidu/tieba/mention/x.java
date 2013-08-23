package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.model.bk;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.aq;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1346a;
    private ArrayList b;
    private int c;

    public x(PostActivity postActivity, ArrayList arrayList, int i) {
        this.f1346a = postActivity;
        this.b = arrayList;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.b.size()) {
                    if (((com.baidu.tieba.data.i) this.b.get(i2)).a() == 3) {
                        StringBuffer stringBuffer = new StringBuffer(100);
                        stringBuffer.append("size=");
                        stringBuffer.append(com.baidu.tieba.data.g.i());
                        stringBuffer.append("&src=");
                        stringBuffer.append(ap.d(((com.baidu.tieba.data.i) this.b.get(i2)).d()));
                        arrayList.add(stringBuffer.toString());
                    }
                    i = i2 + 1;
                } else {
                    PostActivity postActivity = this.f1346a;
                    int i3 = this.c;
                    bkVar = this.f1346a.n;
                    ImageActivity.a(postActivity, arrayList, i3, bkVar);
                    return;
                }
            }
        } catch (Exception e) {
            aq.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
