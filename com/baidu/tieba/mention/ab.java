package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.model.bn;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.util.bs;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ PostActivity a;
    private ArrayList<com.baidu.tieba.data.k> b;
    private int c;

    public ab(PostActivity postActivity, ArrayList<com.baidu.tieba.data.k> arrayList, int i) {
        this.a = postActivity;
        this.b = arrayList;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bn bnVar;
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.b.size()) {
                    if (this.b.get(i2).a() == 3) {
                        StringBuffer stringBuffer = new StringBuffer(100);
                        stringBuffer.append("size=");
                        stringBuffer.append(com.baidu.tieba.data.i.t());
                        stringBuffer.append("&src=");
                        stringBuffer.append(bs.d(this.b.get(i2).e()));
                        arrayList.add(stringBuffer.toString());
                    }
                    i = i2 + 1;
                } else {
                    PostActivity postActivity = this.a;
                    int i3 = this.c;
                    bnVar = this.a.l;
                    ImageActivity.a(postActivity, arrayList, i3, bnVar);
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
