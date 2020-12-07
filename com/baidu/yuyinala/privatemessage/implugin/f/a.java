package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.yuyinala.privatemessage.implugin.b.b;
/* loaded from: classes4.dex */
public class a extends b.a {
    public static boolean oOo = false;
    private Context mContext;
    private String mKey = "";
    private String mType;
    private g oOk;
    private long oOl;
    private int oOm;
    private boolean oOn;

    public a(Context context, long j, String str, int i, g gVar) {
        this.oOn = false;
        this.oOk = gVar;
        this.mContext = context;
        this.oOl = j;
        this.mType = str;
        this.oOm = i;
        if (i == 1) {
            this.oOn = false;
        } else {
            this.oOn = true;
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.b.b.a, java.lang.Runnable
    public void run() {
        k.hm(this.mContext).a(this.mType, this.oOl, this.oOn, new IIsSubscribedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.f.a.1
            @Override // com.baidu.android.imsdk.pubaccount.IIsSubscribedListener
            public void onIsSubscribedResult(int i, String str, long j, boolean z) {
                if (a.this.oOk != null) {
                    a.oOo = true;
                    a.this.oOk.d(i, str, j);
                }
            }
        });
    }
}
