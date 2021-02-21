package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.yuyinala.privatemessage.implugin.b.b;
/* loaded from: classes11.dex */
public class a extends b.a {
    public static boolean paL = false;
    private Context mContext;
    private String mKey = "";
    private String mType;
    private g paH;
    private long paI;
    private int paJ;
    private boolean paK;

    public a(Context context, long j, String str, int i, g gVar) {
        this.paK = false;
        this.paH = gVar;
        this.mContext = context;
        this.paI = j;
        this.mType = str;
        this.paJ = i;
        if (i == 1) {
            this.paK = false;
        } else {
            this.paK = true;
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.b.b.a, java.lang.Runnable
    public void run() {
        k.hC(this.mContext).a(this.mType, this.paI, this.paK, new IIsSubscribedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.f.a.1
            @Override // com.baidu.android.imsdk.pubaccount.IIsSubscribedListener
            public void onIsSubscribedResult(int i, String str, long j, boolean z) {
                if (a.this.paH != null) {
                    a.paL = true;
                    a.this.paH.d(i, str, j);
                }
            }
        });
    }
}
