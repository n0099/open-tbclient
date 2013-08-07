package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.model.bl;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.util.ai;
import com.baidu.tieba.util.aj;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1311a;
    private ArrayList b;
    private int c;

    public w(PostActivity postActivity, ArrayList arrayList, int i) {
        this.f1311a = postActivity;
        this.b = arrayList;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
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
                        stringBuffer.append(ai.d(((com.baidu.tieba.data.i) this.b.get(i2)).d()));
                        arrayList.add(stringBuffer.toString());
                    }
                    i = i2 + 1;
                } else {
                    PostActivity postActivity = this.f1311a;
                    int i3 = this.c;
                    blVar = this.f1311a.n;
                    ImageActivity.a(postActivity, arrayList, i3, blVar);
                    return;
                }
            }
        } catch (Exception e) {
            aj.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
