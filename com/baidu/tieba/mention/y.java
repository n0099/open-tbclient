package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.util.bm;
import com.baidu.tieba.util.bo;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ PostActivity a;
    private ArrayList<com.baidu.tieba.data.j> b;
    private int c;

    public y(PostActivity postActivity, ArrayList<com.baidu.tieba.data.j> arrayList, int i) {
        this.a = postActivity;
        this.b = arrayList;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bv bvVar;
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).a() == 3) {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    stringBuffer.append("size=");
                    stringBuffer.append(com.baidu.tieba.data.h.i());
                    stringBuffer.append("&src=");
                    stringBuffer.append(bm.d(this.b.get(i).e()));
                    arrayList.add(stringBuffer.toString());
                }
            }
            PostActivity postActivity = this.a;
            int i2 = this.c;
            bvVar = this.a.l;
            ImageActivity.a(postActivity, arrayList, i2, bvVar);
        } catch (Exception e) {
            bo.b("PbAdapter", "ImageOnClickListener", "error = " + e.getMessage());
        }
    }
}
