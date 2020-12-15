package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.yuyinala.privatemessage.implugin.b.b;
/* loaded from: classes4.dex */
public class a extends b.a {
    public static boolean oOq = false;
    private Context mContext;
    private String mKey = "";
    private String mType;
    private g oOm;
    private long oOn;
    private int oOo;
    private boolean oOp;

    public a(Context context, long j, String str, int i, g gVar) {
        this.oOp = false;
        this.oOm = gVar;
        this.mContext = context;
        this.oOn = j;
        this.mType = str;
        this.oOo = i;
        if (i == 1) {
            this.oOp = false;
        } else {
            this.oOp = true;
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.b.b.a, java.lang.Runnable
    public void run() {
        k.hm(this.mContext).a(this.mType, this.oOn, this.oOp, new IIsSubscribedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.f.a.1
            @Override // com.baidu.android.imsdk.pubaccount.IIsSubscribedListener
            public void onIsSubscribedResult(int i, String str, long j, boolean z) {
                if (a.this.oOm != null) {
                    a.oOq = true;
                    a.this.oOm.d(i, str, j);
                }
            }
        });
    }
}
