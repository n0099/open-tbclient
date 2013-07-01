package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.model.bg;
import com.baidu.tieba.pb.ImageActivity;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1000a;
    private ArrayList b;
    private int c;

    public w(PostActivity postActivity, ArrayList arrayList, int i) {
        this.f1000a = postActivity;
        this.b = arrayList;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.b.size()) {
                    if (((com.baidu.tieba.data.i) this.b.get(i2)).a() == 3) {
                        StringBuffer stringBuffer = new StringBuffer(100);
                        stringBuffer.append("size=");
                        stringBuffer.append(com.baidu.tieba.data.g.h());
                        stringBuffer.append("&src=");
                        stringBuffer.append(com.baidu.tieba.util.y.d(((com.baidu.tieba.data.i) this.b.get(i2)).f()));
                        arrayList.add(stringBuffer.toString());
                    }
                    i = i2 + 1;
                } else {
                    PostActivity postActivity = this.f1000a;
                    int i3 = this.c;
                    bgVar = this.f1000a.n;
                    ImageActivity.a(postActivity, arrayList, i3, bgVar);
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
