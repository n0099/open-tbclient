package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.yuyinala.privatemessage.implugin.b.b;
/* loaded from: classes10.dex */
public class a extends b.a {
    public static boolean pcR = false;
    private Context mContext;
    private String mKey = "";
    private String mType;
    private g pcN;
    private long pcO;
    private int pcP;
    private boolean pcQ;

    public a(Context context, long j, String str, int i, g gVar) {
        this.pcQ = false;
        this.pcN = gVar;
        this.mContext = context;
        this.pcO = j;
        this.mType = str;
        this.pcP = i;
        if (i == 1) {
            this.pcQ = false;
        } else {
            this.pcQ = true;
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.b.b.a, java.lang.Runnable
    public void run() {
        k.hB(this.mContext).a(this.mType, this.pcO, this.pcQ, new IIsSubscribedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.f.a.1
            @Override // com.baidu.android.imsdk.pubaccount.IIsSubscribedListener
            public void onIsSubscribedResult(int i, String str, long j, boolean z) {
                if (a.this.pcN != null) {
                    a.pcR = true;
                    a.this.pcN.d(i, str, j);
                }
            }
        });
    }
}
