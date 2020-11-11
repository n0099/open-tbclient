package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.yuyinala.privatemessage.implugin.b.b;
/* loaded from: classes4.dex */
public class a extends b.a {
    public static boolean oxE = false;
    private Context mContext;
    private String mKey = "";
    private String mType;
    private g oxA;
    private long oxB;
    private int oxC;
    private boolean oxD;

    public a(Context context, long j, String str, int i, g gVar) {
        this.oxD = false;
        this.oxA = gVar;
        this.mContext = context;
        this.oxB = j;
        this.mType = str;
        this.oxC = i;
        if (i == 1) {
            this.oxD = false;
        } else {
            this.oxD = true;
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.b.b.a, java.lang.Runnable
    public void run() {
        k.gF(this.mContext).a(this.mType, this.oxB, this.oxD, new IIsSubscribedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.f.a.1
            @Override // com.baidu.android.imsdk.pubaccount.IIsSubscribedListener
            public void onIsSubscribedResult(int i, String str, long j, boolean z) {
                if (a.this.oxA != null) {
                    a.oxE = true;
                    a.this.oxA.d(i, str, j);
                }
            }
        });
    }
}
