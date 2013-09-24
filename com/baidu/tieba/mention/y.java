package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.model.bm;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.av;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1382a;
    private ArrayList<com.baidu.tieba.data.i> b;
    private int c;

    public y(PostActivity postActivity, ArrayList<com.baidu.tieba.data.i> arrayList, int i) {
        this.f1382a = postActivity;
        this.b = arrayList;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.b.size()) {
                    if (this.b.get(i2).a() == 3) {
                        StringBuffer stringBuffer = new StringBuffer(100);
                        stringBuffer.append("size=");
                        stringBuffer.append(com.baidu.tieba.data.g.i());
                        stringBuffer.append("&src=");
                        stringBuffer.append(at.d(this.b.get(i2).d()));
                        arrayList.add(stringBuffer.toString());
                    }
                    i = i2 + 1;
                } else {
                    PostActivity postActivity = this.f1382a;
                    int i3 = this.c;
                    bmVar = this.f1382a.n;
                    ImageActivity.a(postActivity, arrayList, i3, bmVar);
                    return;
                }
            }
        } catch (Exception e) {
            av.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
