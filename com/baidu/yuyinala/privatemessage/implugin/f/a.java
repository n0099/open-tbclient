package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.yuyinala.privatemessage.implugin.b.b;
/* loaded from: classes4.dex */
public class a extends b.a {
    public static boolean ozi = false;
    private Context mContext;
    private String mKey = "";
    private String mType;
    private g oze;
    private long ozf;
    private int ozg;
    private boolean ozh;

    public a(Context context, long j, String str, int i, g gVar) {
        this.ozh = false;
        this.oze = gVar;
        this.mContext = context;
        this.ozf = j;
        this.mType = str;
        this.ozg = i;
        if (i == 1) {
            this.ozh = false;
        } else {
            this.ozh = true;
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.b.b.a, java.lang.Runnable
    public void run() {
        k.gD(this.mContext).a(this.mType, this.ozf, this.ozh, new IIsSubscribedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.f.a.1
            @Override // com.baidu.android.imsdk.pubaccount.IIsSubscribedListener
            public void onIsSubscribedResult(int i, String str, long j, boolean z) {
                if (a.this.oze != null) {
                    a.ozi = true;
                    a.this.oze.d(i, str, j);
                }
            }
        });
    }
}
