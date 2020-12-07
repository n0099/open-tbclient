package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.yuyinala.privatemessage.implugin.b.b;
/* loaded from: classes4.dex */
public class d extends b.a {
    private Context mContext;
    private long mPaid;
    private g oOk;

    public d(Context context, long j, g gVar) {
        this.oOk = gVar;
        this.mContext = context;
        this.mPaid = j;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.b.b.a, java.lang.Runnable
    public void run() {
        k.hm(this.mContext).a(this.mPaid, new g() { // from class: com.baidu.yuyinala.privatemessage.implugin.f.d.1
            @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
            public void d(int i, String str, long j) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("GetSubScribeTask", i + "--" + str + "--" + j);
                if (i == 200 && d.this.oOk != null) {
                    d.this.oOk.d(i, str, j);
                }
            }
        });
    }
}
