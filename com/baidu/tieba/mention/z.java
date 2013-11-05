package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.model.bu;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1880a;
    private ArrayList<com.baidu.tieba.data.j> b;
    private int c;

    public z(PostActivity postActivity, ArrayList<com.baidu.tieba.data.j> arrayList, int i) {
        this.f1880a = postActivity;
        this.b = arrayList;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bu buVar;
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).a() == 3) {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    stringBuffer.append("size=");
                    stringBuffer.append(com.baidu.tieba.data.h.i());
                    stringBuffer.append("&src=");
                    stringBuffer.append(bc.d(this.b.get(i).d()));
                    arrayList.add(stringBuffer.toString());
                }
            }
            PostActivity postActivity = this.f1880a;
            int i2 = this.c;
            buVar = this.f1880a.n;
            ImageActivity.a(postActivity, arrayList, i2, buVar);
        } catch (Exception e) {
            be.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
